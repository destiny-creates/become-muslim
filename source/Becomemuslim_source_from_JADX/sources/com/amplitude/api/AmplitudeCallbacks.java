package com.amplitude.api;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class AmplitudeCallbacks implements ActivityLifecycleCallbacks {
    private static final String NULLMSG = "Need to initialize AmplitudeCallbacks with AmplitudeClient instance";
    public static final String TAG = "com.amplitude.api.AmplitudeCallbacks";
    private static AmplitudeLog logger = AmplitudeLog.getLogger();
    private AmplitudeClient clientInstance = null;

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public AmplitudeCallbacks(AmplitudeClient amplitudeClient) {
        if (amplitudeClient == null) {
            logger.m3415e(TAG, NULLMSG);
            return;
        }
        this.clientInstance = amplitudeClient;
        amplitudeClient.useForegroundTracking();
    }

    public void onActivityPaused(Activity activity) {
        if (this.clientInstance == null) {
            logger.m3415e(TAG, NULLMSG);
        } else {
            this.clientInstance.onExitForeground(getCurrentTimeMillis());
        }
    }

    public void onActivityResumed(Activity activity) {
        if (this.clientInstance == null) {
            logger.m3415e(TAG, NULLMSG);
        } else {
            this.clientInstance.onEnterForeground(getCurrentTimeMillis());
        }
    }

    protected long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
