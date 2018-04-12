package com.example.jasonchesney.myapplicationdemo1;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jasonchesney.myapplicationdemo1.Model.MyResponse;
import com.example.jasonchesney.myapplicationdemo1.Model.Notification;
import com.example.jasonchesney.myapplicationdemo1.Model.Sender;
import com.example.jasonchesney.myapplicationdemo1.Remote.APIService;
import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class mapactivity extends Activity {

    Button btnsendData;
    EditText edtTitle, edtContent;

    APIService mService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapactivity);

        Common.currentToken = FirebaseInstanceId.getInstance().getToken();

        mService = Common.getFCMClient();

        btnsendData = (Button)findViewById(R.id.btnSendData);
        edtContent = (EditText)findViewById(R.id.edtContent);
        edtTitle = (EditText)findViewById(R.id.edtTitle);

        btnsendData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Notification notification = new Notification(edtTitle.getText().toString(), edtContent.getText().toString());
                Sender sender = new Sender(Common.currentToken, notification);
                mService.sendNotification(sender)
                        .enqueue(new Callback<MyResponse>() {
                            @Override
                            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                                if(response.body().success == 1)
                                    Toast.makeText(mapactivity.this, "Success", Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(mapactivity.this, "Failed", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<MyResponse> call, Throwable t) {
                                Log.e("ERROR", t.getMessage());
                            }
                        });

            }
        });
    }

}
