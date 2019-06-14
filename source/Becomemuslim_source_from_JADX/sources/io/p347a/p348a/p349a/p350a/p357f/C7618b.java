package io.p347a.p348a.p349a.p350a.p357f;

import android.content.Context;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6520i;
import java.io.File;

/* compiled from: FileStoreImpl */
/* renamed from: io.a.a.a.a.f.b */
public class C7618b implements C6489a {
    /* renamed from: a */
    private final Context f26329a;
    /* renamed from: b */
    private final String f26330b;
    /* renamed from: c */
    private final String f26331c;

    public C7618b(C6520i c6520i) {
        if (c6520i.m26655E() != null) {
            this.f26329a = c6520i.m26655E();
            this.f26330b = c6520i.m26657G();
            c6520i = new StringBuilder();
            c6520i.append("Android/");
            c6520i.append(this.f26329a.getPackageName());
            this.f26331c = c6520i.toString();
            return;
        }
        throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    }

    /* renamed from: a */
    public File mo5461a() {
        return m34397a(this.f26329a.getFilesDir());
    }

    /* renamed from: a */
    File m34397a(File file) {
        if (file != null) {
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    C6514c.m26634h().mo5477d("Fabric", "Couldn't create file");
                }
            }
            return file;
        }
        C6514c.m26634h().mo5472a("Fabric", "Null File");
        return null;
    }
}
