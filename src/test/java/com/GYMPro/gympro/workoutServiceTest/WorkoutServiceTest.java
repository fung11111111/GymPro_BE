package com.GYMPro.gympro.workoutServiceTest;

import com.GYMPro.gympro.workout.dao.WorkoutRepo;
import com.GYMPro.gympro.workout.model.Workout;
import com.GYMPro.gympro.workout.service.WorkoutService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static junit.framework.TestCase.assertEquals;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
public class WorkoutServiceTest {

    @InjectMocks
    private WorkoutService workoutService;

    @Mock
    private WorkoutRepo workoutRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_return_workout_with_id_when_call_insertWorkout() {
        //given
        Workout expected = new Workout("1", "workout");
        when(workoutRepo.insert(expected)).thenReturn(expected);
        // when
        Workout actual = workoutService.insertWorkout(expected);

        //   then
        verify(workoutRepo).insert(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_all_when_call_getAllWorkout() {
        List<Workout> expected = Arrays.asList(new Workout("123", "workout"));
        when(workoutRepo.findAll()).thenReturn(expected);

        List<Workout> actual = workoutService.getAllWorkouts();

        assertEquals(expected, actual);
    }

    @Test
    public void should_update_workout_when_call_updateWorkoutById() {
        Workout expected = new Workout("123", "workout");
        when(workoutRepo.existsById("123")).thenReturn(true);
        when(workoutRepo.save(expected)).thenReturn(expected);

        Workout actual = workoutService.updateWorkoutById("123", expected);

        assertEquals(expected, actual);
    }

    @Test
    public void should_get_workout_when_call_getWorkoutById(){
        Workout expected = new Workout("123", "workout");
        when(workoutRepo.findById("123")).thenReturn(Optional.of(expected));

        Workout actual = workoutService.getWorkoutById("123").get();

        assertEquals(expected, actual);
    }

    @Test
    public void should_delete_workout_when_call_deleteWorkoutById(){
        when(workoutRepo.existsById("123")).thenReturn(true);

        workoutService.deleteWorkoutById("123");

        verify(workoutRepo).deleteById("123");

    }


}
