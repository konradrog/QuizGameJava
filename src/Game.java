import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Game {
    int buff = 0;

    public Game() throws IOException {

        this.readFile();
    }

    public static void readFile() throws IOException {
        FileReader fileReader = new FileReader("C:/Users/Konrad/IdeaProjects/QuizGame/src/pytania.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int buff = 0;
        String text = "";
        String[][] answers = new String[4][2] ;

        int k=0;

        for (int i = buff; i < buff+9; i++) {

            if (i == buff) {
                text = bufferedReader.readLine();
            }
            else if (i % 2 == 0) {
                answers[k][1] = bufferedReader.readLine();
                k++;
            }
            else if (i % 2 == 1) {
                answers[k][0] = bufferedReader.readLine();
            }
        }
        bufferedReader.close();


        Question q = new Question(text, answers);
        q.dispQuestion();


    }
}
