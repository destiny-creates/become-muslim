package com.google.p127a.p132d;

import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* compiled from: JsonWriter */
/* renamed from: com.google.a.d.c */
public class C2154c implements Closeable, Flushable {
    /* renamed from: a */
    private static final String[] f5164a = new String[128];
    /* renamed from: b */
    private static final String[] f5165b = ((String[]) f5164a.clone());
    /* renamed from: c */
    private final Writer f5166c;
    /* renamed from: d */
    private int[] f5167d = new int[32];
    /* renamed from: e */
    private int f5168e = 0;
    /* renamed from: f */
    private String f5169f;
    /* renamed from: g */
    private String f5170g;
    /* renamed from: h */
    private boolean f5171h;
    /* renamed from: i */
    private boolean f5172i;
    /* renamed from: j */
    private String f5173j;
    /* renamed from: k */
    private boolean f5174k;

    static {
        for (int i = 0; i <= 31; i++) {
            f5164a[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        f5164a[34] = "\\\"";
        f5164a[92] = "\\\\";
        f5164a[9] = "\\t";
        f5164a[8] = "\\b";
        f5164a[10] = "\\n";
        f5164a[13] = "\\r";
        f5164a[12] = "\\f";
        f5165b[60] = "\\u003c";
        f5165b[62] = "\\u003e";
        f5165b[38] = "\\u0026";
        f5165b[61] = "\\u003d";
        f5165b[39] = "\\u0027";
    }

    public C2154c(Writer writer) {
        m5937a(6);
        this.f5170g = ":";
        this.f5174k = true;
        if (writer != null) {
            this.f5166c = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    /* renamed from: c */
    public final void m5952c(String str) {
        if (str.length() == 0) {
            this.f5169f = null;
            this.f5170g = ":";
            return;
        }
        this.f5169f = str;
        this.f5170g = ": ";
    }

    /* renamed from: b */
    public final void m5950b(boolean z) {
        this.f5171h = z;
    }

    /* renamed from: g */
    public boolean m5958g() {
        return this.f5171h;
    }

    /* renamed from: c */
    public final void m5953c(boolean z) {
        this.f5172i = z;
    }

    /* renamed from: h */
    public final boolean m5959h() {
        return this.f5172i;
    }

    /* renamed from: d */
    public final void m5955d(boolean z) {
        this.f5174k = z;
    }

    /* renamed from: i */
    public final boolean m5960i() {
        return this.f5174k;
    }

    /* renamed from: b */
    public C2154c mo2015b() {
        m5941j();
        return m5936a(1, "[");
    }

    /* renamed from: c */
    public C2154c mo2017c() {
        return m5935a(1, 2, "]");
    }

    /* renamed from: d */
    public C2154c mo2019d() {
        m5941j();
        return m5936a(3, "{");
    }

    /* renamed from: e */
    public C2154c mo2020e() {
        return m5935a(3, 5, "}");
    }

    /* renamed from: a */
    private C2154c m5936a(int i, String str) {
        m5940e(true);
        m5937a(i);
        this.f5166c.write(str);
        return this;
    }

    /* renamed from: a */
    private C2154c m5935a(int i, int i2, String str) {
        int a = mo2014a();
        if (a != i2) {
            if (a != i) {
                throw new IllegalStateException("Nesting problem.");
            }
        }
        if (this.f5173j == 0) {
            this.f5168e--;
            if (a == i2) {
                m5942k();
            }
            this.f5166c.write(str);
            return this;
        }
        i2 = new StringBuilder();
        i2.append("Dangling name: ");
        i2.append(this.f5173j);
        throw new IllegalStateException(i2.toString());
    }

    /* renamed from: a */
    private void m5937a(int i) {
        if (this.f5168e == this.f5167d.length) {
            Object obj = new int[(this.f5168e * 2)];
            System.arraycopy(this.f5167d, 0, obj, 0, this.f5168e);
            this.f5167d = obj;
        }
        int[] iArr = this.f5167d;
        int i2 = this.f5168e;
        this.f5168e = i2 + 1;
        iArr[i2] = i;
    }

    /* renamed from: a */
    private int mo2014a() {
        if (this.f5168e != 0) {
            return this.f5167d[this.f5168e - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* renamed from: b */
    private void m5938b(int i) {
        this.f5167d[this.f5168e - 1] = i;
    }

    /* renamed from: a */
    public C2154c mo2012a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f5173j != null) {
            throw new IllegalStateException();
        } else if (this.f5168e != 0) {
            this.f5173j = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    /* renamed from: j */
    private void m5941j() {
        if (this.f5173j != null) {
            m5943l();
            m5939d(this.f5173j);
            this.f5173j = null;
        }
    }

    /* renamed from: b */
    public C2154c mo2016b(String str) {
        if (str == null) {
            return mo2021f();
        }
        m5941j();
        m5940e(false);
        m5939d(str);
        return this;
    }

    /* renamed from: f */
    public C2154c mo2021f() {
        if (this.f5173j != null) {
            if (this.f5174k) {
                m5941j();
            } else {
                this.f5173j = null;
                return this;
            }
        }
        m5940e(false);
        this.f5166c.write("null");
        return this;
    }

    /* renamed from: a */
    public C2154c mo2013a(boolean z) {
        m5941j();
        m5940e(false);
        this.f5166c.write(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    /* renamed from: a */
    public C2154c mo2010a(long j) {
        m5941j();
        m5940e(false);
        this.f5166c.write(Long.toString(j));
        return this;
    }

    /* renamed from: a */
    public C2154c mo2011a(Number number) {
        if (number == null) {
            return mo2021f();
        }
        m5941j();
        CharSequence obj = number.toString();
        if (!this.f5171h) {
            if (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Numeric values must be finite, but was ");
                stringBuilder.append(number);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        m5940e(null);
        this.f5166c.append(obj);
        return this;
    }

    public void flush() {
        if (this.f5168e != 0) {
            this.f5166c.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public void close() {
        this.f5166c.close();
        int i = this.f5168e;
        if (i > 1 || (i == 1 && this.f5167d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f5168e = 0;
    }

    /* renamed from: d */
    private void m5939d(String str) {
        String[] strArr = this.f5172i ? f5165b : f5164a;
        this.f5166c.write("\"");
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            String str2;
            char charAt = str.charAt(i2);
            if (charAt < '') {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == ' ') {
                str2 = "\\u2028";
            } else if (charAt == ' ') {
                str2 = "\\u2029";
            } else {
            }
            if (i < i2) {
                this.f5166c.write(str, i, i2 - i);
            }
            this.f5166c.write(str2);
            i = i2 + 1;
        }
        if (i < length) {
            this.f5166c.write(str, i, length - i);
        }
        this.f5166c.write("\"");
    }

    /* renamed from: k */
    private void m5942k() {
        if (this.f5169f != null) {
            this.f5166c.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            int i = this.f5168e;
            for (int i2 = 1; i2 < i; i2++) {
                this.f5166c.write(this.f5169f);
            }
        }
    }

    /* renamed from: l */
    private void m5943l() {
        int a = mo2014a();
        if (a == 5) {
            this.f5166c.write(44);
        } else if (a != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m5942k();
        m5938b(4);
    }

    /* renamed from: e */
    private void m5940e(boolean z) {
        switch (mo2014a()) {
            case 1:
                m5938b((int) true);
                m5942k();
                return;
            case 2:
                this.f5166c.append(',');
                m5942k();
                return;
            case 4:
                this.f5166c.append(this.f5170g);
                m5938b((int) true);
                return;
            case 6:
                break;
            case 7:
                if (this.f5171h) {
                    break;
                }
                throw new IllegalStateException("JSON must have only one top-level value.");
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        if (!this.f5171h) {
            if (!z) {
                throw new IllegalStateException("JSON must start with an array or an object.");
            }
        }
        m5938b((int) true);
    }
}
