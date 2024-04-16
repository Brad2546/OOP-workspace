public class Question {
    String questionPrompt, questionAnswer;

    public Question(String questionPrompt, String questionAnswer) {
        this.questionPrompt = questionPrompt;
        this.questionAnswer = questionAnswer.toLowerCase();
    }

    public String getQuestionPrompt() {
        return questionPrompt;
    }

    public String getQuestionAnswer() {
        return questionAnswer;
    }

    public boolean isCorrect(String guess) {
        return guess.toLowerCase().equals(questionAnswer);
    }
}
