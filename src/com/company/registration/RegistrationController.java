package com.company.registration;

import com.company.GenericController;
import com.company.models.DataBase;
import com.company.models.User;
import com.company.util.Utils;

public class RegistrationController implements GenericController {

    private RegistrationView view = new RegistrationView();
    private DataBase dataBase = DataBase.getInstance();
    private RegistrationStatus registrationStatus = RegistrationStatus.NONE;
    private User registeringUser;

    public RegistrationController() {       // pusty konstruktor

    }

    public enum RegistrationStatus{
        OK,
        INCORRECT_INPUT,
        USER_EXISTS,
        INPUT_LENGTH_INCORRECT,
        NONE // status nieznany
    }

    public void executeView(){
        view.render();
    }

    // kieruje procesem rejestracji
    public void executeRegistrationProcess(){
        while(registrationStatus != RegistrationStatus.OK){
            executeView();
            registeringUser = view.getUserRegistrationData();
            validateUserData();
            if(registrationStatus != RegistrationStatus.OK){
                view.displayRegistrationError(registrationStatus);
            }
            else {
                addUser();
                view.displaySuccessfulRegistrationInformation();
            }
        }
    }

    private void validateUserData(){
        if( !isUserInputLengthCorrect(registeringUser)){
            registrationStatus = RegistrationStatus.INPUT_LENGTH_INCORRECT;
        }
        else if( !isUserInputCorrect(registeringUser)){
            registrationStatus = RegistrationStatus.INCORRECT_INPUT;
        }
        else if( userExists(registeringUser) ){
            registrationStatus = RegistrationStatus.USER_EXISTS;
        }
        else {
            registrationStatus = RegistrationStatus.OK;
        }
    }

    private boolean isUserInputLengthCorrect(User user){
        return ( user.getName().length() > 0 && user.getName().length() <= 32
                && user.getSurname().length() > 0 && user.getSurname().length() <= 32
                && user.getLogin().length() > 0 && user.getLogin().length() <= 32
                && user.getPassword().length() > 0 && user.getPassword().length() <= 32);
    }

    private boolean isUserInputCorrect(User user){
        return ( Utils.isAlpha(user.getName())
                && Utils.isAlpha(user.getSurname())
                && Utils.isAlphanumeric(user.getLogin())
                && Utils.isAlphanumeric(user.getPassword()));
    }
    private boolean userExists(User user){

        return dataBase.loginExists(user.getLogin());
    }

    private void addUser(){
        dataBase.addUser(registeringUser);
    }
}

























//executeview
//validate date - pobrane z widoku -> boolean
//wyswietla widok, pobranie z tego widoku, zapis i odczyt z bazy ,
//wywołanie widoku jeszcze raz przy loginie,

//kotrolery połączone w klasie jednej , zwracaja stan programu

//chyba nie robię
//abstakcyjna klasa view i kontrolel lub interfejsy - mogą posiadać dwie metudy :
//dla widoku