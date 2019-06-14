package ai.api.p007c;

import com.facebook.stetho.server.http.HttpStatus;
import com.google.p127a.p128a.C2120c;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Status */
/* renamed from: ai.api.c.h */
public class C0019h implements Serializable {
    /* renamed from: a */
    private static final Map<Integer, String> f77a = new HashMap();
    /* renamed from: b */
    private static final Map<Integer, String> f78b = new HashMap();
    private static final long serialVersionUID = 1;
    @C2120c(a = "code")
    /* renamed from: c */
    private Integer f79c;
    @C2120c(a = "errorType")
    /* renamed from: d */
    private String f80d;
    @C2120c(a = "errorDetails")
    /* renamed from: e */
    private String f81e;

    public C0019h() {
        f77a.put(Integer.valueOf(400), "Some required parameter is missing or has wrong value. Details will be in the errorDetails field.");
        f78b.put(Integer.valueOf(400), "bad_request");
        f77a.put(Integer.valueOf(401), "Authorization failed. Please check your access keys.");
        f78b.put(Integer.valueOf(401), "unauthorized");
        f77a.put(Integer.valueOf(HttpStatus.HTTP_NOT_FOUND), "Uri is not found or some resource with provided id is not found.");
        f78b.put(Integer.valueOf(HttpStatus.HTTP_NOT_FOUND), "not_found");
        f77a.put(Integer.valueOf(405), "Attempting to use POST with a GET-only endpoint, or vice-versa.");
        f78b.put(Integer.valueOf(405), "not_allowed");
        f77a.put(Integer.valueOf(406), "Uploaded files have some problems with it.");
        f78b.put(Integer.valueOf(406), "not_acceptable");
        f77a.put(Integer.valueOf(409), "The request could not be completed due to a conflict with the current state of the resource. This code is only allowed in situations where it is expected that the user might be able to resolve the conflict and resubmit the request.");
        f78b.put(Integer.valueOf(409), "conflict");
    }

    /* renamed from: a */
    public static C0019h m65a(int i) {
        C0019h c0019h = new C0019h();
        c0019h.m67a(Integer.valueOf(i));
        if (f78b.containsKey(Integer.valueOf(i))) {
            c0019h.m68a((String) f78b.get(Integer.valueOf(i)));
        }
        if (f77a.containsKey(Integer.valueOf(i))) {
            c0019h.m70b((String) f77a.get(Integer.valueOf(i)));
        }
        return c0019h;
    }

    /* renamed from: a */
    public Integer m66a() {
        return this.f79c;
    }

    /* renamed from: a */
    public void m67a(Integer num) {
        this.f79c = num;
    }

    /* renamed from: a */
    public void m68a(String str) {
        this.f80d = str;
    }

    /* renamed from: b */
    public String m69b() {
        if (this.f79c == null || !f77a.containsKey(this.f79c)) {
            return this.f81e;
        }
        return (String) f77a.get(this.f79c);
    }

    /* renamed from: b */
    public void m70b(String str) {
        this.f81e = str;
    }

    public String toString() {
        return String.format("Status{code=%d, errorType='%s', errorDetails='%s'}", new Object[]{this.f79c, this.f80d, this.f81e});
    }
}
