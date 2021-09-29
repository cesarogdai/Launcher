package com.example.cesar.launcher.commands.main.specific;

import com.example.cesar.launcher.commands.CommandAbstraction;
import com.example.cesar.launcher.commands.ExecutePack;

import java.util.ArrayList;
import java.util.List;

public abstract class RedirectCommand  implements CommandAbstraction {
    public List<Object> beforeObjects = new ArrayList<>();
    public List<Object> afterObjects = new ArrayList<>();

    public abstract String onRedirect(ExecutePack pack);
    public abstract int getHint();
    public abstract boolean isWatingPermission();

    public void cleanup(){
        beforeObjects.clear();
        afterObjects.clear();
    }
}
