package info.fftt.uni.slc;

import info.fftt.uni.slc.style.Style;
import info.fftt.uni.slc.style.UniBas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by fftt on 04.12.14.
 */
public class KnowledgeNavigator implements Runnable, ActionListener {
    private ArrayList<User> users;
    private InterfaceGenerator interfaceGenerator;

    public KnowledgeNavigator() {
        Style style = new UniBas();
        this.interfaceGenerator = new InterfaceGenerator(this, style);
        this.users = new ArrayList<User>();

        SwingUtilities.invokeLater(this);
    }

    @Override
    public void run() {
        // Create the window
        interfaceGenerator.showLogin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // actions
        if (e.getActionCommand().equals(ACTION_COMMAND.LOGIN)) {
            interfaceGenerator.hideAll();

            String username = interfaceGenerator.getUsername();
            String password = interfaceGenerator.getPassword();
            if (LoginValidator.isValidUser(username, password)) {

                this.users.add(new User(username, password));
                // Create the window
                System.out.println("showing menu");
                interfaceGenerator.showMenu();
            }
        } else if (e.getActionCommand().equals(ACTION_COMMAND.EXIT)) {
            interfaceGenerator.hideAll();
            System.exit(0);
        }
    }
}
