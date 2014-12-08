package info.fftt.uni.slc.gui;

import info.fftt.uni.slc.ACTION_COMMAND;
import info.fftt.uni.slc.KnowledgeNavigator;

import javax.swing.*;
import java.awt.event.*;

public class Create extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField textURL;
    private JTextField textTitle;
    private JTextField textDescription;
    private KnowledgeNavigator knowledgeNavigator;

    public String getTextURL() {
        return textURL.getText();
    }

    public String getTextTitle() {
        return textTitle.getText();
    }

    public String getTextDescription() {
        return textDescription.getText();
    }

    public Create(KnowledgeNavigator knowledgeNavigator) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        this.knowledgeNavigator = knowledgeNavigator;

        buttonOK.setActionCommand(ACTION_COMMAND.CREATE);
        buttonOK.addActionListener(knowledgeNavigator);

        setTitle("Create");

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }
}
