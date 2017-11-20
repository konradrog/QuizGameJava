import org.junit.Test;
import static org.junit.Assert.*;

public class AnswerTest {

    private Answer answer = new Answer();

    @Test
    public void setValue() throws Exception {
        answer.setValue("0");
        assertEquals("0", answer.value);
    }

    @Test
    public void setText() throws Exception {
        answer.setText("Pytanie");
        assertEquals("Pytanie", answer.text);
    }
}
