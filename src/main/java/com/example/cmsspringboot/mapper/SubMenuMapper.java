package com.example.cmsspringboot.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;

import com.example.cmsspringboot.model.SubMenu;

@Mapper
public interface SubMenuMapper {

    @Select("SELECT * FROM sub_menu")
    List<SubMenu> selectAll();

    @Select("SELECT id, sub_menu_name as name, sub_menu_redirect as url FROM sub_menu WHERE sub_menu_status = 1 AND main_menu_id = #{id}")
    List<SubMenu> selectSubMenu(Long id);

    @Insert("INSERT INTO sub_menu (sub_menu_name, sub_menu_desc, sub_menu_status, sub_menu_redirect) " +
            "VALUES (#{sub_menu_name}, #{sub_menu_desc}, #{sub_menu_status}, #{sub_menu_redirect})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertSubMenu(SubMenu subMenu);

    @Update("UPDATE sub_menu SET sub_menu_name = #{sub_menu_name}, sub_menu_desc = #{sub_menu_desc}, " +
            "sub_menu_status = #{sub_menu_status}, sub_menu_redirect = #{sub_menu_redirect} WHERE id = #{id}")
    void updateSubMenu(SubMenu subMenu, Long id);

    @Delete("DELETE FROM sub_menu WHERE id = #{id}")
    void deleteSubMenu(Long id);
}
