import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
/* wczytywanie plik, i sprawdzanie pliku. zapis do .jar*, drugie konto do repo*/
public class QuestionTest {
    private Answer answer1;
    {
        answer1 = new Answer();
        answer1.setText("Pytanie");
        answer1.setValue("0");
    }
    private Answer answer2;
    {
        answer2 = new Answer();
        answer2.setText("Pytanie");
        answer2.setValue("0");
    }
    private Answer answer3;
    {
        answer3 = new Answer();

        answer3.setText("Pytanie");
        answer3.setValue("0");
    }
    private Answer answer4;
    {
        answer4 = new Answer();
        answer4.setText("Pytanie");
        answer4.setValue("1");
    }

    ArrayList<Answer> answers = new ArrayList<Answer>();
    {
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);
    };

    int corrAns = 0;

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