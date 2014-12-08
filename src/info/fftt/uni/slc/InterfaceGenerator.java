package info.fftt.uni.slc;

import info.fftt.uni.slc.style.Style;

import javax.swing.*;
import java.awt.*;

/**
 * Created by fftt on 04.12.14.
 */
public class InterfaceGenerator {
    private String color;
    private String logo;

    private String menu;
    private String header;
    private String content;

    private KnowledgeNavigator knowledgeNavigator;

    JTextField txtUsername, txtPassword, txtURL, txtDescription, txtTitle;

    public InterfaceGenerator(KnowledgeNavigator knowledgeNavigator, Style style) {
        this.knowledgeNavigator = knowledgeNavigator;

        this.color = style.getColor();
        this.logo = style.getLogo();

    }

    public String getUsername() {
        return txtUsername.getText();
    }

    public String getPassword() {
        return txtPassword.getText();
    }

    public String getURL() {
        return txtURL.getText();
    }

    public String getDescription() {
        return txtDescription.getText();
    }

    public String getTitle() {
        return txtDescription.getText();
    }

    public JFrame getLoginPage() {
        JFrame f = new JFrame("Login");

        JButton btnLogin = new JButton("Login");
        txtUsername = new JTextField(20);
        txtPassword = new JTextField(20);

        // Sets the behavior for when the window is closed
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Add a layout manager so that the button is not placed on top of the label
        f.setLayout(new FlowLayout());

        btnLogin.setActionCommand(ACTION_COMMAND.LOGIN);
        btnLogin.addActionListener(knowledgeNavigator);

        f.add(new JLabel("Username"));
        f.add(txtUsername);
        f.add(new JLabel("Password"));
        f.add(txtPassword);
        f.add(btnLogin);

        return f;
    }

    public JFrame getCreatePage() {
        JFrame f = new JFrame("Create");

        JButton btnCreate = new JButton("Create");
        txtURL = new JTextField(20);
        txtDescription = new JTextField(20);
        txtTitle = new JTextField(20);

        // Sets the behavior for when the window is closed
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Add a layout manager so that the button is not placed on top of the label
        f.setLayout(new FlowLayout());

        btnCreate.setActionCommand(ACTION_COMMAND.CREATE);
        btnCreate.addActionListener(knowledgeNavigator);

        f.add(new JLabel("URL"));
        f.add(txtURL);
        f.add(new JLabel("Description"));
        f.add(txtDescription);
        f.add(new JLabel("Title"));
        f.add(txtTitle);
        f.add(btnCreate);

        return f;
    }
}
