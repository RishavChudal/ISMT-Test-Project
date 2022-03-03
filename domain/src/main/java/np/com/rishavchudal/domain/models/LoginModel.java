package np.com.rishavchudal.domain.models;

/**
 * Created by Rishav Chudal on 02/03/2022.
 */
public class LoginModel {
    private final boolean isLoginSuccess;
    private final String message;
    private User user;

    public LoginModel(boolean isLoginSuccess, String message) {
        this.isLoginSuccess = isLoginSuccess;
        this.message = message;
    }

    public boolean isLoginSuccess() {
        return isLoginSuccess;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }
}
