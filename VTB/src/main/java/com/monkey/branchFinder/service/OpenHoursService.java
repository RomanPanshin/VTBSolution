package com.monkey.branchFinder.service;

import com.monkey.branchFinder.model.OpenHours;
import com.monkey.branchFinder.repository.OpenHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;

@Service
public class OpenHoursService {

    @Autowired
    private OpenHoursRepository openHoursRepository;

    public List<OpenHours> getOpenHoursByBranchId(Long branchId) {
        return openHoursRepository.findByBranchId(branchId);
    }

    public List<OpenHours> getOpenHoursByDayAndHour(Long branchId, DayOfWeek dayOfWeek, Integer hour) {
        String dayValue = mapDayOfWeekToDbValue(dayOfWeek);
        return openHoursRepository.findByBranchIdAndDayAndHour(branchId, dayValue, hour);
    }

    private String mapDayOfWeekToDbValue(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY:
                return "пн";
            case TUESDAY:
                return "вт";
            case WEDNESDAY:
                return "ср";
            case THURSDAY:
                return "чт";
            case FRIDAY:
                return "пт";
            case SATURDAY:
                return "сб";
            case SUNDAY:
                return "вс";
            default:
                throw new IllegalArgumentException("Unknown DayOfWeek: " + dayOfWeek);
        }
    }
}
