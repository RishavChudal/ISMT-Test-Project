package np.com.rishavchudal.test.login;


/**
 * Created by Rishav Chudal on 14/02/2022.
 */
class LoginPresenter {
    private final LoginViewInterface loginViewInterface;

    public LoginPresenter(LoginViewInterface loginViewInterface) {
        this.loginViewInterface = loginViewInterface;
    }

    public void validateLoginCredentials(LoginModel loginModel) {
        String emailAddress = loginModel.getEmailAddress();
        String password = loginModel.getPassword(); 
        if (emailAddress.isEmpty() || password.isEmpty()) {
            loginViewInterface.showCredentialsAreEmpty();
            return;
        }

        /**
         * In Case of Backend Connection
         */
        /*BackEndConnection backEndConnection = new BackEndConnection();
        LoginResponse loginResponse = backEndConnection.verifyLogin(loginModel);*/

        /**
         * In Case of DB Validation
         */
        /*DbConnection dbConnection = new DbConnection();
        LoginResponse loginResponse1 = dbConnection.verifyLogin(loginModel);*/

        if (!emailAddress.equalsIgnoreCase("rishav@ismt.edu.np")) {
            loginViewInterface.showEmailIsIncorrect();
            return;
        }

        if (!password.equals("12345")) {
            loginViewInterface.showPasswordIsIncorrect();
            return;
        }
        loginViewInterface.showDashboardPage();
    }
}
