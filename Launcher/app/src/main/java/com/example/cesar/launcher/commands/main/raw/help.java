package com.example.cesar.launcher.commands.main.raw;

import com.example.cesar.launcher.R;
import com.example.cesar.launcher.commands.CommandAbstraction;
import com.example.cesar.launcher.commands.ExecutePack;
import com.example.cesar.launcher.commands.main.MainPack;
import com.example.cesar.launcher.tuils.Tuils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class help implements CommandAbstraction {

    @Override
    public String exec(ExecutePack pack) throws Exception {
        MainPack info = (MainPack) pack;
        CommandAbstraction cmd = info.get(CommandAbstraction.class);
        int res = cmd == null ? R.string.output_commandnotfound : cmd.helpRes();
        return "Priority: " + info.cmdPrefs.getPriority(cmd) + Tuils.NEWLINE + info.res.getString(res);
    }

    @Override
    public int helpRes() {
        return R.string.help_help;
    }

    @Override
    public int[] argType() {
        return new int[]{CommandAbstraction.COMMAND};
    }

    @Override
    public int priority() {
        return 5;
    }

    @Override
    public String onNotArgEnough(ExecutePack pack, int nArgs) {
        MainPack info = (MainPack) pack;
        List<String> toPrint = new ArrayList<>(Arrays.asList(info.commandGroup.getCommandNames()));

        Collections.sort(toPrint, Tuils::alphabeticCompare);

        Tuils.addPrefix(toPrint, Tuils.DOUBLE_SPACE);
        Tuils.addSeparator(toPrint, Tuils.TRIBLE_SPACE);
        Tuils.insertHeaders(toPrint, true);

        return Tuils.toPlanString(toPrint, "");
    }

    @Override
    public String onArgNotFound(ExecutePack pack, int index) {
        MainPack info = (MainPack) pack;
        return info.res.getString(R.string.output_commandnotfound);
    }

}
