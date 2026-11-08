package com.randomactivity.generator.repository;

import com.randomactivity.generator.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {

    List<Activity>findByMoodAndDayType(String mood,String dayType);

    List<Activity>findByMoodAndDayTypeAndIdNotIn(String mood, String dayType,List<Long>excludeIds);
}
