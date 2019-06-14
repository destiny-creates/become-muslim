package ai.api.p007c;

import com.google.p127a.p128a.C2120c;
import java.io.Serializable;
import java.util.Date;

/* compiled from: AIResponse */
/* renamed from: ai.api.c.c */
public class C0013c implements Serializable {
    private static final long serialVersionUID = 1;
    @C2120c(a = "id")
    /* renamed from: a */
    private String f54a;
    @C2120c(a = "timestamp")
    /* renamed from: b */
    private Date f55b;
    @C2120c(a = "result")
    /* renamed from: c */
    private C0018g f56c;
    @C2120c(a = "status")
    /* renamed from: d */
    private C0019h f57d;
    @C2120c(a = "sessionId")
    /* renamed from: e */
    private String f58e;

    /* renamed from: a */
    public C0019h m50a() {
        return this.f57d;
    }

    /* renamed from: a */
    public void m51a(C0019h c0019h) {
        this.f57d = c0019h;
    }

    /* renamed from: b */
    public boolean m52b() {
        return (this.f57d == null || this.f57d.m66a() == null || this.f57d.m66a().intValue() < 400) ? false : true;
    }

    public String toString() {
        return String.format("AIResponse{id='%s', timestamp=%s, result=%s, status=%s, sessionId=%s}", new Object[]{this.f54a, this.f55b, this.f56c, this.f57d, this.f58e});
    }

    /* renamed from: c */
    public void m53c() {
        if (this.f56c != null) {
            this.f56c.m64a();
        }
    }
}
