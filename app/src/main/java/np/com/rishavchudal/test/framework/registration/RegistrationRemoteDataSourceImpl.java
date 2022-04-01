package np.com.rishavchudal.test.framework.registration;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import np.com.rishavchudal.data.sources.registration.RegistrationRemoteDataSource;
import np.com.rishavchudal.domain.models.RegistrationModel;

/**
 * Created by Rishav Chudal on 28/03/2022.
 */
public class RegistrationRemoteDataSourceImpl implements RegistrationRemoteDataSource {
    private Application application;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    public RegistrationRemoteDataSourceImpl(Application application) {
        this.application = application;
    }

    @Override
    public boolean isInternetWorking() {
        return true;
    }

    @Override
    public RegistrationModel registerUserInRemoteServer(
            String fullName,
            String email,
            String address,
            String password
    ) {
        //TODO
        final String[] userId = {""};
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(application.getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();
                    userId[0] = firebaseAuth.getCurrentUser().getUid();
                    if (!userId[0].isEmpty()) {
                        insertDataIntoRealTimeDataBase(fullName, email, address, userId[0]);
                    }
                }
            }
        });
        return new RegistrationModel(false, "Registration Failed");
    }

    private RegistrationModel insertDataIntoRealTimeDataBase(
            String fullName,
            String email,
            String address,
            String userId
    ) {
        databaseReference = FirebaseDatabase
                .getInstance("https://ismt-test-project-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .getReference();
        databaseReference.child("users").child(userId).child("full_name").setValue(fullName);
        databaseReference.child("users").child(userId).child("email").setValue(email);
        databaseReference.child("users").child(userId).child("address").setValue(address);

        return new RegistrationModel(false, "Registration Failed");
    }
}
