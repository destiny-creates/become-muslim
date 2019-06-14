package com.p064b.p065a.p066a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6520i;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p352b.C6429j.C7601a;
import io.p347a.p348a.p349a.p350a.p352b.C6429j.C7602b;
import io.p347a.p348a.p349a.p350a.p358g.C6504q;
import io.p347a.p348a.p349a.p350a.p358g.C6507t;
import java.io.File;

/* compiled from: Answers */
/* renamed from: com.b.a.a.a */
public class C3402a extends C6520i<Boolean> {
    /* renamed from: a */
    C3411q f9053a;

    /* renamed from: a */
    public String m10823a() {
        return "1.3.6.97";
    }

    /* renamed from: b */
    public String m10826b() {
        return "com.crashlytics.sdk.android:answers";
    }

    /* renamed from: f */
    protected /* synthetic */ Object m10829f() {
        return m10827d();
    }

    /* renamed from: a */
    public void m10825a(C7602b c7602b) {
        if (this.f9053a != null) {
            this.f9053a.m10871b(c7602b.a());
        }
    }

    /* renamed from: a */
    public void m10824a(C7601a c7601a) {
        if (this.f9053a != null) {
            this.f9053a.m10868a(c7601a.a());
        }
    }

    @SuppressLint({"NewApi"})
    protected boolean d_() {
        try {
            long j;
            Context E = E();
            PackageManager packageManager = E.getPackageManager();
            String packageName = E.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String num = Integer.toString(packageInfo.versionCode);
            String str = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (VERSION.SDK_INT >= 9) {
                j = packageInfo.firstInstallTime;
            } else {
                j = new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified();
            }
            this.f9053a = C3411q.m10864a(this, E, D(), num, str, j);
            this.f9053a.m10870b();
            return true;
        } catch (Throwable e) {
            C6514c.h().e("Answers", "Error retrieving app properties", e);
            return false;
        }
    }

    /* renamed from: d */
    protected Boolean m10827d() {
        try {
            C6507t b = C6504q.a().b();
            if (b == null) {
                C6514c.h().e("Answers", "Failed to retrieve settings");
                return Boolean.valueOf(false);
            } else if (b.f20969d.f20939d) {
                C6514c.h().a("Answers", "Analytics collection enabled");
                this.f9053a.m10867a(b.f20970e, m10828e());
                return Boolean.valueOf(true);
            } else {
                C6514c.h().a("Answers", "Analytics collection disabled");
                this.f9053a.m10873c();
                return Boolean.valueOf(false);
            }
        } catch (Throwable e) {
            C6514c.h().e("Answers", "Error dealing with settings", e);
            return Boolean.valueOf(false);
        }
    }

    /* renamed from: e */
    String m10828e() {
        return C6428i.b(E(), "com.crashlytics.ApiEndpoint");
    }
}
