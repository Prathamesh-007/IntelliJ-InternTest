package Main.Login;

import java.sql.Connection;
import java.sql.SQLException;

public interface Data {
    public boolean getData(String val, Connection con) throws SQLException;
}
