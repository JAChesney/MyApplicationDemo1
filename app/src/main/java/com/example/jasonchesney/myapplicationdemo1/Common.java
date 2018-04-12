package com.example.jasonchesney.myapplicationdemo1;

import com.example.jasonchesney.myapplicationdemo1.Remote.APIService;
import com.example.jasonchesney.myapplicationdemo1.Remote.RetrofitClient;

/**
 * Created by JASON CHESNEY on 04-03-2018.
 */

public class Common {
    public static String currentToken = "";

    private static String baseUrl = "https://fcm.googleapis.com/";

    public static APIService getFCMClient()
    {
        return RetrofitClient.getClient(baseUrl).create(APIService.class);
    }
}
