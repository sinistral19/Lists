import java.awt.List;
import java.awt.desktop.SystemSleepEvent;
import java.util.*;

public class ArrList<T extends  Comparable> extends AList<T>
{
    int realSize=5;
    int currPos=-1;
    T[] array;
    boolean hasSort=false;


    public ArrList() {
        array=(T[])new Comparable[realSize];
    }
    public ArrList(Collection<T> collection)
    {
        array=(T[])new Comparable[collection.size()];
        System.arraycopy(collection.toArray(),0,array,0,collection.size());
        currPos=realSize=collection.size();
        currPos--;
    }

    @Override
    public <T> T get(int i)
    {
        indexCheck(i);
        return (T)array[i];
    }

    @Override
    public void set(int i,T value)
    {  indexCheck(i);
        array[i]=value;
    }


    @Override
    public void add(T el) {


        currPos++;
        resizeList(currPos);
        array[currPos]=el;

        hasSort=false;

    }

    private void resizeList(int size) //увеличение размера массива
    {
        if(size>=realSize-1)
        {
        realSize=realSize*2;
        T[] newArray=(T[])new Comparable[realSize];
            System.arraycopy(array,0,newArray,0,array.length);
        array=newArray;
        }
    }

    @Override
    public void addAll(Collection<T> list)
    {
        resizeList(currPos+list.size());
        list.stream()
                .forEach(element->add(element));


    }
    public void addAll(ArrList<T> list)
    {
        resizeList(currPos+list.size());
        for(int i=0;i<list.size();i++)
        {
            add(list.get(i));
        }


    }

    @Override
    public void remove(int i)
    {   indexCheck(i);

        hasSort=false;
        T[] arrayNew=array;
        System.arraycopy(arrayNew,i+1,array,i, currPos-i-1);
        array[currPos-1]=null;
        currPos--;

    }

    @Override
    public void sort() {

        if(hasSort)
        {
            return;
        }
            while(!hasSort)
            {
                hasSort=true;
                for (int i=0;i<=currPos-1;i++)
                {
                   
                    if(array[i].compareTo(array[i+1])>=1)
                    {
                        hasSort=false;
                        T temp=array[i];
                    array[i]=array[i+1];
                    array[i+1]=temp;

                    }
                }
            }



    }
    @Override
    public String toString()
    {
        String s="";
        s+="";
        for (int i=0;i<=currPos;i++)
        {
            s+=array[i].toString()+" ";

        }

        return s;
    }
    public static <T extends Comparable> void staticSort(Collection<T> list)
    {
        int n=list.size();
        ArrList<T> arr=new ArrList<T>(list);

        for(int i=0;i<n;i++)
        {
            int minInd=i;
            for(int j=i+1;j<n;j++)
            {


                if(arr.array[j].compareTo(arr.get(minInd))<=-1)
                {
                    minInd=j;
                }
            }
            if(minInd!=i)
            {
                T tmp=arr.get(minInd);
                arr.set(minInd,arr.get(i));
                arr.set(i,tmp);
            }
        }
        list.clear();
        for(int i=0;i<n;i++)
        {
           list.add(arr.get(i));
        }

    }

    public void indexCheck(int i)
    {
        if(i>currPos)
            throw new IndexOutOfBoundsException("i="+i+">size="+(currPos+1));
        if(i<0)
            throw new IndexOutOfBoundsException("i="+i+"<0");
    }

    public int size()
    {return currPos+1;

    }
    


}
