package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

final class asj extends asf<Float> {
    asj(int i, String str, Float f) {
        super(i, str, f);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3955a(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(m18878a(), ((Float) m18880b()).floatValue()));
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo3956a(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(m18878a(), (double) ((Float) m18880b()).floatValue()));
    }

    /* renamed from: a */
    public final /* synthetic */ void mo3957a(Editor editor, Object obj) {
        editor.putFloat(m18878a(), ((Float) obj).floatValue());
    }
}
