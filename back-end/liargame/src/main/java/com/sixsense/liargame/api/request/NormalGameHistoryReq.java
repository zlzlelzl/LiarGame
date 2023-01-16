package com.sixsense.liargame.api.request;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NormalGameHistoryReq {
    private Long id;
    private String liar;
    private String winner;
    private String word;

    @Builder
    public NormalGameHistoryReq(Long id, String liar, String winner, String word) {
        this.id = id;
        this.liar = liar;
        this.winner = winner;
        this.word = word;
    }
}
