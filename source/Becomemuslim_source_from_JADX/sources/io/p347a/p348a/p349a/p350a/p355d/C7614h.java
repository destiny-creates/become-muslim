package io.p347a.p348a.p349a.p350a.p355d;

import android.content.Context;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p352b.C6441q;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: QueueFileEventStorage */
/* renamed from: io.a.a.a.a.d.h */
public class C7614h implements C6471c {
    /* renamed from: a */
    private final Context f26317a;
    /* renamed from: b */
    private final File f26318b;
    /* renamed from: c */
    private final String f26319c;
    /* renamed from: d */
    private final File f26320d;
    /* renamed from: e */
    private C6441q f26321e = new C6441q(this.f26320d);
    /* renamed from: f */
    private File f26322f;

    public C7614h(Context context, File file, String str, String str2) {
        this.f26317a = context;
        this.f26318b = file;
        this.f26319c = str2;
        this.f26320d = new File(this.f26318b, str);
        m34376e();
    }

    /* renamed from: e */
    private void m34376e() {
        this.f26322f = new File(this.f26318b, this.f26319c);
        if (!this.f26322f.exists()) {
            this.f26322f.mkdirs();
        }
    }

    /* renamed from: a */
    public void mo5451a(byte[] bArr) {
        this.f26321e.m26442a(bArr);
    }

    /* renamed from: a */
    public int mo5447a() {
        return this.f26321e.m26440a();
    }

    /* renamed from: a */
    public void mo5449a(String str) {
        this.f26321e.close();
        m34375a(this.f26320d, new File(this.f26322f, str));
        this.f26321e = new C6441q(this.f26320d);
    }

    /* renamed from: a */
    private void m34375a(File file, File file2) {
        Closeable closeable = null;
        Closeable fileInputStream;
        try {
            Closeable a;
            fileInputStream = new FileInputStream(file);
            try {
                a = mo6414a(file2);
            } catch (Throwable th) {
                file2 = th;
                C6428i.m26367a(fileInputStream, "Failed to close file input stream");
                C6428i.m26367a(closeable, "Failed to close output stream");
                file.delete();
                throw file2;
            }
            try {
                C6428i.m26369a((InputStream) fileInputStream, (OutputStream) a, new byte[1024]);
                C6428i.m26367a(fileInputStream, "Failed to close file input stream");
                C6428i.m26367a(a, "Failed to close output stream");
                file.delete();
            } catch (Throwable th2) {
                Throwable th3 = th2;
                closeable = a;
                file2 = th3;
                C6428i.m26367a(fileInputStream, "Failed to close file input stream");
                C6428i.m26367a(closeable, "Failed to close output stream");
                file.delete();
                throw file2;
            }
        } catch (Throwable th4) {
            file2 = th4;
            fileInputStream = null;
            C6428i.m26367a(fileInputStream, "Failed to close file input stream");
            C6428i.m26367a(closeable, "Failed to close output stream");
            file.delete();
            throw file2;
        }
    }

    /* renamed from: a */
    public OutputStream mo6414a(File file) {
        return new FileOutputStream(file);
    }

    /* renamed from: a */
    public List<File> mo5448a(int i) {
        List<File> arrayList = new ArrayList();
        for (Object add : this.f26322f.listFiles()) {
            arrayList.add(add);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo5450a(List<File> list) {
        for (File file : list) {
            C6428i.m26364a(this.f26317a, String.format("deleting sent analytics file %s", new Object[]{file.getName()}));
            file.delete();
        }
    }

    /* renamed from: c */
    public List<File> mo5454c() {
        return Arrays.asList(this.f26322f.listFiles());
    }

    /* renamed from: d */
    public void mo5455d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.f26321e;	 Catch:{ IOException -> 0x0005 }
        r0.close();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        r0 = r1.f26320d;
        r0.delete();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.d.h.d():void");
    }

    /* renamed from: b */
    public boolean mo5453b() {
        return this.f26321e.m26445b();
    }

    /* renamed from: a */
    public boolean mo5452a(int i, int i2) {
        return this.f26321e.m26444a(i, i2);
    }
}
