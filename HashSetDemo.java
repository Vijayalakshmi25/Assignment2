import java.lang.*;
import java.util.*;
import java.util.Iterator;

public class HashSetDemo {

    public static void main(String[] args) {

        String s1=new String("Akash");
        String s2=new String("Bhargav");
        MyOwnClass myClass=new MyOwnClass("Anil",20);
        MyOwnClass myClass1=new MyOwnClass("Ramya",14);
        Integer one=Integer.valueOf(12);
        Integer two= Integer.valueOf(12);
        Integer three=Integer.valueOf(70);

        Set hs = new HashSet();
        hs.add(s1);
        hs.add(s2);
        hs.add(myClass);
        hs.add(myClass1);
        hs.add(one);
        hs.add(two);
        hs.add(three);
        Iterator it=hs.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();

        Set hs1 = new LinkedHashSet();
        hs1.add(s1);
        hs1.add(s2);
        hs1.add(myClass);
        hs1.add(myClass1);
        hs1.add(one);
        hs1.add(two);
        hs1.add(three);
        Iterator it1=hs1.iterator();
        while(it1.hasNext()) {
            System.out.println(it1.next());
        }
        System.out.println();

        List l1=new ArrayList();
        l1.add(s1);
        l1.add(s2);
        l1.add(myClass);
        l1.add(myClass1);
        l1.add(one);
        l1.add(two);
        l1.add(three);
        Iterator it2=l1.iterator();
        while(it2.hasNext()) {
            System.out.println(it2.next());
        }
    }
}
