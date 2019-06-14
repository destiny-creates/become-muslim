package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@cm
public final class dl extends C4363a {
    public static final Creator<dl> CREATOR = new dn();
    /* renamed from: A */
    public final long f28519A;
    /* renamed from: B */
    public final String f28520B;
    /* renamed from: C */
    public final float f28521C;
    /* renamed from: D */
    public final int f28522D;
    /* renamed from: E */
    public final int f28523E;
    /* renamed from: F */
    public final boolean f28524F;
    /* renamed from: G */
    public final boolean f28525G;
    /* renamed from: H */
    public final String f28526H;
    /* renamed from: I */
    public final boolean f28527I;
    /* renamed from: J */
    public final String f28528J;
    /* renamed from: K */
    public final boolean f28529K;
    /* renamed from: L */
    public final int f28530L;
    /* renamed from: M */
    public final Bundle f28531M;
    /* renamed from: N */
    public final String f28532N;
    /* renamed from: O */
    public final arb f28533O;
    /* renamed from: P */
    public final boolean f28534P;
    /* renamed from: Q */
    public final Bundle f28535Q;
    /* renamed from: R */
    public final String f28536R;
    /* renamed from: S */
    public final String f28537S;
    /* renamed from: T */
    public final String f28538T;
    /* renamed from: U */
    public final boolean f28539U;
    /* renamed from: V */
    public final List<Integer> f28540V;
    /* renamed from: W */
    public final String f28541W;
    /* renamed from: X */
    public final List<String> f28542X;
    /* renamed from: Y */
    public final int f28543Y;
    /* renamed from: Z */
    public final boolean f28544Z;
    /* renamed from: a */
    public final int f28545a;
    public final boolean aa;
    public final boolean ab;
    public final ArrayList<String> ac;
    /* renamed from: b */
    public final Bundle f28546b;
    /* renamed from: c */
    public final aoq f28547c;
    /* renamed from: d */
    public final aou f28548d;
    /* renamed from: e */
    public final String f28549e;
    /* renamed from: f */
    public final ApplicationInfo f28550f;
    /* renamed from: g */
    public final PackageInfo f28551g;
    /* renamed from: h */
    public final String f28552h;
    /* renamed from: i */
    public final String f28553i;
    /* renamed from: j */
    public final String f28554j;
    /* renamed from: k */
    public final mv f28555k;
    /* renamed from: l */
    public final Bundle f28556l;
    /* renamed from: m */
    public final int f28557m;
    /* renamed from: n */
    public final List<String> f28558n;
    /* renamed from: o */
    public final Bundle f28559o;
    /* renamed from: p */
    public final boolean f28560p;
    /* renamed from: q */
    public final int f28561q;
    /* renamed from: r */
    public final int f28562r;
    /* renamed from: s */
    public final float f28563s;
    /* renamed from: t */
    public final String f28564t;
    /* renamed from: u */
    public final long f28565u;
    /* renamed from: v */
    public final String f28566v;
    /* renamed from: w */
    public final List<String> f28567w;
    /* renamed from: x */
    public final String f28568x;
    /* renamed from: y */
    public final aus f28569y;
    /* renamed from: z */
    public final List<String> f28570z;

    dl(int i, Bundle bundle, aoq aoq, aou aou, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, mv mvVar, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, int i3, int i4, float f, String str5, long j, String str6, List<String> list2, String str7, aus aus, List<String> list3, long j2, String str8, float f2, boolean z2, int i5, int i6, boolean z3, boolean z4, String str9, String str10, boolean z5, int i7, Bundle bundle4, String str11, arb arb, boolean z6, Bundle bundle5, String str12, String str13, String str14, boolean z7, List<Integer> list4, String str15, List<String> list5, int i8, boolean z8, boolean z9, boolean z10, ArrayList<String> arrayList) {
        this.f28545a = i;
        this.f28546b = bundle;
        this.f28547c = aoq;
        this.f28548d = aou;
        this.f28549e = str;
        this.f28550f = applicationInfo;
        this.f28551g = packageInfo;
        this.f28552h = str2;
        this.f28553i = str3;
        this.f28554j = str4;
        this.f28555k = mvVar;
        this.f28556l = bundle2;
        this.f28557m = i2;
        this.f28558n = list;
        r0.f28570z = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        r0.f28559o = bundle3;
        r0.f28560p = z;
        r0.f28561q = i3;
        r0.f28562r = i4;
        r0.f28563s = f;
        r0.f28564t = str5;
        r0.f28565u = j;
        r0.f28566v = str6;
        r0.f28567w = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        r0.f28568x = str7;
        r0.f28569y = aus;
        r0.f28519A = j2;
        r0.f28520B = str8;
        r0.f28521C = f2;
        r0.f28527I = z2;
        r0.f28522D = i5;
        r0.f28523E = i6;
        r0.f28524F = z3;
        r0.f28525G = z4;
        r0.f28526H = str9;
        r0.f28528J = str10;
        r0.f28529K = z5;
        r0.f28530L = i7;
        r0.f28531M = bundle4;
        r0.f28532N = str11;
        r0.f28533O = arb;
        r0.f28534P = z6;
        r0.f28535Q = bundle5;
        r0.f28536R = str12;
        r0.f28537S = str13;
        r0.f28538T = str14;
        r0.f28539U = z7;
        r0.f28540V = list4;
        r0.f28541W = str15;
        r0.f28542X = list5;
        r0.f28543Y = i8;
        r0.f28544Z = z8;
        r0.aa = z9;
        r0.ab = z10;
        r0.ac = arrayList;
    }

    private dl(Bundle bundle, aoq aoq, aou aou, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, mv mvVar, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, int i2, int i3, float f, String str5, long j, String str6, List<String> list3, String str7, aus aus, long j2, String str8, float f2, boolean z2, int i4, int i5, boolean z3, boolean z4, String str9, String str10, boolean z5, int i6, Bundle bundle4, String str11, arb arb, boolean z6, Bundle bundle5, String str12, String str13, String str14, boolean z7, List<Integer> list4, String str15, List<String> list5, int i7, boolean z8, boolean z9, boolean z10, ArrayList<String> arrayList) {
        this(24, bundle, aoq, aou, str, applicationInfo, packageInfo, str2, str3, str4, mvVar, bundle2, i, list, bundle3, z, i2, i3, f, str5, j, str6, list3, str7, aus, list2, j2, str8, f2, z2, i4, i5, z3, z4, str9, str10, z5, i6, bundle4, str11, arb, z6, bundle5, str12, str13, str14, z7, list4, str15, list5, i7, z8, z9, z10, arrayList);
    }

    public dl(dm dmVar, long j, String str, String str2, String str3) {
        dm dmVar2 = dmVar;
        long j2 = j;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        Bundle bundle = dmVar2.f15302a;
        aoq aoq = dmVar2.f15303b;
        aou aou = dmVar2.f15304c;
        this(bundle, aoq, aou, dmVar2.f15305d, dmVar2.f15306e, dmVar2.f15307f, (String) nd.m19943a(dmVar2.f15294Q, (Object) ""), dmVar2.f15308g, dmVar2.f15309h, dmVar2.f15311j, dmVar2.f15310i, dmVar2.f15312k, dmVar2.f15313l, dmVar2.f15314m, dmVar2.f15316o, dmVar2.f15317p, dmVar2.f15318q, dmVar2.f15319r, dmVar2.f15320s, dmVar2.f15321t, dmVar2.f15322u, dmVar2.f15323v, dmVar2.f15324w, dmVar2.f15325x, dmVar2.f15326y, j2, dmVar2.f15327z, dmVar2.f15278A, dmVar2.f15279B, dmVar2.f15280C, dmVar2.f15281D, dmVar2.f15282E, dmVar2.f15283F, (String) nd.m19944a(dmVar2.f15284G, (Object) "", 1, TimeUnit.SECONDS), dmVar2.f15285H, dmVar2.f15286I, dmVar2.f15287J, dmVar2.f15288K, dmVar2.f15289L, dmVar2.f15290M, dmVar2.f15291N, dmVar2.f15292O, str4, str5, str6, dmVar2.f15293P, dmVar2.f15295R, dmVar2.f15296S, dmVar2.f15315n, dmVar2.f15297T, dmVar2.f15298U, dmVar2.f15299V, dmVar2.f15300W, dmVar2.f15301X);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f28545a);
        C2835c.a(parcel, 2, this.f28546b, false);
        C2835c.a(parcel, 3, this.f28547c, i, false);
        C2835c.a(parcel, 4, this.f28548d, i, false);
        C2835c.a(parcel, 5, this.f28549e, false);
        C2835c.a(parcel, 6, this.f28550f, i, false);
        C2835c.a(parcel, 7, this.f28551g, i, false);
        C2835c.a(parcel, 8, this.f28552h, false);
        C2835c.a(parcel, 9, this.f28553i, false);
        C2835c.a(parcel, 10, this.f28554j, false);
        C2835c.a(parcel, 11, this.f28555k, i, false);
        C2835c.a(parcel, 12, this.f28556l, false);
        C2835c.a(parcel, 13, this.f28557m);
        C2835c.b(parcel, 14, this.f28558n, false);
        C2835c.a(parcel, 15, this.f28559o, false);
        C2835c.a(parcel, 16, this.f28560p);
        C2835c.a(parcel, 18, this.f28561q);
        C2835c.a(parcel, 19, this.f28562r);
        C2835c.a(parcel, 20, this.f28563s);
        C2835c.a(parcel, 21, this.f28564t, false);
        C2835c.a(parcel, 25, this.f28565u);
        C2835c.a(parcel, 26, this.f28566v, false);
        C2835c.b(parcel, 27, this.f28567w, false);
        C2835c.a(parcel, 28, this.f28568x, false);
        C2835c.a(parcel, 29, this.f28569y, i, false);
        C2835c.b(parcel, 30, this.f28570z, false);
        C2835c.a(parcel, 31, this.f28519A);
        C2835c.a(parcel, 33, this.f28520B, false);
        C2835c.a(parcel, 34, this.f28521C);
        C2835c.a(parcel, 35, this.f28522D);
        C2835c.a(parcel, 36, this.f28523E);
        C2835c.a(parcel, 37, this.f28524F);
        C2835c.a(parcel, 38, this.f28525G);
        C2835c.a(parcel, 39, this.f28526H, false);
        C2835c.a(parcel, 40, this.f28527I);
        C2835c.a(parcel, 41, this.f28528J, false);
        C2835c.a(parcel, 42, this.f28529K);
        C2835c.a(parcel, 43, this.f28530L);
        C2835c.a(parcel, 44, this.f28531M, false);
        C2835c.a(parcel, 45, this.f28532N, false);
        C2835c.a(parcel, 46, this.f28533O, i, false);
        C2835c.a(parcel, 47, this.f28534P);
        C2835c.a(parcel, 48, this.f28535Q, false);
        C2835c.a(parcel, 49, this.f28536R, false);
        C2835c.a(parcel, 50, this.f28537S, false);
        C2835c.a(parcel, 51, this.f28538T, false);
        C2835c.a(parcel, 52, this.f28539U);
        C2835c.a(parcel, 53, this.f28540V, false);
        C2835c.a(parcel, 54, this.f28541W, false);
        C2835c.b(parcel, 55, this.f28542X, false);
        C2835c.a(parcel, 56, this.f28543Y);
        C2835c.a(parcel, 57, this.f28544Z);
        C2835c.a(parcel, 58, this.aa);
        C2835c.a(parcel, 59, this.ab);
        C2835c.b(parcel, 60, this.ac, false);
        C2835c.a(parcel, a);
    }
}
