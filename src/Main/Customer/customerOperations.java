package Main.Customer;

import Main.commandExecute;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class customerOperations implements Details {

    private final static Scanner scan = new Scanner(System.in);

    @Override
    public Map<String, String> getDetails(Connection con) {

        Map<String, String> mp = new LinkedHashMap<>();

        System.out.print("Enter first name: ");
        String fname = scan.nextLine();
        mp.put("fname", fname);

        System.out.print("Enter last name: ");
        String lname = scan.nextLine();
        mp.put("lname", lname);

        System.out.print("Enter password: ");
        String pass = scan.nextLine();
        mp.put("password", pass);

        return mp;

    }

    @Override
    public void addUser(Connection con) throws SQLException {
        Map<String, String> mp = getDetails(con);
        String fname = mp.get("fname");
        String lname = mp.get("lname");
        String name = fname + " " + lname;
        String pass =mp.get("password");

        String command = "INSERT INTO user(username, password) VALUES('"
                + name + "', '" + pass + "');";

        ResultSet rs = commandExecute.executeCommand(con, command);
    }

    public void addUser(Connection con, String name, String pass) throws SQLException{
        String command = "INSERT INTO user(username, password) VALUES('"
                + name + "', '" + pass + "');";
        ResultSet rs = commandExecute.executeCommand(con, command);
    }

}
