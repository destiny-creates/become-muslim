package com.google.android.gms.p185e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.C2872v;
import java.util.Random;

/* renamed from: com.google.android.gms.e.m */
public final class C2941m {
    /* renamed from: a */
    private final Context f7580a;
    /* renamed from: b */
    private final Random f7581b;
    /* renamed from: c */
    private final String f7582c;

    public C2941m(Context context, String str) {
        this(context, str, new Random());
    }

    private C2941m(Context context, String str, Random random) {
        this.f7580a = (Context) C2872v.m8380a((Object) context);
        this.f7582c = (String) C2872v.m8380a((Object) str);
        this.f7581b = random;
    }

    /* renamed from: a */
    public final long m8755a() {
        return m8753a(7200000, 259200000) + 43200000;
    }

    /* renamed from: b */
    public final long m8756b() {
        return m8753a(600000, 86400000) + 3600000;
    }

    /* renamed from: a */
    private final long m8753a(long j, long j2) {
        SharedPreferences e = m8754e();
        long max = Math.max(0, e.getLong("FORBIDDEN_COUNT", 0));
        return (long) (this.f7581b.nextFloat() * ((float) (j + ((long) ((((float) max) / ((float) ((max + Math.max(0, e.getLong("SUCCESSFUL_COUNT", 0))) + 1))) * ((float) (j2 - j)))))));
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: c */
    public final void m8757c() {
        SharedPreferences e = m8754e();
        long j = e.getLong("FORBIDDEN_COUNT", 0);
        long j2 = e.getLong("SUCCESSFUL_COUNT", 0);
        Editor edit = e.edit();
        if (j == 0) {
            j = 3;
        } else {
            j = Math.min(10, j + 1);
        }
        long max = Math.max(0, Math.min(j2, 10 - j));
        edit.putLong("FORBIDDEN_COUNT", j);
        edit.putLong("SUCCESSFUL_COUNT", max);
        edit.apply();
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: d */
    public final void m8758d() {
        SharedPreferences e = m8754e();
        long j = e.getLong("SUCCESSFUL_COUNT", 0);
        long j2 = e.getLong("FORBIDDEN_COUNT", 0);
        j = Math.min(10, j + 1);
        long max = Math.max(0, Math.min(j2, 10 - j));
        Editor edit = e.edit();
        edit.putLong("SUCCESSFUL_COUNT", j);
        edit.putLong("FORBIDDEN_COUNT", max);
        edit.apply();
    }

    /* renamed from: e */
    private final SharedPreferences m8754e() {
        Context context = this.f7580a;
        String valueOf = String.valueOf("_gtmContainerRefreshPolicy_");
        String valueOf2 = String.valueOf(this.f7582c);
        return context.getSharedPreferences(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), 0);
    }
}
