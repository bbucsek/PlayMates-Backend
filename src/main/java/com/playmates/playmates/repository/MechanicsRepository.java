package com.playmates.playmates.repository;

import com.playmates.playmates.model.Mechanics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MechanicsRepository extends JpaRepository<Mechanics, String> {

    Mechanics findMechanicsByName(String name);

}
