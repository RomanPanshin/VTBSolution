package com.monkey.branchFinder.controller;

import com.monkey.branchFinder.model.Atm;
import com.monkey.branchFinder.service.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/atms")
public class AtmController {

    private final AtmService atmService;

    @Autowired
    public AtmController(AtmService atmService) {
        this.atmService = atmService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atm> getAtmById(@PathVariable Long id) {
        Optional<Atm> atm = atmService.findById(id);
        return atm.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/nearby")
    public ResponseEntity<List<Atm>> getNearbyAtms(
            @RequestParam Double latitude,
            @RequestParam Double longitude) {

        List<Atm> nearbyAtms = atmService.findNearbyAtms(latitude, longitude);

        if (nearbyAtms.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(nearbyAtms);
    }
}
