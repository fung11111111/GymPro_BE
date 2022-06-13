package com.GYMPro.gympro.workout.controller;


import com.GYMPro.gympro.workout.model.Workout;
import com.GYMPro.gympro.workout.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout")
public class WorkoutController {
    private final WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }


    @PostMapping
    public Workout insertWorkOut(@RequestBody Workout workout) {
        System.out.println(workout.getName());
        return workoutService.insertWorkout(workout);
    }

    @GetMapping
    public List<Workout> getAllWorkout() {
        return workoutService.getAllWorkouts();
    }

    @PutMapping("/{id}")
    public Workout updateById(@PathVariable String id, @RequestBody Workout workout) {
        return workoutService.updateWorkoutById(id, workout);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        workoutService.deleteWorkoutById(id);
    }

    @GetMapping("/{id}")
    public Workout getById(@PathVariable String id){
        return workoutService.getWorkoutById(id).get();
    }


}
