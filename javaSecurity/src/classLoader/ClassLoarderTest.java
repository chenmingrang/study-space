/**
 * 
 */
package classLoader;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author 陈明让
 * @data 2017年3月12日
 */
public class ClassLoarderTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new ClassLoarderFrame();
				frame.setTitle("ClassLoaderTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ClassLoarderFrame extends JFrame {
	private JTextField keyField = new JTextField("3", 4);
	private JTextField nameField = new JTextField("Calculator", 30);
	private static final int DEFUALT_WIDTH = 300;
	private static final int DEFUALT_HEIGHT = 200;

	public ClassLoarderFrame() {
		setSize(DEFUALT_WIDTH, DEFUALT_HEIGHT);
		setLayout(new GridBagLayout());
		add(new JLabel("Class"), new GBC(0, 0).setAnchor(GBC.EAST));
		add(nameField, new GBC(1, 0).setAnchor(GBC.WEST).setWeight(100, 0));
		add(new JLabel("Key"), new GBC(0, 0).setAnchor(GBC.EAST));
		add(keyField, new GBC(1, 1).setAnchor(GBC.WEST).setWeight(100, 0));
		JButton loadButton = new JButton("Load");
		loadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				runClass(nameField.getText(), keyField.getText());
			}
		});
	}

	public void runClass(String name, String key) {
		try {
			ClassLoader loader = new CryptoClassLoader(Integer.parseInt(key));
			Class<?> c = loader.loadClass(name);
			Method m = c.getMethod("main", String[].class);
			m.invoke(null, (Object) new String[] {});
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e);
		}
	}
}

class CryptoClassLoader extends ClassLoader {
	private int key;

	public CryptoClassLoader(int key) {
		this.key = key;
	}

	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] classByte = null;
			classByte = loadClassByte(name);
			Class<?> cl = defineClass(name, classByte, 0, classByte.length);
			if (cl == null)
				throw new ClassNotFoundException(name);
			return cl;
		} catch (Exception e) {
			throw new ClassNotFoundException(name);
		}
	}

	private byte[] loadClassByte(String name) throws IOException {
		String cname = name.replace(".", "/") + "caeser";
		FileInputStream fis = new FileInputStream(cname);
		byte[] bytes = new byte[fis.available()];
		fis.read(bytes);
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) (bytes[i] - key);
		}
		fis.close();
		return bytes;
	}
}