package com.example.cmsspringboot.service;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import com.example.cmsspringboot.mapper.SubMenuMapper;
import com.example.cmsspringboot.model.SubMenu;

import java.util.List;

@Service
public class SubMenuService {
    @Autowired

    private SubMenuMapper subMenuMapper;

    public List<SubMenu> selectAll(){
        return subMenuMapper.selectAll();
    }

    public List<SubMenu> selectMenuFrontend(Long id){
        return subMenuMapper.selectSubMenu(id);
    }

    public void saveMainMenu(SubMenu subMenu){
        subMenuMapper.insertSubMenu(subMenu);;
    }

    public void updateMainMenu(SubMenu subMenu, Long id){
        subMenuMapper.updateSubMenu(subMenu, id);;
    }

    public void deleteMainMenu(Long id){
        subMenuMapper.deleteSubMenu(id);
    }
}
