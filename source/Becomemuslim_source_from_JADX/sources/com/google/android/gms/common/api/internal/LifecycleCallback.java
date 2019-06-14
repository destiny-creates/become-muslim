package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class LifecycleCallback {
    /* renamed from: a */
    protected final C2801g f7120a;

    @Keep
    private static C2801g getChimeraLifecycleFragmentImpl(C2800f c2800f) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    /* renamed from: a */
    public void mo2431a(int i, int i2, Intent intent) {
    }

    /* renamed from: a */
    public void mo2432a(Bundle bundle) {
    }

    /* renamed from: a */
    public void mo3286a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* renamed from: b */
    public void mo2433b() {
    }

    /* renamed from: b */
    public void mo2434b(Bundle bundle) {
    }

    /* renamed from: c */
    public void mo3289c() {
    }

    /* renamed from: d */
    public void mo2435d() {
    }

    /* renamed from: e */
    public void m7979e() {
    }

    /* renamed from: a */
    protected static C2801g m7970a(C2800f c2800f) {
        if (c2800f.m8071a()) {
            return da.m16803a(c2800f.m8074d());
        }
        if (c2800f.m8072b()) {
            return cy.m14293a(c2800f.m8073c());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    /* renamed from: a */
    public static C2801g m7969a(Activity activity) {
        return m7970a(new C2800f(activity));
    }

    protected LifecycleCallback(C2801g c2801g) {
        this.f7120a = c2801g;
    }

    /* renamed from: a */
    public Activity m7971a() {
        return this.f7120a.mo2448a();
    }
}
