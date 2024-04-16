public class QuizTime {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.add("whats the capital of nepal", "kathmandu");
        quiz.add("what is the 7th element", "nitrogen");
        quiz.askAllQuestions();
    }
}
