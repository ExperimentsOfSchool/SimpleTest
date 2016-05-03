package Utils;

import java.sql.*;

/**
 * Created by Lawrence on 5/1/16.
 *
 */
public class Database {
    private static Database ourInstance = new Database();
    public static Database getInstance() {
        return ourInstance;
    }
    private Connection connection = null;
    private Statement statement;
    private ResultSet resultSet;
    private String sqlStatement;
    private String URL;
    private static final String USER = "qdm21343998";
    private static final String PASS = "qdm21343998";
    private Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            URL = "jdbc:mysql://qdm21343998.my3w.com:3306/qdm21343998_db?autoReconnect=true&useSSL=false";
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int checkEmailAddress(String email) { //Not Exists ? 0 : 1; Error: -1
        try {
            statement = connection.createStatement();
            sqlStatement = "select * from UserList where email='" + email + "'";
            resultSet = statement.executeQuery(sqlStatement);
            return resultSet.next() ? 1 : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int checkPassword(String email, String password) {
        try {
            statement = connection.createStatement();
            sqlStatement = "select password from UserList where email='" + email+ "'";
            resultSet = statement.executeQuery(sqlStatement);
            if(resultSet.next()) {
                if(resultSet.getString(1).equals(password)) return 0; //ResultSet's first column is 1.
                else return 1;
            } else return 2;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int registry(String email, String password) {
        if(this.checkEmailAddress(email) == 0 && !password.equals("")) {
            try {
                statement = connection.createStatement();
                sqlStatement = "insert into UserList (email, password) values ('" + email + "', '" + password + "')";
                return statement.executeUpdate(sqlStatement);
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        } else {
            return -1;
        }
    }
    public int checkPaperName(String paperName) {
        try {
            statement = connection.createStatement();
            sqlStatement = "select * from PaperList where papername='" + paperName + "'";
            resultSet = statement.executeQuery(sqlStatement);
            return resultSet.next() ? 1 : 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int getPaperId(String paperName, String paperFileName) {
        try {
            statement = connection.createStatement();
            sqlStatement = "select paperid from PaperList where papername='" + paperName + "'";
            resultSet = statement.executeQuery(sqlStatement);
            if(resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                sqlStatement = "insert into PaperList (papername, filename) values ('" + paperName + "', '" + paperFileName + "')";
                int result = statement.executeUpdate(sqlStatement);
                if(result != 0) {
                    sqlStatement = "select paperid from PaperList where papername='" + paperName + "'";
                    resultSet = statement.executeQuery(sqlStatement);
                    if(resultSet.next()) {
                        return resultSet.getInt(1);
                    }
                    return 0;
                } else {
                    return -1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public String getPaperList() {
        try {
            statement = connection.createStatement();
            sqlStatement = "select * from PaperList";
            resultSet = statement.executeQuery(sqlStatement);
            String paperList = "<ul id=\"paper_list\">";
            while(resultSet.next()) {
                String piece = "<li class=\"paperPiece\">";
                piece += "<a href=\"SelectPaper?paperid=" + resultSet.getInt(1) + "\">" + resultSet.getString(2) + "</a>";
                piece += "</li>\n";
                paperList += piece;
            }
            paperList += "</ul>";
            return paperList;
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
    public String getPaperInfo(int paperID, String key) {
        try {
            statement = connection.createStatement();
            sqlStatement = "select " + key + " from PaperList where paperid=" + paperID;
            resultSet = statement.executeQuery(sqlStatement);
            if(resultSet.next()) return resultSet.getString(1);
            else return "ERROR";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
    public int setScore(int paperid, String email, int score) {
        try {
            statement = connection.createStatement();
            sqlStatement = "insert into ScoreList (paperid, email, score) values ('" + paperid + "', '" + email + "', '" + score + "')";
            return statement.executeUpdate(sqlStatement);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public String getScore(String email) {
        try {
            statement = connection.createStatement();
            sqlStatement = "select * from ScoreList where email='" + email + "'";
            ResultSet localResultSet = statement.executeQuery(sqlStatement);
            String output = "";
            while(localResultSet.next()) {
                String line = "<tr>";
                String paperName = this.getPaperInfo(localResultSet.getInt(2), "papername");
                line += "<td>" + paperName + "</td><td>" + localResultSet.getString(4) + "</td>";
                line += "</tr>\n";
                output += line;
            }
            return output;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
