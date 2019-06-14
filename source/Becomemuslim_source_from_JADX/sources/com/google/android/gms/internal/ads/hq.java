package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.reward.C2697a;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import org.json.JSONArray;

@cm
public final class hq extends C4363a {
    public static final Creator<hq> CREATOR = new hr();
    /* renamed from: a */
    public final String f28691a;
    /* renamed from: b */
    public final int f28692b;

    public hq(C2697a c2697a) {
        this(c2697a.a(), c2697a.b());
    }

    public hq(String str, int i) {
        this.f28691a = str;
        this.f28692b = i;
    }

    /* renamed from: a */
    public static com.google.android.gms.internal.ads.hq m37546a(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r2);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0012 }
        r0.<init>(r2);	 Catch:{ JSONException -> 0x0012 }
        r2 = m37547a(r0);	 Catch:{ JSONException -> 0x0012 }
        return r2;
    L_0x0012:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.hq.a(java.lang.String):com.google.android.gms.internal.ads.hq");
    }

    /* renamed from: a */
    public static hq m37547a(JSONArray jSONArray) {
        if (jSONArray != null) {
            if (jSONArray.length() != 0) {
                return new hq(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
            }
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof hq) {
                hq hqVar = (hq) obj;
                if (C2868t.a(this.f28691a, hqVar.f28691a) && C2868t.a(Integer.valueOf(this.f28692b), Integer.valueOf(hqVar.f28692b))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return C2868t.a(new Object[]{this.f28691a, Integer.valueOf(this.f28692b)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f28691a, false);
        C2835c.a(parcel, 3, this.f28692b);
        C2835c.a(parcel, i);
    }
}
