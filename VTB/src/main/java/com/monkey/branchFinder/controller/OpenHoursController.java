package com.monkey.branchFinder.controller;


import com.monkey.branchFinder.model.OpenHours;
import com.monkey.branchFinder.service.OpenHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;

@RestController
@RequestMapping("/api/openhours/{branchId}")
public class OpenHoursController {

    private final OpenHoursService openHoursService;

    @Autowired
    public OpenHoursController(OpenHoursService openHoursService) {
        this.openHoursService = openHoursService;
    }

    @GetMapping("/openhours")
    public ResponseEntity<List<OpenHours>> getOpenHoursByBranchId(@PathVariable Long branchId) {

        List<OpenHours> openHours = openHoursService.getOpenHoursByBranchId(branchId);

        if (openHours.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(openHours);
    }

    @GetMapping("/byDayAndHour")
    public ResponseEntity<List<OpenHours>> getOpenHoursByDayAndHour(
            @PathVariable Long branchId,
            @RequestParam DayOfWeek dayOfWeek,
            @RequestParam Integer hour) {

        List<OpenHours> openHours = openHoursService.getOpenHoursByDayAndHour(branchId, dayOfWeek, hour);

        if (openHours.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(openHours);
    }
}
