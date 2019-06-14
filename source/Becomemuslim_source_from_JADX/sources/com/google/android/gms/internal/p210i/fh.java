package com.google.android.gms.internal.p210i;

import android.text.TextUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.C2716q;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.fh */
public final class fh extends C2716q<fh> {
    /* renamed from: a */
    private String f24489a;
    /* renamed from: b */
    private String f24490b;
    /* renamed from: c */
    private String f24491c;
    /* renamed from: d */
    private String f24492d;
    /* renamed from: e */
    private String f24493e;
    /* renamed from: f */
    private String f24494f;
    /* renamed from: g */
    private String f24495g;
    /* renamed from: h */
    private String f24496h;
    /* renamed from: i */
    private String f24497i;
    /* renamed from: j */
    private String f24498j;

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("name", this.f24489a);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, this.f24490b);
        hashMap.put("medium", this.f24491c);
        hashMap.put("keyword", this.f24492d);
        hashMap.put(UriUtil.LOCAL_CONTENT_SCHEME, this.f24493e);
        hashMap.put("id", this.f24494f);
        hashMap.put("adNetworkId", this.f24495g);
        hashMap.put("gclid", this.f24496h);
        hashMap.put("dclid", this.f24497i);
        hashMap.put("aclid", this.f24498j);
        return fh.a(hashMap);
    }

    /* renamed from: a */
    public final String m31574a() {
        return this.f24489a;
    }

    /* renamed from: a */
    public final void m31576a(String str) {
        this.f24489a = str;
    }

    /* renamed from: b */
    public final String m31577b() {
        return this.f24490b;
    }

    /* renamed from: b */
    public final void m31578b(String str) {
        this.f24490b = str;
    }

    /* renamed from: c */
    public final String m31579c() {
        return this.f24491c;
    }

    /* renamed from: c */
    public final void m31580c(String str) {
        this.f24491c = str;
    }

    /* renamed from: d */
    public final String m31581d() {
        return this.f24492d;
    }

    /* renamed from: d */
    public final void m31582d(String str) {
        this.f24492d = str;
    }

    /* renamed from: e */
    public final String m31583e() {
        return this.f24493e;
    }

    /* renamed from: e */
    public final void m31584e(String str) {
        this.f24493e = str;
    }

    /* renamed from: f */
    public final String m31585f() {
        return this.f24494f;
    }

    /* renamed from: f */
    public final void m31586f(String str) {
        this.f24494f = str;
    }

    /* renamed from: g */
    public final String m31587g() {
        return this.f24495g;
    }

    /* renamed from: g */
    public final void m31588g(String str) {
        this.f24495g = str;
    }

    /* renamed from: h */
    public final String m31589h() {
        return this.f24496h;
    }

    /* renamed from: h */
    public final void m31590h(String str) {
        this.f24496h = str;
    }

    /* renamed from: i */
    public final String m31591i() {
        return this.f24497i;
    }

    /* renamed from: i */
    public final void m31592i(String str) {
        this.f24497i = str;
    }

    /* renamed from: j */
    public final String m31593j() {
        return this.f24498j;
    }

    /* renamed from: j */
    public final void m31594j(String str) {
        this.f24498j = str;
    }

    /* renamed from: a */
    public final /* synthetic */ void m31575a(C2716q c2716q) {
        fh fhVar = (fh) c2716q;
        if (!TextUtils.isEmpty(this.f24489a)) {
            fhVar.f24489a = this.f24489a;
        }
        if (!TextUtils.isEmpty(this.f24490b)) {
            fhVar.f24490b = this.f24490b;
        }
        if (!TextUtils.isEmpty(this.f24491c)) {
            fhVar.f24491c = this.f24491c;
        }
        if (!TextUtils.isEmpty(this.f24492d)) {
            fhVar.f24492d = this.f24492d;
        }
        if (!TextUtils.isEmpty(this.f24493e)) {
            fhVar.f24493e = this.f24493e;
        }
        if (!TextUtils.isEmpty(this.f24494f)) {
            fhVar.f24494f = this.f24494f;
        }
        if (!TextUtils.isEmpty(this.f24495g)) {
            fhVar.f24495g = this.f24495g;
        }
        if (!TextUtils.isEmpty(this.f24496h)) {
            fhVar.f24496h = this.f24496h;
        }
        if (!TextUtils.isEmpty(this.f24497i)) {
            fhVar.f24497i = this.f24497i;
        }
        if (!TextUtils.isEmpty(this.f24498j)) {
            fhVar.f24498j = this.f24498j;
        }
    }
}
