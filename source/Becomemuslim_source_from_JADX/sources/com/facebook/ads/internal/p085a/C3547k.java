package com.facebook.ads.internal.p085a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.internal.p095j.C1397a.C1395a;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p108c.C1539g;

/* renamed from: com.facebook.ads.internal.a.k */
public class C3547k extends C1297b {
    /* renamed from: d */
    private static final String f9466d = "k";
    /* renamed from: e */
    private final Uri f9467e;

    public C3547k(Context context, C1412c c1412c, String str, Uri uri) {
        super(context, c1412c, str);
        this.f9467e = uri;
    }

    /* renamed from: a */
    public C1395a mo918a() {
        return C1395a.OPEN_LINK;
    }

    /* renamed from: b */
    public void mo917b() {
        try {
            Log.w("REDIRECTACTION: ", this.f9467e.toString());
            C1539g.m5388a(new C1539g(), this.a, this.f9467e, this.c);
        } catch (Throwable e) {
            String str = f9466d;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to open link url: ");
            stringBuilder.append(this.f9467e.toString());
            Log.d(str, stringBuilder.toString(), e);
        }
    }
}
