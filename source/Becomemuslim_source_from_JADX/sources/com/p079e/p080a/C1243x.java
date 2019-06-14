package com.p079e.p080a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.p079e.p080a.C1236t.C1233d;
import com.p079e.p080a.C1242w.C1241a;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: RequestCreator */
/* renamed from: com.e.a.x */
public class C1243x {
    /* renamed from: a */
    private static final AtomicInteger f3555a = new AtomicInteger();
    /* renamed from: b */
    private final C1236t f3556b;
    /* renamed from: c */
    private final C1241a f3557c;
    /* renamed from: d */
    private boolean f3558d;
    /* renamed from: e */
    private boolean f3559e;
    /* renamed from: f */
    private boolean f3560f;
    /* renamed from: g */
    private int f3561g;
    /* renamed from: h */
    private int f3562h;
    /* renamed from: i */
    private int f3563i;
    /* renamed from: j */
    private int f3564j;
    /* renamed from: k */
    private Drawable f3565k;
    /* renamed from: l */
    private Drawable f3566l;
    /* renamed from: m */
    private Object f3567m;

    C1243x(C1236t c1236t, Uri uri, int i) {
        this.f3560f = true;
        if (c1236t.f3507m) {
            throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
        }
        this.f3556b = c1236t;
        this.f3557c = new C1241a(uri, i, c1236t.f3504j);
    }

    C1243x() {
        this.f3560f = true;
        this.f3556b = null;
        this.f3557c = new C1241a(null, 0, null);
    }

    /* renamed from: a */
    C1243x m4338a() {
        this.f3559e = false;
        return this;
    }

    /* renamed from: a */
    public C1243x m4339a(int i, int i2) {
        this.f3557c.m4325a(i, i2);
        return this;
    }

    /* renamed from: a */
    public void m4340a(ImageView imageView, C1212e c1212e) {
        C1243x c1243x = this;
        ImageView imageView2 = imageView;
        C1212e c1212e2 = c1212e;
        long nanoTime = System.nanoTime();
        ae.m4217a();
        if (imageView2 == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (c1243x.f3557c.m4326a()) {
            if (c1243x.f3559e) {
                if (c1243x.f3557c.m4327b()) {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width != 0) {
                    if (height != 0) {
                        c1243x.f3557c.m4325a(width, height);
                    }
                }
                if (c1243x.f3560f) {
                    C1237u.m4321a(imageView2, m4337b());
                }
                c1243x.f3556b.m4312a(imageView2, new C1214h(this, imageView2, c1212e2));
                return;
            }
            C1242w a = m4336a(nanoTime);
            String a2 = ae.m4215a(a);
            if (C1225p.m4295a(c1243x.f3563i)) {
                Bitmap b = c1243x.f3556b.m4315b(a2);
                if (b != null) {
                    c1243x.f3556b.m4311a(imageView2);
                    C1237u.m4320a(imageView, c1243x.f3556b.f3497c, b, C1233d.MEMORY, c1243x.f3558d, c1243x.f3556b.f3505k);
                    if (c1243x.f3556b.f3506l) {
                        String b2 = a.m4330b();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("from ");
                        stringBuilder.append(C1233d.MEMORY);
                        ae.m4221a("Main", "completed", b2, stringBuilder.toString());
                    }
                    if (c1212e2 != null) {
                        c1212e.m4259a();
                    }
                    return;
                }
            }
            if (c1243x.f3560f) {
                C1237u.m4321a(imageView2, m4337b());
            }
            c1243x.f3556b.m4313a(new C3504l(c1243x.f3556b, imageView, a, c1243x.f3563i, c1243x.f3564j, c1243x.f3562h, c1243x.f3566l, a2, c1243x.f3567m, c1212e, c1243x.f3558d));
        } else {
            c1243x.f3556b.m4311a(imageView2);
            if (c1243x.f3560f) {
                C1237u.m4321a(imageView2, m4337b());
            }
        }
    }

    /* renamed from: b */
    private Drawable m4337b() {
        if (this.f3561g != 0) {
            return this.f3556b.f3497c.getResources().getDrawable(this.f3561g);
        }
        return this.f3565k;
    }

    /* renamed from: a */
    private C1242w m4336a(long j) {
        int andIncrement = f3555a.getAndIncrement();
        C1242w c = this.f3557c.m4328c();
        c.f3537a = andIncrement;
        c.f3538b = j;
        boolean z = this.f3556b.f3506l;
        if (z) {
            ae.m4221a("Main", "created", c.m4330b(), c.toString());
        }
        C1242w a = this.f3556b.m4307a(c);
        if (a != c) {
            a.f3537a = andIncrement;
            a.f3538b = j;
            if (z) {
                String a2 = a.m4329a();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("into ");
                stringBuilder.append(a);
                ae.m4221a("Main", "changed", a2, stringBuilder.toString());
            }
        }
        return a;
    }
}
