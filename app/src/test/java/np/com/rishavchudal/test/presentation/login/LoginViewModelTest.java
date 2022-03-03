package np.com.rishavchudal.test.presentation.login;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import np.com.rishavchudal.data.LoginRepositoryImpl;
import np.com.rishavchudal.domain.models.LoginModel;
import np.com.rishavchudal.domain.usecases.LoginAuthenticateUseCase;
import np.com.rishavchudal.test.framework.LoginLocalDataSourceImpl;
import np.com.rishavchudal.test.framework.LoginRemoteDataSourceImpl;

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
    Observer<Boolean> isLoginSuccessObserver;

    @Mock
    LoginAuthenticateUseCase loginAuthenticateUseCase;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        loginViewModel = new LoginViewModel();
        loginViewModel.isEmailOrPasswordEmpty.observeForever(isEmailOrPasswordEmptyObserver);
        loginViewModel.isEmailIncorrect.observeForever(isEmailIncorrectObserver);
        loginViewModel.isLoginSuccess.observeForever(isLoginSuccessObserver);
    }

    @Test
    public void validateLoginCredentials() {
        String emailAddress = "rishav@ismt.edu.np";
        String password = "12345";
        LoginModel loginModel = new LoginModel(true, "Login Successful");
        when(loginAuthenticateUseCase.authenticateLogin(any(), any())).thenReturn(loginModel);


        loginViewModel.validateLoginCredentials(emailAddress, password);

//        verify(isEmailOrPasswordEmptyObserver).onChanged(true);
//        verify(isEmailIncorrectObserver).onChanged(true);

        verify(isLoginSuccessObserver).onChanged(true);

    }
}