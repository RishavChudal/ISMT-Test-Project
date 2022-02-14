package np.com.rishavchudal.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(this, "Do you want to exit?", Toast.LENGTH_SHORT).show();
    }
}