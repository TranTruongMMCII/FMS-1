package com.example.fms_android.utility;

import com.example.fms_android.api.APIClient;
import com.example.fms_android.service.AdminService;
import com.example.fms_android.service.AnswerService;
import com.example.fms_android.service.AssignmentService;
import com.example.fms_android.service.QuestionService;
import com.example.fms_android.service.TraineeService;
import com.example.fms_android.service.TrainerService;
import com.example.fms_android.service.UserService;

public class APIUtility {

    private static final String baseURL = "http://10.0.2.2:90/";

    public static UserService getUserService(){
        return APIClient.getClient(baseURL).create(UserService.class);
    }
    public static AssignmentService getAssignmentService(){
        return APIClient.getClient(baseURL).create(AssignmentService.class);
    }

    public static AnswerService getAnswerService(){
        return APIClient.getClient(baseURL).create(AnswerService.class);
    }

    public static QuestionService getQuestionService(){
        return APIClient.getClient(baseURL).create(QuestionService.class);
    }

    public static AdminService getAdminService(){
        return APIClient.getClient(baseURL).create(AdminService.class);
    }

    public static TrainerService getTrainerService(){
        return APIClient.getClient(baseURL).create(TrainerService.class);
    }

    public static TraineeService getTraineeService(){
        return APIClient.getClient(baseURL).create(TraineeService.class);
    }
}
