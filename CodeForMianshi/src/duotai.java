import org.w3c.dom.NodeList;
/**
 * @author 9953
 * @date 2021/11/8 - 19:41
 */
public class duotai {
    public static void main(String[] args) {
//        Fu f=new Fu();
//        f.method();
        Fu z=new Zi();
        z.method();
    }
}

class Fu{
    public Fu() {

    }

    public void method(){
        System.out.println("Fu.....method");
    }

    public static void giao() {
        System.out.println("类静态方法");
    }
}

class Zi extends Fu{
    public Zi() {
        super();
    }

    @Override
    public void method() {
        System.out.println("Zi ....method");
        
    }
}

interface jumo{
    public void giao();
    public void laoba();
}

class jiekou implements jumo{
    @Override
    public void giao() {

    }

    @Override
    public void laoba() {

    }
}