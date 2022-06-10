package com.GYMPro.gympro.controller;


import com.GYMPro.gympro.dao.WorkoutRepo;
import com.GYMPro.gympro.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout")
public class WorkoutController {
    @Autowired
    private WorkoutRepo workoutRepo;

    @PostMapping
    public Workout insertWorkOut(@RequestBody Workout workout) {
        System.out.println(workout.getName());
        return workoutRepo.insert(workout);
    }

    @GetMapping
    public List<Workout> getAllWorkout() {
        return workoutRepo.findAll();
    }

}
