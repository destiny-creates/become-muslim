package com.p079e.p080a;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.RotationOptions;
import com.p079e.p080a.C1236t.C1233d;
import com.p079e.p080a.C1245y.C1244a;

/* compiled from: FileRequestHandler */
/* renamed from: com.e.a.k */
class C4545k extends C3503g {
    C4545k(Context context) {
        super(context);
    }

    /* renamed from: a */
    public boolean mo821a(C1242w c1242w) {
        return UriUtil.LOCAL_FILE_SCHEME.equals(c1242w.f3540d.getScheme());
    }

    /* renamed from: a */
    public C1244a mo820a(C1242w c1242w, int i) {
        return new C1244a(null, m11296b(c1242w), C1233d.DISK, C4545k.m15452a(c1242w.f3540d));
    }

    /* renamed from: a */
    static int m15452a(Uri uri) {
        uri = new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1);
        if (uri == 3) {
            return RotationOptions.ROTATE_180;
        }
        if (uri != 6) {
            return uri != 8 ? null : RotationOptions.ROTATE_270;
        } else {
            return 90;
        }
    }
}
