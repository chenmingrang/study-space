package serialClone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerailCloneable implements Cloneable,Serializable{
	private static final long serialVersionUID = -2464948518737904492L;

	@Override
	public Object clone(){
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
			oos.close();
			
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			Object ret = ois.readObject();
			ois.close();
			return ret;
		} catch (Exception e) {
			return null;
		}
	}
}
