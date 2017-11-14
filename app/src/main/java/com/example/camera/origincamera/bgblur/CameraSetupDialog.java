package com.example.camera.origincamera.bgblur;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.camera.origincamera.R;
import com.example.camera.origincamera.RenderScriptGlassBlur;
import com.example.camera.origincamera.bgblur.DialogBgActivity;

/**
 * Created by libo on 2017/10/23.
 */

public class CameraSetupDialog {
    private Dialog dialog;
    private Context context;
    private RadioGroup rgSpeed,rgFocus,rgSkin,rgDelay;
    private ImageView ivBg;
    private View viewClose;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            RenderScriptGlassBlur.bitmapBlur(context,ivBg, DialogBgActivity.textureView.getBitmap(),8);
            handler.sendEmptyMessageDelayed(0,40);
        }
    };

    public CameraSetupDialog(Context context) {
        this.context = context;

        dialog = new Dialog(context, R.style.BottomDialog);
        dialog.setContentView(R.layout.camera_setup);
        dialog.show();

        initView();

        init();
        event();
    }

    private void initView() {
        rgSpeed = dialog.findViewById(R.id.rg_camera_speed);
        rgFocus = dialog.findViewById(R.id.rg_camera_focus);
        rgSkin = dialog.findViewById(R.id.rg_camera_skin);
        rgDelay = dialog.findViewById(R.id.rg_camera_delay);
        viewClose = dialog.findViewById(R.id.view_close);
        ivBg = dialog.findViewById(R.id.iv_bg);
        dialog.setCanceledOnTouchOutside(true);

        ((RadioButton)rgSpeed.getChildAt(0)).setChecked(true);
        ((RadioButton)rgFocus.getChildAt(0)).setChecked(true);
        ((RadioButton)rgSkin.getChildAt(0)).setChecked(true);
        ((RadioButton)rgDelay.getChildAt(0)).setChecked(true);

        handler.sendEmptyMessageDelayed(0,40);
    }

    private void event(){

        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handler.removeCallbacksAndMessages(null);
            }
        });
    }

    private void init() {
        //显示对话框时，后面的Activity不变暗，可选操作。
        Window win = dialog.getWindow();
        win.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        //对话框全屏
        WindowManager windowManager = dialog.getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.width = display.getWidth(); //设置宽度
        lp.height = display.getHeight();
        dialog.getWindow().setAttributes(lp);
    }

}
