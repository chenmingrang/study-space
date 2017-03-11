package task;

import java.io.Serializable;

public class Computer implements Serializable {

	private static final long serialVersionUID = 8786236684928663846L;
	private String board;
	private String name;
	
	public Computer() {
		super();
	}

	public Computer(String board, String name) {
		super();
		this.board = board;
		this.name = name;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Computer [board=" + board + ", name=" + name + "]";
	}
}
