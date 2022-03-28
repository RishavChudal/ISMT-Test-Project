package np.com.rishavchudal.test.framework.registration;

import android.app.Application;

import np.com.rishavchudal.data.sources.registration.RegistrationRemoteDataSource;
import np.com.rishavchudal.domain.models.RegistrationModel;

/**
 * Created by Rishav Chudal on 28/03/2022.
 */
public class RegistrationRemoteDataSourceImpl implements RegistrationRemoteDataSource {
    private Application application;

    public RegistrationRemoteDataSourceImpl(Application application) {
        this.application = application;
    }

    @Override
    public boolean isInternetWorking() {
        return false;
    }

    @Override
    public RegistrationModel registerUserInRemoteServer(
            String fullName,
            String email,
            String address,
            String password
    ) {
        //TODO
        return null;
    }
}
