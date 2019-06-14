package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.ax;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@cm
public final class bcv implements bcg {
    /* renamed from: a */
    private final dl f23934a;
    /* renamed from: b */
    private final bcy f23935b;
    /* renamed from: c */
    private final Context f23936c;
    /* renamed from: d */
    private final Object f23937d = new Object();
    /* renamed from: e */
    private final bci f23938e;
    /* renamed from: f */
    private final boolean f23939f;
    /* renamed from: g */
    private final long f23940g;
    /* renamed from: h */
    private final long f23941h;
    /* renamed from: i */
    private final atc f23942i;
    /* renamed from: j */
    private final boolean f23943j;
    /* renamed from: k */
    private final String f23944k;
    /* renamed from: l */
    private boolean f23945l = false;
    /* renamed from: m */
    private bcm f23946m;
    /* renamed from: n */
    private List<bcp> f23947n = new ArrayList();
    /* renamed from: o */
    private final boolean f23948o;

    public bcv(Context context, dl dlVar, bcy bcy, bci bci, boolean z, boolean z2, String str, long j, long j2, atc atc, boolean z3) {
        this.f23936c = context;
        this.f23934a = dlVar;
        this.f23935b = bcy;
        this.f23938e = bci;
        this.f23939f = z;
        this.f23943j = z2;
        this.f23944k = str;
        this.f23940g = j;
        this.f23941h = j2;
        this.f23942i = atc;
        this.f23948o = z3;
    }

    /* renamed from: a */
    public final bcp mo4099a(List<bch> list) {
        mt.m19918b("Starting mediation.");
        Iterable arrayList = new ArrayList();
        ata a = this.f23942i.m18916a();
        aou aou = this.f23934a.f28548d;
        int[] iArr = new int[2];
        if (aou.f28285g != null) {
            ax.x();
            if (bcr.m19238a(r1.f23944k, iArr)) {
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
                bcp bcp;
                valueOf = (String) it2.next();
                ata a2 = r1.f23942i.m18916a();
                Object obj = r1.f23937d;
                synchronized (obj) {
                    try {
                        if (r1.f23945l) {
                            bcp = new bcp(-1);
                        } else {
                            Iterator it3 = it;
                            Iterator it4 = it2;
                            ata ata = a;
                            bcm bcm = bcm;
                            ata ata2 = a2;
                            bcm bcm2 = bcm;
                            Object obj2 = obj;
                            try {
                                bcm = new bcm(r1.f23936c, valueOf, r1.f23935b, r1.f23938e, bch, r1.f23934a.f28547c, aou, r1.f23934a.f28555k, r1.f23939f, r1.f23943j, r1.f23934a.f28569y, r1.f23934a.f28558n, r1.f23934a.f28570z, r1.f23934a.f28542X, r1.f23948o);
                                r1.f23946m = bcm2;
                                bcp a3 = r1.f23946m.m30456a(r1.f23940g, r1.f23941h);
                                r1.f23947n.add(a3);
                                if (a3.f15220a == 0) {
                                    mt.m19918b("Adapter succeeded.");
                                    r1.f23942i.m18920a("mediation_network_succeed", valueOf);
                                    if (!arrayList.isEmpty()) {
                                        r1.f23942i.m18920a("mediation_networks_fail", TextUtils.join(",", arrayList));
                                    }
                                    r1.f23942i.m18922a(ata2, "mls");
                                    r1.f23942i.m18922a(ata, "ttm");
                                    return a3;
                                }
                                ata ata3 = ata;
                                ata ata4 = ata2;
                                arrayList.add(valueOf);
                                r1.f23942i.m18922a(ata4, "mlf");
                                if (a3.f15222c != null) {
                                    jw.f15691a.post(new bcw(r1, a3));
                                }
                                a = ata3;
                                it = it3;
                                it2 = it4;
                            } catch (Throwable th) {
                                Throwable th2 = th;
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        obj2 = obj;
                    }
                }
                return bcp;
            }
        }
        if (!arrayList.isEmpty()) {
            r1.f23942i.m18920a("mediation_networks_fail", TextUtils.join(",", arrayList));
        }
        return new bcp(1);
    }

    /* renamed from: a */
    public final void mo4100a() {
        synchronized (this.f23937d) {
            this.f23945l = true;
            if (this.f23946m != null) {
                this.f23946m.m30457a();
            }
        }
    }

    /* renamed from: b */
    public final List<bcp> mo4101b() {
        return this.f23947n;
    }
}
