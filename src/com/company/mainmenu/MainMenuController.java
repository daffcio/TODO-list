package com.company.mainmenu;

import com.company.GenericController;
import com.company.models.Action;

public class MainMenuController implements GenericController {

    private  Action action = Action.MAIN_MENU;
    private MainMenuView view = new MainMenuView();

    @Override
    public void executeView() {
        view.render();
    }

    public Action handleOption(){
        int option = view.getOption();
        switch (option){
            case 1:
                return Action.REGISTER;
            case 2:
                return Action.LOGIN;
            case 3:
                return Action.EXIT;
            default :
                return Action.INCORRECT_INPUT;
        }
    }

}
