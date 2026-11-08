package com.randomactivity.generator.controller;

import com.randomactivity.generator.model.Activity;
import com.randomactivity.generator.service.ActivityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/activities")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService){
        this.activityService=activityService;
    }

    @GetMapping("/random")
    public Activity getRandom(
            @RequestParam String mood,
            @RequestParam String dayType,
            @RequestParam(required = false)List<Long>exclude){
        return activityService.getRandomActivity(mood,dayType,exclude);
    }
}
