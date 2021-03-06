package com.example.cesar.launcher.managers.xml.options;

import android.os.Build;

import com.example.cesar.launcher.managers.xml.classes.XMLPrefsElement;
import com.example.cesar.launcher.managers.xml.classes.XMLPrefsSave;

public enum Reply implements XMLPrefsSave {
    reply_enabled {
        @Override
        public String defaultValue() {
            return "true";
        }

        @Override
        public String type() {
            return XMLPrefsSave.BOOLEAN;
        }

        @Override
        public String info() {
            return "If false, notification reply will be disabled";
        }
    };

    @Override
    public XMLPrefsElement parent() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) return ReplyManager.instance;
        else return null;
    }

    @Override
    public String label() {
        return name();
    }

    @Override
    public String[] invalidValues() {
        return null;
    }

    @Override
    public String getLowercaseString() {
        return label();
    }

    @Override
    public String getString() {
        return label();
    }
}
