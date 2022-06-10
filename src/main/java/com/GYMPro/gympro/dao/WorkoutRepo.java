package com.GYMPro.gympro.dao;

import com.GYMPro.gympro.model.Workout;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepo extends MongoRepository<Workout, String> {
}
