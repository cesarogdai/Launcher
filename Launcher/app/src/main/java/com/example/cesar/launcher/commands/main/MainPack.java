package com.example.cesar.launcher.commands.main;

import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;

import java.io.File;
import java.lang.reflect.Method;

public class MainPack {
    //current directory
    public File currentDirectory;

    //resources references
    public Resources res;

    //internet
    public WifiManager wifi;

    //data package
    public Method setMoileDataEnabledMethod;
    public ConnectivityManager connectivityManager;
    public Object connectMgr;

    //contacts phone
    public ContactsManager contacts;

    //music
    public MusicManager2 player;

    //apps & assocs
    public AliasManager aliasManager;
    public AppsManager appsManager;
    public CommandsPreferences cmdPrefs;
    public String lastCommand;
    public Redirectator redirectator;
    public Shellholder shellholder;
    public RssManager rssManager;
    public OkHttpClient client;
    public int commandColor = TerminalManager.NO_COLOR;

    public MainPack(Context context, CommandGroup commandGroup, AliasManager alMgr, AppsManager appmgr, MusicManager2
                    p, ContactManager c, Redirectator redirectator, RssManager rssManager, OkHttpClient client){
        super(commandGroup);
        this.currentDirectory = XMLPrefsManager.get(File.class,Behavior.home_path);

        this.rssManager = rssManager;
        this.client = client;

        this.res = context.getResources();

        this.context = context;
        this.aliasManager = alMgr;
        this.appsManager = appmgr;
        this.cmdPrefs = new CommandsPreferences();

        this.player = p;
        this.contacts = c;

        this.redirectator = redirectator;
    }
    public void dispose(){
        TorchManager mgr = TorchManager.getInstance();
        if(mgr.isOn()) mrg.turnOff();
    }

    public void destroy(){
        if(player != null) player.destroy();
        appsManager.onDestroy();
        if(rssManager != null) rssManager.dispose();
        contacts.destroy(context);
    }
    @Override
    public void clear(){
        super.clear();

        commandColor = TerminalManager.NO_COLOR;
    }
}
