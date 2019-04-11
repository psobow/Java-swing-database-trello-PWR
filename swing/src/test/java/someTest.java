import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class someTest {

    class Foo {
        private int a;
        public Foo(int aa) {
            this.a = aa;
        }
    }

    @Test
    public void test(){

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.set(0, 10);

        System.out.println("Value of a = " + a + " Value of list.get(0) = " + list.get(0));
    }
}
