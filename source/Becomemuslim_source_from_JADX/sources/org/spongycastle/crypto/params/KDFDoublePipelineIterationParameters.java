package org.spongycastle.crypto.params;

import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.util.Arrays;

public final class KDFDoublePipelineIterationParameters implements DerivationParameters {
    /* renamed from: a */
    private final byte[] f27112a;
    /* renamed from: b */
    private final boolean f27113b;
    /* renamed from: c */
    private final int f27114c;
    /* renamed from: d */
    private final byte[] f27115d;

    /* renamed from: a */
    public byte[] m35674a() {
        return this.f27112a;
    }

    /* renamed from: b */
    public boolean m35675b() {
        return this.f27113b;
    }

    /* renamed from: c */
    public int m35676c() {
        return this.f27114c;
    }

    /* renamed from: d */
    public byte[] m35677d() {
        return Arrays.m29373b(this.f27115d);
    }
}
