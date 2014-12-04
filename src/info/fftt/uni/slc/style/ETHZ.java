package info.fftt.uni.slc.style;

/**
 * Created by fftt on 04.12.14.
 */
public class ETHZ implements Style {
    private String color = "#ff00ff";
    private String logo = "./images/logos/ethz.png";

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getLogo() {
        return logo;
    }
}
