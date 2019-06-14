package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

final class ask extends asf<String> {
    ask(int i, String str, String str2) {
        super(i, str, str2);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3955a(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(m18878a(), (String) m18880b());
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3956a(JSONObject jSONObject) {
        return jSONObject.optString(m18878a(), (String) m18880b());
    }

    /* renamed from: a */
    public final /* synthetic */ void mo3957a(Editor editor, Object obj) {
        editor.putString(m18878a(), (String) obj);
    }
}
