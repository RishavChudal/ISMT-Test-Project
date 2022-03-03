package np.com.rishavchudal.test.framework;

import np.com.rishavchudal.data.sources.LoginLocalDataSource;
import np.com.rishavchudal.domain.models.LoginModel;

/**
 * Created by Rishav Chudal on 03/03/2022.
 */
public class LoginLocalDataSourceImpl implements LoginLocalDataSource {
    @Override
    public LoginModel authenticateLoginInLocalDatabase(String email, String password) {
        return null;
    }
}
