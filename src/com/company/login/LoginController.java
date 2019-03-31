package com.company.login;

import com.company.GenericController;
import com.company.models.DataBase;
import com.company.util.Utils;

public class LoginController implements GenericController {

    private LoginView view = new LoginView();
    private DataBase dataBase = DataBase.getInstance();             // pobieram referencję na bazę danych
    private LoginStatus loginStatus = LoginStatus.NONE;

    public LoginController() {          // pusty konstruktor

    }

    public enum LoginStatus {
        OK,
        INCORRECT_LOGIN,
        INCORRECT_PASSWORD,
        NONE // status nieznany
    }

    public void executeView() {         // wykonanie widoku przez kontroler
        view.render();
    }

    // metoda sterująca przebiegiem logowania
    public void executeLoginProcess() {
        if(loginStatus == LoginStatus.OK) {
            view.showAlreadyLoggedInInformation();
        } else {
            while (loginStatus != LoginStatus.OK) {
                executeView();
                validateLoginData();
                if (loginStatus != LoginStatus.OK) {
                    view.displayLoginError(loginStatus);
                } else {
                    view.displaySuccessfulLoginInformation();
                }
            }
        }
    }

    // weryfikacja poprawnośći danych logowania
    private void validateLoginData() {
        if (!isLoginCorrect(view.getLogin())) {
            loginStatus = LoginStatus.INCORRECT_LOGIN;
        } else if (!isPasswordCorrect(view.getLogin(), view.getPassword())) {
            loginStatus = LoginStatus.INCORRECT_PASSWORD;
        } else {
            loginStatus = LoginStatus.OK;
        }
    }

    private boolean isLoginCorrect(String login) {
        return (login.length() > 0 && login.length() <= 32
                && Utils.isAlphanumeric(login)
                && dataBase.loginExists(login));
    }

    private boolean isPasswordCorrect(String login, String password) {
        return (password.length() > 0 && password.length() <= 32
                && Utils.isAlphanumeric(password)
                && dataBase.passwordMatches(login, password));
    }
}








































//    public void validateLoginData(){
//        while(loggedIn == false) {
//
//            User user = view.getLoginData();
//            if (dataBase.loginExists(user.getLogin())) {
//                if(dataBase.passwordMatches(user.getLogin(), user.getPassword())){
//                    loggedIn = true;
//                    loggedUser = dataBase.getUser(user.getLogin());
//                }
//                else {
//                    System.out.println("Błędne hasło");
//                    view.render();
//                }
//            }
//            else{
//                System.out.println("Błędny login"); // info, ze nie ma takiego loginu, wiec znowu zrob render
//                view.render();
//            }
//        }
//    }

