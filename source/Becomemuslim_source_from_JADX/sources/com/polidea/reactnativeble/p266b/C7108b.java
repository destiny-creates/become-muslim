package com.polidea.reactnativeble.p266b;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.polidea.p254a.p263c.C5621d;
import com.polidea.reactnativeble.p265a.C5632a;
import com.polidea.reactnativeble.p269e.C5641a;
import com.polidea.reactnativeble.p269e.C5649i;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.UUID;

/* compiled from: RxBleScanResultConverter */
/* renamed from: com.polidea.reactnativeble.b.b */
public class C7108b extends C5633a<C5621d> {
    /* renamed from: a */
    public WritableMap m33111a(C5621d c5621d) {
        Iterator it;
        WritableArray createArray;
        WritableMap createMap = Arguments.createMap();
        createMap.putString("id", c5621d.m23906a().mo5026c());
        createMap.putString("name", c5621d.m23906a().mo5025b());
        createMap.putInt("rssi", c5621d.m23907b());
        createMap.putInt("mtu", 23);
        c5621d = C5632a.m23932a(c5621d.m23908c().mo5014c());
        createMap.putString("manufacturerData", c5621d.m23942b() != null ? C5641a.m23969a(c5621d.m23942b()) : null);
        if (c5621d.m23943c() != null) {
            WritableMap createMap2 = Arguments.createMap();
            for (Entry entry : c5621d.m23943c().entrySet()) {
                createMap2.putString(C5649i.m23982a((UUID) entry.getKey()), C5641a.m23969a((byte[]) entry.getValue()));
            }
            createMap.putMap("serviceData", createMap2);
        } else {
            createMap.putNull("serviceData");
        }
        if (c5621d.m23944d() != null) {
            createArray = Arguments.createArray();
            it = c5621d.m23944d().iterator();
            while (it.hasNext()) {
                createArray.pushString(C5649i.m23982a((UUID) it.next()));
            }
            createMap.putArray("serviceUUIDs", createArray);
        } else {
            createMap.putNull("serviceUUIDs");
        }
        if (c5621d.m23941a() != null) {
            createMap.putString("localName", c5621d.m23941a());
        } else {
            createMap.putNull("localName");
        }
        if (c5621d.m23945e() != null) {
            createMap.putInt("txPowerLevel", c5621d.m23945e().intValue());
        } else {
            createMap.putNull("txPowerLevel");
        }
        if (c5621d.m23946f() != null) {
            createArray = Arguments.createArray();
            c5621d = c5621d.m23946f().iterator();
            while (c5621d.hasNext()) {
                createArray.pushString(C5649i.m23982a((UUID) c5621d.next()));
            }
            createMap.putArray("solicitedServiceUUIDs", createArray);
        } else {
            createMap.putNull("solicitedServiceUUIDs");
        }
        createMap.putNull("isConnectable");
        createMap.putNull("overflowServiceUUIDs");
        return createMap;
    }
}
