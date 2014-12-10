package info.fftt.uni.slc.style;

/**
 * Created by fftt on 04.12.14.
 */
public class ETHZ implements Style {
    private final String lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";

    @Override
    public String getLookAndFeel() {
        return lookAndFeel;
    }
}
