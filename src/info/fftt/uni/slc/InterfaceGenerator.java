package info.fftt.uni.slc;

import info.fftt.uni.slc.gui.Create;
import info.fftt.uni.slc.gui.Login;
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

    Login dialogLogin;
    Create dialogCreate;

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

    public String getURL() {
        return dialogCreate.getTextURL();
    }

    public String getDescription() {
        return dialogCreate.getTextDescription();
    }

    public String getTitle() {
        return dialogCreate.getTextTitle();
    }

    public void showLoginPage() {
        dialogLogin = new Login(this.knowledgeNavigator);

        dialogLogin.pack();
        dialogLogin.setVisible(true);
    }

    public void showCreatePage() {
        dialogCreate = new Create(this.knowledgeNavigator);
        dialogCreate.pack();
        dialogCreate.setVisible(true);
    }
}
