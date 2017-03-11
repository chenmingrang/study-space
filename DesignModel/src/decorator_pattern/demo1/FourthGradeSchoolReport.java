package decorator_pattern.demo1;

public class FourthGradeSchoolReport extends SchoolReport{

	@Override
	public void report() {
		System.out.println("尊敬的XXX家长：");
		System.out.println("   .............");
		System.out.println("  语文 62      数学65    体育98     自然63");
		System.out.println("   .............");
		System.out.println("                 家长签名：                 ");
	}

	@Override
	public void sign(String name) {
		System.out.println("家长签名为："+name);
	}

}
