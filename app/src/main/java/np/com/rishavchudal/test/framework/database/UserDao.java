package np.com.rishavchudal.test.framework.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import np.com.rishavchudal.domain.models.User;

/**
 * Created by Rishav Chudal on 23/03/2022.
 */
@Dao
public interface UserDao {
    @Insert
    long insertUser(User user);

    @Query("Select * from userentity where user_id = :userId")
    User getUserDetails(long userId);
}
