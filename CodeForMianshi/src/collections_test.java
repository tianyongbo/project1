import javax.print.attribute.standard.MediaPrintableArea;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author 9953
 * @date 2021/11/8 - 18:02
 */
public class collections_test {
    public static void main(String[] args) {

//        HashSet<String> hm=new HashSet<String>();
//        hm.add("hah");
//        hm.add("xixi");
//        hm.add("ca");
//        hm.add("en");
//
//        for (String str:hm) {
//            System.out.println(str);
//        }





/*       LinkedList ll=new LinkedList();
        
        ll.addFirst(12);
        ll.addFirst(13);
        ll.addFirst(112);
        ll.addFirst(213);





        for (Iterator it = ll.iterator(); it.hasNext();){
            System.out.println(it.next());
            
        }
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeFirst());
*/

//        int[] arr={45,21,78,67,34,58,4};
//        Arrays.sort(arr);
//        int a=Arrays.binarySearch(arr,34);
//        int[] arr1=Arrays.copyOf(arr,3);
//        printarr(arr);
//        System.out.println(a);
//        printarr(arr1);

        
        LinkedList list=  (new LinkedList());
        
        list.add("giao1");
        list.add("giao2");
        list.add("giao3");
        list.add("giao4");


        for (Object ll:list) {
            String str=(String)ll;
            System.out.println(str);
            
        }
    }

    public static void printarr(int[] arr) {
        for (int num:arr) {
            System.out.print(num+" ");

        }
        System.out.println();
    }
}



class giao implements Comparable{

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
