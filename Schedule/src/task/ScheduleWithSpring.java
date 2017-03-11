package task;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class ScheduleWithSpring implements InitializingBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("xxxxx");
		ScheduledExecutorService ses=Executors.newScheduledThreadPool(1);
		ses.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println(new Date()+"==>xxxx");
			}
		}, 3, 5, TimeUnit.SECONDS);
	}
}
