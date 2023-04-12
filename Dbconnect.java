
import java.sql.*;
import java.util.Scanner;
import java.lang.Class;
import java.text.*;
import java.util.Calendar;
import java.util.Date;

public class Dbconnect {

    public static void main(String args[]) {
        System.out.println("Select the Below option");
        System.out.println("-----------------------------------------------------------");
        System.out.println("1.Hour of the day when the call volume is highest.");
        System.out.println("2.Hour of the day when the calls are longest.");
        System.out.println("3.Day of the week when the call volume is highest.");
        System.out.println("4.Day of the week when the calls are longest.");
        Scanner myObj1 = new Scanner(System.in); // Create a Scanner object
        System.out.println("Enter Select above option:");
        int id = myObj1.nextInt(); // Read user input

        // switch open
        switch (id) {
            case 1: {
                System.out.println("Enter the date('2021-01-13'):");
                Scanner myObj = new Scanner(System.in); // Create a Scanner object
                System.out.println("Enter Date:");
                String date = myObj.nextLine();
                dval(date);
                break;
            }
            case 2: {
                System.out.println("Enter the date('2021-01-13'):");
                Scanner myObj = new Scanner(System.in); // Create a Scanner object
                System.out.println("Enter Date:");
                String date = myObj.nextLine();
                dlog(date);
                break;
            }
            case 3: {
                wval("2021-01-13");// dummy
                break;
            }
            case 4: {
                wlog("2021-01-13");// dummy
                break;
            }
            default: {
                System.out.println("Please Select the correct Option!");
            }
        }

    }

    private static void dbcon(int data, String date) {

        String[] time1;
        String[] time2;
        String[] storetime1 = new String[100];
        String[] storetime2 = new String[100];
        long[] difference = new long[20];
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/callcenter", "root",
                    "");
            Statement stmt = connect.createStatement();
            // switch
            switch (data) {
                // dval
                case 1: {
                    ResultSet rs = stmt
                            .executeQuery(
                                    "SELECT `Start_Time`,`End_Time`,MAX(`Duration`) FROM `callcenter` where date(`Start_Time`)='"
                                            + date + "'");
                    while (rs.next()) {
                        time1 = rs.getString(1).split(" ");
                        time2 = rs.getString(2).split(" ");
                        System.out.println(
                                "Hour of the day when the call volume is highest is: " + time1[1] + "-" + time2[1]);
                    }
                    break;
                }
                // dlog
                case 2: {

                    ResultSet rs = stmt.executeQuery(
                            "SELECT `Start_Time`,`End_Time` FROM `callcenter` where date(`Start_Time`)='"
                                    + date + "'");
                    while (rs.next()) {
                        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                        time1 = rs.getString(1).split(" ");
                        time2 = rs.getString(2).split(" ");
                        Date date1 = format.parse(time1[1]);
                        Date date2 = format.parse(time2[1]);
                        storetime1[i] = time1[1];
                        storetime2[i] = time2[1];
                        difference[i] = date2.getTime() - date1.getTime();
                        i++;
                    }

                    long max = difference[0];
                    int j = 0;
                    for (i = 1; i < difference.length; i++)
                        if (difference[i] > max) {
                            j = i;
                            max = difference[i];
                        }
                    System.out.println(
                            "Hour of the day when the calls are longest is:" + storetime1[j] + "-" + storetime2[j]);
                    break;
                }
                // week val
                case 3: {
                    ResultSet rs = stmt.executeQuery(
                            "SELECT DAYNAME(`Start_Time`) AS day_of_week, MAX(`Duration`) AS longest_call_duration FROM callcenter GROUP BY day_of_week ORDER BY longest_call_duration DESC LIMIT 1");
                    while (rs.next())
                        System.out.println(
                                "Day of the week when the call volume is highest is:" + rs.getString(1));
                    break;
                }
                // week log

                case 4: {
                    i = 0;
                    String[] day = new String[100];
                    ResultSet rs = stmt.executeQuery(
                            "SELECT DAYNAME(`Start_Time`) AS day_of_week,`Start_Time`,`End_Time` FROM callcenter");
                    while (rs.next()) {
                        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                        time1 = rs.getString(2).split(" ");
                        time2 = rs.getString(3).split(" ");
                        Date date1 = format.parse(time1[1]);
                        Date date2 = format.parse(time2[1]);
                        day[i] = rs.getString(1);
                        difference[i] = date2.getTime() - date1.getTime();
                        i++;
                    }
                    long max = difference[0];
                    int j = 0;
                    for (i = 1; i < difference.length; i++)
                        if (difference[i] > max) {
                            j = i;
                            max = difference[i];
                        }
                    System.out.println("Day of the week when the calls are longest is:" + day[j]);
                    break;
                }
            }
            connect.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // anylist function
    private static void dval(String date) {
        dbcon(1, date);// db connection
    }

    private static void dlog(String date) {
        dbcon(2, date);// db connection
    }

    private static void wval(String date) {
        dbcon(3, date);// db connection
    }

    private static void wlog(String date) {
        dbcon(4, date);// db connection
    }
    // end anylist function
}
