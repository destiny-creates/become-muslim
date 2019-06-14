package com.p079e.p080a;

import android.content.Context;
import android.content.res.AssetManager;
import com.facebook.common.util.UriUtil;
import com.p079e.p080a.C1236t.C1233d;
import com.p079e.p080a.C1245y.C1244a;

/* compiled from: AssetRequestHandler */
/* renamed from: com.e.a.b */
class C3499b extends C1245y {
    /* renamed from: a */
    private static final int f9331a = "file:///android_asset/".length();
    /* renamed from: b */
    private final AssetManager f9332b;

    public C3499b(Context context) {
        this.f9332b = context.getAssets();
    }

    /* renamed from: a */
    public boolean mo821a(C1242w c1242w) {
        c1242w = c1242w.f3540d;
        if (!UriUtil.LOCAL_FILE_SCHEME.equals(c1242w.getScheme()) || c1242w.getPathSegments().isEmpty() || "android_asset".equals(c1242w.getPathSegments().get(0)) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public C1244a mo820a(C1242w c1242w, int i) {
        return new C1244a(this.f9332b.open(C3499b.m11282b(c1242w)), C1233d.DISK);
    }

    /* renamed from: b */
    static String m11282b(C1242w c1242w) {
        return c1242w.f3540d.toString().substring(f9331a);
    }
}
