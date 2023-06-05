package Main;


import Main.Customer.customerOperations;
import Main.Customer.searchOperations;
import Main.Login.SQLConnections;
import Main.Login.userLogin;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.sql.*;

public class Main {
    private static final Scanner scan = new Scanner(System.in);
    private static final Connection con = SQLConnections.getCon();

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");

//        foo();
//        test();
//        test2();
        searchOperations s = new searchOperations();
        Map<String, String> mp = s.findWithUsername(con, "Ana");
        if(mp.isEmpty())
            System.out.println("No Result Found");
        else
            System.out.println(mp);
        SQLConnections.closeCon(con);

    }

    public static void foo() throws SQLException{
        System.out.print("Enter username: ");
        String user = scan.next();
        System.out.print("Enter password: ");
        String pass = scan.next();

        userLogin u = new userLogin();

        if(u.checkUser(user, pass, con)) {
            System.out.println(user + " is a valid user");
        }
    }

//    public static void test() {
//        try {
//            Connection trial = SQLConnections.getCon();
//            Statement s = trial.createStatement();
//            String command = "INSERT INTO user(username, password) values ('test123', 'abcdefg');";
//            String command = "SELECT * FROM user;";
//            if(s.execute(command)) {
//                ResultSet rs = s.getResultSet();
//                while(rs.next()) {
//
//                }
//            }
//            SQLConnections.closeCon(trial);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

    public static void test2() throws SQLException {
        customerOperations c = new customerOperations();
        c.addUser(con);
    }

}