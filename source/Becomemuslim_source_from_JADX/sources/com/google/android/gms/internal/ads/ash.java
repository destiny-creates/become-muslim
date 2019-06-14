package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

final class ash extends asf<Integer> {
    ash(int i, String str, Integer num) {
        super(i, str, num);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3955a(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(m18878a(), ((Integer) m18880b()).intValue()));
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3956a(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(m18878a(), ((Integer) m18880b()).intValue()));
    }

    /* renamed from: a */
    public final /* synthetic */ void mo3957a(Editor editor, Object obj) {
        editor.putInt(m18878a(), ((Integer) obj).intValue());
    }
}
