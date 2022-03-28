package np.com.rishavchudal.test.presentation.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import np.com.rishavchudal.data.repositories.LoginRepositoryImpl;
import np.com.rishavchudal.domain.models.LoginModel;
import np.com.rishavchudal.domain.usecases.LoginAuthenticateUseCase;
import np.com.rishavchudal.test.framework.login.LoginLocalDataSourceImpl;
import np.com.rishavchudal.test.framework.login.LoginRemoteDataSourceImpl;

/**
 * Created by Rishav Chudal on 28/02/2022.
 */
public class LoginViewModel extends AndroidViewModel {
    final MutableLiveData<Boolean> isEmailOrPasswordEmptyLiveData = new MutableLiveData<>();
    final MutableLiveData<Boolean> isEmailIncorrectLiveData = new MutableLiveData<>();
    final MutableLiveData<Boolean> isPasswordIncorrectLiveData = new MutableLiveData<>();
    final MutableLiveData<LoginModel> loginModelLiveData = new MutableLiveData<>();

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    private LoginAuthenticateUseCase loginAuthenticateUseCase = new LoginAuthenticateUseCase(
            new LoginRepositoryImpl(
                    new LoginRemoteDataSourceImpl(),
                    new LoginLocalDataSourceImpl(getApplication())
            )
    );

    public void validateLoginCredentials(String emailAddress, String password) {
        if (emailAddress.isEmpty() || password.isEmpty()) {
            isEmailOrPasswordEmptyLiveData.setValue(true);
            return;
        } else {
            isEmailOrPasswordEmptyLiveData.setValue(false);
        }
        //TODO Other Validations
        LoginModel loginModel = loginAuthenticateUseCase.authenticateLogin(emailAddress, password);
        loginModelLiveData.setValue(loginModel);
    }
}
