package com.cafemanager.menuservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MenuResponse {
    private Long id;
    private String name;
    private String description;
    private float price;
}
