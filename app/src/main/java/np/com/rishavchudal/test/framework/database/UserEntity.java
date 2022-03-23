package np.com.rishavchudal.test.framework.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

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
}
