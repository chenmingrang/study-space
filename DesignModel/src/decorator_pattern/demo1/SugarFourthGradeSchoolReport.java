package decorator_pattern.demo1;

public class SugarFourthGradeSchoolReport extends FourthGradeSchoolReport {
	private void reportHighScore() {
		System.out.println("这次考试的最高成绩：语文是75，数学是78，自然是80");
	}

	private void reportSort() {
		System.out.println("我排38名。。。");
	}

	@Override
	public void report() {
		this.reportHighScore();
		this.reportSort();
		super.report();
	}
}
