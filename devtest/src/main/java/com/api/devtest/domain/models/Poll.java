package com.api.devtest.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String description;
    @ElementCollection
    private List<String> options;
    @ElementCollection
    private Map<String, Integer> votes;
}
