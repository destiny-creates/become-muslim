package com.p064b.p065a.p066a;

import android.content.Context;
import io.p347a.p348a.p349a.p350a.p352b.C6430k;
import io.p347a.p348a.p349a.p350a.p355d.C6470b;
import io.p347a.p348a.p349a.p350a.p355d.C6471c;
import io.p347a.p348a.p349a.p350a.p358g.C6491b;
import java.util.UUID;

/* compiled from: SessionAnalyticsFilesManager */
/* renamed from: com.b.a.a.o */
class C3409o extends C6470b<C0999s> {
    /* renamed from: g */
    private C6491b f9070g;

    C3409o(Context context, C3413u c3413u, C6430k c6430k, C6471c c6471c) {
        super(context, c3413u, c6430k, c6471c, 100);
    }

    /* renamed from: a */
    protected String m10859a() {
        UUID randomUUID = UUID.randomUUID();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sa");
        stringBuilder.append("_");
        stringBuilder.append(randomUUID.toString());
        stringBuilder.append("_");
        stringBuilder.append(this.c.a());
        stringBuilder.append(".tap");
        return stringBuilder.toString();
    }

    /* renamed from: b */
    protected int m10861b() {
        return this.f9070g == null ? super.b() : this.f9070g.f20909e;
    }

    /* renamed from: c */
    protected int m10862c() {
        return this.f9070g == null ? super.c() : this.f9070g.f20907c;
    }

    /* renamed from: a */
    void m10860a(C6491b c6491b) {
        this.f9070g = c6491b;
    }
}
