package com.example.cesar.launcher.commands.main.raw;

import android.bluetooth.BluetoothAdapter;

import com.example.cesar.launcher.R;
import com.example.cesar.launcher.commands.CommandAbstraction;
import com.example.cesar.launcher.commands.ExecutePack;
import com.example.cesar.launcher.commands.main.MainPack;

public class bluetooth implements CommandAbstraction {

    @Override
    public String exec(ExecutePack pack){
        MainPack info = (MainPack) pack;

        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

        if(adapter ==null) return  info.context.getString(R.string.output_bluetooth_unavailable);

        if(adapter.isEnabled()){
            adapter.disable();
            return info.context.getString(R.string.output_bluetooth)+ "falso";
        }else{
            adapter.enable();
            return info.context.getString(R.string.output_bluetooth) + "verdadero";
        }
    }

    @Override
    public int helpRes(){ return R.string.help_bluetooth; }

    @Override
    public int[] argType(){return new int[0];}

    @Override
    public int priority(){ return 2; }

    @Override
    public String onNotArEnough(ExecutePack info, int nArgs){return null;}

    @Override
    public String onArgNotFound(ExecutePack info, int index){return null;}
}
