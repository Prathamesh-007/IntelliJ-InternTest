import Main.Customer.searchOperations;
import Main.Login.SQLConnections;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SearchForm extends JFrame{
    private JPanel panelMain;
    private JScrollPane sp;
    private JTable SearchResults;

    public SearchForm() throws SQLException {
        panelMain = new JPanel();
        String[] columns = {"User ID", "Username", "Password"};
        Connection con = SQLConnections.getCon();
        searchOperations s = new searchOperations();
        List<String[]> result = s.findWithUserID(con, "2");
        int size = result.size();
        String[][] data = new String[size][3];
        for(int i=0;i<size;i++) {
            data[i] = result.get(i);
        }

        SearchResults = new JTable(data, columns);
        SearchResults.setBounds(30, 40, 200, 300);

        sp = new JScrollPane(SearchResults);
        panelMain.add(sp);

        SQLConnections.closeCon(con);
    }

    public static void main(String[] args) throws SQLException{
        SearchForm s = new SearchForm();
        s.setContentPane(s.panelMain);
        s.setTitle("Search Results");
//        s.add(SearchResults)
        s.setVisible(true);
        s.setBounds(600, 200, 200, 200);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
