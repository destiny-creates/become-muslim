package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class aay implements afd {
    /* renamed from: a */
    private final aaw f23533a;

    private aay(aaw aaw) {
        this.f23533a = (aaw) abs.m17935a((Object) aaw, "output");
    }

    /* renamed from: a */
    public static aay m29676a(aaw aaw) {
        return aaw.f23532a != null ? aaw.f23532a : new aay(aaw);
    }

    /* renamed from: a */
    public final int mo3685a() {
        return C4918e.f14231j;
    }

    /* renamed from: a */
    public final void mo3686a(int i) {
        this.f23533a.mo6049a(i, 3);
    }

    /* renamed from: a */
    public final void mo3687a(int i, double d) {
        this.f23533a.m29646a(i, d);
    }

    /* renamed from: a */
    public final void mo3688a(int i, float f) {
        this.f23533a.m29647a(i, f);
    }

    /* renamed from: a */
    public final void mo3689a(int i, int i2) {
        this.f23533a.mo6070e(i, i2);
    }

    /* renamed from: a */
    public final void mo3690a(int i, long j) {
        this.f23533a.mo6050a(i, j);
    }

    /* renamed from: a */
    public final void mo3691a(int i, aai aai) {
        this.f23533a.mo6051a(i, aai);
    }

    /* renamed from: a */
    public final <K, V> void mo3692a(int i, acq<K, V> acq, Map<K, V> map) {
        for (Entry entry : map.entrySet()) {
            this.f23533a.mo6049a(i, 2);
            this.f23533a.mo6061b(acp.m17972a(acq, entry.getKey(), entry.getValue()));
            acp.m17973a(this.f23533a, acq, entry.getKey(), entry.getValue());
        }
    }

    /* renamed from: a */
    public final void mo3693a(int i, Object obj) {
        if (obj instanceof aai) {
            this.f23533a.mo6063b(i, (aai) obj);
        } else {
            this.f23533a.mo6052a(i, (acx) obj);
        }
    }

    /* renamed from: a */
    public final void mo3694a(int i, Object obj, adq adq) {
        this.f23533a.mo6053a(i, (acx) obj, adq);
    }

    /* renamed from: a */
    public final void mo3695a(int i, String str) {
        this.f23533a.mo6054a(i, str);
    }

    /* renamed from: a */
    public final void mo3696a(int i, List<String> list) {
        int i2 = 0;
        if (list instanceof acg) {
            acg acg = (acg) list;
            while (i2 < list.size()) {
                Object b = acg.mo3790b(i2);
                if (b instanceof String) {
                    this.f23533a.mo6054a(i, (String) b);
                } else {
                    this.f23533a.mo6051a(i, (aai) b);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f23533a.mo6054a(i, (String) list.get(i2));
            i2++;
        }
    }

    /* renamed from: a */
    public final void mo3697a(int i, List<?> list, adq adq) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo3694a(i, list.get(i2), adq);
        }
    }

    /* renamed from: a */
    public final void mo3698a(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f23533a.mo6049a(i, 2);
            int i3 = 0;
            for (i = 0; i < list.size(); i++) {
                i3 += aaw.m29620f(((Integer) list.get(i)).intValue());
            }
            this.f23533a.mo6061b(i3);
            while (i2 < list.size()) {
                this.f23533a.mo6048a(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f23533a.mo6062b(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: a */
    public final void mo3699a(int i, boolean z) {
        this.f23533a.mo6055a(i, z);
    }

    /* renamed from: b */
    public final void mo3700b(int i) {
        this.f23533a.mo6049a(i, 4);
    }

    /* renamed from: b */
    public final void mo3701b(int i, int i2) {
        this.f23533a.mo6062b(i, i2);
    }

    /* renamed from: b */
    public final void mo3702b(int i, long j) {
        this.f23533a.mo6066c(i, j);
    }

    /* renamed from: b */
    public final void mo3703b(int i, Object obj, adq adq) {
        aaw aaw = this.f23533a;
        obj = (acx) obj;
        aaw.mo6049a(i, 3);
        adq.mo3756a(obj, aaw.f23532a);
        aaw.mo6049a(i, 4);
    }

    /* renamed from: b */
    public final void mo3704b(int i, List<aai> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f23533a.mo6051a(i, (aai) list.get(i2));
        }
    }

    /* renamed from: b */
    public final void mo3705b(int i, List<?> list, adq adq) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo3703b(i, list.get(i2), adq);
        }
    }

    /* renamed from: b */
    public final void mo3706b(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f23533a.mo6049a(i, 2);
            int i3 = 0;
            for (i = 0; i < list.size(); i++) {
                i3 += aaw.m29632i(((Integer) list.get(i)).intValue());
            }
            this.f23533a.mo6061b(i3);
            while (i2 < list.size()) {
                this.f23533a.mo6069d(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f23533a.mo6070e(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: c */
    public final void mo3707c(int i, int i2) {
        this.f23533a.mo6062b(i, i2);
    }

    /* renamed from: c */
    public final void mo3708c(int i, long j) {
        this.f23533a.mo6050a(i, j);
    }

    /* renamed from: c */
    public final void mo3709c(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f23533a.mo6049a(i, 2);
            int i3 = 0;
            for (i = 0; i < list.size(); i++) {
                i3 += aaw.m29616d(((Long) list.get(i)).longValue());
            }
            this.f23533a.mo6061b(i3);
            while (i2 < list.size()) {
                this.f23533a.mo6056a(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f23533a.mo6050a(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    /* renamed from: d */
    public final void mo3710d(int i, int i2) {
        this.f23533a.mo6070e(i, i2);
    }

    /* renamed from: d */
    public final void mo3711d(int i, long j) {
        this.f23533a.mo6066c(i, j);
    }

    /* renamed from: d */
    public final void mo3712d(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f23533a.mo6049a(i, 2);
            int i3 = 0;
            for (i = 0; i < list.size(); i++) {
                i3 += aaw.m29619e(((Long) list.get(i)).longValue());
            }
            this.f23533a.mo6061b(i3);
            while (i2 < list.size()) {
                this.f23533a.mo6056a(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f23533a.mo6050a(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    /* renamed from: e */
    public final void mo3713e(int i, int i2) {
        this.f23533a.mo6065c(i, i2);
    }

    /* renamed from: e */
    public final void mo3714e(int i, long j) {
        this.f23533a.m29664b(i, j);
    }

    /* renamed from: e */
    public final void mo3715e(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f23533a.mo6049a(i, 2);
            int i3 = 0;
            for (i = 0; i < list.size(); i++) {
                i3 += aaw.m29627g(((Long) list.get(i)).longValue());
            }
            this.f23533a.mo6061b(i3);
            while (i2 < list.size()) {
                this.f23533a.mo6067c(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f23533a.mo6066c(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    /* renamed from: f */
    public final void mo3716f(int i, int i2) {
        this.f23533a.m29674d(i, i2);
    }

    /* renamed from: f */
    public final void mo3717f(int i, List<Float> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f23533a.mo6049a(i, 2);
            int i3 = 0;
            for (i = 0; i < list.size(); i++) {
                i3 += aaw.m29597b(((Float) list.get(i)).floatValue());
            }
            this.f23533a.mo6061b(i3);
            while (i2 < list.size()) {
                this.f23533a.m29644a(((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f23533a.m29647a(i, ((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    /* renamed from: g */
    public final void mo3718g(int i, List<Double> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f23533a.mo6049a(i, 2);
            int i3 = 0;
            for (i = 0; i < list.size(); i++) {
                i3 += aaw.m29596b(((Double) list.get(i)).doubleValue());
            }
            this.f23533a.mo6061b(i3);
            while (i2 < list.size()) {
                this.f23533a.m29643a(((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f23533a.m29646a(i, ((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    /* renamed from: h */
    public final void mo3719h(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f23533a.mo6049a(i, 2);
            int i3 = 0;
            for (i = 0; i < list.size(); i++) {
                i3 += aaw.m29637k(((Integer) list.get(i)).intValue());
            }
            this.f23533a.mo6061b(i3);
            while (i2 < list.size()) {
                this.f23533a.mo6048a(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f23533a.mo6062b(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: i */
    public final void mo3720i(int i, List<Boolean> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f23533a.mo6049a(i, 2);
            int i3 = 0;
            for (i = 0; i < list.size(); i++) {
                i3 += aaw.m29608b(((Boolean) list.get(i)).booleanValue());
            }
            this.f23533a.mo6061b(i3);
            while (i2 < list.size()) {
                this.f23533a.m29660a(((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f23533a.mo6055a(i, ((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    /* renamed from: j */
    public final void mo3721j(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f23533a.mo6049a(i, 2);
            int i3 = 0;
            for (i = 0; i < list.size(); i++) {
                i3 += aaw.m29624g(((Integer) list.get(i)).intValue());
            }
            this.f23533a.mo6061b(i3);
            while (i2 < list.size()) {
                this.f23533a.mo6061b(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f23533a.mo6065c(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: k */
    public final void mo3722k(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f23533a.mo6049a(i, 2);
            int i3 = 0;
            for (i = 0; i < list.size(); i++) {
                i3 += aaw.m29635j(((Integer) list.get(i)).intValue());
            }
            this.f23533a.mo6061b(i3);
            while (i2 < list.size()) {
                this.f23533a.mo6069d(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f23533a.mo6070e(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: l */
    public final void mo3723l(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f23533a.mo6049a(i, 2);
            int i3 = 0;
            for (i = 0; i < list.size(); i++) {
                i3 += aaw.m29631h(((Long) list.get(i)).longValue());
            }
            this.f23533a.mo6061b(i3);
            while (i2 < list.size()) {
                this.f23533a.mo6067c(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f23533a.mo6066c(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    /* renamed from: m */
    public final void mo3724m(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f23533a.mo6049a(i, 2);
            int i3 = 0;
            for (i = 0; i < list.size(); i++) {
                i3 += aaw.m29628h(((Integer) list.get(i)).intValue());
            }
            this.f23533a.mo6061b(i3);
            while (i2 < list.size()) {
                this.f23533a.m29668c(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f23533a.m29674d(i, ((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    /* renamed from: n */
    public final void mo3725n(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f23533a.mo6049a(i, 2);
            int i3 = 0;
            for (i = 0; i < list.size(); i++) {
                i3 += aaw.m29623f(((Long) list.get(i)).longValue());
            }
            this.f23533a.mo6061b(i3);
            while (i2 < list.size()) {
                this.f23533a.m29666b(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f23533a.m29664b(i, ((Long) list.get(i2)).longValue());
            i2++;
        }
    }
}
