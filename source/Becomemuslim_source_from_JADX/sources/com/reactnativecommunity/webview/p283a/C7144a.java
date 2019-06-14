package com.reactnativecommunity.webview.p283a;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.views.webview.events.TopLoadingErrorEvent;
import p044c.p045a.p046a.C0836b;

/* compiled from: TopLoadingErrorEvent.kt */
/* renamed from: com.reactnativecommunity.webview.a.a */
public final class C7144a extends Event<C7144a> {
    /* renamed from: a */
    public static final C5704a f25292a = new C5704a();
    /* renamed from: b */
    private final WritableMap f25293b;

    /* compiled from: TopLoadingErrorEvent.kt */
    /* renamed from: com.reactnativecommunity.webview.a.a$a */
    public static final class C5704a {
        private C5704a() {
        }
    }

    public boolean canCoalesce() {
        return false;
    }

    public short getCoalescingKey() {
        return (short) 0;
    }

    public String getEventName() {
        return TopLoadingErrorEvent.EVENT_NAME;
    }

    public C7144a(int i, WritableMap writableMap) {
        C0836b.a(writableMap, "mEventData");
        super(i);
        this.f25293b = writableMap;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        C0836b.a(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), this.f25293b);
    }
}
