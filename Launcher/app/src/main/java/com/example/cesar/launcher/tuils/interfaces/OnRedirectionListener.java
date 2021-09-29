package com.example.cesar.launcher.tuils.interfaces;

import com.example.cesar.launcher.commands.main.specific.RedirectCommand;

public interface OnRedirectionListener {
    void onRedirectionRequest(RedirectCommand cmd);
    void onRedirectionEnd(RedirectCommand cmd);
}
