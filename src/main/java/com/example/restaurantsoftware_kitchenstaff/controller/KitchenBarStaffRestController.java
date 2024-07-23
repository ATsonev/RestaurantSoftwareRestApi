package com.example.restaurantsoftware_kitchenstaff.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.restaurantsoftware_kitchenstaff.service.KitchenBarStaffService;

@RestController
@RequestMapping("/api/staff")
public class KitchenBarStaffRestController {

    private final KitchenBarStaffService kitchenBarStaffService;

    public KitchenBarStaffRestController(KitchenBarStaffService kitchenBarStaffService) {
        this.kitchenBarStaffService = kitchenBarStaffService;
    }
}
