package com.google.android.gms.internal.p213l;

import android.net.Uri;

/* renamed from: com.google.android.gms.internal.l.hn */
public final class hn {
    /* renamed from: a */
    private final String f17288a;
    /* renamed from: b */
    private final Uri f17289b;
    /* renamed from: c */
    private final String f17290c;
    /* renamed from: d */
    private final String f17291d;
    /* renamed from: e */
    private final boolean f17292e;
    /* renamed from: f */
    private final boolean f17293f;

    public hn(Uri uri) {
        this(null, uri, "", "", false, false);
    }

    private hn(String str, Uri uri, String str2, String str3, boolean z, boolean z2) {
        this.f17288a = null;
        this.f17289b = uri;
        this.f17290c = str2;
        this.f17291d = str3;
        this.f17292e = false;
        this.f17293f = false;
    }

    /* renamed from: a */
    public final hd<Double> m21430a(String str, double d) {
        return hd.m21414b(this, str, d);
    }

    /* renamed from: a */
    public final hd<Integer> m21431a(String str, int i) {
        return hd.m21415b(this, str, i);
    }

    /* renamed from: a */
    public final hd<Long> m21432a(String str, long j) {
        return hd.m21416b(this, str, j);
    }

    /* renamed from: a */
    public final hd<String> m21433a(String str, String str2) {
        return hd.m21417b(this, str, str2);
    }

    /* renamed from: a */
    public final hd<Boolean> m21434a(String str, boolean z) {
        return hd.m21418b(this, str, z);
    }
}
