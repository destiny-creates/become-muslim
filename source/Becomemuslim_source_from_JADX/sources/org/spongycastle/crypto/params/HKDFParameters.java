package org.spongycastle.crypto.params;

import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.util.Arrays;

public class HKDFParameters implements DerivationParameters {
    /* renamed from: a */
    private final byte[] f27100a;
    /* renamed from: b */
    private final boolean f27101b;
    /* renamed from: c */
    private final byte[] f27102c;
    /* renamed from: d */
    private final byte[] f27103d;

    /* renamed from: a */
    public byte[] m35662a() {
        return Arrays.m29373b(this.f27100a);
    }

    /* renamed from: b */
    public boolean m35663b() {
        return this.f27101b;
    }

    /* renamed from: c */
    public byte[] m35664c() {
        return Arrays.m29373b(this.f27102c);
    }

    /* renamed from: d */
    public byte[] m35665d() {
        return Arrays.m29373b(this.f27103d);
    }
}
