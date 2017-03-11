package decorator_pattern.demo1;

public abstract class Decorator extends SchoolReport {
	private SchoolReport sr;

	public Decorator(SchoolReport _sc) {
		this.sr = _sc;
	}

	public void report() {
		this.sr.report();
	}

	public void sign(String name) {
		this.sr.sign(name);
	}
}
