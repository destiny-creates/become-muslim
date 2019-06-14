package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class ahh extends ahg {
    private ahh(Context context, String str, boolean z) {
        super(context, str, z);
    }

    /* renamed from: a */
    public static ahh m42187a(String str, Context context, boolean z) {
        ahg.m36786a(context, z);
        return new ahh(context, str, z);
    }

    /* renamed from: a */
    protected final List<Callable<Void>> mo6640a(ahz ahz, aaa aaa, ww wwVar) {
        if (ahz.m18460c() != null) {
            if (this.r) {
                int n = ahz.m18471n();
                List<Callable<Void>> arrayList = new ArrayList();
                arrayList.addAll(super.mo6640a(ahz, aaa, wwVar));
                arrayList.add(new ait(ahz, "1QeH3Cf7T53ayw17Ebbo9YTdhU+IFx0X5nCtC5gZQym4uicOVPXxYWmMK9k58i8n", "bHJRpFJ+2R5LAbYQUBDMyfYpLd1oiGixlpIqMJOBQPY=", aaa, n, 24));
                return arrayList;
            }
        }
        return super.mo6640a(ahz, aaa, wwVar);
    }
}
