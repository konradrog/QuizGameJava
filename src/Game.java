import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Game {
    int score = 0;

    public Game() throws IOException {

        this.showMenu(this.readFile());
    }

    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score += score;
    }

    public ArrayList<Question>/*static void*/ readFile() throws IOException {
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
        return questions;
     }

    public void showMenu(ArrayList<Question> questions){
        System.out.println("Cześć! Aby rozpocząć grę wybierz numer zestawu pytań (wpisz cyfrę między 1-5)");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println("Wybrałeś zestaw pytań nr: " + num );

        for (int i = 0; i < questions.size(); i++){
            System.out.println(questions.get(i).dispQuestion());
            checkAnswer(getAnswerFromUser(), questions.get(i));
        }
        System.out.print("Twój wynik: " + getScore());


    }

    public String getAnswerFromUser(){
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        return num;
    }

    public void checkAnswer(String num, Question question) {
        int answer = 5;
        switch (num){
            case "a": answer = 0;
                    break;
            case "b": answer = 1;
                break;
            case "c": answer = 2;
                break;
            case "d": answer = 3;
                break;
        }
        if (answer == question.getCorrAns()) {
            setScore(100);
            System.out.println("Poprawna odpowiedź");
        }
        else {
            System.out.println("Zła odpowiedź");
            System.out.println("poprawna odpowiedź to: " + question.getCorrAns());
        }


    }
}
