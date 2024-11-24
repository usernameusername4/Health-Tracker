package com.healthtracker.service;

import com.healthtracker.model.ExerciseLog;
import com.healthtracker.model.WaterIntake;
import com.healthtracker.repository.ExerciseLogRepository;
import com.healthtracker.repository.WaterIntakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HealthTrackerService {

    @Autowired
    private ExerciseLogRepository exerciseLogRepository;

    @Autowired
    private WaterIntakeRepository waterIntakeRepository;

    // ===================== GET Methods =====================

    // Get all Exercises
    public Iterable<ExerciseLog> getAllExercises() {
        return exerciseLogRepository.findAll();
    }

    // Get Exercise by ID
    public ExerciseLog getExerciseById(Long id) {
        return exerciseLogRepository.findById(id).orElse(null);
    }

    // Get all Water Intakes
    public Iterable<WaterIntake> getAllWaterIntakes() {
        return waterIntakeRepository.findAll();
    }

    // Get Water Intake by ID
    public WaterIntake getWaterIntakeById(Long id) {
        return waterIntakeRepository.findById(id).orElse(null);
    }

    // ===================== POST Methods =====================

    // Log Exercise
    public ExerciseLog logExercise(String exerciseType, int durationMinutes) {
        ExerciseLog exerciseLog = new ExerciseLog(exerciseType, durationMinutes, java.time.LocalDateTime.now());
        return exerciseLogRepository.save(exerciseLog);
    }

    // Log Water Intake
    public WaterIntake logWaterIntake(int amountMl) {
        WaterIntake waterIntake = new WaterIntake(amountMl, java.time.LocalDateTime.now());
        return waterIntakeRepository.save(waterIntake);
    }

    // ===================== PUT Methods =====================

    // Update Exercise log by ID
    public ExerciseLog updateExercise(Long id, ExerciseLog updatedExerciseLog) {
        Optional<ExerciseLog> existingExerciseLog = exerciseLogRepository.findById(id);
        if (existingExerciseLog.isPresent()) {
            ExerciseLog exerciseLog = existingExerciseLog.get();
            exerciseLog.setExerciseType(updatedExerciseLog.getExerciseType());
            exerciseLog.setDurationMinutes(updatedExerciseLog.getDurationMinutes());
            return exerciseLogRepository.save(exerciseLog);
        } else {
            return null;
        }
    }

    // Update Water Intake log by ID
    public WaterIntake updateWaterIntake(Long id, WaterIntake updatedWaterIntake) {
        Optional<WaterIntake> existingWaterIntake = waterIntakeRepository.findById(id);
        if (existingWaterIntake.isPresent()) {
            WaterIntake waterIntake = existingWaterIntake.get();
            waterIntake.setAmountMl(updatedWaterIntake.getAmountMl());
            return waterIntakeRepository.save(waterIntake);
        } else {
            return null;
        }
    }
}