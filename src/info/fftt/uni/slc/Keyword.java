package info.fftt.uni.slc;

import java.util.Date;

/**
 * Created by fftt on 04.12.14.
 */
public class Keyword {
    private String name;
    private String description;
    private Date date;

    public Keyword(String name, String description) {
        this.name = name;
        this.description = description;
        this.date = new Date();
    }
}
