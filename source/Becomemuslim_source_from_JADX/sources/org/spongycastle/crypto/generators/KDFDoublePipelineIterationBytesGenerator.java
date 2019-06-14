package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.MacDerivationFunction;
import org.spongycastle.crypto.params.KDFDoublePipelineIterationParameters;
import org.spongycastle.crypto.params.KeyParameter;

public class KDFDoublePipelineIterationBytesGenerator implements MacDerivationFunction {
    /* renamed from: a */
    private static final BigInteger f31689a = BigInteger.valueOf(2147483647L);
    /* renamed from: b */
    private static final BigInteger f31690b = BigInteger.valueOf(2);
    /* renamed from: c */
    private final Mac f31691c;
    /* renamed from: d */
    private final int f31692d;
    /* renamed from: e */
    private byte[] f31693e;
    /* renamed from: f */
    private int f31694f;
    /* renamed from: g */
    private byte[] f31695g;
    /* renamed from: h */
    private boolean f31696h;
    /* renamed from: i */
    private int f31697i;
    /* renamed from: j */
    private byte[] f31698j;
    /* renamed from: k */
    private byte[] f31699k;

    /* renamed from: a */
    public void mo5727a(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFDoublePipelineIterationParameters) {
            KDFDoublePipelineIterationParameters kDFDoublePipelineIterationParameters = (KDFDoublePipelineIterationParameters) derivationParameters;
            this.f31691c.mo5764a(new KeyParameter(kDFDoublePipelineIterationParameters.m35674a()));
            this.f31693e = kDFDoublePipelineIterationParameters.m35677d();
            int c = kDFDoublePipelineIterationParameters.m35676c();
            this.f31695g = new byte[(c / 8)];
            int i = Integer.MAX_VALUE;
            if (kDFDoublePipelineIterationParameters.m35675b()) {
                BigInteger multiply = f31690b.pow(c).multiply(BigInteger.valueOf((long) this.f31692d));
                if (multiply.compareTo(f31689a) != 1) {
                    i = multiply.intValue();
                }
                this.f31694f = i;
            } else {
                this.f31694f = Integer.MAX_VALUE;
            }
            this.f31696h = kDFDoublePipelineIterationParameters.m35675b();
            this.f31697i = null;
            return;
        }
        throw new IllegalArgumentException("Wrong type of arguments given");
    }

    /* renamed from: a */
    public int mo5726a(byte[] bArr, int i, int i2) {
        int i3 = this.f31697i + i2;
        if (i3 < 0 || i3 >= this.f31694f) {
            i = new StringBuilder();
            i.append("Current KDFCTR may only be used for ");
            i.append(this.f31694f);
            i.append(" bytes");
            throw new DataLengthException(i.toString());
        }
        if (this.f31697i % this.f31692d == 0) {
            m40736a();
        }
        i3 = this.f31697i % this.f31692d;
        int min = Math.min(this.f31692d - (this.f31697i % this.f31692d), i2);
        System.arraycopy(this.f31699k, i3, bArr, i, min);
        this.f31697i += min;
        i3 = i2 - min;
        i += min;
        while (i3 > 0) {
            m40736a();
            min = Math.min(this.f31692d, i3);
            System.arraycopy(this.f31699k, 0, bArr, i, min);
            this.f31697i += min;
            i3 -= min;
            i += min;
        }
        return i2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m40736a() {
        /*
        r5 = this;
        r0 = r5.f31697i;
        r1 = 0;
        if (r0 != 0) goto L_0x0017;
    L_0x0005:
        r0 = r5.f31691c;
        r2 = r5.f31693e;
        r3 = r5.f31693e;
        r3 = r3.length;
        r0.mo5765a(r2, r1, r3);
        r0 = r5.f31691c;
        r2 = r5.f31698j;
        r0.mo5761a(r2, r1);
        goto L_0x0028;
    L_0x0017:
        r0 = r5.f31691c;
        r2 = r5.f31698j;
        r3 = r5.f31698j;
        r3 = r3.length;
        r0.mo5765a(r2, r1, r3);
        r0 = r5.f31691c;
        r2 = r5.f31698j;
        r0.mo5761a(r2, r1);
    L_0x0028:
        r0 = r5.f31691c;
        r2 = r5.f31698j;
        r3 = r5.f31698j;
        r3 = r3.length;
        r0.mo5765a(r2, r1, r3);
        r0 = r5.f31696h;
        if (r0 == 0) goto L_0x007e;
    L_0x0036:
        r0 = r5.f31697i;
        r2 = r5.f31692d;
        r0 = r0 / r2;
        r0 = r0 + 1;
        r2 = r5.f31695g;
        r2 = r2.length;
        switch(r2) {
            case 1: goto L_0x006a;
            case 2: goto L_0x005e;
            case 3: goto L_0x0052;
            case 4: goto L_0x004b;
            default: goto L_0x0043;
        };
    L_0x0043:
        r0 = new java.lang.IllegalStateException;
        r1 = "Unsupported size of counter i";
        r0.<init>(r1);
        throw r0;
    L_0x004b:
        r2 = r5.f31695g;
        r3 = r0 >>> 24;
        r3 = (byte) r3;
        r2[r1] = r3;
    L_0x0052:
        r2 = r5.f31695g;
        r3 = r5.f31695g;
        r3 = r3.length;
        r3 = r3 + -3;
        r4 = r0 >>> 16;
        r4 = (byte) r4;
        r2[r3] = r4;
    L_0x005e:
        r2 = r5.f31695g;
        r3 = r5.f31695g;
        r3 = r3.length;
        r3 = r3 + -2;
        r4 = r0 >>> 8;
        r4 = (byte) r4;
        r2[r3] = r4;
    L_0x006a:
        r2 = r5.f31695g;
        r3 = r5.f31695g;
        r3 = r3.length;
        r3 = r3 + -1;
        r0 = (byte) r0;
        r2[r3] = r0;
        r0 = r5.f31691c;
        r2 = r5.f31695g;
        r3 = r5.f31695g;
        r3 = r3.length;
        r0.mo5765a(r2, r1, r3);
    L_0x007e:
        r0 = r5.f31691c;
        r2 = r5.f31693e;
        r3 = r5.f31693e;
        r3 = r3.length;
        r0.mo5765a(r2, r1, r3);
        r0 = r5.f31691c;
        r2 = r5.f31699k;
        r0.mo5761a(r2, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.generators.KDFDoublePipelineIterationBytesGenerator.a():void");
    }
}
