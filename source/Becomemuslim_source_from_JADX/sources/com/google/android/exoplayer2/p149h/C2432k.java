package com.google.android.exoplayer2.p149h;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2329m.C2328a;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: SampleMetadataQueue */
/* renamed from: com.google.android.exoplayer2.h.k */
final class C2432k {
    /* renamed from: a */
    private int f6041a = 1000;
    /* renamed from: b */
    private int[] f6042b = new int[this.f6041a];
    /* renamed from: c */
    private long[] f6043c = new long[this.f6041a];
    /* renamed from: d */
    private int[] f6044d = new int[this.f6041a];
    /* renamed from: e */
    private int[] f6045e = new int[this.f6041a];
    /* renamed from: f */
    private long[] f6046f = new long[this.f6041a];
    /* renamed from: g */
    private C2328a[] f6047g = new C2328a[this.f6041a];
    /* renamed from: h */
    private C2515k[] f6048h = new C2515k[this.f6041a];
    /* renamed from: i */
    private int f6049i;
    /* renamed from: j */
    private int f6050j;
    /* renamed from: k */
    private int f6051k;
    /* renamed from: l */
    private int f6052l;
    /* renamed from: m */
    private long f6053m = Long.MIN_VALUE;
    /* renamed from: n */
    private long f6054n = Long.MIN_VALUE;
    /* renamed from: o */
    private boolean f6055o = true;
    /* renamed from: p */
    private boolean f6056p = true;
    /* renamed from: q */
    private C2515k f6057q;
    /* renamed from: r */
    private int f6058r;

    /* compiled from: SampleMetadataQueue */
    /* renamed from: com.google.android.exoplayer2.h.k$a */
    public static final class C2431a {
        /* renamed from: a */
        public int f6038a;
        /* renamed from: b */
        public long f6039b;
        /* renamed from: c */
        public C2328a f6040c;
    }

    /* renamed from: a */
    public void m6686a(boolean z) {
        this.f6049i = 0;
        this.f6050j = 0;
        this.f6051k = 0;
        this.f6052l = 0;
        this.f6055o = true;
        this.f6053m = Long.MIN_VALUE;
        this.f6054n = Long.MIN_VALUE;
        if (z) {
            this.f6057q = false;
            this.f6056p = true;
        }
    }

    /* renamed from: a */
    public int m6680a() {
        return this.f6050j + this.f6049i;
    }

    /* renamed from: a */
    public long m6683a(int i) {
        int a = m6680a() - i;
        boolean z = a >= 0 && a <= this.f6049i - this.f6052l;
        C2516a.m7017a(z);
        this.f6049i -= a;
        this.f6054n = Math.max(this.f6053m, m6678d(this.f6049i));
        if (this.f6049i == 0) {
            return 0;
        }
        i = m6679e(this.f6049i - 1);
        return this.f6043c[i] + ((long) this.f6044d[i]);
    }

    /* renamed from: b */
    public void m6690b(int i) {
        this.f6058r = i;
    }

    /* renamed from: b */
    public int m6688b() {
        return this.f6050j + this.f6052l;
    }

    /* renamed from: c */
    public int m6692c() {
        return m6693d() ? this.f6042b[m6679e(this.f6052l)] : this.f6058r;
    }

    /* renamed from: d */
    public synchronized boolean m6693d() {
        return this.f6052l != this.f6049i;
    }

    /* renamed from: e */
    public synchronized C2515k m6694e() {
        return this.f6056p ? null : this.f6057q;
    }

    /* renamed from: f */
    public synchronized long m6695f() {
        return this.f6054n;
    }

    /* renamed from: g */
    public synchronized void m6696g() {
        this.f6052l = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public synchronized int m6682a(com.google.android.exoplayer2.C2543l r5, com.google.android.exoplayer2.p135b.C4085e r6, boolean r7, boolean r8, com.google.android.exoplayer2.C2515k r9, com.google.android.exoplayer2.p149h.C2432k.C2431a r10) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.m6693d();	 Catch:{ all -> 0x006a }
        r1 = -5;
        r2 = -3;
        r3 = -4;
        if (r0 != 0) goto L_0x0024;
    L_0x000a:
        if (r8 == 0) goto L_0x0012;
    L_0x000c:
        r5 = 4;
        r6.a_(r5);	 Catch:{ all -> 0x006a }
        monitor-exit(r4);
        return r3;
    L_0x0012:
        r6 = r4.f6057q;	 Catch:{ all -> 0x006a }
        if (r6 == 0) goto L_0x0022;
    L_0x0016:
        if (r7 != 0) goto L_0x001c;
    L_0x0018:
        r6 = r4.f6057q;	 Catch:{ all -> 0x006a }
        if (r6 == r9) goto L_0x0022;
    L_0x001c:
        r6 = r4.f6057q;	 Catch:{ all -> 0x006a }
        r5.f6476a = r6;	 Catch:{ all -> 0x006a }
        monitor-exit(r4);
        return r1;
    L_0x0022:
        monitor-exit(r4);
        return r2;
    L_0x0024:
        r8 = r4.f6052l;	 Catch:{ all -> 0x006a }
        r8 = r4.m6679e(r8);	 Catch:{ all -> 0x006a }
        if (r7 != 0) goto L_0x0062;
    L_0x002c:
        r7 = r4.f6048h;	 Catch:{ all -> 0x006a }
        r7 = r7[r8];	 Catch:{ all -> 0x006a }
        if (r7 == r9) goto L_0x0033;
    L_0x0032:
        goto L_0x0062;
    L_0x0033:
        r5 = r6.m12754f();	 Catch:{ all -> 0x006a }
        if (r5 == 0) goto L_0x003b;
    L_0x0039:
        monitor-exit(r4);
        return r2;
    L_0x003b:
        r5 = r4.f6046f;	 Catch:{ all -> 0x006a }
        r0 = r5[r8];	 Catch:{ all -> 0x006a }
        r6.f10319c = r0;	 Catch:{ all -> 0x006a }
        r5 = r4.f6045e;	 Catch:{ all -> 0x006a }
        r5 = r5[r8];	 Catch:{ all -> 0x006a }
        r6.a_(r5);	 Catch:{ all -> 0x006a }
        r5 = r4.f6044d;	 Catch:{ all -> 0x006a }
        r5 = r5[r8];	 Catch:{ all -> 0x006a }
        r10.f6038a = r5;	 Catch:{ all -> 0x006a }
        r5 = r4.f6043c;	 Catch:{ all -> 0x006a }
        r6 = r5[r8];	 Catch:{ all -> 0x006a }
        r10.f6039b = r6;	 Catch:{ all -> 0x006a }
        r5 = r4.f6047g;	 Catch:{ all -> 0x006a }
        r5 = r5[r8];	 Catch:{ all -> 0x006a }
        r10.f6040c = r5;	 Catch:{ all -> 0x006a }
        r5 = r4.f6052l;	 Catch:{ all -> 0x006a }
        r5 = r5 + 1;
        r4.f6052l = r5;	 Catch:{ all -> 0x006a }
        monitor-exit(r4);
        return r3;
    L_0x0062:
        r6 = r4.f6048h;	 Catch:{ all -> 0x006a }
        r6 = r6[r8];	 Catch:{ all -> 0x006a }
        r5.f6476a = r6;	 Catch:{ all -> 0x006a }
        monitor-exit(r4);
        return r1;
    L_0x006a:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.k.a(com.google.android.exoplayer2.l, com.google.android.exoplayer2.b.e, boolean, boolean, com.google.android.exoplayer2.k, com.google.android.exoplayer2.h.k$a):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public synchronized int m6681a(long r9, boolean r11, boolean r12) {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = r8.f6052l;	 Catch:{ all -> 0x0039 }
        r2 = r8.m6679e(r0);	 Catch:{ all -> 0x0039 }
        r0 = r8.m6693d();	 Catch:{ all -> 0x0039 }
        r7 = -1;
        if (r0 == 0) goto L_0x0037;
    L_0x000e:
        r0 = r8.f6046f;	 Catch:{ all -> 0x0039 }
        r3 = r0[r2];	 Catch:{ all -> 0x0039 }
        r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1));
        if (r0 < 0) goto L_0x0037;
    L_0x0016:
        r0 = r8.f6054n;	 Catch:{ all -> 0x0039 }
        r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x001f;
    L_0x001c:
        if (r12 != 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0037;
    L_0x001f:
        r12 = r8.f6049i;	 Catch:{ all -> 0x0039 }
        r0 = r8.f6052l;	 Catch:{ all -> 0x0039 }
        r3 = r12 - r0;
        r1 = r8;
        r4 = r9;
        r6 = r11;
        r9 = r1.m6676a(r2, r3, r4, r6);	 Catch:{ all -> 0x0039 }
        if (r9 != r7) goto L_0x0030;
    L_0x002e:
        monitor-exit(r8);
        return r7;
    L_0x0030:
        r10 = r8.f6052l;	 Catch:{ all -> 0x0039 }
        r10 = r10 + r9;
        r8.f6052l = r10;	 Catch:{ all -> 0x0039 }
        monitor-exit(r8);
        return r9;
    L_0x0037:
        monitor-exit(r8);
        return r7;
    L_0x0039:
        r9 = move-exception;
        monitor-exit(r8);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.k.a(long, boolean, boolean):int");
    }

    /* renamed from: h */
    public synchronized int m6697h() {
        int i;
        i = this.f6049i - this.f6052l;
        this.f6052l = this.f6049i;
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public synchronized long m6689b(long r10, boolean r12, boolean r13) {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = r9.f6049i;	 Catch:{ all -> 0x0038 }
        r1 = -1;
        if (r0 == 0) goto L_0x0036;
    L_0x0007:
        r0 = r9.f6046f;	 Catch:{ all -> 0x0038 }
        r3 = r9.f6051k;	 Catch:{ all -> 0x0038 }
        r3 = r0[r3];	 Catch:{ all -> 0x0038 }
        r0 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1));
        if (r0 >= 0) goto L_0x0012;
    L_0x0011:
        goto L_0x0036;
    L_0x0012:
        if (r13 == 0) goto L_0x001f;
    L_0x0014:
        r13 = r9.f6052l;	 Catch:{ all -> 0x0038 }
        r0 = r9.f6049i;	 Catch:{ all -> 0x0038 }
        if (r13 == r0) goto L_0x001f;
    L_0x001a:
        r13 = r9.f6052l;	 Catch:{ all -> 0x0038 }
        r13 = r13 + 1;
        goto L_0x0021;
    L_0x001f:
        r13 = r9.f6049i;	 Catch:{ all -> 0x0038 }
    L_0x0021:
        r5 = r13;
        r4 = r9.f6051k;	 Catch:{ all -> 0x0038 }
        r3 = r9;
        r6 = r10;
        r8 = r12;
        r10 = r3.m6676a(r4, r5, r6, r8);	 Catch:{ all -> 0x0038 }
        r11 = -1;
        if (r10 != r11) goto L_0x0030;
    L_0x002e:
        monitor-exit(r9);
        return r1;
    L_0x0030:
        r10 = r9.m6677c(r10);	 Catch:{ all -> 0x0038 }
        monitor-exit(r9);
        return r10;
    L_0x0036:
        monitor-exit(r9);
        return r1;
    L_0x0038:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.k.b(long, boolean, boolean):long");
    }

    /* renamed from: i */
    public synchronized long m6698i() {
        if (this.f6052l == 0) {
            return -1;
        }
        return m6677c(this.f6052l);
    }

    /* renamed from: j */
    public synchronized long m6699j() {
        if (this.f6049i == 0) {
            return -1;
        }
        return m6677c(this.f6049i);
    }

    /* renamed from: a */
    public synchronized boolean m6687a(C2515k c2515k) {
        if (c2515k == null) {
            this.f6056p = true;
            return false;
        }
        this.f6056p = false;
        if (C2541v.m7179a((Object) c2515k, this.f6057q)) {
            return false;
        }
        this.f6057q = c2515k;
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public synchronized void m6685a(long r6, int r8, long r9, int r11, com.google.android.exoplayer2.p137e.C2329m.C2328a r12) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.f6055o;	 Catch:{ all -> 0x00cf }
        r1 = 0;
        if (r0 == 0) goto L_0x000e;
    L_0x0006:
        r0 = r8 & 1;
        if (r0 != 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r5);
        return;
    L_0x000c:
        r5.f6055o = r1;	 Catch:{ all -> 0x00cf }
    L_0x000e:
        r0 = r5.f6056p;	 Catch:{ all -> 0x00cf }
        r0 = r0 ^ 1;
        com.google.android.exoplayer2.p164l.C2516a.m7019b(r0);	 Catch:{ all -> 0x00cf }
        r5.m6684a(r6);	 Catch:{ all -> 0x00cf }
        r0 = r5.f6049i;	 Catch:{ all -> 0x00cf }
        r0 = r5.m6679e(r0);	 Catch:{ all -> 0x00cf }
        r2 = r5.f6046f;	 Catch:{ all -> 0x00cf }
        r2[r0] = r6;	 Catch:{ all -> 0x00cf }
        r6 = r5.f6043c;	 Catch:{ all -> 0x00cf }
        r6[r0] = r9;	 Catch:{ all -> 0x00cf }
        r6 = r5.f6044d;	 Catch:{ all -> 0x00cf }
        r6[r0] = r11;	 Catch:{ all -> 0x00cf }
        r6 = r5.f6045e;	 Catch:{ all -> 0x00cf }
        r6[r0] = r8;	 Catch:{ all -> 0x00cf }
        r6 = r5.f6047g;	 Catch:{ all -> 0x00cf }
        r6[r0] = r12;	 Catch:{ all -> 0x00cf }
        r6 = r5.f6048h;	 Catch:{ all -> 0x00cf }
        r7 = r5.f6057q;	 Catch:{ all -> 0x00cf }
        r6[r0] = r7;	 Catch:{ all -> 0x00cf }
        r6 = r5.f6042b;	 Catch:{ all -> 0x00cf }
        r7 = r5.f6058r;	 Catch:{ all -> 0x00cf }
        r6[r0] = r7;	 Catch:{ all -> 0x00cf }
        r6 = r5.f6049i;	 Catch:{ all -> 0x00cf }
        r6 = r6 + 1;
        r5.f6049i = r6;	 Catch:{ all -> 0x00cf }
        r6 = r5.f6049i;	 Catch:{ all -> 0x00cf }
        r7 = r5.f6041a;	 Catch:{ all -> 0x00cf }
        if (r6 != r7) goto L_0x00cd;
    L_0x004a:
        r6 = r5.f6041a;	 Catch:{ all -> 0x00cf }
        r6 = r6 + 1000;
        r7 = new int[r6];	 Catch:{ all -> 0x00cf }
        r8 = new long[r6];	 Catch:{ all -> 0x00cf }
        r9 = new long[r6];	 Catch:{ all -> 0x00cf }
        r10 = new int[r6];	 Catch:{ all -> 0x00cf }
        r11 = new int[r6];	 Catch:{ all -> 0x00cf }
        r12 = new com.google.android.exoplayer2.p137e.C2329m.C2328a[r6];	 Catch:{ all -> 0x00cf }
        r0 = new com.google.android.exoplayer2.C2515k[r6];	 Catch:{ all -> 0x00cf }
        r2 = r5.f6041a;	 Catch:{ all -> 0x00cf }
        r3 = r5.f6051k;	 Catch:{ all -> 0x00cf }
        r2 = r2 - r3;
        r3 = r5.f6043c;	 Catch:{ all -> 0x00cf }
        r4 = r5.f6051k;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r3, r4, r8, r1, r2);	 Catch:{ all -> 0x00cf }
        r3 = r5.f6046f;	 Catch:{ all -> 0x00cf }
        r4 = r5.f6051k;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r3, r4, r9, r1, r2);	 Catch:{ all -> 0x00cf }
        r3 = r5.f6045e;	 Catch:{ all -> 0x00cf }
        r4 = r5.f6051k;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r3, r4, r10, r1, r2);	 Catch:{ all -> 0x00cf }
        r3 = r5.f6044d;	 Catch:{ all -> 0x00cf }
        r4 = r5.f6051k;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r3, r4, r11, r1, r2);	 Catch:{ all -> 0x00cf }
        r3 = r5.f6047g;	 Catch:{ all -> 0x00cf }
        r4 = r5.f6051k;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r3, r4, r12, r1, r2);	 Catch:{ all -> 0x00cf }
        r3 = r5.f6048h;	 Catch:{ all -> 0x00cf }
        r4 = r5.f6051k;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r3, r4, r0, r1, r2);	 Catch:{ all -> 0x00cf }
        r3 = r5.f6042b;	 Catch:{ all -> 0x00cf }
        r4 = r5.f6051k;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r3, r4, r7, r1, r2);	 Catch:{ all -> 0x00cf }
        r3 = r5.f6051k;	 Catch:{ all -> 0x00cf }
        r4 = r5.f6043c;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r4, r1, r8, r2, r3);	 Catch:{ all -> 0x00cf }
        r4 = r5.f6046f;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r4, r1, r9, r2, r3);	 Catch:{ all -> 0x00cf }
        r4 = r5.f6045e;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r4, r1, r10, r2, r3);	 Catch:{ all -> 0x00cf }
        r4 = r5.f6044d;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r4, r1, r11, r2, r3);	 Catch:{ all -> 0x00cf }
        r4 = r5.f6047g;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r4, r1, r12, r2, r3);	 Catch:{ all -> 0x00cf }
        r4 = r5.f6048h;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r4, r1, r0, r2, r3);	 Catch:{ all -> 0x00cf }
        r4 = r5.f6042b;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r4, r1, r7, r2, r3);	 Catch:{ all -> 0x00cf }
        r5.f6043c = r8;	 Catch:{ all -> 0x00cf }
        r5.f6046f = r9;	 Catch:{ all -> 0x00cf }
        r5.f6045e = r10;	 Catch:{ all -> 0x00cf }
        r5.f6044d = r11;	 Catch:{ all -> 0x00cf }
        r5.f6047g = r12;	 Catch:{ all -> 0x00cf }
        r5.f6048h = r0;	 Catch:{ all -> 0x00cf }
        r5.f6042b = r7;	 Catch:{ all -> 0x00cf }
        r5.f6051k = r1;	 Catch:{ all -> 0x00cf }
        r7 = r5.f6041a;	 Catch:{ all -> 0x00cf }
        r5.f6049i = r7;	 Catch:{ all -> 0x00cf }
        r5.f6041a = r6;	 Catch:{ all -> 0x00cf }
    L_0x00cd:
        monitor-exit(r5);
        return;
    L_0x00cf:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.k.a(long, int, long, int, com.google.android.exoplayer2.e.m$a):void");
    }

    /* renamed from: a */
    public synchronized void m6684a(long j) {
        this.f6054n = Math.max(this.f6054n, j);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public synchronized boolean m6691b(long r8) {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = r7.f6049i;	 Catch:{ all -> 0x004a }
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x0010;
    L_0x0007:
        r3 = r7.f6053m;	 Catch:{ all -> 0x004a }
        r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1));
        if (r8 <= 0) goto L_0x000e;
    L_0x000d:
        r1 = 1;
    L_0x000e:
        monitor-exit(r7);
        return r1;
    L_0x0010:
        r3 = r7.f6053m;	 Catch:{ all -> 0x004a }
        r0 = r7.f6052l;	 Catch:{ all -> 0x004a }
        r5 = r7.m6678d(r0);	 Catch:{ all -> 0x004a }
        r3 = java.lang.Math.max(r3, r5);	 Catch:{ all -> 0x004a }
        r0 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1));
        if (r0 < 0) goto L_0x0022;
    L_0x0020:
        monitor-exit(r7);
        return r1;
    L_0x0022:
        r0 = r7.f6049i;	 Catch:{ all -> 0x004a }
        r1 = r7.f6049i;	 Catch:{ all -> 0x004a }
        r1 = r1 - r2;
        r1 = r7.m6679e(r1);	 Catch:{ all -> 0x004a }
    L_0x002b:
        r3 = r7.f6052l;	 Catch:{ all -> 0x004a }
        if (r0 <= r3) goto L_0x0042;
    L_0x002f:
        r3 = r7.f6046f;	 Catch:{ all -> 0x004a }
        r4 = r3[r1];	 Catch:{ all -> 0x004a }
        r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r3 < 0) goto L_0x0042;
    L_0x0037:
        r0 = r0 + -1;
        r1 = r1 + -1;
        r3 = -1;
        if (r1 != r3) goto L_0x002b;
    L_0x003e:
        r1 = r7.f6041a;	 Catch:{ all -> 0x004a }
        r1 = r1 - r2;
        goto L_0x002b;
    L_0x0042:
        r8 = r7.f6050j;	 Catch:{ all -> 0x004a }
        r8 = r8 + r0;
        r7.m6683a(r8);	 Catch:{ all -> 0x004a }
        monitor-exit(r7);
        return r2;
    L_0x004a:
        r8 = move-exception;
        monitor-exit(r7);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.k.b(long):boolean");
    }

    /* renamed from: a */
    private int m6676a(int i, int i2, long j, boolean z) {
        int i3 = i;
        int i4 = -1;
        for (i = 0; i < i2 && this.f6046f[i3] <= j; i++) {
            if (!(z && (this.f6045e[i3] & 1) == 0)) {
                i4 = i;
            }
            i3++;
            if (i3 == this.f6041a) {
                i3 = 0;
            }
        }
        return i4;
    }

    /* renamed from: c */
    private long m6677c(int i) {
        this.f6053m = Math.max(this.f6053m, m6678d(i));
        this.f6049i -= i;
        this.f6050j += i;
        this.f6051k += i;
        if (this.f6051k >= this.f6041a) {
            this.f6051k -= this.f6041a;
        }
        this.f6052l -= i;
        if (this.f6052l < 0) {
            this.f6052l = 0;
        }
        if (this.f6049i != 0) {
            return this.f6043c[this.f6051k];
        }
        i = (this.f6051k == 0 ? this.f6041a : this.f6051k) - 1;
        return this.f6043c[i] + ((long) this.f6044d[i]);
    }

    /* renamed from: d */
    private long m6678d(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int e = m6679e(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            j = Math.max(j, this.f6046f[e]);
            if ((this.f6045e[e] & 1) != 0) {
                break;
            }
            e--;
            if (e == -1) {
                e = this.f6041a - 1;
            }
        }
        return j;
    }

    /* renamed from: e */
    private int m6679e(int i) {
        int i2 = this.f6051k + i;
        return i2 < this.f6041a ? i2 : i2 - this.f6041a;
    }
}
