package np.com.rishavchudal.domain.models;

/**
 * Created by Rishav Chudal on 28/03/2022.
 */
public class RegistrationModel {
    private final boolean isRegistrationSuccess;
    private final String message;
    private User user;

    public RegistrationModel(boolean isRegistrationSuccess, String message) {
        this.isRegistrationSuccess = isRegistrationSuccess;
        this.message = message;
    }

    public boolean isRegistrationSuccess() {
        return isRegistrationSuccess;
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
}
