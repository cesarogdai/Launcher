package com.example.cesar.launcher.commands.main.raw;

import com.example.cesar.launcher.R;
import com.example.cesar.launcher.commands.CommandAbstraction;
import com.example.cesar.launcher.commands.ExecutePack;
import com.example.cesar.launcher.commands.main.MainPack;
import com.example.cesar.launcher.tuils.interfaces.Reloadable;

public class restart implements CommandAbstraction {

    @Override
    public String exec(ExecutePack pack){
        MainPack info = (MainPack) pack;
        ((Reloadable) info.context).reload();

        return pack.context.getString(R.string.restarting);
    }

    @Override
    public int[] argType(){
        return new int[0];
    }

    @Override
    public int priority(){
        return 4;
    }

    @Override
    public int helpRes(){
        return R.string.help_restart;
    }

    @Override
    public String onArgNotFound(ExecutePack info, int index){
        return null;
    }

    @Override
    public String onNotArgEnough(ExecutePack info, int nArgs){
        return null;
    }
}
