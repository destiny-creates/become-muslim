package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.C3211a;
import com.google.android.gms.common.internal.p181a.C2835c;
import com.google.android.gms.common.internal.p181a.C4363a;
import java.util.Map;

/* renamed from: com.google.firebase.messaging.d */
public final class C7917d extends C4363a {
    public static final Creator<C7917d> CREATOR = new C5378g();
    /* renamed from: a */
    Bundle f29536a;
    /* renamed from: b */
    private Map<String, String> f29537b;

    public C7917d(Bundle bundle) {
        this.f29536a = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = C2835c.a(parcel);
        C2835c.a(parcel, 2, this.f29536a, false);
        C2835c.a(parcel, i);
    }

    /* renamed from: a */
    public final Map<String, String> m38517a() {
        if (this.f29537b == null) {
            Bundle bundle = this.f29536a;
            Map c3211a = new C3211a();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!(str.startsWith("google.") || str.startsWith("gcm.") || str.equals("from") || str.equals("message_type") || str.equals("collapse_key"))) {
                        c3211a.put(str, str2);
                    }
                }
            }
            this.f29537b = c3211a;
        }
        return this.f29537b;
    }
}
