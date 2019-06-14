package host.exp.exponent.experience;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.C4890j;
import android.support.v4.content.C0366b;
import android.support.v7.app.C4473b.C0609a;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.devsupport.DoubleTapReloadRecognizer;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import de.p287a.p288a.C5884c;
import expo.p304a.p305a.C6002i;
import host.exp.exponent.C6290a;
import host.exp.exponent.C6301d;
import host.exp.exponent.C6369g;
import host.exp.exponent.C6381i;
import host.exp.exponent.C6394j;
import host.exp.exponent.experience.C8362a.C7543b;
import host.exp.exponent.notifications.C6396c;
import host.exp.exponent.p334a.C6288a;
import host.exp.exponent.p334a.C6288a.C6287a;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p339f.C6332e;
import host.exp.exponent.p339f.C6333f;
import host.exp.exponent.p339f.C6352l.C6349a;
import host.exp.exponent.p339f.C6352l.C6350b;
import host.exp.exponent.p339f.C6355n;
import host.exp.exponent.p339f.p340a.C6327b;
import host.exp.exponent.p339f.p340a.C6328c;
import host.exp.exponent.p339f.p340a.C7548e;
import host.exp.exponent.p344h.C6373d;
import host.exp.exponent.p346j.C6388f;
import host.exp.p333a.C6271b;
import host.exp.p333a.C6271b.C6267b;
import host.exp.p333a.C6271b.C6270e;
import host.exp.p333a.C6279c.C6272a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import javax.inject.C6562a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import versioned.host.exp.exponent.ExponentPackage;

/* compiled from: ReactNativeActivity */
/* renamed from: host.exp.exponent.experience.f */
public abstract class C8355f extends C4890j implements DefaultHardwareBackBtnHandler {
    /* renamed from: a */
    private static final String f32898a = "f";
    /* renamed from: q */
    protected static Queue<C6332e> f32899q = new LinkedList();
    /* renamed from: b */
    private FrameLayout f32900b;
    /* renamed from: c */
    protected C6394j f32901c = new C6394j("com.facebook.react.ReactInstanceManager");
    /* renamed from: d */
    protected boolean f32902d = false;
    /* renamed from: e */
    protected boolean f32903e = true;
    /* renamed from: f */
    protected String f32904f;
    /* renamed from: g */
    protected String f32905g;
    /* renamed from: h */
    protected C6330b f32906h;
    /* renamed from: i */
    protected String f32907i;
    /* renamed from: j */
    protected int f32908j;
    /* renamed from: k */
    protected String f32909k;
    /* renamed from: l */
    protected C6394j f32910l;
    /* renamed from: m */
    protected boolean f32911m = true;
    /* renamed from: n */
    protected String f32912n;
    /* renamed from: o */
    protected JSONObject f32913o;
    /* renamed from: p */
    protected boolean f32914p = false;
    @C6562a
    /* renamed from: r */
    protected C6373d f32915r;
    @C6562a
    /* renamed from: s */
    C6328c f32916s;
    /* renamed from: t */
    private FrameLayout f32917t;
    /* renamed from: u */
    private C6381i f32918u;
    /* renamed from: v */
    private Handler f32919v = new Handler();
    /* renamed from: w */
    private Handler f32920w = new Handler();
    /* renamed from: x */
    private DoubleTapReloadRecognizer f32921x;
    /* renamed from: y */
    private C7548e f32922y;

    /* compiled from: ReactNativeActivity */
    /* renamed from: host.exp.exponent.experience.f$1 */
    class C63181 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C8355f f20538a;

        C63181(C8355f c8355f) {
            this.f20538a = c8355f;
        }

        public void run() {
            this.f20538a.m44479y();
        }
    }

    /* compiled from: ReactNativeActivity */
    /* renamed from: host.exp.exponent.experience.f$2 */
    class C63192 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C8355f f20539a;

        C63192(C8355f c8355f) {
            this.f20539a = c8355f;
        }

        public void run() {
            this.f20539a.mo6918b();
            C5884c.m24753a().m24769d(new C6321a());
        }
    }

    /* compiled from: ReactNativeActivity */
    /* renamed from: host.exp.exponent.experience.f$3 */
    class C63203 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C8355f f20540a;

        C63203(C8355f c8355f) {
            this.f20540a = c8355f;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("package:");
            stringBuilder.append(this.f20540a.getPackageName());
            this.f20540a.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(stringBuilder.toString())), 123);
        }
    }

    /* compiled from: ReactNativeActivity */
    /* renamed from: host.exp.exponent.experience.f$a */
    public static class C6321a {
    }

    /* renamed from: a */
    public Bundle mo6922a(Bundle bundle) {
        return bundle;
    }

    /* renamed from: o */
    protected void mo6913o() {
    }

    /* renamed from: p */
    protected void mo6915p() {
    }

    /* renamed from: u */
    public boolean m44475u() {
        return this.f32911m;
    }

    /* renamed from: v */
    public boolean m44476v() {
        return this.f32914p;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(null);
        this.f32900b = new FrameLayout(this);
        setContentView(this.f32900b);
        this.f32917t = new FrameLayout(this);
        this.f32900b.addView(this.f32917t);
        this.f32918u = new C6381i(this);
        if (C6301d.m26001a() == null || C6301d.f20504j != null) {
            this.f32917t.setBackgroundColor(C0366b.c(this, C6272a.white));
            this.f32900b.addView(this.f32918u);
        }
        this.f32921x = new DoubleTapReloadRecognizer();
        C6271b.m25899a((Context) this, getApplication());
        C6294a.m25957a().m25961b(C8355f.class, this);
        this.f32922y = this.f32916s.m26041j();
    }

    /* renamed from: a */
    protected void m44465a(View view) {
        this.f32917t.removeAllViews();
        if (C6301d.m26001a() && C6301d.f20504j) {
            LayoutParams layoutParams = this.f32917t.getLayoutParams();
            layoutParams.height = 0;
            this.f32917t.setLayoutParams(layoutParams);
        }
        m44468b(view);
    }

    /* renamed from: b */
    protected void m44468b(View view) {
        m44470c(view);
        this.f32917t.addView(view);
    }

    /* renamed from: c */
    protected void m44470c(View view) {
        if (view.getParent() != null) {
            ((FrameLayout) view.getParent()).removeView(view);
        }
    }

    /* renamed from: w */
    protected void m44477w() {
        if (this.f32911m) {
            if (mo6911c()) {
                this.f32919v.removeCallbacksAndMessages(null);
                mo6918b();
            }
        }
    }

    /* renamed from: a */
    protected void m44466a(String str, Integer num, Integer num2) {
        if (!this.f32911m) {
            m44471c(this.f32913o);
        }
        this.f32918u.m26186a(str, num, num2);
    }

    /* renamed from: x */
    protected void m44478x() {
        this.f32917t.removeAllViews();
    }

    /* renamed from: y */
    protected void m44479y() {
        if (!this.f32910l.m26240a()) {
            if (((Integer) this.f32910l.m26236a("getChildCount", new Object[0])).intValue() > 0) {
                if (mo6911c()) {
                    mo6917a();
                }
                mo6913o();
                C6327b.m26024a(this.f32906h).m26026a();
                mo6912d();
            } else {
                this.f32919v.postDelayed(new C63181(this), 20);
            }
        }
    }

    /* renamed from: c */
    public void m44471c(JSONObject jSONObject) {
        this.f32918u.setManifest(jSONObject);
        this.f32918u.setShowIcon(true);
        this.f32918u.clearAnimation();
        this.f32918u.setAlpha(1.0f);
        this.f32911m = true;
    }

    /* renamed from: a */
    private void mo6917a() {
        if (this.f32911m) {
            runOnUiThread(new C63192(this));
        }
    }

    /* renamed from: b */
    private void mo6918b() {
        if (C6301d.m26001a() && C6301d.f20504j) {
            LayoutParams layoutParams = this.f32917t.getLayoutParams();
            layoutParams.height = this.f32900b.getHeight();
            this.f32917t.setLayoutParams(layoutParams);
        }
        if (this.f32918u != null && this.f32918u.getParent() == this.f32900b) {
            this.f32918u.setAlpha(0.0f);
            this.f32918u.setShowIcon(false);
            this.f32918u.m26185a();
        }
        this.f32922y.m34187g();
        this.f32911m = false;
        this.f32920w.removeCallbacksAndMessages(null);
    }

    /* renamed from: c */
    private boolean mo6911c() {
        return (!this.f32922y.m34184d() || this.f32922y.m34185e()) && this.f32922y.m34183c();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!(this.f32901c == null || !this.f32901c.m26243b() || this.f32902d)) {
            if (i == 82) {
                this.f32901c.m26236a("showDevOptionsDialog", new Object[0]);
                return true;
            }
            C6394j b = this.f32901c.m26241b("getDevSupportManager", new Object[0]);
            if (b != null && ((Boolean) b.m26236a("getDevSupportEnabled", new Object[0])).booleanValue() && ((DoubleTapReloadRecognizer) Assertions.assertNotNull(this.f32921x)).didDoubleTapR(i, getCurrentFocus())) {
                if (C6290a.m25954a(this.f32907i) >= C6290a.m25954a("26.0.0")) {
                    m44471c(this.f32913o);
                }
                b.m26236a("handleReloadJS", new Object[0]);
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void onBackPressed() {
        if (this.f32901c == null || !this.f32901c.m26243b() || this.f32902d) {
            super.onBackPressed();
        } else {
            this.f32901c.m26236a("onBackPressed", new Object[0]);
        }
    }

    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    protected void onPause() {
        super.onPause();
        if (this.f32901c != null && this.f32901c.m26243b() && !this.f32902d) {
            this.f32901c.m26249f();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.f32901c != null && this.f32901c.m26243b() && !this.f32902d) {
            this.f32901c.m26237a((Object) this, (Object) this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.f32901c != null && this.f32901c.m26243b() && !this.f32902d && this.f32903e) {
            this.f32901c.m26236a("destroy", new Object[0]);
        }
        this.f32919v.removeCallbacksAndMessages(null);
        this.f32920w.removeCallbacksAndMessages(null);
        C5884c.m24753a().m24768c(this);
    }

    public void onNewIntent(Intent intent) {
        if (this.f32901c == null || !this.f32901c.m26243b() || this.f32902d) {
            super.onNewIntent(intent);
            return;
        }
        try {
            this.f32901c.m26236a("onNewIntent", intent);
        } catch (Throwable th) {
            C6289b.m25953c(f32898a, th.toString());
            super.onNewIntent(intent);
        }
    }

    /* renamed from: h */
    public boolean mo6900h() {
        return C6369g.m26131b(this.f32913o);
    }

    /* renamed from: b */
    protected void m44469b(String str) {
        this.f32912n = str;
        if (mo6900h() == null || C6271b.m25897a().m25926f() == null) {
            mo6915p();
        } else {
            new C0609a(this).a("Please enable \"Permit drawing over other apps\"").b("Click \"ok\" to open settings. Press the back button once you've enabled the setting.").a(17039370, new C63203(this)).a(false).c();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C6271b.m25897a().m25909a(i, i2, intent);
        if (!(this.f32901c == null || !this.f32901c.m26243b() || this.f32902d)) {
            this.f32901c.m26236a("onActivityResult", this, Integer.valueOf(i), Integer.valueOf(i2), intent);
        }
        if (i == 123) {
            this.f32914p = true;
            mo6915p();
        }
    }

    /* renamed from: a */
    public C6394j m44464a(C6270e c6270e, String str, String str2, C6396c c6396c, boolean z, List<? extends Object> list, List<C6002i> list2, C6317d c6317d) {
        JSONException e;
        C6394j b;
        String str3 = str2;
        C6396c c6396c2 = c6396c;
        List<C6002i> list3 = list2;
        if (!this.f32902d) {
            if (c6270e.mo5398v()) {
                C6394j b2;
                Map of = MapBuilder.of("experienceUrl", r1.f32904f, "linkingUri", mo6919e(), "intentUri", str, "isHeadless", Boolean.valueOf(false));
                C6267b c6267b = new C6267b();
                c6267b.f20404a = getApplication();
                c6267b.f20405b = r1.f32912n;
                c6267b.f20406c = of;
                c6267b.f20407d = list3;
                c6267b.f20408e = c6270e.mo5397l();
                c6267b.f20409f = r1.f32913o;
                c6267b.f20410g = ExponentPackage.getOrCreateSingletonModules(getApplicationContext(), r1.f32913o, list3);
                C6394j b3 = new C6394j("host.exp.exponent.VersionedUtils").m26233a(str3).m26241b("getReactInstanceManagerBuilder", c6267b);
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        b3.m26236a("addPackage", it.next());
                    }
                }
                if (c6270e.mo5396h()) {
                    C6271b.m25901a(str3, r1.f32913o.optString("debuggerHost"), r1.f32913o.optString("mainModuleName"), b3);
                    new C6394j("com.facebook.react.devsupport.DevLoadingViewController").m26233a(str3).m26241b("setDevLoadingEnabled", Boolean.valueOf(false));
                    C6394j a = new C6394j("host.exp.exponent.ExponentDevBundleDownloadListener").m26233a(str3).m26234a(c6317d);
                    b3.m26241b("setDevBundleDownloadListener", a.m26244c());
                    if (C6290a.m25954a(str2) < C6290a.m25954a("26.0.0")) {
                        m44479y();
                    }
                } else {
                    m44479y();
                }
                Bundle bundle = new Bundle();
                JSONObject jSONObject = new JSONObject();
                if (c6396c2 != null) {
                    bundle.putString("notification", c6396c2.f20702b);
                    try {
                        jSONObject.put("notification", c6396c2.m26254b("selected"));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                try {
                    Object obj;
                    jSONObject.put("manifest", r1.f32913o);
                    jSONObject.put("shell", z);
                    str3 = "initialUri";
                    if (str == null) {
                        obj = null;
                    } else {
                        obj = str.toString();
                    }
                    jSONObject.put(str3, obj);
                    jSONObject.put("errorRecovery", C6327b.m26024a(r1.f32906h).m26029b());
                } catch (Throwable e3) {
                    C6289b.m25950a(f32898a, e3);
                }
                JSONObject e4 = r1.f32915r.m26165e(r1.f32905g);
                C6270e c6270e2;
                if (e4 != null) {
                    if (e4.has("lastErrors")) {
                        try {
                            jSONObject.put("lastErrors", e4.getJSONArray("lastErrors"));
                        } catch (JSONException e22) {
                            e22.printStackTrace();
                        }
                        e4.remove("lastErrors");
                    }
                    if (e4.has("unreadNotifications")) {
                        try {
                            JSONArray jSONArray = e4.getJSONArray("unreadNotifications");
                            jSONObject.put("unreadNotifications", jSONArray);
                            c6270e2 = c6270e;
                            try {
                                c6270e.mo5395a(jSONArray);
                            } catch (JSONException e5) {
                                e22 = e5;
                                e22.printStackTrace();
                                e4.remove("unreadNotifications");
                                r1.f32915r.m26158b(r1.f32905g, e4);
                                bundle.putBundle("exp", C6388f.m26203a(jSONObject));
                                if (c6270e.mo5398v()) {
                                    return new C6394j("com.facebook.react.ReactInstanceManager");
                                }
                                C6288a.m25941a(C6287a.STARTED_LOADING_REACT_NATIVE);
                                b = b3.m26241b("build", new Object[0]);
                                b2 = b.m26241b("getDevSupportManager", new Object[0]).m26241b("getDevSettings", new Object[0]);
                                if (b2 != null) {
                                    b2.m26239a("exponentActivityId", Integer.valueOf(r1.f32908j));
                                    if (((Boolean) b2.m26236a("isRemoteJSDebugEnabled", new Object[0])).booleanValue()) {
                                        m44479y();
                                    }
                                }
                                b.m26237a((Object) this, (Object) this);
                                r1.f32910l.m26236a("startReactApplication", b.m26244c(), r1.f32913o.optString("appKey", "main"), mo6922a(bundle));
                                return b;
                            }
                        } catch (JSONException e6) {
                            e22 = e6;
                            c6270e2 = c6270e;
                            e22.printStackTrace();
                            e4.remove("unreadNotifications");
                            r1.f32915r.m26158b(r1.f32905g, e4);
                            bundle.putBundle("exp", C6388f.m26203a(jSONObject));
                            if (c6270e.mo5398v()) {
                                return new C6394j("com.facebook.react.ReactInstanceManager");
                            }
                            C6288a.m25941a(C6287a.STARTED_LOADING_REACT_NATIVE);
                            b = b3.m26241b("build", new Object[0]);
                            b2 = b.m26241b("getDevSupportManager", new Object[0]).m26241b("getDevSettings", new Object[0]);
                            if (b2 != null) {
                                b2.m26239a("exponentActivityId", Integer.valueOf(r1.f32908j));
                                if (((Boolean) b2.m26236a("isRemoteJSDebugEnabled", new Object[0])).booleanValue()) {
                                    m44479y();
                                }
                            }
                            b.m26237a((Object) this, (Object) this);
                            r1.f32910l.m26236a("startReactApplication", b.m26244c(), r1.f32913o.optString("appKey", "main"), mo6922a(bundle));
                            return b;
                        }
                        e4.remove("unreadNotifications");
                    } else {
                        c6270e2 = c6270e;
                    }
                    r1.f32915r.m26158b(r1.f32905g, e4);
                } else {
                    c6270e2 = c6270e;
                }
                bundle.putBundle("exp", C6388f.m26203a(jSONObject));
                if (c6270e.mo5398v()) {
                    return new C6394j("com.facebook.react.ReactInstanceManager");
                }
                C6288a.m25941a(C6287a.STARTED_LOADING_REACT_NATIVE);
                b = b3.m26241b("build", new Object[0]);
                b2 = b.m26241b("getDevSupportManager", new Object[0]).m26241b("getDevSettings", new Object[0]);
                if (b2 != null) {
                    b2.m26239a("exponentActivityId", Integer.valueOf(r1.f32908j));
                    if (((Boolean) b2.m26236a("isRemoteJSDebugEnabled", new Object[0])).booleanValue()) {
                        m44479y();
                    }
                }
                b.m26237a((Object) this, (Object) this);
                r1.f32910l.m26236a("startReactApplication", b.m26244c(), r1.f32913o.optString("appKey", "main"), mo6922a(bundle));
                return b;
            }
        }
        return new C6394j("com.facebook.react.ReactInstanceManager");
    }

    /* renamed from: a */
    protected boolean m44467a(C6333f c6333f) {
        if (this.f32911m) {
            return true;
        }
        C6327b a = C6327b.m26024a(this.f32906h);
        a.m26030c();
        if (!a.m26031d() || !C6355n.m26073a().m26070i(this.f32904f)) {
            return true;
        }
        f32899q.clear();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("USER_ERROR_MESSAGE", c6333f.m26053a());
            jSONObject.put("DEVELOPER_ERROR_MESSAGE", c6333f.m26055b());
            jSONObject.put("MANIFEST_URL", this.f32904f);
            C6288a.m25945a("ERROR_RELOADED", jSONObject);
        } catch (C6333f c6333f2) {
            C6289b.m25953c(f32898a, c6333f2.getMessage());
        }
        return null;
    }

    public void onEventMainThread(C6349a c6349a) {
        if (this.f32904f != null && this.f32904f.equals(c6349a.f20606a) != null) {
            mo6912d();
        }
    }

    public void onEvent(C7543b c7543b) {
        mo6917a();
    }

    /* renamed from: d */
    private void mo6912d() {
        if (this.f32904f != null) {
            try {
                new C6394j("com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter").m26233a(this.f32909k);
                C6394j b = this.f32901c.m26241b("getCurrentReactContext", new Object[0]).m26241b("getJSModule", b.m26247d());
                if (b != null) {
                    for (C6350b c6350b : C6355n.m26073a().m26071j(this.f32904f)) {
                        b.m26236a("emit", c6350b.f20607a, c6350b.f20608b);
                    }
                }
            } catch (Throwable th) {
                C6289b.m25950a(f32898a, th);
            }
        }
    }

    /* renamed from: e */
    private String mo6919e() {
        StringBuilder stringBuilder;
        if (C6301d.f20497c != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(C6301d.f20497c);
            stringBuilder.append("://");
            return stringBuilder.toString();
        } else if (C6290a.m25954a(this.f32907i) < C6290a.m25954a("27.0.0")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.f32904f);
            stringBuilder.append("/+");
            return stringBuilder.toString();
        } else {
            Uri parse = Uri.parse(this.f32904f);
            String host = parse.getHost();
            if (host == null || (!host.equals("exp.host") && !host.equals("expo.io") && !host.equals("exp.direct") && !host.equals("expo.test") && !host.endsWith(".exp.host") && !host.endsWith(".expo.io") && !host.endsWith(".exp.direct") && !host.endsWith(".expo.test"))) {
                return this.f32904f;
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
}
