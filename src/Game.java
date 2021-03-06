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

    public ArrayList<Question> readFile() throws IOException {

        int set_number = chooseSetOfQuestions();
        while (set_number == 0) {
            set_number = chooseSetOfQuestions();
        }
        System.out.println("Wybrałeś zestaw pytań nr: " + set_number );

        FileReader fileReader = new FileReader(getFileName(set_number));
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int buff = 0;
        ArrayList<Question> questions = new ArrayList<Question>();


        for (int j = 0; j < 5; j++) {
            String text = "";
            ArrayList<Answer> answers = new ArrayList<Answer>();

            int k=0;

            for (int i = buff; i < buff+10; i++) {
                if (i == buff) {
                    text = bufferedReader.readLine();
                }
                else if (i == buff+9) {
                    bufferedReader.readLine();
                }
                else if (i % 2 == 0) {
                    answers.get(k).setText(bufferedReader.readLine());
                    k++;
                }
                else if (i % 2 == 1) {
                    Answer answer = new Answer();
                    answer.setValue( bufferedReader.readLine());
                    answers.add(answer);
                }
            }

            questions.add(new Question(text, answers));
            buff += 10;
        }
        bufferedReader.close();
        return questions;
    }

    public void showMenu(ArrayList<Question> questions){
        for (int i = 0; i < questions.size(); i++){
            System.out.println(questions.get(i).dispQuestion());
            checkAnswer(getAnswerFromUser(), questions.get(i));
        }
        System.out.print("Twój wynik: " + getScore());


    }

    public int chooseSetOfQuestions() {
        System.out.println("Cześć! Aby rozpocząć grę wybierz numer zestawu pytań (wpisz cyfrę między 1-5)");
        Scanner sc = new Scanner(System.in);
        int num = 0;
        try {
            num = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Wybrałeś zły symbol, spróbuj ponownie");
        }
        if (num < 1 || num > 4) {
            System.out.println("Wybrałeś zły numer, spróbuj ponownie");
            num = 0;
        }
        return num;
    }

    public String getFileName(int number){
        String fileName = "";
        switch (number){
            case 1: fileName = "C:/Users/Konrad/IdeaProjects/QuizGame/src/1.txt";
                break;
            case 2: fileName = "C:/Users/Konrad/IdeaProjects/QuizGame/src/2.txt";
                break;
            case 3: fileName = "C:/Users/Konrad/IdeaProjects/QuizGame/src/3.txt";
                break;
            case 4: fileName = "C:/Users/Konrad/IdeaProjects/QuizGame/src/4.txt";
                break;
            case 5: fileName = "C:/Users/Konrad/IdeaProjects/QuizGame/src/5.txt";
                break;
        }
        return fileName;
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
            System.out.println("Poprawna odpowiedź to: " + question.showCorrAns());
        }
    }
}
