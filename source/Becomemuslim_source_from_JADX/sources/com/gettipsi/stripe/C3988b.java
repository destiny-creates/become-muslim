package com.gettipsi.stripe;

import android.app.Activity;
import android.content.Intent;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.gettipsi.stripe.p126b.C2104a;
import com.gettipsi.stripe.p126b.C2106c;
import com.gettipsi.stripe.p126b.C2107d;
import com.google.android.gms.common.api.C2782b;
import com.google.android.gms.p186f.C2950c;
import com.google.android.gms.p186f.C2954g;
import com.google.android.gms.wallet.C5153b;
import com.google.android.gms.wallet.C5162r;
import com.google.android.gms.wallet.C5162r.C8229a.C5161a;
import com.google.android.gms.wallet.C6850n;
import com.google.android.gms.wallet.C7872d;
import com.google.android.gms.wallet.C7874f;
import com.google.android.gms.wallet.C7877i;
import com.google.android.gms.wallet.C7878j;
import com.google.android.gms.wallet.C7878j.C5156a;
import com.google.android.gms.wallet.C7880l;
import com.google.android.gms.wallet.C7882p;
import com.google.android.gms.wallet.C7883q;
import com.stripe.android.p285b.C7168u;
import java.util.Arrays;
import java.util.Collection;

/* compiled from: GoogleApiPayFlowImpl */
/* renamed from: com.gettipsi.stripe.b */
public final class C3988b extends C2109c {
    /* renamed from: b */
    private static final String f10002b = "b";
    /* renamed from: c */
    private C6850n f10003c;
    /* renamed from: d */
    private Promise f10004d;

    public C3988b(C2107d<Activity> c2107d) {
        super(c2107d);
    }

    /* renamed from: b */
    private C6850n m12205b(Activity activity) {
        return C5162r.a(activity, new C5161a().a(m5818b()).a());
    }

    /* renamed from: a */
    private void m12204a(Activity activity, boolean z, final Promise promise) {
        C2104a.m5776a((Object) activity);
        C2104a.m5776a((Object) promise);
        z = C7874f.a().a(1).a(2).a(z).a();
        this.f10003c = m12205b(activity);
        this.f10003c.a(z).mo2578a(new C2950c<Boolean>(this) {
            /* renamed from: b */
            final /* synthetic */ C3988b f10001b;

            public void onComplete(C2954g<Boolean> c2954g) {
                try {
                    promise.resolve(Boolean.valueOf(((Boolean) c2954g.mo2586a(C2782b.class)).booleanValue()));
                } catch (C2954g<Boolean> c2954g2) {
                    promise.reject(C3988b.f10002b, String.format("Error, statusCode: %d", new Object[]{Integer.valueOf(c2954g2.m7935a())}));
                }
            }
        });
    }

    /* renamed from: d */
    private C7880l m12206d() {
        return C7880l.a().a(1).a("gateway", "stripe").a("stripe:publishableKey", m5819c()).a("stripe:version", "6.0.0").a();
    }

    /* renamed from: a */
    private C7878j m12200a(ReadableMap readableMap) {
        String string = readableMap.getString("total_price");
        String string2 = readableMap.getString("currency_code");
        boolean booleanValue = C2106c.m5797a(readableMap, "billing_address_required", Boolean.valueOf(false)).booleanValue();
        Boolean a = C2106c.m5797a(readableMap, "shipping_address_required", Boolean.valueOf(false));
        return m12201a(string, string2, booleanValue, a.booleanValue(), C2106c.m5800a(readableMap));
    }

    /* renamed from: a */
    private C7878j m12201a(String str, String str2, boolean z, boolean z2, Collection<String> collection) {
        C2104a.m5779b(str);
        C2104a.m5777a(str2);
        C5156a a = C7878j.a();
        a.a(C7883q.a().a(2).a(str).b(str2).a());
        a.a(C7872d.a().a(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(5), Integer.valueOf(4)})).a(z).a()).a(1).a(2).a(z2);
        if (collection.size() > null) {
            a.a(C7882p.a().a(collection).a());
        }
        a.a(m12206d());
        return a.a();
    }

    /* renamed from: a */
    private void m12203a(Activity activity, C7878j c7878j) {
        C2104a.m5776a((Object) activity);
        C2104a.m5776a((Object) c7878j);
        this.f10003c = m12205b(activity);
        C5153b.a(this.f10003c.a(c7878j), activity, 65534);
    }

    /* renamed from: a */
    public void mo1987a(ReadableMap readableMap, Promise promise) {
        C2104a.m5776a((Object) readableMap);
        C2104a.m5776a((Object) promise);
        Activity activity = (Activity) this.a.mo1986b();
        if (activity == null) {
            promise.reject(f10002b, "Cannot start process with no current activity");
            return;
        }
        this.f10004d = promise;
        m12203a(activity, m12200a(readableMap));
    }

    /* renamed from: a */
    public void mo1988a(boolean z, Promise promise) {
        Activity activity = (Activity) this.a.mo1986b();
        if (activity == null) {
            promise.reject(f10002b, "Cannot start process with no current activity");
        } else if (C2109c.m5811a(activity)) {
            m12204a(activity, z, promise);
        } else {
            promise.reject(f10002b, "Play services are not available!");
        }
    }

    /* renamed from: a */
    public boolean mo1989a(Activity activity, int i, int i2, Intent intent) {
        if (this.f10004d == null || i != 65534) {
            return false;
        }
        switch (i2) {
            case -1:
                C7877i b = C7877i.b(intent);
                C2104a.m5776a((Object) b);
                C7168u a = C7168u.a(b.c().a());
                if (a != 0) {
                    this.f10004d.resolve(C2106c.m5784a(C2106c.m5794a(a), C2106c.m5796a(b), b.b()));
                    break;
                }
                this.f10004d.reject(f10002b, "Failed to create token from JSON string");
                break;
            case 0:
                this.f10004d.reject(f10002b, "Purchase was cancelled");
                break;
            case 1:
                this.f10004d.reject(f10002b, C5153b.a(intent).m16701a());
                break;
            default:
                break;
        }
        this.f10004d = null;
        return true;
    }
}
