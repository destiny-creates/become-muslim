package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;
import java.util.Arrays;

public final class aek {
    /* renamed from: a */
    private static final aek f14337a = new aek(0, new int[0], new Object[0], false);
    /* renamed from: b */
    private int f14338b;
    /* renamed from: c */
    private int[] f14339c;
    /* renamed from: d */
    private Object[] f14340d;
    /* renamed from: e */
    private int f14341e;
    /* renamed from: f */
    private boolean f14342f;

    private aek() {
        this(0, new int[8], new Object[8], true);
    }

    private aek(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f14341e = -1;
        this.f14338b = i;
        this.f14339c = iArr;
        this.f14340d = objArr;
        this.f14342f = z;
    }

    /* renamed from: a */
    public static aek m18195a() {
        return f14337a;
    }

    /* renamed from: a */
    static aek m18196a(aek aek, aek aek2) {
        int i = aek.f14338b + aek2.f14338b;
        Object copyOf = Arrays.copyOf(aek.f14339c, i);
        System.arraycopy(aek2.f14339c, 0, copyOf, aek.f14338b, aek2.f14338b);
        Object copyOf2 = Arrays.copyOf(aek.f14340d, i);
        System.arraycopy(aek2.f14340d, 0, copyOf2, aek.f14338b, aek2.f14338b);
        return new aek(i, copyOf, copyOf2, true);
    }

    /* renamed from: a */
    private static void m18197a(int i, Object obj, afd afd) {
        int i2 = i >>> 3;
        i &= 7;
        if (i != 5) {
            switch (i) {
                case 0:
                    afd.mo3690a(i2, ((Long) obj).longValue());
                    return;
                case 1:
                    afd.mo3711d(i2, ((Long) obj).longValue());
                    return;
                case 2:
                    afd.mo3691a(i2, (aai) obj);
                    return;
                case 3:
                    if (afd.mo3685a() == C4918e.f14231j) {
                        afd.mo3686a(i2);
                        ((aek) obj).m18202b(afd);
                        afd.mo3700b(i2);
                        return;
                    }
                    afd.mo3700b(i2);
                    ((aek) obj).m18202b(afd);
                    afd.mo3686a(i2);
                    return;
                default:
                    throw new RuntimeException(abw.m17950f());
            }
        }
        afd.mo3710d(i2, ((Integer) obj).intValue());
    }

    /* renamed from: b */
    static aek m18198b() {
        return new aek();
    }

    /* renamed from: a */
    final void m18199a(int i, Object obj) {
        if (this.f14342f) {
            if (this.f14338b == this.f14339c.length) {
                int i2 = this.f14338b + (this.f14338b < 4 ? 8 : this.f14338b >> 1);
                this.f14339c = Arrays.copyOf(this.f14339c, i2);
                this.f14340d = Arrays.copyOf(this.f14340d, i2);
            }
            this.f14339c[this.f14338b] = i;
            this.f14340d[this.f14338b] = obj;
            this.f14338b++;
            return;
        }
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    final void m18200a(afd afd) {
        int i;
        if (afd.mo3685a() == C4918e.f14232k) {
            for (i = this.f14338b - 1; i >= 0; i--) {
                afd.mo3693a(this.f14339c[i] >>> 3, this.f14340d[i]);
            }
            return;
        }
        for (i = 0; i < this.f14338b; i++) {
            afd.mo3693a(this.f14339c[i] >>> 3, this.f14340d[i]);
        }
    }

    /* renamed from: a */
    final void m18201a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < this.f14338b; i2++) {
            ada.m18002a(stringBuilder, i, String.valueOf(this.f14339c[i2] >>> 3), this.f14340d[i2]);
        }
    }

    /* renamed from: b */
    public final void m18202b(afd afd) {
        if (this.f14338b != 0) {
            int i;
            if (afd.mo3685a() == C4918e.f14231j) {
                for (i = 0; i < this.f14338b; i++) {
                    m18197a(this.f14339c[i], this.f14340d[i], afd);
                }
                return;
            }
            for (i = this.f14338b - 1; i >= 0; i--) {
                m18197a(this.f14339c[i], this.f14340d[i], afd);
            }
        }
    }

    /* renamed from: c */
    public final void m18203c() {
        this.f14342f = false;
    }

    /* renamed from: d */
    public final int m18204d() {
        int i = this.f14341e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (i = 0; i < this.f14338b; i++) {
            i2 += aaw.m29615d(this.f14339c[i] >>> 3, (aai) this.f14340d[i]);
        }
        this.f14341e = i2;
        return i2;
    }

    /* renamed from: e */
    public final int m18205e() {
        int i = this.f14341e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (i = 0; i < this.f14338b; i++) {
            int i3 = this.f14339c[i];
            int i4 = i3 >>> 3;
            i3 &= 7;
            if (i3 != 5) {
                switch (i3) {
                    case 0:
                        i3 = aaw.m29618e(i4, ((Long) this.f14340d[i]).longValue());
                        break;
                    case 1:
                        i3 = aaw.m29626g(i4, ((Long) this.f14340d[i]).longValue());
                        break;
                    case 2:
                        i3 = aaw.m29610c(i4, (aai) this.f14340d[i]);
                        break;
                    case 3:
                        i3 = (aaw.m29617e(i4) << 1) + ((aek) this.f14340d[i]).m18205e();
                        break;
                    default:
                        throw new IllegalStateException(abw.m17950f());
                }
            }
            i3 = aaw.m29633i(i4, ((Integer) this.f14340d[i]).intValue());
            i2 += i3;
        }
        this.f14341e = i2;
        return i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof aek)) {
            return false;
        }
        aek aek = (aek) obj;
        if (this.f14338b == aek.f14338b) {
            Object obj2;
            int[] iArr = this.f14339c;
            int[] iArr2 = aek.f14339c;
            int i = this.f14338b;
            for (int i2 = 0; i2 < i; i2++) {
                if (iArr[i2] != iArr2[i2]) {
                    obj2 = null;
                    break;
                }
            }
            obj2 = 1;
            if (obj2 != null) {
                Object[] objArr = this.f14340d;
                Object[] objArr2 = aek.f14340d;
                int i3 = this.f14338b;
                for (i = 0; i < i3; i++) {
                    if (!objArr[i].equals(objArr2[i])) {
                        obj = null;
                        break;
                    }
                }
                obj = 1;
                if (obj != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.f14338b + 527) * 31;
        int[] iArr = this.f14339c;
        int i2 = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < this.f14338b; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        i = (i + i3) * 31;
        Object[] objArr = this.f14340d;
        for (int i5 = 0; i5 < this.f14338b; i5++) {
            i2 = (i2 * 31) + objArr[i5].hashCode();
        }
        return i + i2;
    }
}
