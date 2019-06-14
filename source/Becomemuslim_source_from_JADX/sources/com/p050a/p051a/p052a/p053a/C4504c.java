package com.p050a.p051a.p052a.p053a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.p052a.p054b.C0885a.C0884a;
import com.p050a.p051a.p052a.p054b.C0887o;
import com.p050a.p051a.p056c.C0917e;
import com.p050a.p051a.p056c.C0918f;
import com.p050a.p051a.p056c.p057a.C3369l;
import com.p050a.p051a.p056c.p058b.C0895b;
import com.p050a.p051a.p056c.p058b.C3379n;
import com.p050a.p051a.p056c.p059c.C4529a;
import com.p050a.p051a.p062f.C0952c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContentGroup */
/* renamed from: com.a.a.a.a.c */
public class C4504c implements C3358d, C3360l, C0884a, C0918f {
    /* renamed from: a */
    private final Matrix f12120a;
    /* renamed from: b */
    private final Path f12121b;
    /* renamed from: c */
    private final RectF f12122c;
    /* renamed from: d */
    private final String f12123d;
    /* renamed from: e */
    private final List<C0880b> f12124e;
    /* renamed from: f */
    private final C0957g f12125f;
    /* renamed from: g */
    private List<C3360l> f12126g;
    /* renamed from: h */
    private C0887o f12127h;

    /* renamed from: a */
    private static List<C0880b> m15266a(C0957g c0957g, C4529a c4529a, List<C0895b> list) {
        List<C0880b> arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            C0880b a = ((C0895b) list.get(i)).mo738a(c0957g, c4529a);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    static C3369l m15265a(List<C0895b> list) {
        for (int i = 0; i < list.size(); i++) {
            C0895b c0895b = (C0895b) list.get(i);
            if (c0895b instanceof C3369l) {
                return (C3369l) c0895b;
            }
        }
        return null;
    }

    public C4504c(C0957g c0957g, C4529a c4529a, C3379n c3379n) {
        this(c0957g, c4529a, c3379n.m10750a(), C4504c.m15266a(c0957g, c4529a, c3379n.m10751b()), C4504c.m15265a(c3379n.m10751b()));
    }

    C4504c(C0957g c0957g, C4529a c4529a, String str, List<C0880b> list, C3369l c3369l) {
        this.f12120a = new Matrix();
        this.f12121b = new Path();
        this.f12122c = new RectF();
        this.f12123d = str;
        this.f12125f = c0957g;
        this.f12124e = list;
        if (c3369l != null) {
            this.f12127h = c3369l.m10695h();
            this.f12127h.m3146a(c4529a);
            this.f12127h.m3145a((C0884a) this);
        }
        c0957g = new ArrayList();
        for (c4529a = list.size() - 1; c4529a >= null; c4529a--) {
            C0880b c0880b = (C0880b) list.get(c4529a);
            if ((c0880b instanceof C0881i) != null) {
                c0957g.add((C0881i) c0880b);
            }
        }
        for (c4529a = c0957g.size() - 1; c4529a >= null; c4529a--) {
            ((C0881i) c0957g.get(c4529a)).mo2794a(list.listIterator(list.size()));
        }
    }

    /* renamed from: a */
    public void mo728a() {
        this.f12125f.invalidateSelf();
    }

    /* renamed from: b */
    public String mo730b() {
        return this.f12123d;
    }

    /* renamed from: a */
    public void mo729a(List<C0880b> list, List<C0880b> list2) {
        list2 = new ArrayList(list.size() + this.f12124e.size());
        list2.addAll(list);
        for (list = this.f12124e.size() - 1; list >= null; list--) {
            C0880b c0880b = (C0880b) this.f12124e.get(list);
            c0880b.mo729a(list2, this.f12124e.subList(0, list));
            list2.add(c0880b);
        }
    }

    /* renamed from: c */
    List<C3360l> m15274c() {
        if (this.f12126g == null) {
            this.f12126g = new ArrayList();
            for (int i = 0; i < this.f12124e.size(); i++) {
                C0880b c0880b = (C0880b) this.f12124e.get(i);
                if (c0880b instanceof C3360l) {
                    this.f12126g.add((C3360l) c0880b);
                }
            }
        }
        return this.f12126g;
    }

    /* renamed from: d */
    Matrix m15275d() {
        if (this.f12127h != null) {
            return this.f12127h.m3151d();
        }
        this.f12120a.reset();
        return this.f12120a;
    }

    /* renamed from: e */
    public Path mo2793e() {
        this.f12120a.reset();
        if (this.f12127h != null) {
            this.f12120a.set(this.f12127h.m3151d());
        }
        this.f12121b.reset();
        for (int size = this.f12124e.size() - 1; size >= 0; size--) {
            C0880b c0880b = (C0880b) this.f12124e.get(size);
            if (c0880b instanceof C3360l) {
                this.f12121b.addPath(((C3360l) c0880b).mo2793e(), this.f12120a);
            }
        }
        return this.f12121b;
    }

    /* renamed from: a */
    public void mo2789a(Canvas canvas, Matrix matrix, int i) {
        this.f12120a.set(matrix);
        if (this.f12127h != null) {
            this.f12120a.preConcat(this.f12127h.m3151d());
            i = (int) ((((((float) ((Integer) this.f12127h.m3143a().mo733e()).intValue()) / 100.0f) * ((float) i)) / 1132396544) * 1132396544);
        }
        for (matrix = this.f12124e.size() - 1; matrix >= null; matrix--) {
            Object obj = this.f12124e.get(matrix);
            if (obj instanceof C3358d) {
                ((C3358d) obj).mo2789a(canvas, this.f12120a, i);
            }
        }
    }

    /* renamed from: a */
    public void mo2790a(RectF rectF, Matrix matrix) {
        this.f12120a.set(matrix);
        if (this.f12127h != null) {
            this.f12120a.preConcat(this.f12127h.m3151d());
        }
        this.f12122c.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (matrix = this.f12124e.size() - 1; matrix >= null; matrix--) {
            C0880b c0880b = (C0880b) this.f12124e.get(matrix);
            if (c0880b instanceof C3358d) {
                ((C3358d) c0880b).mo2790a(this.f12122c, this.f12120a);
                if (rectF.isEmpty()) {
                    rectF.set(this.f12122c);
                } else {
                    rectF.set(Math.min(rectF.left, this.f12122c.left), Math.min(rectF.top, this.f12122c.top), Math.max(rectF.right, this.f12122c.right), Math.max(rectF.bottom, this.f12122c.bottom));
                }
            }
        }
    }

    /* renamed from: a */
    public void mo2791a(C0917e c0917e, int i, List<C0917e> list, C0917e c0917e2) {
        if (c0917e.m3222a(mo730b(), i)) {
            if (!"__container".equals(mo730b())) {
                c0917e2 = c0917e2.m3220a(mo730b());
                if (c0917e.m3224c(mo730b(), i)) {
                    list.add(c0917e2.m3219a((C0918f) this));
                }
            }
            if (c0917e.m3225d(mo730b(), i)) {
                i += c0917e.m3223b(mo730b(), i);
                for (int i2 = 0; i2 < this.f12124e.size(); i2++) {
                    C0880b c0880b = (C0880b) this.f12124e.get(i2);
                    if (c0880b instanceof C0918f) {
                        ((C0918f) c0880b).mo2791a(c0917e, i, list, c0917e2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public <T> void mo2792a(T t, C0952c<T> c0952c) {
        if (this.f12127h != null) {
            this.f12127h.m3147a(t, c0952c);
        }
    }
}
