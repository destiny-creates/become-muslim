package org.spongycastle.crypto.params;

import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.util.Arrays;

public final class KDFFeedbackParameters implements DerivationParameters {
    /* renamed from: a */
    private final byte[] f27116a;
    /* renamed from: b */
    private final byte[] f27117b;
    /* renamed from: c */
    private final boolean f27118c;
    /* renamed from: d */
    private final int f27119d;
    /* renamed from: e */
    private final byte[] f27120e;

    /* renamed from: a */
    public byte[] m35678a() {
        return this.f27116a;
    }

    /* renamed from: b */
    public byte[] m35679b() {
        return this.f27117b;
    }

    /* renamed from: c */
    public boolean m35680c() {
        return this.f27118c;
    }

    /* renamed from: d */
    public int m35681d() {
        return this.f27119d;
    }

    /* renamed from: e */
    public byte[] m35682e() {
        return Arrays.m29373b(this.f27120e);
    }
}
