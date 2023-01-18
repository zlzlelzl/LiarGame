package com.sixsense.liargame.api.response;

import com.sixsense.liargame.common.model.response.UserDto;
import lombok.*;
import java.util.List;
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
    private String DateTimestamp(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public ArticleResp(long id, String title, String content, boolean isNotice) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isNotice = isNotice;
    }
}
