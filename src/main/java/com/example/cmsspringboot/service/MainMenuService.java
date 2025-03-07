package com.example.cmsspringboot.service;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import com.example.cmsspringboot.mapper.MainMenuMapper;
import com.example.cmsspringboot.model.MainMenu;

import java.util.List;

@Service
public class MainMenuService {
    @Autowired

    private MainMenuMapper mainMenuMapper;

    public List<MainMenu> selectAll(){
        return mainMenuMapper.selectAll();
    }

    public List<MainMenu> selectMenuFrontend(){
        return mainMenuMapper.selectAllMenuFrontend();
    }

    public void saveMainMenu(MainMenu mainMenu){
        mainMenuMapper.insertMainMenu(mainMenu);
    }

    public void updateMainMenu(MainMenu mainMenu, Long id){
        mainMenuMapper.updateMainMenu(mainMenu, id);
    }

    public void deleteMainMenu(Long id){
        mainMenuMapper.deleteMainMenu(id);
    }
}
