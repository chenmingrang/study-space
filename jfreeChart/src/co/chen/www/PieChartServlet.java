package co.chen.www;

import java.awt.Font;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class PieChartServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PieChartServlet() {
		super();
	}

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
		this.doPost(request, response);
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
		
		JFreeChart chart = ChartFactory.createPieChart3D("编程语言排行榜", createPieDataset(), true, true, false);
		Font font = new Font("宋体", Font.ITALIC, 18);
		LegendTitle lTitle = chart.getLegend(0);
		//下标题字体设置
		lTitle.setItemFont(font);
		chart.setBorderVisible(true);
		//上标题字体设置
		TextTitle title = new TextTitle("编程语言排行榜", font);
		chart.setTitle(title);
		PiePlot plot = (PiePlot) chart.getPlot();
		//图片上的字体设置
		plot.setLabelFont(font);
		plot.setNoDataMessage("暂无数据");
		plot.setCircular(false);
		plot.setLabelGap(0.02d);
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 500, 300);
	}

	public static PieDataset createPieDataset(){
		DefaultPieDataset dataset = new DefaultPieDataset();
		Random random =new Random();
		dataset.setValue("JAVA编程",  random.nextDouble()*100);
		dataset.setValue("C/C++",  random.nextDouble()*100);
		dataset.setValue("PHP",  random.nextDouble()*100);
		dataset.setValue("JavaScript",  random.nextDouble()*100);
		dataset.setValue("Ajax",  random.nextDouble()*100);
		return dataset;
	}
}
