package com.example.camera.origincamera.moveblur;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageView;
import com.example.camera.origincamera.R;
import com.example.camera.origincamera.RenderScriptGlassBlur;

/**
 * Created by libo on 2017/11/14.
 */

public class BlurDialog {
    private Dialog dialog;
    private ImageView ivBg;

    public BlurDialog(Context context,Bitmap bitmap){
        dialog = new Dialog(context, R.style.BottomDialog);
        dialog.setContentView(R.layout.dialog_bgblur);
        dialog.show();

        ivBg = dialog.findViewById(R.id.imageview_bg);

        fullScreen();

        RenderScriptGlassBlur.bitmapBlur(context,ivBg,bitmap,3);
    }

    private void fullScreen(){

        WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
        layoutParams.gravity= Gravity.BOTTOM;
        layoutParams.width= WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height= WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().getDecorView().setPadding(0, 0, 0, 0);
        dialog.getWindow().setAttributes(layoutParams);
    }
}
