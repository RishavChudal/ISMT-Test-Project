package np.com.rishavchudal.data.sources.registration;

import np.com.rishavchudal.domain.models.RegistrationModel;

/**
 * Created by Rishav Chudal on 28/03/2022.
 */
public interface RegistrationRemoteDataSource {

    boolean isInternetWorking();

    RegistrationModel registerUserInRemoteServer(
            String fullName,
            String email,
            String address,
            String password
    );
}
