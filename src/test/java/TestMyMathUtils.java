import util.MyMathUtils;

public class TestMyMathUtils {
    public static void main(String[] args) {
        TestMyMathUtils myTest = new TestMyMathUtils();
        myTest.testequals();
        myTest.testreduce();;
        myTest.testcheckFinite();
    }

    public void testequals() {
        MyMathUtils temp = new MyMathUtils();
        double x = 1.2;
        double y = 2.4;
        boolean flg = temp.equals(x,y);
        if(flg==false){
            System.out.println("Pass!");
        }else {
            System.err.println("Error in equal()!");
        }
    }

    public void testreduce() {
        MyMathUtils temp = new MyMathUtils();
        double x = 1;
        double period = -1;
        double offset = 0;
        double flg =temp.reduce(x,period,offset);
        if(flg==2){
            System.out.println("Pass!");
        }else {
            System.err.println("Error in reduce()!");
        }
    }

    public void testcheckFinite() {
        MyMathUtils temp = new MyMathUtils();
        boolean error = false;
        double x = 1.414;
        try{
            temp.checkFinite(x);
        }catch (Exception e) {
            System.out.println("Error in checkFinite()!");
            error = true;
        }
        if(!error){
            System.out.println("Pass!");
        }

    }
}
