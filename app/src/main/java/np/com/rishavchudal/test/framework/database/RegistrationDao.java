package np.com.rishavchudal.test.framework.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * Created by Rishav Chudal on 28/03/2022.
 */
@Dao
public interface RegistrationDao {

    @Query("Select exists (Select * from user where email_address = :emailAddress)")
    boolean isUserAlreadyPresent(String emailAddress);

    @Insert
    long insertUser(UserEntity userEntity);
}
