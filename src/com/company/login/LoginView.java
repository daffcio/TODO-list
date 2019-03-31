package com.company.login;

import com.company.GenericView;
import com.company.login.LoginController.LoginStatus;
import java.util.Scanner;

public class LoginView implements GenericView {

    private String login;
    private String password;

    public LoginView() {        // pusty konstruktor
    }

    public void render(){                               // funkcja prowadząca dialog z użytkownikiem
        Scanner reading = new Scanner(System.in);

        System.out.println("Logowanie");

        System.out.println("Podaj login");
        login = reading.nextLine();

        System.out.println("Podaj hasło");
        password = reading.nextLine();

    }

    // wypisuje błąd zaistaniały przy logowaniu
    public void displayLoginError(LoginStatus loginStatus){
        switch (loginStatus){
            case INCORRECT_LOGIN:
                System.out.println("Niepoprawny login");
                break;
            case INCORRECT_PASSWORD:
                System.out.println("Niepoprawne hasło");
                break;
        }
    }

    // wypisanie informacji o udanym zalogowaniu sie
    public void displaySuccessfulLoginInformation(){
        System.out.println("Zostałeś zalogowany");
    }

    // wypisuje komunikat że użytkownik jest już zalogowany, gdyby chciał zalogować się jeszcze raz
    public void showAlreadyLoggedInInformation() {
        System.out.println("Już jesteś zalogowany!");
    }

    // za ich pomocą kontroler pobiera dane podane przez użytkownika
    public String getLogin(){
        return login;
    }

    public String getPassword(){
        return password;
    }
}
