package com.p050a.p051a.p052a.p053a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.C0959i;
import com.p050a.p051a.p052a.p054b.C0885a;
import com.p050a.p051a.p052a.p054b.C0885a.C0884a;
import com.p050a.p051a.p052a.p054b.C0887o;
import com.p050a.p051a.p056c.C0917e;
import com.p050a.p051a.p056c.p058b.C3377k;
import com.p050a.p051a.p056c.p059c.C4529a;
import com.p050a.p051a.p061e.C0947e;
import com.p050a.p051a.p062f.C0952c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* compiled from: RepeaterContent */
/* renamed from: com.a.a.a.a.o */
public class C4511o implements C3358d, C0881i, C3359j, C3360l, C0884a {
    /* renamed from: a */
    private final Matrix f12190a = new Matrix();
    /* renamed from: b */
    private final Path f12191b = new Path();
    /* renamed from: c */
    private final C0957g f12192c;
    /* renamed from: d */
    private final C4529a f12193d;
    /* renamed from: e */
    private final String f12194e;
    /* renamed from: f */
    private final C0885a<Float, Float> f12195f;
    /* renamed from: g */
    private final C0885a<Float, Float> f12196g;
    /* renamed from: h */
    private final C0887o f12197h;
    /* renamed from: i */
    private C4504c f12198i;

    public C4511o(C0957g c0957g, C4529a c4529a, C3377k c3377k) {
        this.f12192c = c0957g;
        this.f12193d = c4529a;
        this.f12194e = c3377k.m10740a();
        this.f12195f = c3377k.m10741b().mo737a();
        c4529a.m15378a(this.f12195f);
        this.f12195f.m3133a((C0884a) this);
        this.f12196g = c3377k.m10742c().mo737a();
        c4529a.m15378a(this.f12196g);
        this.f12196g.m3133a((C0884a) this);
        this.f12197h = c3377k.m10743d().m10695h();
        this.f12197h.m3146a(c4529a);
        this.f12197h.m3145a((C0884a) this);
    }

    /* renamed from: a */
    public void mo2794a(ListIterator<C0880b> listIterator) {
        if (this.f12198i == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            List arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.f12198i = new C4504c(this.f12192c, this.f12193d, "Repeater", arrayList, null);
        }
    }

    /* renamed from: b */
    public String mo730b() {
        return this.f12194e;
    }

    /* renamed from: a */
    public void mo729a(List<C0880b> list, List<C0880b> list2) {
        this.f12198i.mo729a((List) list, (List) list2);
    }

    /* renamed from: e */
    public Path mo2793e() {
        Path e = this.f12198i.mo2793e();
        this.f12191b.reset();
        float floatValue = ((Float) this.f12195f.mo733e()).floatValue();
        float floatValue2 = ((Float) this.f12196g.mo733e()).floatValue();
        for (int i = ((int) floatValue) - 1; i >= 0; i--) {
            this.f12190a.set(this.f12197h.m3148b(((float) i) + floatValue2));
            this.f12191b.addPath(e, this.f12190a);
        }
        return this.f12191b;
    }

    /* renamed from: a */
    public void mo2789a(Canvas canvas, Matrix matrix, int i) {
        float floatValue = ((Float) this.f12195f.mo733e()).floatValue();
        float floatValue2 = ((Float) this.f12196g.mo733e()).floatValue();
        float floatValue3 = ((Float) this.f12197h.m3149b().mo733e()).floatValue() / 100.0f;
        float floatValue4 = ((Float) this.f12197h.m3150c().mo733e()).floatValue() / 100.0f;
        for (int i2 = ((int) floatValue) - 1; i2 >= 0; i2--) {
            this.f12190a.set(matrix);
            float f = (float) i2;
            this.f12190a.preConcat(this.f12197h.m3148b(f + floatValue2));
            this.f12198i.mo2789a(canvas, this.f12190a, (int) (((float) i) * C0947e.m3302a(floatValue3, floatValue4, f / floatValue)));
        }
    }

    /* renamed from: a */
    public void mo2790a(RectF rectF, Matrix matrix) {
        this.f12198i.mo2790a(rectF, matrix);
    }

    /* renamed from: a */
    public void mo728a() {
        this.f12192c.invalidateSelf();
    }

    /* renamed from: a */
    public void mo2791a(C0917e c0917e, int i, List<C0917e> list, C0917e c0917e2) {
        C0947e.m3309a(c0917e, i, list, c0917e2, this);
    }

    /* renamed from: a */
    public <T> void mo2792a(T t, C0952c<T> c0952c) {
        if (!this.f12197h.m3147a(t, c0952c)) {
            if (t == C0959i.f2713m) {
                this.f12195f.m3134a((C0952c) c0952c);
            } else if (t == C0959i.f2714n) {
                this.f12196g.m3134a((C0952c) c0952c);
            }
        }
    }
}
