package io.nlopez.smartlocation.p364b;

import android.util.Log;

/* compiled from: LoggerFactory */
/* renamed from: io.nlopez.smartlocation.b.c */
public class C6540c {

    /* compiled from: LoggerFactory */
    /* renamed from: io.nlopez.smartlocation.b.c$a */
    private static class C7634a implements C6538b {
        private C7634a() {
        }

        /* renamed from: a */
        private String m34484a() {
            return new Exception().getStackTrace()[3].getMethodName();
        }

        /* renamed from: e */
        private String m34485e(String str, Object... objArr) {
            return objArr.length == 0 ? str : String.format(str, objArr);
        }

        /* renamed from: a */
        public void mo5497a(String str, Object... objArr) {
            Log.d(m34484a(), m34485e(str, objArr));
        }

        /* renamed from: b */
        public void mo5499b(String str, Object... objArr) {
            Log.i(m34484a(), m34485e(str, objArr));
        }

        /* renamed from: c */
        public void mo5500c(String str, Object... objArr) {
            Log.w(m34484a(), m34485e(str, objArr));
        }

        /* renamed from: d */
        public void mo5501d(String str, Object... objArr) {
            Log.e(m34484a(), m34485e(str, objArr));
        }

        /* renamed from: a */
        public void mo5498a(Throwable th, String str, Object... objArr) {
            Log.e(m34484a(), m34485e(str, objArr), th);
        }
    }

    /* compiled from: LoggerFactory */
    /* renamed from: io.nlopez.smartlocation.b.c$b */
    private static class C7635b implements C6538b {
        /* renamed from: a */
        public void mo5497a(String str, Object... objArr) {
        }

        /* renamed from: a */
        public void mo5498a(Throwable th, String str, Object... objArr) {
        }

        /* renamed from: b */
        public void mo5499b(String str, Object... objArr) {
        }

        /* renamed from: c */
        public void mo5500c(String str, Object... objArr) {
        }

        /* renamed from: d */
        public void mo5501d(String str, Object... objArr) {
        }

        private C7635b() {
        }
    }

    /* renamed from: a */
    public static C6538b m26716a(boolean z) {
        return z ? new C7634a() : new C7635b();
    }
}
