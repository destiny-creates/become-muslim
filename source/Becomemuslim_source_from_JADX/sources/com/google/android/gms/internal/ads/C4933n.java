package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONObject;

@cm
/* renamed from: com.google.android.gms.internal.ads.n */
public class C4933n {
    /* renamed from: a */
    private final qo f15818a;
    /* renamed from: b */
    private final String f15819b;

    public C4933n(qo qoVar) {
        this(qoVar, "");
    }

    public C4933n(qo qoVar, String str) {
        this.f15818a = qoVar;
        this.f15819b = str;
    }

    /* renamed from: a */
    public final void m19928a(int i, int i2, int i3, int i4) {
        try {
            this.f15818a.mo4089a("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (Throwable e) {
            mt.m19919b("Error occured while dispatching size change.", e);
        }
    }

    /* renamed from: a */
    public final void m19929a(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.f15818a.mo4089a("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (Throwable e) {
            mt.m19919b("Error occured while obtaining screen information.", e);
        }
    }

    /* renamed from: a */
    public final void m19930a(String str) {
        try {
            this.f15818a.mo4089a("onError", new JSONObject().put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str).put(NativeProtocol.WEB_DIALOG_ACTION, this.f15819b));
        } catch (Throwable e) {
            mt.m19919b("Error occurred while dispatching error event.", e);
        }
    }

    /* renamed from: b */
    public final void m19931b(int i, int i2, int i3, int i4) {
        try {
            this.f15818a.mo4089a("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (Throwable e) {
            mt.m19919b("Error occured while dispatching default position.", e);
        }
    }

    /* renamed from: b */
    public final void m19932b(String str) {
        try {
            this.f15818a.mo4089a("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (Throwable e) {
            mt.m19919b("Error occured while dispatching ready Event.", e);
        }
    }

    /* renamed from: c */
    public final void m19933c(String str) {
        try {
            this.f15818a.mo4089a("onStateChanged", new JSONObject().put(ServerProtocol.DIALOG_PARAM_STATE, str));
        } catch (Throwable e) {
            mt.m19919b("Error occured while dispatching state change.", e);
        }
    }
}
