package com.playmates.playmates.model;

import com.playmates.playmates.model.generated.GamesItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<EventBoardGame> games;

    @ElementCollection
    @ManyToMany
    private List<AppUser> members;

    private Integer memberLimit;

    private Date eventDate;
}
