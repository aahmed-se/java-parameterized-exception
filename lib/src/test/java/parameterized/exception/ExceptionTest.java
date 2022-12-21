package parameterized.exception;

import org.testng.annotations.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ExceptionTest {

    @Test
    public void testExceptionWithParameters() {

        String key = "123";
        String value = "abc";

        SampleException testException =
                new SampleException("key={}, value={}", key, value);
        assertThat(testException.getMessage()).isEqualTo("key=123, value=abc");
    }

    @Test
    public void testExceptionSimple() {

        SampleException testException =
                new SampleException("Simple Message");
        assertThat(testException.getMessage()).isEqualTo("Simple Message");
    }

    @Test
    public void testExceptionCompound() {

        int key = 123;
        String value = "abc";

        SampleException testException =
                new SampleException("key={}, value={}", key, value, new Exception("inner exception"));

        assertThat(testException.getMessage()).contains("key=123, value=abc");
        assertThat(testException.getCause().getMessage()).isEqualTo("inner exception");
    }
}
