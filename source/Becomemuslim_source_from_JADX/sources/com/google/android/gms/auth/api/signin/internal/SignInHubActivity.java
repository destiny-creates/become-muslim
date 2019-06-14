package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.C0344z.C0343a;
import android.support.v4.app.C4890j;
import android.support.v4.content.C0369c;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

@KeepName
public class SignInHubActivity extends C4890j {
    /* renamed from: a */
    private static boolean f14119a = false;
    /* renamed from: b */
    private boolean f14120b = false;
    /* renamed from: c */
    private SignInConfiguration f14121c;
    /* renamed from: d */
    private boolean f14122d;
    /* renamed from: e */
    private int f14123e;
    /* renamed from: f */
    private Intent f14124f;

    /* renamed from: com.google.android.gms.auth.api.signin.internal.SignInHubActivity$a */
    private class C4315a implements C0343a<Void> {
        /* renamed from: a */
        private final /* synthetic */ SignInHubActivity f11366a;

        private C4315a(SignInHubActivity signInHubActivity) {
            this.f11366a = signInHubActivity;
        }

        /* renamed from: a */
        public final void mo2362a(C0369c<Void> c0369c) {
        }

        /* renamed from: a */
        public final C0369c<Void> mo2361a(int i, Bundle bundle) {
            return new C4754g(this.f11366a, GoogleApiClient.m7910a());
        }

        /* renamed from: a */
        public final /* synthetic */ void mo2363a(C0369c c0369c, Object obj) {
            this.f11366a.setResult(this.f11366a.f14123e, this.f11366a.f14124f);
            this.f11366a.finish();
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    protected void onCreate(android.os.Bundle r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r4 = this;
        super.onCreate(r5);
        r0 = r4.getIntent();
        r1 = r0.getAction();
        r2 = "com.google.android.gms.auth.NO_IMPL";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0019;
    L_0x0013:
        r5 = 12500; // 0x30d4 float:1.7516E-41 double:6.176E-320;
        r4.m17786a(r5);
        return;
    L_0x0019:
        r2 = "com.google.android.gms.auth.GOOGLE_SIGN_IN";
        r2 = r1.equals(r2);
        if (r2 != 0) goto L_0x004c;
    L_0x0021:
        r2 = "com.google.android.gms.auth.APPAUTH_SIGN_IN";
        r2 = r1.equals(r2);
        if (r2 != 0) goto L_0x004c;
    L_0x0029:
        r5 = "AuthSignInClient";
        r1 = "Unknown action: ";
        r0 = r0.getAction();
        r0 = java.lang.String.valueOf(r0);
        r2 = r0.length();
        if (r2 == 0) goto L_0x0040;
    L_0x003b:
        r0 = r1.concat(r0);
        goto L_0x0045;
    L_0x0040:
        r0 = new java.lang.String;
        r0.<init>(r1);
    L_0x0045:
        android.util.Log.e(r5, r0);
        r4.finish();
        return;
    L_0x004c:
        r2 = "config";
        r0 = r0.getBundleExtra(r2);
        r2 = "config";
        r0 = r0.getParcelable(r2);
        r0 = (com.google.android.gms.auth.api.signin.internal.SignInConfiguration) r0;
        r4.f14121c = r0;
        r0 = r4.f14121c;
        r2 = 0;
        if (r0 != 0) goto L_0x006f;
    L_0x0061:
        r5 = "AuthSignInClient";
        r0 = "Activity started with invalid configuration.";
        android.util.Log.e(r5, r0);
        r4.setResult(r2);
        r4.finish();
        return;
    L_0x006f:
        r0 = 1;
        if (r5 != 0) goto L_0x0074;
    L_0x0072:
        r3 = 1;
        goto L_0x0075;
    L_0x0074:
        r3 = 0;
    L_0x0075:
        if (r3 == 0) goto L_0x00bd;
    L_0x0077:
        r5 = f14119a;
        if (r5 == 0) goto L_0x0084;
    L_0x007b:
        r4.setResult(r2);
        r5 = 12502; // 0x30d6 float:1.7519E-41 double:6.177E-320;
        r4.m17786a(r5);
        return;
    L_0x0084:
        f14119a = r0;
        r5 = new android.content.Intent;
        r5.<init>(r1);
        r2 = "com.google.android.gms.auth.GOOGLE_SIGN_IN";
        r1 = r1.equals(r2);
        if (r1 == 0) goto L_0x0099;
    L_0x0093:
        r1 = "com.google.android.gms";
        r5.setPackage(r1);
        goto L_0x00a0;
    L_0x0099:
        r1 = r4.getPackageName();
        r5.setPackage(r1);
    L_0x00a0:
        r1 = "config";
        r2 = r4.f14121c;
        r5.putExtra(r1, r2);
        r1 = 40962; // 0xa002 float:5.74E-41 double:2.0238E-319;
        r4.startActivityForResult(r5, r1);	 Catch:{ ActivityNotFoundException -> 0x00ae }
        return;
    L_0x00ae:
        r4.f14120b = r0;
        r5 = "AuthSignInClient";
        r0 = "Could not launch sign in Intent. Google Play Service is probably being updated...";
        android.util.Log.w(r5, r0);
        r5 = 17;
        r4.m17786a(r5);
        return;
    L_0x00bd:
        r0 = "signingInGoogleApiClients";
        r0 = r5.getBoolean(r0);
        r4.f14122d = r0;
        r0 = r4.f14122d;
        if (r0 == 0) goto L_0x00de;
    L_0x00c9:
        r0 = "signInResultCode";
        r0 = r5.getInt(r0);
        r4.f14123e = r0;
        r0 = "signInResultData";
        r5 = r5.getParcelable(r0);
        r5 = (android.content.Intent) r5;
        r4.f14124f = r5;
        r4.m17785a();
    L_0x00de:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.SignInHubActivity.onCreate(android.os.Bundle):void");
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f14122d);
        if (this.f14122d) {
            bundle.putInt("signInResultCode", this.f14123e);
            bundle.putParcelable("signInResultData", this.f14124f);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (!this.f14120b) {
            setResult(0);
            if (i == 40962) {
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
                    if (signInAccount != null && signInAccount.m16671a() != null) {
                        i = signInAccount.m16671a();
                        C2746r.m7822a(this).m7825a(this.f14121c.m16672a(), i);
                        intent.removeExtra("signInAccount");
                        intent.putExtra("googleSignInAccount", i);
                        this.f14122d = true;
                        this.f14123e = i2;
                        this.f14124f = intent;
                        m17785a();
                        return;
                    } else if (intent.hasExtra("errorCode") != 0) {
                        i = intent.getIntExtra("errorCode", 8);
                        if (i == 13) {
                            i = 12501;
                        }
                        m17786a(i);
                        return;
                    }
                }
                m17786a(8);
            }
        }
    }

    /* renamed from: a */
    private final void m17785a() {
        getSupportLoaderManager().mo175a(0, null, new C4315a());
        f14119a = false;
    }

    /* renamed from: a */
    private final void m17786a(int i) {
        Parcelable status = new Status(i);
        i = new Intent();
        i.putExtra("googleSignInStatus", status);
        setResult(0, i);
        finish();
        f14119a = false;
    }
}
