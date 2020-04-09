package com.playmates.playmates.model.credentials;

import com.playmates.playmates.model.AppUser;
import com.playmates.playmates.model.generated.GamesItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventCredentials {

    private List<GamesItem> games;
    private Integer limit;
    private LocalDateTime date;
    private Set<AppUser> members;
}
