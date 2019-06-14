package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

final class asg extends asf<Boolean> {
    asg(int i, String str, Boolean bool) {
        super(i, str, bool);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3955a(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(m18878a(), ((Boolean) m18880b()).booleanValue()));
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3956a(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean(m18878a(), ((Boolean) m18880b()).booleanValue()));
    }

    /* renamed from: a */
    public final /* synthetic */ void mo3957a(Editor editor, Object obj) {
        editor.putBoolean(m18878a(), ((Boolean) obj).booleanValue());
    }
}
