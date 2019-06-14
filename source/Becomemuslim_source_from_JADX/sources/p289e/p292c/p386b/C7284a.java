package p289e.p292c.p386b;

import p289e.C5984g;

/* compiled from: ProducerArbiter */
/* renamed from: e.c.b.a */
public final class C7284a implements C5984g {
    /* renamed from: g */
    static final C5984g f25630g = new C72831();
    /* renamed from: a */
    long f25631a;
    /* renamed from: b */
    C5984g f25632b;
    /* renamed from: c */
    boolean f25633c;
    /* renamed from: d */
    long f25634d;
    /* renamed from: e */
    long f25635e;
    /* renamed from: f */
    C5984g f25636f;

    /* compiled from: ProducerArbiter */
    /* renamed from: e.c.b.a$1 */
    static class C72831 implements C5984g {
        /* renamed from: a */
        public void mo5119a(long j) {
        }

        C72831() {
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void mo5119a(long r6) {
        /*
        r5 = this;
        r0 = 0;
        r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r2 < 0) goto L_0x0041;
    L_0x0006:
        if (r2 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        monitor-enter(r5);
        r2 = r5.f25633c;	 Catch:{ all -> 0x003e }
        if (r2 == 0) goto L_0x0016;
    L_0x000e:
        r0 = r5.f25634d;	 Catch:{ all -> 0x003e }
        r2 = 0;
        r0 = r0 + r6;
        r5.f25634d = r0;	 Catch:{ all -> 0x003e }
        monitor-exit(r5);	 Catch:{ all -> 0x003e }
        return;
    L_0x0016:
        r2 = 1;
        r5.f25633c = r2;	 Catch:{ all -> 0x003e }
        monitor-exit(r5);	 Catch:{ all -> 0x003e }
        r2 = r5.f25631a;	 Catch:{ all -> 0x0034 }
        r4 = 0;
        r2 = r2 + r6;
        r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x0027;
    L_0x0022:
        r2 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
    L_0x0027:
        r5.f25631a = r2;	 Catch:{ all -> 0x0034 }
        r0 = r5.f25632b;	 Catch:{ all -> 0x0034 }
        if (r0 == 0) goto L_0x0030;
    L_0x002d:
        r0.mo5119a(r6);	 Catch:{ all -> 0x0034 }
    L_0x0030:
        r5.m33597a();	 Catch:{ all -> 0x0034 }
        return;
    L_0x0034:
        r6 = move-exception;
        monitor-enter(r5);
        r7 = 0;
        r5.f25633c = r7;	 Catch:{ all -> 0x003b }
        monitor-exit(r5);	 Catch:{ all -> 0x003b }
        throw r6;
    L_0x003b:
        r6 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x003b }
        throw r6;
    L_0x003e:
        r6 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x003e }
        throw r6;
    L_0x0041:
        r6 = new java.lang.IllegalArgumentException;
        r7 = "n >= 0 required";
        r6.<init>(r7);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.b.a.a(long):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public void m33600b(long r7) {
        /*
        r6 = this;
        r0 = 0;
        r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1));
        if (r2 <= 0) goto L_0x0043;
    L_0x0006:
        monitor-enter(r6);
        r2 = r6.f25633c;	 Catch:{ all -> 0x0040 }
        if (r2 == 0) goto L_0x0013;
    L_0x000b:
        r0 = r6.f25635e;	 Catch:{ all -> 0x0040 }
        r2 = 0;
        r0 = r0 + r7;
        r6.f25635e = r0;	 Catch:{ all -> 0x0040 }
        monitor-exit(r6);	 Catch:{ all -> 0x0040 }
        return;
    L_0x0013:
        r2 = 1;
        r6.f25633c = r2;	 Catch:{ all -> 0x0040 }
        monitor-exit(r6);	 Catch:{ all -> 0x0040 }
        r2 = r6.f25631a;	 Catch:{ all -> 0x0036 }
        r4 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 == 0) goto L_0x0032;
    L_0x0022:
        r2 = r2 - r7;
        r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r7 < 0) goto L_0x002a;
    L_0x0027:
        r6.f25631a = r2;	 Catch:{ all -> 0x0036 }
        goto L_0x0032;
    L_0x002a:
        r7 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0036 }
        r8 = "more items arrived than were requested";
        r7.<init>(r8);	 Catch:{ all -> 0x0036 }
        throw r7;	 Catch:{ all -> 0x0036 }
    L_0x0032:
        r6.m33597a();	 Catch:{ all -> 0x0036 }
        return;
    L_0x0036:
        r7 = move-exception;
        monitor-enter(r6);
        r8 = 0;
        r6.f25633c = r8;	 Catch:{ all -> 0x003d }
        monitor-exit(r6);	 Catch:{ all -> 0x003d }
        throw r7;
    L_0x003d:
        r7 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x003d }
        throw r7;
    L_0x0040:
        r7 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0040 }
        throw r7;
    L_0x0043:
        r7 = new java.lang.IllegalArgumentException;
        r8 = "n > 0 required";
        r7.<init>(r8);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.b.a.b(long):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m33599a(p289e.C5984g r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.f25633c;	 Catch:{ all -> 0x0028 }
        if (r0 == 0) goto L_0x000d;
    L_0x0005:
        if (r3 != 0) goto L_0x0009;
    L_0x0007:
        r3 = f25630g;	 Catch:{ all -> 0x0028 }
    L_0x0009:
        r2.f25636f = r3;	 Catch:{ all -> 0x0028 }
        monitor-exit(r2);	 Catch:{ all -> 0x0028 }
        return;
    L_0x000d:
        r0 = 1;
        r2.f25633c = r0;	 Catch:{ all -> 0x0028 }
        monitor-exit(r2);	 Catch:{ all -> 0x0028 }
        r2.f25632b = r3;	 Catch:{ all -> 0x001e }
        if (r3 == 0) goto L_0x001a;
    L_0x0015:
        r0 = r2.f25631a;	 Catch:{ all -> 0x001e }
        r3.mo5119a(r0);	 Catch:{ all -> 0x001e }
    L_0x001a:
        r2.m33597a();	 Catch:{ all -> 0x001e }
        return;
    L_0x001e:
        r3 = move-exception;
        monitor-enter(r2);
        r0 = 0;
        r2.f25633c = r0;	 Catch:{ all -> 0x0025 }
        monitor-exit(r2);	 Catch:{ all -> 0x0025 }
        throw r3;
    L_0x0025:
        r3 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0025 }
        throw r3;
    L_0x0028:
        r3 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0028 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.b.a.a(e.g):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m33597a() {
        /*
        r14 = this;
    L_0x0000:
        monitor-enter(r14);
        r0 = r14.f25634d;	 Catch:{ all -> 0x0062 }
        r2 = r14.f25635e;	 Catch:{ all -> 0x0062 }
        r4 = r14.f25636f;	 Catch:{ all -> 0x0062 }
        r5 = 0;
        r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1));
        if (r7 != 0) goto L_0x0018;
    L_0x000d:
        r8 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1));
        if (r8 != 0) goto L_0x0018;
    L_0x0011:
        if (r4 != 0) goto L_0x0018;
    L_0x0013:
        r0 = 0;
        r14.f25633c = r0;	 Catch:{ all -> 0x0062 }
        monitor-exit(r14);	 Catch:{ all -> 0x0062 }
        return;
    L_0x0018:
        r14.f25634d = r5;	 Catch:{ all -> 0x0062 }
        r14.f25635e = r5;	 Catch:{ all -> 0x0062 }
        r8 = 0;
        r14.f25636f = r8;	 Catch:{ all -> 0x0062 }
        monitor-exit(r14);	 Catch:{ all -> 0x0062 }
        r9 = r14.f25631a;
        r11 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
        if (r13 == 0) goto L_0x0049;
    L_0x002b:
        r9 = r9 + r0;
        r13 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r13 < 0) goto L_0x0046;
    L_0x0030:
        r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
        if (r13 != 0) goto L_0x0035;
    L_0x0034:
        goto L_0x0046;
    L_0x0035:
        r11 = 0;
        r9 = r9 - r2;
        r2 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r2 < 0) goto L_0x003e;
    L_0x003b:
        r14.f25631a = r9;
        goto L_0x0049;
    L_0x003e:
        r0 = new java.lang.IllegalStateException;
        r1 = "more produced than requested";
        r0.<init>(r1);
        throw r0;
    L_0x0046:
        r14.f25631a = r11;
        r9 = r11;
    L_0x0049:
        if (r4 == 0) goto L_0x0058;
    L_0x004b:
        r0 = f25630g;
        if (r4 != r0) goto L_0x0052;
    L_0x004f:
        r14.f25632b = r8;
        goto L_0x0000;
    L_0x0052:
        r14.f25632b = r4;
        r4.mo5119a(r9);
        goto L_0x0000;
    L_0x0058:
        r2 = r14.f25632b;
        if (r2 == 0) goto L_0x0000;
    L_0x005c:
        if (r7 == 0) goto L_0x0000;
    L_0x005e:
        r2.mo5119a(r0);
        goto L_0x0000;
    L_0x0062:
        r0 = move-exception;
        monitor-exit(r14);	 Catch:{ all -> 0x0062 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.b.a.a():void");
    }
}
