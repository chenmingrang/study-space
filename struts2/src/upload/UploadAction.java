package upload;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UploadAction extends ActionSupport {
	
	/*
	 * 上传文件的存储的临时文件：
	 * E:\\TOOLS\\apache-tomcat-6.0.35\\work\\Catalina\\localhost\\itcast1105_struts\\upload__5fee1dc7_13ad3d1835b__8000_00000000.tmp
	 */
	private File upload;
	
	//上传文件的类型：text/plain
	private String uploadContentType;
	
	//上传文件的真是名称
	private String uploadFileName;
	

	public File getUpload() {
		return upload;
	}


	public void setUpload(File upload) {
		this.upload = upload;
	}


	public String getUploadContentType() {
		return uploadContentType;
	}


	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}


	public String getUploadFileName() {
		return uploadFileName;
	}


	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}


	public String saveFile(){
		System.out.println("UploadAction *********** saveFile()");
		
		ServletContext sc = ServletActionContext.getServletContext();
		
		String path = sc.getRealPath("/upload/fileupload");
		
		File file = new File(path, uploadFileName);
		
		try {
			
			FileUtils.copyFile(upload, file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		upload.delete();
		
		return "success";
	}
	
}
