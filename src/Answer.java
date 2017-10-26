import java.io.*;
import java.util.Scanner;

public class Answer {
    public int id;
    public String text;
    public boolean checked;

    public Answer(int id, String text, boolean checked ){
        this.id = id;
        this.text = text;
        this.checked = checked;
    }

    public void readFile() throws IOException {
        FileReader fileReader = new FileReader("C:/Users/Konrad/IdeaProjects/QuizGame/src/pytania.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String textLine = bufferedReader.readLine();
        do {
            System.out.println(textLine);

            textLine = bufferedReader.readLine();
        } while(textLine != null);

        bufferedReader.close();
    }

}

