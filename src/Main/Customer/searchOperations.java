package Main.Customer;

import Main.commandExecute;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class searchOperations implements Search{
    private Map<String, String> mp = new LinkedHashMap<>();


    @Override
    public String createCommand(String field, String val) {
        String command = "SELECT * FROM user WHERE "
                + field + " = '" + val + "';";
        return command;
    }

    @Override
    public Map findWithEmail(Connection con, String email) throws SQLException {
        String command = createCommand("email", email);
        ResultSet rs = commandExecute.executeCommand(con, command);
        if(rs.next()) {
            mp.put("id", rs.getString("user_id"));
            mp.put("user", rs.getString("username"));
            mp.put("password", rs.getString("password"));
        }
        return mp;
    }

    @Override
    public Map findWithUsername(Connection con, String username) throws SQLException {
        String command = createCommand("username", username);
        ResultSet rs = commandExecute.executeCommand(con, command);
        if(rs.next()) {
            mp.put("id", rs.getString("user_id"));
            mp.put("user", rs.getString("username"));
            mp.put("password", rs.getString("password"));
        }

        return mp;
    }

    @Override
    public List findWithUserID(Connection con, String user_id) throws SQLException {
        String command = createCommand("user_id", user_id);
        ResultSet rs = commandExecute.executeCommand(con, command);
        List<String[]> result = new ArrayList<>();
        while(rs.next()) {
            String[] temp = new String[3];
            temp[0] = rs.getString(1);
            temp[1] = rs.getString(2);
            temp[2] = rs.getString(3);

            result.add(temp);
        }
        return result;
    }
}
