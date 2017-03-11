package task;

import java.util.ArrayList;
import java.util.List;

public class GetComputerByRandom {
	public static Computer getComputer(){
		List<Computer> list=new ArrayList<Computer>();
		list.add(new Computer("thinkPad", "intel"));
		list.add(new Computer("hp", "dell"));
		list.add(new Computer("lenove", "acer"));
		int x=(int) (Math.random()*3);
		return list.get(x);
	}

}
