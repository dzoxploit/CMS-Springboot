package com.example.cmsspringboot.controller;

import com.example.cmsspringboot.dto.MainMenuRequest;
import com.example.cmsspringboot.model.MainMenu;
import com.example.cmsspringboot.service.MainMenuService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("main-menus")
public class MainMenuController {
    private final MainMenuService mainMenuService;

    public MainMenuController(MainMenuService mainMenuService) {
        this.mainMenuService = mainMenuService;
    }

    @GetMapping
    public Map<String, Object> getMainMenu() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<MainMenu> mainMenus = mainMenuService.selectAll();

            response.put("status", HttpStatus.ACCEPTED);
            response.put("message", "Main menus data retrieved successfully");
            response.put("data", mainMenus);

        } catch (Exception e) {
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
            response.put("message", "Error: " + e.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getMainMenuById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<MainMenu> mainMenu = mainMenuService.findMainMenuById(id);
            if (mainMenu != null) {
                response.put("status", 200);
                response.put("message", "Main menu found successfully");
                response.put("data", mainMenu);
            } else {
                response.put("status", 404);
                response.put("message", "Main menu not found");
            }
        } catch (Exception e) {
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
            response.put("message", "Error: " + e.getMessage());
        }
        return response;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody MainMenuRequest request) {
        try {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setMainMenuName(request.getMainMenuName());
            mainMenu.setMainMenuDesc(request.getMainMenuDesc());
            mainMenu.setMainMenuRedirect(request.getMainMenuRedirect());
            mainMenu.setMainMenuStatus(request.getMainMenuStatus());
    
            mainMenuService.saveMainMenu(mainMenu);
            return ResponseEntity.ok("Main menu successfully created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Error: " + e.getMessage());
        }
    }
    
    @PostMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody MainMenuRequest request, @PathVariable Long id) {
        try {
            MainMenu mainMenu = new MainMenu();
            mainMenu.setMainMenuName(request.getMainMenuName());
            mainMenu.setMainMenuDesc(request.getMainMenuDesc());
            mainMenu.setMainMenuRedirect(request.getMainMenuRedirect());
            mainMenu.setMainMenuStatus(request.getMainMenuStatus());
    
            mainMenuService.updateMainMenu(mainMenu, id);
            return ResponseEntity.ok("Main menu successfully updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            mainMenuService.deleteMainMenu(id);
            return ResponseEntity.ok("Main menu successfully deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Error: " + e.getMessage());
        }
    }
}