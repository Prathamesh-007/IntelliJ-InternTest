package Main.Login;

import java.sql.Connection;
import java.sql.SQLException;

public interface Login {
    public boolean checkUser(String user, String pass, Connection con) throws SQLException;
}
