package com.playmates.playmates.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventForFrontend {

    private Long id;

    private String hostName;

    private List<EventBoardGame> games;

    private Set<String> members;

    private Integer memberLimit;

    private Date eventDate;
}
