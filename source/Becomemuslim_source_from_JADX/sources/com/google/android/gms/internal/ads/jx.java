package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import java.util.List;

final class jx implements ato {
    /* renamed from: a */
    private final /* synthetic */ List f24140a;
    /* renamed from: b */
    private final /* synthetic */ atn f24141b;
    /* renamed from: c */
    private final /* synthetic */ Context f24142c;

    jx(jw jwVar, List list, atn atn, Context context) {
        this.f24140a = list;
        this.f24141b = atn;
        this.f24142c = context;
    }

    /* renamed from: a */
    public final void mo4304a() {
        for (String str : this.f24140a) {
            String str2 = "Pinging url: ";
            String valueOf = String.valueOf(str);
            mt.m19922d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            this.f24141b.m30196a(Uri.parse(str), null, null);
        }
        this.f24141b.m30193a((Activity) this.f24142c);
    }

    /* renamed from: b */
    public final void mo4305b() {
    }
}
