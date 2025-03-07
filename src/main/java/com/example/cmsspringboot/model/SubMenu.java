package com.example.cmsspringboot.model;

public class SubMenu {
 
    private Long id; 
    private String sub_menu_name;
    private String sub_menu_desc;
    private String sub_menu_redirect;
    private Boolean sub_menu_status;
    private Long main_menu_id;

    public SubMenu() {}

    public SubMenu(String sub_menu_name, String sub_menu_desc, String sub_menu_redirect, Boolean sub_menu_status, Long main_menu_id){
        this.sub_menu_name = sub_menu_name;
        this.sub_menu_desc = sub_menu_desc;
        this.sub_menu_redirect = sub_menu_redirect;
        this.sub_menu_status = sub_menu_status;
    }

    public Long getId() {
        return id;
    }

    public String getSubMenuName() {
        return sub_menu_name;
    }

    public void setSubMenuName(String sub_menu_name){
        this.sub_menu_name = sub_menu_name;
    }

    public String subMainMenuDesc() {
        return sub_menu_desc;
    }

    public void setSubMenuDesc(String sub_menu_desc){
        this.sub_menu_desc = sub_menu_desc;
    }

    public String getSubMenuRedirect() {
        return sub_menu_redirect;
    }

    public void setSubMenuRedirect(String sub_menu_redirect){
        this.sub_menu_redirect = sub_menu_redirect;
    }

    public Boolean getSubMenuStatus() {
        return sub_menu_status;
    }

    public void setSubMenuStatus(Boolean sub_menu_status){
        this.sub_menu_status = sub_menu_status;
    }

    public Long getMainMenuId() {
        return main_menu_id;
    }

    public void setMainMenuId(Long main_menu_id) {
        this.main_menu_id = main_menu_id;
    }
}
