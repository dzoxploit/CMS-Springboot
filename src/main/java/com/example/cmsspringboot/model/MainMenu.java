package com.example.cmsspringboot.model;

public class MainMenu {
 
    private Long id; 
    private String main_menu_name;
    private String main_menu_desc;
    private String main_menu_redirect;
    private Boolean main_menu_status;

    public MainMenu() {}

    public MainMenu(String main_menu_name, String main_menu_desc, String main_menu_redirect, Boolean main_menu_status ){
        this.main_menu_name = main_menu_name;
        this.main_menu_desc = main_menu_desc;
        this.main_menu_redirect = main_menu_redirect;
        this.main_menu_status = main_menu_status;
    }

    public Long getId() {
        return id;
    }

    public String getMainMenuName() {
        return main_menu_name;
    }

    public void setMainMenuName(String main_menu_name){
        this.main_menu_name = main_menu_name;
    }

    public String getMainMenuDesc() {
        return main_menu_desc;
    }

    public void setMainMenuDesc(String main_menu_desc){
        this.main_menu_desc = main_menu_desc;
    }

    public String getMainMenuRedirect() {
        return main_menu_redirect;
    }

    public void setMainMenuRedirect(String main_menu_redirect){
        this.main_menu_redirect = main_menu_redirect;
    }

    public Boolean getMainMenuStatus() {
        return main_menu_status;
    }

    public void setMainMenuStatus(Boolean main_menu_status){
        this.main_menu_status = main_menu_status;
    }
}
