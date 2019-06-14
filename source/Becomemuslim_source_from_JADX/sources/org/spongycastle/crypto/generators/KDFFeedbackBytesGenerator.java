package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.MacDerivationFunction;
import org.spongycastle.crypto.params.KDFFeedbackParameters;
import org.spongycastle.crypto.params.KeyParameter;

public class KDFFeedbackBytesGenerator implements MacDerivationFunction {
    /* renamed from: a */
    private static final BigInteger f31700a = BigInteger.valueOf(2147483647L);
    /* renamed from: b */
    private static final BigInteger f31701b = BigInteger.valueOf(2);
    /* renamed from: c */
    private final Mac f31702c;
    /* renamed from: d */
    private final int f31703d;
    /* renamed from: e */
    private byte[] f31704e;
    /* renamed from: f */
    private int f31705f;
    /* renamed from: g */
    private byte[] f31706g;
    /* renamed from: h */
    private byte[] f31707h;
    /* renamed from: i */
    private boolean f31708i;
    /* renamed from: j */
    private int f31709j;
    /* renamed from: k */
    private byte[] f31710k;

    /* renamed from: a */
    public void mo5727a(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFFeedbackParameters) {
            KDFFeedbackParameters kDFFeedbackParameters = (KDFFeedbackParameters) derivationParameters;
            this.f31702c.mo5764a(new KeyParameter(kDFFeedbackParameters.m35678a()));
            this.f31704e = kDFFeedbackParameters.m35682e();
            int d = kDFFeedbackParameters.m35681d();
            this.f31706g = new byte[(d / 8)];
            int i = Integer.MAX_VALUE;
            if (kDFFeedbackParameters.m35680c()) {
                BigInteger multiply = f31701b.pow(d).multiply(BigInteger.valueOf((long) this.f31703d));
                if (multiply.compareTo(f31700a) != 1) {
                    i = multiply.intValue();
                }
                this.f31705f = i;
            } else {
                this.f31705f = Integer.MAX_VALUE;
            }
            this.f31707h = kDFFeedbackParameters.m35679b();
            this.f31708i = kDFFeedbackParameters.m35680c();
            this.f31709j = null;
            return;
        }
        throw new IllegalArgumentException("Wrong type of arguments given");
    }

    /* renamed from: a */
    public int mo5726a(byte[] bArr, int i, int i2) {
        int i3 = this.f31709j + i2;
        if (i3 < 0 || i3 >= this.f31705f) {
            i = new StringBuilder();
            i.append("Current KDFCTR may only be used for ");
            i.append(this.f31705f);
            i.append(" bytes");
            throw new DataLengthException(i.toString());
        }
        if (this.f31709j % this.f31703d == 0) {
            m40739a();
        }
        i3 = this.f31709j % this.f31703d;
        int min = Math.min(this.f31703d - (this.f31709j % this.f31703d), i2);
        System.arraycopy(this.f31710k, i3, bArr, i, min);
        this.f31709j += min;
        i3 = i2 - min;
        i += min;
        while (i3 > 0) {
            m40739a();
            min = Math.min(this.f31703d, i3);
            System.arraycopy(this.f31710k, 0, bArr, i, min);
            this.f31709j += min;
            i3 -= min;
            i += min;
        }
        return i2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m40739a() {
        /*
        r5 = this;
        r0 = r5.f31709j;
        r1 = 0;
        if (r0 != 0) goto L_0x0010;
    L_0x0005:
        r0 = r5.f31702c;
        r2 = r5.f31707h;
        r3 = r5.f31707h;
        r3 = r3.length;
        r0.mo5765a(r2, r1, r3);
        goto L_0x001a;
    L_0x0010:
        r0 = r5.f31702c;
        r2 = r5.f31710k;
        r3 = r5.f31710k;
        r3 = r3.length;
        r0.mo5765a(r2, r1, r3);
    L_0x001a:
        r0 = r5.f31708i;
        if (r0 == 0) goto L_0x0066;
    L_0x001e:
        r0 = r5.f31709j;
        r2 = r5.f31703d;
        r0 = r0 / r2;
        r0 = r0 + 1;
        r2 = r5.f31706g;
        r2 = r2.length;
        switch(r2) {
            case 1: goto L_0x0052;
            case 2: goto L_0x0046;
            case 3: goto L_0x003a;
            case 4: goto L_0x0033;
            default: goto L_0x002b;
        };
    L_0x002b:
        r0 = new java.lang.IllegalStateException;
        r1 = "Unsupported size of counter i";
        r0.<init>(r1);
        throw r0;
    L_0x0033:
        r2 = r5.f31706g;
        r3 = r0 >>> 24;
        r3 = (byte) r3;
        r2[r1] = r3;
    L_0x003a:
        r2 = r5.f31706g;
        r3 = r5.f31706g;
        r3 = r3.length;
        r3 = r3 + -3;
        r4 = r0 >>> 16;
        r4 = (byte) r4;
        r2[r3] = r4;
    L_0x0046:
        r2 = r5.f31706g;
        r3 = r5.f31706g;
        r3 = r3.length;
        r3 = r3 + -2;
        r4 = r0 >>> 8;
        r4 = (byte) r4;
        r2[r3] = r4;
    L_0x0052:
        r2 = r5.f31706g;
        r3 = r5.f31706g;
        r3 = r3.length;
        r3 = r3 + -1;
        r0 = (byte) r0;
        r2[r3] = r0;
        r0 = r5.f31702c;
        r2 = r5.f31706g;
        r3 = r5.f31706g;
        r3 = r3.length;
        r0.mo5765a(r2, r1, r3);
    L_0x0066:
        r0 = r5.f31702c;
        r2 = r5.f31704e;
        r3 = r5.f31704e;
        r3 = r3.length;
        r0.mo5765a(r2, r1, r3);
        r0 = r5.f31702c;
        r2 = r5.f31710k;
        r0.mo5761a(r2, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.generators.KDFFeedbackBytesGenerator.a():void");
    }
}
