package io.nlopez.smartlocation.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.location.C7834c;

/* compiled from: ActivityStore */
/* renamed from: io.nlopez.smartlocation.activity.a */
public class C6535a {
    /* renamed from: a */
    private static final String f21049a;
    /* renamed from: b */
    private SharedPreferences f21050b;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C6535a.class.getCanonicalName());
        stringBuilder.append(".KEY");
        f21049a = stringBuilder.toString();
    }

    /* renamed from: a */
    public void m26707a(String str, C7834c c7834c) {
        Editor edit = this.f21050b.edit();
        edit.putInt(m26706a(str, "ACTIVITY"), c7834c.m38221a());
        edit.putInt(m26706a(str, "CONFIDENCE"), c7834c.m38222b());
        edit.putInt(m26706a(str, "VERSION_CODE"), c7834c.getVersionCode());
        edit.apply();
    }

    /* renamed from: a */
    private String m26706a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f21049a);
        stringBuilder.append("_");
        stringBuilder.append(str);
        stringBuilder.append("_");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }
}
