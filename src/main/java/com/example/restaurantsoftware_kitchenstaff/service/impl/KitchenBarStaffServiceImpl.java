package com.example.restaurantsoftware_kitchenstaff.service.impl;

import com.example.restaurantsoftware_kitchenstaff.model.KitchenBarStaff;
import com.example.restaurantsoftware_kitchenstaff.model.dto.AddKitchenBarStaffDTO;
import com.example.restaurantsoftware_kitchenstaff.model.dto.KitchenBarStaffDto;
import com.example.restaurantsoftware_kitchenstaff.model.enums.Role;
import com.example.restaurantsoftware_kitchenstaff.repository.KitchenBarStaffRepository;
import com.example.restaurantsoftware_kitchenstaff.service.KitchenBarStaffService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class KitchenBarStaffServiceImpl implements KitchenBarStaffService {

    private final KitchenBarStaffRepository kitchenBarStaffRepository;
    private final PasswordEncoder passwordEncoder;

    public KitchenBarStaffServiceImpl(KitchenBarStaffRepository kitchenBarStaffRepository, PasswordEncoder passwordEncoder) {
        this.kitchenBarStaffRepository = kitchenBarStaffRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public KitchenBarStaffDto save(AddKitchenBarStaffDTO dto) {
        KitchenBarStaff kitchenBarStaff = new KitchenBarStaff();
        kitchenBarStaff.setStaff(Role.valueOf(dto.getStaff().toUpperCase()));
        kitchenBarStaff.setPassword(passwordEncoder.encode(dto.getPassword()));
        kitchenBarStaffRepository.save(kitchenBarStaff);
        return new KitchenBarStaffDto(kitchenBarStaff.getId(), kitchenBarStaff.getStaff().toString(),
                kitchenBarStaff.getPassword());
    }

    @Override
    public List<KitchenBarStaffDto> getAllStaff() {
        return kitchenBarStaffRepository.findAll().stream()
                .map(KitchenBarStaffServiceImpl::convertToDto).toList();
    }

    @Override
    public Optional<KitchenBarStaffDto> findByPassword(String password) {
        for (KitchenBarStaff kitchenBarStaff : kitchenBarStaffRepository.findAll()) {
            if(passwordEncoder.matches(password, kitchenBarStaff.getPassword())) {
                return Optional.of(convertToDto(kitchenBarStaff));
            }
        }
        return Optional.empty();
    }

    @Override
    public void deleteAccountById(Long id) {
        kitchenBarStaffRepository.deleteById(id);
    }

    private static KitchenBarStaffDto convertToDto(KitchenBarStaff kitchenBarStaff) {
        KitchenBarStaffDto dto = new KitchenBarStaffDto();
        dto.setId(kitchenBarStaff.getId());
        dto.setStaff(kitchenBarStaff.getStaff().toString());
        dto.setPassword(kitchenBarStaff.getPassword());
        return dto;
    }
}
