package info.fftt.uni.slc.gui;

import info.fftt.uni.slc.KnowledgeNavigator;
import info.fftt.uni.slc.constants.ACTION_COMMAND;
import info.fftt.uni.slc.constants.TITLE;

import javax.swing.*;
import java.awt.event.*;

public class MainDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonExit;
    private JTabbedPane tabbedPane1;
    private JTextField textFieldTitle;
    private JTextField textFieldDescription;
    private JTextField textFieldURL;
    private JButton createButton;
    private JList<String> list1;
    private JButton refreshButton;
    private JTable table1;
    private JScrollPane scrollPane;

    DefaultListModel<String> listModel;

    public MainDialog(KnowledgeNavigator knowledgeNavigator) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonExit);

        buttonExit.setActionCommand(ACTION_COMMAND.EXIT);
        buttonExit.addActionListener(knowledgeNavigator);

        refreshButton.setActionCommand(ACTION_COMMAND.REFRESH_LIST);
        refreshButton.addActionListener(knowledgeNavigator);

        createButton.setActionCommand(ACTION_COMMAND.CREATE);
        createButton.addActionListener(knowledgeNavigator);

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

        setTitle(TITLE.MAIN);
    }

    public void addListItem(String item) {
//        System.out.println("adding item: " + item);
        listModel.addElement(item);
    }

    public void clearItemsList() {
        listModel.clear();
    }

    private void onCancel() {
        dispose();
    }

    private void createUIComponents() {
        listModel = new DefaultListModel<String>();
        list1 = new JList<String>(listModel);
    }

    public ListModel<String> getItemList() {
        return listModel;
    }

    public String getURL() {
        return this.textFieldURL.getText();
    }

    public String getTitle() {
        return this.textFieldTitle.getText();
    }

    public String getDescription() {
        return this.textFieldDescription.getText();
    }
}
