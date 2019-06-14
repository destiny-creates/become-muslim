package com.google.android.gms.p190g.p191a;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.internal.p214m.C6825e;
import com.google.android.gms.internal.p214m.C7828c;
import com.google.android.gms.internal.p214m.C7829k;
import com.google.android.gms.p190g.C3040a;
import com.google.android.gms.p190g.C3052b;

/* renamed from: com.google.android.gms.g.a.b */
public final class C4421b extends C3040a<C4820a> {
    /* renamed from: a */
    private final C6825e f11784a;

    /* renamed from: com.google.android.gms.g.a.b$a */
    public static class C3025a {
        /* renamed from: a */
        private Context f7746a;
        /* renamed from: b */
        private C7828c f7747b = new C7828c();

        public C3025a(Context context) {
            this.f7746a = context;
        }

        /* renamed from: a */
        public C3025a m8869a(int i) {
            this.f7747b.f29135a = i;
            return this;
        }

        /* renamed from: a */
        public C4421b m8870a() {
            return new C4421b(new C6825e(this.f7746a, this.f7747b));
        }
    }

    private C4421b() {
        throw new IllegalStateException("Default constructor called");
    }

    private C4421b(C6825e c6825e) {
        this.f11784a = c6825e;
    }

    /* renamed from: a */
    public final SparseArray<C4820a> m14692a(C3052b c3052b) {
        if (c3052b != null) {
            C4820a[] a;
            C7829k a2 = C7829k.a(c3052b);
            if (c3052b.m8912c() != null) {
                a = this.f11784a.a(c3052b.m8912c(), a2);
                if (a == null) {
                    throw new IllegalArgumentException("Internal barcode detector error; check logcat output.");
                }
            } else {
                a = this.f11784a.a(c3052b.m8911b(), a2);
            }
            SparseArray<C4820a> sparseArray = new SparseArray(a.length);
            for (C4820a c4820a : a) {
                sparseArray.append(c4820a.f13615b.hashCode(), c4820a);
            }
            return sparseArray;
        }
        throw new IllegalArgumentException("No frame supplied.");
    }

    /* renamed from: a */
    public final void mo2596a() {
        super.mo2596a();
        this.f11784a.c();
    }

    /* renamed from: b */
    public final boolean mo2597b() {
        return this.f11784a.b();
    }
}
