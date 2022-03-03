package np.com.rishavchudal.data.sources;

import np.com.rishavchudal.domain.models.LoginModel;

/**
 * Created by Rishav Chudal on 02/03/2022.
 */
public interface LoginLocalDataSource {
    LoginModel authenticateLoginInLocalDatabase(String email, String password);
}
