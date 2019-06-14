package ai.api.p007c;

import ai.api.p009e.C0031c;
import com.google.p127a.p128a.C2120c;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* compiled from: AIRequest */
/* renamed from: ai.api.c.b */
public class C3090b extends C0015e implements Serializable {
    private static final long serialVersionUID = 1;
    @C2120c(a = "query")
    /* renamed from: a */
    private String[] f7887a;
    @C2120c(a = "confidence")
    /* renamed from: b */
    private float[] f7888b;
    @C2120c(a = "contexts")
    /* renamed from: c */
    private List<Object> f7889c;
    @C2120c(a = "resetContexts")
    /* renamed from: d */
    private Boolean f7890d;

    /* renamed from: a */
    public void m9036a(String str) {
        if (C0031c.m89a(str)) {
            throw new IllegalStateException("Query must not be empty");
        }
        this.f7887a = new String[]{str};
        this.f7888b = null;
    }

    /* renamed from: a */
    public void m9038a(String[] strArr, float[] fArr) {
        if (strArr != null) {
            if (fArr == null) {
                if (strArr.length > 1) {
                    throw new IllegalStateException("Then confidences array is null, query must be one or zero item length");
                }
            }
            if (fArr != null) {
                if (strArr.length != fArr.length) {
                    throw new IllegalStateException("Query and confidence arrays must be equals size");
                }
            }
            this.f7887a = strArr;
            this.f7888b = fArr;
            return;
        }
        throw new IllegalStateException("Query array must not be null");
    }

    /* renamed from: a */
    public void m9037a(List<Object> list) {
        this.f7889c = list;
    }

    public String toString() {
        return String.format("AIRequest{query=%s, resetContexts=%s, language='%s', timezone='%s'}", new Object[]{Arrays.toString(this.f7887a), this.f7890d, m56b(), m54a()});
    }
}
