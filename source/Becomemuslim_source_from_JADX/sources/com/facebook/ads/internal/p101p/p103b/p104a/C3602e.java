package com.facebook.ads.internal.p101p.p103b.p104a;

import android.util.Log;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.facebook.ads.internal.p.b.a.e */
abstract class C3602e implements C1455a {
    /* renamed from: a */
    private final ExecutorService f9609a = Executors.newSingleThreadExecutor();

    /* renamed from: com.facebook.ads.internal.p.b.a.e$a */
    private class C1460a implements Callable<Void> {
        /* renamed from: a */
        final /* synthetic */ C3602e f4311a;
        /* renamed from: b */
        private final File f4312b;

        public C1460a(C3602e c3602e, File file) {
            this.f4311a = c3602e;
            this.f4312b = file;
        }

        /* renamed from: a */
        public Void m5166a() {
            this.f4311a.m11743b(this.f4312b);
            return null;
        }

        public /* synthetic */ Object call() {
            return m5166a();
        }
    }

    C3602e() {
    }

    /* renamed from: a */
    private void m11741a(List<File> list) {
        long b = m11742b((List) list);
        int size = list.size();
        for (File file : list) {
            if (!mo2870a(file, b, size)) {
                long length = file.length();
                StringBuilder stringBuilder;
                if (file.delete()) {
                    size--;
                    b -= length;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Cache file ");
                    stringBuilder.append(file);
                    stringBuilder.append(" is deleted because it exceeds cache limit");
                    Log.i("ProxyCache", stringBuilder.toString());
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Error deleting file ");
                    stringBuilder.append(file);
                    stringBuilder.append(" for trimming cache");
                    Log.e("ProxyCache", stringBuilder.toString());
                }
            }
        }
    }

    /* renamed from: b */
    private long m11742b(List<File> list) {
        long j = 0;
        for (File length : list) {
            j += length.length();
        }
        return j;
    }

    /* renamed from: b */
    private void m11743b(File file) {
        C1459d.m5163c(file);
        m11741a(C1459d.m5162b(file.getParentFile()));
    }

    /* renamed from: a */
    public void mo988a(File file) {
        this.f9609a.submit(new C1460a(this, file));
    }

    /* renamed from: a */
    protected abstract boolean mo2870a(File file, long j, int i);
}
