package com.gettipsi.stripe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.gettipsi.stripe.p126b.C2104a;
import com.gettipsi.stripe.p126b.C2107d;
import com.google.android.gms.common.C4361e;

/* compiled from: PayFlow */
/* renamed from: com.gettipsi.stripe.c */
public abstract class C2109c {
    /* renamed from: a */
    protected final C2107d<Activity> f5041a;
    /* renamed from: b */
    private String f5042b;
    /* renamed from: c */
    private int f5043c;

    /* renamed from: b */
    private static boolean m5812b(int i) {
        return i != 3 ? i == 1 : true;
    }

    /* renamed from: a */
    abstract void mo1987a(ReadableMap readableMap, Promise promise);

    /* renamed from: a */
    abstract void mo1988a(boolean z, Promise promise);

    /* renamed from: a */
    abstract boolean mo1989a(Activity activity, int i, int i2, Intent intent);

    public C2109c(C2107d<Activity> c2107d) {
        C2104a.m5776a((Object) c2107d);
        this.f5041a = c2107d;
    }

    /* renamed from: a */
    public static C2109c m5809a(C2107d<Activity> c2107d) {
        return new C3988b(c2107d);
    }

    /* renamed from: a */
    private static boolean m5810a(int i, int i2) {
        return (i == i2 || C2109c.m5812b(i) == 0 || C2109c.m5812b(i2) == 0) ? false : true;
    }

    /* renamed from: b */
    protected int m5818b() {
        C2104a.m5778a(C2109c.m5812b(this.f5043c));
        return this.f5043c;
    }

    /* renamed from: a */
    public void m5813a(int i) {
        C2104a.m5778a(C2109c.m5812b(i));
        C2104a.m5778a(C2109c.m5810a(this.f5043c, i) ^ 1);
        this.f5043c = i;
    }

    /* renamed from: c */
    protected String m5819c() {
        return C2104a.m5777a(this.f5042b);
    }

    /* renamed from: a */
    public void m5815a(String str) {
        this.f5042b = C2104a.m5777a(str);
    }

    /* renamed from: a */
    public static boolean m5811a(Activity activity) {
        C2104a.m5776a((Object) activity);
        return C4361e.m14332a().mo2455a((Context) activity) == null ? true : null;
    }
}
