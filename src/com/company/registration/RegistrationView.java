package com.company.registration;

import com.company.GenericView;
import com.company.registration.RegistrationController.RegistrationStatus;
import com.company.models.User;

import java.util.Scanner;

public class RegistrationView implements GenericView {

    private String name;
    private String surname;
    private String login;
    private String password;

    public RegistrationView() { // pusty kontruktor

    }

    public void render(){                                       // prowadzi dialog z użytkownikiem przy rejestracji
        Scanner reading = new Scanner(System.in);

        System.out.println("Rejestracja");

        System.out.println("Podaj imię");
        name = reading.nextLine();

        System.out.println("Podaj nazwisko");
        surname = reading.nextLine();

        System.out.println("Podaj login");
        login = reading.nextLine();

        System.out.println("Podaj hasło");
        password = reading.nextLine();
    }

    public void displayRegistrationError(RegistrationStatus registrationStatus){
        switch (registrationStatus){
            case USER_EXISTS:
                System.out.println("Użytkownik o podanym loginie istnieje już w bazie");
                break;
            case INCORRECT_INPUT:
                System.out.println("Podane dane zawierają niepoprawne znaki");
                break;
            case INPUT_LENGTH_INCORRECT:
                System.out.println("Wprowadziłeś puste lub za duże dane");
                break;
        }
    }

    public void displaySuccessfulRegistrationInformation(){
        System.out.println("Rejestracja zakończona powodzeniem");
    }

    // zwraca kontrolerowi dane wprowadzone przez użtkownika
    public User getUserRegistrationData(){
        User user = new User(name,surname,login,password);
        return user;
    }
}



























//views
// registration,login, mainmenu, taskdetails, dialog(czy na pewno chcesz coś zrobić)
// login+haslo(getery metoda execute view, interfejs viewable metodę execute view)

// brak obsugi bledow
//wykonanie systemu
//        wyswietlanie stringow ,
//zapisa danych w odpowiednie miejsca , obsługa błędów, imie nie powinno zawierać cyfr
//pyta sie,  w zmiennych przechowuje informacje ktore pobierze

//render nie zwraca nie bierze,
//wpisuje to w te pola
//spytać się pobrać , spytac się pobrać, dopóki użytkownik nie poda danych

//2.
//getter utworzy nowego usera w sobie ustawia parametry zwraca go , gert register user
//druga zwraca tego uzytkownika, get register user

//pozwala na pobranie kontrolerowu danych rejestracji ktore zostały podane przez użytkownika