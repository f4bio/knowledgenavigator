package info.fftt.uni.slc.style;

/**
 * Created by fftt on 04.12.14.
 */
public class UniBas implements Style {

    private final String lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";

    @Override
    public String getLookAndFeel() {
        return lookAndFeel;
    }

}
