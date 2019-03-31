package com.company.models;

import java.util.ArrayList;

public class DataBase {

    private static DataBase dataBase = new DataBase();

    // nie mogę utworzyć więcej niż jednego obiektu danej klasy na zewnątrz
    // powinna istniec tylko jedna baza w programie, musimy zablokować dostep do tworzenia nowych baz danych
    // poniewaz chcemy tylko jedna bazę to trzymamy ja w tej samej klasie
    // udostepniamy jej referencje przez getInstance
    // nie pozwalamy na tworzenie nowej instacji poprzez modyfikacje konstruktora na prywatny

    private ArrayList<User> users = new ArrayList<User>(); // lista użytkowników

    private DataBase() { // prywatny pusty konstruktor - prywatny aby nie można było tworzyć obiektów z zewnątrz

    }

    public static DataBase getInstance()        // udostępniam referencję do bazy
    {
        return dataBase;
    }

    //przy rejestracji dodaję użytkownika do bazy
    public void addUser(User user)
    {
        users.add(user);
    }

    //wyszukiwanie istnienia loginu w bazie- wykorzystywane przy rejestracji
    public boolean loginExists(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login))
                return true;
        }
        return false;
    }

    // sprawdzenie czy dla danego loginu podane hasło się zgadza - wykorzystywane przy logowaniu
    public boolean passwordMatches(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }

    // wyświetlenie zawartości bazy
    public void showAllUsers() {
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}

































    /////////////////////////////////////////////////////

//    private ArrayList<Task> tasks = new ArrayList<Task>();
//    private ArrayList<String> categories = new ArrayList<String>();
//    // getter dla listy zadań - potrzebny do pózniejszego filtrowania i wyświetlania
//    public ArrayList<Task> getTasks() {
//        return tasks;
//    }
//
//    public void addTask(Task task){
//        tasks.add(task);
//    }
//
//    public void addCategory(String category){
//        categories.add(category);
//    }
//
//    // usuwanie
//    public void removeTask(int i){
//        tasks.remove(i);
//    }
//
//    public void removeUser(int i){
//        users.remove(i);
//    }
//
//    public void removeCategory(int i){
//        categories.remove(i);
//    }
//    // zakładam że uzytkownik jest w bazie, zwracam go
//    public User getUser(String login){
//        int n = users.size();
//        for(int i=0; i<n; i++){
//            if(users.get(i).getLogin().equals(login))
//                return users.get(i);
//        }
//        return null;
//    }


//wyszukiwanie tych rzeczy
//wszystkie notatki danego uzytkownika
//wyszukuje po tych rzeczach ktore chce