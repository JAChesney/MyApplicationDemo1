package com.example.jasonchesney.myapplicationdemo1.Service;

import com.example.jasonchesney.myapplicationdemo1.Common;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by JASON CHESNEY on 04-03-2018.
 */

public class MyFirebaseService extends FirebaseInstanceIdService{
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Common.currentToken = refreshedToken;
    }
}
