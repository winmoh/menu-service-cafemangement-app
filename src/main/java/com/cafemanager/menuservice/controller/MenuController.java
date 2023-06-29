package com.cafemanager.menuservice.controller;

import com.cafemanager.menuservice.dto.MenuRequest;
import com.cafemanager.menuservice.dto.MenuResponse;
import com.cafemanager.menuservice.service.menuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menu")
public class MenuController {
    private final menuService mnService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody MenuRequest menuRequest){
        mnService.createProduct(menuRequest);


    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MenuResponse>  getMenu(){
        return mnService.getMenu();

    }


}
