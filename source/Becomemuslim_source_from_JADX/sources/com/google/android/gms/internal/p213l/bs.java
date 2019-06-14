package com.google.android.gms.internal.p213l;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.p180d.C2828b;
import com.google.android.gms.common.p180d.C2829c;
import com.google.android.gms.common.stats.C2882a;
import java.util.List;

/* renamed from: com.google.android.gms.internal.l.bs */
public final class bs {
    /* renamed from: a */
    volatile gv f17010a;
    /* renamed from: b */
    private final cg f17011b;
    /* renamed from: c */
    private ServiceConnection f17012c;

    bs(cg cgVar) {
        this.f17011b = cgVar;
    }

    /* renamed from: c */
    private final boolean m21327c() {
        boolean z = false;
        try {
            C2828b a = C2829c.a(this.f17011b.mo4752n());
            if (a == null) {
                this.f17011b.mo4754r().m42567k().m21307a("Failed to retrieve Package Manager to check Play Store compatibility");
                return false;
            }
            if (a.b("com.android.vending", 128).versionCode >= 80837300) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            this.f17011b.mo4754r().m42567k().m21308a("Failed to retrieve Play Store version", e);
            return false;
        }
    }

    /* renamed from: a */
    protected final void m21328a() {
        this.f17011b.mo4755u();
        this.f17011b.mo4753q().mo6210d();
        if (m21327c()) {
            this.f17012c = new bu();
            this.f17011b.mo4754r().m42567k().m21307a("Install Referrer Reporter is initializing");
            this.f17011b.mo4753q().mo6210d();
            Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
            intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
            PackageManager packageManager = this.f17011b.mo4752n().getPackageManager();
            if (packageManager == null) {
                this.f17011b.mo4754r().m42565i().m21307a("Failed to obtain Package Manager to verify binding conditions");
                return;
            }
            List queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                this.f17011b.mo4754r().m42567k().m21307a("Play Service for fetching Install Referrer is unavailable on device");
                return;
            }
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentServices.get(0);
            if (resolveInfo.serviceInfo != null) {
                String str = resolveInfo.serviceInfo.packageName;
                if (resolveInfo.serviceInfo.name == null || this.f17012c == null || !"com.android.vending".equals(str) || !m21327c()) {
                    this.f17011b.mo4754r().m42567k().m21307a("Play Store missing or incompatible. Version 8.3.73 or later required");
                } else {
                    try {
                        this.f17011b.mo4754r().m42567k().m21308a("Install Referrer Service is", C2882a.a().a(this.f17011b.mo4752n(), new Intent(intent), this.f17012c, 1) ? "available" : "not available");
                        return;
                    } catch (Exception e) {
                        this.f17011b.mo4754r().I_().m21308a("Exception occurred while binding to Install Referrer Service", e.getMessage());
                        return;
                    }
                }
            }
            return;
        }
        this.f17011b.mo4754r().m42567k().m21307a("Install Referrer Reporter is not available");
        this.f17012c = null;
    }

    /* renamed from: a */
    final void m21329a(Bundle bundle) {
        this.f17011b.mo4753q().mo6210d();
        if (bundle != null) {
            bd I_;
            String str;
            long j = bundle.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                I_ = this.f17011b.mo4754r().I_();
                str = "Service response is missing Install Referrer install timestamp";
            } else {
                str = bundle.getString("install_referrer");
                if (str != null) {
                    if (!str.isEmpty()) {
                        this.f17011b.mo4754r().m42579w().m21308a("InstallReferrer API result", str);
                        fw k = this.f17011b.m31969k();
                        String str2 = "?";
                        str = String.valueOf(str);
                        Bundle a = k.m42656a(Uri.parse(str.length() != 0 ? str2.concat(str) : new String(str2)));
                        if (a == null) {
                            I_ = this.f17011b.mo4754r().I_();
                            str = "No campaign params defined in install referrer result";
                        } else {
                            String string = a.getString("medium");
                            Object obj = (string == null || "(not set)".equalsIgnoreCase(string) || "organic".equalsIgnoreCase(string)) ? null : 1;
                            if (obj != null) {
                                long j2 = bundle.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                                if (j2 == 0) {
                                    I_ = this.f17011b.mo4754r().I_();
                                    str = "Install Referrer is missing click timestamp for ad campaign";
                                } else {
                                    a.putLong("click_timestamp", j2);
                                }
                            }
                            if (j == this.f17011b.m31961c().f32332i.m21318a()) {
                                I_ = this.f17011b.mo4754r().m42579w();
                                str = "Campaign has already been logged";
                            } else {
                                a.putString("_cis", "referrer API");
                                this.f17011b.m31961c().f32332i.m21319a(j);
                                this.f17011b.m31966h().m44099a("auto", "_cmp", a);
                                if (this.f17012c != null) {
                                    C2882a.a().a(this.f17011b.mo4752n(), this.f17012c);
                                }
                                return;
                            }
                        }
                    }
                }
                I_ = this.f17011b.mo4754r().I_();
                str = "No referrer defined in install referrer response";
            }
            I_.m21307a(str);
        }
    }

    /* renamed from: b */
    final Bundle m21330b() {
        this.f17011b.mo4753q().mo6210d();
        if (this.f17010a == null) {
            this.f17011b.mo4754r().m42565i().m21307a("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.f17011b.mo4752n().getPackageName());
        try {
            bundle = this.f17010a.mo4764a(bundle);
            if (bundle != null) {
                return bundle;
            }
            this.f17011b.mo4754r().I_().m21307a("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e) {
            this.f17011b.mo4754r().I_().m21308a("Exception occurred while retrieving the Install Referrer", e.getMessage());
            return null;
        }
    }
}
