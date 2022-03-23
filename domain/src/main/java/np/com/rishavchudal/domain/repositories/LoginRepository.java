package np.com.rishavchudal.domain.repositories;

import np.com.rishavchudal.domain.models.LoginModel;

/**
 * Created by Rishav Chudal on 02/03/2022.
 */
public interface LoginRepository {
    LoginModel authenticateLogin(String email, String password);
}
