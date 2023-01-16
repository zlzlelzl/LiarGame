package com.sixsense.liargame.api.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sixsense.liargame.api.request.NormalGameHistoryReq;
import com.sixsense.liargame.api.response.NormalGameHistoryResp;
import com.sixsense.liargame.api.service.HistoryService;
import com.sixsense.liargame.common.auth.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/history")
public class HistoryController {
    private final HistoryService historyService;

    @PostMapping("/normal")
    public ResponseEntity<?> writeNormal(HttpServletRequest request, @RequestBody NormalGameHistoryReq history) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/normal")
    public ResponseEntity<List<NormalGameHistoryResp>> getNormalGame(HttpServletRequest request) {
        String token = request.getHeader(JwtProperties.HEADER_STRING);
        Long userId = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(token).getClaim("id").asLong();

    }
}
