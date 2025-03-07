package com.example.cmsspringboot.dto;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MainMenuRequest {
    @NotBlank
    private String main_menu_name;

    @Nullable
    private String main_menu_desc;

    @NotBlank
    private String main_menu_redirect;

    @NotBlank
    private Boolean main_menu_status;
}

