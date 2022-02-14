package np.com.rishavchudal.test.login;

import static np.com.rishavchudal.test.R.color.white;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import np.com.rishavchudal.test.DashboardActivity;
import np.com.rishavchudal.test.R;

public class LoginActivity extends AppCompatActivity implements LoginViewInterface{
    private final static String tagName = "LoginActivity";
    private TextView tvTitle;
    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d(tagName, "On Create is called");
        assignPresenter();
        initViews();
        assignPageTitle();
        initLoginButtonAction();
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

    private void assignPresenter() {
        loginPresenter = new LoginPresenter(this);
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
        LoginModel loginModel = new LoginModel(email, password);
        loginPresenter.validateLoginCredentials(loginModel);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(this, "Do you want to exit?", Toast.LENGTH_SHORT).show();
    }

    private void startDashboard() {
        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public Context getViewContext() {
        return LoginActivity.this;
    }

    @Override
    public void showCredentialsAreEmpty() {
        Toast.makeText(this, "Email or Password is Empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmailIsIncorrect() {
        Toast.makeText(this, "Email is Incorrect", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPasswordIsIncorrect() {
        Toast.makeText(this, "Password is Incorrect", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDashboardPage() {
        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        startDashboard();
    }

    /*
        MVP - Model, View & Presenter
        MVVM - Model, View & View Model
     */
}