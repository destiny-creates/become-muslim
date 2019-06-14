package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.internal.adapters.p086a.C1321k;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1508k;
import com.facebook.ads.internal.p105q.p106a.C1520t;
import com.facebook.ads.internal.p111r.C1545a;
import java.util.Map;

public class aa extends C1323b {
    /* renamed from: c */
    private final C1412c f9481c;
    /* renamed from: d */
    private final C1520t f9482d;
    /* renamed from: e */
    private C1321k f9483e;

    public aa(Context context, C1412c c1412c, C1545a c1545a, C1520t c1520t, C1324c c1324c) {
        super(context, c1324c, c1545a);
        this.f9481c = c1412c;
        this.f9482d = c1520t;
    }

    /* renamed from: a */
    public void m11509a(C1321k c1321k) {
        this.f9483e = c1321k;
    }

    /* renamed from: a */
    protected void mo920a(Map<String, String> map) {
        if (this.f9483e != null && !TextUtils.isEmpty(this.f9483e.m4565g())) {
            map.put("touch", C1508k.m5306a(this.f9482d.m5335e()));
            this.f9481c.mo945a(this.f9483e.m4565g(), map);
        }
    }
}
