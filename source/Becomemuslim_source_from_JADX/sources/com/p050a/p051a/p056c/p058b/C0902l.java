package com.p050a.p051a.p056c.p058b;

import android.graphics.PointF;
import com.p050a.p051a.p056c.C0894a;
import com.p050a.p051a.p061e.C0947e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapeData */
/* renamed from: com.a.a.c.b.l */
public class C0902l {
    /* renamed from: a */
    private final List<C0894a> f2535a = new ArrayList();
    /* renamed from: b */
    private PointF f2536b;
    /* renamed from: c */
    private boolean f2537c;

    public C0902l(PointF pointF, boolean z, List<C0894a> list) {
        this.f2536b = pointF;
        this.f2537c = z;
        this.f2535a.addAll(list);
    }

    /* renamed from: a */
    private void m3181a(float f, float f2) {
        if (this.f2536b == null) {
            this.f2536b = new PointF();
        }
        this.f2536b.set(f, f2);
    }

    /* renamed from: a */
    public PointF m3182a() {
        return this.f2536b;
    }

    /* renamed from: b */
    public boolean m3184b() {
        return this.f2537c;
    }

    /* renamed from: c */
    public List<C0894a> m3185c() {
        return this.f2535a;
    }

    /* renamed from: a */
    public void m3183a(C0902l c0902l, C0902l c0902l2, float f) {
        boolean z;
        int size;
        PointF a;
        if (this.f2536b == null) {
            this.f2536b = new PointF();
        }
        if (!c0902l.m3184b()) {
            if (!c0902l2.m3184b()) {
                z = false;
                this.f2537c = z;
                if (!(this.f2535a.isEmpty() || this.f2535a.size() == c0902l.m3185c().size())) {
                    if (this.f2535a.size() == c0902l2.m3185c().size()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Curves must have the same number of control points. This: ");
                        stringBuilder.append(m3185c().size());
                        stringBuilder.append("\tShape 1: ");
                        stringBuilder.append(c0902l.m3185c().size());
                        stringBuilder.append("\tShape 2: ");
                        stringBuilder.append(c0902l2.m3185c().size());
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                }
                if (this.f2535a.isEmpty()) {
                    for (size = c0902l.m3185c().size() - 1; size >= 0; size--) {
                        this.f2535a.add(new C0894a());
                    }
                }
                PointF a2 = c0902l.m3182a();
                a = c0902l2.m3182a();
                m3181a(C0947e.m3302a(a2.x, a.x, f), C0947e.m3302a(a2.y, a.y, f));
                for (size = this.f2535a.size() - 1; size >= 0; size--) {
                    C0894a c0894a = (C0894a) c0902l.m3185c().get(size);
                    C0894a c0894a2 = (C0894a) c0902l2.m3185c().get(size);
                    PointF a3 = c0894a.m3165a();
                    PointF b = c0894a.m3167b();
                    PointF c = c0894a.m3169c();
                    PointF a4 = c0894a2.m3165a();
                    PointF b2 = c0894a2.m3167b();
                    a = c0894a2.m3169c();
                    ((C0894a) this.f2535a.get(size)).m3166a(C0947e.m3302a(a3.x, a4.x, f), C0947e.m3302a(a3.y, a4.y, f));
                    ((C0894a) this.f2535a.get(size)).m3168b(C0947e.m3302a(b.x, b2.x, f), C0947e.m3302a(b.y, b2.y, f));
                    ((C0894a) this.f2535a.get(size)).m3170c(C0947e.m3302a(c.x, a.x, f), C0947e.m3302a(c.y, a.y, f));
                }
            }
        }
        z = true;
        this.f2537c = z;
        if (this.f2535a.size() == c0902l2.m3185c().size()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Curves must have the same number of control points. This: ");
            stringBuilder2.append(m3185c().size());
            stringBuilder2.append("\tShape 1: ");
            stringBuilder2.append(c0902l.m3185c().size());
            stringBuilder2.append("\tShape 2: ");
            stringBuilder2.append(c0902l2.m3185c().size());
            throw new IllegalStateException(stringBuilder2.toString());
        }
        if (this.f2535a.isEmpty()) {
            for (size = c0902l.m3185c().size() - 1; size >= 0; size--) {
                this.f2535a.add(new C0894a());
            }
        }
        PointF a22 = c0902l.m3182a();
        a = c0902l2.m3182a();
        m3181a(C0947e.m3302a(a22.x, a.x, f), C0947e.m3302a(a22.y, a.y, f));
        for (size = this.f2535a.size() - 1; size >= 0; size--) {
            C0894a c0894a3 = (C0894a) c0902l.m3185c().get(size);
            C0894a c0894a22 = (C0894a) c0902l2.m3185c().get(size);
            PointF a32 = c0894a3.m3165a();
            PointF b3 = c0894a3.m3167b();
            PointF c2 = c0894a3.m3169c();
            PointF a42 = c0894a22.m3165a();
            PointF b22 = c0894a22.m3167b();
            a = c0894a22.m3169c();
            ((C0894a) this.f2535a.get(size)).m3166a(C0947e.m3302a(a32.x, a42.x, f), C0947e.m3302a(a32.y, a42.y, f));
            ((C0894a) this.f2535a.get(size)).m3168b(C0947e.m3302a(b3.x, b22.x, f), C0947e.m3302a(b3.y, b22.y, f));
            ((C0894a) this.f2535a.get(size)).m3170c(C0947e.m3302a(c2.x, a.x, f), C0947e.m3302a(c2.y, a.y, f));
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShapeData{numCurves=");
        stringBuilder.append(this.f2535a.size());
        stringBuilder.append("closed=");
        stringBuilder.append(this.f2537c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
