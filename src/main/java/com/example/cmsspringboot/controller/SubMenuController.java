package com.example.cmsspringboot.controller;

import com.example.cmsspringboot.dto.SubMenuRequest;
import com.example.cmsspringboot.model.SubMenu;
import com.example.cmsspringboot.service.SubMenuService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sub-menus")
public class SubMenuController {

    private final SubMenuService subMenuService;

    public SubMenuController(SubMenuService subMenuService) {
        this.subMenuService = subMenuService;
    }

    // Get all sub-menus
    @GetMapping
    public Map<String, Object> getAllSubMenus() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<SubMenu> subMenus = subMenuService.selectAll();
            response.put("status", HttpStatus.OK);
            response.put("message", "Sub-menus retrieved successfully");
            response.put("data", subMenus);
        } catch (Exception e) {
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
            response.put("message", "Error: " + e.getMessage());
        }
        return response;
    }

    // Get sub-menu by ID
    @GetMapping("/{id}")
    public Map<String, Object> getSubMenuById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<SubMenu> subMenus = subMenuService.selectSubMenuFrontend(id);
            if (!subMenus.isEmpty()) {
                response.put("status", HttpStatus.OK);
                response.put("message", "Sub-menu found successfully");
                response.put("data", subMenus);
            } else {
                response.put("status", HttpStatus.NOT_FOUND);
                response.put("message", "Sub-menu not found");
            }
        } catch (Exception e) {
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
            response.put("message", "Error: " + e.getMessage());
        }
        return response;
    }

    // Create a new sub-menu
    @PostMapping("/create")
    public ResponseEntity<String> createSubMenu(@RequestBody SubMenuRequest request) {
        try {
            SubMenu subMenu = new SubMenu();
            subMenu.setSubMenuName(request.getSubMenuName());
            subMenu.setSubMenuDesc(request.getSubMenuDesc());
            subMenu.setSubMenuRedirect(request.getSubMenuRedirect());
            subMenu.setSubMenuStatus(request.getSubMenuStatus());
            subMenu.setMainMenuId(request.getMainMenuId()); // Assuming SubMenu has a mainMenuId field

            subMenuService.saveSubMenu(subMenu);
            return ResponseEntity.ok("Sub-menu created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Error: " + e.getMessage());
        }
    }

    // Update an existing sub-menu
    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateSubMenu(@RequestBody SubMenuRequest request, @PathVariable Long id) {
        try {
            SubMenu subMenu = new SubMenu();
            subMenu.setSubMenuName(request.getSubMenuName());
            subMenu.setSubMenuDesc(request.getSubMenuDesc());
            subMenu.setSubMenuRedirect(request.getSubMenuRedirect());
            subMenu.setSubMenuStatus(request.getSubMenuStatus());
            subMenu.setMainMenuId(request.getMainMenuId()); // Assuming SubMenu has a mainMenuId field

            subMenuService.updateSubMenu(subMenu, id);
            return ResponseEntity.ok("Sub-menu updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Error: " + e.getMessage());
        }
    }

    // Delete a sub-menu by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSubMenu(@PathVariable Long id) {
        try {
            subMenuService.deleteSubMenu(id);
            return ResponseEntity.ok("Sub-menu deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Error: " + e.getMessage());
        }
    }
}