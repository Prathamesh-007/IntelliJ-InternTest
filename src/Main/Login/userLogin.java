package Main.Login;

import java.sql.*;

public class userLogin implements Login, Data {
    private static Statement s = null;
    private static ResultSet rs = null;
    public boolean getData(String user, Connection con) throws SQLException {
        s = con.createStatement();
        String command = "SELECT * FROM USER WHERE username = '" + user + "';";
        try {

            rs = s.executeQuery(command);
//            System.out.println(rs);

        } catch(SQLException e){
            System.out.println("Exception: " + e);
        }
        finally {
            if(rs.next()) {
//                System.out.println(rs);
                return true;
            }

            return false;
        }
    }

    public boolean checkUser(String user, String pass, Connection con) throws SQLException {
        if(getData(user, con)) {
            if(pass.equals(rs.getString("password"))) {
                System.out.println(user);
                System.out.println(pass);
                System.out.println(rs.getString("user_id"));
                return true;
            }
        }

        return false;
    }


}

