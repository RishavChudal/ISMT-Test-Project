package np.com.rishavchudal.domain.usecases;

import np.com.rishavchudal.domain.models.LoginModel;
import np.com.rishavchudal.domain.repositories.LoginRepository;

/**
 * Created by Rishav Chudal on 02/03/2022.
 */
public class LoginAuthenticateUseCase {
    private final LoginRepository loginRepository;

    public LoginAuthenticateUseCase(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LoginModel authenticateLogin(String email, String password) {
        return loginRepository.authenticateLogin(email, password);
    }
}
