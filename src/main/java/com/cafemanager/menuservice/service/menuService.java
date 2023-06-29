package com.cafemanager.menuservice.service;

import com.cafemanager.menuservice.dto.MenuRequest;
import com.cafemanager.menuservice.dto.MenuResponse;
import com.cafemanager.menuservice.model.menu;
import com.cafemanager.menuservice.repository.MenuRepository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.awt.*;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class menuService {
    private final MenuRepository menuRepository;
    public void createProduct(MenuRequest menuRequest){
        menu product=menu.builder()
                .name(menuRequest.getName())
                .description(menuRequest.getDescription())
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
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();

    }
}


