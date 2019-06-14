package android.support.v4.util;

import android.util.Log;
import java.io.Writer;

/* compiled from: LogWriter */
/* renamed from: android.support.v4.util.e */
public class C0451e extends Writer {
    /* renamed from: a */
    private final String f1159a;
    /* renamed from: b */
    private StringBuilder f1160b = new StringBuilder(128);

    public C0451e(String str) {
        this.f1159a = str;
    }

    public void close() {
        m1409a();
    }

    public void flush() {
        m1409a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m1409a();
            } else {
                this.f1160b.append(c);
            }
        }
    }

    /* renamed from: a */
    private void m1409a() {
        if (this.f1160b.length() > 0) {
            Log.d(this.f1159a, this.f1160b.toString());
            this.f1160b.delete(0, this.f1160b.length());
        }
    }
}
