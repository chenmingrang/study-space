/**
 * 
 */
package co.chen.www;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @author 陈明让
 * @data 2017年3月19日
 */
public class AreaChartServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("image/png");
		JFreeChart localJFreeChart = ChartFactory.createStackedAreaChart(
				"Stacked Area Chart", "Category", "Value", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot localCategoryPlot = (CategoryPlot) localJFreeChart
				.getPlot();
		localCategoryPlot.setForegroundAlpha(0.85F);
		CategoryAxis localCategoryAxis = localCategoryPlot.getDomainAxis();
		localCategoryAxis.setLowerMargin(0.0D);
		localCategoryAxis.setUpperMargin(0.0D);
		localCategoryAxis.setCategoryMargin(0.0D);
		NumberAxis localNumberAxis = (NumberAxis) localCategoryPlot
				.getRangeAxis();
		localNumberAxis.setStandardTickUnits(NumberAxis
				.createIntegerTickUnits());
		CategoryItemRenderer localCategoryItemRenderer = localCategoryPlot
				.getRenderer();
		localCategoryItemRenderer.setBaseItemLabelsVisible(true);

		ChartUtilities.writeChartAsPNG(response.getOutputStream(),
				localJFreeChart, 600, 500);
	}

	private static CategoryDataset createDataset() {
		DefaultCategoryDataset localDefaultCategoryDataset = new DefaultCategoryDataset();
		localDefaultCategoryDataset.addValue(10D, "S1", "C1");
		localDefaultCategoryDataset.addValue(2.0D, "S1", "C2");
		localDefaultCategoryDataset.addValue(3.0D, "S1", "C3");
		localDefaultCategoryDataset.addValue(4.0D, "S1", "C4");
		localDefaultCategoryDataset.addValue(5.0D, "S1", "C5");
		localDefaultCategoryDataset.addValue(6.0D, "S1", "C6");
		localDefaultCategoryDataset.addValue(7.0D, "S1", "C7");
		localDefaultCategoryDataset.addValue(8.0D, "S1", "C8");
		localDefaultCategoryDataset.addValue(6.0D, "S2", "C1");
		localDefaultCategoryDataset.addValue(3.0D, "S2", "C2");
		localDefaultCategoryDataset.addValue(1D, "S2", "C3");
		localDefaultCategoryDataset.addValue(3.0D, "S2", "C4");
		localDefaultCategoryDataset.addValue(9.0D, "S2", "C5");
		localDefaultCategoryDataset.addValue(7.0D, "S2", "C6");
		localDefaultCategoryDataset.addValue(2.0D, "S2", "C7");
		localDefaultCategoryDataset.addValue(3.0D, "S2", "C8");
		localDefaultCategoryDataset.addValue(5.0D, "S3", "C1");
		localDefaultCategoryDataset.addValue(7.0D, "S3", "C2");
		localDefaultCategoryDataset.addValue(6.0D, "S3", "C3");
		localDefaultCategoryDataset.addValue(7.0D, "S3", "C4");
		localDefaultCategoryDataset.addValue(4.0D, "S3", "C5");
		localDefaultCategoryDataset.addValue(5.0D, "S3", "C6");
		localDefaultCategoryDataset.addValue(3.0D, "S3", "C7");
		localDefaultCategoryDataset.addValue(1.0D, "S3", "C8");
		return localDefaultCategoryDataset;
	}
}
