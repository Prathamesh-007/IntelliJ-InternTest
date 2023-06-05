import Main.Customer.searchOperations;
import Main.Login.SQLConnections;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TrialRuns extends JFrame{
    private JPanel Trial;
    private JList list;
    private JButton btn;

    public DefaultListModel foo() throws SQLException{
        DefaultListModel<Map<String, String>> d = new DefaultListModel<>();
        Connection con = SQLConnections.getCon();
        Statement s = con.createStatement();
        String command = "SELECT * FROM user WHERE user_id > 2;";
        ResultSet rs = s.executeQuery(command);

        while(rs.next()) {
            Map<String, String> map = new LinkedHashMap<>();
            map.put("user_id", rs.getString("user_id"));
            map.put("username", rs.getString("username"));
            map.put("password", rs.getString("password"));
            d.addElement(map);
        }

        con.close();
        return d;
    }

    TrialRuns() throws SQLException {
        JFrame f= new JFrame();
        DefaultListModel<String> l1 = foo();
        JList<String> list = new JList<>(l1);
        list.setBounds(100,100, 75,75);
        list.setSize(600, 600);
        f.add(list);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String args[]) {
        Connection con = SQLConnections.getCon();
        try {
            searchOperations s = new searchOperations();
            List<String[]> result = s.findWithUserID(con, "1");
            int size = result.size();
            String[][] data = new String[size][3];
            for(int i=0;i<size;i++) {
                data[i] = result.get(i);
            }
            System.out.println(data[0][0] + " " + data[0][1] + " " + data[0][2]);

        }
        catch (SQLException e) {
            System.out.println("Exception: " + e);
        }
        finally {
            SQLConnections.closeCon(con);
        }

    }

}
