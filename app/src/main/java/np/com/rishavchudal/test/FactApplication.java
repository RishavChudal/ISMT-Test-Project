package np.com.rishavchudal.test;

import android.app.Application;

/**
 * Created by Rishav Chudal on 24/03/2022.
 */
public class FactApplication extends Application {
    private static Application INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public static Application getFactApplicationContext() {
        return INSTANCE;
    }
}
