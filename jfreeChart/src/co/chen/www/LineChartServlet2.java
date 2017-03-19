/**
 * 
 */
package co.chen.www;

import java.awt.Font;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @author 陈明让
 * @data 2017年3月19日
 */
public class LineChartServlet2 extends HttpServlet {

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

		JFreeChart chart = ChartFactory.createXYLineChart(
				"2016年编程语言排行榜", "月份", "热度", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);
		
		Font font = new Font("宋体", Font.ITALIC, 18);
		
		chart.getTitle().setFont(font);
		chart.getLegend(0).setItemFont(font);
		
		XYPlot localXYPlot = (XYPlot) chart.getPlot();
		localXYPlot.setDomainPannable(true);
		localXYPlot.setRangePannable(true);
		
		localXYPlot.getDomainAxis().setLabelFont(font);
		localXYPlot.getRangeAxis().setLabelFont(font);
		
		XYLineAndShapeRenderer localXYLineAndShapeRenderer = (XYLineAndShapeRenderer) localXYPlot
				.getRenderer();
		localXYLineAndShapeRenderer.setBaseShapesVisible(true);
		localXYLineAndShapeRenderer.setBaseShapesFilled(true);
		
		NumberAxis localNumberAxis_x = (NumberAxis)localXYPlot.getDomainAxis();
		localNumberAxis_x.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		
		NumberAxis localNumberAxis = (NumberAxis) localXYPlot.getRangeAxis();
		localNumberAxis.setStandardTickUnits(NumberAxis
				.createIntegerTickUnits());
		
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 800,600);
	}

	
	private static XYDataset createDataset(){
		XYSeries localXYSeries1 = new XYSeries("Java语言");
	    localXYSeries1.add(1, 1.0D);
	    localXYSeries1.add(2, 4.0D);
	    localXYSeries1.add(3, 3.0D);
	    localXYSeries1.add(4, 5.0D);
	    localXYSeries1.add(5, 5.0D);
	    localXYSeries1.add(6, 7.0D);
	    localXYSeries1.add(7, 7.0D);
	    localXYSeries1.add(8, 8.0D);
	    XYSeries localXYSeries2 = new XYSeries("PHP");
	    localXYSeries2.add(1, 5.0D);
	    localXYSeries2.add(2, 7.0D);
	    localXYSeries2.add(3, 6.0D);
	    localXYSeries2.add(4, 8.0D);
	    localXYSeries2.add(5, 4.0D);
	    localXYSeries2.add(6, 4.0D);
	    localXYSeries2.add(7, 2.0D);
	    localXYSeries2.add(8, 1.0D);
	    XYSeries localXYSeries3 = new XYSeries("C/C++");
	    localXYSeries3.add(1, 4.0D);
	    localXYSeries3.add(2, 3.0D);
	    localXYSeries3.add(3, 2.0D);
	    localXYSeries3.add(4, 3.0D);
	    localXYSeries3.add(5, 6.0D);
	    localXYSeries3.add(6, 3.0D);
	    localXYSeries3.add(7, 4.0D);
	    localXYSeries3.add(8, 3.0D);
	    XYSeriesCollection localXYSeriesCollection = new XYSeriesCollection();
	    localXYSeriesCollection.addSeries(localXYSeries1);
	    localXYSeriesCollection.addSeries(localXYSeries2);
	    localXYSeriesCollection.addSeries(localXYSeries3);
	    return localXYSeriesCollection;
	}
}
