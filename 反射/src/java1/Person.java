package java1;

/**
 * @author 9953
 * @date 2021/11/17 - 10:53
 */
@MyAnnotation()
public class Person extends Creature<String> implements Comparable<String>,MyInterface{
    private String name;
    int age;
    public int id;

    public Person(){}

    private Person(String name){
        this.name=name;
    }

    Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    private String show(String nation){
        System.out.println("我的国籍是"+nation);
        return nation;
    }

    public String display(String interests)throws NullPointerException,ClassCastException{
        return interests;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");

    }
    
    public static void showdesc(){
        System.out.println("我是一个可爱的人");
        
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
