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
    private int id;
    private String name;
    private String category;
    private float price;
}
