package org.unibl.etf.fitnessonline.services;

import org.unibl.etf.fitnessonline.models.dtos.ActivityDTO;
import org.unibl.etf.fitnessonline.models.requests.ActivityRequest;
import org.unibl.etf.fitnessonline.models.requests.ChartRequest;

import java.util.List;

public interface ActivityService {
    void addActivity(ActivityRequest request);
    List<ActivityDTO> findByUserId(Integer id);
    List<ActivityDTO> findActivitiesBetweenDates(Integer id, ChartRequest request);
}
