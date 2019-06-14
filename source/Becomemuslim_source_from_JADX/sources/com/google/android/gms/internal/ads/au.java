package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

@cm
public final class au extends ak {
    /* renamed from: g */
    protected bcp f32199g;
    /* renamed from: h */
    private bcy f32200h;
    /* renamed from: i */
    private bcg f32201i;
    /* renamed from: j */
    private bci f32202j;
    /* renamed from: k */
    private final atc f32203k;
    /* renamed from: l */
    private final qo f32204l;
    /* renamed from: m */
    private boolean f32205m;

    au(Context context, it itVar, bcy bcy, ap apVar, atc atc, qo qoVar) {
        super(context, itVar, apVar);
        this.f32200h = bcy;
        this.f32202j = itVar.f15602c;
        this.f32203k = atc;
        this.f32204l = qoVar;
    }

    /* renamed from: a */
    protected final is mo6644a(int i) {
        bci bci;
        dr drVar;
        String str;
        String str2;
        boolean z;
        long j;
        dl dlVar = this.e.f15600a;
        aoq aoq = dlVar.f28547c;
        qo qoVar = this.f32204l;
        List list = this.f.f28598c;
        List list2 = this.f.f28600e;
        List list3 = this.f.f28604i;
        int i2 = this.f.f28606k;
        long j2 = this.f.f28605j;
        String str3 = dlVar.f28553i;
        boolean z2 = this.f.f28602g;
        bch bch = this.f32199g != null ? r0.f32199g.f15221b : null;
        bdb bdb = r0.f32199g != null ? r0.f32199g.f15222c : null;
        String name = r0.f32199g != null ? r0.f32199g.f15223d : AdMobAdapter.class.getName();
        bci bci2 = r0.f32202j;
        bcl bcl = r0.f32199g != null ? r0.f32199g.f15224e : null;
        bch bch2 = bch;
        bdb bdb2 = bdb;
        long j3 = r0.f.f28603h;
        aou aou = r0.e.f15603d;
        long j4 = j3;
        long j5 = r0.f.f28601f;
        long j6 = r0.e.f15605f;
        j3 = r0.f.f28608m;
        String str4 = r0.f.f28609n;
        JSONObject jSONObject = r0.e.f15607h;
        hq hqVar = r0.f.f28572A;
        List list4 = r0.f.f28573B;
        List list5 = r0.f.f28574C;
        aou aou2 = aou;
        boolean z3 = r0.f32202j != null ? r0.f32202j.f15208o : false;
        dr drVar2 = r0.f.f28576E;
        if (r0.f32201i != null) {
            List b = r0.f32201i.mo4101b();
            String str5 = "";
            if (b == null) {
                bci = bci2;
                drVar = drVar2;
                str = str5.toString();
                str2 = str3;
                z = z2;
                j = j3;
            } else {
                Iterator it = b.iterator();
                String str6 = str5;
                while (it.hasNext()) {
                    Iterator it2;
                    drVar = drVar2;
                    bcp bcp = (bcp) it.next();
                    if (bcp != null) {
                        it2 = it;
                        if (bcp.f15221b == null || TextUtils.isEmpty(bcp.f15221b.f15176d)) {
                            bci = bci2;
                        } else {
                            int i3;
                            String valueOf = String.valueOf(str6);
                            j = j3;
                            String str7 = bcp.f15221b.f15176d;
                            switch (bcp.f15220a) {
                                case -1:
                                    i3 = 4;
                                    break;
                                case 0:
                                    bci = bci2;
                                    i3 = 0;
                                    break;
                                case 1:
                                    bci = bci2;
                                    i3 = 1;
                                    break;
                                case 3:
                                    i3 = 2;
                                    break;
                                case 4:
                                    i3 = 3;
                                    break;
                                case 5:
                                    i3 = 5;
                                    break;
                                default:
                                    i3 = 6;
                                    break;
                            }
                            bci = bci2;
                            long j7 = bcp.f15226g;
                            z = z2;
                            str2 = str3;
                            StringBuilder stringBuilder = new StringBuilder(String.valueOf(str7).length() + 33);
                            stringBuilder.append(str7);
                            stringBuilder.append(".");
                            stringBuilder.append(i3);
                            stringBuilder.append(".");
                            stringBuilder.append(j7);
                            String stringBuilder2 = stringBuilder.toString();
                            stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(stringBuilder2).length());
                            stringBuilder.append(valueOf);
                            stringBuilder.append(stringBuilder2);
                            stringBuilder.append("_");
                            str6 = stringBuilder.toString();
                            drVar2 = drVar;
                            it = it2;
                            j3 = j;
                            bci2 = bci;
                            z2 = z;
                            str3 = str2;
                        }
                    } else {
                        bci = bci2;
                        it2 = it;
                    }
                    str2 = str3;
                    z = z2;
                    j = j3;
                    drVar2 = drVar;
                    it = it2;
                    j3 = j;
                    bci2 = bci;
                    z2 = z;
                    str3 = str2;
                }
                bci = bci2;
                drVar = drVar2;
                str2 = str3;
                z = z2;
                j = j3;
                str = str6.substring(0, Math.max(0, str6.length() - 1));
            }
        } else {
            bci = bci2;
            drVar = drVar2;
            str2 = str3;
            z = z2;
            j = j3;
            str = null;
        }
        return new is(aoq, qoVar, list, i, list2, list3, i2, j2, str2, z, bch2, bdb2, name, bci, bcl, j4, aou2, j5, j6, j, str4, jSONObject, null, hqVar, list4, list5, z3, drVar, str, r0.f.f28579H, r0.f.f28583L, r0.e.f15608i, r0.f.f28586O, r0.e.f15609j, r0.f.f28588Q, r0.f.f28589R, r0.f.f28590S, r0.f.f28591T);
    }

    /* renamed from: a */
    protected final void mo6645a(long j) {
        boolean z;
        ListIterator listIterator;
        StringBuilder stringBuilder;
        synchronized (this.d) {
            if (r1.f32202j.f15206m != -1) {
                long j2 = j;
                bcg bcs = new bcs(r1.b, r1.e.f15600a, r1.f32200h, r1.f32202j, r1.f.f28614s, r1.f.f28621z, r1.f.f28581J, j2, ((Long) aph.m18688f().m18889a(asp.bB)).longValue(), 2, r1.e.f15609j);
            } else {
                bcg bcv = new bcv(r1.b, r1.e.f15600a, r1.f32200h, r1.f32202j, r1.f.f28614s, r1.f.f28621z, r1.f.f28581J, j, ((Long) aph.m18688f().m18889a(asp.bB)).longValue(), r1.f32203k, r1.e.f15609j);
            }
            r1.f32201i = r0;
        }
        List arrayList = new ArrayList(r1.f32202j.f15194a);
        Bundle bundle = r1.e.f15600a.f28547c.f28273m;
        String str = "com.google.ads.mediation.admob.AdMobAdapter";
        if (bundle != null) {
            bundle = bundle.getBundle(str);
            if (bundle != null) {
                z = bundle.getBoolean("_skipMediation");
                if (z) {
                    listIterator = arrayList.listIterator();
                    while (listIterator.hasNext()) {
                        if (!((bch) listIterator.next()).f15175c.contains(str)) {
                            listIterator.remove();
                        }
                    }
                }
                r1.f32199g = r1.f32201i.mo4099a(arrayList);
                switch (r1.f32199g.f15220a) {
                    case 0:
                        if (r1.f32199g.f15221b == null && r1.f32199g.f15221b.f15187o != null) {
                            CountDownLatch countDownLatch = new CountDownLatch(1);
                            jw.f15691a.post(new av(r1, countDownLatch));
                            try {
                                countDownLatch.await(10, TimeUnit.SECONDS);
                                synchronized (r1.d) {
                                    if (!r1.f32205m) {
                                        throw new an("View could not be prepared", 0);
                                    } else if (r1.f32204l.mo6660A()) {
                                        throw new an("Assets not loaded, web view is destroyed", 0);
                                    }
                                }
                                return;
                            } catch (InterruptedException e) {
                                String valueOf = String.valueOf(e);
                                stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 38);
                                stringBuilder.append("Interrupted while waiting for latch : ");
                                stringBuilder.append(valueOf);
                                throw new an(stringBuilder.toString(), 0);
                            }
                        }
                        return;
                    case 1:
                        throw new an("No fill from any mediation ad networks.", 3);
                    default:
                        int i = r1.f32199g.f15220a;
                        stringBuilder = new StringBuilder(40);
                        stringBuilder.append("Unexpected mediation result: ");
                        stringBuilder.append(i);
                        throw new an(stringBuilder.toString(), 0);
                }
            }
        }
        z = false;
        if (z) {
            listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (!((bch) listIterator.next()).f15175c.contains(str)) {
                    listIterator.remove();
                }
            }
        }
        r1.f32199g = r1.f32201i.mo4099a(arrayList);
        switch (r1.f32199g.f15220a) {
            case 0:
                if (r1.f32199g.f15221b == null) {
                    break;
                }
                return;
            case 1:
                throw new an("No fill from any mediation ad networks.", 3);
            default:
                int i2 = r1.f32199g.f15220a;
                stringBuilder = new StringBuilder(40);
                stringBuilder.append("Unexpected mediation result: ");
                stringBuilder.append(i2);
                throw new an(stringBuilder.toString(), 0);
        }
    }

    public final void h_() {
        synchronized (this.d) {
            super.h_();
            if (this.f32201i != null) {
                this.f32201i.mo4100a();
            }
        }
    }
}
