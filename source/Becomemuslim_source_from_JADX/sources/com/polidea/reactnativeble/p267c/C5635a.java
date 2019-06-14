package com.polidea.reactnativeble.p267c;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableArray;
import com.polidea.reactnativeble.p269e.C5648h;

/* compiled from: BleError */
/* renamed from: com.polidea.reactnativeble.c.a */
public class C5635a {
    /* renamed from: a */
    public String f18826a;
    /* renamed from: b */
    public String f18827b;
    /* renamed from: c */
    public String f18828c;
    /* renamed from: d */
    public String f18829d;
    /* renamed from: e */
    public String f18830e;
    /* renamed from: f */
    private C5636b f18831f;
    /* renamed from: g */
    private Integer f18832g;
    /* renamed from: h */
    private String f18833h;

    public C5635a(C5636b c5636b, String str, Integer num) {
        this.f18831f = c5636b;
        this.f18833h = str;
        this.f18832g = num;
    }

    /* renamed from: a */
    public String m23950a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("\"errorCode\":");
        stringBuilder.append(this.f18831f.f18873M);
        stringBuilder.append(",\"attErrorCode\":");
        if (this.f18832g != null && this.f18832g.intValue() < 128) {
            if (this.f18832g.intValue() >= 0) {
                stringBuilder.append(this.f18832g);
                stringBuilder.append(",\"iosErrorCode\": null");
                stringBuilder.append(",\"androidErrorCode\":");
                if (this.f18832g != null) {
                    if (this.f18832g.intValue() < 128) {
                        stringBuilder.append(this.f18832g);
                        m23949a(stringBuilder, "reason", this.f18833h);
                        m23949a(stringBuilder, "deviceID", this.f18826a);
                        m23949a(stringBuilder, "serviceUUID", this.f18827b);
                        m23949a(stringBuilder, "characteristicUUID", this.f18828c);
                        m23949a(stringBuilder, "descriptorUUID", this.f18829d);
                        m23949a(stringBuilder, "internalMessage", this.f18830e);
                        stringBuilder.append("}");
                        return stringBuilder.toString();
                    }
                }
                stringBuilder.append("null");
                m23949a(stringBuilder, "reason", this.f18833h);
                m23949a(stringBuilder, "deviceID", this.f18826a);
                m23949a(stringBuilder, "serviceUUID", this.f18827b);
                m23949a(stringBuilder, "characteristicUUID", this.f18828c);
                m23949a(stringBuilder, "descriptorUUID", this.f18829d);
                m23949a(stringBuilder, "internalMessage", this.f18830e);
                stringBuilder.append("}");
                return stringBuilder.toString();
            }
        }
        stringBuilder.append("null");
        stringBuilder.append(",\"iosErrorCode\": null");
        stringBuilder.append(",\"androidErrorCode\":");
        if (this.f18832g != null) {
            if (this.f18832g.intValue() < 128) {
                stringBuilder.append(this.f18832g);
                m23949a(stringBuilder, "reason", this.f18833h);
                m23949a(stringBuilder, "deviceID", this.f18826a);
                m23949a(stringBuilder, "serviceUUID", this.f18827b);
                m23949a(stringBuilder, "characteristicUUID", this.f18828c);
                m23949a(stringBuilder, "descriptorUUID", this.f18829d);
                m23949a(stringBuilder, "internalMessage", this.f18830e);
                stringBuilder.append("}");
                return stringBuilder.toString();
            }
        }
        stringBuilder.append("null");
        m23949a(stringBuilder, "reason", this.f18833h);
        m23949a(stringBuilder, "deviceID", this.f18826a);
        m23949a(stringBuilder, "serviceUUID", this.f18827b);
        m23949a(stringBuilder, "characteristicUUID", this.f18828c);
        m23949a(stringBuilder, "descriptorUUID", this.f18829d);
        m23949a(stringBuilder, "internalMessage", this.f18830e);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private void m23949a(StringBuilder stringBuilder, String str, String str2) {
        stringBuilder.append(",\"");
        stringBuilder.append(str);
        stringBuilder.append("\":");
        if (str2 == null) {
            stringBuilder.append("null");
            return;
        }
        stringBuilder.append("\"");
        stringBuilder.append(str2);
        stringBuilder.append("\"");
    }

    /* renamed from: b */
    public ReadableArray m23953b() {
        ReadableArray createArray = Arguments.createArray();
        createArray.pushString(m23950a());
        createArray.pushNull();
        return createArray;
    }

    /* renamed from: a */
    public void m23951a(Promise promise) {
        promise.reject(null, m23950a());
    }

    /* renamed from: a */
    public void m23952a(C5648h c5648h) {
        c5648h.m23981a(null, m23950a());
    }
}
