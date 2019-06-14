package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;

@cm
/* renamed from: com.google.android.gms.internal.ads.p */
public final class C4935p {
    /* renamed from: a */
    private static final Object f15868a = new Object();
    /* renamed from: b */
    private static boolean f15869b = false;
    /* renamed from: c */
    private static boolean f15870c = false;
    /* renamed from: d */
    private tg f15871d;

    /* renamed from: c */
    private final void m19985c(Context context) {
        synchronized (f15868a) {
            if (((Boolean) aph.m18688f().m18889a(asp.dg)).booleanValue() && !f15870c) {
                try {
                    f15870c = true;
                    this.f15871d = th.m31112a(DynamiteModule.a(context, DynamiteModule.f7429a, ModuleDescriptor.MODULE_ID).a("com.google.android.gms.ads.omid.DynamiteOmid"));
                } catch (Throwable e) {
                    mt.m19923d("#007 Could not call remote method.", e);
                }
            }
        }
    }

    /* renamed from: a */
    public final C2758b m19986a(String str, WebView webView, String str2, String str3, String str4) {
        synchronized (f15868a) {
            if (((Boolean) aph.m18688f().m18889a(asp.dg)).booleanValue()) {
                if (f15869b) {
                    try {
                        return this.f15871d.mo4371a(str, C4757d.a(webView), str2, str3, str4);
                    } catch (Throwable e) {
                        mt.m19923d("#007 Could not call remote method.", e);
                        return null;
                    }
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    public final void m19987a(C2758b c2758b) {
        synchronized (f15868a) {
            if (((Boolean) aph.m18688f().m18889a(asp.dg)).booleanValue()) {
                if (f15869b) {
                    try {
                        this.f15871d.mo4375b(c2758b);
                        return;
                    } catch (Throwable e) {
                        mt.m19923d("#007 Could not call remote method.", e);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void m19988a(C2758b c2758b, View view) {
        synchronized (f15868a) {
            if (((Boolean) aph.m18688f().m18889a(asp.dg)).booleanValue()) {
                if (f15869b) {
                    try {
                        this.f15871d.mo4373a(c2758b, C4757d.a(view));
                        return;
                    } catch (Throwable e) {
                        mt.m19923d("#007 Could not call remote method.", e);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final boolean m19989a(Context context) {
        synchronized (f15868a) {
            if (!((Boolean) aph.m18688f().m18889a(asp.dg)).booleanValue()) {
                return false;
            } else if (f15869b) {
                return true;
            } else {
                try {
                    m19985c(context);
                    boolean a = this.f15871d.mo4374a(C4757d.a(context));
                    f15869b = a;
                    return a;
                } catch (Throwable e) {
                    mt.m19923d("#007 Could not call remote method.", e);
                    return false;
                }
            }
        }
    }

    /* renamed from: b */
    public final String m19990b(Context context) {
        if (!((Boolean) aph.m18688f().m18889a(asp.dg)).booleanValue()) {
            return null;
        }
        try {
            m19985c(context);
            String str = "a.";
            String valueOf = String.valueOf(this.f15871d.mo4372a());
            return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
            return null;
        }
    }

    /* renamed from: b */
    public final void m19991b(C2758b c2758b) {
        synchronized (f15868a) {
            if (((Boolean) aph.m18688f().m18889a(asp.dg)).booleanValue()) {
                if (f15869b) {
                    try {
                        this.f15871d.mo4376c(c2758b);
                        return;
                    } catch (Throwable e) {
                        mt.m19923d("#007 Could not call remote method.", e);
                        return;
                    }
                }
            }
        }
    }
}
