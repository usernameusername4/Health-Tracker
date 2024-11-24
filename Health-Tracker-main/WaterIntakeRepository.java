package com.healthtracker.repository;

import com.healthtracker.model.WaterIntake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterIntakeRepository extends JpaRepository<WaterIntake, Long> {
}