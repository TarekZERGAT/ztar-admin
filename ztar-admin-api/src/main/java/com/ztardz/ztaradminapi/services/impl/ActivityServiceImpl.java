package com.ztardz.ztaradminapi.services.impl;

import com.ztardz.ztaradminapi.models.ActivityEntity;
import com.ztardz.ztaradminapi.models.UserEntity;
import com.ztardz.ztaradminapi.repositories.ActivityRepository;
import com.ztardz.ztaradminapi.services.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private ActivityRepository activityRepository;

    @Override
    public List<ActivityEntity> browseAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public ActivityEntity readActivityById(Integer id) {
        return null;
    }

    @Override
    public ActivityEntity editActivity(ActivityEntity activity) {
        return null;
    }

    @Override
    public ActivityEntity addNewActivity(ActivityEntity activity, UserEntity user) {
        activity.setCreatedBy(user);
        return activityRepository.save(activity);
    }

    @Override
    public void deleteActivity(ActivityEntity activity) {

    }
}
