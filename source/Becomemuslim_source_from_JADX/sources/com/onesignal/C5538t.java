package com.onesignal;

import android.content.Context;
import android.net.Uri;
import com.onesignal.C6965s.C5531a;
import java.security.SecureRandom;
import org.json.JSONObject;

/* compiled from: NotificationGenerationJob */
/* renamed from: com.onesignal.t */
class C5538t {
    /* renamed from: a */
    Context f18576a;
    /* renamed from: b */
    JSONObject f18577b;
    /* renamed from: c */
    boolean f18578c;
    /* renamed from: d */
    boolean f18579d;
    /* renamed from: e */
    Long f18580e;
    /* renamed from: f */
    CharSequence f18581f;
    /* renamed from: g */
    CharSequence f18582g;
    /* renamed from: h */
    Uri f18583h;
    /* renamed from: i */
    Integer f18584i;
    /* renamed from: j */
    Integer f18585j;
    /* renamed from: k */
    Uri f18586k;
    /* renamed from: l */
    C5531a f18587l;

    C5538t(Context context) {
        this.f18576a = context;
    }

    /* renamed from: a */
    CharSequence m23562a() {
        if (this.f18582g != null) {
            return this.f18582g;
        }
        return this.f18577b.optString("title", null);
    }

    /* renamed from: b */
    CharSequence m23564b() {
        if (this.f18581f != null) {
            return this.f18581f;
        }
        return this.f18577b.optString("alert", null);
    }

    /* renamed from: c */
    Integer m23565c() {
        if (this.f18587l == null) {
            this.f18587l = new C5531a();
        }
        if (this.f18587l.f18570b == null) {
            this.f18587l.f18570b = Integer.valueOf(new SecureRandom().nextInt());
        }
        return this.f18587l.f18570b;
    }

    /* renamed from: d */
    int m23566d() {
        if (this.f18587l != null) {
            if (this.f18587l.f18570b != null) {
                return this.f18587l.f18570b.intValue();
            }
        }
        return -1;
    }

    /* renamed from: a */
    void m23563a(Integer num) {
        if (num != null) {
            if (this.f18587l == null || this.f18587l.f18570b == null) {
                if (this.f18587l == null) {
                    this.f18587l = new C5531a();
                }
                this.f18587l.f18570b = num;
            }
        }
    }

    /* renamed from: e */
    boolean m23567e() {
        return (this.f18587l == null || this.f18587l.f18569a == null) ? false : true;
    }
}
