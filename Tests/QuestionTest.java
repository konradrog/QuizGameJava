import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTest {

    private String[][] answers = new String[][]{
            {"0", "Odpowiedz 1"},
            {"0", "Odpowiedz 2"},
            {"0", "Odpowiedz 3"},
            {"1", "Odpowiedz 4"},

    };
    private Question question = new Question("Pytanie", answers);

    @Test
    public void getText() throws Exception {
        assertEquals("Pytanie", question.getText());
    }
    @Test
    public void setCorrectAnswer() throws Exception {
        assertEquals(3, question.setCorrAns(answers));
    }

    @Test
    public void getCorrectAnswer() throws Exception {
        assertEquals(3, question.getCorrAns());
    }



}