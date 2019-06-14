package com.reactnativecommunity.webview.p283a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import p044c.p045a.p046a.C0836b;

/* compiled from: TopShouldStartLoadWithRequestEvent.kt */
/* renamed from: com.reactnativecommunity.webview.a.f */
public final class C7149f extends Event<C7149f> {
    /* renamed from: a */
    public static final C5709a f25302a = new C5709a();
    /* renamed from: b */
    private final WritableMap f25303b;

    /* compiled from: TopShouldStartLoadWithRequestEvent.kt */
    /* renamed from: com.reactnativecommunity.webview.a.f$a */
    public static final class C5709a {
        private C5709a() {
        }
    }

    public boolean canCoalesce() {
        return false;
    }

    public short getCoalescingKey() {
        return (short) 0;
    }

    public String getEventName() {
        return "topShouldStartLoadWithRequest";
    }

    public C7149f(int i, WritableMap writableMap) {
        C0836b.a(writableMap, "mData");
        super(i);
        this.f25303b = writableMap;
        this.f25303b.putString("navigationType", FacebookRequestErrorClassification.KEY_OTHER);
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        C0836b.a(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(getViewTag(), "topShouldStartLoadWithRequest", this.f25303b);
    }
}
