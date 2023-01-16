package com.sixsense.liargame.api.service.impl;

import com.sixsense.liargame.api.response.NormalGameHistoryResp;
import com.sixsense.liargame.api.service.HistoryService;
import com.sixsense.liargame.db.repository.NormalGameRepository;
import com.sixsense.liargame.db.repository.SpyGameRepository;
import com.sixsense.liargame.db.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final NormalGameRepository normalGameRepository;
    private final SpyGameRepository spyGameRepository;
    private final UserRepository userRepository;

    @Override
    public List<NormalGameHistoryResp> getNormalGameHistory(Long userId) {
        normalGameRepository.
        return null;
    }
}
