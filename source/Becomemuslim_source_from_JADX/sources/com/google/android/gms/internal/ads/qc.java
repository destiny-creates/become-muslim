package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import java.util.HashMap;
import java.util.Map;

final class qc implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ String f15943a;
    /* renamed from: b */
    private final /* synthetic */ String f15944b;
    /* renamed from: c */
    private final /* synthetic */ String f15945c;
    /* renamed from: d */
    private final /* synthetic */ String f15946d;
    /* renamed from: e */
    private final /* synthetic */ pz f15947e;

    qc(pz pzVar, String str, String str2, String str3, String str4) {
        this.f15947e = pzVar;
        this.f15943a = str;
        this.f15944b = str2;
        this.f15945c = str3;
        this.f15946d = str4;
    }

    public final void run() {
        Map hashMap = new HashMap();
        hashMap.put("event", "precacheCanceled");
        hashMap.put("src", this.f15943a);
        if (!TextUtils.isEmpty(this.f15944b)) {
            hashMap.put("cachedSrc", this.f15944b);
        }
        hashMap.put("type", pz.m30994b(this.f15945c));
        hashMap.put("reason", this.f15945c);
        if (!TextUtils.isEmpty(this.f15946d)) {
            hashMap.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, this.f15946d);
        }
        this.f15947e.m30993a("onPrecacheEvent", hashMap);
    }
}
