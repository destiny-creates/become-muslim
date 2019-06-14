package com.google.android.exoplayer2.p163k;

import android.text.TextUtils;
import com.google.android.exoplayer2.p163k.C2498g.C2497a;
import com.google.android.exoplayer2.p164l.C2531n;
import com.google.android.exoplayer2.p164l.C2541v;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: HttpDataSource */
/* renamed from: com.google.android.exoplayer2.k.r */
public interface C4250r extends C2498g {
    /* renamed from: a */
    public static final C2531n<String> f11214a = new C42461();

    /* compiled from: HttpDataSource */
    /* renamed from: com.google.android.exoplayer2.k.r$c */
    public static class C2504c extends IOException {
        /* renamed from: a */
        public final int f6360a;
        /* renamed from: b */
        public final C2501j f6361b;

        public C2504c(String str, C2501j c2501j, int i) {
            super(str);
            this.f6361b = c2501j;
            this.f6360a = i;
        }

        public C2504c(IOException iOException, C2501j c2501j, int i) {
            super(iOException);
            this.f6361b = c2501j;
            this.f6360a = i;
        }

        public C2504c(String str, IOException iOException, C2501j c2501j, int i) {
            super(str, iOException);
            this.f6361b = c2501j;
            this.f6360a = i;
        }
    }

    /* compiled from: HttpDataSource */
    /* renamed from: com.google.android.exoplayer2.k.r$f */
    public static final class C2505f {
        /* renamed from: a */
        private final Map<String, String> f6362a = new HashMap();
        /* renamed from: b */
        private Map<String, String> f6363b;

        /* renamed from: a */
        public synchronized void m6961a(String str, String str2) {
            this.f6363b = null;
            this.f6362a.put(str, str2);
        }

        /* renamed from: a */
        public synchronized void m6960a(String str) {
            this.f6363b = null;
            this.f6362a.remove(str);
        }

        /* renamed from: a */
        public synchronized void m6959a() {
            this.f6363b = null;
            this.f6362a.clear();
        }

        /* renamed from: b */
        public synchronized Map<String, String> m6962b() {
            if (this.f6363b == null) {
                this.f6363b = Collections.unmodifiableMap(new HashMap(this.f6362a));
            }
            return this.f6363b;
        }
    }

    /* compiled from: HttpDataSource */
    /* renamed from: com.google.android.exoplayer2.k.r$1 */
    static class C42461 implements C2531n<String> {
        C42461() {
        }

        /* renamed from: a */
        public boolean m13792a(String str) {
            str = C2541v.m7190d(str);
            return (TextUtils.isEmpty(str) || ((str.contains("text") && !str.contains("text/vtt")) || str.contains("html") || str.contains("xml") != null)) ? null : true;
        }
    }

    /* renamed from: com.google.android.exoplayer2.k.r$b */
    public interface C4247b extends C2497a {
    }

    /* compiled from: HttpDataSource */
    /* renamed from: com.google.android.exoplayer2.k.r$d */
    public static final class C4248d extends C2504c {
        /* renamed from: c */
        public final String f11211c;

        public C4248d(String str, C2501j c2501j) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid content type: ");
            stringBuilder.append(str);
            super(stringBuilder.toString(), c2501j, 1);
            this.f11211c = str;
        }
    }

    /* compiled from: HttpDataSource */
    /* renamed from: com.google.android.exoplayer2.k.r$e */
    public static final class C4249e extends C2504c {
        /* renamed from: c */
        public final int f11212c;
        /* renamed from: d */
        public final Map<String, List<String>> f11213d;

        public C4249e(int i, Map<String, List<String>> map, C2501j c2501j) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Response code: ");
            stringBuilder.append(i);
            super(stringBuilder.toString(), c2501j, 1);
            this.f11212c = i;
            this.f11213d = map;
        }
    }

    /* compiled from: HttpDataSource */
    /* renamed from: com.google.android.exoplayer2.k.r$a */
    public static abstract class C4733a implements C4247b {
        private final C2505f defaultRequestProperties = new C2505f();

        protected abstract C4250r createDataSourceInternal(C2505f c2505f);

        public final C4250r createDataSource() {
            return createDataSourceInternal(this.defaultRequestProperties);
        }

        public final C2505f getDefaultRequestProperties() {
            return this.defaultRequestProperties;
        }

        @Deprecated
        public final void setDefaultRequestProperty(String str, String str2) {
            this.defaultRequestProperties.m6961a(str, str2);
        }

        @Deprecated
        public final void clearDefaultRequestProperty(String str) {
            this.defaultRequestProperties.m6960a(str);
        }

        @Deprecated
        public final void clearAllDefaultRequestProperties() {
            this.defaultRequestProperties.m6959a();
        }
    }
}
