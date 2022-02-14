package np.com.rishavchudal.test.login;

/**
 * Created by Rishav Chudal on 14/02/2022.
 */
class LoginModel {
    private final String emailAddress;
    private final String password;

    public LoginModel(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }
}
