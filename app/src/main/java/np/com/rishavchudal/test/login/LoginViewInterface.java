package np.com.rishavchudal.test.login;

import android.content.Context;

/**
 * Created by Rishav Chudal on 14/02/2022.
 */
public interface LoginViewInterface {
    Context getViewContext();

    void showCredentialsAreEmpty();

    void showEmailIsIncorrect();

    void showPasswordIsIncorrect();

    void showDashboardPage();
}
