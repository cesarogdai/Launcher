package com.example.cesar.launcher.managers.xml.classes;

public interface XMLPrefsElement {
    XMLPrefsList getValues();
    void write(XMLPrefsSave save, String value);
    String[] delete();
    String path;
}
