package com.facebook.ads.internal.view.p114c.p115a;

import com.facebook.ads.internal.adapters.p086a.C1316h;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.view.c.a.b */
public class C1580b {
    /* renamed from: a */
    private final int f4726a;
    /* renamed from: b */
    private final int f4727b;
    /* renamed from: c */
    private final C1316h f4728c;

    C1580b(int i, int i2, C1316h c1316h) {
        this.f4726a = i;
        this.f4727b = i2;
        this.f4728c = c1316h;
    }

    /* renamed from: a */
    public Map<String, String> m5512a() {
        Map<String, String> hashMap = new HashMap();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f4726a);
        stringBuilder.append("");
        hashMap.put("cardind", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.f4727b);
        stringBuilder.append("");
        hashMap.put("cardcnt", stringBuilder.toString());
        return hashMap;
    }

    /* renamed from: b */
    public int m5513b() {
        return this.f4726a;
    }

    /* renamed from: c */
    public C1316h m5514c() {
        return this.f4728c;
    }
}
