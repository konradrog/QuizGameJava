import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Game {
    public Game() throws IOException {

        this.readFile();
    }

    public static void readFile() throws IOException {
        FileReader fileReader = new FileReader("C:/Users/Konrad/IdeaProjects/QuizGame/src/pytania.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int buff = 0;
        ArrayList<Question> questions = new ArrayList<Question>();

        for (int j = 0; j < 5; j++) {
            String text = "";
            String[][] answers = new String[4][2] ;
            int k=0;
            for (int i = buff; i < buff+10; i++) {

                if (i == buff) {
                    text = bufferedReader.readLine();
                }
                else if (i == buff+9) {
                    bufferedReader.readLine();
                }
                else if (i % 2 == 0) {
                    answers[k][1] = bufferedReader.readLine();
                    k++;
                }
                else if (i % 2 == 1) {
                    answers[k][0] = bufferedReader.readLine();
                }
            }
            questions.add(new Question(text, answers));
            //questions.get(j).dispQuestion();
            buff += 10;
        }
        bufferedReader.close();
     }

     public static void showMenu(){

     }
}
