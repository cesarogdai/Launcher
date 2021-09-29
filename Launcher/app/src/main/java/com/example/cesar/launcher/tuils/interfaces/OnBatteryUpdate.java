package com.example.cesar.launcher.tuils.interfaces;

public interface OnBatteryUpdate {
    void update(float percentage);
    void onCharging();
    void onNotCharging();
}
