package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.C0448b;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import com.google.android.gms.fitness.data.C4803c.C2990a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class DataType extends C4363a implements ReflectedParcelable {
    /* renamed from: A */
    public static final DataType f13392A = new DataType("com.google.height", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", C4803c.f13518p);
    /* renamed from: B */
    public static final DataType f13393B = new DataType("com.google.weight", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", C4803c.f13519q);
    /* renamed from: C */
    public static final DataType f13394C = new DataType("com.google.body.fat.percentage", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", C4803c.f13521s);
    public static final Creator<DataType> CREATOR = new C3006v();
    /* renamed from: D */
    public static final DataType f13395D = new DataType("com.google.body.waist.circumference", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", C4803c.f13520r);
    /* renamed from: E */
    public static final DataType f13396E = new DataType("com.google.body.hip.circumference", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", C4803c.f13520r);
    /* renamed from: F */
    public static final DataType f13397F = new DataType("com.google.nutrition", "https://www.googleapis.com/auth/fitness.nutrition.read", "https://www.googleapis.com/auth/fitness.nutrition.write", C4803c.f13480D, C4803c.f13478B, C4803c.f13479C);
    /* renamed from: G */
    public static final DataType f13398G = new DataType("com.google.hydration", "https://www.googleapis.com/auth/fitness.nutrition.read", "https://www.googleapis.com/auth/fitness.nutrition.write", C4803c.f13477A);
    /* renamed from: H */
    public static final DataType f13399H = new DataType("com.google.activity.exercise", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13487K, C4803c.f13488L, C4803c.f13508f, C4803c.f13490N, C4803c.f13489M);
    /* renamed from: I */
    public static final DataType f13400I;
    /* renamed from: J */
    public static final DataType f13401J;
    /* renamed from: K */
    public static final DataType f13402K = new DataType("com.google.device_on_body", C4803c.af);
    /* renamed from: L */
    public static final DataType f13403L = new DataType("com.google.activity.summary", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13503a, C4803c.f13508f, C4803c.f13491O);
    /* renamed from: M */
    public static final DataType f13404M = new DataType("com.google.floor_change.summary", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13510h, C4803c.f13511i, C4803c.f13482F, C4803c.f13483G, C4803c.f13485I, C4803c.f13486J);
    /* renamed from: N */
    public static final DataType f13405N = new DataType("com.google.calories.bmr.summary", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", C4803c.f13492P, C4803c.f13493Q, C4803c.f13494R);
    /* renamed from: O */
    public static final DataType f13406O = f13418a;
    /* renamed from: P */
    public static final DataType f13407P = f13438u;
    @Deprecated
    /* renamed from: Q */
    public static final DataType f13408Q = f13425h;
    /* renamed from: R */
    public static final DataType f13409R = f13426i;
    /* renamed from: S */
    public static final DataType f13410S;
    /* renamed from: T */
    public static final DataType f13411T;
    @KeepName
    public static final DataType TYPE_DISTANCE_CUMULATIVE = new DataType("com.google.distance.cumulative", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", C4803c.f13517o);
    @KeepName
    public static final DataType TYPE_STEP_COUNT_CUMULATIVE = new DataType("com.google.step_count.cumulative", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13506d);
    /* renamed from: U */
    public static final DataType f13412U = new DataType("com.google.heart_rate.summary", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", C4803c.f13492P, C4803c.f13493Q, C4803c.f13494R);
    /* renamed from: V */
    public static final DataType f13413V = new DataType("com.google.location.bounding_box", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", C4803c.f13495S, C4803c.f13496T, C4803c.f13497U, C4803c.f13498V);
    /* renamed from: W */
    public static final DataType f13414W = new DataType("com.google.power.summary", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13492P, C4803c.f13493Q, C4803c.f13494R);
    /* renamed from: X */
    public static final DataType f13415X = new DataType("com.google.speed.summary", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", C4803c.f13492P, C4803c.f13493Q, C4803c.f13494R);
    /* renamed from: Y */
    public static final DataType f13416Y = new DataType("com.google.body.fat.percentage.summary", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", C4803c.f13492P, C4803c.f13493Q, C4803c.f13494R);
    /* renamed from: Z */
    public static final DataType f13417Z = new DataType("com.google.body.hip.circumference.summary", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", C4803c.f13492P, C4803c.f13493Q, C4803c.f13494R);
    /* renamed from: a */
    public static final DataType f13418a = new DataType("com.google.step_count.delta", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13506d);
    public static final DataType aa = new DataType("com.google.body.waist.circumference.summary", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", C4803c.f13492P, C4803c.f13493Q, C4803c.f13494R);
    public static final DataType ab = new DataType("com.google.weight.summary", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", C4803c.f13492P, C4803c.f13493Q, C4803c.f13494R);
    public static final DataType ac = new DataType("com.google.height.summary", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", C4803c.f13492P, C4803c.f13493Q, C4803c.f13494R);
    public static final DataType ad = new DataType("com.google.nutrition.summary", "https://www.googleapis.com/auth/fitness.nutrition.read", "https://www.googleapis.com/auth/fitness.nutrition.write", C4803c.f13480D, C4803c.f13478B);
    public static final DataType ae = f13398G;
    @Deprecated
    public static final Set<DataType> af;
    /* renamed from: b */
    public static final DataType f13419b = new DataType("com.google.step_length", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13507e);
    /* renamed from: c */
    public static final DataType f13420c = new DataType("com.google.step_count.cadence", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13523u);
    /* renamed from: d */
    public static final DataType f13421d = new DataType("com.google.internal.goal", C4803c.f13524v);
    /* renamed from: e */
    public static final DataType f13422e = new DataType("com.google.stride_model", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13525w);
    /* renamed from: f */
    public static final DataType f13423f = new DataType("com.google.activity.segment", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13503a);
    /* renamed from: g */
    public static final DataType f13424g = new DataType("com.google.floor_change", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13503a, C4803c.f13504b, C4803c.f13481E, C4803c.f13484H);
    @Deprecated
    /* renamed from: h */
    public static final DataType f13425h = new DataType("com.google.calories.consumed", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13527y);
    /* renamed from: i */
    public static final DataType f13426i = new DataType("com.google.calories.expended", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13527y);
    /* renamed from: j */
    public static final DataType f13427j = new DataType("com.google.calories.bmr", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13527y);
    /* renamed from: k */
    public static final DataType f13428k = new DataType("com.google.power.sample", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13528z);
    @Deprecated
    /* renamed from: l */
    public static final DataType f13429l = new DataType("com.google.activity.sample", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13503a, C4803c.f13504b);
    /* renamed from: m */
    public static final DataType f13430m = new DataType("com.google.activity.samples", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13505c);
    /* renamed from: n */
    public static final DataType f13431n = new DataType("com.google.accelerometer", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C2990a.f7673a, C2990a.f7674b, C2990a.f7675c);
    /* renamed from: o */
    public static final DataType f13432o = new DataType("com.google.sensor.events", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13500X, C4803c.f13502Z, C4803c.ad);
    /* renamed from: p */
    public static final DataType f13433p = new DataType("com.google.sensor.const_rate_events", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13501Y, C4803c.aa, C4803c.ab, C4803c.ac, C4803c.ad);
    /* renamed from: q */
    public static final DataType f13434q = new DataType("com.google.heart_rate.bpm", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.read", C4803c.f13512j);
    /* renamed from: r */
    public static final DataType f13435r = new DataType("com.google.location.sample", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", C4803c.f13513k, C4803c.f13514l, C4803c.f13515m, C4803c.f13516n);
    /* renamed from: s */
    public static final DataType f13436s = new DataType("com.google.location.track", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", C4803c.f13513k, C4803c.f13514l, C4803c.f13515m, C4803c.f13516n);
    /* renamed from: t */
    public static final DataType f13437t = new DataType("com.google.moves", C4803c.f13509g);
    /* renamed from: u */
    public static final DataType f13438u = new DataType("com.google.distance.delta", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", C4803c.f13517o);
    /* renamed from: v */
    public static final DataType f13439v = new DataType("com.google.speed", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", C4803c.f13522t);
    /* renamed from: w */
    public static final DataType f13440w = new DataType("com.google.cycling.wheel_revolution.cumulative", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", C4803c.f13526x);
    /* renamed from: x */
    public static final DataType f13441x = new DataType("com.google.cycling.wheel_revolution.rpm", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", C4803c.f13523u);
    /* renamed from: y */
    public static final DataType f13442y = new DataType("com.google.cycling.pedaling.cumulative", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13526x);
    /* renamed from: z */
    public static final DataType f13443z = new DataType("com.google.cycling.pedaling.cadence", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", C4803c.f13523u);
    private final String ag;
    private final List<C4803c> ah;
    private final String ai;
    private final String aj;

    static {
        DataType dataType = new DataType("com.google.active_minutes", C4803c.f13509g);
        f13400I = dataType;
        f13401J = dataType;
        dataType = new DataType("com.google.heart_minutes", C4803c.ae);
        f13410S = dataType;
        f13411T = dataType;
        Set c0448b = new C0448b();
        af = c0448b;
        c0448b.add(f13423f);
        af.add(f13427j);
        af.add(f13394C);
        af.add(f13396E);
        af.add(f13395D);
        af.add(f13425h);
        af.add(f13426i);
        af.add(f13438u);
        af.add(f13424g);
        af.add(f13435r);
        af.add(f13397F);
        af.add(f13398G);
        af.add(f13434q);
        af.add(f13428k);
        af.add(f13439v);
        af.add(f13418a);
        af.add(f13393B);
    }

    public DataType(String str, String str2, String str3, C4803c... c4803cArr) {
        this(str, Arrays.asList(c4803cArr), str2, str3);
    }

    DataType(String str, List<C4803c> list, String str2, String str3) {
        this.ag = str;
        this.ah = Collections.unmodifiableList(list);
        this.ai = str2;
        this.aj = str3;
    }

    private DataType(String str, C4803c... c4803cArr) {
        this(str, Arrays.asList(c4803cArr), null, null);
    }

    /* renamed from: a */
    public static List<DataType> m16989a(DataType dataType) {
        List list = (List) C2994i.f7731a.get(dataType);
        return list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    /* renamed from: a */
    public final int m16990a(C4803c c4803c) {
        int indexOf = this.ah.indexOf(c4803c);
        C2872v.m8392b(indexOf >= 0, "%s not a field of %s", c4803c, this);
        return indexOf;
    }

    /* renamed from: a */
    public final String m16991a() {
        return this.ag;
    }

    /* renamed from: b */
    public final List<C4803c> m16992b() {
        return this.ah;
    }

    /* renamed from: c */
    public final String m16993c() {
        return this.ag.startsWith("com.google.") ? this.ag.substring(11) : this.ag;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataType)) {
            return false;
        }
        DataType dataType = (DataType) obj;
        return this.ag.equals(dataType.ag) && this.ah.equals(dataType.ah);
    }

    public final int hashCode() {
        return this.ag.hashCode();
    }

    public final String toString() {
        return String.format("DataType{%s%s}", new Object[]{this.ag, this.ah});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.m8179a(parcel);
        C2835c.m8193a(parcel, 1, m16991a(), false);
        C2835c.m8207c(parcel, 2, m16992b(), false);
        C2835c.m8193a(parcel, 3, this.ai, false);
        C2835c.m8193a(parcel, 4, this.aj, false);
        C2835c.m8180a(parcel, i);
    }
}
