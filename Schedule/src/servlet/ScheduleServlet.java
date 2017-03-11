package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 5400159083459551562L;
	private ScheduledExecutorService ses1=Executors.newScheduledThreadPool(1);
	private ScheduledExecutorService ses2=Executors.newScheduledThreadPool(1);
	private ScheduledExecutorService ses3=Executors.newScheduledThreadPool(1);

	@Override
	public void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		final Runnable rn=new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println(sdf.format(new Date())+"yyyyyy");
				} catch (Exception e) {
					ses1.shutdown();
				}
			}
		};
		ses1.scheduleAtFixedRate(rn, 0, 3, TimeUnit.SECONDS);
		ses2.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				ses1.shutdown();
			}
		}, 7, 10000, TimeUnit.SECONDS);
		ses3.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				if(ses1.isShutdown()){
					ses1=Executors.newScheduledThreadPool(1);
					ses1.scheduleAtFixedRate(rn, 5, 5, TimeUnit.SECONDS);
				}
			}
		}, 0, 1, TimeUnit.SECONDS);
	}
}
