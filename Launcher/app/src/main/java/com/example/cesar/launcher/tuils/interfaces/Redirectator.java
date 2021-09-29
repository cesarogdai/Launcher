package com.example.cesar.launcher.tuils.interfaces;

import com.example.cesar.launcher.commands.main.specific.RedirectCommand;

public interface Redirectator {
    void prepareRedirection(RedirectCommand cmd);
    void cleanup();
}
