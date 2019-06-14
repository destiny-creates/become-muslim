package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

final class asi extends asf<Long> {
    asi(int i, String str, Long l) {
        super(i, str, l);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3955a(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(m18878a(), ((Long) m18880b()).longValue()));
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3956a(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(m18878a(), ((Long) m18880b()).longValue()));
    }

    /* renamed from: a */
    public final /* synthetic */ void mo3957a(Editor editor, Object obj) {
        editor.putLong(m18878a(), ((Long) obj).longValue());
    }
}
