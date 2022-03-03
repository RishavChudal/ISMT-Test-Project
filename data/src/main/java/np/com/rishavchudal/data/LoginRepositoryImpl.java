package np.com.rishavchudal.data;

import np.com.rishavchudal.data.sources.LoginLocalDataSource;
import np.com.rishavchudal.data.sources.LoginRemoteDataSource;
import np.com.rishavchudal.domain.models.LoginModel;
import np.com.rishavchudal.domain.repositories.LoginRepository;

/**
 * Created by Rishav Chudal on 02/03/2022.
 */
public class LoginRepositoryImpl implements LoginRepository {
    private final LoginRemoteDataSource loginRemoteDataSource;
    private final LoginLocalDataSource loginLocalDataSource;

    public LoginRepositoryImpl(
            LoginRemoteDataSource loginRemoteDataSource,
            LoginLocalDataSource loginLocalDataSource
    ) {
        this.loginRemoteDataSource = loginRemoteDataSource;
        this.loginLocalDataSource = loginLocalDataSource;
    }

    @Override
    public LoginModel authenticateLogin(String email, String password) {
        boolean isInternetWorking = loginRemoteDataSource.isInternetWorking();
        if (isInternetWorking) {
           return loginRemoteDataSource.authenticateLoginInRemoteServer(email, password);
        } else {
            return loginLocalDataSource.authenticateLoginInLocalDatabase(email, password);
        }
    }
}
