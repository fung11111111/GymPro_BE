package com.GYMPro.gympro.service;

import com.GYMPro.gympro.dao.WorkoutRepo;
import com.GYMPro.gympro.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    private final WorkoutRepo workoutRepo;

    @Autowired
    public WorkoutService(WorkoutRepo workoutRepo) {
        this.workoutRepo = workoutRepo;
    }

    public List<Workout> getAllWorkouts() {
        return workoutRepo.findAll();
    }

    public Workout insertWorkout(Workout workout) {
        return workoutRepo.insert(workout);
    }

    public Optional<Workout> getWorkoutById(String id) {
        return workoutRepo.findById(id);
    }

    public void deleteWorkoutById(String id) {
        if (workoutRepo.existsById(id)) {
            workoutRepo.deleteById(id);
        }
    }

    public Workout updateWorkoutById(String id, Workout workout) {
        if (!workoutRepo.existsById(id)) return null;

        workout.setId(id);
        return workoutRepo.save(workout);
    }


}
