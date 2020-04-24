package com.playmates.playmates.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private AppUser host;

    @ManyToMany
    private Set<BoardGameFiltered> games;

    @ManyToMany
    private Set<AppUser> members;

    private Integer memberLimit;

    private LocalDateTime eventDate;

    @ElementCollection
    private Set<Comment> comments;
}
