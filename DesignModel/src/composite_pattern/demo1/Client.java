package composite_pattern.demo1;

import java.util.ArrayList;

/**
 * Created by cmr on 2017/12/19.
 */
public class Client {

    public static void main(String[] args) {
        Branch ceo = compositeCorpTree();
        System.out.println(ceo.getInfo() + "\n");
        System.out.println(getTreeInfo(ceo));
    }

    public static String getTreeInfo(Branch root){
        ArrayList<Corp> subordinateList = root.getSubordinate();
        String info = "";
        for (Corp corp: subordinateList) {
            if(corp instanceof Leaf){
                info = info + corp.getInfo() + "\n";
            }else {
                info = info + corp.getInfo() + "\n" + getTreeInfo((Branch) corp);
            }
        }
        return info;
    }

    public static Branch compositeCorpTree(){
        Branch root = new Branch("Micheal", "boss", 100000);

        Branch devDep = new Branch("Gorge", "develop manager", 8000);
        Branch salesDev = new Branch("Green", "sales manager", 7000);
        Branch financeDep = new Branch("Tom", "finance manager", 7000);

        Branch firstDevGroup = new Branch("Joe", "first team leader", 6000);
        Branch secondDevGroup = new Branch("Tim", "second team leader", 6000);

        Leaf a = new Leaf("a", "developer", 7000);
        Leaf b = new Leaf("b", "developer", 7000);
        Leaf c = new Leaf("c", "developer", 7000);
        Leaf d = new Leaf("d", "developer", 7000);
        Leaf e = new Leaf("e", "developer", 7000);

        Leaf f = new Leaf("f", "salesman", 5000);
        Leaf g = new Leaf("g", "salesman", 5000);

        Leaf h = new Leaf("h", "financial staff", 4000);

        root.addSubordinate(devDep);
        root.addSubordinate(salesDev);
        root.addSubordinate(financeDep);

        devDep.addSubordinate(firstDevGroup);
        devDep.addSubordinate(secondDevGroup);

        firstDevGroup.addSubordinate(a);
        firstDevGroup.addSubordinate(b);
        firstDevGroup.addSubordinate(c);

        secondDevGroup.addSubordinate(d);
        secondDevGroup.addSubordinate(e);

        salesDev.addSubordinate(f);
        salesDev.addSubordinate(g);

        financeDep.addSubordinate(h);

        return root;
    }
}
