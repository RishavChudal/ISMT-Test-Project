package np.com.rishavchudal.test.framework.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by Rishav Chudal on 23/03/2022.
 */
@Database(
        entities = {UserEntity.class},
        version = 1
)
public abstract class FactDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();
    public abstract LoginDao getLoginDao();
}
