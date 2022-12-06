package com.ztardz.ztaradminapi.services;

import com.ztardz.ztaradminapi.models.ActivityEntity;
import com.ztardz.ztaradminapi.models.UserEntity;

import java.util.List;

public interface ActivityService {
    List<ActivityEntity> browseAllActivities();
    ActivityEntity readActivityById(Integer id);
    ActivityEntity editActivity(ActivityEntity activityToEdit);
    ActivityEntity addNewActivity(ActivityEntity activityToAdd);
    void deleteActivity(ActivityEntity activityToDelete);
}
