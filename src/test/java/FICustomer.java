import org.junit.Test;

public class FICustomer {

    @Test
    public void test_me()
    {
        SampleFunctionInterface<String> fi =
                System.out::println;

        fi.doSomething("sourav");
        fi.doSomething("sourav2");
    }
}
