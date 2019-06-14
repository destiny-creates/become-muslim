package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.Collections;
import java.util.List;

@cm
public final class dp extends C4363a {
    public static final Creator<dp> CREATOR = new dq();
    /* renamed from: A */
    public final hq f28572A;
    /* renamed from: B */
    public final List<String> f28573B;
    /* renamed from: C */
    public final List<String> f28574C;
    /* renamed from: D */
    public final boolean f28575D;
    /* renamed from: E */
    public final dr f28576E;
    /* renamed from: F */
    public final boolean f28577F;
    /* renamed from: G */
    public String f28578G;
    /* renamed from: H */
    public final List<String> f28579H;
    /* renamed from: I */
    public final boolean f28580I;
    /* renamed from: J */
    public final String f28581J;
    /* renamed from: K */
    public final ia f28582K;
    /* renamed from: L */
    public final String f28583L;
    /* renamed from: M */
    public final boolean f28584M;
    /* renamed from: N */
    public final boolean f28585N;
    /* renamed from: O */
    public final boolean f28586O;
    /* renamed from: P */
    public final int f28587P;
    /* renamed from: Q */
    public final boolean f28588Q;
    /* renamed from: R */
    public final List<String> f28589R;
    /* renamed from: S */
    public final boolean f28590S;
    /* renamed from: T */
    public final String f28591T;
    /* renamed from: U */
    private dl f28592U;
    /* renamed from: V */
    private final int f28593V;
    /* renamed from: W */
    private eb f28594W;
    /* renamed from: X */
    private Bundle f28595X;
    /* renamed from: a */
    public final String f28596a;
    /* renamed from: b */
    public String f28597b;
    /* renamed from: c */
    public final List<String> f28598c;
    /* renamed from: d */
    public final int f28599d;
    /* renamed from: e */
    public final List<String> f28600e;
    /* renamed from: f */
    public final long f28601f;
    /* renamed from: g */
    public final boolean f28602g;
    /* renamed from: h */
    public final long f28603h;
    /* renamed from: i */
    public final List<String> f28604i;
    /* renamed from: j */
    public final long f28605j;
    /* renamed from: k */
    public final int f28606k;
    /* renamed from: l */
    public final String f28607l;
    /* renamed from: m */
    public final long f28608m;
    /* renamed from: n */
    public final String f28609n;
    /* renamed from: o */
    public final boolean f28610o;
    /* renamed from: p */
    public final String f28611p;
    /* renamed from: q */
    public final String f28612q;
    /* renamed from: r */
    public final boolean f28613r;
    /* renamed from: s */
    public final boolean f28614s;
    /* renamed from: t */
    public final boolean f28615t;
    /* renamed from: u */
    public final boolean f28616u;
    /* renamed from: v */
    public final boolean f28617v;
    /* renamed from: w */
    public String f28618w;
    /* renamed from: x */
    public final String f28619x;
    /* renamed from: y */
    public final boolean f28620y;
    /* renamed from: z */
    public final boolean f28621z;

    public dp(int i) {
        this(19, null, null, null, i, null, -1, false, -1, null, -1, -1, null, -1, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false, null, false, 0, false, null, false, null);
    }

    public dp(int i, long j) {
        this(19, null, null, null, i, null, -1, false, -1, null, j, -1, null, -1, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false, null, false, 0, false, null, false, null);
    }

    dp(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, eb ebVar, String str7, String str8, boolean z8, boolean z9, hq hqVar, List<String> list4, List<String> list5, boolean z10, dr drVar, boolean z11, String str9, List<String> list6, boolean z12, String str10, ia iaVar, String str11, boolean z13, boolean z14, Bundle bundle, boolean z15, int i4, boolean z16, List<String> list7, boolean z17, String str12) {
        this.f28593V = i;
        this.f28596a = str;
        this.f28597b = str2;
        List list8 = null;
        r0.f28598c = list != null ? Collections.unmodifiableList(list) : null;
        r0.f28599d = i2;
        r0.f28600e = list2 != null ? Collections.unmodifiableList(list2) : null;
        r0.f28601f = j;
        r0.f28602g = z;
        r0.f28603h = j2;
        r0.f28604i = list3 != null ? Collections.unmodifiableList(list3) : null;
        r0.f28605j = j3;
        r0.f28606k = i3;
        r0.f28607l = str3;
        r0.f28608m = j4;
        r0.f28609n = str4;
        r0.f28610o = z2;
        r0.f28611p = str5;
        r0.f28612q = str6;
        r0.f28613r = z3;
        r0.f28614s = z4;
        r0.f28615t = z5;
        r0.f28616u = z6;
        r0.f28584M = z13;
        r0.f28617v = z7;
        r0.f28594W = ebVar;
        r0.f28618w = str7;
        r0.f28619x = str8;
        if (r0.f28597b == null && r0.f28594W != null) {
            eq eqVar = (eq) r0.f28594W.m37462a(eq.CREATOR);
            if (!(eqVar == null || TextUtils.isEmpty(eqVar.f28649a))) {
                r0.f28597b = eqVar.f28649a;
            }
        }
        r0.f28620y = z8;
        r0.f28621z = z9;
        r0.f28572A = hqVar;
        r0.f28573B = list4;
        r0.f28574C = list5;
        r0.f28575D = z10;
        r0.f28576E = drVar;
        r0.f28577F = z11;
        r0.f28578G = str9;
        r0.f28579H = list6;
        r0.f28580I = z12;
        r0.f28581J = str10;
        r0.f28582K = iaVar;
        r0.f28583L = str11;
        r0.f28585N = z14;
        r0.f28595X = bundle;
        r0.f28586O = z15;
        r0.f28587P = i4;
        r0.f28588Q = z16;
        if (list7 != null) {
            list8 = Collections.unmodifiableList(list7);
        }
        r0.f28589R = list8;
        r0.f28590S = z17;
        r0.f28591T = str12;
    }

    public dp(dl dlVar, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str6, boolean z7, boolean z8, hq hqVar, List<String> list4, List<String> list5, boolean z9, dr drVar, boolean z10, String str7, List<String> list6, boolean z11, String str8, ia iaVar, String str9, boolean z12, boolean z13, boolean z14, int i2, boolean z15, List<String> list7, boolean z16, String str10) {
        this(19, str, str2, list, -2, list2, j, z, -1, list3, j3, i, str3, j4, str4, false, null, str5, z2, z3, z4, z5, false, null, null, str6, z7, z8, hqVar, list4, list5, z9, drVar, z10, str7, list6, z11, str8, iaVar, str9, z12, z13, null, z14, i2, z15, list7, z16, str10);
        this.f28592U = dlVar;
    }

    public dp(dl dlVar, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str7, boolean z8, boolean z9, hq hqVar, List<String> list4, List<String> list5, boolean z10, dr drVar, boolean z11, String str8, List<String> list6, boolean z12, String str9, ia iaVar, String str10, boolean z13, boolean z14, boolean z15, int i2, boolean z16, List<String> list7, boolean z17, String str11) {
        this(19, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, null, null, str7, z8, z9, hqVar, list4, list5, z10, drVar, z11, str8, list6, z12, str9, iaVar, str10, z13, z14, null, z15, 0, z16, list7, z17, str11);
        this.f28592U = dlVar;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (!(this.f28592U == null || this.f28592U.f28545a < 9 || TextUtils.isEmpty(this.f28597b))) {
            this.f28594W = new eb(new eq(this.f28597b));
            this.f28597b = null;
        }
        int a = C2835c.a(parcel);
        C2835c.a(parcel, 1, this.f28593V);
        C2835c.a(parcel, 2, this.f28596a, false);
        C2835c.a(parcel, 3, this.f28597b, false);
        C2835c.b(parcel, 4, this.f28598c, false);
        C2835c.a(parcel, 5, this.f28599d);
        C2835c.b(parcel, 6, this.f28600e, false);
        C2835c.a(parcel, 7, this.f28601f);
        C2835c.a(parcel, 8, this.f28602g);
        C2835c.a(parcel, 9, this.f28603h);
        C2835c.b(parcel, 10, this.f28604i, false);
        C2835c.a(parcel, 11, this.f28605j);
        C2835c.a(parcel, 12, this.f28606k);
        C2835c.a(parcel, 13, this.f28607l, false);
        C2835c.a(parcel, 14, this.f28608m);
        C2835c.a(parcel, 15, this.f28609n, false);
        C2835c.a(parcel, 18, this.f28610o);
        C2835c.a(parcel, 19, this.f28611p, false);
        C2835c.a(parcel, 21, this.f28612q, false);
        C2835c.a(parcel, 22, this.f28613r);
        C2835c.a(parcel, 23, this.f28614s);
        C2835c.a(parcel, 24, this.f28615t);
        C2835c.a(parcel, 25, this.f28616u);
        C2835c.a(parcel, 26, this.f28617v);
        C2835c.a(parcel, 28, this.f28594W, i, false);
        C2835c.a(parcel, 29, this.f28618w, false);
        C2835c.a(parcel, 30, this.f28619x, false);
        C2835c.a(parcel, 31, this.f28620y);
        C2835c.a(parcel, 32, this.f28621z);
        C2835c.a(parcel, 33, this.f28572A, i, false);
        C2835c.b(parcel, 34, this.f28573B, false);
        C2835c.b(parcel, 35, this.f28574C, false);
        C2835c.a(parcel, 36, this.f28575D);
        C2835c.a(parcel, 37, this.f28576E, i, false);
        C2835c.a(parcel, 38, this.f28577F);
        C2835c.a(parcel, 39, this.f28578G, false);
        C2835c.b(parcel, 40, this.f28579H, false);
        C2835c.a(parcel, 42, this.f28580I);
        C2835c.a(parcel, 43, this.f28581J, false);
        C2835c.a(parcel, 44, this.f28582K, i, false);
        C2835c.a(parcel, 45, this.f28583L, false);
        C2835c.a(parcel, 46, this.f28584M);
        C2835c.a(parcel, 47, this.f28585N);
        C2835c.a(parcel, 48, this.f28595X, false);
        C2835c.a(parcel, 49, this.f28586O);
        C2835c.a(parcel, 50, this.f28587P);
        C2835c.a(parcel, 51, this.f28588Q);
        C2835c.b(parcel, 52, this.f28589R, false);
        C2835c.a(parcel, 53, this.f28590S);
        C2835c.a(parcel, 54, this.f28591T, false);
        C2835c.a(parcel, a);
    }
}
