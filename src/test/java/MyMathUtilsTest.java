import util.MyMathUtils;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MyMathUtilsTest {

    @org.junit.Test
    public void testEquals() {
        MyMathUtils temp = new MyMathUtils();
        double x = 1.2;
        double y = 2.4;
        boolean flg = temp.equals(x,y);
        assertEquals(false,flg);
    }

    @org.junit.Test
    public void reduce() {
        MyMathUtils temp = new MyMathUtils();
        double x = 1;
        double period = -1;
        double offset = 0;
        double flg =temp.reduce(x,period,offset);
        System.out.println(flg);
        assertEquals(2,flg,0.0);
    }

    @org.junit.Test
    public void checkFinite() {
        MyMathUtils temp = new MyMathUtils();
        double x = 1.414;
        try{
            temp.checkFinite(x);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            assert false;
        }
        }
}