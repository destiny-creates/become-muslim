package com.google.android.gms.p190g.p191a;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;

/* renamed from: com.google.android.gms.g.a.a */
public class C4820a extends C4363a {
    public static final Creator<C4820a> CREATOR = new C3027d();
    /* renamed from: a */
    public int f13614a;
    /* renamed from: b */
    public String f13615b;
    /* renamed from: c */
    public String f13616c;
    /* renamed from: d */
    public int f13617d;
    /* renamed from: e */
    public Point[] f13618e;
    /* renamed from: f */
    public C4813f f13619f;
    /* renamed from: g */
    public C4816i f13620g;
    /* renamed from: h */
    public C4817j f13621h;
    /* renamed from: i */
    public C4819l f13622i;
    /* renamed from: j */
    public C4818k f13623j;
    /* renamed from: k */
    public C4814g f13624k;
    /* renamed from: l */
    public C4810c f13625l;
    /* renamed from: m */
    public C4811d f13626m;
    /* renamed from: n */
    public C4812e f13627n;

    /* renamed from: com.google.android.gms.g.a.a$a */
    public static class C4808a extends C4363a {
        public static final Creator<C4808a> CREATOR = new C3026c();
        /* renamed from: a */
        public int f13554a;
        /* renamed from: b */
        public String[] f13555b;

        public C4808a(int i, String[] strArr) {
            this.f13554a = i;
            this.f13555b = strArr;
        }

        public void writeToParcel(Parcel parcel, int i) {
            i = C2835c.m8179a(parcel);
            C2835c.m8184a(parcel, 2, this.f13554a);
            C2835c.m8201a(parcel, 3, this.f13555b, false);
            C2835c.m8180a(parcel, i);
        }
    }

    /* renamed from: com.google.android.gms.g.a.a$b */
    public static class C4809b extends C4363a {
        public static final Creator<C4809b> CREATOR = new C3029f();
        /* renamed from: a */
        public int f13556a;
        /* renamed from: b */
        public int f13557b;
        /* renamed from: c */
        public int f13558c;
        /* renamed from: d */
        public int f13559d;
        /* renamed from: e */
        public int f13560e;
        /* renamed from: f */
        public int f13561f;
        /* renamed from: g */
        public boolean f13562g;
        /* renamed from: h */
        public String f13563h;

        public C4809b(int i, int i2, int i3, int i4, int i5, int i6, boolean z, String str) {
            this.f13556a = i;
            this.f13557b = i2;
            this.f13558c = i3;
            this.f13559d = i4;
            this.f13560e = i5;
            this.f13561f = i6;
            this.f13562g = z;
            this.f13563h = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            i = C2835c.m8179a(parcel);
            C2835c.m8184a(parcel, 2, this.f13556a);
            C2835c.m8184a(parcel, 3, this.f13557b);
            C2835c.m8184a(parcel, 4, this.f13558c);
            C2835c.m8184a(parcel, 5, this.f13559d);
            C2835c.m8184a(parcel, 6, this.f13560e);
            C2835c.m8184a(parcel, 7, this.f13561f);
            C2835c.m8196a(parcel, 8, this.f13562g);
            C2835c.m8193a(parcel, 9, this.f13563h, false);
            C2835c.m8180a(parcel, i);
        }
    }

    /* renamed from: com.google.android.gms.g.a.a$c */
    public static class C4810c extends C4363a {
        public static final Creator<C4810c> CREATOR = new C3030g();
        /* renamed from: a */
        public String f13564a;
        /* renamed from: b */
        public String f13565b;
        /* renamed from: c */
        public String f13566c;
        /* renamed from: d */
        public String f13567d;
        /* renamed from: e */
        public String f13568e;
        /* renamed from: f */
        public C4809b f13569f;
        /* renamed from: g */
        public C4809b f13570g;

        public C4810c(String str, String str2, String str3, String str4, String str5, C4809b c4809b, C4809b c4809b2) {
            this.f13564a = str;
            this.f13565b = str2;
            this.f13566c = str3;
            this.f13567d = str4;
            this.f13568e = str5;
            this.f13569f = c4809b;
            this.f13570g = c4809b2;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int a = C2835c.m8179a(parcel);
            C2835c.m8193a(parcel, 2, this.f13564a, false);
            C2835c.m8193a(parcel, 3, this.f13565b, false);
            C2835c.m8193a(parcel, 4, this.f13566c, false);
            C2835c.m8193a(parcel, 5, this.f13567d, false);
            C2835c.m8193a(parcel, 6, this.f13568e, false);
            C2835c.m8188a(parcel, 7, this.f13569f, i, false);
            C2835c.m8188a(parcel, 8, this.f13570g, i, false);
            C2835c.m8180a(parcel, a);
        }
    }

    /* renamed from: com.google.android.gms.g.a.a$d */
    public static class C4811d extends C4363a {
        public static final Creator<C4811d> CREATOR = new C3031h();
        /* renamed from: a */
        public C4815h f13571a;
        /* renamed from: b */
        public String f13572b;
        /* renamed from: c */
        public String f13573c;
        /* renamed from: d */
        public C4816i[] f13574d;
        /* renamed from: e */
        public C4813f[] f13575e;
        /* renamed from: f */
        public String[] f13576f;
        /* renamed from: g */
        public C4808a[] f13577g;

        public C4811d(C4815h c4815h, String str, String str2, C4816i[] c4816iArr, C4813f[] c4813fArr, String[] strArr, C4808a[] c4808aArr) {
            this.f13571a = c4815h;
            this.f13572b = str;
            this.f13573c = str2;
            this.f13574d = c4816iArr;
            this.f13575e = c4813fArr;
            this.f13576f = strArr;
            this.f13577g = c4808aArr;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int a = C2835c.m8179a(parcel);
            C2835c.m8188a(parcel, 2, this.f13571a, i, false);
            C2835c.m8193a(parcel, 3, this.f13572b, false);
            C2835c.m8193a(parcel, 4, this.f13573c, false);
            C2835c.m8200a(parcel, 5, this.f13574d, i, false);
            C2835c.m8200a(parcel, 6, this.f13575e, i, false);
            C2835c.m8201a(parcel, 7, this.f13576f, false);
            C2835c.m8200a(parcel, 8, this.f13577g, i, false);
            C2835c.m8180a(parcel, a);
        }
    }

    /* renamed from: com.google.android.gms.g.a.a$e */
    public static class C4812e extends C4363a {
        public static final Creator<C4812e> CREATOR = new C3032i();
        /* renamed from: a */
        public String f13578a;
        /* renamed from: b */
        public String f13579b;
        /* renamed from: c */
        public String f13580c;
        /* renamed from: d */
        public String f13581d;
        /* renamed from: e */
        public String f13582e;
        /* renamed from: f */
        public String f13583f;
        /* renamed from: g */
        public String f13584g;
        /* renamed from: h */
        public String f13585h;
        /* renamed from: i */
        public String f13586i;
        /* renamed from: j */
        public String f13587j;
        /* renamed from: k */
        public String f13588k;
        /* renamed from: l */
        public String f13589l;
        /* renamed from: m */
        public String f13590m;
        /* renamed from: n */
        public String f13591n;

        public C4812e(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
            this.f13578a = str;
            this.f13579b = str2;
            this.f13580c = str3;
            this.f13581d = str4;
            this.f13582e = str5;
            this.f13583f = str6;
            this.f13584g = str7;
            this.f13585h = str8;
            this.f13586i = str9;
            this.f13587j = str10;
            this.f13588k = str11;
            this.f13589l = str12;
            this.f13590m = str13;
            this.f13591n = str14;
        }

        public void writeToParcel(Parcel parcel, int i) {
            i = C2835c.m8179a(parcel);
            C2835c.m8193a(parcel, 2, this.f13578a, false);
            C2835c.m8193a(parcel, 3, this.f13579b, false);
            C2835c.m8193a(parcel, 4, this.f13580c, false);
            C2835c.m8193a(parcel, 5, this.f13581d, false);
            C2835c.m8193a(parcel, 6, this.f13582e, false);
            C2835c.m8193a(parcel, 7, this.f13583f, false);
            C2835c.m8193a(parcel, 8, this.f13584g, false);
            C2835c.m8193a(parcel, 9, this.f13585h, false);
            C2835c.m8193a(parcel, 10, this.f13586i, false);
            C2835c.m8193a(parcel, 11, this.f13587j, false);
            C2835c.m8193a(parcel, 12, this.f13588k, false);
            C2835c.m8193a(parcel, 13, this.f13589l, false);
            C2835c.m8193a(parcel, 14, this.f13590m, false);
            C2835c.m8193a(parcel, 15, this.f13591n, false);
            C2835c.m8180a(parcel, i);
        }
    }

    /* renamed from: com.google.android.gms.g.a.a$f */
    public static class C4813f extends C4363a {
        public static final Creator<C4813f> CREATOR = new C3033j();
        /* renamed from: a */
        public int f13592a;
        /* renamed from: b */
        public String f13593b;
        /* renamed from: c */
        public String f13594c;
        /* renamed from: d */
        public String f13595d;

        public C4813f(int i, String str, String str2, String str3) {
            this.f13592a = i;
            this.f13593b = str;
            this.f13594c = str2;
            this.f13595d = str3;
        }

        public void writeToParcel(Parcel parcel, int i) {
            i = C2835c.m8179a(parcel);
            C2835c.m8184a(parcel, 2, this.f13592a);
            C2835c.m8193a(parcel, 3, this.f13593b, false);
            C2835c.m8193a(parcel, 4, this.f13594c, false);
            C2835c.m8193a(parcel, 5, this.f13595d, false);
            C2835c.m8180a(parcel, i);
        }
    }

    /* renamed from: com.google.android.gms.g.a.a$g */
    public static class C4814g extends C4363a {
        public static final Creator<C4814g> CREATOR = new C3034k();
        /* renamed from: a */
        public double f13596a;
        /* renamed from: b */
        public double f13597b;

        public C4814g(double d, double d2) {
            this.f13596a = d;
            this.f13597b = d2;
        }

        public void writeToParcel(Parcel parcel, int i) {
            i = C2835c.m8179a(parcel);
            C2835c.m8182a(parcel, 2, this.f13596a);
            C2835c.m8182a(parcel, 3, this.f13597b);
            C2835c.m8180a(parcel, i);
        }
    }

    /* renamed from: com.google.android.gms.g.a.a$h */
    public static class C4815h extends C4363a {
        public static final Creator<C4815h> CREATOR = new C3035l();
        /* renamed from: a */
        public String f13598a;
        /* renamed from: b */
        public String f13599b;
        /* renamed from: c */
        public String f13600c;
        /* renamed from: d */
        public String f13601d;
        /* renamed from: e */
        public String f13602e;
        /* renamed from: f */
        public String f13603f;
        /* renamed from: g */
        public String f13604g;

        public C4815h(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.f13598a = str;
            this.f13599b = str2;
            this.f13600c = str3;
            this.f13601d = str4;
            this.f13602e = str5;
            this.f13603f = str6;
            this.f13604g = str7;
        }

        public void writeToParcel(Parcel parcel, int i) {
            i = C2835c.m8179a(parcel);
            C2835c.m8193a(parcel, 2, this.f13598a, false);
            C2835c.m8193a(parcel, 3, this.f13599b, false);
            C2835c.m8193a(parcel, 4, this.f13600c, false);
            C2835c.m8193a(parcel, 5, this.f13601d, false);
            C2835c.m8193a(parcel, 6, this.f13602e, false);
            C2835c.m8193a(parcel, 7, this.f13603f, false);
            C2835c.m8193a(parcel, 8, this.f13604g, false);
            C2835c.m8180a(parcel, i);
        }
    }

    /* renamed from: com.google.android.gms.g.a.a$i */
    public static class C4816i extends C4363a {
        public static final Creator<C4816i> CREATOR = new C3036m();
        /* renamed from: a */
        public int f13605a;
        /* renamed from: b */
        public String f13606b;

        public C4816i(int i, String str) {
            this.f13605a = i;
            this.f13606b = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            i = C2835c.m8179a(parcel);
            C2835c.m8184a(parcel, 2, this.f13605a);
            C2835c.m8193a(parcel, 3, this.f13606b, false);
            C2835c.m8180a(parcel, i);
        }
    }

    /* renamed from: com.google.android.gms.g.a.a$j */
    public static class C4817j extends C4363a {
        public static final Creator<C4817j> CREATOR = new C3037n();
        /* renamed from: a */
        public String f13607a;
        /* renamed from: b */
        public String f13608b;

        public C4817j(String str, String str2) {
            this.f13607a = str;
            this.f13608b = str2;
        }

        public void writeToParcel(Parcel parcel, int i) {
            i = C2835c.m8179a(parcel);
            C2835c.m8193a(parcel, 2, this.f13607a, false);
            C2835c.m8193a(parcel, 3, this.f13608b, false);
            C2835c.m8180a(parcel, i);
        }
    }

    /* renamed from: com.google.android.gms.g.a.a$k */
    public static class C4818k extends C4363a {
        public static final Creator<C4818k> CREATOR = new C3038o();
        /* renamed from: a */
        public String f13609a;
        /* renamed from: b */
        public String f13610b;

        public C4818k(String str, String str2) {
            this.f13609a = str;
            this.f13610b = str2;
        }

        public void writeToParcel(Parcel parcel, int i) {
            i = C2835c.m8179a(parcel);
            C2835c.m8193a(parcel, 2, this.f13609a, false);
            C2835c.m8193a(parcel, 3, this.f13610b, false);
            C2835c.m8180a(parcel, i);
        }
    }

    /* renamed from: com.google.android.gms.g.a.a$l */
    public static class C4819l extends C4363a {
        public static final Creator<C4819l> CREATOR = new C3039p();
        /* renamed from: a */
        public String f13611a;
        /* renamed from: b */
        public String f13612b;
        /* renamed from: c */
        public int f13613c;

        public C4819l(String str, String str2, int i) {
            this.f13611a = str;
            this.f13612b = str2;
            this.f13613c = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            i = C2835c.m8179a(parcel);
            C2835c.m8193a(parcel, 2, this.f13611a, false);
            C2835c.m8193a(parcel, 3, this.f13612b, false);
            C2835c.m8184a(parcel, 4, this.f13613c);
            C2835c.m8180a(parcel, i);
        }
    }

    public C4820a(int i, String str, String str2, int i2, Point[] pointArr, C4813f c4813f, C4816i c4816i, C4817j c4817j, C4819l c4819l, C4818k c4818k, C4814g c4814g, C4810c c4810c, C4811d c4811d, C4812e c4812e) {
        this.f13614a = i;
        this.f13615b = str;
        this.f13616c = str2;
        this.f13617d = i2;
        this.f13618e = pointArr;
        this.f13619f = c4813f;
        this.f13620g = c4816i;
        this.f13621h = c4817j;
        this.f13622i = c4819l;
        this.f13623j = c4818k;
        this.f13624k = c4814g;
        this.f13625l = c4810c;
        this.f13626m = c4811d;
        this.f13627n = c4812e;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = C2835c.m8179a(parcel);
        C2835c.m8184a(parcel, 2, this.f13614a);
        C2835c.m8193a(parcel, 3, this.f13615b, false);
        C2835c.m8193a(parcel, 4, this.f13616c, false);
        C2835c.m8184a(parcel, 5, this.f13617d);
        C2835c.m8200a(parcel, 6, this.f13618e, i, false);
        C2835c.m8188a(parcel, 7, this.f13619f, i, false);
        C2835c.m8188a(parcel, 8, this.f13620g, i, false);
        C2835c.m8188a(parcel, 9, this.f13621h, i, false);
        C2835c.m8188a(parcel, 10, this.f13622i, i, false);
        C2835c.m8188a(parcel, 11, this.f13623j, i, false);
        C2835c.m8188a(parcel, 12, this.f13624k, i, false);
        C2835c.m8188a(parcel, 13, this.f13625l, i, false);
        C2835c.m8188a(parcel, 14, this.f13626m, i, false);
        C2835c.m8188a(parcel, 15, this.f13627n, i, false);
        C2835c.m8180a(parcel, a);
    }
}
