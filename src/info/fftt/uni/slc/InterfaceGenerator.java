package info.fftt.uni.slc;

import info.fftt.uni.slc.gui.LoginDialog;
import info.fftt.uni.slc.gui.MainDialog;
import info.fftt.uni.slc.style.Style;

import javax.swing.*;

/**
 * Created by fftt on 04.12.14.
 */
public class InterfaceGenerator {
    private KnowledgeNavigator knowledgeNavigator;

    LoginDialog dialogLogin;
    MainDialog dialogMain;

    public InterfaceGenerator(KnowledgeNavigator knowledgeNavigator, Style style) {
        this.knowledgeNavigator = knowledgeNavigator;

        try {
            UIManager.setLookAndFeel(style.getLookAndFeel());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return dialogLogin.getUsername();
    }

    public String getPassword() {
        return new String(dialogLogin.getPassword());
    }

    public ListModel<String> getItemsList() {
        return dialogMain.getItemList();
    }

    public void addItemsList(String text) {
        dialogMain.addListItem(text);
    }

    public void clearItemsList() {
        dialogMain.clearItemsList();
    }

    public void hideAll() {
        if (dialogLogin != null)
            dialogLogin.dispose();
        if (dialogMain != null)
            dialogMain.dispose();
    }

    public void showLogin() {
        dialogLogin = new LoginDialog(this.knowledgeNavigator);

        dialogLogin.pack();
        dialogLogin.setVisible(true);
    }

    public void showMain() {
        dialogMain = new MainDialog(this.knowledgeNavigator);

        dialogMain.pack();
        dialogMain.setVisible(true);
    }

    public String getURL() {
        return dialogMain.getURL();
    }

    public String getTitle() {
        return dialogMain.getTitle();
    }

    public String getDescription() {
        return dialogMain.getDescription();
    }
}
