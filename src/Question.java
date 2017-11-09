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
        this.corrAns = this.setCorrAns(answers);
    }

    public String getText() {

        return text;
    }

    public int setCorrAns(String[][] answers) {
        int result = 0;
        for (int i=0; i < 4; i++) {

            if (answers[i][0].equals("1")) {
                result = i;
            }

        }
        return result;
    }

    public int getCorrAns() {

        return corrAns;

    }

    public String dispQuestion() {

        System.out.println(text);
        for (int i = 0; i < 4; i++)
        {
            System.out.println(answers[i][1]);
        }
        return "";
    }

    public String showCorrAns() {
        String corrAnsLetter = "";
        switch (corrAns) {
            case 0: corrAnsLetter = "a";
                break;
            case 1: corrAnsLetter = "b";
                break;
            case 2: corrAnsLetter = "c";
                break;
            case 3: corrAnsLetter = "d";
                break;
        }
        return corrAnsLetter;
    }



}
