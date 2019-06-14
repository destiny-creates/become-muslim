package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class akc implements ayg {
    /* renamed from: a */
    private final Map<String, List<awi<?>>> f23681a = new HashMap();
    /* renamed from: b */
    private final aia f23682b;

    akc(aia aia) {
        this.f23682b = aia;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private final synchronized boolean m30009b(com.google.android.gms.internal.ads.awi<?> r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r6.m19065e();	 Catch:{ all -> 0x0052 }
        r1 = r5.f23681a;	 Catch:{ all -> 0x0052 }
        r1 = r1.containsKey(r0);	 Catch:{ all -> 0x0052 }
        r2 = 1;
        r3 = 0;
        if (r1 == 0) goto L_0x003a;
    L_0x000f:
        r1 = r5.f23681a;	 Catch:{ all -> 0x0052 }
        r1 = r1.get(r0);	 Catch:{ all -> 0x0052 }
        r1 = (java.util.List) r1;	 Catch:{ all -> 0x0052 }
        if (r1 != 0) goto L_0x001e;
    L_0x0019:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x0052 }
        r1.<init>();	 Catch:{ all -> 0x0052 }
    L_0x001e:
        r4 = "waiting-for-response";
        r6.m19061b(r4);	 Catch:{ all -> 0x0052 }
        r1.add(r6);	 Catch:{ all -> 0x0052 }
        r6 = r5.f23681a;	 Catch:{ all -> 0x0052 }
        r6.put(r0, r1);	 Catch:{ all -> 0x0052 }
        r6 = com.google.android.gms.internal.ads.eg.f15334a;	 Catch:{ all -> 0x0052 }
        if (r6 == 0) goto L_0x0038;
    L_0x002f:
        r6 = "Request for cacheKey=%s is in flight, putting on hold.";
        r1 = new java.lang.Object[r2];	 Catch:{ all -> 0x0052 }
        r1[r3] = r0;	 Catch:{ all -> 0x0052 }
        com.google.android.gms.internal.ads.eg.m19390b(r6, r1);	 Catch:{ all -> 0x0052 }
    L_0x0038:
        monitor-exit(r5);
        return r2;
    L_0x003a:
        r1 = r5.f23681a;	 Catch:{ all -> 0x0052 }
        r4 = 0;
        r1.put(r0, r4);	 Catch:{ all -> 0x0052 }
        r6.m19055a(r5);	 Catch:{ all -> 0x0052 }
        r6 = com.google.android.gms.internal.ads.eg.f15334a;	 Catch:{ all -> 0x0052 }
        if (r6 == 0) goto L_0x0050;
    L_0x0047:
        r6 = "new request, sending to network %s";
        r1 = new java.lang.Object[r2];	 Catch:{ all -> 0x0052 }
        r1[r3] = r0;	 Catch:{ all -> 0x0052 }
        com.google.android.gms.internal.ads.eg.m19390b(r6, r1);	 Catch:{ all -> 0x0052 }
    L_0x0050:
        monitor-exit(r5);
        return r3;
    L_0x0052:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.akc.b(com.google.android.gms.internal.ads.awi):boolean");
    }

    /* renamed from: a */
    public final synchronized void mo3834a(awi<?> awi) {
        String e = awi.m19065e();
        List list = (List) this.f23681a.remove(e);
        if (!(list == null || list.isEmpty())) {
            if (eg.f15334a) {
                eg.m19388a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), e);
            }
            awi awi2 = (awi) list.remove(0);
            this.f23681a.put(e, list);
            awi2.m19055a((ayg) this);
            try {
                this.f23682b.f14554c.put(awi2);
            } catch (InterruptedException e2) {
                eg.m19391c("Couldn't add request to queue. %s", e2.toString());
                Thread.currentThread().interrupt();
                this.f23682b.m18475a();
            }
        }
    }

    /* renamed from: a */
    public final void mo3835a(awi<?> awi, bck<?> bck) {
        if (bck.f15215b != null) {
            if (!bck.f15215b.m18416a()) {
                List<awi> list;
                String e = awi.m19065e();
                synchronized (this) {
                    list = (List) this.f23681a.remove(e);
                }
                if (list != null) {
                    if (eg.f15334a) {
                        eg.m19388a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), e);
                    }
                    for (awi a : list) {
                        this.f23682b.f14556e.mo3851a(a, (bck) bck);
                    }
                }
                return;
            }
        }
        mo3834a(awi);
    }
}
