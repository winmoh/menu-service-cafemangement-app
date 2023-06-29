package com.cafemanager.menuservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value= "menu")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class menu {
    @Id

    private Long id;
    private  String name;
    private String description;
    private float price;
}
