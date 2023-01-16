package com.sixsense.liargame.api.service;

import com.sixsense.liargame.api.response.NormalGameHistoryResp;

import java.util.List;

public interface HistoryService {
    List<NormalGameHistoryResp> getNormalGameHistory(Long userId);
}
