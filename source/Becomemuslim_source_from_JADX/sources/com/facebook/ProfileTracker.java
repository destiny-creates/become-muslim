package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.C0373d;
import com.facebook.internal.Validate;

public abstract class ProfileTracker {
    private final C0373d broadcastManager;
    private boolean isTracking = false;
    private final BroadcastReceiver receiver;

    private class ProfileBroadcastReceiver extends BroadcastReceiver {
        private ProfileBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (ProfileManager.ACTION_CURRENT_PROFILE_CHANGED.equals(intent.getAction()) != null) {
                ProfileTracker.this.onCurrentProfileChanged((Profile) intent.getParcelableExtra(ProfileManager.EXTRA_OLD_PROFILE), (Profile) intent.getParcelableExtra(ProfileManager.EXTRA_NEW_PROFILE));
            }
        }
    }

    protected abstract void onCurrentProfileChanged(Profile profile, Profile profile2);

    public ProfileTracker() {
        Validate.sdkInitialized();
        this.receiver = new ProfileBroadcastReceiver();
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
        intentFilter.addAction(ProfileManager.ACTION_CURRENT_PROFILE_CHANGED);
        this.broadcastManager.m1142a(this.receiver, intentFilter);
    }
}
