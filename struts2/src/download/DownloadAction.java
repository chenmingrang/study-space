package download;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	private static final long serialVersionUID = 9216246988113743624L;

	private InputStream inputStream;
	private String fileName;
	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String downloadFile() {
		try {
			inputStream=new FileInputStream("d:/testXm11.xls");
			fileName="测试.xls";
			return "success";
		} catch (FileNotFoundException e) {
			msg="erro";
			return "error";
		}
	}

}
