package com.facebook.ads.internal.p085a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.p095j.C1397a.C1395a;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p108c.C1539g;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.a.i */
class C4557i extends C3545h {
    /* renamed from: e */
    private static final String f12288e = "i";
    /* renamed from: f */
    private final Uri f12289f;
    /* renamed from: g */
    private final Map<String, String> f12290g;

    C4557i(Context context, C1412c c1412c, String str, Uri uri, Map<String, String> map, C1304l c1304l) {
        super(context, c1412c, str, c1304l);
        this.f12289f = uri;
        this.f12290g = map;
    }

    /* renamed from: a */
    public C1395a mo918a() {
        return C1395a.OPEN_LINK;
    }

    /* renamed from: e */
    void mo2815e() {
        C1296a c1296a;
        try {
            C1539g.m5388a(new C1539g(), this.a, Uri.parse(this.f12289f.getQueryParameter("link")), this.c);
            c1296a = null;
        } catch (Throwable e) {
            String str = f12288e;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to open link url: ");
            stringBuilder.append(this.f12289f.toString());
            Log.d(str, stringBuilder.toString(), e);
            c1296a = C1296a.CANNOT_OPEN;
        }
        m11492a(this.f12290g, c1296a);
    }
}
