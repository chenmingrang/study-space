/**
 * 
 */
package co.chen.www;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
import org.jfree.chart.renderer.RendererState;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.VerticalAlignment;

/**
 * @author 陈明让
 * @data 2017年3月19日
 */
public class LineChartServlet extends HttpServlet {

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
		JFreeChart chart = ChartFactory.createLineChart("图书销量榜", "月份", "销量", createDataset(),  PlotOrientation.VERTICAL, true, true, false);
		
		Font font = new Font("宋体", Font.ITALIC, 18);
		chart.getTitle().setFont(font);
		
		chart.getLegend(0).setWidth(600d);
		chart.getLegend(0).setVerticalAlignment(VerticalAlignment.TOP);
		chart.getLegend(0).setPosition(RectangleEdge.BOTTOM);
		
		TextTitle textTitle = new TextTitle("日期："+new Date());
		textTitle.setFont(new Font("黑体", Font.BOLD, 10));
		textTitle.setPosition(RectangleEdge.BOTTOM);
		textTitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		chart.addSubtitle(textTitle);
		
		chart.setBackgroundPaint(Color.white);
		
		CategoryPlot plot = chart.getCategoryPlot();
		
		plot.setBackgroundPaint(Color.lightGray);
		plot.setRangeGridlinesVisible(false);
		
		//设置坐标轴字体
		plot.getDomainAxis().setLabelFont(font);
		plot.getRangeAxis().setLabelFont(font);
		plot.getDomainAxis().setTickLabelFont(font);
		
		
		LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
		
		renderer.setBaseSeriesVisible(true);
		renderer.setDrawOutlines(true);
		renderer.setUseFillPaint(true);
		renderer.setBaseFillPaint(Color.white);
		
		//设置折线
		renderer.setSeriesStroke(0, new BasicStroke(3f));
		renderer.setSeriesOutlineStroke(0, new BasicStroke(2f));
		
		//设置拐点
		renderer.setSeriesShape(0, new java.awt.geom.Ellipse2D.Double(-30d,-30d,50d,50d));
		
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 900, 500);
	}

	private static CategoryDataset createDataset(){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Random random = new Random();
		for (int i = 1; i <=12; i++) {
			dataset.addValue(random.nextInt(10)+1, "Java", i+"月");
			dataset.addValue(random.nextInt(10)+1, "PHP", i+"月");
			dataset.addValue(random.nextInt(10)+1, "C/C++", i+"月");
		}
		return dataset;
	}
}
