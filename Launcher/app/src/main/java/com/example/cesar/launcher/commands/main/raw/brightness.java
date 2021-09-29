package com.example.cesar.launcher.commands.main.raw;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;

import com.example.cesar.launcher.R;
import com.example.cesar.launcher.commands.CommandAbstraction;
import com.example.cesar.launcher.commands.ExecutePack;

import static android.provider.Settings.System.SCREEN_BRIGHTNESS;
import static android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE;
import static android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC;
import static android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL;

public class brightness implements CommandAbstraction {
    @Override
    public String exec(ExecutePack pack) throws Exception {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.System.canWrite(pack.context)){
            pack.context.startActivity(new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS));
            return pack.context.getString(R.string.output_waitingpermission);
        }
        final int brightness = pack.getInt();

        ((Activity) pack.context).runOnUiThread(() ->{
            int b = brightness;

            if(b < 0) b=0;
            else if(b > 100) b = 100;
            b = b * 255 / 100;
            int autoBrightnessState;

            try {
                autoBrightnessState = Settings.System.getInt(((Activity) pack.context).getContentResolver(), Settings.System.SCREEN_BRIGHTNESS_MODE);
            }catch (Exception e){
                autoBrightnessState = SCREEN_BRIGHTNESS_MODE_MANUAL;
            }

            if(autoBrightnessState == SCREEN_BRIGHTNESS_MODE_AUTOMATIC) Settings.System.putInt(((Activity) pack.context).getContentResolver(), SCREEN_BRIGHTNESS_MODE, SCREEN_BRIGHTNESS_MODE_MANUAL);

            ContentResolver contentResolver = ((Activity) pack.context).getApplicationContext().getContentResolver();
            Settings.System.putInt(contentResolver, SCREEN_BRIGHTNESS, b);

            refreshBrightness(((Activity) pack.context).getWindow(), b);
        });
        return null;
    }

    private void refreshBrightness(Window window, float brightness){
        WindowManager.LayoutParams lp = window.getAttributes();

        if(brightness < 0){
            lp.screenBrightness = WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE;
        }else{
            lp.screenBrightness = brightness;
        }
        window.setAttributes(lp);
    }

    @Override
    public int[] argType(){
        return new int[] {CommandAbstraction.INT};
    }

    @Override
    public int priority(){
        return 3;
    }

    @Override
    public int helpRes()
    {
        return R.string.help_brightness;
    }

    @Override
    public String onArgNotFound(ExecutePack pack, int indexNotFOund){
        return pack.context.getString(R.string.invalid_integer);
    }

    @Override
    public String onNotArgEnough(ExecutePack pack, int nArgs){
        return pack.context.getString(helpRes());
    }
}
