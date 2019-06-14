package com.p064b.p065a.p066a;

import android.content.Context;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p352b.C6436o;
import io.p347a.p348a.p349a.p350a.p352b.C6436o.C6435a;
import java.util.Map;
import java.util.UUID;

/* compiled from: SessionMetadataCollector */
/* renamed from: com.b.a.a.v */
class C1001v {
    /* renamed from: a */
    private final Context f2802a;
    /* renamed from: b */
    private final C6436o f2803b;
    /* renamed from: c */
    private final String f2804c;
    /* renamed from: d */
    private final String f2805d;

    public C1001v(Context context, C6436o c6436o, String str, String str2) {
        this.f2802a = context;
        this.f2803b = c6436o;
        this.f2804c = str;
        this.f2805d = str2;
    }

    /* renamed from: a */
    public C1000t m3446a() {
        Map i = this.f2803b.i();
        return new C1000t(this.f2803b.c(), UUID.randomUUID().toString(), this.f2803b.b(), (String) i.get(C6435a.f20783d), (String) i.get(C6435a.f20786g), this.f2803b.l(), (String) i.get(C6435a.f20782c), C6428i.m(this.f2802a), this.f2803b.d(), this.f2803b.g(), this.f2804c, this.f2805d);
    }
}
