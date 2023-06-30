package com.cafemanager.menuservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value= "menu")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class menu {

    @Transient
    public static final String sequence_name="products_sequence";
    @Id
    private int id;
    private  String name;
    private String category;
    private float price;
}
