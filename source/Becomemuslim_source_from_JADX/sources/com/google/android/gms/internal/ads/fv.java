package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.ax;
import org.json.JSONObject;

@cm
public final class fv implements ey {
    /* renamed from: a */
    private bbp<JSONObject, JSONObject> f24079a;
    /* renamed from: b */
    private bbp<JSONObject, JSONObject> f24080b;

    public fv(Context context) {
        this.f24079a = ax.s().m19211a(context, mv.m37566a()).m19215a("google.afma.request.getAdDictionary", bbu.f15167a, bbu.f15167a);
        this.f24080b = ax.s().m19211a(context, mv.m37566a()).m19215a("google.afma.sdkConstants.getSdkConstants", bbu.f15167a, bbu.f15167a);
    }

    /* renamed from: a */
    public final bbp<JSONObject, JSONObject> mo4245a() {
        return this.f24079a;
    }

    /* renamed from: b */
    public final bbp<JSONObject, JSONObject> mo4246b() {
        return this.f24080b;
    }
}
