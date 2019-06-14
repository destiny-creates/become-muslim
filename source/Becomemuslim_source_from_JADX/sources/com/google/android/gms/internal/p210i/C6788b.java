package com.google.android.gms.internal.p210i;

import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.analytics.C2716q;
import com.google.android.gms.common.internal.C2872v;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.google.android.gms.internal.i.b */
public final class C6788b extends C2716q<C6788b> {
    /* renamed from: a */
    private String f24433a;
    /* renamed from: b */
    private int f24434b;
    /* renamed from: c */
    private int f24435c;
    /* renamed from: d */
    private String f24436d;
    /* renamed from: e */
    private String f24437e;
    /* renamed from: f */
    private boolean f24438f;
    /* renamed from: g */
    private boolean f24439g;

    public C6788b() {
        this(false);
    }

    private C6788b(boolean z) {
        z = UUID.randomUUID();
        int leastSignificantBits = (int) (z.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits == 0) {
            leastSignificantBits = (int) (z.getMostSignificantBits() & 2147483647L);
            if (leastSignificantBits == 0) {
                Log.e("GAv4", "UUID.randomUUID() returned 0.");
                leastSignificantBits = Integer.MAX_VALUE;
            }
        }
        this(false, leastSignificantBits);
    }

    private C6788b(boolean z, int i) {
        C2872v.a(i);
        this.f24434b = i;
        this.f24439g = false;
    }

    /* renamed from: a */
    public final String m31308a() {
        return this.f24433a;
    }

    /* renamed from: b */
    public final int m31310b() {
        return this.f24434b;
    }

    /* renamed from: c */
    public final String m31311c() {
        return this.f24437e;
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("screenName", this.f24433a);
        hashMap.put("interstitial", Boolean.valueOf(this.f24438f));
        hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, Boolean.valueOf(this.f24439g));
        hashMap.put("screenId", Integer.valueOf(this.f24434b));
        hashMap.put("referrerScreenId", Integer.valueOf(this.f24435c));
        hashMap.put("referrerScreenName", this.f24436d);
        hashMap.put("referrerUri", this.f24437e);
        return C6788b.a(hashMap);
    }

    /* renamed from: a */
    public final /* synthetic */ void m31309a(C2716q c2716q) {
        C6788b c6788b = (C6788b) c2716q;
        if (!TextUtils.isEmpty(this.f24433a)) {
            c6788b.f24433a = this.f24433a;
        }
        if (this.f24434b != 0) {
            c6788b.f24434b = this.f24434b;
        }
        if (this.f24435c != 0) {
            c6788b.f24435c = this.f24435c;
        }
        if (!TextUtils.isEmpty(this.f24436d)) {
            c6788b.f24436d = this.f24436d;
        }
        if (!TextUtils.isEmpty(this.f24437e)) {
            Object obj = this.f24437e;
            if (TextUtils.isEmpty(obj)) {
                c6788b.f24437e = null;
            } else {
                c6788b.f24437e = obj;
            }
        }
        if (this.f24438f) {
            c6788b.f24438f = this.f24438f;
        }
        if (this.f24439g) {
            c6788b.f24439g = this.f24439g;
        }
    }
}
