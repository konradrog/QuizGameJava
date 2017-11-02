import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/* pomyślec nad zmianą formatu pliku textowego, testy, osobna klasa do odpowiedzi, poprawić dokumentacje*/
public class Question {
    String text;
    String[][] answers;
    int corrAns;

    public Question(String text, String[][] answers) {
        this.text = text;
        this.answers = answers;
        this.setCorrAns();
    }

    public String getText() {

        return text;
    }

    public void setCorrAns() {

        for (int i=0; i < 4; i++) {

            if (answers[i][0] == "1")
            {
                this.corrAns = i;
            }

        }

    }

    public int getCorrAns() {

        return corrAns;

    }

    public void dispQuestion() {

        System.out.println(text);
        for (int i = 0; i < 4; i++)
        {
            System.out.println(answers[i][1]);
        }

    }



}
