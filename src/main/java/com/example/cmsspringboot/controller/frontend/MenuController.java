package com.example.cmsspringboot.controller.frontend;


import com.example.cmsspringboot.dto.MainMenuRequest;
import com.example.cmsspringboot.model.MainMenu;
import com.example.cmsspringboot.service.MainMenuService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuController {


    private final MainMenuService mainMenuService;

    public MenuController(MainMenuService mainMenuService) {
        this.mainMenuService = mainMenuService;
    }

    @GetMapping
    public Map<String, Object> getMainMenu() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<MainMenuRequest> mainMenus = mainMenuService.getAllMenusWithSubMenus();

            response.put("status", HttpStatus.ACCEPTED);
            response.put("message", "Main menus data retrieved successfully");
            response.put("data", mainMenus);

        } catch (Exception e) {
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
            response.put("message", "Error: " + e.getMessage());
        }
        return response;
    }
    
}
