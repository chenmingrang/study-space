/**
 * 
 */
package co.chen.www;

import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author 陈明让
 * @data 2017年3月17日
 */
public class BarChartServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("image/png");
		JFreeChart chart = ChartFactory.createBarChart3D("畅销书排行榜", "按季度", "销量", createDataset(), 
				     PlotOrientation.VERTICAL, true, true, false);
		Font font = new Font("宋体", Font.ITALIC, 18);
		
		TextTitle title = new TextTitle("编程语言排行榜", font);
		
		LegendTitle lTitle = chart.getLegend(0);
		//下标题字体设置
		lTitle.setItemFont(font);
		
		chart.setTitle(title);
		//获得图表区域对象
		CategoryPlot plot = chart.getCategoryPlot();
		
		//设置网格线可见
		plot.setDomainGridlinesVisible(true);
		//y轴
		plot.getRangeAxis().setLabelFont(font);
		//获得x轴
		CategoryAxis axis = plot.getDomainAxis();
		//设置x轴显示的分类名称的显示位置，如果不设置则水平显示，设置后，可以斜像显示，分类角度、图表空间有限时，建议采用
		axis.setLabel("xxx轴");
		axis.setLabelFont(font);
		axis.setTickLabelFont(new Font("宋体", Font.BOLD, 20));
		axis.setCategoryMargin(0.0d);
		axis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.3926990d));
		//获取显示图形对象
		BarRenderer3D barRenderer3D = (BarRenderer3D) plot.getRenderer();
		barRenderer3D.setDrawBarOutline(false);
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 600, 500);
	}

	private static CategoryDataset createDataset(){
		String[] category1 = {"第一季度","第二季度","第三季度","第四季度"};//维度
		String[] category2 = {"Java","C/C++","Python","Sclar"};
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=0;i<category1.length;i++){
			String category = category1[i];
			for(int j=0;j<category2.length;j++){
				String cat = category2[j];
				//模拟添加数据
				dataset.addValue(new Random().nextDouble()*100, category, cat);
			}
		}
		return dataset;
	}
}
