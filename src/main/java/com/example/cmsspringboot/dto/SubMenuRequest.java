package com.example.cmsspringboot.dto;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SubMenuRequest {
    @NotBlank
    private String sub_menu_name;

    @Nullable
    private String sub_menu_desc;

    @NotBlank
    private String sub_menu_redirect;

    @NotBlank
    private Boolean sub_menu_status;

    @Nullable
    private String main_menu_id;
}

