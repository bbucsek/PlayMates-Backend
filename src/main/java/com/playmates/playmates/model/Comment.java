package com.playmates.playmates.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime submitDate;

    @OneToOne
    private AppUser author;

    private String comment;
}
