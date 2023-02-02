package com.sixsense.liargame.api.service;

import com.sixsense.liargame.common.model.Vote;
import com.sixsense.liargame.common.model.response.GameResultResp;

public interface GameService {
    GameResultResp normalGameStart(Long userId, Long roomId);

    GameResultResp spyGameStart(Long userId);

    void vote(Vote vote, Long GameId);

    void insertAnswer(String answer, Long GameId);

}