package host.exp.exponent.p344h;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import host.exp.exponent.p334a.C6289b;
import host.exp.p333a.C6263a;
import host.exp.p333a.C6279c.C6277f;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.inject.C6562a;
import org.json.JSONObject;

/* compiled from: ExponentSharedPreferences */
/* renamed from: host.exp.exponent.h.d */
public class C6373d {
    /* renamed from: a */
    private static final String f20641a = "d";
    /* renamed from: b */
    private static final Map<String, Boolean> f20642b = new HashMap();
    /* renamed from: c */
    private SharedPreferences f20643c;
    /* renamed from: d */
    private Context f20644d;

    /* compiled from: ExponentSharedPreferences */
    /* renamed from: host.exp.exponent.h.d$a */
    public static class C6372a {
        /* renamed from: a */
        public final JSONObject f20639a;
        /* renamed from: b */
        public final String f20640b;

        C6372a(JSONObject jSONObject, String str) {
            this.f20639a = jSONObject;
            this.f20640b = str;
        }
    }

    static {
        f20642b.put("use_internet_kernel", Boolean.valueOf(C6263a.f20399a));
        f20642b.put("has_saved_shortcut", Boolean.valueOf(false));
        f20642b.put("is_first_kernel_run", Boolean.valueOf(true));
        f20642b.put("nux_has_finished_first_run", Boolean.valueOf(false));
        f20642b.put("should_not_use_kernel_cache", Boolean.valueOf(false));
    }

    @C6562a
    public C6373d(Context context) {
        this.f20643c = context.getSharedPreferences(context.getString(C6277f.preference_file_key), 0);
        this.f20644d = context;
    }

    /* renamed from: a */
    public Context m26149a() {
        return this.f20644d;
    }

    /* renamed from: a */
    public boolean m26155a(String str) {
        return this.f20643c.getBoolean(str, ((Boolean) f20642b.get(str)).booleanValue());
    }

    /* renamed from: a */
    public void m26153a(String str, boolean z) {
        this.f20643c.edit().putBoolean(str, z).apply();
    }

    /* renamed from: b */
    public String m26156b(String str) {
        return m26150a(str, null);
    }

    /* renamed from: a */
    public String m26150a(String str, String str2) {
        return this.f20643c.getString(str, str2);
    }

    /* renamed from: b */
    public void m26157b(String str, String str2) {
        this.f20643c.edit().putString(str, str2).apply();
    }

    /* renamed from: b */
    public boolean m26159b() {
        return m26155a("use_internet_kernel");
    }

    /* renamed from: c */
    public boolean m26161c() {
        return m26155a("has_saved_shortcut");
    }

    /* renamed from: d */
    public String m26162d() {
        return this.f20643c.getString("uuid", null);
    }

    /* renamed from: e */
    public String m26164e() {
        String string = this.f20643c.getString("uuid", null);
        if (string != null) {
            return string;
        }
        string = UUID.randomUUID().toString();
        m26157b("uuid", string);
        return string;
    }

    /* renamed from: a */
    public void m26154a(JSONObject jSONObject) {
        m26157b("expo_auth_session", jSONObject.toString());
    }

    /* renamed from: f */
    public void m26166f() {
        m26157b("expo_auth_session", null);
    }

    /* renamed from: g */
    public String m26167g() {
        String b = m26156b("expo_auth_session");
        if (b == null) {
            return null;
        }
        try {
            return new JSONObject(b).getString("sessionSecret");
        } catch (Throwable e) {
            C6289b.m25950a(f20641a, e);
            return null;
        }
    }

    /* renamed from: a */
    public void m26152a(String str, JSONObject jSONObject, String str2) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("manifest", jSONObject);
            jSONObject2.put("bundleUrl", str2);
            jSONObject2.put("safe_manifest", jSONObject);
            this.f20643c.edit().putString(str, jSONObject2.toString()).apply();
        } catch (Throwable e) {
            C6289b.m25950a(f20641a, e);
        }
    }

    /* renamed from: c */
    public C6372a m26160c(String str) {
        str = this.f20643c.getString(str, null);
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new C6372a(jSONObject.getJSONObject("manifest"), jSONObject.getString("bundleUrl"));
        } catch (Throwable e) {
            C6289b.m25950a(f20641a, e);
            return null;
        }
    }

    /* renamed from: a */
    public void m26151a(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2;
            String string = this.f20643c.getString(str, null);
            if (string != null) {
                jSONObject2 = new JSONObject(string);
            } else {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("safe_manifest", jSONObject);
            this.f20643c.edit().putString(str, jSONObject2.toString()).apply();
        } catch (Throwable e) {
            C6289b.m25950a(f20641a, e);
        }
    }

    /* renamed from: d */
    public String m26163d(String str) {
        str = this.f20643c.getString(str, null);
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str).getString("safe_manifest");
        } catch (Throwable e) {
            C6289b.m25950a(f20641a, e);
            return null;
        }
    }

    /* renamed from: b */
    public void m26158b(String str, JSONObject jSONObject) {
        Editor edit = this.f20643c.edit();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("experience_metadata_");
        stringBuilder.append(str);
        edit.putString(stringBuilder.toString(), jSONObject.toString()).apply();
    }

    /* renamed from: e */
    public JSONObject m26165e(String str) {
        SharedPreferences sharedPreferences = this.f20643c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("experience_metadata_");
        stringBuilder.append(str);
        str = sharedPreferences.getString(stringBuilder.toString(), null);
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable e) {
            C6289b.m25950a(f20641a, e);
            return null;
        }
    }
}
