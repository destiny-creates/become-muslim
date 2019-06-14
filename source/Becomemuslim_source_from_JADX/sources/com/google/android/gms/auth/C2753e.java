package com.google.android.gms.auth;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.C2773a;
import com.google.android.gms.common.C2832i;
import com.google.android.gms.common.internal.C2859l;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.p178b.C2823a;
import java.io.IOException;

/* renamed from: com.google.android.gms.auth.e */
public class C2753e {
    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public static final String f7044a = "callerUid";
    @SuppressLint({"InlinedApi"})
    /* renamed from: b */
    public static final String f7045b = "androidPackageName";
    /* renamed from: c */
    private static final String[] f7046c = new String[]{"com.google", "com.google.work", "cn.google"};
    /* renamed from: d */
    private static final ComponentName f7047d = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    /* renamed from: e */
    private static final C2823a f7048e = new C2823a("Auth", "GoogleAuthUtil");

    /* renamed from: b */
    public static String m7844b(Context context, Account account, String str) {
        return C2753e.m7839a(context, account, str, new Bundle());
    }

    /* renamed from: a */
    public static String m7839a(Context context, Account account, String str, Bundle bundle) {
        C2753e.m7840a(account);
        return C2753e.m7842b(context, account, str, bundle).m16648a();
    }

    /* renamed from: b */
    public static TokenData m7842b(Context context, Account account, String str, Bundle bundle) {
        C2872v.m8393c("Calling this from your main thread can lead to deadlock");
        C2872v.m8383a(str, (Object) "Scope cannot be empty or null.");
        C2753e.m7840a(account);
        C2753e.m7841a(context, 8400000);
        bundle = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str2);
        if (TextUtils.isEmpty(bundle.getString(f7045b))) {
            bundle.putString(f7045b, str2);
        }
        bundle.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        return (TokenData) C2753e.m7837a(context, f7047d, new C4322f(account, str, bundle));
    }

    /* renamed from: b */
    public static void m7845b(Context context, String str) {
        C2872v.m8393c("Calling this from your main thread can lead to deadlock");
        C2753e.m7841a(context, 8400000);
        Bundle bundle = new Bundle();
        String str2 = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str2);
        if (!bundle.containsKey(f7045b)) {
            bundle.putString(f7045b, str2);
        }
        C2753e.m7837a(context, f7047d, new C4323g(str, bundle));
    }

    /* renamed from: a */
    private static void m7840a(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        } else if (TextUtils.isEmpty(account.name)) {
            throw new IllegalArgumentException("Account name cannot be empty!");
        } else {
            String[] strArr = f7046c;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                if (!strArr[i].equals(account.type)) {
                    i++;
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException("Account type not supported");
        }
    }

    /* renamed from: a */
    private static void m7841a(Context context, int i) {
        try {
            C2832i.ensurePlayServicesAvailable(context.getApplicationContext(), i);
        } catch (Context context2) {
            throw new C4756c(context2.m14351a(), context2.getMessage(), context2.m8402b());
        } catch (Context context22) {
            throw new C2727a(context22.getMessage());
        }
    }

    /* renamed from: b */
    private static <T> T m7843b(T t) {
        if (t != null) {
            return t;
        }
        f7048e.m8116c("GoogleAuthUtil", "Binder call returned null.");
        throw new IOException("Service unavailable.");
    }

    /* renamed from: a */
    private static <T> T m7837a(Context context, ComponentName componentName, C2754h<T> c2754h) {
        ServiceConnection c2773a = new C2773a();
        context = C2859l.m8356a(context);
        if (context.m8358a(componentName, c2773a, "GoogleAuthUtil")) {
            try {
                c2754h = c2754h.mo2368a(c2773a.m7890a());
                context.m8360b(componentName, c2773a, "GoogleAuthUtil");
                return c2754h;
            } catch (C2754h<T> c2754h2) {
                f7048e.m8115b("GoogleAuthUtil", "Error on service connection.", c2754h2);
                throw new IOException("Error on service connection.", c2754h2);
            } catch (Throwable th) {
                context.m8360b(componentName, c2773a, "GoogleAuthUtil");
            }
        } else {
            throw new IOException("Could not bind to service.");
        }
    }
}
