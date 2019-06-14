package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.p170d.C2629a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@cm
public final class aot {
    /* renamed from: a */
    public static final aot f14795a = new aot();

    protected aot() {
    }

    /* renamed from: a */
    public static aoq m18660a(Context context, ard ard) {
        Context context2;
        List list;
        String a;
        ard ard2 = ard;
        Date a2 = ard.m18778a();
        long time = a2 != null ? a2.getTime() : -1;
        String b = ard.m18780b();
        int c = ard.m18781c();
        Collection d = ard.m18782d();
        if (d.isEmpty()) {
            context2 = context;
            list = null;
        } else {
            list = Collections.unmodifiableList(new ArrayList(d));
            context2 = context;
        }
        boolean a3 = ard2.m18779a(context2);
        int l = ard.m18790l();
        Location e = ard.m18783e();
        Bundle a4 = ard2.m18777a(AdMobAdapter.class);
        boolean f = ard.m18784f();
        String g = ard.m18785g();
        C2629a i = ard.m18787i();
        aru aru = i != null ? new aru(i) : null;
        context2 = context.getApplicationContext();
        if (context2 != null) {
            String packageName = context2.getPackageName();
            aph.m18683a();
            a = mi.m19868a(Thread.currentThread().getStackTrace(), packageName);
        } else {
            a = null;
        }
        return new aoq(7, time, a4, c, list, a3, l, f, g, aru, e, b, ard.m18789k(), ard.m18791m(), Collections.unmodifiableList(new ArrayList(ard.m18792n())), ard.m18786h(), a, ard.m18793o());
    }
}
