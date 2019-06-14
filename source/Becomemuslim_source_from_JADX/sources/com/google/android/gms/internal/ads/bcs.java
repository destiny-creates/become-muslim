package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.ax;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@cm
public final class bcs implements bcg {
    /* renamed from: a */
    private final dl f23919a;
    /* renamed from: b */
    private final bcy f23920b;
    /* renamed from: c */
    private final Context f23921c;
    /* renamed from: d */
    private final bci f23922d;
    /* renamed from: e */
    private final boolean f23923e;
    /* renamed from: f */
    private final long f23924f;
    /* renamed from: g */
    private final long f23925g;
    /* renamed from: h */
    private final int f23926h;
    /* renamed from: i */
    private final Object f23927i = new Object();
    /* renamed from: j */
    private boolean f23928j = false;
    /* renamed from: k */
    private final Map<no<bcp>, bcm> f23929k = new HashMap();
    /* renamed from: l */
    private final boolean f23930l;
    /* renamed from: m */
    private final String f23931m;
    /* renamed from: n */
    private List<bcp> f23932n = new ArrayList();
    /* renamed from: o */
    private final boolean f23933o;

    public bcs(Context context, dl dlVar, bcy bcy, bci bci, boolean z, boolean z2, String str, long j, long j2, int i, boolean z3) {
        this.f23921c = context;
        this.f23919a = dlVar;
        this.f23920b = bcy;
        this.f23922d = bci;
        this.f23923e = z;
        this.f23930l = z2;
        this.f23931m = str;
        this.f23924f = j;
        this.f23925g = j2;
        this.f23926h = 2;
        this.f23933o = z3;
    }

    /* renamed from: a */
    private final void m30461a(no<bcp> noVar) {
        jw.f15691a.post(new bcu(this, noVar));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private final com.google.android.gms.internal.ads.bcp m30462b(java.util.List<com.google.android.gms.internal.ads.no<com.google.android.gms.internal.ads.bcp>> r4) {
        /*
        r3 = this;
        r0 = r3.f23927i;
        monitor-enter(r0);
        r1 = r3.f23928j;	 Catch:{ all -> 0x0047 }
        if (r1 == 0) goto L_0x000f;
    L_0x0007:
        r4 = new com.google.android.gms.internal.ads.bcp;	 Catch:{ all -> 0x0047 }
        r1 = -1;
        r4.<init>(r1);	 Catch:{ all -> 0x0047 }
        monitor-exit(r0);	 Catch:{ all -> 0x0047 }
        return r4;
    L_0x000f:
        monitor-exit(r0);	 Catch:{ all -> 0x0047 }
        r4 = r4.iterator();
    L_0x0014:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x003c;
    L_0x001a:
        r0 = r4.next();
        r0 = (com.google.android.gms.internal.ads.no) r0;
        r1 = r0.get();	 Catch:{ InterruptedException -> 0x0035, InterruptedException -> 0x0035 }
        r1 = (com.google.android.gms.internal.ads.bcp) r1;	 Catch:{ InterruptedException -> 0x0035, InterruptedException -> 0x0035 }
        r2 = r3.f23932n;	 Catch:{ InterruptedException -> 0x0035, InterruptedException -> 0x0035 }
        r2.add(r1);	 Catch:{ InterruptedException -> 0x0035, InterruptedException -> 0x0035 }
        if (r1 == 0) goto L_0x0014;
    L_0x002d:
        r2 = r1.f15220a;	 Catch:{ InterruptedException -> 0x0035, InterruptedException -> 0x0035 }
        if (r2 != 0) goto L_0x0014;
    L_0x0031:
        r3.m30461a(r0);	 Catch:{ InterruptedException -> 0x0035, InterruptedException -> 0x0035 }
        return r1;
    L_0x0035:
        r0 = move-exception;
        r1 = "Exception while processing an adapter; continuing with other adapters";
        com.google.android.gms.internal.ads.mt.m19921c(r1, r0);
        goto L_0x0014;
    L_0x003c:
        r4 = 0;
        r3.m30461a(r4);
        r4 = new com.google.android.gms.internal.ads.bcp;
        r0 = 1;
        r4.<init>(r0);
        return r4;
    L_0x0047:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0047 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bcs.b(java.util.List):com.google.android.gms.internal.ads.bcp");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private final com.google.android.gms.internal.ads.bcp m30465c(java.util.List<com.google.android.gms.internal.ads.no<com.google.android.gms.internal.ads.bcp>> r14) {
        /*
        r13 = this;
        r0 = r13.f23927i;
        monitor-enter(r0);
        r1 = r13.f23928j;	 Catch:{ all -> 0x00a7 }
        r2 = -1;
        if (r1 == 0) goto L_0x000f;
    L_0x0008:
        r14 = new com.google.android.gms.internal.ads.bcp;	 Catch:{ all -> 0x00a7 }
        r14.<init>(r2);	 Catch:{ all -> 0x00a7 }
        monitor-exit(r0);	 Catch:{ all -> 0x00a7 }
        return r14;
    L_0x000f:
        monitor-exit(r0);	 Catch:{ all -> 0x00a7 }
        r0 = r13.f23922d;
        r0 = r0.f15207n;
        r3 = -1;
        r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r0 == 0) goto L_0x001f;
    L_0x001a:
        r0 = r13.f23922d;
        r0 = r0.f15207n;
        goto L_0x0021;
    L_0x001f:
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
    L_0x0021:
        r14 = r14.iterator();
        r3 = 0;
        r1 = r0;
        r0 = r3;
        r4 = -1;
    L_0x0029:
        r5 = r14.hasNext();
        if (r5 == 0) goto L_0x009a;
    L_0x002f:
        r5 = r14.next();
        r5 = (com.google.android.gms.internal.ads.no) r5;
        r6 = com.google.android.gms.ads.internal.ax.l();
        r6 = r6.a();
        r8 = 0;
        r10 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1));
        if (r10 != 0) goto L_0x0054;
    L_0x0043:
        r10 = r5.isDone();	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        if (r10 == 0) goto L_0x0054;
    L_0x0049:
        r10 = r5.get();	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
    L_0x004d:
        r10 = (com.google.android.gms.internal.ads.bcp) r10;	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        goto L_0x005b;
    L_0x0050:
        r14 = move-exception;
        goto L_0x008c;
    L_0x0052:
        r5 = move-exception;
        goto L_0x0078;
    L_0x0054:
        r10 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        r10 = r5.get(r1, r10);	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        goto L_0x004d;
    L_0x005b:
        r11 = r13.f23932n;	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        r11.add(r10);	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        if (r10 == 0) goto L_0x007d;
    L_0x0062:
        r11 = r10.f15220a;	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        if (r11 != 0) goto L_0x007d;
    L_0x0066:
        r11 = r10.f15225f;	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        if (r11 == 0) goto L_0x007d;
    L_0x006a:
        r12 = r11.mo4144a();	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        if (r12 <= r4) goto L_0x007d;
    L_0x0070:
        r11 = r11.mo4144a();	 Catch:{ InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052, InterruptedException -> 0x0052 }
        r3 = r5;
        r0 = r10;
        r4 = r11;
        goto L_0x007d;
    L_0x0078:
        r10 = "Exception while processing an adapter; continuing with other adapters";
        com.google.android.gms.internal.ads.mt.m19921c(r10, r5);	 Catch:{ all -> 0x0050 }
    L_0x007d:
        r5 = com.google.android.gms.ads.internal.ax.l();
        r10 = r5.a();
        r10 = r10 - r6;
        r1 = r1 - r10;
        r1 = java.lang.Math.max(r1, r8);
        goto L_0x0029;
    L_0x008c:
        r0 = com.google.android.gms.ads.internal.ax.l();
        r3 = r0.a();
        r3 = r3 - r6;
        r1 = r1 - r3;
        java.lang.Math.max(r1, r8);
        throw r14;
    L_0x009a:
        r13.m30461a(r3);
        if (r0 != 0) goto L_0x00a6;
    L_0x009f:
        r14 = new com.google.android.gms.internal.ads.bcp;
        r0 = 1;
        r14.<init>(r0);
        return r14;
    L_0x00a6:
        return r0;
    L_0x00a7:
        r14 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00a7 }
        throw r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.bcs.c(java.util.List):com.google.android.gms.internal.ads.bcp");
    }

    /* renamed from: a */
    public final bcp mo4099a(List<bch> list) {
        mt.m19918b("Starting mediation.");
        ArrayList arrayList = new ArrayList();
        aou aou = this.f23919a.f28548d;
        int[] iArr = new int[2];
        if (aou.f28285g != null) {
            ax.x();
            if (bcr.m19238a(r0.f23931m, iArr)) {
                int i = 0;
                int i2 = iArr[0];
                int i3 = iArr[1];
                aou[] aouArr = aou.f28285g;
                int length = aouArr.length;
                while (i < length) {
                    aou aou2 = aouArr[i];
                    if (i2 == aou2.f28283e && i3 == aou2.f28280b) {
                        aou = aou2;
                        break;
                    }
                    i++;
                }
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bch bch = (bch) it.next();
            String str = "Trying mediation network: ";
            String valueOf = String.valueOf(bch.f15174b);
            mt.m19922d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            Iterator it2 = bch.f15175c.iterator();
            while (it2.hasNext()) {
                String str2 = (String) it2.next();
                Context context = r0.f23921c;
                bcy bcy = r0.f23920b;
                bci bci = r0.f23922d;
                aoq aoq = r0.f23919a.f28547c;
                mv mvVar = r0.f23919a.f28555k;
                boolean z = r0.f23923e;
                Iterator it3 = it;
                Iterator it4 = it2;
                ArrayList arrayList2 = arrayList;
                boolean z2 = z;
                bch bch2 = bch;
                aou aou3 = aou;
                mv mvVar2 = mvVar;
                bcm bcm = new bcm(context, str2, bcy, bci, bch2, aoq, aou3, mvVar2, z2, r0.f23930l, r0.f23919a.f28569y, r0.f23919a.f28558n, r0.f23919a.f28570z, r0.f23919a.f28542X, r0.f23933o);
                no a = ju.m19679a(new bct(r0, bcm));
                r0.f23929k.put(a, bcm);
                ArrayList arrayList3 = arrayList2;
                arrayList3.add(a);
                arrayList = arrayList3;
                it = it3;
                it2 = it4;
            }
        }
        List list2 = arrayList;
        return r0.f23926h != 2 ? m30462b(list2) : m30465c(list2);
    }

    /* renamed from: a */
    public final void mo4100a() {
        synchronized (this.f23927i) {
            this.f23928j = true;
            for (bcm a : this.f23929k.values()) {
                a.m30457a();
            }
        }
    }

    /* renamed from: b */
    public final List<bcp> mo4101b() {
        return this.f23932n;
    }
}
