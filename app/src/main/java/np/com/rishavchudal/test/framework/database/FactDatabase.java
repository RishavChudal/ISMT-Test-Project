package np.com.rishavchudal.test.framework.database;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import np.com.rishavchudal.test.FactApplication;

/**
 * Created by Rishav Chudal on 23/03/2022.
 */
@Database(
        entities = {UserEntity.class},
        version = 1
)
public abstract class FactDatabase extends RoomDatabase {
    public static final String DB_NAME = "db-fun-facts";
    private static FactDatabase INSTANCE;

    public static FactDatabase getInstance(Application application) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    application.getApplicationContext(),
                    FactDatabase.class,
                    DB_NAME
            ).allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
    public abstract UserDao getUserDao();
    public abstract LoginDao getLoginDao();
    public abstract RegistrationDao getRegistrationDao();
}
