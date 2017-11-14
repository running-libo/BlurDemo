package com.example.camera.origincamera.adjust;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.camera.origincamera.R;
import com.example.camera.origincamera.RenderScriptGlassBlur;

public class AdjustActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust);

        init();
    }

    private void init() {
        imageView = (ImageView) findViewById(R.id.imageview);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        seekBar.setMax(25);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.test10);
                if(progress < 1){
                    progress = 1;
                }
                Bitmap blurBitmap = RenderScriptGlassBlur.handleGlassblur(getApplicationContext(),bitmap,progress);
                imageView.setImageBitmap(blurBitmap);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
