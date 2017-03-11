package prototype_pattern;

import java.util.ArrayList;

public class CloneObj2 implements Cloneable {
	private ArrayList<String> arrayList = new ArrayList<String>();

	@SuppressWarnings("unchecked")
	@Override
	public CloneObj2 clone() {
		CloneObj2 obj = null;
		try {
			obj = (CloneObj2) super.clone();
			obj.arrayList=(ArrayList<String>) this.arrayList.clone();
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
	
	//深克隆
	public static void main(String[] args) {
		CloneObj2 obj=new CloneObj2();
		obj.setValue("张三");
		CloneObj2 cloneObj=obj.clone();
		cloneObj.setValue("李四");
		System.out.println(obj.getValue());
	}
}
