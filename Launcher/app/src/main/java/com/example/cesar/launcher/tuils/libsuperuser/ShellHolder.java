package com.example.cesar.launcher.tuils.libsuperuser;
import android.content.Context;

import com.example.cesar.launcher.managers.TerminalManager;
import com.example.cesar.launcher.managers.xml.XMLPrefsManager;
import com.example.cesar.launcher.managers.xml.options.Behavior;
import com.example.cesar.launcher.tuils.Tuils;

import java.io.File;
import java.util.regex.Pattern;


public class ShellHolder {

    private Context context;

    public ShellHolder(Context context) {
        this.context = context;
    }

    Pattern p = Pattern.compile("^\\n");

    public Shell.Interactive build() {
        Shell.Interactive interactive = new Shell.Builder()
                .setOnSTDOUTLineListener(line -> {
                    line = p.matcher(line).replaceAll(Tuils.EMPTYSTRING);
                    Tuils.sendOutput(context, line, TerminalManager.CATEGORY_OUTPUT);
                })
                .setOnSTDERRLineListener(line -> {
                    line = p.matcher(line).replaceAll(Tuils.EMPTYSTRING);
                    Tuils.sendOutput(context, line, TerminalManager.CATEGORY_OUTPUT);
                })
                .open();
        interactive.addCommand("cd " + XMLPrefsManager.get(File.class, Behavior.home_path));
        return interactive;
    }
}
