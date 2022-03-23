package np.com.rishavchudal.domain.models;

/**
 * Created by Rishav Chudal on 02/03/2022.
 */
public class User {
    private final long userId;
    private final String fullName;
    private final String emailAddress;
    private final String address;

    public User(long userId, String fullName, String emailAddress, String address) {
        this.userId = userId;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.address = address;
    }

    public long getUserId() {
        return userId;
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
