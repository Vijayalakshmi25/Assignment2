import java.util.Iterator;
import java.util.*;
public class PractisePblms {
    public static void main(String[] args) {

        // Create HashSet object
        HashSet hs = new HashSet(5, 0.5f);
        System.out.println(hs.add("one"));
        System.out.println(hs.add("two"));
        System.out.println(hs.add("three"));
        System.out.println(hs.add("four"));
        System.out.println(hs.add("five"));
        Iterator it=hs.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        Boolean b = hs.add("one");
        System.out.println("Duplicate item allowed = " + b);
        Iterator it1=hs.iterator();
        while(it1.hasNext()) {
            System.out.println(it1.next());
        }
        // Set up test data
        String name[] = {
                new String("Sang"),
                new String("Shin"),
                new String("Boston"),
                new String("Shin")
        };

        // Create HashSet object instance and
        // assign it to a variable of Set type.
        Set s = new HashSet();
        for (int i=0; i<name.length; i++)
            if (!s.add(name[i]))
                System.out.println("Duplicate detected: "+name[i]);

        System.out.println(s.size()+" distinct words detected: "+s);
    }

}
