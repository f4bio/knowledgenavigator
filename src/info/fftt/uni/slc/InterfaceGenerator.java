package info.fftt.uni.slc;

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

    public InterfaceGenerator(Style style) {
        this.color = style.getColor();
        this.logo = style.getLogo();

        menu = "item0<br />item1<br />item2";
        header = String.format("<img src=%s />", logo);
        content = String.format("<body style='background=%s'>hello</body>", color);
    }

    public String generatePage() {
        return header+content;
    }

    public String getMenu() {
        return menu;
    }
    public String getHeader() {
        return header;
    }

    public String getContent() {
        return content;
    }
}
