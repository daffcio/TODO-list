package com.company.mainmenu;

import com.company.GenericView;
import java.util.Scanner;

public class MainMenuView implements GenericView {

    private int option;

    public void render() {
        System.out.println("Wybierz opcję");
        System.out.println("1.Rejestracja");
        System.out.println("2.Logowanie");
        System.out.println("3.Wyjście");

        Scanner reading = new Scanner(System.in);
        option = reading.nextInt();
    }

    public int getOption(){
        return  option;
    }
}
