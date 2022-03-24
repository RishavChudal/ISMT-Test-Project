package np.com.rishavchudal.test.framework.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import np.com.rishavchudal.domain.models.User;

/**
 * Created by Rishav Chudal on 23/03/2022.
 */
@Entity
public class UserEntity {
    @ColumnInfo(name = "user_id")
    private long userId;

    @ColumnInfo(name = "email_address")
    private String emailAddress;

    @ColumnInfo(name = "full_name")
    private String fullName;

    @ColumnInfo(name = "address")
    private String address;

    public UserEntity(long userId, String emailAddress, String fullName, String address) {
        this.userId = userId;
        this.emailAddress = emailAddress;
        this.fullName = fullName;
        this.address = address;
    }

    public long getUserId() {
        return userId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public static UserEntity mapDomainToFrameWork(User user) {
        return new UserEntity(
                user.getUserId(),
                user.getEmailAddress(),
                user.getFullName(),
                user.getAddress()
        );
    }
}
