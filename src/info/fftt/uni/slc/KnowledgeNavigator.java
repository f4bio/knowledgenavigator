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
                System.out.println("showing main window");
                interfaceGenerator.showMain();
            }
        } else if (e.getActionCommand().equals(ACTION_COMMAND.REFRESH_LIST)) {
            System.out.println("refreshing list");

            interfaceGenerator.clearItemsList();
            for (Item item : this.users.get(0).items) {
                interfaceGenerator.addItemsList(String.format("%s (%s)", item.getTitle(), item.getUrl().toString()));
            }

        } else if (e.getActionCommand().equals(ACTION_COMMAND.CREATE)) {
            System.out.println("creating item");

            String url = interfaceGenerator.getURL();
            String title = interfaceGenerator.getTitle();
            String description = interfaceGenerator.getDescription();

            Item item = new Item(url, title, description);
            this.users.get(0).addItem(item);

        } else if (e.getActionCommand().equals(ACTION_COMMAND.EXIT)) {
            interfaceGenerator.hideAll();
            System.exit(0);
        }
    }
}
