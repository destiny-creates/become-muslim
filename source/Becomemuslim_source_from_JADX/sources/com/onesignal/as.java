package com.onesignal;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.onesignal.C5526p.C5525f;
import com.onesignal.am.C5457b;
import com.onesignal.am.C5470o;
import com.onesignal.bj.C5495a;
import org.json.JSONObject;

/* compiled from: OneSignalStateSynchronizer */
class as {
    /* renamed from: a */
    private static bi f18458a;
    /* renamed from: b */
    private static bg f18459b;

    /* renamed from: a */
    static bi m23301a() {
        if (f18458a == null) {
            f18458a = new bi();
        }
        return f18458a;
    }

    /* renamed from: b */
    static bg m23308b() {
        if (f18459b == null) {
            f18459b = new bg();
        }
        return f18459b;
    }

    /* renamed from: c */
    static boolean m23313c() {
        boolean j = m23301a().m23431j();
        boolean j2 = m23308b().m23431j();
        if (j2) {
            j2 = m23308b().m23426f() != null;
        }
        if (j || r1) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    static void m23315d() {
        m23301a().m23430i();
        m23308b().m23430i();
    }

    /* renamed from: e */
    static void m23316e() {
        m23301a().m23429h();
        m23308b().m23429h();
    }

    /* renamed from: a */
    static void m23307a(boolean z) {
        m23301a().m23425e(z);
        m23308b().m23425e(z);
    }

    /* renamed from: a */
    static void m23306a(JSONObject jSONObject, C5457b c5457b) {
        try {
            jSONObject = new JSONObject().put("tags", jSONObject);
            m23301a().m23414a(jSONObject, c5457b);
            m23308b().m23414a(jSONObject, c5457b);
        } catch (JSONObject jSONObject2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Encountered an error attempting to serialize your tags into JSON: ");
            stringBuilder.append(jSONObject2.getMessage());
            stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder.append(jSONObject2.getStackTrace());
            c5457b.m23109a(new C5470o(-1, stringBuilder.toString()));
            jSONObject2.printStackTrace();
        }
    }

    /* renamed from: a */
    static void m23303a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("em_m", al.m23088a(str, "MD5"));
            jSONObject.put("em_s", al.m23088a(str, "SHA-1"));
            m23301a().m23427f(jSONObject);
        } catch (String str2) {
            str2.printStackTrace();
        }
    }

    /* renamed from: a */
    static void m23304a(String str, String str2) {
        m23301a().m32649a(str, str2);
        m23308b().m32629a(str, str2);
    }

    /* renamed from: b */
    static void m23311b(boolean z) {
        m23301a().mo4953b(z);
    }

    /* renamed from: f */
    static boolean m23317f() {
        return m23301a().mo4951b();
    }

    /* renamed from: c */
    static void m23312c(boolean z) {
        m23301a().mo4959c(z);
    }

    /* renamed from: a */
    static void m23302a(C5525f c5525f) {
        m23301a().m23411a(c5525f);
        m23308b().m23411a(c5525f);
    }

    /* renamed from: g */
    static boolean m23318g() {
        return m23301a().mo4950a();
    }

    /* renamed from: h */
    static String m23319h() {
        return m23301a().m23426f();
    }

    /* renamed from: d */
    static C5495a m23314d(boolean z) {
        return m23301a().mo4947a(z);
    }

    /* renamed from: i */
    static void m23320i() {
        m23301a().m23434m();
        m23308b().m23434m();
        am.m23210e(null);
        am.m23217f(null);
        am.m23150a(-3660);
    }

    /* renamed from: a */
    static void m23305a(JSONObject jSONObject) {
        m23301a().m23424e(jSONObject);
        m23308b().m23424e(jSONObject);
    }

    /* renamed from: b */
    static void m23310b(JSONObject jSONObject) {
        m23301a().mo4949a(jSONObject);
    }

    /* renamed from: j */
    static void m23321j() {
        m23308b().mo4951b();
    }

    /* renamed from: k */
    static void m23322k() {
        m23301a().m23433l();
        m23308b().m23433l();
    }

    /* renamed from: l */
    static void m23323l() {
        m23308b().m23433l();
    }

    /* renamed from: m */
    static void m23324m() {
        m23301a().mo4958e();
        m23308b().mo4958e();
    }

    /* renamed from: b */
    static void m23309b(String str) {
        m23301a().m23416b(str);
        m23308b().m23416b(str);
    }
}
