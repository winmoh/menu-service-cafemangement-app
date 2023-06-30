package com.cafemanager.menuservice.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@RequiredArgsConstructor
@Data
@Document(collection="menu_sequence")
public class menuSequence {
    @Id
    private String id;
    private int seq;
}
