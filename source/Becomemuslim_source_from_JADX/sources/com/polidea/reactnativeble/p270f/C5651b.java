package com.polidea.reactnativeble.p270f;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.polidea.p254a.af;
import com.polidea.p254a.ah;
import java.util.List;
import java.util.UUID;

/* compiled from: Device */
/* renamed from: com.polidea.reactnativeble.f.b */
public class C5651b {
    /* renamed from: a */
    private ah f18895a;
    /* renamed from: b */
    private af f18896b;
    /* renamed from: c */
    private List<C5652c> f18897c;

    public C5651b(ah ahVar, af afVar) {
        this.f18895a = ahVar;
        this.f18896b = afVar;
    }

    /* renamed from: a */
    public void m23995a(List<C5652c> list) {
        this.f18897c = list;
    }

    /* renamed from: a */
    public List<C5652c> m23994a() {
        return this.f18897c;
    }

    /* renamed from: b */
    public ah m23996b() {
        return this.f18895a;
    }

    /* renamed from: c */
    public af m23997c() {
        return this.f18896b;
    }

    /* renamed from: a */
    public C5652c m23993a(UUID uuid) {
        if (this.f18897c == null) {
            return null;
        }
        for (C5652c c5652c : this.f18897c) {
            if (uuid.equals(c5652c.m24001c().getUuid())) {
                return c5652c;
            }
        }
        return null;
    }

    /* renamed from: a */
    public WritableMap m23992a(Integer num) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("id", this.f18895a.mo5026c());
        createMap.putString("name", this.f18895a.mo5025b());
        if (num != null) {
            createMap.putInt("rssi", num.intValue());
        } else {
            createMap.putNull("rssi");
        }
        if (this.f18896b != null) {
            createMap.putInt("mtu", this.f18896b.mo4995c());
        } else {
            createMap.putInt("mtu", 23);
        }
        createMap.putNull("manufacturerData");
        createMap.putNull("serviceData");
        createMap.putNull("serviceUUIDs");
        createMap.putNull("localName");
        createMap.putNull("txPowerLevel");
        createMap.putNull("solicitedServiceUUIDs");
        createMap.putNull("isConnectable");
        createMap.putNull("overflowServiceUUIDs");
        return createMap;
    }
}
