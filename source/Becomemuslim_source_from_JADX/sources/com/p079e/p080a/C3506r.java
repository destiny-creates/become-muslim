package com.p079e.p080a;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import com.facebook.common.util.UriUtil;
import com.p079e.p080a.C1236t.C1233d;
import com.p079e.p080a.C1245y.C1244a;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: NetworkRequestHandler */
/* renamed from: com.e.a.r */
class C3506r extends C1245y {
    /* renamed from: a */
    private final C1222j f9344a;
    /* renamed from: b */
    private final aa f9345b;

    /* compiled from: NetworkRequestHandler */
    /* renamed from: com.e.a.r$a */
    static class C1227a extends IOException {
        public C1227a(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    int mo829a() {
        return 2;
    }

    /* renamed from: b */
    boolean mo831b() {
        return true;
    }

    public C3506r(C1222j c1222j, aa aaVar) {
        this.f9344a = c1222j;
        this.f9345b = aaVar;
    }

    /* renamed from: a */
    public boolean mo821a(C1242w c1242w) {
        c1242w = c1242w.f3540d.getScheme();
        if (!UriUtil.HTTP_SCHEME.equals(c1242w)) {
            if (UriUtil.HTTPS_SCHEME.equals(c1242w) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    public C1244a mo820a(C1242w c1242w, int i) {
        c1242w = this.f9344a.mo819a(c1242w.f3540d, c1242w.f3539c);
        if (c1242w == null) {
            return null;
        }
        C1233d c1233d = c1242w.f3446c ? C1233d.DISK : C1233d.NETWORK;
        Bitmap b = c1242w.m4288b();
        if (b != null) {
            return new C1244a(b, c1233d);
        }
        InputStream a = c1242w.m4287a();
        if (a == null) {
            return null;
        }
        if (c1233d == C1233d.DISK) {
            if (c1242w.m4289c() == 0) {
                ae.m4219a(a);
                throw new C1227a("Received response with 0 content-length header.");
            }
        }
        if (c1233d == C1233d.NETWORK && c1242w.m4289c() > 0) {
            this.f9345b.m4188a(c1242w.m4289c());
        }
        return new C1244a(a, c1233d);
    }

    /* renamed from: a */
    boolean mo830a(boolean z, NetworkInfo networkInfo) {
        if (networkInfo != null) {
            if (!networkInfo.isConnected()) {
                return false;
            }
        }
        return true;
    }
}
