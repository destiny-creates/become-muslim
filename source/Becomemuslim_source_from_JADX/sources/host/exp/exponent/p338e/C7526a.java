package host.exp.exponent.p338e;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.soloader.SoLoader;
import expo.p304a.p305a.C6002i;
import expo.p318c.p319a.C6047a.C6043a;
import expo.p318c.p319a.p320a.C6044a;
import expo.p318c.p319a.p320a.C6045b;
import expo.p318c.p319a.p320a.C6046c;
import host.exp.exponent.C6295c;
import host.exp.exponent.C6301d;
import host.exp.exponent.C6369g;
import host.exp.exponent.C6394j;
import host.exp.exponent.p339f.C6339i;
import host.exp.exponent.p346j.C6383a;
import host.exp.exponent.p346j.C6383a.C6382a;
import host.exp.exponent.p346j.C6387e;
import host.exp.p333a.C6271b;
import host.exp.p333a.C6271b.C6267b;
import host.exp.p333a.C6271b.C6268c;
import host.exp.p333a.C6271b.C6270e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import versioned.host.exp.exponent.ExponentPackage;
import versioned.host.exp.exponent.ExponentPackageDelegate;

/* compiled from: HeadlessAppLoader */
/* renamed from: host.exp.exponent.e.a */
public class C7526a implements C6044a, C6270e {
    /* renamed from: a */
    private static String f26089a = "headlessAppReadyForBundle";
    /* renamed from: b */
    private static final Map<Integer, String> f26090b = new HashMap();
    /* renamed from: c */
    private JSONObject f26091c;
    /* renamed from: d */
    private String f26092d;
    /* renamed from: e */
    private String f26093e;
    /* renamed from: f */
    private String f26094f;
    /* renamed from: g */
    private C6394j f26095g;
    /* renamed from: h */
    private Context f26096h;
    /* renamed from: i */
    private String f26097i;
    /* renamed from: j */
    private boolean f26098j;
    /* renamed from: k */
    private String f26099k;
    /* renamed from: l */
    private C7527b f26100l;
    /* renamed from: m */
    private C6043a f26101m;
    /* renamed from: n */
    private int f26102n;

    /* compiled from: HeadlessAppLoader */
    /* renamed from: host.exp.exponent.e.a$2 */
    class C63032 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C7526a f20513a;

        C63032(C7526a c7526a) {
            this.f20513a = c7526a;
        }

        public void run() {
            if (this.f20513a.f26095g.m26243b()) {
                this.f20513a.f26095g.m26250g();
                this.f20513a.f26095g.m26242b(null);
            }
            if (this.f20513a.mo5396h()) {
                this.f20513a.f26099k = "";
                this.f20513a.m34131f();
                return;
            }
            this.f20513a.f26098j = true;
            C6383a.m26189a(C7526a.f26089a);
        }
    }

    /* compiled from: HeadlessAppLoader */
    /* renamed from: host.exp.exponent.e.a$4 */
    class C75254 implements C6268c {
        /* renamed from: a */
        final /* synthetic */ C7526a f26088a;

        C75254(C7526a c7526a) {
            this.f26088a = c7526a;
        }

        /* renamed from: a */
        public void mo5392a() {
            this.f26088a.f26095g = this.f26088a.m34117a(this.f26088a, this.f26088a.f26097i, this.f26088a.f26094f, this.f26088a.m34129e(), this.f26088a.m34142b());
        }

        /* renamed from: a */
        public void mo5393a(String str) {
            this.f26088a.f26101m.onComplete(null, new Exception(str));
        }
    }

    /* renamed from: a */
    public void mo5395a(JSONArray jSONArray) {
    }

    /* renamed from: l */
    public ExponentPackageDelegate mo5397l() {
        return null;
    }

    /* renamed from: v */
    public boolean mo5398v() {
        return false;
    }

    /* renamed from: a */
    public static boolean m34121a(int i) {
        return i < -1 && f26090b.containsKey(Integer.valueOf(i)) != 0;
    }

    /* renamed from: b */
    public static String m34123b(int i) {
        return (String) f26090b.get(Integer.valueOf(i));
    }

    /* renamed from: a */
    public C6046c mo5394a(String str, Map<String, Object> map, C6043a c6043a) {
        this.f26092d = str;
        this.f26100l = new C7527b();
        this.f26101m = c6043a;
        this.f26102n = C6387e.m26202b();
        new C6295c(this, this.f26092d, true) {
            /* renamed from: d */
            final /* synthetic */ C7526a f26085d;

            /* renamed from: a */
            public void mo5386a(JSONObject jSONObject) {
            }

            /* renamed from: c */
            public void mo5389c(JSONObject jSONObject) {
            }

            /* renamed from: b */
            public void mo5388b(final JSONObject jSONObject) {
                C6271b.m25897a().m25913a(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C75231 f20512b;

                    public void run() {
                        try {
                            String a = C6339i.m26062a(jSONObject.getString("bundleUrl"));
                            C7526a.f26090b.put(Integer.valueOf(this.f20512b.f26085d.f26102n), a);
                            this.f20512b.f26085d.m34140a(this.f20512b.f26085d.f26092d, jSONObject, a);
                        } catch (JSONException e) {
                            this.f20512b.f26085d.f26101m.onComplete(false, new Exception(e.getMessage()));
                        }
                    }
                });
            }

            /* renamed from: a */
            public void mo5385a(String str) {
                this.f26085d.m34139a(str);
            }

            /* renamed from: a */
            public void mo5384a(Exception exception) {
                this.f26085d.f26101m.onComplete(null, new Exception(exception.getMessage()));
            }

            /* renamed from: b */
            public void mo5387b(String str) {
                this.f26085d.f26101m.onComplete(null, new Exception(str));
            }
        }.m25983a();
        return this.f26100l;
    }

    /* renamed from: a */
    public void m34140a(String str, JSONObject jSONObject, String str2) {
        this.f26092d = str;
        this.f26091c = jSONObject;
        this.f26093e = jSONObject.optString("sdkVersion");
        if ("32.0.0".equals(this.f26093e) != null) {
            this.f26093e = "UNVERSIONED";
        }
        this.f26094f = C6301d.m26001a() != null ? "UNVERSIONED" : this.f26093e;
        if ("UNVERSIONED".equals(this.f26093e) == null) {
            for (String equals : C6301d.f20500f) {
                if (equals.equals(this.f26093e) != null) {
                    str = true;
                    break;
                }
            }
            str = null;
            if (str == null) {
                str = this.f26101m;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.f26093e);
                stringBuilder.append(" is not a valid SDK version.");
                str.onComplete(null, new Exception(stringBuilder.toString()));
                return;
            }
        }
        m34138a();
        if (this.f26097i == null || this.f26097i.equals(C6301d.f20496b) != null) {
            if (C6301d.f20497c != null) {
                str = new StringBuilder();
                str.append(C6301d.f20497c);
                str.append("://");
                this.f26097i = str.toString();
            } else {
                this.f26097i = this.f26092d;
            }
        }
        UiThreadUtil.runOnUiThread(new C63032(this));
    }

    /* renamed from: a */
    public void m34139a(final String str) {
        if (!mo5396h()) {
            C6383a.m26190a(f26089a, new C6382a(this) {
                /* renamed from: b */
                final /* synthetic */ C7526a f26087b;

                /* renamed from: a */
                public boolean mo5390a() {
                    return this.f26087b.f26098j;
                }

                /* renamed from: b */
                public void mo5391b() {
                    this.f26087b.f26099k = str;
                    this.f26087b.m34131f();
                    C6383a.m26191b(C7526a.f26089a);
                }
            });
        }
    }

    /* renamed from: h */
    public boolean mo5396h() {
        return C6369g.m26131b(this.f26091c);
    }

    /* renamed from: a */
    public void m34138a() {
        if (this.f26094f != null) {
            SoLoader.init(this.f26096h, false);
        }
    }

    /* renamed from: e */
    private List<ReactPackage> m34129e() {
        if (!C6301d.m26001a()) {
            return null;
        }
        try {
            return ((C6045b) this.f26096h.getApplicationContext()).mo6404a();
        } catch (ClassCastException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public List<C6002i> m34142b() {
        if (!C6301d.m26001a()) {
            return null;
        }
        try {
            return ((C6045b) this.f26096h.getApplicationContext()).mo6405b();
        } catch (ClassCastException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: f */
    private void m34131f() {
        C6271b.m25897a().m25914a(mo5396h(), this.f26091c, new C75254(this));
    }

    /* renamed from: a */
    private C6394j m34117a(C6270e c6270e, String str, String str2, List<? extends Object> list, List<C6002i> list2) {
        str = MapBuilder.of("experienceUrl", this.f26092d, "linkingUri", m34133g(), "intentUri", str, "isHeadless", Boolean.valueOf(true));
        C6267b c6267b = new C6267b();
        c6267b.f20404a = (Application) this.f26096h;
        c6267b.f20405b = this.f26099k;
        c6267b.f20406c = str;
        c6267b.f20407d = list2;
        c6267b.f20408e = c6270e.mo5397l();
        c6267b.f20409f = this.f26091c;
        c6267b.f20410g = ExponentPackage.getOrCreateSingletonModules(this.f26096h, this.f26091c, list2);
        C6394j b = new C6394j("host.exp.exponent.VersionedUtils").m26233a(str2).m26241b("getReactInstanceManagerBuilder", c6267b);
        if (list != null) {
            list = list.iterator();
            while (list.hasNext() != null) {
                b.m26236a("addPackage", list.next());
            }
        }
        if (c6270e.mo5396h() != null) {
            C6271b.m25901a(str2, this.f26091c.optString("debuggerHost"), this.f26091c.optString("mainModuleName"), b);
        }
        c6270e = b.m26241b("build", new Object[0]);
        str = c6270e.m26241b("getDevSupportManager", new Object[0]).m26241b("getDevSettings", new Object[0]);
        if (str != null) {
            str.m26239a("exponentActivityId", Integer.valueOf(this.f26102n));
        }
        c6270e.m26236a("createReactContextInBackground", new Object[0]);
        this.f26100l.m34147a(c6270e);
        this.f26101m.onComplete(true, null);
        return c6270e;
    }

    /* renamed from: g */
    private String m34133g() {
        if (C6301d.f20497c != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C6301d.f20497c);
            stringBuilder.append("://");
            return stringBuilder.toString();
        }
        Uri parse = Uri.parse(this.f26092d);
        String host = parse.getHost();
        if (host == null || (!host.equals("exp.host") && !host.equals("expo.io") && !host.equals("exp.direct") && !host.equals("expo.test") && !host.endsWith(".exp.host") && !host.endsWith(".expo.io") && !host.endsWith(".exp.direct") && !host.endsWith(".expo.test"))) {
            return this.f26092d;
        }
        List<String> pathSegments = parse.getPathSegments();
        Builder buildUpon = parse.buildUpon();
        buildUpon.path(null);
        for (String str : pathSegments) {
            if ("--".equals(str)) {
                break;
            }
            buildUpon.appendEncodedPath(str);
        }
        return buildUpon.appendEncodedPath("--/").build().toString();
    }
}
