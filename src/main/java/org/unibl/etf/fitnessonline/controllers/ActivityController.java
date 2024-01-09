package org.unibl.etf.fitnessonline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.fitnessonline.models.dtos.ActivityDTO;
import org.unibl.etf.fitnessonline.models.requests.ActivityRequest;
import org.unibl.etf.fitnessonline.models.requests.ChartRequest;
import org.unibl.etf.fitnessonline.services.ActivityService;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@CrossOrigin(origins = "*")
public class ActivityController {
    @Autowired
    private ActivityService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addActivity(@RequestBody ActivityRequest request) {
        service.addActivity(request);
    }

    @GetMapping("/{id}")
    public List<ActivityDTO> findByUserId(@PathVariable Integer id) {
        return service.findByUserId(id);
    }

    @PostMapping("/chart/{id}")
    public List<ActivityDTO> findActivitiesBetweenDates(@PathVariable Integer id, @RequestBody ChartRequest request) {
        return service.findActivitiesBetweenDates(id, request);
    }
}
