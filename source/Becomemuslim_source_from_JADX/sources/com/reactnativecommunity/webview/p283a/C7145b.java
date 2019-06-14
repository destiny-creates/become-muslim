package com.reactnativecommunity.webview.p283a;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.webview.events.TopLoadingFinishEvent;
import p044c.p045a.p046a.C0836b;

/* compiled from: TopLoadingFinishEvent.kt */
/* renamed from: com.reactnativecommunity.webview.a.b */
public final class C7145b extends Event<C7145b> {
    /* renamed from: a */
    public static final C5705a f25294a = new C5705a();
    /* renamed from: b */
    private final WritableMap f25295b;

    /* compiled from: TopLoadingFinishEvent.kt */
    /* renamed from: com.reactnativecommunity.webview.a.b$a */
    public static final class C5705a {
        private C5705a() {
        }
    }

    public boolean canCoalesce() {
        return false;
    }

    public short getCoalescingKey() {
        return (short) 0;
    }

    public String getEventName() {
        return TopLoadingFinishEvent.EVENT_NAME;
    }

    public C7145b(int i, WritableMap writableMap) {
        C0836b.a(writableMap, "mEventData");
        super(i);
        this.f25295b = writableMap;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        C0836b.a(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), this.f25295b);
    }
}
