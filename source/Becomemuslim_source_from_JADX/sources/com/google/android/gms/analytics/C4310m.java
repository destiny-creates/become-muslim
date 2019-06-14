package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.analytics.m */
public final class C4310m implements C2725w {
    /* renamed from: a */
    private static final Uri f11360a;
    /* renamed from: b */
    private final LogPrinter f11361b = new LogPrinter(4, "GA/LogCatTransport");

    /* renamed from: a */
    public final Uri mo2357a() {
        return f11360a;
    }

    /* renamed from: a */
    public final void mo2358a(C2714o c2714o) {
        List arrayList = new ArrayList(c2714o.m7747b());
        Collections.sort(arrayList, new C2713n(this));
        c2714o = new StringBuilder();
        ArrayList arrayList2 = (ArrayList) arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            obj = ((C2716q) obj).toString();
            if (!TextUtils.isEmpty(obj)) {
                if (c2714o.length() != 0) {
                    c2714o.append(", ");
                }
                c2714o.append(obj);
            }
        }
        this.f11361b.println(c2714o.toString());
    }

    static {
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("local");
        f11360a = builder.build();
    }
}
