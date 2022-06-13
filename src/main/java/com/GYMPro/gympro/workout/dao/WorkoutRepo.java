package com.GYMPro.gympro.workout.dao;

import com.GYMPro.gympro.workout.model.Workout;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepo extends MongoRepository<Workout, String> {
}
