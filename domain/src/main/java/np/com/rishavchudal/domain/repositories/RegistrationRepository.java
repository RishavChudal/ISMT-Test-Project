package np.com.rishavchudal.domain.repositories;

import np.com.rishavchudal.domain.models.RegistrationModel;

/**
 * Created by Rishav Chudal on 28/03/2022.
 */
public interface RegistrationRepository {
    RegistrationModel registerUser(String fullName, String email, String address, String password);
}
