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

    public List<SubMenu> selectSubMenuFrontend(Long id){
        return subMenuMapper.selectSubMenu(id);
    }

    public void saveSubMenu(SubMenu subMenu){
        subMenuMapper.insertSubMenu(subMenu);;
    }

    public void updateSubMenu(SubMenu subMenu, Long id){
        subMenuMapper.updateSubMenu(subMenu, id);;
    }

    public void deleteSubMenu(Long id){
        subMenuMapper.deleteSubMenu(id);
    }
}
