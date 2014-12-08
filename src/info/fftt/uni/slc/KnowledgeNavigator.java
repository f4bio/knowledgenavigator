package info.fftt.uni.slc;

import info.fftt.uni.slc.style.Style;
import info.fftt.uni.slc.style.UniBas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by fftt on 04.12.14.
 */
public class KnowledgeNavigator implements Runnable, ActionListener {
    private User[] users;
    private InterfaceGenerator interfaceGenerator;
    private JFrame jframe;

    public KnowledgeNavigator() {
        Style style = new UniBas();
        interfaceGenerator = new InterfaceGenerator(this, style);
    }

    @Override
    public void run() {
        // Create the window
        jframe = interfaceGenerator.getLoginPage();
        jframe.pack();
        // By default, the window is not visible. Make it visible.
        jframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals(ACTION_COMMAND.LOGIN)) {
            jframe.setVisible(false);
            // Create the window
            jframe = interfaceGenerator.getCreatePage();

            jframe.pack();
            // By default, the window is not visible. Make it visible.
            jframe.setVisible(true);
        }
    }
}
