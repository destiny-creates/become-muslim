package com.bugsnag.android;

import android.content.Context;
import com.bugsnag.android.ab.C1071a;
import com.facebook.stetho.common.Utf8Charset;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: FileStore */
/* renamed from: com.bugsnag.android.y */
abstract class C1108y<T extends C1071a> {
    /* renamed from: a */
    private final int f3119a;
    /* renamed from: b */
    private final Comparator<File> f3120b;
    /* renamed from: c */
    protected final C1091l f3121c;
    /* renamed from: d */
    final String f3122d;
    /* renamed from: e */
    final Lock f3123e = new ReentrantLock();
    /* renamed from: f */
    final Collection<File> f3124f = new ConcurrentSkipListSet();

    /* renamed from: a */
    abstract String mo778a(Object obj);

    C1108y(C1091l c1091l, Context context, String str, int i, Comparator<File> comparator) {
        this.f3121c = c1091l;
        this.f3119a = i;
        this.f3120b = comparator;
        c1091l = null;
        try {
            i = new StringBuilder();
            i.append(context.getCacheDir().getAbsolutePath());
            i.append(str);
            context = i.toString();
            str = new File(context);
            str.mkdirs();
            if (str.exists() == null) {
                ad.m3736b("Could not prepare file storage directory");
            } else {
                c1091l = context;
            }
        } catch (Context context2) {
            ad.m3733a("Could not prepare file storage directory", context2);
        }
        this.f3122d = c1091l;
    }

    /* renamed from: a */
    void m3931a(String str) {
        String str2;
        Object[] objArr;
        if (this.f3122d != null) {
            String a = mo778a((Object) str);
            m3933c();
            this.f3123e.lock();
            Writer writer = null;
            try {
                Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(a), Utf8Charset.NAME));
                try {
                    bufferedWriter.write(str);
                } catch (Exception e) {
                    str = e;
                    writer = bufferedWriter;
                    try {
                        ad.m3733a(String.format("Couldn't save unsent payload to disk (%s) ", new Object[]{a}), str);
                        if (writer != null) {
                            try {
                                writer.close();
                            } catch (Exception e2) {
                                str = e2;
                                str2 = "Failed to close unsent payload writer (%s) ";
                                objArr = new Object[]{a};
                                ad.m3733a(String.format(str2, objArr), str);
                                this.f3123e.unlock();
                            }
                        }
                        this.f3123e.unlock();
                    } catch (Throwable th) {
                        str = th;
                        if (writer != null) {
                            try {
                                writer.close();
                            } catch (Throwable e3) {
                                ad.m3733a(String.format("Failed to close unsent payload writer (%s) ", new Object[]{a}), e3);
                            }
                        }
                        this.f3123e.unlock();
                        throw str;
                    }
                } catch (Throwable th2) {
                    str = th2;
                    writer = bufferedWriter;
                    if (writer != null) {
                        writer.close();
                    }
                    this.f3123e.unlock();
                    throw str;
                }
                try {
                    bufferedWriter.close();
                } catch (Exception e4) {
                    str = e4;
                    str2 = "Failed to close unsent payload writer (%s) ";
                    objArr = new Object[]{a};
                    ad.m3733a(String.format(str2, objArr), str);
                    this.f3123e.unlock();
                }
            } catch (Exception e5) {
                str = e5;
                ad.m3733a(String.format("Couldn't save unsent payload to disk (%s) ", new Object[]{a}), str);
                if (writer != null) {
                    writer.close();
                }
                this.f3123e.unlock();
            }
            this.f3123e.unlock();
        }
    }

    /* renamed from: a */
    String m3929a(C1071a c1071a) {
        if (this.f3122d == null) {
            return null;
        }
        m3933c();
        String a = mo778a((Object) c1071a);
        this.f3123e.lock();
        Closeable abVar;
        try {
            abVar = new ab(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(a), Utf8Charset.NAME)));
            try {
                abVar.m11021a(c1071a);
                ad.m3732a(String.format("Saved unsent payload to disk (%s) ", new Object[]{a}));
                aa.m3708a(abVar);
                this.f3123e.unlock();
                return a;
            } catch (Exception e) {
                c1071a = e;
                try {
                    ad.m3733a(String.format("Couldn't save unsent payload to disk (%s) ", new Object[]{a}), c1071a);
                    aa.m3708a(abVar);
                    this.f3123e.unlock();
                    return null;
                } catch (Throwable th) {
                    c1071a = th;
                    aa.m3708a(abVar);
                    this.f3123e.unlock();
                    throw c1071a;
                }
            }
        } catch (Exception e2) {
            c1071a = e2;
            abVar = null;
            ad.m3733a(String.format("Couldn't save unsent payload to disk (%s) ", new Object[]{a}), c1071a);
            aa.m3708a(abVar);
            this.f3123e.unlock();
            return null;
        } catch (Throwable th2) {
            c1071a = th2;
            abVar = null;
            aa.m3708a(abVar);
            this.f3123e.unlock();
            throw c1071a;
        }
    }

    /* renamed from: c */
    void m3933c() {
        File file = new File(this.f3122d);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length >= this.f3119a) {
                Arrays.sort(listFiles, this.f3120b);
                for (int i = 0; i < listFiles.length && listFiles.length >= this.f3119a; i++) {
                    File file2 = listFiles[i];
                    if (!this.f3124f.contains(file2)) {
                        ad.m3736b(String.format("Discarding oldest error as stored error limit reached (%s)", new Object[]{file2.getPath()}));
                        m3934c(Collections.singleton(file2));
                    }
                }
            }
        }
    }

    /* renamed from: d */
    List<File> m3935d() {
        this.f3123e.lock();
        try {
            List<File> arrayList = new ArrayList();
            if (this.f3122d != null) {
                File file = new File(this.f3122d);
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            if (file2.isFile() && !this.f3124f.contains(file2)) {
                                arrayList.add(file2);
                            }
                        }
                    }
                }
            }
            this.f3124f.addAll(arrayList);
            return arrayList;
        } finally {
            this.f3123e.unlock();
        }
    }

    /* renamed from: b */
    void m3932b(Collection<File> collection) {
        this.f3123e.lock();
        if (collection != null) {
            try {
                this.f3124f.removeAll(collection);
            } catch (Throwable th) {
                this.f3123e.unlock();
            }
        }
        this.f3123e.unlock();
    }

    /* renamed from: c */
    void m3934c(Collection<File> collection) {
        this.f3123e.lock();
        if (collection != null) {
            try {
                this.f3124f.removeAll(collection);
                for (File file : collection) {
                    if (!file.delete()) {
                        file.deleteOnExit();
                    }
                }
            } catch (Throwable th) {
                this.f3123e.unlock();
            }
        }
        this.f3123e.unlock();
    }
}
