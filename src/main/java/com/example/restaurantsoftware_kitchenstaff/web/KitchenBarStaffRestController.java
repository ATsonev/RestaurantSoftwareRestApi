package com.example.restaurantsoftware_kitchenstaff.web;

import com.example.restaurantsoftware_kitchenstaff.model.dto.AddKitchenBarStaffDTO;
import com.example.restaurantsoftware_kitchenstaff.model.dto.KitchenBarStaffDto;
import com.example.restaurantsoftware_kitchenstaff.service.KitchenBarStaffService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/kitchen-bar-staff")
public class KitchenBarStaffRestController {

    private final KitchenBarStaffService kitchenBarStaffService;

    public KitchenBarStaffRestController(KitchenBarStaffService kitchenBarStaffService) {
        this.kitchenBarStaffService = kitchenBarStaffService;
    }


    @PostMapping
    public ResponseEntity<KitchenBarStaffDto> addKitchenBarStaff(@RequestBody AddKitchenBarStaffDTO dto) {
        KitchenBarStaffDto save = kitchenBarStaffService.save(dto);
        return ResponseEntity.ok(save);
    }

    @GetMapping()
    public ResponseEntity<List<KitchenBarStaffDto>> getAllStaff() {
        return ResponseEntity.ok(kitchenBarStaffService.getAllStaff());
    }

    @PostMapping("/by-password")
    public ResponseEntity<KitchenBarStaffDto> getKitchenBarStaffByPassword(
            @RequestBody KitchenBarStaffDto dto) {
        Optional<KitchenBarStaffDto> kitchenBarStaffDto= kitchenBarStaffService.findByPassword(dto.getPassword());
        return kitchenBarStaffDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/delete-account/{id}")
    public ResponseEntity<List<KitchenBarStaffDto>> deleteAccount(@PathVariable Long id) {
        kitchenBarStaffService.deleteAccountById(id);
        List<KitchenBarStaffDto> updatedStaff = kitchenBarStaffService.getAllStaff();
        return ResponseEntity.ok(updatedStaff);
    }


}
