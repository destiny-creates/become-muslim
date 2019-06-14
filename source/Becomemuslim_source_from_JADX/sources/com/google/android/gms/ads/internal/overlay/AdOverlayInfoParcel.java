package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.C4744r;
import com.google.android.gms.ads.internal.gmsg.C2651k;
import com.google.android.gms.ads.internal.gmsg.C2652m;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.internal.ads.aok;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.mv;
import com.google.android.gms.internal.ads.qo;
import com.google.android.gms.p174b.C2758b.C4325a;
import com.google.android.gms.p174b.C4757d;

@cm
public final class AdOverlayInfoParcel extends C4363a implements ReflectedParcelable {
    public static final Creator<AdOverlayInfoParcel> CREATOR = new C2664m();
    /* renamed from: a */
    public final C4739c f13021a;
    /* renamed from: b */
    public final aok f13022b;
    /* renamed from: c */
    public final C2665n f13023c;
    /* renamed from: d */
    public final qo f13024d;
    /* renamed from: e */
    public final C2652m f13025e;
    /* renamed from: f */
    public final String f13026f;
    /* renamed from: g */
    public final boolean f13027g;
    /* renamed from: h */
    public final String f13028h;
    /* renamed from: i */
    public final C2668t f13029i;
    /* renamed from: j */
    public final int f13030j;
    /* renamed from: k */
    public final int f13031k;
    /* renamed from: l */
    public final String f13032l;
    /* renamed from: m */
    public final mv f13033m;
    /* renamed from: n */
    public final String f13034n;
    /* renamed from: o */
    public final C4744r f13035o;
    /* renamed from: p */
    public final C2651k f13036p;

    AdOverlayInfoParcel(C4739c c4739c, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i, int i2, String str3, mv mvVar, String str4, C4744r c4744r, IBinder iBinder6) {
        this.f13021a = c4739c;
        this.f13022b = (aok) C4757d.m16685a(C4325a.m14024a(iBinder));
        this.f13023c = (C2665n) C4757d.m16685a(C4325a.m14024a(iBinder2));
        this.f13024d = (qo) C4757d.m16685a(C4325a.m14024a(iBinder3));
        this.f13036p = (C2651k) C4757d.m16685a(C4325a.m14024a(iBinder6));
        this.f13025e = (C2652m) C4757d.m16685a(C4325a.m14024a(iBinder4));
        this.f13026f = str;
        this.f13027g = z;
        this.f13028h = str2;
        this.f13029i = (C2668t) C4757d.m16685a(C4325a.m14024a(iBinder5));
        this.f13030j = i;
        this.f13031k = i2;
        this.f13032l = str3;
        this.f13033m = mvVar;
        this.f13034n = str4;
        this.f13035o = c4744r;
    }

    public AdOverlayInfoParcel(C4739c c4739c, aok aok, C2665n c2665n, C2668t c2668t, mv mvVar) {
        this.f13021a = c4739c;
        this.f13022b = aok;
        this.f13023c = c2665n;
        this.f13024d = null;
        this.f13036p = null;
        this.f13025e = null;
        this.f13026f = null;
        this.f13027g = false;
        this.f13028h = null;
        this.f13029i = c2668t;
        this.f13030j = -1;
        this.f13031k = 4;
        this.f13032l = null;
        this.f13033m = mvVar;
        this.f13034n = null;
        this.f13035o = null;
    }

    public AdOverlayInfoParcel(aok aok, C2665n c2665n, C2651k c2651k, C2652m c2652m, C2668t c2668t, qo qoVar, boolean z, int i, String str, mv mvVar) {
        this.f13021a = null;
        this.f13022b = aok;
        this.f13023c = c2665n;
        this.f13024d = qoVar;
        this.f13036p = c2651k;
        this.f13025e = c2652m;
        this.f13026f = null;
        this.f13027g = z;
        this.f13028h = null;
        this.f13029i = c2668t;
        this.f13030j = i;
        this.f13031k = 3;
        this.f13032l = str;
        this.f13033m = mvVar;
        this.f13034n = null;
        this.f13035o = null;
    }

    public AdOverlayInfoParcel(aok aok, C2665n c2665n, C2651k c2651k, C2652m c2652m, C2668t c2668t, qo qoVar, boolean z, int i, String str, String str2, mv mvVar) {
        this.f13021a = null;
        this.f13022b = aok;
        this.f13023c = c2665n;
        this.f13024d = qoVar;
        this.f13036p = c2651k;
        this.f13025e = c2652m;
        this.f13026f = str2;
        this.f13027g = z;
        this.f13028h = str;
        this.f13029i = c2668t;
        this.f13030j = i;
        this.f13031k = 3;
        this.f13032l = null;
        this.f13033m = mvVar;
        this.f13034n = null;
        this.f13035o = null;
    }

    public AdOverlayInfoParcel(aok aok, C2665n c2665n, C2668t c2668t, qo qoVar, int i, mv mvVar, String str, C4744r c4744r) {
        this.f13021a = null;
        this.f13022b = aok;
        this.f13023c = c2665n;
        this.f13024d = qoVar;
        this.f13036p = null;
        this.f13025e = null;
        this.f13026f = null;
        this.f13027g = false;
        this.f13028h = null;
        this.f13029i = c2668t;
        this.f13030j = i;
        this.f13031k = 1;
        this.f13032l = null;
        this.f13033m = mvVar;
        this.f13034n = str;
        this.f13035o = c4744r;
    }

    public AdOverlayInfoParcel(aok aok, C2665n c2665n, C2668t c2668t, qo qoVar, boolean z, int i, mv mvVar) {
        this.f13021a = null;
        this.f13022b = aok;
        this.f13023c = c2665n;
        this.f13024d = qoVar;
        this.f13036p = null;
        this.f13025e = null;
        this.f13026f = null;
        this.f13027g = z;
        this.f13028h = null;
        this.f13029i = c2668t;
        this.f13030j = i;
        this.f13031k = 2;
        this.f13032l = null;
        this.f13033m = mvVar;
        this.f13034n = null;
        this.f13035o = null;
    }

    /* renamed from: a */
    public static com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel m16553a(android.content.Intent r1) {
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
        r0 = "com.google.android.gms.ads.inernal.overlay.AdOverlayInfo";	 Catch:{ Exception -> 0x0018 }
        r1 = r1.getBundleExtra(r0);	 Catch:{ Exception -> 0x0018 }
        r0 = com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel.class;	 Catch:{ Exception -> 0x0018 }
        r0 = r0.getClassLoader();	 Catch:{ Exception -> 0x0018 }
        r1.setClassLoader(r0);	 Catch:{ Exception -> 0x0018 }
        r0 = "com.google.android.gms.ads.inernal.overlay.AdOverlayInfo";	 Catch:{ Exception -> 0x0018 }
        r1 = r1.getParcelable(r0);	 Catch:{ Exception -> 0x0018 }
        r1 = (com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel) r1;	 Catch:{ Exception -> 0x0018 }
        return r1;
    L_0x0018:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel.a(android.content.Intent):com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel");
    }

    /* renamed from: a */
    public static void m16554a(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8188a(parcel, 2, this.f13021a, i, false);
        C2835c.m8187a(parcel, 3, C4757d.m16684a(this.f13022b).asBinder(), false);
        C2835c.m8187a(parcel, 4, C4757d.m16684a(this.f13023c).asBinder(), false);
        C2835c.m8187a(parcel, 5, C4757d.m16684a(this.f13024d).asBinder(), false);
        C2835c.m8187a(parcel, 6, C4757d.m16684a(this.f13025e).asBinder(), false);
        C2835c.m8193a(parcel, 7, this.f13026f, false);
        C2835c.m8196a(parcel, 8, this.f13027g);
        C2835c.m8193a(parcel, 9, this.f13028h, false);
        C2835c.m8187a(parcel, 10, C4757d.m16684a(this.f13029i).asBinder(), false);
        C2835c.m8184a(parcel, 11, this.f13030j);
        C2835c.m8184a(parcel, 12, this.f13031k);
        C2835c.m8193a(parcel, 13, this.f13032l, false);
        C2835c.m8188a(parcel, 14, this.f13033m, i, false);
        C2835c.m8193a(parcel, 16, this.f13034n, false);
        C2835c.m8188a(parcel, 17, this.f13035o, i, false);
        C2835c.m8187a(parcel, 18, C4757d.m16684a(this.f13036p).asBinder(), false);
        C2835c.m8180a(parcel, a);
    }
}
