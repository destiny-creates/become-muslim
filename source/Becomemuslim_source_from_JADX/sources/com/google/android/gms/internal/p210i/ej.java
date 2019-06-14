package com.google.android.gms.internal.p210i;

import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.i.ej */
class ej extends ei {
    /* renamed from: b */
    protected final byte[] f28884b;

    ej(byte[] bArr) {
        if (bArr != null) {
            this.f28884b = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* renamed from: e */
    protected int mo6725e() {
        return 0;
    }

    /* renamed from: a */
    public byte mo6159a(int i) {
        return this.f28884b[i];
    }

    /* renamed from: b */
    byte mo6166b(int i) {
        return this.f28884b[i];
    }

    /* renamed from: a */
    public int mo6160a() {
        return this.f28884b.length;
    }

    /* renamed from: a */
    public final dy mo6162a(int i, int i2) {
        i = dy.m20455b(0, i2, mo6160a());
        if (i == 0) {
            return dy.f16513a;
        }
        return new ed(this.f28884b, mo6725e(), i);
    }

    /* renamed from: a */
    final void mo6164a(dx dxVar) {
        dxVar.mo6184a(this.f28884b, mo6725e(), mo6160a());
    }

    /* renamed from: a */
    protected final String mo6163a(Charset charset) {
        return new String(this.f28884b, mo6725e(), mo6160a(), charset);
    }

    /* renamed from: c */
    public final boolean mo6167c() {
        int e = mo6725e();
        return ij.m20860a(this.f28884b, e, mo6160a() + e);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof dy) || mo6160a() != ((dy) obj).mo6160a()) {
            return false;
        }
        if (mo6160a() == 0) {
            return true;
        }
        if (!(obj instanceof ej)) {
            return obj.equals(this);
        }
        ej ejVar = (ej) obj;
        int d = m20466d();
        int d2 = ejVar.m20466d();
        if (d == 0 || d2 == 0 || d == d2) {
            return mo6165a(ejVar, 0, mo6160a());
        }
        return false;
    }

    /* renamed from: a */
    final boolean mo6165a(dy dyVar, int i, int i2) {
        StringBuilder stringBuilder;
        if (i2 > dyVar.mo6160a()) {
            i = mo6160a();
            stringBuilder = new StringBuilder(40);
            stringBuilder.append("Length too large: ");
            stringBuilder.append(i2);
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i2 > dyVar.mo6160a()) {
            dyVar = dyVar.mo6160a();
            stringBuilder = new StringBuilder(59);
            stringBuilder.append("Ran off end of other: 0, ");
            stringBuilder.append(i2);
            stringBuilder.append(", ");
            stringBuilder.append(dyVar);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if ((dyVar instanceof ej) == 0) {
            return dyVar.mo6162a(0, i2).equals(mo6162a(0, i2));
        } else {
            ej ejVar = (ej) dyVar;
            if (ih.m20810a(this.f28884b, mo6725e(), ejVar.f28884b, ejVar.mo6725e(), i2) == -1) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: a */
    protected final int mo6161a(int i, int i2, int i3) {
        return fm.m20553a(i, this.f28884b, mo6725e(), i3);
    }
}
