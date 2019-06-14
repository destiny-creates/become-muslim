package com.stripe.android;

import com.facebook.share.internal.ShareConstants;

/* compiled from: RequestOptions */
/* renamed from: com.stripe.android.n */
public class C5759n {
    /* renamed from: a */
    private final String f19122a;
    /* renamed from: b */
    private final String f19123b;
    /* renamed from: c */
    private final String f19124c;
    /* renamed from: d */
    private final String f19125d;
    /* renamed from: e */
    private final String f19126e;
    /* renamed from: f */
    private final String f19127f;

    /* compiled from: RequestOptions */
    /* renamed from: com.stripe.android.n$a */
    public static final class C5758a {
        /* renamed from: a */
        private String f19116a;
        /* renamed from: b */
        private String f19117b;
        /* renamed from: c */
        private String f19118c;
        /* renamed from: d */
        private String f19119d;
        /* renamed from: e */
        private String f19120e;
        /* renamed from: f */
        private String f19121f;

        C5758a(String str, String str2) {
            this.f19119d = str;
            this.f19120e = str2;
        }

        /* renamed from: a */
        C5758a m24321a(String str) {
            this.f19117b = str;
            return this;
        }

        /* renamed from: b */
        C5758a m24323b(String str) {
            if (C5775u.m24419b(str)) {
                str = null;
            }
            this.f19116a = str;
            return this;
        }

        /* renamed from: c */
        C5758a m24324c(String str) {
            this.f19121f = str;
            return this;
        }

        /* renamed from: a */
        public C5759n m24322a() {
            return new C5759n(this.f19116a, this.f19117b, this.f19118c, this.f19119d, this.f19120e, this.f19121f);
        }
    }

    private C5759n(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f19122a = str;
        this.f19123b = str2;
        this.f19124c = str3;
        this.f19125d = str4;
        this.f19126e = str5;
        this.f19127f = str6;
    }

    /* renamed from: a */
    String m24328a() {
        return this.f19122a;
    }

    /* renamed from: b */
    String m24329b() {
        return this.f19123b;
    }

    /* renamed from: c */
    String m24330c() {
        return this.f19124c;
    }

    /* renamed from: d */
    String m24331d() {
        return this.f19125d;
    }

    /* renamed from: e */
    String m24332e() {
        return this.f19126e;
    }

    /* renamed from: f */
    String m24333f() {
        return this.f19127f;
    }

    /* renamed from: a */
    public static C5758a m24325a(String str) {
        return C5759n.m24326a(str, ShareConstants.FEED_SOURCE_PARAM);
    }

    /* renamed from: a */
    public static C5758a m24327a(String str, String str2, String str3) {
        return new C5758a(str, str3).m24324c(str2);
    }

    /* renamed from: a */
    public static C5758a m24326a(String str, String str2) {
        return new C5758a(str, str2);
    }
}
