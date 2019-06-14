package com.google.maps.android.p247a.p249b;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;

/* compiled from: KmlBoolean */
/* renamed from: com.google.maps.android.a.b.a */
public class C5383a {
    /* renamed from: a */
    public static boolean m22835a(String str) {
        if (!AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(str)) {
            if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(str) == null) {
                return null;
            }
        }
        return true;
    }
}
