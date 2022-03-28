package np.com.rishavchudal.test.framework.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import np.com.rishavchudal.domain.models.User;

/**
 * Created by Rishav Chudal on 23/03/2022.
 */
@Entity(tableName = "user")
public class UserEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private long userId;

    @ColumnInfo(name = "email_address")
    private String emailAddress;

    @ColumnInfo(name = "full_name")
    private String fullName;

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "password")
    private String password;

    public UserEntity(String emailAddress, String fullName, String address, String password) {
        this.emailAddress = emailAddress;
        this.fullName = fullName;
        this.address = address;
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public String getPassword() {
        return password;
    }
}
