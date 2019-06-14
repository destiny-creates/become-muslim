package com.reactnativecommunity.webview.p283a;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import p044c.p045a.p046a.C0836b;

/* compiled from: TopLoadingProgressEvent.kt */
/* renamed from: com.reactnativecommunity.webview.a.c */
public final class C7146c extends Event<C7146c> {
    /* renamed from: a */
    public static final C5706a f25296a = new C5706a();
    /* renamed from: b */
    private final WritableMap f25297b;

    /* compiled from: TopLoadingProgressEvent.kt */
    /* renamed from: com.reactnativecommunity.webview.a.c$a */
    public static final class C5706a {
        private C5706a() {
        }
    }

    public boolean canCoalesce() {
        return false;
    }

    public short getCoalescingKey() {
        return (short) 0;
    }

    public String getEventName() {
        return "topLoadingProgress";
    }

    public C7146c(int i, WritableMap writableMap) {
        C0836b.a(writableMap, "mEventData");
        super(i);
        this.f25297b = writableMap;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        C0836b.a(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), this.f25297b);
    }
}
