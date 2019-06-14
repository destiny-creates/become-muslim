package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.util.C2904o;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

@cm
public final class jp {
    /* renamed from: a */
    Editor f15667a;
    /* renamed from: b */
    private final Object f15668b = new Object();
    /* renamed from: c */
    private no<?> f15669c;
    /* renamed from: d */
    private CopyOnWriteArraySet<jt> f15670d = new CopyOnWriteArraySet();
    /* renamed from: e */
    private SharedPreferences f15671e;
    /* renamed from: f */
    private boolean f15672f = false;
    /* renamed from: g */
    private boolean f15673g = true;
    /* renamed from: h */
    private String f15674h;
    /* renamed from: i */
    private String f15675i;
    /* renamed from: j */
    private boolean f15676j = false;
    /* renamed from: k */
    private String f15677k = "";
    /* renamed from: l */
    private long f15678l = 0;
    /* renamed from: m */
    private long f15679m = 0;
    /* renamed from: n */
    private long f15680n = 0;
    /* renamed from: o */
    private int f15681o = -1;
    /* renamed from: p */
    private int f15682p = 0;
    /* renamed from: q */
    private Set<String> f15683q = Collections.emptySet();
    /* renamed from: r */
    private JSONObject f15684r = new JSONObject();
    /* renamed from: s */
    private boolean f15685s = true;
    /* renamed from: t */
    private boolean f15686t = true;

    /* renamed from: a */
    private final void m19615a(Bundle bundle) {
        new jr(this, bundle).mo3819c();
    }

    @TargetApi(23)
    /* renamed from: n */
    private static boolean m19640n() {
        return C2904o.j() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    /* renamed from: o */
    private final void m19642o() {
        if (this.f15669c != null && !this.f15669c.isDone()) {
            try {
                this.f15669c.get(1, TimeUnit.SECONDS);
            } catch (Throwable e) {
                Thread.currentThread().interrupt();
                mt.m19921c("Interrupted while waiting for preferences loaded.", e);
            } catch (Throwable e2) {
                mt.m19919b("Fail to initialize AdSharedPreferenceManager.", e2);
            }
        }
    }

    /* renamed from: p */
    private final Bundle m19643p() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("listener_registration_bundle", true);
        synchronized (this.f15668b) {
            bundle.putBoolean("use_https", this.f15673g);
            bundle.putBoolean("content_url_opted_out", this.f15685s);
            bundle.putBoolean("content_vertical_opted_out", this.f15686t);
            bundle.putBoolean("auto_collect_location", this.f15676j);
            bundle.putInt("version_code", this.f15682p);
            bundle.putStringArray("never_pool_slots", (String[]) this.f15683q.toArray(new String[this.f15683q.size()]));
            bundle.putString("app_settings_json", this.f15677k);
            bundle.putLong("app_settings_last_update_ms", this.f15678l);
            bundle.putLong("app_last_background_time_ms", this.f15679m);
            bundle.putInt("request_in_session_count", this.f15681o);
            bundle.putLong("first_ad_req_time_ms", this.f15680n);
            bundle.putString("native_advanced_settings", this.f15684r.toString());
            if (this.f15674h != null) {
                bundle.putString("content_url_hashes", this.f15674h);
            }
            if (this.f15675i != null) {
                bundle.putString("content_vertical_hashes", this.f15675i);
            }
        }
        return bundle;
    }

    /* renamed from: a */
    public final void m19647a(int i) {
        m19642o();
        synchronized (this.f15668b) {
            if (this.f15682p == i) {
                return;
            }
            this.f15682p = i;
            if (this.f15667a != null) {
                this.f15667a.putInt("version_code", i);
                this.f15667a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("version_code", i);
            m19615a(bundle);
        }
    }

    /* renamed from: a */
    public final void m19648a(long j) {
        m19642o();
        synchronized (this.f15668b) {
            if (this.f15679m == j) {
                return;
            }
            this.f15679m = j;
            if (this.f15667a != null) {
                this.f15667a.putLong("app_last_background_time_ms", j);
                this.f15667a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("app_last_background_time_ms", j);
            m19615a(bundle);
        }
    }

    /* renamed from: a */
    public final void m19649a(Context context) {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.f15669c = (no) new jq(this, context).mo3819c();
    }

    /* renamed from: a */
    public final void m19650a(jt jtVar) {
        synchronized (this.f15668b) {
            if (this.f15669c != null && this.f15669c.isDone()) {
                jtVar.mo4303a(m19643p());
            }
            this.f15670d.add(jtVar);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void m19651a(java.lang.String r4) {
        /*
        r3 = this;
        r3.m19642o();
        r0 = r3.f15668b;
        monitor-enter(r0);
        if (r4 == 0) goto L_0x0034;
    L_0x0008:
        r1 = r3.f15674h;	 Catch:{ all -> 0x0032 }
        r1 = r4.equals(r1);	 Catch:{ all -> 0x0032 }
        if (r1 == 0) goto L_0x0011;
    L_0x0010:
        goto L_0x0034;
    L_0x0011:
        r3.f15674h = r4;	 Catch:{ all -> 0x0032 }
        r1 = r3.f15667a;	 Catch:{ all -> 0x0032 }
        if (r1 == 0) goto L_0x0023;
    L_0x0017:
        r1 = r3.f15667a;	 Catch:{ all -> 0x0032 }
        r2 = "content_url_hashes";
        r1.putString(r2, r4);	 Catch:{ all -> 0x0032 }
        r1 = r3.f15667a;	 Catch:{ all -> 0x0032 }
        r1.apply();	 Catch:{ all -> 0x0032 }
    L_0x0023:
        r1 = new android.os.Bundle;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = "content_url_hashes";
        r1.putString(r2, r4);	 Catch:{ all -> 0x0032 }
        r3.m19615a(r1);	 Catch:{ all -> 0x0032 }
        monitor-exit(r0);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0032:
        r4 = move-exception;
        goto L_0x0036;
    L_0x0034:
        monitor-exit(r0);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0036:
        monitor-exit(r0);	 Catch:{ all -> 0x0032 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jp.a(java.lang.String):void");
    }

    /* renamed from: a */
    public final void m19652a(String str, String str2, boolean z) {
        m19642o();
        synchronized (this.f15668b) {
            JSONArray optJSONArray = this.f15684r.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            int i = 0;
            while (i < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject == null) {
                    return;
                } else if (!str2.equals(optJSONObject.optString("template_id"))) {
                    i++;
                } else if (z && optJSONObject.optBoolean("uses_media_view", false) == z) {
                    return;
                } else {
                    length = i;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", ax.l().a());
                optJSONArray.put(length, jSONObject);
                this.f15684r.put(str, optJSONArray);
            } catch (Throwable e) {
                mt.m19921c("Could not update native advanced settings", e);
            }
            if (this.f15667a != null) {
                this.f15667a.putString("native_advanced_settings", this.f15684r.toString());
                this.f15667a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", this.f15684r.toString());
            m19615a(bundle);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void m19653a(boolean r4) {
        /*
        r3 = this;
        r3.m19642o();
        r0 = r3.f15668b;
        monitor-enter(r0);
        r1 = r3.f15673g;	 Catch:{ all -> 0x0031 }
        if (r1 != r4) goto L_0x000c;
    L_0x000a:
        monitor-exit(r0);	 Catch:{ all -> 0x0031 }
        return;
    L_0x000c:
        r3.f15673g = r4;	 Catch:{ all -> 0x0031 }
        r1 = r3.f15667a;	 Catch:{ all -> 0x0031 }
        if (r1 == 0) goto L_0x001e;
    L_0x0012:
        r1 = r3.f15667a;	 Catch:{ all -> 0x0031 }
        r2 = "use_https";
        r1.putBoolean(r2, r4);	 Catch:{ all -> 0x0031 }
        r1 = r3.f15667a;	 Catch:{ all -> 0x0031 }
        r1.apply();	 Catch:{ all -> 0x0031 }
    L_0x001e:
        r1 = r3.f15672f;	 Catch:{ all -> 0x0031 }
        if (r1 != 0) goto L_0x002f;
    L_0x0022:
        r1 = new android.os.Bundle;	 Catch:{ all -> 0x0031 }
        r1.<init>();	 Catch:{ all -> 0x0031 }
        r2 = "use_https";
        r1.putBoolean(r2, r4);	 Catch:{ all -> 0x0031 }
        r3.m19615a(r1);	 Catch:{ all -> 0x0031 }
    L_0x002f:
        monitor-exit(r0);	 Catch:{ all -> 0x0031 }
        return;
    L_0x0031:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0031 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jp.a(boolean):void");
    }

    /* renamed from: a */
    public final boolean m19654a() {
        boolean z;
        m19642o();
        synchronized (this.f15668b) {
            if (!this.f15673g) {
                if (!this.f15672f) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public final void m19655b(int i) {
        m19642o();
        synchronized (this.f15668b) {
            if (this.f15681o == i) {
                return;
            }
            this.f15681o = i;
            if (this.f15667a != null) {
                this.f15667a.putInt("request_in_session_count", i);
                this.f15667a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putInt("request_in_session_count", i);
            m19615a(bundle);
        }
    }

    /* renamed from: b */
    public final void m19656b(long j) {
        m19642o();
        synchronized (this.f15668b) {
            if (this.f15680n == j) {
                return;
            }
            this.f15680n = j;
            if (this.f15667a != null) {
                this.f15667a.putLong("first_ad_req_time_ms", j);
                this.f15667a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("first_ad_req_time_ms", j);
            m19615a(bundle);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final void m19657b(java.lang.String r4) {
        /*
        r3 = this;
        r3.m19642o();
        r0 = r3.f15668b;
        monitor-enter(r0);
        if (r4 == 0) goto L_0x0034;
    L_0x0008:
        r1 = r3.f15675i;	 Catch:{ all -> 0x0032 }
        r1 = r4.equals(r1);	 Catch:{ all -> 0x0032 }
        if (r1 == 0) goto L_0x0011;
    L_0x0010:
        goto L_0x0034;
    L_0x0011:
        r3.f15675i = r4;	 Catch:{ all -> 0x0032 }
        r1 = r3.f15667a;	 Catch:{ all -> 0x0032 }
        if (r1 == 0) goto L_0x0023;
    L_0x0017:
        r1 = r3.f15667a;	 Catch:{ all -> 0x0032 }
        r2 = "content_vertical_hashes";
        r1.putString(r2, r4);	 Catch:{ all -> 0x0032 }
        r1 = r3.f15667a;	 Catch:{ all -> 0x0032 }
        r1.apply();	 Catch:{ all -> 0x0032 }
    L_0x0023:
        r1 = new android.os.Bundle;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = "content_vertical_hashes";
        r1.putString(r2, r4);	 Catch:{ all -> 0x0032 }
        r3.m19615a(r1);	 Catch:{ all -> 0x0032 }
        monitor-exit(r0);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0032:
        r4 = move-exception;
        goto L_0x0036;
    L_0x0034:
        monitor-exit(r0);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0036:
        monitor-exit(r0);	 Catch:{ all -> 0x0032 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jp.b(java.lang.String):void");
    }

    /* renamed from: b */
    public final void m19658b(boolean z) {
        m19642o();
        synchronized (this.f15668b) {
            if (this.f15685s == z) {
                return;
            }
            this.f15685s = z;
            if (this.f15667a != null) {
                this.f15667a.putBoolean("content_url_opted_out", z);
                this.f15667a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", this.f15685s);
            bundle.putBoolean("content_vertical_opted_out", this.f15686t);
            m19615a(bundle);
        }
    }

    /* renamed from: b */
    public final boolean m19659b() {
        boolean z;
        m19642o();
        synchronized (this.f15668b) {
            z = this.f15685s;
        }
        return z;
    }

    /* renamed from: c */
    public final String m19660c() {
        String str;
        m19642o();
        synchronized (this.f15668b) {
            str = this.f15674h;
        }
        return str;
    }

    /* renamed from: c */
    public final void m19661c(String str) {
        m19642o();
        synchronized (this.f15668b) {
            if (this.f15683q.contains(str)) {
                return;
            }
            this.f15683q.add(str);
            if (this.f15667a != null) {
                this.f15667a.putStringSet("never_pool_slots", this.f15683q);
                this.f15667a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putStringArray("never_pool_slots", (String[]) this.f15683q.toArray(new String[this.f15683q.size()]));
            m19615a(bundle);
        }
    }

    /* renamed from: c */
    public final void m19662c(boolean z) {
        m19642o();
        synchronized (this.f15668b) {
            if (this.f15686t == z) {
                return;
            }
            this.f15686t = z;
            if (this.f15667a != null) {
                this.f15667a.putBoolean("content_vertical_opted_out", z);
                this.f15667a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("content_url_opted_out", this.f15685s);
            bundle.putBoolean("content_vertical_opted_out", this.f15686t);
            m19615a(bundle);
        }
    }

    /* renamed from: d */
    public final void m19663d(String str) {
        m19642o();
        synchronized (this.f15668b) {
            if (this.f15683q.contains(str)) {
                this.f15683q.remove(str);
                if (this.f15667a != null) {
                    this.f15667a.putStringSet("never_pool_slots", this.f15683q);
                    this.f15667a.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("never_pool_slots", (String[]) this.f15683q.toArray(new String[this.f15683q.size()]));
                m19615a(bundle);
                return;
            }
        }
    }

    /* renamed from: d */
    public final void m19664d(boolean z) {
        m19642o();
        synchronized (this.f15668b) {
            if (this.f15676j == z) {
                return;
            }
            this.f15676j = z;
            if (this.f15667a != null) {
                this.f15667a.putBoolean("auto_collect_location", z);
                this.f15667a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("auto_collect_location", z);
            m19615a(bundle);
        }
    }

    /* renamed from: d */
    public final boolean m19665d() {
        boolean z;
        m19642o();
        synchronized (this.f15668b) {
            z = this.f15686t;
        }
        return z;
    }

    /* renamed from: e */
    public final String m19666e() {
        String str;
        m19642o();
        synchronized (this.f15668b) {
            str = this.f15675i;
        }
        return str;
    }

    /* renamed from: e */
    public final boolean m19667e(String str) {
        boolean contains;
        m19642o();
        synchronized (this.f15668b) {
            contains = this.f15683q.contains(str);
        }
        return contains;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    public final void m19668f(java.lang.String r6) {
        /*
        r5 = this;
        r5.m19642o();
        r0 = r5.f15668b;
        monitor-enter(r0);
        r1 = com.google.android.gms.ads.internal.ax.l();	 Catch:{ all -> 0x004a }
        r1 = r1.a();	 Catch:{ all -> 0x004a }
        r5.f15678l = r1;	 Catch:{ all -> 0x004a }
        if (r6 == 0) goto L_0x0048;
    L_0x0012:
        r3 = r5.f15677k;	 Catch:{ all -> 0x004a }
        r3 = r6.equals(r3);	 Catch:{ all -> 0x004a }
        if (r3 == 0) goto L_0x001b;
    L_0x001a:
        goto L_0x0048;
    L_0x001b:
        r5.f15677k = r6;	 Catch:{ all -> 0x004a }
        r3 = r5.f15667a;	 Catch:{ all -> 0x004a }
        if (r3 == 0) goto L_0x0034;
    L_0x0021:
        r3 = r5.f15667a;	 Catch:{ all -> 0x004a }
        r4 = "app_settings_json";
        r3.putString(r4, r6);	 Catch:{ all -> 0x004a }
        r3 = r5.f15667a;	 Catch:{ all -> 0x004a }
        r4 = "app_settings_last_update_ms";
        r3.putLong(r4, r1);	 Catch:{ all -> 0x004a }
        r3 = r5.f15667a;	 Catch:{ all -> 0x004a }
        r3.apply();	 Catch:{ all -> 0x004a }
    L_0x0034:
        r3 = new android.os.Bundle;	 Catch:{ all -> 0x004a }
        r3.<init>();	 Catch:{ all -> 0x004a }
        r4 = "app_settings_json";
        r3.putString(r4, r6);	 Catch:{ all -> 0x004a }
        r6 = "app_settings_last_update_ms";
        r3.putLong(r6, r1);	 Catch:{ all -> 0x004a }
        r5.m19615a(r3);	 Catch:{ all -> 0x004a }
        monitor-exit(r0);	 Catch:{ all -> 0x004a }
        return;
    L_0x0048:
        monitor-exit(r0);	 Catch:{ all -> 0x004a }
        return;
    L_0x004a:
        r6 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x004a }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jp.f(java.lang.String):void");
    }

    /* renamed from: f */
    public final boolean m19669f() {
        boolean z;
        m19642o();
        synchronized (this.f15668b) {
            z = this.f15676j;
        }
        return z;
    }

    /* renamed from: g */
    public final int m19670g() {
        int i;
        m19642o();
        synchronized (this.f15668b) {
            i = this.f15682p;
        }
        return i;
    }

    /* renamed from: h */
    public final iw m19671h() {
        iw iwVar;
        m19642o();
        synchronized (this.f15668b) {
            iwVar = new iw(this.f15677k, this.f15678l);
        }
        return iwVar;
    }

    /* renamed from: i */
    public final long m19672i() {
        long j;
        m19642o();
        synchronized (this.f15668b) {
            j = this.f15679m;
        }
        return j;
    }

    /* renamed from: j */
    public final int m19673j() {
        int i;
        m19642o();
        synchronized (this.f15668b) {
            i = this.f15681o;
        }
        return i;
    }

    /* renamed from: k */
    public final long m19674k() {
        long j;
        m19642o();
        synchronized (this.f15668b) {
            j = this.f15680n;
        }
        return j;
    }

    /* renamed from: l */
    public final JSONObject m19675l() {
        JSONObject jSONObject;
        m19642o();
        synchronized (this.f15668b) {
            jSONObject = this.f15684r;
        }
        return jSONObject;
    }

    /* renamed from: m */
    public final void m19676m() {
        m19642o();
        synchronized (this.f15668b) {
            this.f15684r = new JSONObject();
            if (this.f15667a != null) {
                this.f15667a.remove("native_advanced_settings");
                this.f15667a.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", "{}");
            m19615a(bundle);
        }
    }
}
