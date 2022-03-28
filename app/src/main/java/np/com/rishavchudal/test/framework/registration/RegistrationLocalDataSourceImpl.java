package np.com.rishavchudal.test.framework.registration;

import android.app.Application;

import np.com.rishavchudal.data.sources.registration.RegistrationLocalDataSource;
import np.com.rishavchudal.domain.models.RegistrationModel;
import np.com.rishavchudal.domain.models.User;
import np.com.rishavchudal.test.framework.database.FactDatabase;
import np.com.rishavchudal.test.framework.database.RegistrationDao;
import np.com.rishavchudal.test.framework.database.UserEntity;

/**
 * Created by Rishav Chudal on 28/03/2022.
 */
public class RegistrationLocalDataSourceImpl implements RegistrationLocalDataSource {
    private Application application;

    public RegistrationLocalDataSourceImpl(Application application) {
        this.application = application;
    }

    @Override
    public RegistrationModel registerUserInLocalDataBase(
            String fullName,
            String email,
            String address,
            String password
    ) {
        RegistrationDao registrationDao = FactDatabase.getInstance(application).getRegistrationDao();
        if (registrationDao.isUserAlreadyPresent(email)) {
            return new RegistrationModel(false, "User Already Registered");
        }
        return insertUserDataInTable(fullName, email, address, password, registrationDao);
    }

    private RegistrationModel insertUserDataInTable(
            String fullName,
            String email,
            String address,
            String password,
            RegistrationDao registrationDao
    ) {
        try {
            UserEntity userEntity = new UserEntity(email, fullName, address, password);
            long rowId = registrationDao.insertUser(userEntity);
            if (rowId > 0) {
                return onSuccessRegistrationModel(userEntity);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new RegistrationModel(false, "User Registration Failed");
    }

    private RegistrationModel onSuccessRegistrationModel(UserEntity userEntity) {
        User user = new User(
                userEntity.getUserId(),
                userEntity.getFullName(),
                userEntity.getEmailAddress(),
                userEntity.getAddress()
        );
        RegistrationModel registrationModel = new RegistrationModel(
                true,
                "User Registered"
        );
        registrationModel.setUser(user);
        return registrationModel;
    }
}
