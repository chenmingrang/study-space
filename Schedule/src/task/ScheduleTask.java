package task;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component("scheduleTask")
public class ScheduleTask implements Serializable {
	private static final long serialVersionUID = 5113609235666081506L;
	private static long delay = 3L;
	private static long period = 5L;
	// @Resource(name="computer")
//	 private Computer computer=new Computer();
	private Computer computer;
	private int num = 1;

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	
//	@PostConstruct
	public void init() {
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
		ses.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println(num);
				num++;
				int x = (int) (Math.random() * 10);
				System.out.println(x);
				/*if (x % 2 == 1) {
					computer = new Computer("thinkPad", "intel");
					// computer.setName("thinkPad");
					// computer.setBoard("intel");
				}
				if (x % 2 == 0) {
					computer = new Computer("hp", "dell");
					// computer.setBoard("dell");
					// computer.setName("Mac");
				}*/
//				computer=GetComputerByRandom.getComputer();
				System.out.println("执行------->");
//				System.out.println("computer=[" + computer.getName() + ";"
//						+ computer.getBoard() + "]");
//				System.out.println(computer.hashCode());
				System.out.println(new Date() + "======>开始执行");
				throw new RuntimeException("over");
			}
		}, delay, period, TimeUnit.SECONDS);
		// ScheduledExecutorService ses2=Executors.newScheduledThreadPool(1);
		// ses2.scheduleAtFixedRate(new Runnable() {
		// @Override
		// public void run() {
		// computer=GetComputer.getComputer();
		// System.out.println("xxxx:"+computer.getName());
		// }
		// }, 1, 6, TimeUnit.SECONDS);
	}
}
