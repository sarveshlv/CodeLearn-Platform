package com.capg.app.service.UserActivityService;

import com.capg.app.model.UserActivity;

import java.util.List;

public interface UserActivityService {

    List<UserActivity> getAllCardsByUserIdAndStatus(String userId, String status);

    List<UserActivity> getAllCardsByUserIdAndType(String userId, String type);
}
