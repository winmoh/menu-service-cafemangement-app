package com.cafemanager.menuservice.service;

import com.cafemanager.menuservice.dto.MenuRequest;
import com.cafemanager.menuservice.dto.MenuResponse;
import com.cafemanager.menuservice.model.menu;
import com.cafemanager.menuservice.repository.MenuRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.awt.*;
import java.util.List;

import static com.cafemanager.menuservice.model.menu.sequence_name;

@Service
@RequiredArgsConstructor
@Slf4j

public class menuService {
    private final MenuRepository menuRepository;
    @Autowired
    private SequenceGeneratorService service;

    public void createProduct(MenuRequest menuRequest){
        menu product=menu.builder()
                .id(service.getSequenceNumber(sequence_name))
                .name(menuRequest.getName())
                .category(menuRequest.getCategory())
                .price(menuRequest.getPrice())
                .build();
        menuRepository.save(product);
        log.info("product {} is saved",product.getId());


    }

    public List<MenuResponse> getMenu(){
        List<menu> menuProducts =menuRepository.findAll();
        return menuProducts.stream().map(this::mapToMenuResponse).toList();



    }
    public MenuResponse mapToMenuResponse(menu product){
        return MenuResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .price(product.getPrice())
                .build();

    }
}


