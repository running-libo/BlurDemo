package com.example.camera.origincamera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.camera.origincamera.adjust.AdjustActivity;
import com.example.camera.origincamera.bgblur.DialogBgActivity;
import com.example.camera.origincamera.moveblur.BlurDialogActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
    }

    public void adjust(View view){
        startActivity(new Intent(this,AdjustActivity.class));
    }

    public void dialog(View view){
        startActivity(new Intent(this,DialogBgActivity.class));
    }

    public void dialogbg(View view){
        startActivity(new Intent(this,BlurDialogActivity.class));
    }
}
