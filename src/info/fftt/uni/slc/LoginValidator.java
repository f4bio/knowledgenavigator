package info.fftt.uni.slc;

/**
 * Created by fftt on 04.12.14.
 */
public class LoginValidator {

    public static boolean isValidUser(String email, String password) {
        if (email != null && password != null) {
            return true;
        } else {
            return false;
        }
    }
}
