package np.com.rishavchudal.domain.models;

/**
 * Created by Rishav Chudal on 02/03/2022.
 */
public class User {
    private final String fullName;
    private final String emailAddress;
    private final String address;

    public User(String fullName, String emailAddress, String address) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }
}
