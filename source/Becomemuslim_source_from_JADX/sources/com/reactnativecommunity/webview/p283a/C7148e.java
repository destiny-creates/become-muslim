package com.reactnativecommunity.webview.p283a;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.webview.events.TopMessageEvent;
import p044c.p045a.p046a.C0836b;

/* compiled from: TopMessageEvent.kt */
/* renamed from: com.reactnativecommunity.webview.a.e */
public final class C7148e extends Event<C7148e> {
    /* renamed from: a */
    public static final C5708a f25300a = new C5708a();
    /* renamed from: b */
    private final String f25301b;

    /* compiled from: TopMessageEvent.kt */
    /* renamed from: com.reactnativecommunity.webview.a.e$a */
    public static final class C5708a {
        private C5708a() {
        }
    }

    public boolean canCoalesce() {
        return false;
    }

    public short getCoalescingKey() {
        return (short) 0;
    }

    public String getEventName() {
        return TopMessageEvent.EVENT_NAME;
    }

    public C7148e(int i, String str) {
        C0836b.a(str, "mData");
        super(i);
        this.f25301b = str;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        C0836b.a(rCTEventEmitter, "rctEventEmitter");
        WritableMap createMap = Arguments.createMap();
        createMap.putString("data", this.f25301b);
        rCTEventEmitter.receiveEvent(getViewTag(), TopMessageEvent.EVENT_NAME, createMap);
    }
}
