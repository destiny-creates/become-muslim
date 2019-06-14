package org.spongycastle.crypto.params;

import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.util.Arrays;

public final class KDFCounterParameters implements DerivationParameters {
    /* renamed from: a */
    private byte[] f27108a;
    /* renamed from: b */
    private byte[] f27109b;
    /* renamed from: c */
    private byte[] f27110c;
    /* renamed from: d */
    private int f27111d;

    /* renamed from: a */
    public byte[] m35670a() {
        return this.f27108a;
    }

    /* renamed from: b */
    public byte[] m35671b() {
        return Arrays.m29373b(this.f27109b);
    }

    /* renamed from: c */
    public byte[] m35672c() {
        return Arrays.m29373b(this.f27110c);
    }

    /* renamed from: d */
    public int m35673d() {
        return this.f27111d;
    }
}
