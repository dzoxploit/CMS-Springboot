package com.example.cmsspringboot.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;

import com.example.cmsspringboot.model.MainMenu;

@Mapper
public interface MainMenuMapper {

    @Select("SELECT * FROM main_menu")
    List<MainMenu> selectAll();

    @Select("SELECT id, main_menu_name as name, main_menu_redirect as url FROM main_menu WHERE main_menu_status = 1")
    List<MainMenu> selectAllMenuFrontend();

    @Insert("INSERT INTO main_menu (main_menu_name, main_menu_desc, main_menu_status, main_menu_redirect) " +
            "VALUES (#{main_menu_name}, #{main_menu_desc}, #{main_menu_status}, #{main_menu_redirect})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertMainMenu(MainMenu mainMenu);

    @Update("UPDATE main_menu SET main_menu_name = #{main_menu_name}, main_menu_desc = #{main_menu_desc}, " +
            "main_menu_status = #{main_menu_status}, main_menu_redirect = #{main_menu_redirect} WHERE id = #{id}")
    void updateMainMenu(MainMenu mainMenu, Long id);

    @Delete("DELETE FROM main_menu WHERE id = #{id}")
    void deleteMainMenu(Long id);
}
