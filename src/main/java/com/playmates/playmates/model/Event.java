package com.playmates.playmates.model;

import com.playmates.playmates.model.generated.GamesItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private Long hostId;

    @OneToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<EventBoardGame> games;

    @ElementCollection
    private Set<Long> memberIds;

    private Integer memberLimit;

    private Date eventDate;
}
