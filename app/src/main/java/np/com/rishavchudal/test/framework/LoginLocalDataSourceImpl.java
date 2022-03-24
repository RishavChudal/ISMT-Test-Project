package np.com.rishavchudal.test.framework;

import androidx.room.Room;

import np.com.rishavchudal.data.sources.LoginLocalDataSource;
import np.com.rishavchudal.domain.models.LoginModel;
import np.com.rishavchudal.domain.models.User;
import np.com.rishavchudal.test.FactApplication;
import np.com.rishavchudal.test.framework.database.FactDatabase;
import np.com.rishavchudal.test.framework.database.LoginDao;
import np.com.rishavchudal.test.framework.database.UserDao;
import np.com.rishavchudal.test.framework.database.UserEntity;

/**
 * Created by Rishav Chudal on 03/03/2022.
 */
public class LoginLocalDataSourceImpl implements LoginLocalDataSource {
    private FactDatabase factDatabase;

    public LoginLocalDataSourceImpl() {
        this.factDatabase = Room.databaseBuilder(
                FactApplication.getFactApplicationContext(),
                FactDatabase.class, "fact-database"
        ).build();
    }

    @Override
    public LoginModel authenticateLoginInLocalDatabase(
            String email,
            String password
    ) {
        LoginDao loginDao = factDatabase.getLoginDao();
        UserEntity userEntity = loginDao.getValidUser(email);
        if (userEntity == null) {
            return new LoginModel(false, "Login Failed");
        }
        User user = mapFrameWorkToDomain(userEntity);
        LoginModel loginModel = new LoginModel(
                true,
                "Login Success"
        );
        loginModel.setUser(user);
        return loginModel;
    }

    private User mapFrameWorkToDomain(UserEntity userEntity) {
        return new User(
                userEntity.getUserId(),
                userEntity.getEmailAddress(),
                userEntity.getFullName(),
                userEntity.getAddress()
        );
    }
}
