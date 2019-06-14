package com.imagepicker;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;

/* compiled from: ResponseHelper */
/* renamed from: com.imagepicker.c */
public class C5426c {
    /* renamed from: a */
    private WritableMap f18222a = Arguments.createMap();

    /* renamed from: a */
    public void m23013a() {
        this.f18222a = Arguments.createMap();
    }

    /* renamed from: a */
    public void m23018a(String str, String str2) {
        this.f18222a.putString(str, str2);
    }

    /* renamed from: a */
    public void m23017a(String str, int i) {
        this.f18222a.putInt(str, i);
    }

    /* renamed from: a */
    public void m23019a(String str, boolean z) {
        this.f18222a.putBoolean(str, z);
    }

    /* renamed from: a */
    public void m23016a(String str, double d) {
        this.f18222a.putDouble(str, d);
    }

    /* renamed from: a */
    public void m23015a(Callback callback, String str) {
        m23013a();
        this.f18222a.putString("customButton", str);
        m23020b(callback);
    }

    /* renamed from: a */
    public void m23014a(Callback callback) {
        m23013a();
        this.f18222a.putBoolean("didCancel", true);
        m23020b(callback);
    }

    /* renamed from: b */
    public void m23021b(Callback callback, String str) {
        m23013a();
        this.f18222a.putString("error", str);
        m23020b(callback);
    }

    /* renamed from: b */
    public void m23020b(Callback callback) {
        callback.invoke(new Object[]{this.f18222a});
    }
}
