package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.p169c.C2627a.C2626a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

@cm
public final class br implements bh<atu> {
    /* renamed from: a */
    private final boolean f23994a;
    /* renamed from: b */
    private final boolean f23995b;
    /* renamed from: c */
    private final boolean f23996c;

    public br(boolean z, boolean z2, boolean z3) {
        this.f23994a = z;
        this.f23995b = z2;
        this.f23996c = z3;
    }

    /* renamed from: a */
    public final /* synthetic */ aui mo4219a(ay ayVar, JSONObject jSONObject) {
        String string;
        ay ayVar2 = ayVar;
        JSONObject jSONObject2 = jSONObject;
        List<no> a = ayVar.m19124a(jSONObject, "images", false, this.f23994a, this.f23995b);
        Future a2 = ayVar2.m19123a(jSONObject2, "app_icon", true, this.f23994a);
        no a3 = ayVar2.m19122a(jSONObject2, "video");
        Future a4 = ayVar.m19121a(jSONObject);
        List arrayList = new ArrayList();
        for (no noVar : a) {
            arrayList.add((att) noVar.get());
        }
        qo a5 = ay.m19112a(a3);
        String string2 = jSONObject2.getString("headline");
        if (r0.f23996c) {
            if (((Boolean) aph.m18688f().m18889a(asp.dm)).booleanValue()) {
                Resources h = ax.i().m30843h();
                string = h != null ? h.getString(C2626a.s7) : "Test Ad";
                if (string2 != null) {
                    StringBuilder stringBuilder = new StringBuilder((String.valueOf(string).length() + 3) + String.valueOf(string2).length());
                    stringBuilder.append(string);
                    stringBuilder.append(" : ");
                    stringBuilder.append(string2);
                    string2 = stringBuilder.toString();
                }
                return new atu(string, arrayList, jSONObject2.getString("body"), (avd) a2.get(), jSONObject2.getString("call_to_action"), jSONObject2.optDouble("rating", -1.0d), jSONObject2.optString("store"), jSONObject2.optString("price"), (atp) a4.get(), new Bundle(), a5 == null ? a5.mo6127b() : null, a5 == null ? a5.getView() : null, null, null);
            }
        }
        string = string2;
        if (a5 == null) {
        }
        if (a5 == null) {
        }
        return new atu(string, arrayList, jSONObject2.getString("body"), (avd) a2.get(), jSONObject2.getString("call_to_action"), jSONObject2.optDouble("rating", -1.0d), jSONObject2.optString("store"), jSONObject2.optString("price"), (atp) a4.get(), new Bundle(), a5 == null ? a5.mo6127b() : null, a5 == null ? a5.getView() : null, null, null);
    }
}
