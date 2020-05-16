package com.javachinna.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javachinna.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
