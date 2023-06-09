package com.sixsense.liargame.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SettingDto {
    private Integer id;
    private String title;
    private String mode;
    private String password;
    private Integer maxCount;
    private Integer timeout;
}
