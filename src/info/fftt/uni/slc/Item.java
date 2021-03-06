package info.fftt.uni.slc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by fftt on 04.12.14.
 *
 */
public class Item {
    private ArrayList<Keyword> keywords;
    private Date date;
    private URL url;
    private String title;
    private String description;

    public Item(URL url, String title, String description) {
        this.url = url;
        this.title = title;
        this.description = description;
        this.date = new Date();
        this.keywords = new ArrayList<Keyword>();
    }

    public Item(String url, String title, String description) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.title = title;
        this.description = description;
        this.date = new Date();
        this.keywords = new ArrayList<Keyword>();
    }

    public void addKeyword(Keyword keyword) {
        this.keywords.add(keyword);
    }

    public Date getDate() {
        return date;
    }

    public URL getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
