package com.example.cmsspringboot.service;

import org.springframework.stereotype.Service;
import com.example.cmsspringboot.mapper.MainMenuMapper;
import com.example.cmsspringboot.mapper.SubMenuMapper;
import com.example.cmsspringboot.dto.MainMenuRequest;
import com.example.cmsspringboot.model.MainMenu;
import com.example.cmsspringboot.model.SubMenu;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainMenuService {

    private final MainMenuMapper mainMenuMapper;
    private final SubMenuMapper subMenuMapper;

    public MainMenuService(MainMenuMapper mainMenuMapper, SubMenuMapper subMenuMapper) {
        this.mainMenuMapper = mainMenuMapper;
        this.subMenuMapper = subMenuMapper;
    }

    // Mengambil MainMenu dengan daftar SubMenu
    public List<MainMenuRequest> getAllMenusWithSubMenus() {
        List<MainMenu> mainMenus = mainMenuMapper.selectAllMenuFrontend();
        
        return mainMenus.stream()
                .map(menu -> new MainMenuRequest(menu, subMenuMapper.selectSubMenu(menu.getId())))
                .collect(Collectors.toList());
    }

    // Mengambil semua MainMenu
    public List<MainMenu> selectAll() {
        return mainMenuMapper.selectAll();
    }

    // Mengambil semua MainMenu untuk frontend
    public List<MainMenu> selectMenuFrontend() {
        return mainMenuMapper.selectAllMenuFrontend();
    }

    // Mencari MainMenu berdasarkan ID
    public MainMenu findMainMenuById(Long id) {
        return (MainMenu) mainMenuMapper.findMainMenuById(id);
    }

    // Menyimpan MainMenu baru
    public void saveMainMenu(MainMenu mainMenu) {
        mainMenuMapper.insertMainMenu(mainMenu);
    }

    // Mengupdate MainMenu berdasarkan ID
    public void updateMainMenu(MainMenu mainMenu, Long id) {
        mainMenuMapper.updateMainMenu(mainMenu, id);
    }

    // Menghapus MainMenu berdasarkan ID
    public void deleteMainMenu(Long id) {
        mainMenuMapper.deleteMainMenu(id);
    }
}
