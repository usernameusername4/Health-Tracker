package com.healthtracker.controller;

import com.healthtracker.model.ExerciseLog;
import com.healthtracker.model.WaterIntake;
import com.healthtracker.service.HealthTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HealthTrackerController {

    @Autowired
    private HealthTrackerService healthTrackerService;

    // ===================== GET Methods =====================

    // Get all Exercises
    @GetMapping("/exercises")
    public Iterable<ExerciseLog> getAllExercises() {
        return healthTrackerService.getAllExercises();
    }

    // Get a specific Exercise by ID
    @GetMapping("/exercises/{id}")
    public ExerciseLog getExerciseById(@PathVariable Long id) {
        return healthTrackerService.getExerciseById(id);
    }

    // Get all Water Intakes records
    @GetMapping("/water-intakes")
    public Iterable<WaterIntake> getAllWaterIntakes() {
        return healthTrackerService.getAllWaterIntakes();
    }

    // Get a specific Water Intake by ID
    @GetMapping("/water-intakes/{id}")
    public WaterIntake getWaterIntakeById(@PathVariable Long id) {
        return healthTrackerService.getWaterIntakeById(id);
    }

    // ===================== POST Methods =====================

    // Create a new Exercise log
    @PostMapping("/log-exercise")
    public ExerciseLog logExercise(@RequestBody ExerciseLog exerciseLog) {
        return healthTrackerService.logExercise(exerciseLog.getExerciseType(), exerciseLog.getDurationMinutes());
    }

    // Create a new Water Intake log
    @PostMapping("/log-water")
    public WaterIntake logWater(@RequestBody WaterIntake waterIntake) {
        return healthTrackerService.logWaterIntake(waterIntake.getAmountMl());
    }

    // ===================== PUT Methods =====================

    // Update an existing Exercise log by ID
    @PutMapping("/exercises/{id}")
    public ExerciseLog updateExercise(@PathVariable Long id, @RequestBody ExerciseLog updatedExerciseLog) {
        return healthTrackerService.updateExercise(id, updatedExerciseLog);
    }

    // Update an existing Water Intake log by ID
    @PutMapping("/water-intakes/{id}")
    public WaterIntake updateWaterIntake(@PathVariable Long id, @RequestBody WaterIntake updatedWaterIntake) {
        return healthTrackerService.updateWaterIntake(id, updatedWaterIntake);
    }
}