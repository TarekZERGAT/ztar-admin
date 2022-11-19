package com.ztardz.ztaradminapi.services;

import com.ztardz.ztaradminapi.models.ActivityEntity;
import com.ztardz.ztaradminapi.models.UserEntity;

import java.util.List;

public interface ActivityService {
    List<ActivityEntity> browseAllActivities();
    ActivityEntity readActivityById(Integer id);
    ActivityEntity editActivity(ActivityEntity activity);
    ActivityEntity addNewActivity(ActivityEntity activity, UserEntity user);
    void deleteActivity(ActivityEntity activity);
}
