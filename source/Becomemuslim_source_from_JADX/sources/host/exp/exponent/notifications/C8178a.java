package host.exp.exponent.notifications;

import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.raizlabs.android.dbflow.p281e.C7139b;
import java.util.Map;

/* compiled from: ActionObject */
/* renamed from: host.exp.exponent.notifications.a */
public class C8178a extends C7139b {
    /* renamed from: a */
    private String f30374a;
    /* renamed from: b */
    private String f30375b;
    /* renamed from: c */
    private String f30376c;
    /* renamed from: d */
    private Boolean f30377d;
    /* renamed from: e */
    private Boolean f30378e;
    /* renamed from: f */
    private String f30379f;
    /* renamed from: g */
    private String f30380g;
    /* renamed from: h */
    private Boolean f30381h;
    /* renamed from: i */
    private int f30382i;

    public C8178a() {
        this.f30382i = 0;
    }

    public C8178a(Map<String, Object> map, int i) {
        this.f30374a = (String) map.get("categoryId");
        this.f30375b = (String) map.get("actionId");
        this.f30376c = (String) map.get("buttonTitle");
        this.f30377d = (Boolean) map.get("isDestructive");
        this.f30378e = (Boolean) map.get("isAuthenticationRequired");
        this.f30381h = Boolean.valueOf(map.get("textInput") != null);
        if (this.f30381h.booleanValue() && (map.get("textInput") instanceof Map)) {
            map = (Map) map.get("textInput");
            this.f30380g = (String) map.get(ReactTextInputShadowNode.PROP_PLACEHOLDER);
            this.f30379f = (String) map.get("submitButtonTitle");
        }
        this.f30382i = i;
    }

    /* renamed from: d */
    public String m39727d() {
        return this.f30375b;
    }

    /* renamed from: e */
    public String m39729e() {
        return this.f30376c;
    }

    /* renamed from: f */
    public boolean m39731f() {
        return this.f30381h.booleanValue();
    }

    /* renamed from: g */
    public int m39732g() {
        return this.f30382i;
    }

    /* renamed from: a */
    public void m39720a(int i) {
        this.f30382i = i;
    }

    /* renamed from: a */
    public void m39721a(Boolean bool) {
        this.f30381h = bool;
    }

    /* renamed from: a */
    public void m39722a(String str) {
        this.f30375b = str;
    }

    /* renamed from: h */
    public String m39733h() {
        return this.f30379f;
    }

    /* renamed from: b */
    public void m39724b(String str) {
        this.f30379f = str;
    }

    /* renamed from: i */
    public String m39734i() {
        return this.f30374a;
    }

    /* renamed from: c */
    public void m39726c(String str) {
        this.f30374a = str;
    }

    /* renamed from: d */
    public void m39728d(String str) {
        this.f30376c = str;
    }

    /* renamed from: j */
    public Boolean m39735j() {
        return this.f30377d;
    }

    /* renamed from: b */
    public void m39723b(Boolean bool) {
        this.f30377d = bool;
    }

    /* renamed from: k */
    public Boolean m39736k() {
        return this.f30378e;
    }

    /* renamed from: c */
    public void m39725c(Boolean bool) {
        this.f30378e = bool;
    }

    /* renamed from: l */
    public String m39737l() {
        return this.f30380g;
    }

    /* renamed from: e */
    public void m39730e(String str) {
        this.f30380g = str;
    }
}
