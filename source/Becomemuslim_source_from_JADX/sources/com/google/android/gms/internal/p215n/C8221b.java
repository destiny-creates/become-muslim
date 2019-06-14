package com.google.android.gms.internal.p215n;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2853f;
import com.google.android.gms.common.internal.C4785j;
import com.google.android.gms.p186f.C2955h;
import com.google.android.gms.wallet.C7874f;
import com.google.android.gms.wallet.C7877i;
import com.google.android.gms.wallet.C7878j;

/* renamed from: com.google.android.gms.internal.n.b */
public final class C8221b extends C4785j<C5070r> {
    /* renamed from: e */
    private final Context f32368e;
    /* renamed from: f */
    private final int f32369f;
    /* renamed from: g */
    private final String f32370g;
    /* renamed from: h */
    private final int f32371h;
    /* renamed from: i */
    private final boolean f32372i;

    public C8221b(Context context, Looper looper, C2853f c2853f, C2775b c2775b, C2776c c2776c, int i, int i2, boolean z) {
        super(context, looper, 4, c2853f, c2775b, c2776c);
        this.f32368e = context;
        this.f32369f = i;
        this.f32370g = c2853f.a();
        this.f32371h = i2;
        this.f32372i = z;
    }

    /* renamed from: e */
    private final Bundle m42732e() {
        int i = this.f32369f;
        String packageName = this.f32368e.getPackageName();
        Object obj = this.f32370g;
        int i2 = this.f32371h;
        boolean z = this.f32372i;
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", i);
        bundle.putBoolean("com.google.android.gms.wallet.EXTRA_USING_ANDROID_PAY_BRAND", z);
        bundle.putString("androidPackageName", packageName);
        if (!TextUtils.isEmpty(obj)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(obj, "com.google"));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", i2);
        return bundle;
    }

    /* renamed from: a */
    protected final /* synthetic */ IInterface m42733a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wallet.internal.IOwService");
        return queryLocalInterface instanceof C5070r ? (C5070r) queryLocalInterface : new C6829s(iBinder);
    }

    /* renamed from: a */
    public final void m42734a(C7874f c7874f, C2955h<Boolean> c2955h) {
        C5071t c8222d = new C8222d(c2955h);
        try {
            ((C5070r) w()).mo4773a(c7874f, m42732e(), c8222d);
        } catch (Throwable e) {
            Log.e("WalletClientImpl", "RemoteException during isReadyToPay", e);
            c8222d.mo6227a(Status.f13153c, false, Bundle.EMPTY);
        }
    }

    /* renamed from: a */
    public final void m42735a(C7878j c7878j, C2955h<C7877i> c2955h) {
        Bundle e = m42732e();
        e.putBoolean("com.google.android.gms.wallet.EXTRA_USING_AUTO_RESOLVABLE_RESULT", true);
        C5071t c8223e = new C8223e(c2955h);
        try {
            ((C5070r) w()).mo4774a(c7878j, e, c8223e);
        } catch (Throwable e2) {
            Log.e("WalletClientImpl", "RemoteException getting payment data", e2);
            c8223e.mo6226a(Status.f13153c, null, Bundle.EMPTY);
        }
    }

    /* renamed from: b */
    protected final String m42736b() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    /* renamed from: f */
    public final int m42737f() {
        return C2832i.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    protected final String q_() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    /* renamed from: x */
    public final boolean m42738x() {
        return true;
    }
}
