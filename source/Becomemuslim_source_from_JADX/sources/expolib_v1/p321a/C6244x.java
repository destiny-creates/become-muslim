package expolib_v1.p321a;

import java.io.IOException;

/* compiled from: Protocol */
/* renamed from: expolib_v1.a.x */
public enum C6244x {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    
    /* renamed from: e */
    private final String f20361e;

    private C6244x(String str) {
        this.f20361e = str;
    }

    /* renamed from: a */
    public static C6244x m25807a(String str) {
        if (str.equals(HTTP_1_0.f20361e)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f20361e)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.f20361e)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f20361e)) {
            return SPDY_3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected protocol: ");
        stringBuilder.append(str);
        throw new IOException(stringBuilder.toString());
    }

    public String toString() {
        return this.f20361e;
    }
}
