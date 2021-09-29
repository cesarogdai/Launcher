package com.example.cesar.launcher.commands.main.raw;

import com.example.cesar.launcher.R;
import com.example.cesar.launcher.commands.CommandAbstraction;
import com.example.cesar.launcher.commands.ExecutePack;
import com.example.cesar.launcher.commands.main.MainPack;

public class changelog implements CommandAbstraction {

    @Override
    public String exec(ExecutePack pack) throws Exception{
        ChangelogManager.printLog(pack.context, ((MainPack) pack).client, true);
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
        return R.string.help_changelog;
    }

    @Override
    public String onArgNotFound(ExecutePack pack, int indexNotFound){
        return null;
    }

    @Override
    public String onNotArgEnough(ExecutePack pack, int nArgs){
        return null;
    }
}
