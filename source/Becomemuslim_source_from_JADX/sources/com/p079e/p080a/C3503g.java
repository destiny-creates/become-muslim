package com.p079e.p080a;

import android.content.Context;
import com.facebook.common.util.UriUtil;
import com.p079e.p080a.C1236t.C1233d;
import com.p079e.p080a.C1245y.C1244a;
import java.io.InputStream;

/* compiled from: ContentStreamRequestHandler */
/* renamed from: com.e.a.g */
class C3503g extends C1245y {
    /* renamed from: a */
    final Context f9335a;

    C3503g(Context context) {
        this.f9335a = context;
    }

    /* renamed from: a */
    public boolean mo821a(C1242w c1242w) {
        return UriUtil.LOCAL_CONTENT_SCHEME.equals(c1242w.f3540d.getScheme());
    }

    /* renamed from: a */
    public C1244a mo820a(C1242w c1242w, int i) {
        return new C1244a(m11296b(c1242w), C1233d.DISK);
    }

    /* renamed from: b */
    InputStream m11296b(C1242w c1242w) {
        return this.f9335a.getContentResolver().openInputStream(c1242w.f3540d);
    }
}
