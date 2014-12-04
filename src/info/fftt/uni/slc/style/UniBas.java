package info.fftt.uni.slc.style;

/**
 * Created by fftt on 04.12.14.
 */
public class UniBas implements Style {

    private String color = "#00ff00";
    private String logo = "./images/logos/unibas.png";

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getLogo() {
        return logo;
    }
}
