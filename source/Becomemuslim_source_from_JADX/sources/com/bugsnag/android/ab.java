package com.bugsnag.android;

import com.facebook.stetho.common.Utf8Charset;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Writer;

/* compiled from: JsonStream */
public class ab extends ac {
    /* renamed from: a */
    private final ah f9162a = new ah();
    /* renamed from: b */
    private final Writer f9163b;

    /* compiled from: JsonStream */
    /* renamed from: com.bugsnag.android.ab$a */
    public interface C1071a {
        void toStream(ab abVar);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ ac mo765a() {
        return super.mo765a();
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ ac mo770b() {
        return super.mo770b();
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ ac mo771b(String str) {
        return super.mo771b(str);
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ ac mo772c() {
        return super.mo772c();
    }

    /* renamed from: c */
    public /* synthetic */ ac mo773c(String str) {
        return mo764a(str);
    }

    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ ac mo775d() {
        return super.mo775d();
    }

    /* renamed from: e */
    public /* bridge */ /* synthetic */ ac mo776e() {
        return super.mo776e();
    }

    public /* bridge */ /* synthetic */ void flush() {
        super.flush();
    }

    public ab(Writer writer) {
        super(writer);
        m3726b(false);
        this.f9163b = writer;
    }

    /* renamed from: a */
    public ab mo764a(String str) {
        super.mo773c(str);
        return this;
    }

    /* renamed from: a */
    public void m11021a(C1071a c1071a) {
        if (c1071a == null) {
            mo765a();
        } else {
            c1071a.toStream(this);
        }
    }

    /* renamed from: a */
    public void m11023a(Object obj) {
        this.f9162a.m3739a(obj, this);
    }

    /* renamed from: a */
    public void m11022a(File file) {
        if (file != null) {
            if (file.length() > 0) {
                super.flush();
                m3731f();
                Closeable closeable = null;
                try {
                    Closeable bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Utf8Charset.NAME));
                    try {
                        aa.m3707a(bufferedReader, this.f9163b);
                        aa.m3708a(bufferedReader);
                        this.f9163b.flush();
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        closeable = bufferedReader;
                        file = th2;
                        aa.m3708a(closeable);
                        throw file;
                    }
                } catch (Throwable th3) {
                    file = th3;
                    aa.m3708a(closeable);
                    throw file;
                }
            }
        }
    }
}
