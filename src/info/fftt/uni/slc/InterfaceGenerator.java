package info.fftt.uni.slc;

import info.fftt.uni.slc.gui.LoginDialog;
import info.fftt.uni.slc.gui.MainDialog;
import info.fftt.uni.slc.style.Style;

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

    LoginDialog dialogLogin;
    MainDialog dialogMenu;

    public InterfaceGenerator(KnowledgeNavigator knowledgeNavigator, Style style) {
        this.knowledgeNavigator = knowledgeNavigator;

        this.color = style.getColor();
        this.logo = style.getLogo();
    }

    public String getUsername() {
        return dialogLogin.getUsername();
    }

    public String getPassword() {
        return new String(dialogLogin.getPassword());
    }


    public void hideAll() {
        if (dialogLogin != null)
            dialogLogin.dispose();
        if (dialogMenu != null)
            dialogMenu.dispose();
    }

    public void showLogin() {
        dialogLogin = new LoginDialog(this.knowledgeNavigator);

        dialogLogin.pack();
        dialogLogin.setVisible(true);
    }

    public void showMenu() {
        dialogMenu = new MainDialog(this.knowledgeNavigator);

        dialogMenu.pack();
        dialogMenu.setVisible(true);
    }
}
