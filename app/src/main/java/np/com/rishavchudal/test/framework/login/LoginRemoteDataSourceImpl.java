package np.com.rishavchudal.test.framework.login;

import np.com.rishavchudal.data.sources.LoginRemoteDataSource;
import np.com.rishavchudal.domain.models.LoginModel;

/**
 * Created by Rishav Chudal on 03/03/2022.
 */
public class LoginRemoteDataSourceImpl implements LoginRemoteDataSource {
    @Override
    public boolean isInternetWorking() {
        return false;
    }

    @Override
    public LoginModel authenticateLoginInRemoteServer(String email, String password) {
        return null;
    }
}
