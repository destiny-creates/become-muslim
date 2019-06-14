package host.exp.exponent.p339f.p340a;

import com.amplitude.api.Constants;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p344h.C6373d;
import java.util.HashMap;
import java.util.Map;
import javax.inject.C6562a;
import org.json.JSONObject;

/* compiled from: ErrorRecoveryManager */
/* renamed from: host.exp.exponent.f.a.b */
public class C6327b {
    /* renamed from: b */
    private static Map<C6330b, C6327b> f20549b = new HashMap();
    /* renamed from: c */
    private static long f20550c = 0;
    /* renamed from: d */
    private static long f20551d = 0;
    @C6562a
    /* renamed from: a */
    C6373d f20552a;
    /* renamed from: e */
    private C6330b f20553e;
    /* renamed from: f */
    private long f20554f = 0;
    /* renamed from: g */
    private boolean f20555g = false;
    /* renamed from: h */
    private JSONObject f20556h;

    /* renamed from: a */
    public static C6327b m26024a(C6330b c6330b) {
        if (!f20549b.containsKey(c6330b)) {
            f20549b.put(c6330b, new C6327b(c6330b));
        }
        return (C6327b) f20549b.get(c6330b);
    }

    public C6327b(C6330b c6330b) {
        this.f20553e = c6330b;
        C6294a.m25957a().m25961b(C6327b.class, this);
    }

    /* renamed from: a */
    public void m26026a() {
        this.f20554f = System.currentTimeMillis();
        f20550c = this.f20554f;
        m26028a(false);
    }

    /* renamed from: a */
    public void m26027a(JSONObject jSONObject) {
        this.f20556h = jSONObject;
    }

    /* renamed from: b */
    public JSONObject m26029b() {
        JSONObject jSONObject = this.f20555g ? this.f20556h : null;
        if (this.f20555g) {
            f20551d++;
        }
        m26028a(false);
        this.f20556h = null;
        return jSONObject;
    }

    /* renamed from: c */
    public void m26030c() {
        m26028a(true);
    }

    /* renamed from: a */
    public void m26028a(boolean z) {
        this.f20555g = z;
        if (this.f20553e != null) {
            JSONObject e = this.f20552a.m26165e(this.f20553e.m26048a());
            if (e == null) {
                e = new JSONObject();
            }
            try {
                e.put("loadingError", z);
                this.f20552a.m26158b(this.f20553e.m26048a(), e);
            } catch (boolean z2) {
                z2.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    public boolean m26031d() {
        return System.currentTimeMillis() - this.f20554f >= m26025e();
    }

    /* renamed from: e */
    private long m26025e() {
        long min = Math.min(Constants.MIN_TIME_BETWEEN_SESSIONS_MILLIS, (long) (Math.pow(1.5d, (double) f20551d) * 5000.0d));
        if (System.currentTimeMillis() - f20550c <= 2 * min) {
            return min;
        }
        f20551d = 0;
        return 5000;
    }
}
