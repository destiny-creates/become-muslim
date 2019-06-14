package ai.api.p007c;

import ai.api.C0036f;
import java.io.Serializable;

/* compiled from: AIError */
/* renamed from: ai.api.c.a */
public class C0012a implements Serializable {
    private static final long serialVersionUID = 1;
    /* renamed from: a */
    private final String f51a;
    /* renamed from: b */
    private final C0013c f52b;
    /* renamed from: c */
    private C0036f f53c;

    public C0012a(String str) {
        this.f52b = null;
        this.f51a = str;
    }

    public C0012a(C0036f c0036f) {
        this.f52b = c0036f.m110a();
        this.f51a = c0036f.getMessage();
        this.f53c = c0036f;
    }

    public String toString() {
        if (this.f53c != null) {
            return this.f53c.toString();
        }
        return this.f51a;
    }
}
