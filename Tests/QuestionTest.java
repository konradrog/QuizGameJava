import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTest {
    @Test
    public void getText() throws Exception {
        String[][] answers = new String[][]{
                {"0", "Odpowiedz 1"},
                {"0", "Odpowiedz 2"},
                {"0", "Odpowiedz 3"},
                {"1", "Odpowiedz 4"},

        };
        Question question = new Question("Pytanie", answers);
        assertEquals("Pytanie", question.getText());
    }

}