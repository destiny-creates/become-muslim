package com.bugsnag.android;

import android.content.Context;
import java.io.File;
import java.util.Comparator;
import java.util.Locale;
import java.util.UUID;

/* compiled from: SessionStore */
class ak extends C1108y<aj> {
    /* renamed from: a */
    static final Comparator<File> f9182a = new C10721();

    /* compiled from: SessionStore */
    /* renamed from: com.bugsnag.android.ak$1 */
    static class C10721 implements Comparator<File> {
        C10721() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m3740a((File) obj, (File) obj2);
        }

        /* renamed from: a */
        public int m3740a(File file, File file2) {
            if (file == null && file2 == null) {
                return null;
            }
            if (file == null) {
                return 1;
            }
            if (file2 == null) {
                return -1;
            }
            return file.getName().compareTo(file2.getName());
        }
    }

    ak(C1091l c1091l, Context context) {
        super(c1091l, context, "/bugsnag-sessions/", 128, f9182a);
    }

    /* renamed from: a */
    String mo778a(Object obj) {
        return String.format(Locale.US, "%s%s%d.json", new Object[]{this.d, UUID.randomUUID().toString(), Long.valueOf(System.currentTimeMillis())});
    }
}
