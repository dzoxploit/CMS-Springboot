package com.example.cmsspringboot.dto;

import com.example.cmsspringboot.model.MainMenu;
import com.example.cmsspringboot.model.SubMenu;
import lombok.Data;

import java.util.List;

@Data
public class MainMenuRequest {
    private Long id;
    private String mainMenuName;
    private String mainMenuDesc;
    private String mainMenuRedirect;
    private Boolean mainMenuStatus;
    private List<SubMenu> subMenus;

    public MainMenuRequest(MainMenu mainMenu, List<SubMenu> subMenus) {
        this.id = mainMenu.getId();
        this.mainMenuName = mainMenu.getMainMenuName();
        this.mainMenuDesc = mainMenu.getMainMenuDesc();
        this.mainMenuRedirect = mainMenu.getMainMenuRedirect();
        this.mainMenuStatus = mainMenu.getMainMenuStatus();
        this.subMenus = subMenus;
    }
}
