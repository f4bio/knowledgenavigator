package info.fftt.uni.slc;

import info.fftt.uni.slc.style.Style;
import info.fftt.uni.slc.style.UniBas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by fftt on 04.12.14.
 */
public class KnowledgeNavigator implements Runnable, ActionListener {
    private ArrayList<User> users;
    private InterfaceGenerator interfaceGenerator;
    private JDialog jDialog;

    public KnowledgeNavigator() {
        Style style = new UniBas();
        this.interfaceGenerator = new InterfaceGenerator(this, style);
        this.users = new ArrayList<User>();

        SwingUtilities.invokeLater(this);
    }

    @Override
    public void run() {
        // Create the window
        interfaceGenerator.showLoginPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(ACTION_COMMAND.LOGIN)) {
            String username = interfaceGenerator.getUsername();
            String password = interfaceGenerator.getPassword();
            if (LoginValidator.isValidUser(username, password)) {

                this.users.add(new User(username, password));
                // Create the window
                interfaceGenerator.showCreatePage();
            }
        } else if (e.getActionCommand().equals(ACTION_COMMAND.CREATE)) {
            String url = interfaceGenerator.getURL();
            String description = interfaceGenerator.getDescription();
            String title = interfaceGenerator.getTitle();

            try {
                //TODO: multi-user support
                this.users.get(0).addItem(new Item(new URL(url), title, description));
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            }

        } else if (e.getActionCommand().equals(ACTION_COMMAND.CANCEL)) {
            interfaceGenerator.dialogLogin.dispose();
            interfaceGenerator.dialogCreate.dispose();
        }
    }
}
