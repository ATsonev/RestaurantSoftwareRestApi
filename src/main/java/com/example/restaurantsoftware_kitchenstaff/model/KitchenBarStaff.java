package com.example.restaurantsoftware_kitchenstaff.model;

import com.example.restaurantsoftware_kitchenstaff.model.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "kitchen_bar_staff")
public class KitchenBarStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role staff;
    private String password;

    public KitchenBarStaff() {
    }

    public KitchenBarStaff(Role staff, String password) {
        this.staff = staff;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getStaff() {
        return staff;
    }

    public void setStaff(Role staff) {
        this.staff = staff;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
