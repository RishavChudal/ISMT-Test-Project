package np.com.rishavchudal.test.presentation.registration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import np.com.rishavchudal.domain.models.LoginModel;
import np.com.rishavchudal.domain.models.RegistrationModel;
import np.com.rishavchudal.domain.models.User;
import np.com.rishavchudal.test.AppLogger;
import np.com.rishavchudal.test.R;
import np.com.rishavchudal.test.presentation.dashboard.DashboardActivity;
import np.com.rishavchudal.test.presentation.login.LoginMvvmActivity;

public class RegistrationActivity extends AppCompatActivity {

    private TextInputEditText textInputEditTextFullName;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextAddress;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextConfirmPassword;
    private MaterialButton materialButtonRegister;
    private TextView tvLogin;
    private RegistrationViewModel registrationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initViewModel();
        initViews();
        initRegisterButtonAction();
        initLoginClickAction();
        observeMutableLiveDatas();
    }

    @Override
    public void onBackPressed() {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(RegistrationActivity.this)
                .setTitle(R.string.title_exit)
                .setMessage(R.string.msg_exit)
                .setPositiveButton(R.string.title_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        exitApplication();
                    }
                })
                .setNegativeButton(R.string.title_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        materialAlertDialogBuilder.show();
    }

    private void initViewModel() {
        registrationViewModel = new ViewModelProvider(this).get(RegistrationViewModel.class);
    }

    private void initViews() {
        textInputEditTextFullName = findViewById(R.id.text_input_et_full_name);
        textInputEditTextEmail = findViewById(R.id.text_input_et_email);
        textInputEditTextAddress = findViewById(R.id.text_input_et_address);
        textInputEditTextPassword = findViewById(R.id.text_input_et_password);
        textInputEditTextConfirmPassword = findViewById(R.id.text_input_et_confirm_password);
        materialButtonRegister = findViewById(R.id.material_btn_register);
        tvLogin = findViewById(R.id.tv_login);
    }

    private void initRegisterButtonAction() {
        materialButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegisterButtonClicked();
            }
        });
    }

    private void onRegisterButtonClicked() {
        String fullName = textInputEditTextFullName.getText().toString().trim();
        AppLogger.log("Full Name ::: " + fullName);

        String email = textInputEditTextEmail.getText().toString().trim();
        AppLogger.log("Email ::: " + email);

        String address = textInputEditTextAddress.getText().toString().trim();
        AppLogger.log("Address ::: " + address);

        String password = textInputEditTextPassword.getText().toString().trim();
        AppLogger.log("Password ::: " + password);

        String confirmedPassword = textInputEditTextConfirmPassword.getText().toString().trim();
        AppLogger.log("Confirmed Password ::: " + confirmedPassword);

        registrationViewModel.validateUserDataForRegistration(
                fullName,
                email,
                address,
                password,
                confirmedPassword
        );
    }

    private void initLoginClickAction() {
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, LoginMvvmActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void observeMutableLiveDatas() {
        //TODO observe other mutable live datas
        observeRegistrationModelLiveData();
    }

    private void observeRegistrationModelLiveData() {
        registrationViewModel.getRegistrationModelLiveData().observe(
                this,
                new Observer<RegistrationModel>() {
                    @Override
                    public void onChanged(RegistrationModel registrationModel) {
                        onRegistrationModelChanged(registrationModel);
                    }
                }
        );
    }

    private void onRegistrationModelChanged(RegistrationModel registrationModel) {
        if (registrationModel.isRegistrationSuccess()) {
            Toast.makeText(
                    RegistrationActivity.this,
                    "Registration Success",
                    Toast.LENGTH_SHORT
            ).show();
            startDashboard(registrationModel.getUser());
            return;
        }
        Toast.makeText(
                RegistrationActivity.this,
                registrationModel.getMessage(),
                Toast.LENGTH_SHORT
        ).show();
    }

    private void startDashboard(User user) {
        Intent intent = new Intent(RegistrationActivity.this, DashboardActivity.class);
        intent.putExtra(DashboardActivity.EXTRA_DATA_USER, user);
        startActivity(intent);
        finish();
    }

    private void exitApplication() {
        finishAndRemoveTask();
    }
}