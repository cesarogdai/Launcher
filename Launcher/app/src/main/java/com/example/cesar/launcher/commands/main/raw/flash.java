package com.example.cesar.launcher.commands.main.raw;

import android.Manifest;
import android.app.Activity;
import android.app.LauncherActivity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.example.cesar.launcher.R;
import com.example.cesar.launcher.commands.CommandAbstraction;
import com.example.cesar.launcher.commands.ExecutePack;
import com.example.cesar.launcher.managers.flashlight.TorchManager;

public class flash implements CommandAbstraction {

    @Override
    public String exec(ExecutePack pack){
        if (ContextCompat.checkSelfPermission(pack.context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions((Activity) pack.context, new String[]{Manifest.permission.CAMERA}, LauncherActivity.COMMAND_REQUEST_PERMISSION);
            return pack.context.getString(R.string.output_waitingpermission);
        }

        TorchManager.getInstance().toggle(pack.context);
        return null;
    }
    @Override
    public int helpRes() {
        return R.string.help_flash;
    }

    @Override
    public int[] argType() {
        return new int[0];
    }

    @Override
    public int priority() {
        return 4;
    }

    @Override
    public String onNotArgEnough(ExecutePack info, int nArgs) {
        return null;
    }

    @Override
    public String onArgNotFound(ExecutePack info, int index) {
        return null;
    }
}
