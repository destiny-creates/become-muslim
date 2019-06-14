package com.bugsnag.android;

import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* compiled from: JsonWriter */
class ac implements Closeable, Flushable {
    /* renamed from: a */
    private static final String[] f3002a = new String[128];
    /* renamed from: b */
    private static final String[] f3003b = ((String[]) f3002a.clone());
    /* renamed from: c */
    private final Writer f3004c;
    /* renamed from: d */
    private int[] f3005d = new int[32];
    /* renamed from: e */
    private int f3006e = 0;
    /* renamed from: f */
    private String f3007f;
    /* renamed from: g */
    private String f3008g;
    /* renamed from: h */
    private boolean f3009h;
    /* renamed from: i */
    private boolean f3010i;
    /* renamed from: j */
    private String f3011j;
    /* renamed from: k */
    private boolean f3012k;

    static {
        for (int i = 0; i <= 31; i++) {
            f3002a[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        f3002a[34] = "\\\"";
        f3002a[92] = "\\\\";
        f3002a[9] = "\\t";
        f3002a[8] = "\\b";
        f3002a[10] = "\\n";
        f3002a[13] = "\\r";
        f3002a[12] = "\\f";
        f3003b[60] = "\\u003c";
        f3003b[62] = "\\u003e";
        f3003b[38] = "\\u0026";
        f3003b[61] = "\\u003d";
        f3003b[39] = "\\u0027";
    }

    public ac(Writer writer) {
        m3712a(6);
        this.f3008g = ":";
        this.f3012k = true;
        if (writer != null) {
            this.f3004c = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    /* renamed from: b */
    public final void m3726b(boolean z) {
        this.f3012k = z;
    }

    /* renamed from: e */
    public ac mo776e() {
        m3716h();
        return m3711a(1, "[");
    }

    /* renamed from: d */
    public ac mo775d() {
        return m3710a(1, 2, "]");
    }

    /* renamed from: c */
    public ac mo772c() {
        m3716h();
        return m3711a(3, "{");
    }

    /* renamed from: b */
    public ac mo770b() {
        return m3710a(3, 5, "}");
    }

    /* renamed from: a */
    private ac m3711a(int i, String str) {
        m3731f();
        m3712a(i);
        this.f3004c.write(str);
        return this;
    }

    /* renamed from: a */
    private ac m3710a(int i, int i2, String str) {
        int g = m3715g();
        if (g != i2) {
            if (g != i) {
                throw new IllegalStateException("Nesting problem.");
            }
        }
        if (this.f3011j == 0) {
            this.f3006e--;
            if (g == i2) {
                m3717i();
            }
            this.f3004c.write(str);
            return this;
        }
        i2 = new StringBuilder();
        i2.append("Dangling name: ");
        i2.append(this.f3011j);
        throw new IllegalStateException(i2.toString());
    }

    /* renamed from: a */
    private void m3712a(int i) {
        if (this.f3006e == this.f3005d.length) {
            Object obj = new int[(this.f3006e * 2)];
            System.arraycopy(this.f3005d, 0, obj, 0, this.f3006e);
            this.f3005d = obj;
        }
        int[] iArr = this.f3005d;
        int i2 = this.f3006e;
        this.f3006e = i2 + 1;
        iArr[i2] = i;
    }

    /* renamed from: g */
    private int m3715g() {
        if (this.f3006e != 0) {
            return this.f3005d[this.f3006e - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* renamed from: b */
    private void m3714b(int i) {
        this.f3005d[this.f3006e - 1] = i;
    }

    /* renamed from: c */
    public ac mo773c(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f3011j != null) {
            throw new IllegalStateException();
        } else if (this.f3006e != 0) {
            this.f3011j = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    /* renamed from: h */
    private void m3716h() {
        if (this.f3011j != null) {
            m3718j();
            mo764a(this.f3011j);
            this.f3011j = null;
        }
    }

    /* renamed from: b */
    public ac mo771b(String str) {
        if (str == null) {
            return mo765a();
        }
        m3716h();
        m3731f();
        mo764a(str);
        return this;
    }

    /* renamed from: a */
    public ac mo765a() {
        if (this.f3011j != null) {
            if (this.f3012k) {
                m3716h();
            } else {
                this.f3011j = null;
                return this;
            }
        }
        m3731f();
        this.f3004c.write("null");
        return this;
    }

    /* renamed from: a */
    public ac mo769a(boolean z) {
        m3716h();
        m3731f();
        this.f3004c.write(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    /* renamed from: a */
    public ac mo767a(Boolean bool) {
        if (bool == null) {
            return mo765a();
        }
        m3716h();
        m3731f();
        this.f3004c.write(bool.booleanValue() != null ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        return this;
    }

    /* renamed from: a */
    public ac mo766a(long j) {
        m3716h();
        m3731f();
        this.f3004c.write(Long.toString(j));
        return this;
    }

    /* renamed from: a */
    public ac mo768a(Number number) {
        if (number == null) {
            return mo765a();
        }
        m3716h();
        CharSequence obj = number.toString();
        if (!this.f3009h) {
            if (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Numeric values must be finite, but was ");
                stringBuilder.append(number);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        m3731f();
        this.f3004c.append(obj);
        return this;
    }

    public void flush() {
        if (this.f3006e != 0) {
            this.f3004c.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public void close() {
        this.f3004c.close();
        int i = this.f3006e;
        if (i > 1 || (i == 1 && this.f3005d[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f3006e = 0;
    }

    /* renamed from: a */
    private void mo764a(String str) {
        String[] strArr = this.f3010i ? f3003b : f3002a;
        this.f3004c.write("\"");
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
                this.f3004c.write(str, i, i2 - i);
            }
            this.f3004c.write(str2);
            i = i2 + 1;
        }
        if (i < length) {
            this.f3004c.write(str, i, length - i);
        }
        this.f3004c.write("\"");
    }

    /* renamed from: i */
    private void m3717i() {
        if (this.f3007f != null) {
            this.f3004c.write(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            int i = this.f3006e;
            for (int i2 = 1; i2 < i; i2++) {
                this.f3004c.write(this.f3007f);
            }
        }
    }

    /* renamed from: j */
    private void m3718j() {
        int g = m3715g();
        if (g == 5) {
            this.f3004c.write(44);
        } else if (g != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m3717i();
        m3714b(4);
    }

    /* renamed from: f */
    void m3731f() {
        switch (m3715g()) {
            case 1:
                m3714b(2);
                m3717i();
                return;
            case 2:
                this.f3004c.append(',');
                m3717i();
                return;
            case 4:
                this.f3004c.append(this.f3008g);
                m3714b(5);
                return;
            case 6:
                break;
            case 7:
                if (this.f3009h) {
                    break;
                }
                throw new IllegalStateException("JSON must have only one top-level value.");
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        m3714b(7);
    }
}
