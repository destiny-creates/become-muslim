package com.google.android.gms.internal.p210i;

import com.google.android.gms.internal.p210i.fk.C4996e;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.es */
final class es implements ix {
    /* renamed from: a */
    private final eq f24488a;

    /* renamed from: a */
    public static es m31522a(eq eqVar) {
        if (eqVar.f24487a != null) {
            return eqVar.f24487a;
        }
        return new es(eqVar);
    }

    private es(eq eqVar) {
        this.f24488a = (eq) fm.m20558a((Object) eqVar, "output");
    }

    /* renamed from: a */
    public final int mo4501a() {
        return C4996e.f16612j;
    }

    /* renamed from: a */
    public final void mo4505a(int i, int i2) {
        this.f24488a.mo6196e(i, i2);
    }

    /* renamed from: a */
    public final void mo4506a(int i, long j) {
        this.f24488a.mo6173a(i, j);
    }

    /* renamed from: b */
    public final void mo4518b(int i, long j) {
        this.f24488a.mo6192c(i, j);
    }

    /* renamed from: a */
    public final void mo4504a(int i, float f) {
        this.f24488a.m31491a(i, f);
    }

    /* renamed from: a */
    public final void mo4503a(int i, double d) {
        this.f24488a.m31490a(i, d);
    }

    /* renamed from: b */
    public final void mo4517b(int i, int i2) {
        this.f24488a.mo6187b(i, i2);
    }

    /* renamed from: c */
    public final void mo4524c(int i, long j) {
        this.f24488a.mo6173a(i, j);
    }

    /* renamed from: c */
    public final void mo4523c(int i, int i2) {
        this.f24488a.mo6187b(i, i2);
    }

    /* renamed from: d */
    public final void mo4527d(int i, long j) {
        this.f24488a.mo6192c(i, j);
    }

    /* renamed from: d */
    public final void mo4526d(int i, int i2) {
        this.f24488a.mo6196e(i, i2);
    }

    /* renamed from: a */
    public final void mo4515a(int i, boolean z) {
        this.f24488a.mo6178a(i, z);
    }

    /* renamed from: a */
    public final void mo4511a(int i, String str) {
        this.f24488a.mo6177a(i, str);
    }

    /* renamed from: a */
    public final void mo4507a(int i, dy dyVar) {
        this.f24488a.mo6174a(i, dyVar);
    }

    /* renamed from: e */
    public final void mo4529e(int i, int i2) {
        this.f24488a.mo6191c(i, i2);
    }

    /* renamed from: f */
    public final void mo4532f(int i, int i2) {
        this.f24488a.m31520d(i, i2);
    }

    /* renamed from: e */
    public final void mo4530e(int i, long j) {
        this.f24488a.m31509b(i, j);
    }

    /* renamed from: a */
    public final void mo4510a(int i, Object obj, hi hiVar) {
        this.f24488a.mo6176a(i, (gt) obj, hiVar);
    }

    /* renamed from: b */
    public final void mo4519b(int i, Object obj, hi hiVar) {
        eq eqVar = this.f24488a;
        obj = (gt) obj;
        eqVar.mo6172a(i, 3);
        hiVar.mo4571a(obj, eqVar.f24487a);
        eqVar.mo6172a(i, 4);
    }

    /* renamed from: a */
    public final void mo4502a(int i) {
        this.f24488a.mo6172a(i, 3);
    }

    /* renamed from: b */
    public final void mo4516b(int i) {
        this.f24488a.mo6172a(i, 4);
    }

    /* renamed from: a */
    public final void mo4509a(int i, Object obj) {
        if (obj instanceof dy) {
            this.f24488a.mo6188b(i, (dy) obj);
        } else {
            this.f24488a.mo6189b(i, (gt) obj);
        }
    }

    /* renamed from: a */
    public final void mo4514a(int i, List<Integer> list, boolean z) {
        boolean z2 = false;
        if (z) {
            this.f24488a.mo6172a(i, 2);
            int i2 = false;
            for (i = 0; i < list.size(); i++) {
                i2 += eq.m31464f(((Integer) list.get(i)).intValue());
            }
            this.f24488a.mo6186b(i2);
            int i3;
            while (i3 < list.size()) {
                this.f24488a.mo6171a(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (z2 < list.size()) {
            this.f24488a.mo6187b(i, ((Integer) list.get(z2)).intValue());
            z2++;
        }
    }

    /* renamed from: b */
    public final void mo4522b(int i, List<Integer> list, boolean z) {
        boolean z2 = false;
        if (z) {
            this.f24488a.mo6172a(i, 2);
            int i2 = false;
            for (i = 0; i < list.size(); i++) {
                i2 += eq.m31476i(((Integer) list.get(i)).intValue());
            }
            this.f24488a.mo6186b(i2);
            int i3;
            while (i3 < list.size()) {
                this.f24488a.mo6195d(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (z2 < list.size()) {
            this.f24488a.mo6196e(i, ((Integer) list.get(z2)).intValue());
            z2++;
        }
    }

    /* renamed from: c */
    public final void mo4525c(int i, List<Long> list, boolean z) {
        boolean z2 = false;
        if (z) {
            this.f24488a.mo6172a(i, 2);
            int i2 = false;
            for (i = 0; i < list.size(); i++) {
                i2 += eq.m31460d(((Long) list.get(i)).longValue());
            }
            this.f24488a.mo6186b(i2);
            int i3;
            while (i3 < list.size()) {
                this.f24488a.mo6179a(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (z2 < list.size()) {
            this.f24488a.mo6173a(i, ((Long) list.get(z2)).longValue());
            z2++;
        }
    }

    /* renamed from: d */
    public final void mo4528d(int i, List<Long> list, boolean z) {
        boolean z2 = false;
        if (z) {
            this.f24488a.mo6172a(i, 2);
            int i2 = false;
            for (i = 0; i < list.size(); i++) {
                i2 += eq.m31463e(((Long) list.get(i)).longValue());
            }
            this.f24488a.mo6186b(i2);
            int i3;
            while (i3 < list.size()) {
                this.f24488a.mo6179a(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (z2 < list.size()) {
            this.f24488a.mo6173a(i, ((Long) list.get(z2)).longValue());
            z2++;
        }
    }

    /* renamed from: e */
    public final void mo4531e(int i, List<Long> list, boolean z) {
        boolean z2 = false;
        if (z) {
            this.f24488a.mo6172a(i, 2);
            int i2 = false;
            for (i = 0; i < list.size(); i++) {
                i2 += eq.m31471g(((Long) list.get(i)).longValue());
            }
            this.f24488a.mo6186b(i2);
            int i3;
            while (i3 < list.size()) {
                this.f24488a.mo6193c(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (z2 < list.size()) {
            this.f24488a.mo6192c(i, ((Long) list.get(z2)).longValue());
            z2++;
        }
    }

    /* renamed from: f */
    public final void mo4533f(int i, List<Float> list, boolean z) {
        boolean z2 = false;
        if (z) {
            this.f24488a.mo6172a(i, 2);
            int i2 = false;
            for (i = 0; i < list.size(); i++) {
                i2 += eq.m31439b(((Float) list.get(i)).floatValue());
            }
            this.f24488a.mo6186b(i2);
            int i3;
            while (i3 < list.size()) {
                this.f24488a.m31488a(((Float) list.get(i3)).floatValue());
                i3++;
            }
            return;
        }
        while (z2 < list.size()) {
            this.f24488a.m31491a(i, ((Float) list.get(z2)).floatValue());
            z2++;
        }
    }

    /* renamed from: g */
    public final void mo4534g(int i, List<Double> list, boolean z) {
        boolean z2 = false;
        if (z) {
            this.f24488a.mo6172a(i, 2);
            int i2 = false;
            for (i = 0; i < list.size(); i++) {
                i2 += eq.m31438b(((Double) list.get(i)).doubleValue());
            }
            this.f24488a.mo6186b(i2);
            int i3;
            while (i3 < list.size()) {
                this.f24488a.m31487a(((Double) list.get(i3)).doubleValue());
                i3++;
            }
            return;
        }
        while (z2 < list.size()) {
            this.f24488a.m31490a(i, ((Double) list.get(z2)).doubleValue());
            z2++;
        }
    }

    /* renamed from: h */
    public final void mo4535h(int i, List<Integer> list, boolean z) {
        boolean z2 = false;
        if (z) {
            this.f24488a.mo6172a(i, 2);
            int i2 = false;
            for (i = 0; i < list.size(); i++) {
                i2 += eq.m31481k(((Integer) list.get(i)).intValue());
            }
            this.f24488a.mo6186b(i2);
            int i3;
            while (i3 < list.size()) {
                this.f24488a.mo6171a(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (z2 < list.size()) {
            this.f24488a.mo6187b(i, ((Integer) list.get(z2)).intValue());
            z2++;
        }
    }

    /* renamed from: i */
    public final void mo4536i(int i, List<Boolean> list, boolean z) {
        boolean z2 = false;
        if (z) {
            this.f24488a.mo6172a(i, 2);
            int i2 = false;
            for (i = 0; i < list.size(); i++) {
                i2 += eq.m31450b(((Boolean) list.get(i)).booleanValue());
            }
            this.f24488a.mo6186b(i2);
            int i3;
            while (i3 < list.size()) {
                this.f24488a.m31505a(((Boolean) list.get(i3)).booleanValue());
                i3++;
            }
            return;
        }
        while (z2 < list.size()) {
            this.f24488a.mo6178a(i, ((Boolean) list.get(z2)).booleanValue());
            z2++;
        }
    }

    /* renamed from: a */
    public final void mo4512a(int i, List<String> list) {
        int i2 = 0;
        if (list instanceof gb) {
            gb gbVar = (gb) list;
            while (i2 < list.size()) {
                Object b = gbVar.mo4604b(i2);
                if (b instanceof String) {
                    this.f24488a.mo6177a(i, (String) b);
                } else {
                    this.f24488a.mo6174a(i, (dy) b);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f24488a.mo6177a(i, (String) list.get(i2));
            i2++;
        }
    }

    /* renamed from: b */
    public final void mo4520b(int i, List<dy> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f24488a.mo6174a(i, (dy) list.get(i2));
        }
    }

    /* renamed from: j */
    public final void mo4537j(int i, List<Integer> list, boolean z) {
        boolean z2 = false;
        if (z) {
            this.f24488a.mo6172a(i, 2);
            int i2 = false;
            for (i = 0; i < list.size(); i++) {
                i2 += eq.m31468g(((Integer) list.get(i)).intValue());
            }
            this.f24488a.mo6186b(i2);
            int i3;
            while (i3 < list.size()) {
                this.f24488a.mo6186b(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (z2 < list.size()) {
            this.f24488a.mo6191c(i, ((Integer) list.get(z2)).intValue());
            z2++;
        }
    }

    /* renamed from: k */
    public final void mo4538k(int i, List<Integer> list, boolean z) {
        boolean z2 = false;
        if (z) {
            this.f24488a.mo6172a(i, 2);
            int i2 = false;
            for (i = 0; i < list.size(); i++) {
                i2 += eq.m31479j(((Integer) list.get(i)).intValue());
            }
            this.f24488a.mo6186b(i2);
            int i3;
            while (i3 < list.size()) {
                this.f24488a.mo6195d(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (z2 < list.size()) {
            this.f24488a.mo6196e(i, ((Integer) list.get(z2)).intValue());
            z2++;
        }
    }

    /* renamed from: l */
    public final void mo4539l(int i, List<Long> list, boolean z) {
        boolean z2 = false;
        if (z) {
            this.f24488a.mo6172a(i, 2);
            int i2 = false;
            for (i = 0; i < list.size(); i++) {
                i2 += eq.m31475h(((Long) list.get(i)).longValue());
            }
            this.f24488a.mo6186b(i2);
            int i3;
            while (i3 < list.size()) {
                this.f24488a.mo6193c(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (z2 < list.size()) {
            this.f24488a.mo6192c(i, ((Long) list.get(z2)).longValue());
            z2++;
        }
    }

    /* renamed from: m */
    public final void mo4540m(int i, List<Integer> list, boolean z) {
        boolean z2 = false;
        if (z) {
            this.f24488a.mo6172a(i, 2);
            int i2 = false;
            for (i = 0; i < list.size(); i++) {
                i2 += eq.m31472h(((Integer) list.get(i)).intValue());
            }
            this.f24488a.mo6186b(i2);
            int i3;
            while (i3 < list.size()) {
                this.f24488a.m31514c(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        while (z2 < list.size()) {
            this.f24488a.m31520d(i, ((Integer) list.get(z2)).intValue());
            z2++;
        }
    }

    /* renamed from: n */
    public final void mo4541n(int i, List<Long> list, boolean z) {
        boolean z2 = false;
        if (z) {
            this.f24488a.mo6172a(i, 2);
            int i2 = false;
            for (i = 0; i < list.size(); i++) {
                i2 += eq.m31467f(((Long) list.get(i)).longValue());
            }
            this.f24488a.mo6186b(i2);
            int i3;
            while (i3 < list.size()) {
                this.f24488a.m31512b(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        while (z2 < list.size()) {
            this.f24488a.m31509b(i, ((Long) list.get(z2)).longValue());
            z2++;
        }
    }

    /* renamed from: a */
    public final void mo4513a(int i, List<?> list, hi hiVar) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo4510a(i, list.get(i2), hiVar);
        }
    }

    /* renamed from: b */
    public final void mo4521b(int i, List<?> list, hi hiVar) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mo4519b(i, list.get(i2), hiVar);
        }
    }

    /* renamed from: a */
    public final <K, V> void mo4508a(int i, gm<K, V> gmVar, Map<K, V> map) {
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            this.f24488a.mo6172a(i, 2);
            this.f24488a.mo6186b(gl.m20592a(gmVar, entry.getKey(), entry.getValue()));
            gl.m20593a(this.f24488a, gmVar, entry.getKey(), entry.getValue());
        }
    }
}
