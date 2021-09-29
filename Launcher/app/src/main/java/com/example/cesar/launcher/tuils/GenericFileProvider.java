package com.example.cesar.launcher.tuils;

import android.support.v4.content.FileProvider;

import com.example.cesar.launcher.BuildConfig;

public class GenericFileProvider extends FileProvider {
    public static final String PROVIDER_NAME = BuildConfig.APPLICATION_ID + ".FILE_PROVIDER";
}
