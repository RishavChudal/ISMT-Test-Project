package np.com.rishavchudal.domain.usecases;

import np.com.rishavchudal.domain.models.RegistrationModel;
import np.com.rishavchudal.domain.repositories.RegistrationRepository;

/**
 * Created by Rishav Chudal on 28/03/2022.
 */
public class RegisterUserUseCase {
    private final RegistrationRepository registrationRepository;

    public RegisterUserUseCase(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public RegistrationModel registerUser(
            String fullName,
            String email,
            String address,
            String password
    ) {
        return registrationRepository.registerUser(fullName, email, address, password);
    }
}
