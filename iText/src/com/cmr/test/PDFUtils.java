package com.cmr.test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @date 2017-3-1
 * @author *_* 陈明让 *_*
 */
public class PDFUtils {
	@Test
	public void test() throws Exception{
		String templatePath = "pdfTest/wjzModel.pdf";
		Map<String, String> map = new HashMap<String, String>();
		map.put("NSRMC", "陆振华");
		map.put("NSRSBH", "453888838333322");
		map.put("FDDBR", "陆振华");
		map.put("SFZJMC", "身份证");
		map.put("SFZJHM", "4111522199003034817");
		map.put("LXR", "陆振华");
		map.put("LXDH", "13099998888");
		map.put("WCJYDZ", "河南省信阳市光山县");
		map.put("WCJYDXZQHM", "450011");
		map.put("DJZCLX", "软件服务");
		map.put("JYFS", "自主营业");
		map.put("HTDFQYMC", "河南省百旺金赋有限公司");
		map.put("HTDFNSRSBH", "450011000099887");
		map.put("SWJGQZSJ", "2017 年 04 月 27 日");
		//外出经营活动情况
		map.put("HWHFWMC_1","建筑服务1");
		map.put("HWHFWMC_2","建筑服务2");
		map.put("WCJYDD_1","河南省郑州市金水区农业路\r与经一路交叉口189号");
		map.put("WCJYDD_2","河南光山" );
		map.put("HTYXQX_1","2018-07-31" );
		map.put("HTYXQX_2","2018-07-31" );
		map.put("HTJE_1","3000.00" );
		map.put("HTJE_2","4000.00" );
		map.put("JBR", "张三");
		map.put("FZR", "李三");
		map.put("SWJGLXDH", "0371-99998888");
		map.put("ZMYXRQ", "自 2016 年 10 月 31 日 起 至 2017 年 07 月 28 日 止");
		
		//生成图片并设置格式
		Image image = PDFUtils.getImage("pdfTest/timg.jpg", 130, 270, 60);
		byte[] bytes = PDFUtils.getPDFBytes(templatePath,"hello", map,image, 1);
		FileOutputStream fos = new FileOutputStream("pdfTest/testProtect.pdf");
		fos.write(bytes);
		fos.close();
	}
	
	/**
	 * @function  利用现有的pdf模板生成字节流
	 * @param templatePath  模板文件路径
	 * @param ownerPassword  为文档保护密码，如果为null的话会使用随机字符串
	 * @param resultMap    需要填写的数值
	 * @param image  需要插入的图片
	 * @param ImagePage 插入图片的页码(从1开始)
	 * @throws IOException 
	 */
	public static byte[] getPDFBytes(String templatePath,String ownerPassword,
			Map<String, String> resultMap, Image image, int ImagePage)
			throws Exception {
		PdfReader reader = new PdfReader(templatePath);// 读取pdf模板
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfStamper stamper = new PdfStamper(reader, baos);
		//设置保护
		if(ownerPassword==null)
			stamper.setEncryption(null, null,
					PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
		else
			stamper.setEncryption(null, ownerPassword.getBytes(),
					PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
		//将数据填入表格中
		AcroFields form = stamper.getAcroFields();
		Iterator<String> it = form.getFields().keySet().iterator();
		while (it.hasNext()) {
			String name = it.next().toString();
			// System.out.println(name);
			if (resultMap.get(name.toUpperCase()) != null && !"".equals(resultMap.get(name.toUpperCase()))) {
				String oldStr = form.getField(name);
				if (oldStr != null && !"".equals(oldStr)) {
					form.setField(name,oldStr + resultMap.get(name.toUpperCase()));
				} else {
					form.setField(name, resultMap.get(name.toUpperCase()));
				}
			}
		}
		
		// 设置图片
		PdfContentByte contentByte = stamper.getUnderContent(ImagePage);
		contentByte.addImage(image);
		// 如果为false那么生成的PDF文件还能编辑，一定要设为true
		stamper.setFormFlattening(true);
		stamper.close();
		reader.close();
		return baos.toByteArray();
	}
	
	/**
	 * @function  生成并设pdf图片比例及位置等参数
	 * @param path  模板图片的路径
	 * @param xPos  x坐标值(从左下角开始计算坐标)
	 * @param yPos  y坐标值
	 * @param percent  放缩的比例
	 * @return   返回图片对象
	 * @throws Exception
	 */
	public static Image getImage(String path,float xPos,float yPos,float percent) throws Exception{
//		Image image = Image.getInstance(path);
		URL url = new URL("http://img1.360buyimg.com/imgb/s250x250_jfs/t1654/354/1036705273/40317/3a7997f/55c1b8c1N1b307a65.jpg");
		Image image = Image.getInstance(url);
		image.setAlignment(Image.UNDERLYING);
        image.setAbsolutePosition(xPos,yPos);
        image.scalePercent(percent);
        return image;
	}
}
