package info.fftt.uni.slc.gui;

import info.fftt.uni.slc.KnowledgeNavigator;
import info.fftt.uni.slc.constants.ACTION_COMMAND;
import info.fftt.uni.slc.constants.TITLE;

import javax.swing.*;
import java.awt.event.*;

public class LoginDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private KnowledgeNavigator knowledgeNavigator;

    public LoginDialog(KnowledgeNavigator knowledgeNavigator) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        this.knowledgeNavigator = knowledgeNavigator;

        buttonOK.setActionCommand(ACTION_COMMAND.LOGIN);
        buttonCancel.setActionCommand(ACTION_COMMAND.CANCEL);

        buttonOK.addActionListener(knowledgeNavigator);
        buttonCancel.addActionListener(knowledgeNavigator);

        setTitle(TITLE.LOGIN);

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        dispose();
    }

    public String getUsername() {
        return this.textField1.getText();
    }

    public char[] getPassword() {
        return this.passwordField1.getPassword();
    }
}
