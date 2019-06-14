package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class AEADParameters implements CipherParameters {
    /* renamed from: a */
    private byte[] f27064a;
    /* renamed from: b */
    private byte[] f27065b;
    /* renamed from: c */
    private KeyParameter f27066c;
    /* renamed from: d */
    private int f27067d;

    public AEADParameters(KeyParameter keyParameter, int i, byte[] bArr) {
        this(keyParameter, i, bArr, null);
    }

    public AEADParameters(KeyParameter keyParameter, int i, byte[] bArr, byte[] bArr2) {
        this.f27066c = keyParameter;
        this.f27065b = bArr;
        this.f27067d = i;
        this.f27064a = bArr2;
    }

    /* renamed from: a */
    public KeyParameter m35626a() {
        return this.f27066c;
    }

    /* renamed from: b */
    public int m35627b() {
        return this.f27067d;
    }

    /* renamed from: c */
    public byte[] m35628c() {
        return this.f27064a;
    }

    /* renamed from: d */
    public byte[] m35629d() {
        return this.f27065b;
    }
}
