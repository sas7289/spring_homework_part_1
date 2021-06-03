package com.example.lesson_8.repository;

import com.example.lesson_8.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, Long> {
}
