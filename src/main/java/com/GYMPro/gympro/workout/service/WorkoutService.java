package com.GYMPro.gympro.workout.service;

import com.GYMPro.gympro.workout.dao.WorkoutRepo;
import com.GYMPro.gympro.workout.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepo workoutRepo;

    //todo: seems unit test cannot inject to the constructor
//    @Autowired
//    public WorkoutService(WorkoutRepo workoutRepo) {
//        this.workoutRepo = workoutRepo;
//    }

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
