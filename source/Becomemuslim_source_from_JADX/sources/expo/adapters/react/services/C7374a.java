package expo.adapters.react.services;

import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import expo.p304a.p305a.C5998e;
import expo.p304a.p305a.p306a.C5991a;
import expo.p304a.p305a.p306a.C5991a.C5990b;
import java.util.Collections;
import java.util.List;

/* compiled from: EventEmitterModule */
/* renamed from: expo.adapters.react.services.a */
public class C7374a implements C5991a, C5998e {
    /* renamed from: a */
    private ReactContext f25777a;

    public C7374a(ReactContext reactContext) {
        this.f25777a = reactContext;
    }

    /* renamed from: a */
    public void mo5142a(String str, Bundle bundle) {
        ((RCTDeviceEventEmitter) this.f25777a.getJSModule(RCTDeviceEventEmitter.class)).emit(str, Arguments.fromBundle(bundle));
    }

    /* renamed from: a */
    public void mo5141a(int i, C5990b c5990b) {
        ((UIManagerModule) this.f25777a.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(C7374a.m33789b(i, c5990b));
    }

    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C5991a.class);
    }

    /* renamed from: b */
    private static Event m33789b(final int i, final C5990b c5990b) {
        return new Event(i) {
            public String getEventName() {
                return c5990b.getEventName();
            }

            public void dispatch(RCTEventEmitter rCTEventEmitter) {
                rCTEventEmitter.receiveEvent(i, c5990b.getEventName(), Arguments.fromBundle(c5990b.getEventBody()));
            }

            public boolean canCoalesce() {
                return c5990b.canCoalesce();
            }

            public short getCoalescingKey() {
                return c5990b.getCoalescingKey();
            }
        };
    }
}
