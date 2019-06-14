package io.p347a.p348a.p349a.p350a.p355d;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: GZIPQueueFileEventStorage */
/* renamed from: io.a.a.a.a.d.g */
public class C8182g extends C7614h {
    public C8182g(Context context, File file, String str, String str2) {
        super(context, file, str, str2);
    }

    /* renamed from: a */
    public OutputStream mo6414a(File file) {
        return new GZIPOutputStream(new FileOutputStream(file));
    }
}
