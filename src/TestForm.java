import Main.Customer.customerOperations;
import Main.Login.SQLConnections;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class TestForm extends JFrame {
    private JTextField nameField;
    private JTextField passwordField;
    private JButton Add;
    private JPanel panelMain;

    public TestForm() {
        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String password = passwordField.getText();
                Connection con = SQLConnections.getCon();
                customerOperations c = new customerOperations();
                try {
                    c.addUser(con, name, password);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                SQLConnections.closeCon(con);
            }
        });
    }

    public static void main(String[] args) {
        TestForm t = new TestForm();
        t.setContentPane(t.panelMain);
        t.setTitle("AddUser");
        t.setBounds(600, 200, 200, 200);
        t.setVisible(true);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
