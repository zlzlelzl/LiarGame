package com.sixsense.liargame.api.request;

import lombok.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CommentReq {
    private String content;
    private int userId;
    private String createdAt;
}
