import java.util.*;

/**
 * @author 9953
 * @date 2021/11/10 - 9:51
 */
public class 泛型 {
    public static void main(String[] args) {

        ArrayList<Person> al=new ArrayList<Person>();

        al.add(new Person("giao"));
        al.add(new Person("laoba"));
        al.add(new Person("guolaoshi"));
        al.add(new Person("youqu"));
        printcollection(al);

        System.out.println("===============================");
        
        ArrayList<Student> al2=new ArrayList<Student>();
        al2.add(new Student("liuxin"));
        al2.add(new Student("tianyongbo"));
        al2.add(new Student("yangchengcheng"));
        al2.add(new Student("yangbinhao"));
        printcollection(al2);
    }

    private static void printcollection(ArrayList<? extends Person> list) {
       for( Iterator<? extends Person> it=list.iterator();it.hasNext();){
           System.out.println(it.next());
       }
       
    }
}

class Person{
    private String name;
    public Person(String name) {
        this.name=name;
    }

    @Override
    public String toString() {
        return "name:"+this.name;
    }
}

class Student extends Person{
    public Student(String name){
        super(name);
    }


}