package com.sixsense.liargame.api.response;

import com.sixsense.liargame.common.model.response.UserDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArticleResp {
    private long id;
    private String title;
    private String content;
    private boolean isNotice;
    private String name;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String DateTimestamp(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

}
