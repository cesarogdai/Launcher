package com.example.cesar.launcher.commands.main.raw;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.example.cesar.launcher.R;
import com.example.cesar.launcher.commands.CommandAbstraction;
import com.example.cesar.launcher.commands.ExecutePack;

public class clear implements CommandAbstraction {

    @Override
    public String exec(ExecutePack info) throws Exception{
        LocalBroadcastManager.getInstance(info.context.getApplicationContext()).sendBroadcast(new Intent(UIMananger.ACTION_CLEAR));
        return null;
    }

    @Override
    public int[] argType(){
        return new int[0];
    }

    @Override
    public int priority(){
        return 2;
    }

    @Override
    public int helpRes(){
        return R.string.help_clear;
    }
    @Override
    public String onArgNotFound(ExecutePack pack, int index){
        return  null;
    }

    @Override
    public String onNotArgEnough(ExecutePack info, int nArgs){
        return null;
    }

}
