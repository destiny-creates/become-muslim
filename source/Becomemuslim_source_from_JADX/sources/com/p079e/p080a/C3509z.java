package com.p079e.p080a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.facebook.common.util.UriUtil;
import com.p079e.p080a.C1236t.C1233d;
import com.p079e.p080a.C1245y.C1244a;

/* compiled from: ResourceRequestHandler */
/* renamed from: com.e.a.z */
class C3509z extends C1245y {
    /* renamed from: a */
    private final Context f9347a;

    C3509z(Context context) {
        this.f9347a = context;
    }

    /* renamed from: a */
    public boolean mo821a(C1242w c1242w) {
        if (c1242w.f3541e != 0) {
            return true;
        }
        return UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(c1242w.f3540d.getScheme());
    }

    /* renamed from: a */
    public C1244a mo820a(C1242w c1242w, int i) {
        Resources a = ae.m4209a(this.f9347a, c1242w);
        return new C1244a(C3509z.m11313a(a, ae.m4206a(a, c1242w), c1242w), C1233d.DISK);
    }

    /* renamed from: a */
    private static Bitmap m11313a(Resources resources, int i, C1242w c1242w) {
        Options c = C1245y.m4348c(c1242w);
        if (C1245y.m4347a(c)) {
            BitmapFactory.decodeResource(resources, i, c);
            C1245y.m4346a(c1242w.f3544h, c1242w.f3545i, c, c1242w);
        }
        return BitmapFactory.decodeResource(resources, i, c);
    }
}
