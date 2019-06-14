package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p212k.C5031v;
import com.google.android.gms.internal.p212k.C5032y;
import com.google.android.gms.internal.p212k.C6822z;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.maps.model.i */
public final class C5141i {
    /* renamed from: a */
    private final C5031v f17414a;
    /* renamed from: b */
    private final C5140a f17415b;

    /* renamed from: com.google.android.gms.maps.model.i$a */
    static class C5140a {
        /* renamed from: a */
        public static final C5140a f17413a = new C5140a();

        private C5140a() {
        }

        /* renamed from: a */
        public static C5032y m21780a(IBinder iBinder) {
            return C6822z.m31924a(iBinder);
        }

        /* renamed from: a */
        public static C5142j m21781a(C5032y c5032y) {
            return new C5142j(c5032y);
        }
    }

    public C5141i(C5031v c5031v) {
        this(c5031v, C5140a.f17413a);
    }

    private C5141i(C5031v c5031v, C5140a c5140a) {
        this.f17414a = (C5031v) C2872v.a(c5031v, "delegate");
        this.f17415b = (C5140a) C2872v.a(c5140a, "shim");
    }

    /* renamed from: a */
    public final int m21782a() {
        try {
            return this.f17414a.mo4728a();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: b */
    public final List<C5142j> m21783b() {
        try {
            List<IBinder> b = this.f17414a.mo4730b();
            List<C5142j> arrayList = new ArrayList(b.size());
            for (IBinder a : b) {
                arrayList.add(C5140a.m21781a(C5140a.m21780a(a)));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    /* renamed from: c */
    public final boolean m21784c() {
        try {
            return this.f17414a.mo4731c();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C5141i)) {
            return false;
        }
        try {
            return this.f17414a.mo4729a(((C5141i) obj).f17414a);
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }

    public final int hashCode() {
        try {
            return this.f17414a.mo4732d();
        } catch (RemoteException e) {
            throw new C5146u(e);
        }
    }
}
