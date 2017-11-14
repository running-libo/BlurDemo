package com.example.camera.origincamera.bgblur;

import android.graphics.SurfaceTexture;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;

import com.example.camera.origincamera.OpenCamera;
import com.example.camera.origincamera.R;

public class DialogBgActivity extends AppCompatActivity implements TextureView.SurfaceTextureListener {
    public static TextureView textureView;
    private OpenCamera openCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textureView = (TextureView) findViewById(R.id.textureview);
        openCamera = new OpenCamera(getApplicationContext(), textureView);

        openCamera.startCameraThread();

        if (!textureView.isAvailable()) {
            textureView.setSurfaceTextureListener(this);
        } else {
            openCamera.startPreview();
        }
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        openCamera.setupCamera(width, height);  //设置相机参数,回调的是textureview的宽高
        openCamera.openCamera();
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {

    }

    public void onclick(View view){
        new CameraSetupDialog(this);
    }
}
