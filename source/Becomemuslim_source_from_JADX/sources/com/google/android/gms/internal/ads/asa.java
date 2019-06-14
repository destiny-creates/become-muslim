package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.p180d.C2829c;

@cm
public final class asa {
    /* renamed from: a */
    private final Context f14891a;

    public asa(Context context) {
        C2872v.a(context, "Context can not be null");
        this.f14891a = context;
    }

    /* renamed from: a */
    private final boolean m18861a(Intent intent) {
        C2872v.a(intent, "Intent can not be null");
        return !this.f14891a.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    /* renamed from: a */
    public final boolean m18862a() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return m18861a(intent);
    }

    /* renamed from: b */
    public final boolean m18863b() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return m18861a(intent);
    }

    /* renamed from: c */
    public final boolean m18864c() {
        return ((Boolean) lz.m19845a(this.f14891a, new asb())).booleanValue() && C2829c.a(this.f14891a).a("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(14)
    /* renamed from: d */
    public final boolean m18865d() {
        return m18861a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}
