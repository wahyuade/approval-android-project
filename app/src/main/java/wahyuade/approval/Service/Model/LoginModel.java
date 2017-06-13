package wahyuade.approval.Service.Model;

/**
 * Created by Wahyu Ade Sasongko on 6/11/2017.
 */

public class LoginModel {
    private boolean success;
    private String message, token;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }
}
