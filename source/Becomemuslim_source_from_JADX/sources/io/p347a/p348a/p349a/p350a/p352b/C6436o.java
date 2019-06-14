package io.p347a.p348a.p349a.p350a.p352b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6520i;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* compiled from: IdManager */
/* renamed from: io.a.a.a.a.b.o */
public class C6436o {
    /* renamed from: d */
    private static final Pattern f20789d = Pattern.compile("[^\\p{Alnum}]");
    /* renamed from: e */
    private static final String f20790e = Pattern.quote("/");
    /* renamed from: a */
    C6419c f20791a;
    /* renamed from: b */
    C6418b f20792b;
    /* renamed from: c */
    boolean f20793c;
    /* renamed from: f */
    private final ReentrantLock f20794f = new ReentrantLock();
    /* renamed from: g */
    private final C6437p f20795g;
    /* renamed from: h */
    private final boolean f20796h;
    /* renamed from: i */
    private final boolean f20797i;
    /* renamed from: j */
    private final Context f20798j;
    /* renamed from: k */
    private final String f20799k;
    /* renamed from: l */
    private final String f20800l;
    /* renamed from: m */
    private final Collection<C6520i> f20801m;

    /* compiled from: IdManager */
    /* renamed from: io.a.a.a.a.b.o$a */
    public enum C6435a {
        WIFI_MAC_ADDRESS(1),
        BLUETOOTH_MAC_ADDRESS(2),
        FONT_TOKEN(53),
        ANDROID_ID(100),
        ANDROID_DEVICE_ID(101),
        ANDROID_SERIAL(102),
        ANDROID_ADVERTISING_ID(103);
        
        /* renamed from: h */
        public final int f20788h;

        private C6435a(int i) {
            this.f20788h = i;
        }
    }

    public C6436o(Context context, String str, String str2, Collection<C6520i> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        } else if (collection != null) {
            this.f20798j = context;
            this.f20799k = str;
            this.f20800l = str2;
            this.f20801m = collection;
            this.f20795g = new C6437p();
            this.f20791a = new C6419c(context);
            this.f20796h = C6428i.m26370a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
            if (this.f20796h == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Device ID collection disabled for ");
                stringBuilder.append(context.getPackageName());
                C6514c.m26634h().mo5472a("Fabric", stringBuilder.toString());
            }
            this.f20797i = C6428i.m26370a(context, "com.crashlytics.CollectUserIdentifiers", true);
            if (this.f20797i == null) {
                collection = new StringBuilder();
                collection.append("User information collection disabled for ");
                collection.append(context.getPackageName());
                C6514c.m26634h().mo5472a("Fabric", collection.toString());
            }
        } else {
            throw new IllegalArgumentException("kits must not be null");
        }
    }

    /* renamed from: a */
    public boolean m26405a() {
        return this.f20797i;
    }

    /* renamed from: a */
    private String m26402a(String str) {
        return str == null ? null : f20789d.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    /* renamed from: b */
    public String m26406b() {
        String str = this.f20800l;
        if (str != null) {
            return str;
        }
        SharedPreferences a = C6428i.m26353a(this.f20798j);
        String string = a.getString("crashlytics.installation.id", null);
        return string == null ? m26401a(a) : string;
    }

    /* renamed from: c */
    public String m26407c() {
        return this.f20799k;
    }

    /* renamed from: d */
    public String m26408d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m26409e());
        stringBuilder.append("/");
        stringBuilder.append(m26410f());
        return stringBuilder.toString();
    }

    /* renamed from: e */
    public String m26409e() {
        return m26404b(VERSION.RELEASE);
    }

    /* renamed from: f */
    public String m26410f() {
        return m26404b(VERSION.INCREMENTAL);
    }

    /* renamed from: g */
    public String m26411g() {
        return String.format(Locale.US, "%s/%s", new Object[]{m26404b(Build.MANUFACTURER), m26404b(Build.MODEL)});
    }

    /* renamed from: b */
    private String m26404b(String str) {
        return str.replaceAll(f20790e, "");
    }

    /* renamed from: h */
    public String m26412h() {
        String str = "";
        if (!this.f20796h) {
            return str;
        }
        str = m26418n();
        if (str != null) {
            return str;
        }
        SharedPreferences a = C6428i.m26353a(this.f20798j);
        String string = a.getString("crashlytics.installation.id", null);
        return string == null ? m26401a(a) : string;
    }

    /* renamed from: a */
    private String m26401a(SharedPreferences sharedPreferences) {
        this.f20794f.lock();
        try {
            String string = sharedPreferences.getString("crashlytics.installation.id", null);
            if (string == null) {
                string = m26402a(UUID.randomUUID().toString());
                sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
            }
            this.f20794f.unlock();
            return string;
        } catch (Throwable th) {
            this.f20794f.unlock();
        }
    }

    /* renamed from: i */
    public Map<C6435a, String> m26413i() {
        Map hashMap = new HashMap();
        for (C6520i c6520i : this.f20801m) {
            if (c6520i instanceof C6432m) {
                for (Entry entry : ((C6432m) c6520i).m26395e().entrySet()) {
                    m26403a(hashMap, (C6435a) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        m26403a(hashMap, C6435a.ANDROID_ID, m26418n());
        m26403a(hashMap, C6435a.ANDROID_ADVERTISING_ID, m26417m());
        return Collections.unmodifiableMap(hashMap);
    }

    /* renamed from: j */
    public String m26414j() {
        return this.f20795g.m26419a(this.f20798j);
    }

    /* renamed from: k */
    synchronized C6418b m26415k() {
        if (!this.f20793c) {
            this.f20792b = this.f20791a.m26332a();
            this.f20793c = true;
        }
        return this.f20792b;
    }

    /* renamed from: l */
    public Boolean m26416l() {
        if (this.f20796h) {
            C6418b k = m26415k();
            if (k != null) {
                return Boolean.valueOf(k.f20749b);
            }
        }
        return null;
    }

    /* renamed from: m */
    public String m26417m() {
        if (this.f20796h) {
            C6418b k = m26415k();
            if (k != null) {
                return k.f20748a;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m26403a(Map<C6435a, String> map, C6435a c6435a, String str) {
        if (str != null) {
            map.put(c6435a, str);
        }
    }

    /* renamed from: n */
    public String m26418n() {
        if (this.f20796h) {
            String string = Secure.getString(this.f20798j.getContentResolver(), "android_id");
            if (!"9774d56d682e549c".equals(string)) {
                return m26402a(string);
            }
        }
        return null;
    }
}
