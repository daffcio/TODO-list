package com.company;

import com.company.registration.RegistrationController;
import com.company.login.LoginController;
import com.company.mainmenu.MainMenuController;
import com.company.models.Action;
import com.company.models.DataBase;
import com.company.models.User;

public class Main {

    private static RegistrationController registrationController = new RegistrationController();
    private static LoginController loginController = new LoginController();
    private static MainMenuController mainMenuController = new MainMenuController();
    private static Action action = Action.MAIN_MENU;
    private static DataBase dataBase = DataBase.getInstance();

    public static void main(String[] args) {

        //testowanie
        User user = new User("Dawid", "Kulma", "dawidek123", "ala123");
        dataBase.addUser(user);
        System.out.println("Stan bazy danych");
        dataBase.showAllUsers();

        while (action != Action.EXIT) {
            switch (action) {
                case MAIN_MENU:
                    mainMenuController.executeView();
                    action = mainMenuController.handleOption();
                    break;
                case REGISTER:
                    registrationController.executeRegistrationProcess();
                    action = Action.LOGIN;
                    break;
                case LOGIN:
                    loginController.executeLoginProcess();
                    action = Action.MAIN_MENU;
                    break;
                case INCORRECT_INPUT:
                    System.out.println("Zła opcja");
                    action = Action.MAIN_MENU;
                    break;
            }
        }
        System.out.println("Koniec programu");
    }
}
















// w statycznej metodzie main mozna korzystac tylko ze statycznych pól
// każdy program w javie powinien mieć punkt startowy -
// jest on wywoływany w statyczny sposób ponieważ nie ma potrzeby istancjacji głównej klasy ktora jest wywoływana


//   public void a(){
//     loginController;
//}
//        registrationController.executeRegistrationProcess();
//        System.out.println("\nStan bazy danych");
//        dataBase.showAllUsers();