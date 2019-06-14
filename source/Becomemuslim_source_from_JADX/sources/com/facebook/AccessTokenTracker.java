package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.C0373d;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;

public abstract class AccessTokenTracker {
    private static final String TAG = "AccessTokenTracker";
    private final C0373d broadcastManager;
    private boolean isTracking = false;
    private final BroadcastReceiver receiver;

    private class CurrentAccessTokenBroadcastReceiver extends BroadcastReceiver {
        private CurrentAccessTokenBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (AccessTokenManager.ACTION_CURRENT_ACCESS_TOKEN_CHANGED.equals(intent.getAction()) != null) {
                Utility.logd(AccessTokenTracker.TAG, "AccessTokenChanged");
                AccessTokenTracker.this.onCurrentAccessTokenChanged((AccessToken) intent.getParcelableExtra(AccessTokenManager.EXTRA_OLD_ACCESS_TOKEN), (AccessToken) intent.getParcelableExtra(AccessTokenManager.EXTRA_NEW_ACCESS_TOKEN));
            }
        }
    }

    protected abstract void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2);

    public AccessTokenTracker() {
        Validate.sdkInitialized();
        this.receiver = new CurrentAccessTokenBroadcastReceiver();
        this.broadcastManager = C0373d.m1138a(FacebookSdk.getApplicationContext());
        startTracking();
    }

    public void startTracking() {
        if (!this.isTracking) {
            addBroadcastReceiver();
            this.isTracking = true;
        }
    }

    public void stopTracking() {
        if (this.isTracking) {
            this.broadcastManager.m1141a(this.receiver);
            this.isTracking = false;
        }
    }

    public boolean isTracking() {
        return this.isTracking;
    }

    private void addBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AccessTokenManager.ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        this.broadcastManager.m1142a(this.receiver, intentFilter);
    }
}
