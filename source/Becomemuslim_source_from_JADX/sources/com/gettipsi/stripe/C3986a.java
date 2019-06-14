package com.gettipsi.stripe;

import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/* compiled from: CreditCardFormOnChangeEvent */
/* renamed from: com.gettipsi.stripe.a */
public class C3986a extends Event<C3986a> {
    /* renamed from: a */
    private final WritableMap f9998a;
    /* renamed from: b */
    private final boolean f9999b;

    public String getEventName() {
        return "topChange";
    }

    public C3986a(int i, WritableMap writableMap, boolean z) {
        super(i);
        this.f9998a = writableMap;
        this.f9999b = z;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), m12199a());
    }

    /* renamed from: a */
    private WritableMap m12199a() {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("valid", this.f9999b);
        createMap.putMap(NativeProtocol.WEB_DIALOG_PARAMS, this.f9998a);
        return createMap;
    }
}
