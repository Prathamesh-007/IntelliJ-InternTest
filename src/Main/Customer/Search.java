package Main.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.List;

public interface Search {
    public String createCommand(String field, String val);
    public Map findWithEmail(Connection con, String email) throws SQLException;
    public Map findWithUsername(Connection con, String email) throws SQLException;
    public List findWithUserID(Connection con, String email) throws SQLException;
}
