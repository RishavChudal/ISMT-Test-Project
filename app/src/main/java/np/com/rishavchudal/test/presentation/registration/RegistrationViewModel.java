package np.com.rishavchudal.test.presentation.registration;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import np.com.rishavchudal.data.repositories.RegistrationRepositoryImpl;
import np.com.rishavchudal.domain.models.RegistrationModel;
import np.com.rishavchudal.domain.usecases.RegisterUserUseCase;
import np.com.rishavchudal.test.framework.registration.RegistrationLocalDataSourceImpl;
import np.com.rishavchudal.test.framework.registration.RegistrationRemoteDataSourceImpl;

/**
 * Created by Rishav Chudal on 28/03/2022.
 */
public class RegistrationViewModel extends AndroidViewModel {
    private final MutableLiveData<RegistrationModel> registrationModelLiveData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isFullNameEmptyLiveData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isEmailCorrectLiveData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isPasswordInCorrectFormatLiveData = new MutableLiveData<>();

    public RegistrationViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<RegistrationModel> getRegistrationModelLiveData() {
        return registrationModelLiveData;
    }

    public MutableLiveData<Boolean> getIsFullNameEmptyLiveData() {
        return isFullNameEmptyLiveData;
    }

    public MutableLiveData<Boolean> getIsEmailCorrectLiveData() {
        return isEmailCorrectLiveData;
    }

    public MutableLiveData<Boolean> getIsPasswordInCorrectFormatLiveData() {
        return isPasswordInCorrectFormatLiveData;
    }

    private RegisterUserUseCase registerUserUseCase = new RegisterUserUseCase(
            new RegistrationRepositoryImpl(
                    new RegistrationLocalDataSourceImpl(getApplication()),
                    new RegistrationRemoteDataSourceImpl(getApplication())
            )
    );

    public void validateUserDataForRegistration(
            String fullName,
            String email,
            String address,
            String password,
            String confirmedPassword
    ) {
        //TODO Validate fields
        RegistrationModel registrationModel = registerUserUseCase
                .registerUser(fullName, email, address, password);

        registrationModelLiveData.setValue(registrationModel);
    }
}
