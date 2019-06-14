package com.reactnativecommunity.webview.p283a;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.webview.events.TopLoadingStartEvent;
import p044c.p045a.p046a.C0836b;

/* compiled from: TopLoadingStartEvent.kt */
/* renamed from: com.reactnativecommunity.webview.a.d */
public final class C7147d extends Event<C7147d> {
    /* renamed from: a */
    public static final C5707a f25298a = new C5707a();
    /* renamed from: b */
    private final WritableMap f25299b;

    /* compiled from: TopLoadingStartEvent.kt */
    /* renamed from: com.reactnativecommunity.webview.a.d$a */
    public static final class C5707a {
        private C5707a() {
        }
    }

    public boolean canCoalesce() {
        return false;
    }

    public short getCoalescingKey() {
        return (short) 0;
    }

    public String getEventName() {
        return TopLoadingStartEvent.EVENT_NAME;
    }

    public C7147d(int i, WritableMap writableMap) {
        C0836b.a(writableMap, "mEventData");
        super(i);
        this.f25299b = writableMap;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        C0836b.a(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), this.f25299b);
    }
}
