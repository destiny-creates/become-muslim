package com.p050a.p051a.p056c.p059c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import com.facebook.imageutils.JfifUtil;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.C0957g;
import com.p050a.p051a.C0959i;
import com.p050a.p051a.C0967n;
import com.p050a.p051a.p052a.p053a.C4504c;
import com.p050a.p051a.p052a.p054b.C0885a;
import com.p050a.p051a.p052a.p054b.C0885a.C0884a;
import com.p050a.p051a.p052a.p054b.C4520n;
import com.p050a.p051a.p056c.C0907b;
import com.p050a.p051a.p056c.C0915c;
import com.p050a.p051a.p056c.C0916d;
import com.p050a.p051a.p056c.p058b.C3379n;
import com.p050a.p051a.p061e.C0948f;
import com.p050a.p051a.p062f.C0952c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TextLayer */
/* renamed from: com.a.a.c.c.h */
public class C4842h extends C4529a {
    /* renamed from: e */
    private final char[] f13732e = new char[1];
    /* renamed from: f */
    private final RectF f13733f = new RectF();
    /* renamed from: g */
    private final Matrix f13734g = new Matrix();
    /* renamed from: h */
    private final Paint f13735h = new Paint(this, 1) {
        /* renamed from: a */
        final /* synthetic */ C4842h f2599a;
    };
    /* renamed from: i */
    private final Paint f13736i = new Paint(this, 1) {
        /* renamed from: a */
        final /* synthetic */ C4842h f2600a;
    };
    /* renamed from: j */
    private final Map<C0916d, List<C4504c>> f13737j = new HashMap();
    /* renamed from: k */
    private final C4520n f13738k;
    /* renamed from: l */
    private final C0957g f13739l;
    /* renamed from: m */
    private final C0954f f13740m;
    /* renamed from: n */
    private C0885a<Integer, Integer> f13741n;
    /* renamed from: o */
    private C0885a<Integer, Integer> f13742o;
    /* renamed from: p */
    private C0885a<Float, Float> f13743p;
    /* renamed from: q */
    private C0885a<Float, Float> f13744q;

    C4842h(C0957g c0957g, C0912d c0912d) {
        super(c0957g, c0912d);
        this.f13739l = c0957g;
        this.f13740m = c0912d.m3189a();
        this.f13738k = c0912d.m3208s().m15361b();
        this.f13738k.m3133a((C0884a) this);
        m15378a((C0885a) this.f13738k);
        c0957g = c0912d.m3209t();
        if (!(c0957g == null || c0957g.f2506a == null)) {
            this.f13741n = c0957g.f2506a.mo737a();
            this.f13741n.m3133a((C0884a) this);
            m15378a((C0885a) this.f13741n);
        }
        if (!(c0957g == null || c0957g.f2507b == null)) {
            this.f13742o = c0957g.f2507b.mo737a();
            this.f13742o.m3133a((C0884a) this);
            m15378a((C0885a) this.f13742o);
        }
        if (!(c0957g == null || c0957g.f2508c == null)) {
            this.f13743p = c0957g.f2508c.mo737a();
            this.f13743p.m3133a((C0884a) this);
            m15378a((C0885a) this.f13743p);
        }
        if (c0957g != null && c0957g.f2509d != null) {
            this.f13744q = c0957g.f2509d.mo737a();
            this.f13744q.m3133a((C0884a) this);
            m15378a((C0885a) this.f13744q);
        }
    }

    /* renamed from: b */
    void mo3346b(Canvas canvas, Matrix matrix, int i) {
        canvas.save();
        if (this.f13739l.m3397p() == 0) {
            canvas.setMatrix(matrix);
        }
        C0907b c0907b = (C0907b) this.f13738k.mo733e();
        C0915c c0915c = (C0915c) this.f13740m.m3348i().get(c0907b.f2552b);
        if (c0915c == null) {
            canvas.restore();
            return;
        }
        if (this.f13741n != null) {
            this.f13735h.setColor(((Integer) this.f13741n.mo733e()).intValue());
        } else {
            this.f13735h.setColor(c0907b.f2558h);
        }
        if (this.f13742o != null) {
            this.f13736i.setColor(((Integer) this.f13742o.mo733e()).intValue());
        } else {
            this.f13736i.setColor(c0907b.f2559i);
        }
        int intValue = (((Integer) this.d.m3143a().mo733e()).intValue() * JfifUtil.MARKER_FIRST_BYTE) / 100;
        this.f13735h.setAlpha(intValue);
        this.f13736i.setAlpha(intValue);
        if (this.f13743p != null) {
            this.f13736i.setStrokeWidth(((Float) this.f13743p.mo733e()).floatValue());
        } else {
            this.f13736i.setStrokeWidth((((float) c0907b.f2560j) * C0948f.m3313a()) * C0948f.m3314a(matrix));
        }
        if (this.f13739l.m3397p()) {
            m17205a(c0907b, matrix, c0915c, canvas);
        } else {
            m17206a(c0907b, c0915c, matrix, canvas);
        }
        canvas.restore();
    }

    /* renamed from: a */
    private void m17205a(C0907b c0907b, Matrix matrix, C0915c c0915c, Canvas canvas) {
        float f = ((float) c0907b.f2553c) / 100.0f;
        float a = C0948f.m3314a(matrix);
        String str = c0907b.f2551a;
        for (int i = 0; i < str.length(); i++) {
            C0916d c0916d = (C0916d) this.f13740m.m3347h().m1467a(C0916d.m3214a(str.charAt(i), c0915c.m3211a(), c0915c.m3213c()));
            if (c0916d != null) {
                m17207a(c0916d, matrix, f, c0907b, canvas);
                float b = ((((float) c0916d.m3216b()) * f) * C0948f.m3313a()) * a;
                float f2 = ((float) c0907b.f2555e) / 10.0f;
                if (this.f13744q != null) {
                    f2 += ((Float) this.f13744q.mo733e()).floatValue();
                }
                canvas.translate(b + (f2 * a), 0.0f);
            }
        }
    }

    /* renamed from: a */
    private void m17206a(C0907b c0907b, C0915c c0915c, Matrix matrix, Canvas canvas) {
        matrix = C0948f.m3314a(matrix);
        c0915c = this.f13739l.m3360a(c0915c.m3211a(), c0915c.m3213c());
        if (c0915c != null) {
            String str = c0907b.f2551a;
            C0967n o = this.f13739l.m3396o();
            if (o != null) {
                str = o.m3410a(str);
            }
            this.f13735h.setTypeface(c0915c);
            this.f13735h.setTextSize((float) (c0907b.f2553c * ((double) C0948f.m3313a())));
            this.f13736i.setTypeface(this.f13735h.getTypeface());
            this.f13736i.setTextSize(this.f13735h.getTextSize());
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                m17203a(charAt, c0907b, canvas);
                this.f13732e[0] = charAt;
                float measureText = this.f13735h.measureText(this.f13732e, 0, 1);
                float f = ((float) c0907b.f2555e) / 10.0f;
                if (this.f13744q != null) {
                    f += ((Float) this.f13744q.mo733e()).floatValue();
                }
                canvas.translate(measureText + (f * matrix), 0.0f);
            }
        }
    }

    /* renamed from: a */
    private void m17207a(C0916d c0916d, Matrix matrix, float f, C0907b c0907b, Canvas canvas) {
        c0916d = m17202a(c0916d);
        for (int i = 0; i < c0916d.size(); i++) {
            Path e = ((C4504c) c0916d.get(i)).mo2793e();
            e.computeBounds(this.f13733f, false);
            this.f13734g.set(matrix);
            this.f13734g.preTranslate(0.0f, ((float) (-c0907b.f2557g)) * C0948f.m3313a());
            this.f13734g.preScale(f, f);
            e.transform(this.f13734g);
            if (c0907b.f2561k) {
                m17204a(e, this.f13735h, canvas);
                m17204a(e, this.f13736i, canvas);
            } else {
                m17204a(e, this.f13736i, canvas);
                m17204a(e, this.f13735h, canvas);
            }
        }
    }

    /* renamed from: a */
    private void m17204a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    /* renamed from: a */
    private void m17203a(char c, C0907b c0907b, Canvas canvas) {
        this.f13732e[0] = c;
        if (c0907b.f2561k != '\u0000') {
            m17208a(this.f13732e, this.f13735h, canvas);
            m17208a(this.f13732e, this.f13736i, canvas);
            return;
        }
        m17208a(this.f13732e, this.f13736i, canvas);
        m17208a(this.f13732e, this.f13735h, canvas);
    }

    /* renamed from: a */
    private void m17208a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    /* renamed from: a */
    private List<C4504c> m17202a(C0916d c0916d) {
        if (this.f13737j.containsKey(c0916d)) {
            return (List) this.f13737j.get(c0916d);
        }
        List a = c0916d.m3215a();
        int size = a.size();
        List<C4504c> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new C4504c(this.f13739l, this, (C3379n) a.get(i)));
        }
        this.f13737j.put(c0916d, arrayList);
        return arrayList;
    }

    /* renamed from: a */
    public <T> void mo2792a(T t, C0952c<T> c0952c) {
        super.mo2792a((Object) t, (C0952c) c0952c);
        if (t == C0959i.f2701a && this.f13741n != null) {
            this.f13741n.m3134a((C0952c) c0952c);
        } else if (t == C0959i.f2702b && this.f13742o != null) {
            this.f13742o.m3134a((C0952c) c0952c);
        } else if (t == C0959i.f2711k && this.f13743p != null) {
            this.f13743p.m3134a((C0952c) c0952c);
        } else if (t == C0959i.f2712l && this.f13744q != null) {
            this.f13744q.m3134a((C0952c) c0952c);
        }
    }
}
