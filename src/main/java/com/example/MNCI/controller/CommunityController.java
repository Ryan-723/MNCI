package com.example.MNCI.controller;

import com.example.MNCI.dto.CommunityDto;
import com.example.MNCI.service.CommunityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Community")
@AllArgsConstructor
@Slf4j
public class CommunityController {

    private final CommunityService communityService;
    @PostMapping
    public ResponseEntity<CommunityDto> createCommunity(@RequestBody CommunityDto communityDto){
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(communityService.save(communityDto));
    }

    @GetMapping
    public ResponseEntity<List<CommunityDto>> getAllCommunities(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(communityService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommunityDto> getCommunity(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(communityService.getCommunity(id));
    }
}
