package ai.api;

import ai.api.p007c.C0014d;
import java.util.List;
import java.util.Map;

/* compiled from: RequestExtras */
/* renamed from: ai.api.j */
public class C0044j {
    /* renamed from: a */
    private List<Object> f131a;
    /* renamed from: b */
    private List<Object> f132b;
    /* renamed from: c */
    private Map<String, String> f133c;
    /* renamed from: d */
    private C0014d f134d;

    public C0044j() {
        this.f131a = null;
        this.f132b = null;
    }

    public C0044j(List<Object> list, List<Object> list2) {
        this.f131a = list;
        this.f132b = list2;
    }

    /* renamed from: a */
    public List<Object> m115a() {
        return this.f131a;
    }

    /* renamed from: b */
    public List<Object> m116b() {
        return this.f132b;
    }

    /* renamed from: c */
    public Map<String, String> m117c() {
        return this.f133c;
    }

    /* renamed from: d */
    public C0014d m118d() {
        return this.f134d;
    }

    /* renamed from: e */
    public boolean m119e() {
        return (this.f131a == null || this.f131a.isEmpty()) ? false : true;
    }

    /* renamed from: f */
    public boolean m120f() {
        return (this.f132b == null || this.f132b.isEmpty()) ? false : true;
    }
}
