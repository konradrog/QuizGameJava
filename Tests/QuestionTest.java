import org.junit.After;
import org.junit.Before;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class QuestionTest extends junit.framework.TestCase {
    int corrAns = 0;
    ArrayList<Answer> answers;
    Question question;

    public QuestionTest() {}

    protected void setUp() {
        Answer answer1 = new Answer();
        Answer answer2 = new Answer();
        Answer answer3 = new Answer();
        Answer answer4 = new Answer();

        answer1.setText("Pytanie");
        answer1.setValue("0");

        answer2.setText("Pytanie");
        answer2.setValue("0");

        answer3.setText("Pytanie");
        answer3.setValue("0");

        answer4.setText("Pytanie");
        answer4.setValue("1");

        answers = new ArrayList<Answer>();

        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);

        question = new Question("Pytanie", answers);
    }

    protected void tearDown() {
        answers.clear();
    }


    public void testGetText() throws Exception {
        assertEquals("Pytanie", question.getText());
    }


    public void testSetCorrectAnswer() throws Exception {
        assertEquals(3, question.setCorrAns(answers));
    }


    public void testGetCorrectAnswer() throws Exception {
        assertEquals(3, question.getCorrAns());
    }



}