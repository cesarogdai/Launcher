package com.example.cesar.launcher.commands.tuixt;

import android.content.Context;
import android.content.res.Resources;
import android.widget.EditText;

import com.example.cesar.launcher.commands.CommandGroup;
import com.example.cesar.launcher.commands.ExecutePack;

import java.io.File;

public class TuixtPack extends ExecutePack {

    public File editFile;
    public EditText editText;

    public Resources resources;

    public TuixtPack(CommandGroup group, File file, Context context, EditText editText){
        super(group);

        this.editText = editText;
        editFile = file;
        this.context = context;
        this.resources = context.getResources();
    }

}
