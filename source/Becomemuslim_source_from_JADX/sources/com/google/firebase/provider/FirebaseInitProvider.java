package com.google.firebase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.internal.C2872v;
import com.google.firebase.C5335b;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
public class FirebaseInitProvider extends ContentProvider {
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
        if (C5335b.m22598a(getContext()) == null) {
            Log.i("FirebaseInitProvider", "FirebaseApp initialization unsuccessful");
        } else {
            Log.i("FirebaseInitProvider", "FirebaseApp initialization successful");
        }
        return false;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        C2872v.a(providerInfo, "FirebaseInitProvider ProviderInfo cannot be null.");
        if ("com.google.firebase.firebaseinitprovider".equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        }
        super.attachInfo(context, providerInfo);
    }
}
