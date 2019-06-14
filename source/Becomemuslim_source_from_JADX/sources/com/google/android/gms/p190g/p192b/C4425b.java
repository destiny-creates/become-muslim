package com.google.android.gms.p190g.p192b;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.internal.p214m.C7829k;
import com.google.android.gms.p190g.C3040a;
import com.google.android.gms.p190g.C3052b;
import com.google.android.gms.p190g.C3054d;
import com.google.android.gms.p190g.p192b.p193a.p194a.C4422c;
import com.google.android.gms.p190g.p192b.p193a.p194a.C4823e;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.g.b.b */
public final class C4425b extends C3040a<C3048a> {
    /* renamed from: a */
    private final C3054d f11786a;
    /* renamed from: b */
    private final C4422c f11787b;
    /* renamed from: c */
    private final Object f11788c;
    /* renamed from: d */
    private boolean f11789d;

    /* renamed from: com.google.android.gms.g.b.b$a */
    public static class C3049a {
        /* renamed from: a */
        private final Context f7767a;
        /* renamed from: b */
        private int f7768b = 0;
        /* renamed from: c */
        private boolean f7769c = false;
        /* renamed from: d */
        private int f7770d = 0;
        /* renamed from: e */
        private boolean f7771e = true;
        /* renamed from: f */
        private int f7772f = 0;
        /* renamed from: g */
        private float f7773g = -1.0f;

        public C3049a(Context context) {
            this.f7767a = context;
        }

        /* renamed from: a */
        public C3049a m8898a(float f) {
            if (f < 0.0f || f > 1.0f) {
                StringBuilder stringBuilder = new StringBuilder(47);
                stringBuilder.append("Invalid proportional face size: ");
                stringBuilder.append(f);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            this.f7773g = f;
            return this;
        }

        /* renamed from: a */
        public C3049a m8899a(int i) {
            if (i != 0) {
                if (i != 1) {
                    StringBuilder stringBuilder = new StringBuilder(34);
                    stringBuilder.append("Invalid landmark type: ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            this.f7768b = i;
            return this;
        }

        /* renamed from: a */
        public C3049a m8900a(boolean z) {
            this.f7771e = z;
            return this;
        }

        /* renamed from: a */
        public C4425b m8901a() {
            C4823e c4823e = new C4823e();
            c4823e.f13644a = this.f7772f;
            c4823e.f13645b = this.f7768b;
            c4823e.f13646c = this.f7770d;
            c4823e.f13647d = this.f7769c;
            c4823e.f13648e = this.f7771e;
            c4823e.f13649f = this.f7773g;
            return new C4425b(new C4422c(this.f7767a, c4823e));
        }

        /* renamed from: b */
        public C3049a m8902b(int i) {
            if (i != 0) {
                if (i != 1) {
                    StringBuilder stringBuilder = new StringBuilder(40);
                    stringBuilder.append("Invalid classification type: ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            this.f7770d = i;
            return this;
        }

        /* renamed from: c */
        public C3049a m8903c(int i) {
            switch (i) {
                case 0:
                case 1:
                    this.f7772f = i;
                    return this;
                default:
                    StringBuilder stringBuilder = new StringBuilder(25);
                    stringBuilder.append("Invalid mode: ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    private C4425b() {
        this.f11786a = new C3054d();
        this.f11788c = new Object();
        this.f11789d = true;
        throw new IllegalStateException("Default constructor called");
    }

    private C4425b(C4422c c4422c) {
        this.f11786a = new C3054d();
        this.f11788c = new Object();
        this.f11789d = true;
        this.f11787b = c4422c;
    }

    /* renamed from: a */
    public final SparseArray<C3048a> m14700a(C3052b c3052b) {
        if (c3052b != null) {
            C3048a[] a;
            ByteBuffer b = c3052b.m8911b();
            synchronized (this.f11788c) {
                if (this.f11789d) {
                    a = this.f11787b.m14697a(b, C7829k.a(c3052b));
                } else {
                    throw new RuntimeException("Cannot use detector after release()");
                }
            }
            Set hashSet = new HashSet();
            SparseArray<C3048a> sparseArray = new SparseArray(a.length);
            int i = 0;
            for (C3048a c3048a : a) {
                int j = c3048a.m8897j();
                i = Math.max(i, j);
                if (hashSet.contains(Integer.valueOf(j))) {
                    j = i + 1;
                    i = j;
                }
                hashSet.add(Integer.valueOf(j));
                sparseArray.append(this.f11786a.m8913a(j), c3048a);
            }
            return sparseArray;
        }
        throw new IllegalArgumentException("No frame supplied.");
    }

    /* renamed from: a */
    public final void mo2596a() {
        super.mo2596a();
        synchronized (this.f11788c) {
            if (this.f11789d) {
                this.f11787b.c();
                this.f11789d = false;
                return;
            }
        }
    }

    /* renamed from: b */
    public final boolean mo2597b() {
        return this.f11787b.b();
    }

    protected final void finalize() {
        try {
            synchronized (this.f11788c) {
                if (this.f11789d) {
                    Log.w("FaceDetector", "FaceDetector was not released with FaceDetector.release()");
                    mo2596a();
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }
}
