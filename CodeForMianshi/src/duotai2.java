/**
 * @author 9953
 * @date 2021/11/9 - 22:03
 */
public class duotai2 {
    public static void main(String[] args) {
        wine e=new jnc();
        e.method();
    }
}

class wine{
    public wine() {
    }

    public void method() {
        System.out.println("Fu======method");

    }
}

class jnc extends wine{
    public jnc() {
        super();
    }

    public void method(){
        System.out.println("Zi=====method");
        fun1();
    }

    public void fun1() {
        System.out.println("zi======fun1");

    }
}
