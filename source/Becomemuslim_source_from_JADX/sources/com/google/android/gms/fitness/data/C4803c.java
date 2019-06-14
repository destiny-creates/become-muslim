package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.fitness.data.c */
public final class C4803c extends C4363a {
    /* renamed from: A */
    public static final C4803c f13477A = C4803c.m17018b("volume");
    /* renamed from: B */
    public static final C4803c f13478B = C4803c.m17020d("meal_type");
    /* renamed from: C */
    public static final C4803c f13479C = C4803c.m17021e("food_item");
    public static final Creator<C4803c> CREATOR = new C3008x();
    /* renamed from: D */
    public static final C4803c f13480D = C4803c.m17022f("nutrients");
    /* renamed from: E */
    public static final C4803c f13481E = C4803c.m17018b("elevation.change");
    /* renamed from: F */
    public static final C4803c f13482F = C4803c.m17022f("elevation.gain");
    /* renamed from: G */
    public static final C4803c f13483G = C4803c.m17022f("elevation.loss");
    /* renamed from: H */
    public static final C4803c f13484H = C4803c.m17018b("floors");
    /* renamed from: I */
    public static final C4803c f13485I = C4803c.m17022f("floor.gain");
    /* renamed from: J */
    public static final C4803c f13486J = C4803c.m17022f("floor.loss");
    /* renamed from: K */
    public static final C4803c f13487K = C4803c.m17021e("exercise");
    /* renamed from: L */
    public static final C4803c f13488L = C4803c.m17020d("repetitions");
    /* renamed from: M */
    public static final C4803c f13489M = C4803c.m17018b("resistance");
    /* renamed from: N */
    public static final C4803c f13490N = C4803c.m17020d("resistance_type");
    /* renamed from: O */
    public static final C4803c f13491O = C4803c.m17020d("num_segments");
    /* renamed from: P */
    public static final C4803c f13492P = C4803c.m17018b("average");
    /* renamed from: Q */
    public static final C4803c f13493Q = C4803c.m17018b("max");
    /* renamed from: R */
    public static final C4803c f13494R = C4803c.m17018b("min");
    /* renamed from: S */
    public static final C4803c f13495S = C4803c.m17018b("low_latitude");
    /* renamed from: T */
    public static final C4803c f13496T = C4803c.m17018b("low_longitude");
    /* renamed from: U */
    public static final C4803c f13497U = C4803c.m17018b("high_latitude");
    /* renamed from: V */
    public static final C4803c f13498V = C4803c.m17018b("high_longitude");
    /* renamed from: W */
    public static final C4803c f13499W = C4803c.m17020d("occurrences");
    /* renamed from: X */
    public static final C4803c f13500X = C4803c.m17020d("sensor_type");
    /* renamed from: Y */
    public static final C4803c f13501Y = C4803c.m17020d("sensor_types");
    /* renamed from: Z */
    public static final C4803c f13502Z = new C4803c("timestamps", 5);
    /* renamed from: a */
    public static final C4803c f13503a = C4803c.m17020d("activity");
    public static final C4803c aa = C4803c.m17020d("sample_period");
    public static final C4803c ab = C4803c.m17020d("num_samples");
    public static final C4803c ac = C4803c.m17020d("num_dimensions");
    public static final C4803c ad = new C4803c("sensor_values", 6);
    public static final C4803c ae = C4803c.m17018b("intensity");
    public static final C4803c af = C4803c.m17018b("probability");
    private static final C4803c ag = C4803c.m17022f("activity_duration");
    /* renamed from: b */
    public static final C4803c f13504b = C4803c.m17018b("confidence");
    /* renamed from: c */
    public static final C4803c f13505c = C4803c.m17022f("activity_confidence");
    /* renamed from: d */
    public static final C4803c f13506d = C4803c.m17020d("steps");
    /* renamed from: e */
    public static final C4803c f13507e = C4803c.m17018b("step_length");
    /* renamed from: f */
    public static final C4803c f13508f = C4803c.m17020d("duration");
    /* renamed from: g */
    public static final C4803c f13509g = C4803c.m17017a("duration");
    /* renamed from: h */
    public static final C4803c f13510h = C4803c.m17022f("activity_duration.ascending");
    /* renamed from: i */
    public static final C4803c f13511i = C4803c.m17022f("activity_duration.descending");
    /* renamed from: j */
    public static final C4803c f13512j = C4803c.m17018b("bpm");
    /* renamed from: k */
    public static final C4803c f13513k = C4803c.m17018b("latitude");
    /* renamed from: l */
    public static final C4803c f13514l = C4803c.m17018b("longitude");
    /* renamed from: m */
    public static final C4803c f13515m = C4803c.m17018b("accuracy");
    /* renamed from: n */
    public static final C4803c f13516n = new C4803c("altitude", 2, Boolean.valueOf(true));
    /* renamed from: o */
    public static final C4803c f13517o = C4803c.m17018b("distance");
    /* renamed from: p */
    public static final C4803c f13518p = C4803c.m17018b("height");
    /* renamed from: q */
    public static final C4803c f13519q = C4803c.m17018b("weight");
    /* renamed from: r */
    public static final C4803c f13520r = C4803c.m17018b("circumference");
    /* renamed from: s */
    public static final C4803c f13521s = C4803c.m17018b("percentage");
    /* renamed from: t */
    public static final C4803c f13522t = C4803c.m17018b("speed");
    /* renamed from: u */
    public static final C4803c f13523u = C4803c.m17018b("rpm");
    /* renamed from: v */
    public static final C4803c f13524v = C4803c.m17023g("google.android.fitness.GoalV2");
    /* renamed from: w */
    public static final C4803c f13525w = C4803c.m17023g("google.android.fitness.StrideModel");
    /* renamed from: x */
    public static final C4803c f13526x = C4803c.m17020d("revolutions");
    /* renamed from: y */
    public static final C4803c f13527y = C4803c.m17018b("calories");
    /* renamed from: z */
    public static final C4803c f13528z = C4803c.m17018b("watts");
    private final String ah;
    private final int ai;
    private final Boolean aj;

    /* renamed from: com.google.android.gms.fitness.data.c$a */
    public static class C2990a {
        /* renamed from: a */
        public static final C4803c f7673a = C4803c.m17018b("x");
        /* renamed from: b */
        public static final C4803c f7674b = C4803c.m17018b("y");
        /* renamed from: c */
        public static final C4803c f7675c = C4803c.m17018b("z");
        /* renamed from: d */
        public static final C4803c f7676d = C4803c.m17019c("debug_session");
        /* renamed from: e */
        public static final C4803c f7677e = C4803c.m17019c("google.android.fitness.SessionV2");
    }

    private C4803c(String str, int i) {
        this(str, i, null);
    }

    C4803c(String str, int i, Boolean bool) {
        this.ah = (String) C2872v.m8380a((Object) str);
        this.ai = i;
        this.aj = bool;
    }

    /* renamed from: a */
    static C4803c m17017a(String str) {
        return new C4803c(str, 1, Boolean.valueOf(true));
    }

    /* renamed from: b */
    static C4803c m17018b(String str) {
        return new C4803c(str, 2);
    }

    /* renamed from: c */
    static C4803c m17019c(String str) {
        return new C4803c(str, 7, Boolean.valueOf(true));
    }

    /* renamed from: d */
    private static C4803c m17020d(String str) {
        return new C4803c(str, 1);
    }

    /* renamed from: e */
    private static C4803c m17021e(String str) {
        return new C4803c(str, 3);
    }

    /* renamed from: f */
    private static C4803c m17022f(String str) {
        return new C4803c(str, 4);
    }

    /* renamed from: g */
    private static C4803c m17023g(String str) {
        return new C4803c(str, 7);
    }

    /* renamed from: a */
    public final String m17024a() {
        return this.ah;
    }

    /* renamed from: b */
    public final int m17025b() {
        return this.ai;
    }

    /* renamed from: c */
    public final Boolean m17026c() {
        return this.aj;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4803c)) {
            return false;
        }
        C4803c c4803c = (C4803c) obj;
        return this.ah.equals(c4803c.ah) && this.ai == c4803c.ai;
    }

    public final int hashCode() {
        return this.ah.hashCode();
    }

    public final String toString() {
        String str = "%s(%s)";
        Object[] objArr = new Object[2];
        objArr[0] = this.ah;
        objArr[1] = this.ai == 1 ? "i" : "f";
        return String.format(str, objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8193a(parcel, 1, m17024a(), false);
        C2835c.m8184a(parcel, 2, m17025b());
        C2835c.m8189a(parcel, 3, m17026c(), false);
        C2835c.m8180a(parcel, i);
    }
}
