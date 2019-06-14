package com.p079e.p080a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.p079e.p080a.C1236t.C1233d;
import com.p079e.p080a.C1236t.C1234e;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: Action */
/* renamed from: com.e.a.a */
abstract class C1194a<T> {
    /* renamed from: a */
    final C1236t f3348a;
    /* renamed from: b */
    final C1242w f3349b;
    /* renamed from: c */
    final WeakReference<T> f3350c;
    /* renamed from: d */
    final boolean f3351d;
    /* renamed from: e */
    final int f3352e;
    /* renamed from: f */
    final int f3353f;
    /* renamed from: g */
    final int f3354g;
    /* renamed from: h */
    final Drawable f3355h;
    /* renamed from: i */
    final String f3356i;
    /* renamed from: j */
    final Object f3357j;
    /* renamed from: k */
    boolean f3358k;
    /* renamed from: l */
    boolean f3359l;

    /* compiled from: Action */
    /* renamed from: com.e.a.a$a */
    static class C1193a<M> extends WeakReference<M> {
        /* renamed from: a */
        final C1194a f3347a;

        public C1193a(C1194a c1194a, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f3347a = c1194a;
        }
    }

    /* renamed from: a */
    abstract void mo826a();

    /* renamed from: a */
    abstract void mo827a(Bitmap bitmap, C1233d c1233d);

    C1194a(C1236t c1236t, T t, C1242w c1242w, int i, int i2, int i3, Drawable drawable, String str, Object obj, boolean z) {
        this.f3348a = c1236t;
        this.f3349b = c1242w;
        if (t == null) {
            c1236t = null;
        } else {
            c1236t = new C1193a(this, t, c1236t.f3503i);
        }
        this.f3350c = c1236t;
        this.f3352e = i;
        this.f3353f = i2;
        this.f3351d = z;
        this.f3354g = i3;
        this.f3355h = drawable;
        this.f3356i = str;
        if (obj == null) {
            obj = this;
        }
        this.f3357j = obj;
    }

    /* renamed from: b */
    void mo828b() {
        this.f3359l = true;
    }

    /* renamed from: c */
    C1242w m4175c() {
        return this.f3349b;
    }

    /* renamed from: d */
    T m4176d() {
        return this.f3350c == null ? null : this.f3350c.get();
    }

    /* renamed from: e */
    String m4177e() {
        return this.f3356i;
    }

    /* renamed from: f */
    boolean m4178f() {
        return this.f3359l;
    }

    /* renamed from: g */
    boolean m4179g() {
        return this.f3358k;
    }

    /* renamed from: h */
    int m4180h() {
        return this.f3352e;
    }

    /* renamed from: i */
    int m4181i() {
        return this.f3353f;
    }

    /* renamed from: j */
    C1236t m4182j() {
        return this.f3348a;
    }

    /* renamed from: k */
    C1234e m4183k() {
        return this.f3349b.f3554r;
    }

    /* renamed from: l */
    Object m4184l() {
        return this.f3357j;
    }
}
