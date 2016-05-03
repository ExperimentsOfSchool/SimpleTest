package Paper;

import Utils.Database;
import Utils.Utilities;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Lawrence on 5/1/16.
 *
 */
public class Paper {
    private String paperName;
    private ArrayList<Question> questions;
    private String paperFileName;
    private String paperPath;
    private int paperId;
    public Paper(String paperName, String paperPath, String paperFileName) {
        this.paperName = paperName;
        this.paperPath = paperPath;
        this.paperFileName = paperFileName;
        Database database = Database.getInstance();
        this.paperId = database.getPaperId(this.paperName, this.paperFileName);
        if(this.paperId == -1) this.paperId = 0;
        questions = new ArrayList<>();
        try {
            Workbook questionBook = new XSSFWorkbook(paperPath + "/" + paperFileName);
            Sheet questionSheet = questionBook.getSheetAt(0);
            for (int i = 1; i <= questionSheet.getLastRowNum(); i++) { //getLastRowNum == Row Count - 1
                Row questionRow = questionSheet.getRow(i);
                String[] options = new String[4];
                for(int j = 0; j < 4; j++) {
                    options[j] = questionRow.getCell(j + 2).getStringCellValue();
                }
                Question question = new Question((int)questionRow.getCell(0).getNumericCellValue(), questionRow.getCell(1).getStringCellValue(), options, Utilities.getCorrectAnswerNum(questionRow.getCell(6).getStringCellValue()));
                questions.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String printIntoHTML() {
        String output = "";
        for(Question question : questions) {
            output += question.printIntoHTML();
        }
        return output;
    }

    public String getPaperName() {
        return this.paperName;
    }

    public String getPaperFileName() {
        return this.paperFileName;
    }

    public int getPaperId() {
        return this.paperId;
    }
    public ArrayList<Question> getQuestions() {
        return this.questions;
    }
}
