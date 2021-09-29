package com.example.cesar.launcher.managers.xml.options;

import com.example.cesar.launcher.managers.xml.XMLPrefsManager;
import com.example.cesar.launcher.managers.xml.classes.XMLPrefsElement;
import com.example.cesar.launcher.managers.xml.classes.XMLPrefsSave;

public enum Cmd implements XMLPrefsManager {

    default_seach{
        @Override
        public String defaultValue(){
            return "-gg";
        }

        @Override
        public String info(){
            return "El parametro si buscas \"search example param\" en lugar de \"search -param apples\"";
        }

        @Override
        public String type(){
            return XMLPrefsSave.TEXT;
        }
    };

    @Override
    public XMLPrefsElement parent(){
        return XMLPrefsManager.XMLPrefsRoot.CMD;
    }

    @Override
    public String label(){
        return name();
    }

    @Override
    public String[] invalidValues(){
        return null;
    }

    @Override
    public String getLowercaseString() {
        return label();
    }

    @Override
    public String getString(){
        return label();
    }
}
