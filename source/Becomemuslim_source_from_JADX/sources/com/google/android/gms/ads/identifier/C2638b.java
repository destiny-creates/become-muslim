package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.common.C2832i;

/* renamed from: com.google.android.gms.ads.identifier.b */
public final class C2638b {
    /* renamed from: a */
    private SharedPreferences f6690a;

    public C2638b(Context context) {
        try {
            context = C2832i.getRemoteContext(context);
            this.f6690a = context == null ? null : context.getSharedPreferences("google_ads_flags", 0);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while getting SharedPreferences ", th);
            this.f6690a = null;
        }
    }

    /* renamed from: a */
    final float m7433a(String str, float f) {
        try {
            return this.f6690a == null ? 0.0f : this.f6690a.getFloat(str, 0.0f);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return 0.0f;
        }
    }

    /* renamed from: a */
    final String m7434a(String str, String str2) {
        try {
            return this.f6690a == null ? str2 : this.f6690a.getString(str, str2);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return str2;
        }
    }

    /* renamed from: a */
    public final boolean m7435a(String str, boolean z) {
        try {
            return this.f6690a == null ? false : this.f6690a.getBoolean(str, false);
        } catch (Throwable th) {
            Log.w("GmscoreFlag", "Error while reading from SharedPreferences ", th);
            return false;
        }
    }
}
