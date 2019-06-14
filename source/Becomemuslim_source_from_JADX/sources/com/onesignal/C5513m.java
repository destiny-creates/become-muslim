package com.onesignal;

import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: GoogleApiClientCompatProxy */
/* renamed from: com.onesignal.m */
class C5513m {
    /* renamed from: a */
    private final GoogleApiClient f18539a;
    /* renamed from: b */
    private final Class f18540b;

    C5513m(GoogleApiClient googleApiClient) {
        this.f18539a = googleApiClient;
        this.f18540b = googleApiClient.getClass();
    }

    /* renamed from: a */
    void m23494a() {
        try {
            this.f18540b.getMethod("connect", new Class[0]).invoke(this.f18539a, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    void m23495b() {
        try {
            this.f18540b.getMethod("disconnect", new Class[0]).invoke(this.f18539a, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    GoogleApiClient m23496c() {
        return this.f18539a;
    }
}
