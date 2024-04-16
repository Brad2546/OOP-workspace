import java.util.Scanner;

public class Quiz {
    Question[] questions;
    Scanner scanner;
    int listSize, score;

    public Quiz() {
        questions = new Question[25];
        scanner = new Scanner(System.in);
        listSize = 0;
        score = 0;
    }

    public void add(String newPrompt, String newAnswer) {
        if (listSize < 25) {
            questions[listSize] = new Question(newPrompt, newAnswer);
            listSize++;
        }
    }

    public void askAllQuestions() {
        int questionNo = 1;
        score = 0;
        for (Question eachQuestion : questions) {
            if (eachQuestion == null) {
                break;
            }
            System.out.println("Question (" + questionNo + "/"+ listSize+") : " +eachQuestion.questionPrompt+": ");
            questionNo++;
            String guess = scanner.nextLine();
            if (eachQuestion.isCorrect(guess)) {
                System.out.println("Correct +1 score");
                score++;
            } else {
                System.out.println("Incorrect! the correct answer is \""+eachQuestion.getQuestionAnswer()+"\"");
            }
        }
        System.out.println("Well done, you got "+score+"/"+listSize+" questions correct!");
    }
}
