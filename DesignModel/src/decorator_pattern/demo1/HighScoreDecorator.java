package decorator_pattern.demo1;

public class HighScoreDecorator extends Decorator {
	public HighScoreDecorator(SchoolReport sr) {
		super(sr);
	}
	
	private void reportHighScore(){
		System.out.println("这次考试的最高成绩：语文是75，数学是78，自然是80");
	}
	
	@Override
	public void report(){
		this.reportHighScore();
		super.report();
	}
}
