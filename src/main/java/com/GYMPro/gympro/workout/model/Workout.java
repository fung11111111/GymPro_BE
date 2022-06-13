package com.GYMPro.gympro.workout.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Workout {
    @Id
    private String id;
    private String name;

    public Workout(@JsonProperty("id") String id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public Workout(@JsonProperty("name") String name){
        this.name = name;
    }


}
