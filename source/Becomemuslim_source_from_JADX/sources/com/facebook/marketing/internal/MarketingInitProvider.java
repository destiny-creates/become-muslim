package com.facebook.marketing.internal;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdk.InitializeCallback;
import com.facebook.marketing.CodelessActivityLifecycleTracker;

public final class MarketingInitProvider extends ContentProvider {
    private static final String TAG = "MarketingInitProvider";

    /* renamed from: com.facebook.marketing.internal.MarketingInitProvider$1 */
    class C37851 implements InitializeCallback {
        C37851() {
        }

        public void onInitialized() {
            MarketingInitProvider.this.setupCodeless();
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public boolean onCreate() {
        try {
            if (FacebookSdk.isInitialized()) {
                setupCodeless();
            } else {
                FacebookSdk.sdkInitialize(getContext(), new C37851());
            }
        } catch (Throwable e) {
            Log.i(TAG, "Failed to auto initialize the Marketing SDK", e);
        }
        return false;
    }

    private void setupCodeless() {
        CodelessActivityLifecycleTracker.startTracking((Application) FacebookSdk.getApplicationContext());
        RemoteConfigManager.loadRemoteConfig();
        new MarketingLogger((Application) FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationId()).logCodelessInitialized();
    }
}
