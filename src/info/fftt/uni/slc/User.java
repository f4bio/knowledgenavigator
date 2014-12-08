package info.fftt.uni.slc;

import java.util.ArrayList;

/**
 * Created by fftt on 04.12.14.
 */
public class User {
    ArrayList<Item> items;
    String username, password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
}
