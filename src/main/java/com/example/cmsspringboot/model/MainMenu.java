package com.example.cmsspringboot.model;

public class MainMenu {

    private Long id;
    private String main_menu_name;
    private String main_menu_desc;
    private String main_menu_redirect;
    private Boolean main_menu_status;

    // Default Constructor
    public MainMenu() {}

    // Parameterized Constructor
    public MainMenu(String main_menu_name, String main_menu_desc, String main_menu_redirect, Boolean main_menu_status) {
        this.main_menu_name = main_menu_name;
        this.main_menu_desc = main_menu_desc;
        this.main_menu_redirect = main_menu_redirect;
        this.main_menu_status = main_menu_status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainMenuName() {
        return main_menu_name;
    }

    public void setMainMenuName(String main_menu_name) {
        this.main_menu_name = main_menu_name;
    }

    public String getMainMenuDesc() {
        return main_menu_desc;
    }

    public void setMainMenuDesc(String main_menu_desc) {
        this.main_menu_desc = main_menu_desc;
    }

    public String getMainMenuRedirect() {
        return main_menu_redirect;
    }

    public void setMainMenuRedirect(String main_menu_redirect) {
        this.main_menu_redirect = main_menu_redirect;
    }

    public Boolean getMainMenuStatus() {
        return main_menu_status;
    }

    public void setMainMenuStatus(Boolean main_menu_status) {
        this.main_menu_status = main_menu_status;
    }

    // toString() Method (Optional, for debugging purposes)
    @Override
    public String toString() {
        return "MainMenu{" +
                "id=" + id +
                ", main_menu_name='" + main_menu_name + '\'' +
                ", main_menu_desc='" + main_menu_desc + '\'' +
                ", main_menu_redirect='" + main_menu_redirect + '\'' +
                ", main_menu_status=" + main_menu_status +
                '}';
    }
}