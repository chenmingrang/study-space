package upload;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UploadsAction extends ActionSupport {

	private File [] uploadImages;
	
	private String [] uploadImagesContentType;
	
	private String [] uploadImagesFileName;
	
	public String saveFiles(){
		System.out.println("UploadsAction ******** saveFiles()");
		
		ServletContext sc = ServletActionContext.getServletContext();
		
		String path = sc.getRealPath("/fileupload");
		
		for(int i=0;i<uploadImages.length;i++){
			File file = new File(path, uploadImagesFileName[i]);
			
			try {
				FileUtils.copyFile(uploadImages[i], file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			uploadImages[i].delete();
			
		}
		
		return "success";
	}

	public File[] getUploadImages() {
		return uploadImages;
	}

	public void setUploadImages(File[] uploadImages) {
		this.uploadImages = uploadImages;
	}

	public String[] getUploadImagesContentType() {
		return uploadImagesContentType;
	}

	public void setUploadImagesContentType(String[] uploadImagesContentType) {
		this.uploadImagesContentType = uploadImagesContentType;
	}

	public String[] getUploadImagesFileName() {
		return uploadImagesFileName;
	}

	public void setUploadImagesFileName(String[] uploadImagesFileName) {
		this.uploadImagesFileName = uploadImagesFileName;
	}
	
}
