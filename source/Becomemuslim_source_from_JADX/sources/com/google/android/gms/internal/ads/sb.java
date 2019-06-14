package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

@cm
public final class sb extends MutableContextWrapper {
    /* renamed from: a */
    private Activity f15988a;
    /* renamed from: b */
    private Context f15989b;
    /* renamed from: c */
    private Context f15990c;

    public sb(Context context) {
        super(context);
        setBaseContext(context);
    }

    /* renamed from: a */
    public final Activity m20086a() {
        return this.f15988a;
    }

    /* renamed from: b */
    public final Context m20087b() {
        return this.f15990c;
    }

    public final Object getSystemService(String str) {
        return this.f15990c.getSystemService(str);
    }

    public final void setBaseContext(Context context) {
        this.f15989b = context.getApplicationContext();
        this.f15988a = context instanceof Activity ? (Activity) context : null;
        this.f15990c = context;
        super.setBaseContext(this.f15989b);
    }

    public final void startActivity(Intent intent) {
        if (this.f15988a != null) {
            this.f15988a.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.f15989b.startActivity(intent);
    }
}
