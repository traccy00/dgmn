package com.traccy.dgmn.service.impl;

import com.traccy.dgmn.entity.Activity;
import com.traccy.dgmn.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class ActivityService {
  @Autowired
  private ActivityRepository activityRepository;

  @Autowired
  private HttpServletRequest request;

  public Activity logActivityData(String action, String beforeData, String afterData) {
    String ip = request.getRemoteAddr();

    Activity activity = new Activity();
    activity.setIpAddress(ip);
    activity.setAction(action);
    activity.setBeforeData(beforeData);
    activity.setAfterData(afterData);
    activity.create();
    return activityRepository.save(activity);
  }

}
