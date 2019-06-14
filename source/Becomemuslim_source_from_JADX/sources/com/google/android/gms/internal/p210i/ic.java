package com.google.android.gms.internal.p210i;

import com.google.android.gms.internal.p210i.fk.C4996e;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.i.ic */
public final class ic {
    /* renamed from: a */
    private static final ic f16690a = new ic(0, new int[0], new Object[0], false);
    /* renamed from: b */
    private int f16691b;
    /* renamed from: c */
    private int[] f16692c;
    /* renamed from: d */
    private Object[] f16693d;
    /* renamed from: e */
    private int f16694e;
    /* renamed from: f */
    private boolean f16695f;

    /* renamed from: a */
    public static ic m20783a() {
        return f16690a;
    }

    /* renamed from: b */
    static ic m20786b() {
        return new ic();
    }

    /* renamed from: a */
    static ic m20784a(ic icVar, ic icVar2) {
        int i = icVar.f16691b + icVar2.f16691b;
        Object copyOf = Arrays.copyOf(icVar.f16692c, i);
        System.arraycopy(icVar2.f16692c, 0, copyOf, icVar.f16691b, icVar2.f16691b);
        Object copyOf2 = Arrays.copyOf(icVar.f16693d, i);
        System.arraycopy(icVar2.f16693d, 0, copyOf2, icVar.f16691b, icVar2.f16691b);
        return new ic(i, copyOf, copyOf2, true);
    }

    private ic() {
        this(0, new int[8], new Object[8], true);
    }

    private ic(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f16694e = -1;
        this.f16691b = i;
        this.f16692c = iArr;
        this.f16693d = objArr;
        this.f16695f = z;
    }

    /* renamed from: c */
    public final void m20791c() {
        this.f16695f = false;
    }

    /* renamed from: a */
    final void m20788a(ix ixVar) {
        int i;
        if (ixVar.mo4501a() == C4996e.f16613k) {
            for (i = this.f16691b - 1; i >= 0; i--) {
                ixVar.mo4509a(this.f16692c[i] >>> 3, this.f16693d[i]);
            }
            return;
        }
        for (i = 0; i < this.f16691b; i++) {
            ixVar.mo4509a(this.f16692c[i] >>> 3, this.f16693d[i]);
        }
    }

    /* renamed from: b */
    public final void m20790b(ix ixVar) {
        if (this.f16691b != 0) {
            int i;
            if (ixVar.mo4501a() == C4996e.f16612j) {
                for (i = 0; i < this.f16691b; i++) {
                    ic.m20785a(this.f16692c[i], this.f16693d[i], ixVar);
                }
                return;
            }
            for (i = this.f16691b - 1; i >= 0; i--) {
                ic.m20785a(this.f16692c[i], this.f16693d[i], ixVar);
            }
        }
    }

    /* renamed from: a */
    private static void m20785a(int i, Object obj, ix ixVar) {
        int i2 = i >>> 3;
        i &= 7;
        if (i != 5) {
            switch (i) {
                case 0:
                    ixVar.mo4506a(i2, ((Long) obj).longValue());
                    return;
                case 1:
                    ixVar.mo4527d(i2, ((Long) obj).longValue());
                    return;
                case 2:
                    ixVar.mo4507a(i2, (dy) obj);
                    return;
                case 3:
                    if (ixVar.mo4501a() == C4996e.f16612j) {
                        ixVar.mo4502a(i2);
                        ((ic) obj).m20790b(ixVar);
                        ixVar.mo4516b(i2);
                        return;
                    }
                    ixVar.mo4516b(i2);
                    ((ic) obj).m20790b(ixVar);
                    ixVar.mo4502a(i2);
                    return;
                default:
                    throw new RuntimeException(fs.m20572e());
            }
        }
        ixVar.mo4526d(i2, ((Integer) obj).intValue());
    }

    /* renamed from: d */
    public final int m20792d() {
        int i = this.f16694e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (i = 0; i < this.f16691b; i++) {
            i2 += eq.m31458d(this.f16692c[i] >>> 3, (dy) this.f16693d[i]);
        }
        this.f16694e = i2;
        return i2;
    }

    /* renamed from: e */
    public final int m20793e() {
        int i = this.f16694e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (i = 0; i < this.f16691b; i++) {
            int i3 = this.f16692c[i];
            int i4 = i3 >>> 3;
            i3 &= 7;
            if (i3 != 5) {
                switch (i3) {
                    case 0:
                        i2 += eq.m31462e(i4, ((Long) this.f16693d[i]).longValue());
                        break;
                    case 1:
                        i2 += eq.m31470g(i4, ((Long) this.f16693d[i]).longValue());
                        break;
                    case 2:
                        i2 += eq.m31452c(i4, (dy) this.f16693d[i]);
                        break;
                    case 3:
                        i2 += (eq.m31461e(i4) << 1) + ((ic) this.f16693d[i]).m20793e();
                        break;
                    default:
                        throw new IllegalStateException(fs.m20572e());
                }
            }
            i2 += eq.m31477i(i4, ((Integer) this.f16693d[i]).intValue());
        }
        this.f16694e = i2;
        return i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ic)) {
            return false;
        }
        ic icVar = (ic) obj;
        if (this.f16691b == icVar.f16691b) {
            Object obj2;
            int[] iArr = this.f16692c;
            int[] iArr2 = icVar.f16692c;
            int i = this.f16691b;
            for (int i2 = 0; i2 < i; i2++) {
                if (iArr[i2] != iArr2[i2]) {
                    obj2 = null;
                    break;
                }
            }
            obj2 = 1;
            if (obj2 != null) {
                Object[] objArr = this.f16693d;
                obj = icVar.f16693d;
                int i3 = this.f16691b;
                for (i = 0; i < i3; i++) {
                    if (!objArr[i].equals(obj[i])) {
                        obj = null;
                        break;
                    }
                }
                obj = true;
                if (obj != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.f16691b + 527) * 31;
        int[] iArr = this.f16692c;
        int i2 = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < this.f16691b; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        i = (i + i3) * 31;
        Object[] objArr = this.f16693d;
        for (int i5 = 0; i5 < this.f16691b; i5++) {
            i2 = (i2 * 31) + objArr[i5].hashCode();
        }
        return i + i2;
    }

    /* renamed from: a */
    final void m20789a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < this.f16691b; i2++) {
            gw.m20622a(stringBuilder, i, String.valueOf(this.f16692c[i2] >>> 3), this.f16693d[i2]);
        }
    }

    /* renamed from: a */
    final void m20787a(int i, Object obj) {
        if (this.f16695f) {
            if (this.f16691b == this.f16692c.length) {
                int i2 = this.f16691b + (this.f16691b < 4 ? 8 : this.f16691b >> 1);
                this.f16692c = Arrays.copyOf(this.f16692c, i2);
                this.f16693d = Arrays.copyOf(this.f16693d, i2);
            }
            this.f16692c[this.f16691b] = i;
            this.f16693d[this.f16691b] = obj;
            this.f16691b++;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
