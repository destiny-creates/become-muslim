package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.fitness.data.a */
public class C4801a extends C4363a {
    public static final Creator<C4801a> CREATOR = new C3005u();
    /* renamed from: a */
    private static final int[] f13463a = new int[0];
    /* renamed from: b */
    private final DataType f13464b;
    /* renamed from: c */
    private final String f13465c;
    /* renamed from: d */
    private final int f13466d;
    /* renamed from: e */
    private final C4802b f13467e;
    /* renamed from: f */
    private final C4807o f13468f;
    /* renamed from: g */
    private final String f13469g;
    /* renamed from: h */
    private final int[] f13470h;
    /* renamed from: i */
    private final String f13471i;

    /* renamed from: com.google.android.gms.fitness.data.a$a */
    public static final class C2989a {
        /* renamed from: a */
        private DataType f7666a;
        /* renamed from: b */
        private int f7667b = -1;
        /* renamed from: c */
        private String f7668c;
        /* renamed from: d */
        private C4802b f7669d;
        /* renamed from: e */
        private C4807o f7670e;
        /* renamed from: f */
        private String f7671f = "";
        /* renamed from: g */
        private int[] f7672g;

        /* renamed from: a */
        public final C2989a m8849a(int i) {
            this.f7667b = i;
            return this;
        }

        /* renamed from: a */
        public final C2989a m8850a(DataType dataType) {
            this.f7666a = dataType;
            return this;
        }

        /* renamed from: a */
        public final C2989a m8851a(String str) {
            this.f7668c = str;
            return this;
        }

        /* renamed from: a */
        public final C4801a m8852a() {
            boolean z = false;
            C2872v.m8387a(this.f7666a != null, (Object) "Must set data type");
            if (this.f7667b >= 0) {
                z = true;
            }
            C2872v.m8387a(z, (Object) "Must set data source type");
            return new C4801a();
        }
    }

    public C4801a(DataType dataType, String str, int i, C4802b c4802b, C4807o c4807o, String str2, int[] iArr) {
        this.f13464b = dataType;
        this.f13466d = i;
        this.f13465c = str;
        this.f13467e = c4802b;
        this.f13468f = c4807o;
        this.f13469g = str2;
        this.f13471i = m17003h();
        if (iArr == null) {
            iArr = f13463a;
        }
        this.f13470h = iArr;
    }

    private C4801a(C2989a c2989a) {
        this.f13464b = c2989a.f7666a;
        this.f13466d = c2989a.f7667b;
        this.f13465c = c2989a.f7668c;
        this.f13467e = c2989a.f7669d;
        this.f13468f = c2989a.f7670e;
        this.f13469g = c2989a.f7671f;
        this.f13471i = m17003h();
        this.f13470h = c2989a.f7672g;
    }

    /* renamed from: a */
    public static String m17002a(int i) {
        switch (i) {
            case 1:
                return "blood_pressure_esh2002";
            case 2:
                return "blood_pressure_esh2010";
            case 3:
                return "blood_pressure_aami";
            case 4:
                return "blood_pressure_bhs_a_a";
            case 5:
                return "blood_pressure_bhs_a_b";
            case 6:
                return "blood_pressure_bhs_b_a";
            case 7:
                return "blood_pressure_bhs_b_b";
            case 8:
                return "blood_glucose_iso151972003";
            case 9:
                return "blood_glucose_iso151972013";
            default:
                return "unknown";
        }
    }

    /* renamed from: h */
    private final String m17003h() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m17004i());
        stringBuilder.append(":");
        stringBuilder.append(this.f13464b.m16991a());
        if (this.f13468f != null) {
            stringBuilder.append(":");
            stringBuilder.append(this.f13468f.m17035a());
        }
        if (this.f13467e != null) {
            stringBuilder.append(":");
            stringBuilder.append(this.f13467e.m17016e());
        }
        if (this.f13469g != null) {
            stringBuilder.append(":");
            stringBuilder.append(this.f13469g);
        }
        return stringBuilder.toString();
    }

    /* renamed from: i */
    private final String m17004i() {
        switch (this.f13466d) {
            case 0:
                return "raw";
            case 1:
                return "derived";
            case 2:
                return "cleaned";
            case 3:
                return "converted";
            default:
                return "derived";
        }
    }

    /* renamed from: a */
    public DataType m17005a() {
        return this.f13464b;
    }

    /* renamed from: b */
    public int m17006b() {
        return this.f13466d;
    }

    /* renamed from: c */
    public String m17007c() {
        return this.f13465c;
    }

    /* renamed from: d */
    public C4802b m17008d() {
        return this.f13467e;
    }

    /* renamed from: e */
    public String m17009e() {
        return this.f13469g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4801a)) {
            return false;
        }
        return this.f13471i.equals(((C4801a) obj).f13471i);
    }

    /* renamed from: f */
    public int[] m17010f() {
        return this.f13470h;
    }

    /* renamed from: g */
    public final String m17011g() {
        String str;
        String str2;
        String valueOf;
        String c;
        StringBuilder stringBuilder;
        switch (this.f13466d) {
            case 0:
                str = "r";
                break;
            case 1:
                str = "d";
                break;
            case 2:
                str = "c";
                break;
            case 3:
                str = "v";
                break;
            default:
                str = "?";
                break;
        }
        String c2 = this.f13464b.m16993c();
        if (this.f13468f == null) {
            str2 = "";
        } else if (this.f13468f.equals(C4807o.f13549a)) {
            str2 = ":gms";
        } else {
            str2 = ":";
            valueOf = String.valueOf(this.f13468f.m17035a());
            str2 = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
        }
        if (this.f13467e != null) {
            valueOf = this.f13467e.m17013b();
            c = this.f13467e.m17014c();
            stringBuilder = new StringBuilder((String.valueOf(valueOf).length() + 2) + String.valueOf(c).length());
            stringBuilder.append(":");
            stringBuilder.append(valueOf);
            stringBuilder.append(":");
            stringBuilder.append(c);
            valueOf = stringBuilder.toString();
        } else {
            valueOf = "";
        }
        if (this.f13469g != null) {
            c = ":";
            String valueOf2 = String.valueOf(this.f13469g);
            c = valueOf2.length() != 0 ? c.concat(valueOf2) : new String(c);
        } else {
            c = "";
        }
        stringBuilder = new StringBuilder(((((String.valueOf(str).length() + 1) + String.valueOf(c2).length()) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()) + String.valueOf(c).length());
        stringBuilder.append(str);
        stringBuilder.append(":");
        stringBuilder.append(c2);
        stringBuilder.append(str2);
        stringBuilder.append(valueOf);
        stringBuilder.append(c);
        return stringBuilder.toString();
    }

    public int hashCode() {
        return this.f13471i.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DataSource{");
        stringBuilder.append(m17004i());
        if (this.f13465c != null) {
            stringBuilder.append(":");
            stringBuilder.append(this.f13465c);
        }
        if (this.f13468f != null) {
            stringBuilder.append(":");
            stringBuilder.append(this.f13468f);
        }
        if (this.f13467e != null) {
            stringBuilder.append(":");
            stringBuilder.append(this.f13467e);
        }
        if (this.f13469g != null) {
            stringBuilder.append(":");
            stringBuilder.append(this.f13469g);
        }
        stringBuilder.append(":");
        stringBuilder.append(this.f13464b);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8188a(parcel, 1, m17005a(), i, false);
        C2835c.m8193a(parcel, 2, m17007c(), false);
        C2835c.m8184a(parcel, 3, m17006b());
        C2835c.m8188a(parcel, 4, m17008d(), i, false);
        C2835c.m8188a(parcel, 5, this.f13468f, i, false);
        C2835c.m8193a(parcel, 6, m17009e(), false);
        C2835c.m8199a(parcel, 8, m17010f(), false);
        C2835c.m8180a(parcel, a);
    }
}
