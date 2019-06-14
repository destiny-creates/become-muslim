package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

final class aa {
    /* renamed from: b */
    private static final long f18043b = TimeUnit.DAYS.toMillis(7);
    /* renamed from: a */
    final String f18044a;
    /* renamed from: c */
    private final String f18045c;
    /* renamed from: d */
    private final long f18046d;

    private aa(String str, String str2, long j) {
        this.f18044a = str;
        this.f18045c = str2;
        this.f18046d = j;
    }

    /* renamed from: a */
    static aa m22696a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new aa(str, null, 0);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new aa(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
        } catch (String str2) {
            str2 = String.valueOf(str2);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str2).length() + 23);
            stringBuilder.append("Failed to parse token: ");
            stringBuilder.append(str2);
            Log.w("FirebaseInstanceId", stringBuilder.toString());
            return null;
        }
    }

    /* renamed from: a */
    static String m22698a(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j);
            return jSONObject.toString();
        } catch (String str3) {
            str3 = String.valueOf(str3);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str3).length() + 24);
            stringBuilder.append("Failed to encode token: ");
            stringBuilder.append(str3);
            Log.w("FirebaseInstanceId", stringBuilder.toString());
            return null;
        }
    }

    /* renamed from: a */
    static String m22697a(aa aaVar) {
        return aaVar == null ? null : aaVar.f18044a;
    }

    /* renamed from: b */
    final boolean m22699b(String str) {
        if (System.currentTimeMillis() <= this.f18046d + f18043b) {
            if (str.equals(this.f18045c) != null) {
                return null;
            }
        }
        return true;
    }
}
