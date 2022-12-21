package parameterized.exception;

import org.testng.annotations.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ExceptionTest {

    @Test
    public void testPulsarExceptionWithParameters() {

        String key = "123";
        String value = "abc";

        SampleException testException =
                new SampleException("key={}, value={}", key, value);
        assertThat(testException.getMessage()).isEqualTo("key=123, value=abc");
    }

    @Test
    public void testPulsarExceptionSimple() {

        SampleException testException =
                new SampleException("Simple Message");
        assertThat(testException.getMessage()).isEqualTo("Simple Message");
    }

    @Test
    public void testPulsarExceptionCompound() {

        int key = 123;
        String value = "abc";

        SampleException testException =
                new SampleException("key={}, value={}", key, value, new Exception("inner exception"));

        assertThat(testException.getMessage()).contains("key=123, value=abc");
        assertThat(testException.getCause().getMessage()).isEqualTo("inner exception");
    }
}
