package org.spongycastle.crypto.params;

import java.security.SecureRandom;

public class DSAParameterGenerationParameters {
    /* renamed from: a */
    private final int f22414a;
    /* renamed from: b */
    private final int f22415b;
    /* renamed from: c */
    private final int f22416c;
    /* renamed from: d */
    private final int f22417d;
    /* renamed from: e */
    private final SecureRandom f22418e;

    public DSAParameterGenerationParameters(int i, int i2, int i3, SecureRandom secureRandom) {
        this(i, i2, i3, secureRandom, -1);
    }

    public DSAParameterGenerationParameters(int i, int i2, int i3, SecureRandom secureRandom, int i4) {
        this.f22414a = i;
        this.f22415b = i2;
        this.f22417d = i3;
        this.f22416c = i4;
        this.f22418e = secureRandom;
    }

    /* renamed from: a */
    public int m27495a() {
        return this.f22414a;
    }

    /* renamed from: b */
    public int m27496b() {
        return this.f22415b;
    }

    /* renamed from: c */
    public int m27497c() {
        return this.f22417d;
    }

    /* renamed from: d */
    public SecureRandom m27498d() {
        return this.f22418e;
    }

    /* renamed from: e */
    public int m27499e() {
        return this.f22416c;
    }
}
