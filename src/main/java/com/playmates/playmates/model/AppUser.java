package com.playmates.playmates.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AppUser {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String username;

    @NotEmpty
    @JsonIgnore
    private String password;

    @NotEmpty
    @Column(unique = true)
    private String email;

    @ManyToMany
    private Set<BoardGameFiltered> favouriteBoardGames;

    @ManyToMany
    private Set<Mechanics> favouriteMechanics;

    @ElementCollection
    @Builder.Default
    @JsonIgnore
    private List<String> roles = new ArrayList<>();


}
