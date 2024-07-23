package com.example.restaurantsoftware_kitchenstaff.repository;

import com.example.restaurantsoftware_kitchenstaff.model.KitchenBarStaff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KitchenBarStaffRepository extends JpaRepository<KitchenBarStaff, Long> {
    Optional<KitchenBarStaff> findByPassword(String password);
}
