package np.com.rishavchudal.test.presentation.login;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.app.Application;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import np.com.rishavchudal.domain.models.LoginModel;
import np.com.rishavchudal.domain.usecases.LoginAuthenticateUseCase;

/**
 * Created by Rishav Chudal on 03/03/2022.
 */
@RunWith(JUnit4.class)
public class LoginViewModelTest {
    private LoginViewModel loginViewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Mock
    Observer<Boolean> isEmailOrPasswordEmptyObserver;

    @Mock
    Observer<Boolean> isEmailIncorrectObserver;

    @Mock
    Observer<LoginModel> loginModelObserver;

    @Mock
    LoginAuthenticateUseCase loginAuthenticateUseCase;

    @Mock
    Application application;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        loginViewModel = new LoginViewModel(application);
        loginViewModel.isEmailOrPasswordEmptyLiveData.observeForever(isEmailOrPasswordEmptyObserver);
        loginViewModel.isEmailIncorrectLiveData.observeForever(isEmailIncorrectObserver);
        loginViewModel.loginModelLiveData.observeForever(loginModelObserver);
    }

    @Test
    public void validateLoginCredentials_OnEmailEmpty_isEmailOrPasswordEmptyLiveDataChangesToTrue() {
        //setup
        String emailAddress = "";
        String password = "12345";

        //test
        loginViewModel.validateLoginCredentials(emailAddress, password);

        //verify
        verify(isEmailOrPasswordEmptyObserver).onChanged(true);
    }

    @Test
    public void validateLoginCredentials_OnPasswordEmpty_isEmailOrPasswordEmptyLiveDataChangesToTrue() {
        //setup
        String emailAddress = "rishavchudal@ismt.edu.np";
        String password = "";

        //test
        loginViewModel.validateLoginCredentials(emailAddress, password);

        //verify
        verify(isEmailOrPasswordEmptyObserver).onChanged(true);
    }

    //TODO Change, Will refactor later
    @Test
    public void validateLoginCredentials_onLoginSuccess_isLoginSuccessLiveDataChangedToTrue() {
        //setup
        String emailAddress = "rishav@ismt.edu.np";
        String password = "12345";
        LoginModel loginModel = new LoginModel(true, "Login Successful");
        when(loginAuthenticateUseCase.authenticateLogin(any(), any())).thenReturn(loginModel);

        //test
        loginViewModel.validateLoginCredentials(emailAddress, password);

        //verify
        verify(loginModelObserver).onChanged(loginModel);

    }
}