package ai.api.p007c;

import ai.api.p009e.C0031c;
import com.google.p127a.p128a.C2120c;
import java.io.Serializable;
import java.util.List;

/* compiled from: QuestionMetadata */
/* renamed from: ai.api.c.e */
public class C0015e implements Serializable {
    private static final long serialVersionUID = 1;
    @C2120c(a = "timezone")
    /* renamed from: a */
    private String f59a;
    @C2120c(a = "lang")
    /* renamed from: b */
    private String f60b;
    @C2120c(a = "sessionId")
    /* renamed from: c */
    private String f61c;
    @C2120c(a = "entities")
    /* renamed from: d */
    private List<Object> f62d;
    @C2120c(a = "location")
    /* renamed from: e */
    private C0014d f63e;

    /* renamed from: a */
    public String m54a() {
        return this.f59a;
    }

    /* renamed from: b */
    public void m57b(String str) {
        this.f59a = str;
    }

    /* renamed from: b */
    public String m56b() {
        return this.f60b;
    }

    /* renamed from: c */
    public void m59c(String str) {
        if (C0031c.m89a(str)) {
            throw new IllegalArgumentException("language must not be null");
        }
        this.f60b = str;
    }

    /* renamed from: d */
    public void m60d(String str) {
        this.f61c = str;
    }

    /* renamed from: b */
    public void m58b(List<Object> list) {
        this.f62d = list;
    }

    /* renamed from: a */
    public void m55a(C0014d c0014d) {
        this.f63e = c0014d;
    }

    public String toString() {
        return String.format("QuestionMetadata{language='%s', timezone='%s'}", new Object[]{this.f60b, this.f59a});
    }
}
