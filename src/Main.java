import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrlist=new ArrayList<Integer>();
        arrlist.add(7);
        arrlist.add(5);
        arrlist.add(3);
        arrlist.add(4);
        arrlist.add(6);

        arrlist.add(9);
        arrlist.add(11);
        arrlist.add(17);
        arrlist.add(22);
        arrlist.add(1);

        //ArrList <Integer> list=new ArrList<Integer>();


        ArrList<Integer> list=new ArrList<Integer>(arrlist);
        list.sort();
        /*list.add(5);
        list.add(1);
        list.add(7);
        list.add(2);
        list.add(10);*/
System.out.println(list);

    }
    }
