package com.manssi.authapisisdm.dao;

import com.manssi.authapisisdm.models.Role;
import com.manssi.authapisisdm.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);
}
