package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.MacDerivationFunction;
import org.spongycastle.crypto.params.KDFCounterParameters;
import org.spongycastle.crypto.params.KeyParameter;

public class KDFCounterBytesGenerator implements MacDerivationFunction {
    /* renamed from: a */
    private static final BigInteger f31679a = BigInteger.valueOf(2147483647L);
    /* renamed from: b */
    private static final BigInteger f31680b = BigInteger.valueOf(2);
    /* renamed from: c */
    private final Mac f31681c;
    /* renamed from: d */
    private final int f31682d;
    /* renamed from: e */
    private byte[] f31683e;
    /* renamed from: f */
    private byte[] f31684f;
    /* renamed from: g */
    private int f31685g;
    /* renamed from: h */
    private byte[] f31686h;
    /* renamed from: i */
    private int f31687i;
    /* renamed from: j */
    private byte[] f31688j;

    /* renamed from: a */
    public void mo5727a(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFCounterParameters) {
            KDFCounterParameters kDFCounterParameters = (KDFCounterParameters) derivationParameters;
            this.f31681c.mo5764a(new KeyParameter(kDFCounterParameters.m35670a()));
            this.f31683e = kDFCounterParameters.m35671b();
            this.f31684f = kDFCounterParameters.m35672c();
            derivationParameters = kDFCounterParameters.m35673d();
            this.f31686h = new byte[(derivationParameters / 8)];
            derivationParameters = f31680b.pow(derivationParameters).multiply(BigInteger.valueOf((long) this.f31682d));
            if (derivationParameters.compareTo(f31679a) == 1) {
                derivationParameters = Integer.MAX_VALUE;
            } else {
                derivationParameters = derivationParameters.intValue();
            }
            this.f31685g = derivationParameters;
            this.f31687i = null;
            return;
        }
        throw new IllegalArgumentException("Wrong type of arguments given");
    }

    /* renamed from: a */
    public int mo5726a(byte[] bArr, int i, int i2) {
        int i3 = this.f31687i + i2;
        if (i3 < 0 || i3 >= this.f31685g) {
            i = new StringBuilder();
            i.append("Current KDFCTR may only be used for ");
            i.append(this.f31685g);
            i.append(" bytes");
            throw new DataLengthException(i.toString());
        }
        if (this.f31687i % this.f31682d == 0) {
            m40733a();
        }
        i3 = this.f31687i % this.f31682d;
        int min = Math.min(this.f31682d - (this.f31687i % this.f31682d), i2);
        System.arraycopy(this.f31688j, i3, bArr, i, min);
        this.f31687i += min;
        i3 = i2 - min;
        i += min;
        while (i3 > 0) {
            m40733a();
            min = Math.min(this.f31682d, i3);
            System.arraycopy(this.f31688j, 0, bArr, i, min);
            this.f31687i += min;
            i3 -= min;
            i += min;
        }
        return i2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m40733a() {
        /*
        r5 = this;
        r0 = r5.f31687i;
        r1 = r5.f31682d;
        r0 = r0 / r1;
        r0 = r0 + 1;
        r1 = r5.f31686h;
        r1 = r1.length;
        r2 = 0;
        switch(r1) {
            case 1: goto L_0x0035;
            case 2: goto L_0x0029;
            case 3: goto L_0x001d;
            case 4: goto L_0x0016;
            default: goto L_0x000e;
        };
    L_0x000e:
        r0 = new java.lang.IllegalStateException;
        r1 = "Unsupported size of counter i";
        r0.<init>(r1);
        throw r0;
    L_0x0016:
        r1 = r5.f31686h;
        r3 = r0 >>> 24;
        r3 = (byte) r3;
        r1[r2] = r3;
    L_0x001d:
        r1 = r5.f31686h;
        r3 = r5.f31686h;
        r3 = r3.length;
        r3 = r3 + -3;
        r4 = r0 >>> 16;
        r4 = (byte) r4;
        r1[r3] = r4;
    L_0x0029:
        r1 = r5.f31686h;
        r3 = r5.f31686h;
        r3 = r3.length;
        r3 = r3 + -2;
        r4 = r0 >>> 8;
        r4 = (byte) r4;
        r1[r3] = r4;
    L_0x0035:
        r1 = r5.f31686h;
        r3 = r5.f31686h;
        r3 = r3.length;
        r3 = r3 + -1;
        r0 = (byte) r0;
        r1[r3] = r0;
        r0 = r5.f31681c;
        r1 = r5.f31683e;
        r3 = r5.f31683e;
        r3 = r3.length;
        r0.mo5765a(r1, r2, r3);
        r0 = r5.f31681c;
        r1 = r5.f31686h;
        r3 = r5.f31686h;
        r3 = r3.length;
        r0.mo5765a(r1, r2, r3);
        r0 = r5.f31681c;
        r1 = r5.f31684f;
        r3 = r5.f31684f;
        r3 = r3.length;
        r0.mo5765a(r1, r2, r3);
        r0 = r5.f31681c;
        r1 = r5.f31688j;
        r0.mo5761a(r1, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.generators.KDFCounterBytesGenerator.a():void");
    }
}
