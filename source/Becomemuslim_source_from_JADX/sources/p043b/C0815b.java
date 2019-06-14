package p043b;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* compiled from: AppLink */
/* renamed from: b.b */
public class C0815b {
    /* renamed from: a */
    private Uri f2272a;
    /* renamed from: b */
    private List<C0814a> f2273b;
    /* renamed from: c */
    private Uri f2274c;

    /* compiled from: AppLink */
    /* renamed from: b.b$a */
    public static class C0814a {
        /* renamed from: a */
        private final Uri f2268a;
        /* renamed from: b */
        private final String f2269b;
        /* renamed from: c */
        private final String f2270c;
        /* renamed from: d */
        private final String f2271d;

        public C0814a(String str, String str2, Uri uri, String str3) {
            this.f2269b = str;
            this.f2270c = str2;
            this.f2268a = uri;
            this.f2271d = str3;
        }
    }

    public C0815b(Uri uri, List<C0814a> list, Uri uri2) {
        this.f2272a = uri;
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f2273b = list;
        this.f2274c = uri2;
    }
}
