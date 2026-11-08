package com.randomactivity.generator.service;

import com.randomactivity.generator.model.Activity;
import com.randomactivity.generator.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final Random random = new Random();

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public Activity getRandomActivity(String mood, String dayType, List<Long> excludeIds) {
        List<Activity> filteredActivites;

        if (excludeIds == null || excludeIds.isEmpty()) {
            filteredActivites = activityRepository.findByMoodAndDayType(mood, dayType);
            if (filteredActivites.isEmpty()) {
                filteredActivites = activityRepository.findByMoodAndDayType(mood, "any");
            }
        } else {
            filteredActivites = activityRepository.findByMoodAndDayTypeAndIdNotIn(mood, dayType, excludeIds);
            if (filteredActivites.isEmpty()) {
                filteredActivites = activityRepository.findByMoodAndDayTypeAndIdNotIn(mood, "any", excludeIds);
            }
            if (filteredActivites.isEmpty()) {
                filteredActivites = activityRepository.findByMoodAndDayType(mood, dayType);
                if (filteredActivites.isEmpty()) {
                    filteredActivites = activityRepository.findByMoodAndDayType(mood, "any");
                }
            }
        }
        if (filteredActivites.isEmpty()) {
            return new Activity(null, "Просто ничего не делай", "Просто полежи на диване,полистай мемы если ничего не выбралось", "any", "any", true);
        }
        int randomIndex = random.nextInt(filteredActivites.size());
        return filteredActivites.get(randomIndex);
    }

}
