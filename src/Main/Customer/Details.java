package Main.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public interface Details {
    public Map getDetails(Connection con);
    public void addUser(Connection con) throws SQLException;

    public void addUser(Connection con, String name, String pass) throws SQLException;

}
