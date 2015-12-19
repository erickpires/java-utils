import java.lang.reflect.InvocationTargetException;

/**
 * Created by erickpires on 19/12/15.
 */
public class Test {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {

        TestType test = new TestType(7);
        Callbacker<Integer> callbacker = new Callbacker<>(TestType.class, "anMethod", int.class);
        int a = callbacker.call(3);

        System.out.println("a: " + a);
    }

    static class TestType {
        int value;
        public TestType(int value) {
            this.value = value;
        }
        public int aMethod(Integer i) {
            System.out.println("Called");
            System.out.println("Value:" + value);
            System.out.println("i: " + i);

            return i;
        }
        public int aMethod() {
            System.out.println("Called");
            System.out.println("Value:" + value);

            return value;
        }

        public static int anMethod(int value) {
            System.out.println("I'm static");
            System.out.println("Value:" + value);

            return value;
        }
    }
}
