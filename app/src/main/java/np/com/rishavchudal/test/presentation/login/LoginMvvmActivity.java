package np.com.rishavchudal.test.presentation.login;

import static np.com.rishavchudal.test.R.color.white;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import np.com.rishavchudal.test.presentation.dashboard.DashboardActivity;
import np.com.rishavchudal.test.R;

/**
 * Created by Rishav Chudal on 28/02/2022.
 */
public class LoginMvvmActivity extends AppCompatActivity {
    private final static String tagName = "LoginMvvmActivity";
    private TextView tvTitle;
    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d(tagName, "On Create is called");
        bindViewModel();
        initViews();
        assignPageTitle();
        initLoginButtonAction();
        observeMutableLiveData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tagName, "On Start is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tagName, "On Resume is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tagName, "On Pause is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tagName, "On Stop is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tagName, "On Destroy is called");
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(this, "Do you want to exit?", Toast.LENGTH_SHORT).show();
    }

    private void bindViewModel() {
        loginViewModel = new ViewModelProvider(LoginMvvmActivity.this)
                .get(LoginViewModel.class);
    }

    private void initViews() {
        tvTitle = findViewById(R.id.tv_title);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
    }

    private void assignPageTitle() {
        tvTitle.setText(R.string.login_title);
    }

    private void initLoginButtonAction() {
        btnLogin.setText("Try it");
        btnLogin.setTextColor(getResources().getColor(white));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginButtonClicked();
            }
        });

        btnLogin.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d(tagName, "Button is Long Clicked");
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, "rishavchudal@ismt.edu.np");
                intent.putExtra(Intent.EXTRA_SUBJECT, "This is a dummy message");
                intent.putExtra(Intent.EXTRA_TEXT, "Dummy test message");
                startActivity(intent);
                return true;
            }
        });
    }

    private void onLoginButtonClicked() {
        Log.d(tagName, "Button is clicked");
        String email = etEmail.getText().toString().trim();
        Log.d(tagName, "Email ::: " + email);
        String password = etPassword.getText().toString().trim();
        Log.d(tagName, "Password ::: " + password);
        loginViewModel.validateLoginCredentials(email, password);
    }

    private void observeMutableLiveData() {
        observeIsEmailOrPasswordEmptyLiveData();
        observeIsEmailIncorrect();
        observeIsPasswordIncorrectLiveData();
        observeIsLoginSuccessLiveData();
    }

    private void observeIsEmailOrPasswordEmptyLiveData() {
        loginViewModel.isEmailOrPasswordEmpty.observe(
                LoginMvvmActivity.this,
                new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isEmpty) {
                if (isEmpty) {
                    Log.i(tagName, "observeIsEmailOrPasswordEmptyLiveData: " + isEmpty);
                    Toast.makeText(LoginMvvmActivity.this, "Email or Password is Empty", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void observeIsEmailIncorrect() {
        loginViewModel.isEmailIncorrect.observe(
                LoginMvvmActivity.this,
                new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean isEmailIncorrect) {
                        if (isEmailIncorrect) {
                            Toast.makeText(
                                    LoginMvvmActivity.this,
                                    "Email is incorrect",
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                });
    }

    private void observeIsPasswordIncorrectLiveData() {
        loginViewModel.isPasswordIncorrect.observe(
                LoginMvvmActivity.this,
                new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean isPasswordIncorrect) {
                        if (isPasswordIncorrect) {
                            Toast.makeText(
                                    LoginMvvmActivity.this,
                                    "Password is incorrect",
                                    Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                });
    }

    private void observeIsLoginSuccessLiveData() {
        loginViewModel.isLoginSuccess.observe(
                LoginMvvmActivity.this,
                new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean isLoginSuccess) {
                        if (isLoginSuccess) {
                            Toast.makeText(
                                    LoginMvvmActivity.this,
                                    "Login Success",
                                    Toast.LENGTH_SHORT
                            ).show();
                            startDashboard();
                        }
                    }
                });
    }

    private void startDashboard() {
        Intent intent = new Intent(LoginMvvmActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }


}
