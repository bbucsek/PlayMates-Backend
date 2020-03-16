package com.playmates.playmates.model.credentials;

import com.playmates.playmates.model.generated.GamesItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventCredentials {

    private List<GamesItem> games;
    private Integer limit;
    private Date date;
}
