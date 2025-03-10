package com.example.cmsspringboot.dto;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SubMenuRequest {
    @NotBlank
    private String subMenuName;

    @Nullable
    private String subMenuDesc;

    @NotBlank
    private String subMenuRedirect;

    @NotBlank
    private Boolean subMenuStatus;

    @Nullable
    private Long mainMenuId;
}

