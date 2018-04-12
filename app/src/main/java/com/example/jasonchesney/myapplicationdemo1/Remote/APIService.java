package com.example.jasonchesney.myapplicationdemo1.Remote;

import com.example.jasonchesney.myapplicationdemo1.Model.MyResponse;
import com.example.jasonchesney.myapplicationdemo1.Model.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by JASON CHESNEY on 05-03-2018.
 */

public interface APIService {

    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAATelSvNQ:APA91bFh7zC63Whj_cIR05TgIDMTBcWlFyndbkBu81wBeFl8AHMTtlCCuY-A_IWWD7xM4NnXI-anSNsAXXYZOMFSs8J04Y4ENwF4cn7lvBE2Y-xz8mxMuQpmVePVAtCIiXUgSFAlUiWR"
    })
    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
