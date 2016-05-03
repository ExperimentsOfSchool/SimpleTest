package Paper;

/**
 * Created by Lawrence on 5/1/16.
 *
 */
public class Question {
    private int questionID;
    private String questionDetail;
    private String[] options;
    private int correctAnswer;
    public Question(int questionID, String questionDetail, String[] options, int correctAnswer) {
        this.questionDetail = questionDetail;
        this.questionID = questionID;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
    public boolean judgeAnswer(int answer) {
        return (answer == this.correctAnswer);
    }
    public String[] getOptions() {
        return this.options;
    }
    public int getQuestionID() {
        return this.questionID;
    }
    public String generateInConsole() {
        String output = this.questionID + ": " + this.questionDetail + "\n";
        output += "A. " + this.options[0] + "\tB. " + this.options[1] + "\tC. " + this.options[2] + "\tD. " + this.options[3] + "\n";
        output += "Correct Answer is: " + this.correctAnswer;
        return output;
    }
    public String printIntoHTML() {
        String output = "<div>" +
                        "<div class=\"questionDetail\"><h3>" + this.questionDetail + "</h3></div>" +
                        "<div class=\"questionOptions\">\n";
        for(int i = 0; i< 4; i++) {
            output += "<div class=\"option\"><label for=\"" + this.questionID + "_" + (i+1) + "\"><input name=\"" + this.questionID + "\" type=\"radio\" value=" + (i+1) + " id=\"" + this.questionID + "_" + (i+1) + "\" />" + "<label for=\"" + this.questionID + "_" + (i+1) + "\">" + options[i] + "</label></div>\n";
        }
        output += "</div></div>\n";
        return output;
    }
}