package expolib_v1.p321a.p322a.p327e;

import com.facebook.soloader.MinElf;
import java.util.Arrays;

/* compiled from: Settings */
/* renamed from: expolib_v1.a.a.e.n */
public final class C6186n {
    /* renamed from: a */
    private int f20030a;
    /* renamed from: b */
    private final int[] f20031b = new int[10];

    /* renamed from: a */
    void m25465a() {
        this.f20030a = 0;
        Arrays.fill(this.f20031b, 0);
    }

    /* renamed from: a */
    C6186n m25464a(int i, int i2) {
        if (i >= this.f20031b.length) {
            return this;
        }
        this.f20030a = (1 << i) | this.f20030a;
        this.f20031b[i] = i2;
        return this;
    }

    /* renamed from: a */
    boolean m25467a(int i) {
        return ((1 << i) & this.f20030a) != 0;
    }

    /* renamed from: b */
    int m25469b(int i) {
        return this.f20031b[i];
    }

    /* renamed from: b */
    int m25468b() {
        return Integer.bitCount(this.f20030a);
    }

    /* renamed from: c */
    int m25470c() {
        return (this.f20030a & 2) != 0 ? this.f20031b[1] : -1;
    }

    /* renamed from: c */
    int m25471c(int i) {
        return (this.f20030a & 16) != 0 ? this.f20031b[4] : i;
    }

    /* renamed from: d */
    int m25473d(int i) {
        return (this.f20030a & 32) != 0 ? this.f20031b[5] : i;
    }

    /* renamed from: d */
    int m25472d() {
        return (this.f20030a & 128) != 0 ? this.f20031b[7] : MinElf.PN_XNUM;
    }

    /* renamed from: a */
    void m25466a(C6186n c6186n) {
        for (int i = 0; i < 10; i++) {
            if (c6186n.m25467a(i)) {
                m25464a(i, c6186n.m25469b(i));
            }
        }
    }
}
