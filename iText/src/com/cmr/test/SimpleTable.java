package com.cmr.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class SimpleTable {
	public static final String DEST = "pdfTest/small_table.pdf";

	@Test
	public void test() throws Exception {
		Document document = new Document();
		OutputStream os = new FileOutputStream(new File("pdfTest/chinese.pdf"));
		PdfWriter.getInstance(document, os);
		document.open();
		// 方法一：使用Windows系统字体(TrueType)
		BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/simfang.TTF",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		// 方法二：使用iTextAsian.jar中的字体
		// BaseFont baseFont =
		// BaseFont.createFont("STSong-Light",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);

		// 方法三：使用资源字体(ClassPath)
		// //BaseFont baseFont =
		// BaseFont.createFont("/SIMYOU.TTF",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);

		Font font = new Font(baseFont);
		document.add(new Paragraph("解决中文问题了！", font));
		document.close();
	}

	public static void main(String[] args) throws IOException,
			DocumentException {
		File file = new File(DEST);
		file.getParentFile().mkdirs();
		new SimpleTable().createPdf(DEST);
	}

	public void createPdf(String dest) throws IOException, DocumentException {
		Rectangle small = new Rectangle(210, 297);
		BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/simfang.TTF",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		Font font = new Font(baseFont);
		Document document = new Document(small, 5.0f, 5.0f, 5.0f, 5.0f);
		PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(dest));
		document.open();
		PdfPTable table = new PdfPTable(30);
		table.setTotalWidth(new float[] { 160, 120 });
		table.setLockedWidth(true);
		PdfContentByte cb = writer.getDirectContent();
		// first row
		PdfPCell cell = new PdfPCell(new Phrase("我是中文"));
		cell.setFixedHeight(30);
		cell.setBorder(Rectangle.BOX);
		cell.setColspan(2);
		table.addCell(cell);
		// second row
		cell = new PdfPCell(new Phrase("Some more text", font));
		cell.setFixedHeight(30);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(Rectangle.BOX);
		table.addCell(cell);
		Barcode128 code128 = new Barcode128();
		code128.setCode("14785236987541");
		code128.setCodeType(Barcode128.CODE128);
		Image code128Image = code128.createImageWithBarcode(cb, null, null);
		cell = new PdfPCell(code128Image, true);
		cell.setBorder(Rectangle.BOX);
		cell.setFixedHeight(30);
		table.addCell(cell);
		// third row
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("and something else here", font));
		cell.setBorder(Rectangle.BOX);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(cell);
		document.add(table);
		document.close();
	}
	
	@Test
	public void test2(){
		// 模板路径
		String templatePath = "pdfTest/wjzModel.pdf";
		// 生成的新文件路径
		String newPDFPath = "pdfTest/newPdf.pdf";
		PdfReader reader;
		FileOutputStream out;
		ByteArrayOutputStream bos;
		PdfStamper stamper;
		try {
			out = new FileOutputStream(newPDFPath);// 输出流
			reader = new PdfReader(templatePath);// 读取pdf模板
			bos = new ByteArrayOutputStream();
			stamper = new PdfStamper(reader, bos);
			AcroFields form = stamper.getAcroFields();

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
			map.put("HWHFWMC_1","建筑服务1" );
			map.put("HWHFWMC_2","建筑服务2" );
			map.put("WCJYDD_1","河南光山" );
			map.put("WCJYDD_2","河南光山" );
			map.put("HTYXQX_1","2018-07-31" );
			map.put("HTYXQX_2","2018-07-31" );
			map.put("HTJE_1","3000.00" );
			map.put("HTJE_2","4000.00" );
			//特殊处理
			map.put("JBR", "张三");
			map.put("FZR", "李三");
			map.put("SWJGLXDH", "0371-99998888");
			java.util.Iterator<String> it = form.getFields().keySet().iterator();
			while (it.hasNext()) {
				String name = it.next().toString();
				System.out.println(name);
				if(map.get(name.toUpperCase())!=null &&!"".equals(map.get(name.toUpperCase()))){
					String oldStr = form.getField(name);
					if(oldStr!=null && !"".equals(oldStr)){
						form.setField(name, oldStr+map.get(name.toUpperCase()));
					}else{
						form.setField(name, map.get(name.toUpperCase()));
					}
				}
//				System.out.println("\""+name+"\"="+form.getField(name));
			}
			stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true
			stamper.close();
			Document doc = new Document();
			PdfCopy copy = new PdfCopy(doc, out);
			doc.open();
			PdfImportedPage importPage = copy.getImportedPage(
					new PdfReader(bos.toByteArray()), 1);
			PdfImportedPage importPage2 = copy.getImportedPage(
					new PdfReader(bos.toByteArray()), 2);
			copy.addPage(importPage);
			copy.addPage(importPage2);
			doc.close();

		} catch (IOException e) {
			System.out.println(1);
		} catch (DocumentException e) {
			System.out.println(2);
		}

	}
}
