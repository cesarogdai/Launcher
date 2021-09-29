package com.example.cesar.launcher.commands.main.raw;

import com.example.cesar.launcher.R;
import com.example.cesar.launcher.commands.CommandAbstraction;
import com.example.cesar.launcher.commands.ExecutePack;
import com.example.cesar.launcher.commands.main.MainPack;

public class refresh  implements CommandAbstraction {

    @Override
    public String exec(ExecutePack pack){
        MainPack info = (MainPack)  pack;
        info.appsManager.fill();
        info.aliasManager.reload();
        if(info.player != null) info.player.refresh();
        info.rssManager.refresh();

        return info.res.getString(R.string.output_refresh);
    }

    @Override
    public int helpRes(){
        return R.string.help_refresh;
    }

    @Override
    public int[] argType(){
        return new int[0];
    }

     @Override
    public int priority(){
        return 3;
     }

     @Override
    public String onNotArgEnough(ExecutePack info, int nArgs){
        return null;
     }

     @Override
    public String onArgNotFOund(ExecutePack pack, int index){
        return null;
     }
}
