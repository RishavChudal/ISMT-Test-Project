package np.com.rishavchudal.test.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import np.com.rishavchudal.test.login.LoginModel;

/**
 * Created by Rishav Chudal on 28/02/2022.
 */
public class LoginViewModel extends ViewModel {
    final MutableLiveData<Boolean> isEmailOrPasswordEmpty = new MutableLiveData<>();
    final MutableLiveData<Boolean> isEmailIncorrect = new MutableLiveData<>();
    final MutableLiveData<Boolean> isPasswordIncorrect = new MutableLiveData<>();
    final MutableLiveData<Boolean> isLoginSuccess = new MutableLiveData<>();


    public void validateLoginCredentials(LoginModel loginModel) {
        String emailAddress = loginModel.getEmailAddress();
        String password = loginModel.getPassword();
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
        isLoginSuccess.setValue(true);
    }
}
