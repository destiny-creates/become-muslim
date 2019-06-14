package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class pr {
    /* renamed from: a */
    private final int f15927a;
    /* renamed from: b */
    private final List<aqg> f15928b;
    /* renamed from: c */
    private final int f15929c;
    /* renamed from: d */
    private final InputStream f15930d;

    public pr(int i, List<aqg> list) {
        this(i, list, -1, null);
    }

    public pr(int i, List<aqg> list, int i2, InputStream inputStream) {
        this.f15927a = i;
        this.f15928b = list;
        this.f15929c = i2;
        this.f15930d = inputStream;
    }

    /* renamed from: a */
    public final int m20024a() {
        return this.f15927a;
    }

    /* renamed from: b */
    public final List<aqg> m20025b() {
        return Collections.unmodifiableList(this.f15928b);
    }

    /* renamed from: c */
    public final int m20026c() {
        return this.f15929c;
    }

    /* renamed from: d */
    public final InputStream m20027d() {
        return this.f15930d;
    }
}
