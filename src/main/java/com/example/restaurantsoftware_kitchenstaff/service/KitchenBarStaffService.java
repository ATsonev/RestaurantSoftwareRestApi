package com.example.restaurantsoftware_kitchenstaff.service;

import com.example.restaurantsoftware_kitchenstaff.model.KitchenBarStaff;
import com.example.restaurantsoftware_kitchenstaff.model.dto.AddKitchenBarStaffDTO;
import com.example.restaurantsoftware_kitchenstaff.model.dto.KitchenBarStaffDto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface KitchenBarStaffService {
    KitchenBarStaffDto save(AddKitchenBarStaffDTO kitchenBarStaff);

    List<KitchenBarStaffDto> getAllStaff();

    Optional<KitchenBarStaffDto> findByPassword(String password);
}
