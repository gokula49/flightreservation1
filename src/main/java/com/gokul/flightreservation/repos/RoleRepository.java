package com.gokul.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gokul.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
