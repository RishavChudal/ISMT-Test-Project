package np.com.rishavchudal.test.framework.login;

import android.app.Application;

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
    private Application application;

    public LoginLocalDataSourceImpl(Application application) {
        this.application = application;
    }

    @Override
    public LoginModel authenticateLoginInLocalDatabase(
            String email,
            String password
    ) {
        LoginDao loginDao = FactDatabase.getInstance(application).getLoginDao();
        UserEntity userEntity = loginDao.getValidUser(email, password);
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
