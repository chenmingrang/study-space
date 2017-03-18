/**
 * 
 */
package co.chen.www;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.GroupLayout.Alignment;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLabelLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.VerticalAlignment;

/**
 * @author 陈明让
 * @data 2017年3月18日
 */
public class BarChartServlet3 extends HttpServlet {

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
//		JFreeChart chart = ChartFactory.createXYBarChart("图书销量", "x标签", true, "y标签", createDataset());
		JFreeChart chart = ChartFactory.createXYBarChart("图书销量", "月份", false, "销量", createDataset(),
				PlotOrientation.VERTICAL, true, false, false);
		chart.setBackgroundPaint(Color.white);
		
		XYPlot xyPlot = chart.getXYPlot();
		xyPlot.setBackgroundPaint(Color.LIGHT_GRAY);
		xyPlot.setDomainGridlinePaint(Color.white);
		xyPlot.setRangeGridlinePaint(Color.white);
		
		XYBarRenderer renderer = (XYBarRenderer) xyPlot.getRenderer();
		renderer.setDrawBarOutline(false);
		
		Font font = new Font("SansSerif", 10, 20);
		chart.getTitle().setFont(font);
		
		chart.getLegend(0).setVerticalAlignment(VerticalAlignment.TOP);
		chart.getLegend(0).setPosition(RectangleEdge.RIGHT);//设置legend的位置
		
		chart.getLegend().setItemFont(font);
		
		xyPlot.getDomainAxis().setLabelFont(font);
		xyPlot.getDomainAxis().setLabelLocation(AxisLabelLocation.HIGH_END);
		
		
		xyPlot.getRangeAxis().setLabelFont(font);
		xyPlot.getRangeAxis().setLabelLocation(AxisLabelLocation.HIGH_END);
		
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 600, 500);
	}
    
	private static IntervalXYDataset createDataset(){
		XYSeries xySeries1 = new XYSeries("Java");
		XYSeries xySeries2 = new XYSeries("PHP");
		XYSeries xySeries3 = new XYSeries("C/C++");
		Random random = new Random();
		for (int i = 1; i < 13; i++) {
			//添加数据
//			xySeries1.add(i,random.nextInt(100));
//			xySeries2.add(i,random.nextInt(100));
			xySeries1.add(i,i);
			xySeries2.add(i,i+1);//累计值
			xySeries3.add(i,i+1+1);//累计值
		}
		XYSeriesCollection collection = new XYSeriesCollection();
		collection.addSeries(xySeries1);
		collection.addSeries(xySeries2);
		collection.addSeries(xySeries3);
		return new XYBarDataset(collection, 0.900000000000002D);
	}
}
