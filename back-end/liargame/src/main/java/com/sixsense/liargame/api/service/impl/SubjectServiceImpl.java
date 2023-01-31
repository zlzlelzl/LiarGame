package com.sixsense.liargame.api.service.impl;

import com.sixsense.liargame.api.response.SubjectResp;
import com.sixsense.liargame.api.response.WordResp;
import com.sixsense.liargame.api.service.SubjectService;
import com.sixsense.liargame.db.entity.Subject;
import com.sixsense.liargame.db.repository.RoomRepository;
import com.sixsense.liargame.db.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final RoomRepository roomRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository, RoomRepository roomRepository) {
        this.subjectRepository = subjectRepository;
        this.roomRepository = roomRepository;
    }


    @Override
    public List<SubjectResp> selectAllSubjects() {
        return subjectRepository.findAll().stream().map(this::toSubjectDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void selectRandomWord(Long subjectId, Integer roomId) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow();
        int size = subject.getWords().size();
        int idx = (int) (Math.random() * size);
        WordResp wordResp = toWordDto(subject.getWords().get(idx));
        roomRepository.findById(roomId).orElseThrow().setWord(wordResp.getName());
    }
}
