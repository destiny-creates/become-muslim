package com.raizlabs.android.dbflow.p273c;

import com.raizlabs.android.dbflow.p273c.p274a.C5664b;
import java.util.UUID;

/* compiled from: DBTransactionInfo */
/* renamed from: com.raizlabs.android.dbflow.c.b */
public class C5667b {
    /* renamed from: a */
    private String f18934a;
    /* renamed from: b */
    private int f18935b;

    private C5667b() {
    }

    /* renamed from: a */
    public static C5667b m24036a(String str) {
        return C5667b.m24037a(str, C5664b.f18921b);
    }

    /* renamed from: a */
    public static C5667b m24037a(String str, int i) {
        C5667b c5667b = new C5667b();
        c5667b.f18934a = str;
        c5667b.f18935b = i;
        return c5667b;
    }

    /* renamed from: a */
    public static C5667b m24035a() {
        C5667b c5667b = new C5667b();
        c5667b.f18934a = UUID.randomUUID().toString();
        c5667b.f18935b = C5664b.f18920a;
        return c5667b;
    }

    /* renamed from: b */
    public static C5667b m24038b() {
        C5667b c5667b = new C5667b();
        c5667b.f18935b = C5664b.f18923d;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fetch ");
        stringBuilder.append(UUID.randomUUID().toString());
        c5667b.f18934a = stringBuilder.toString();
        return c5667b;
    }

    /* renamed from: c */
    public int m24039c() {
        return this.f18935b;
    }
}
