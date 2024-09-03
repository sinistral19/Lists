import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class ArrListTest {

    @Test
    public void test_get() {
        ArrList<Integer> list=new ArrList<Integer>();
        list.add(1);
        list.add(7);
        list.add(2);
        list.add(5);
        list.add(7);
        list.add(3);
        Assert.assertEquals(6,list.size());
        Assert.assertEquals((Integer)1,list.get(0));
        Assert.assertEquals((Integer)2,list.get(2));
        Assert.assertEquals((Integer)3,list.get(5));
    }
    @Test
    public void test_addAll() {
        ArrList<Integer> list=new ArrList<Integer>();
        list.add(1);
        list.add(7);
        list.add(2);
        list.add(5);
        Assert.assertEquals(3,list.currPos);
        list.add(7);
        list.add(3);
        list.add(7);
        list.add(3);
        Assert.assertEquals(7,list.currPos);

        ArrayList<Integer> arrlist=new ArrayList<Integer>();
        arrlist.add(7);
        arrlist.add(5);
        arrlist.add(3);
        arrlist.add(4);
        arrlist.add(6);
        list.addAll(arrlist);
        Assert.assertEquals(12,list.currPos);
    }
    @Test
    public void test_remove() {
        ArrList<Integer> list=new ArrList<Integer>();
        ArrayList<Integer> arrlist=new ArrayList<Integer>();
        arrlist.add(7);
        arrlist.add(5);
        arrlist.add(3);
        arrlist.add(4);
        arrlist.add(6);
        list.addAll(arrlist);
        Assert.assertEquals(4,list.currPos);
        Assert.assertEquals(10,list.realSize);
        list.remove(3);
        Assert.assertEquals(3,list.currPos);
    }

    @Test
    public void test_add2() {
        ArrList<String> list=new ArrList<String>();
        ArrayList<String> arrlist=new ArrayList<String>();
        arrlist.add("A");
        arrlist.add("B");
        arrlist.add("C");
        arrlist.add("D");
        arrlist.add("E");
        list.addAll(arrlist);
        Assert.assertEquals(4,list.currPos);
        Assert.assertEquals(10,list.realSize);
        Assert.assertEquals("D",list.get(3));
        list.remove(3);
        Assert.assertEquals(3,list.currPos);
    }
    @Test
    public void test_resize() {
        ArrList<Integer> list=new ArrList<Integer>();
        list.add(1);
        list.add(7);
        list.add(2);
        list.add(5);
        Assert.assertEquals(5,list.realSize);
        list.add(7);
        list.add(3);
        list.add(7);
        list.add(3);
        Assert.assertEquals(10,list.realSize);

        ArrayList<Integer> arrlist=new ArrayList<Integer>();
        arrlist.add(7);
        arrlist.add(5);
        arrlist.add(3);
        arrlist.add(4);
        arrlist.add(6);
        list.addAll(arrlist);
        Assert.assertEquals(20,list.realSize);
    }
    @Test
    public void test_sort() {
        ArrList<Integer> list=new ArrList<Integer>();
        list.add(1);
        list.add(7);
        list.add(2);
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(7);
        list.add(3);
        list.sort();

        Assert.assertEquals("1 2 3 3 5 7 7 7 ",list.toString());

        ArrList<String> list2=new ArrList<String>();
        list2.add("A");
        list2.add("Z");
        list2.add("B");
        list2.add("G");
        list2.sort();

        Assert.assertEquals("A B G Z ",list2.toString());
    }
    @Test
    public void test_staticSort() {
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(7);
        list.add(2);
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(7);
        list.add(3);
        ArrList.staticSort(list);
        ArrayList<Integer> list2=new ArrayList<Integer>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(3);
        list2.add(5);
        list2.add(7);
        list2.add(7);
        list2.add(7);
        Assert.assertEquals(list2,list);
    }
    @Test
    public void test_addErr() {
        ArrList<Integer> list=new ArrList<Integer>();
        list.add(1);
       var errorMes= Assert.assertThrows(IndexOutOfBoundsException.class,()->list.get(15));
    Assert.assertEquals("i=15>size=1",errorMes.getMessage());
    }
}