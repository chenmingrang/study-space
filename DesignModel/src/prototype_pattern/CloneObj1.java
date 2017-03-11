package prototype_pattern;

import java.util.ArrayList;

public class CloneObj1 implements Cloneable {
	private ArrayList<String> arrayList = new ArrayList<String>();

	@Override
	public CloneObj1 clone() {
		CloneObj1 obj = null;
		try {
			obj = (CloneObj1) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public void setValue(String value){
		this.arrayList.add(value);
	}
	
	public ArrayList<String> getValue(){
		return arrayList;
	}
	
	//浅克隆
	public static void main(String[] args) {
		CloneObj1 obj=new CloneObj1();
		obj.setValue("张三");
		CloneObj1 cloneObj=obj.clone();
		cloneObj.setValue("李四");
		System.out.println(obj.getValue());
	}
}
