package com.sixsense.liargame.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import java.util.List;

@Getter
@MappedSuperclass
@NoArgsConstructor
public class History extends BaseTime {
    private String liar;
    private String winner;
    private Long wordId;
    @ManyToMany
    @JoinColumn(name = "id")
    private List<Playuser> playusers;

    public History(String liar, String winner, Long wordId, List<Playuser> playusers) {
        this.liar = liar;
        this.winner = winner;
        this.wordId = wordId;
        this.playusers = playusers;
    }
}
