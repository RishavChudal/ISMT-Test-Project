package np.com.rishavchudal.test.presentation.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import np.com.rishavchudal.data.LoginRepositoryImpl;
import np.com.rishavchudal.domain.models.LoginModel;
import np.com.rishavchudal.domain.usecases.LoginAuthenticateUseCase;
import np.com.rishavchudal.test.framework.LoginLocalDataSourceImpl;
import np.com.rishavchudal.test.framework.LoginRemoteDataSourceImpl;

/**
 * Created by Rishav Chudal on 28/02/2022.
 */
public class LoginViewModel extends ViewModel {
    final MutableLiveData<Boolean> isEmailOrPasswordEmpty = new MutableLiveData<>();
    final MutableLiveData<Boolean> isEmailIncorrect = new MutableLiveData<>();
    final MutableLiveData<Boolean> isPasswordIncorrect = new MutableLiveData<>();
    final MutableLiveData<Boolean> isLoginSuccess = new MutableLiveData<>();

    private LoginAuthenticateUseCase loginAuthenticateUseCase = new LoginAuthenticateUseCase(
            new LoginRepositoryImpl(
                    new LoginRemoteDataSourceImpl(),
                    new LoginLocalDataSourceImpl()
            )
    );

    public void validateLoginCredentials(String emailAddress, String password) {
        if (emailAddress.isEmpty() || password.isEmpty()) {
            isEmailOrPasswordEmpty.setValue(true);
            return;
        } else {
            isEmailOrPasswordEmpty.setValue(false);
        }

        /**
         * In Case of Backend Connection
         */
        /*BackEndConnection backEndConnection = new BackEndConnection();
        LoginResponse loginResponse = backEndConnection.verifyLogin(loginModel);*/

        /**
         * In Case of DB Validation
         */
        /*DbConnection dbConnection = new DbConnection();
        LoginResponse loginResponse1 = dbConnection.verifyLogin(loginModel);*/

        if (!emailAddress.equalsIgnoreCase("rishav@ismt.edu.np")) {
            isEmailIncorrect.setValue(true);
            return;
        } else {
            isEmailIncorrect.setValue(false);
        }

        if (!password.equals("12345")) {
            isPasswordIncorrect.setValue(true);
            return;
        } else {
            isPasswordIncorrect.setValue(false);
        }
        LoginModel loginModel = loginAuthenticateUseCase.authenticateLogin(emailAddress, password);
        isLoginSuccess.setValue(loginModel.isLoginSuccess());
    }
}
