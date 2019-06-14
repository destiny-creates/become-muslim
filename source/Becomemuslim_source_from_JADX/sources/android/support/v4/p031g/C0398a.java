package android.support.v4.p031g;

import android.support.v4.util.C0462k;
import android.util.Base64;
import java.util.List;

/* compiled from: FontRequest */
/* renamed from: android.support.v4.g.a */
public final class C0398a {
    /* renamed from: a */
    private final String f1021a;
    /* renamed from: b */
    private final String f1022b;
    /* renamed from: c */
    private final String f1023c;
    /* renamed from: d */
    private final List<List<byte[]>> f1024d;
    /* renamed from: e */
    private final int f1025e = null;
    /* renamed from: f */
    private final String f1026f;

    public C0398a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f1021a = (String) C0462k.m1451a(str);
        this.f1022b = (String) C0462k.m1451a(str2);
        this.f1023c = (String) C0462k.m1451a(str3);
        this.f1024d = (List) C0462k.m1451a(list);
        str = new StringBuilder(this.f1021a);
        str.append("-");
        str.append(this.f1022b);
        str.append("-");
        str.append(this.f1023c);
        this.f1026f = str.toString();
    }

    /* renamed from: a */
    public String m1178a() {
        return this.f1021a;
    }

    /* renamed from: b */
    public String m1179b() {
        return this.f1022b;
    }

    /* renamed from: c */
    public String m1180c() {
        return this.f1023c;
    }

    /* renamed from: d */
    public List<List<byte[]>> m1181d() {
        return this.f1024d;
    }

    /* renamed from: e */
    public int m1182e() {
        return this.f1025e;
    }

    /* renamed from: f */
    public String m1183f() {
        return this.f1026f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("FontRequest {mProviderAuthority: ");
        stringBuilder2.append(this.f1021a);
        stringBuilder2.append(", mProviderPackage: ");
        stringBuilder2.append(this.f1022b);
        stringBuilder2.append(", mQuery: ");
        stringBuilder2.append(this.f1023c);
        stringBuilder2.append(", mCertificates:");
        stringBuilder.append(stringBuilder2.toString());
        for (int i = 0; i < this.f1024d.size(); i++) {
            stringBuilder.append(" [");
            List list = (List) this.f1024d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                stringBuilder.append(" \"");
                stringBuilder.append(Base64.encodeToString((byte[]) list.get(i2), 0));
                stringBuilder.append("\"");
            }
            stringBuilder.append(" ]");
        }
        stringBuilder.append("}");
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("mCertificatesArray: ");
        stringBuilder2.append(this.f1025e);
        stringBuilder.append(stringBuilder2.toString());
        return stringBuilder.toString();
    }
}
