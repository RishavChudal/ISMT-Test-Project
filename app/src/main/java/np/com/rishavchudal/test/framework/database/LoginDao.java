package np.com.rishavchudal.test.framework.database;

import androidx.room.Dao;
import androidx.room.Query;

/**
 * Created by Rishav Chudal on 24/03/2022.
 */
@Dao
public interface LoginDao {
    @Query("Select * from userentity where email_address = email_address")
    UserEntity getValidUser(String emailAddress);
}
