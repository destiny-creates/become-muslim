package com.p050a.p051a.p052a.p053a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.C0959i;
import com.p050a.p051a.p052a.p054b.C0885a;
import com.p050a.p051a.p052a.p054b.C0885a.C0884a;
import com.p050a.p051a.p052a.p054b.C3366p;
import com.p050a.p051a.p056c.p058b.C3381p;
import com.p050a.p051a.p056c.p059c.C4529a;
import com.p050a.p051a.p062f.C0952c;

/* compiled from: StrokeContent */
/* renamed from: com.a.a.a.a.q */
public class C4836q extends C4503a {
    /* renamed from: b */
    private final C4529a f13713b;
    /* renamed from: c */
    private final String f13714c;
    /* renamed from: d */
    private final C0885a<Integer, Integer> f13715d;
    /* renamed from: e */
    private C0885a<ColorFilter, ColorFilter> f13716e;

    public C4836q(C0957g c0957g, C4529a c4529a, C3381p c3381p) {
        super(c0957g, c4529a, c3381p.m10762g().m3186a(), c3381p.m10763h().m3187a(), c3381p.m10758c(), c3381p.m10759d(), c3381p.m10760e(), c3381p.m10761f());
        this.f13713b = c4529a;
        this.f13714c = c3381p.m10756a();
        this.f13715d = c3381p.m10757b().mo737a();
        this.f13715d.m3133a((C0884a) this);
        c4529a.m15378a(this.f13715d);
    }

    /* renamed from: a */
    public void mo2789a(Canvas canvas, Matrix matrix, int i) {
        this.a.setColor(((Integer) this.f13715d.mo733e()).intValue());
        if (this.f13716e != null) {
            this.a.setColorFilter((ColorFilter) this.f13716e.mo733e());
        }
        super.mo2789a(canvas, matrix, i);
    }

    /* renamed from: b */
    public String mo730b() {
        return this.f13714c;
    }

    /* renamed from: a */
    public <T> void mo2792a(T t, C0952c<T> c0952c) {
        super.mo2792a((Object) t, (C0952c) c0952c);
        if (t == C0959i.f2702b) {
            this.f13715d.m3134a((C0952c) c0952c);
        } else if (t != C0959i.f2724x) {
        } else {
            if (c0952c == null) {
                this.f13716e = null;
                return;
            }
            this.f13716e = new C3366p(c0952c);
            this.f13716e.m3133a((C0884a) this);
            this.f13713b.m15378a(this.f13715d);
        }
    }
}
