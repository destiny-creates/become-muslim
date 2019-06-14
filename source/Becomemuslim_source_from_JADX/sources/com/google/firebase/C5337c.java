package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.ac;
import com.google.android.gms.common.util.C2908s;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
/* renamed from: com.google.firebase.c */
public final class C5337c {
    /* renamed from: a */
    private final String f18000a;
    /* renamed from: b */
    private final String f18001b;
    /* renamed from: c */
    private final String f18002c;
    /* renamed from: d */
    private final String f18003d;
    /* renamed from: e */
    private final String f18004e;
    /* renamed from: f */
    private final String f18005f;
    /* renamed from: g */
    private final String f18006g;

    /* compiled from: com.google.firebase:firebase-common@@16.0.2 */
    /* renamed from: com.google.firebase.c$a */
    public static final class C5336a {
        /* renamed from: a */
        private String f17993a;
        /* renamed from: b */
        private String f17994b;
        /* renamed from: c */
        private String f17995c;
        /* renamed from: d */
        private String f17996d;
        /* renamed from: e */
        private String f17997e;
        /* renamed from: f */
        private String f17998f;
        /* renamed from: g */
        private String f17999g;

        /* renamed from: a */
        public final C5336a m22617a(String str) {
            this.f17993a = C2872v.a(str, "ApiKey must be set.");
            return this;
        }

        /* renamed from: b */
        public final C5336a m22619b(String str) {
            this.f17994b = C2872v.a(str, "ApplicationId must be set.");
            return this;
        }

        /* renamed from: c */
        public final C5336a m22620c(String str) {
            this.f17997e = str;
            return this;
        }

        /* renamed from: a */
        public final C5337c m22618a() {
            return new C5337c(this.f17994b, this.f17993a, this.f17995c, this.f17996d, this.f17997e, this.f17998f, this.f17999g);
        }
    }

    private C5337c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        C2872v.a(C2908s.a(str) ^ 1, "ApplicationId must be set.");
        this.f18001b = str;
        this.f18000a = str2;
        this.f18002c = str3;
        this.f18003d = str4;
        this.f18004e = str5;
        this.f18005f = str6;
        this.f18006g = str7;
    }

    /* renamed from: a */
    public static C5337c m22621a(Context context) {
        ac acVar = new ac(context);
        Object a = acVar.a("google_app_id");
        if (TextUtils.isEmpty(a) != null) {
            return null;
        }
        return new C5337c(a, acVar.a("google_api_key"), acVar.a("firebase_database_url"), acVar.a("ga_trackingId"), acVar.a("gcm_defaultSenderId"), acVar.a("google_storage_bucket"), acVar.a("project_id"));
    }

    /* renamed from: a */
    public final String m22622a() {
        return this.f18001b;
    }

    /* renamed from: b */
    public final String m22623b() {
        return this.f18004e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C5337c)) {
            return false;
        }
        C5337c c5337c = (C5337c) obj;
        if (C2868t.a(this.f18001b, c5337c.f18001b) && C2868t.a(this.f18000a, c5337c.f18000a) && C2868t.a(this.f18002c, c5337c.f18002c) && C2868t.a(this.f18003d, c5337c.f18003d) && C2868t.a(this.f18004e, c5337c.f18004e) && C2868t.a(this.f18005f, c5337c.f18005f) && C2868t.a(this.f18006g, c5337c.f18006g) != null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return C2868t.a(new Object[]{this.f18001b, this.f18000a, this.f18002c, this.f18003d, this.f18004e, this.f18005f, this.f18006g});
    }

    public final String toString() {
        return C2868t.a(this).a("applicationId", this.f18001b).a("apiKey", this.f18000a).a("databaseUrl", this.f18002c).a("gcmSenderId", this.f18004e).a("storageBucket", this.f18005f).a("projectId", this.f18006g).toString();
    }
}
