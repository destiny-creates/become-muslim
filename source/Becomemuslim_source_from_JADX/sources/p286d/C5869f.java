package p286d;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;

/* compiled from: ByteString */
/* renamed from: d.f */
public class C5869f implements Serializable, Comparable<C5869f> {
    /* renamed from: a */
    static final char[] f19526a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    /* renamed from: b */
    public static final C5869f f19527b = C5869f.m24699a(new byte[0]);
    private static final long serialVersionUID = 1;
    /* renamed from: c */
    final byte[] f19528c;
    /* renamed from: d */
    transient int f19529d;
    /* renamed from: e */
    transient String f19530e;

    public /* synthetic */ int compareTo(Object obj) {
        return m24710b((C5869f) obj);
    }

    C5869f(byte[] bArr) {
        this.f19528c = bArr;
    }

    /* renamed from: a */
    public static C5869f m24699a(byte... bArr) {
        if (bArr != null) {
            return new C5869f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    /* renamed from: a */
    public static C5869f m24697a(String str) {
        if (str != null) {
            C5869f c5869f = new C5869f(str.getBytes(C5878v.f19548a));
            c5869f.f19530e = str;
            return c5869f;
        }
        throw new IllegalArgumentException("s == null");
    }

    /* renamed from: a */
    public static C5869f m24698a(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        } else if (charset != null) {
            return new C5869f(str.getBytes(charset));
        } else {
            throw new IllegalArgumentException("charset == null");
        }
    }

    /* renamed from: a */
    public String mo5099a() {
        String str = this.f19530e;
        if (str != null) {
            return str;
        }
        str = new String(this.f19528c, C5878v.f19548a);
        this.f19530e = str;
        return str;
    }

    /* renamed from: b */
    public String mo5103b() {
        return C5866b.m24689a(this.f19528c);
    }

    /* renamed from: c */
    public C5869f mo5104c() {
        return m24702d("MD5");
    }

    /* renamed from: d */
    public C5869f mo5105d() {
        return m24702d("SHA-1");
    }

    /* renamed from: e */
    public C5869f mo5106e() {
        return m24702d("SHA-256");
    }

    /* renamed from: d */
    private C5869f m24702d(String str) {
        try {
            return C5869f.m24699a(MessageDigest.getInstance(str).digest(this.f19528c));
        } catch (String str2) {
            throw new AssertionError(str2);
        }
    }

    /* renamed from: b */
    public static C5869f m24700b(String str) {
        if (str != null) {
            str = C5866b.m24691a(str);
            return str != null ? new C5869f(str) : null;
        } else {
            throw new IllegalArgumentException("base64 == null");
        }
    }

    /* renamed from: f */
    public String mo5108f() {
        char[] cArr = new char[(this.f19528c.length * 2)];
        int i = 0;
        for (byte b : this.f19528c) {
            int i2 = i + 1;
            cArr[i] = f19526a[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = f19526a[b & 15];
        }
        return new String(cArr);
    }

    /* renamed from: c */
    public static C5869f m24701c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((C5869f.m24694a(str.charAt(i2)) << 4) + C5869f.m24694a(str.charAt(i2 + 1)));
            }
            return C5869f.m24699a(bArr);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected hex string: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private static int m24694a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 'A') + 10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected hex digit: ");
        stringBuilder.append(c);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public static C5869f m24696a(InputStream inputStream, int i) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i >= 0) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read != -1) {
                    i2 += read;
                } else {
                    throw new EOFException();
                }
            }
            return new C5869f(bArr);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    /* renamed from: g */
    public C5869f mo5109g() {
        for (int i = 0; i < this.f19528c.length; i++) {
            byte b = this.f19528c[i];
            if (b >= (byte) 65) {
                if (b <= (byte) 90) {
                    byte[] bArr = (byte[]) this.f19528c.clone();
                    bArr[i] = (byte) (b + 32);
                    for (int i2 = i + 1; i2 < bArr.length; i2++) {
                        byte b2 = bArr[i2];
                        if (b2 >= (byte) 65) {
                            if (b2 <= (byte) 90) {
                                bArr[i2] = (byte) (b2 + 32);
                            }
                        }
                    }
                    return new C5869f(bArr);
                }
            }
        }
        return this;
    }

    /* renamed from: a */
    public C5869f mo5098a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        } else if (i2 <= this.f19528c.length) {
            int i3 = i2 - i;
            if (i3 < 0) {
                throw new IllegalArgumentException("endIndex < beginIndex");
            } else if (i == 0 && i2 == this.f19528c.length) {
                return this;
            } else {
                i2 = new byte[i3];
                System.arraycopy(this.f19528c, i, i2, 0, i3);
                return new C5869f(i2);
            }
        } else {
            i2 = new StringBuilder();
            i2.append("endIndex > length(");
            i2.append(this.f19528c.length);
            i2.append(")");
            throw new IllegalArgumentException(i2.toString());
        }
    }

    /* renamed from: a */
    public byte mo5097a(int i) {
        return this.f19528c[i];
    }

    /* renamed from: h */
    public int mo5110h() {
        return this.f19528c.length;
    }

    /* renamed from: i */
    public byte[] mo5112i() {
        return (byte[]) this.f19528c.clone();
    }

    /* renamed from: a */
    void mo5100a(C8037c c8037c) {
        c8037c.m38983b(this.f19528c, 0, this.f19528c.length);
    }

    /* renamed from: a */
    public boolean mo5101a(int i, C5869f c5869f, int i2, int i3) {
        return c5869f.mo5102a(i2, this.f19528c, i, i3);
    }

    /* renamed from: a */
    public boolean mo5102a(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.f19528c.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && C5878v.m24748a(this.f19528c, i, bArr, i2, i3) != 0;
    }

    /* renamed from: a */
    public final boolean m24709a(C5869f c5869f) {
        return mo5101a(0, c5869f, 0, c5869f.mo5110h());
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof C5869f) {
            C5869f c5869f = (C5869f) obj;
            if (c5869f.mo5110h() == this.f19528c.length && c5869f.mo5102a(0, this.f19528c, 0, this.f19528c.length) != null) {
                return z;
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        int i = this.f19529d;
        if (i != 0) {
            return i;
        }
        i = Arrays.hashCode(this.f19528c);
        this.f19529d = i;
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public int m24710b(p286d.C5869f r10) {
        /*
        r9 = this;
        r0 = r9.mo5110h();
        r1 = r10.mo5110h();
        r2 = java.lang.Math.min(r0, r1);
        r3 = 0;
        r4 = 0;
    L_0x000e:
        r5 = -1;
        r6 = 1;
        if (r4 >= r2) goto L_0x0028;
    L_0x0012:
        r7 = r9.mo5097a(r4);
        r7 = r7 & 255;
        r8 = r10.mo5097a(r4);
        r8 = r8 & 255;
        if (r7 != r8) goto L_0x0023;
    L_0x0020:
        r4 = r4 + 1;
        goto L_0x000e;
    L_0x0023:
        if (r7 >= r8) goto L_0x0026;
    L_0x0025:
        goto L_0x0027;
    L_0x0026:
        r5 = 1;
    L_0x0027:
        return r5;
    L_0x0028:
        if (r0 != r1) goto L_0x002b;
    L_0x002a:
        return r3;
    L_0x002b:
        if (r0 >= r1) goto L_0x002e;
    L_0x002d:
        goto L_0x002f;
    L_0x002e:
        r5 = 1;
    L_0x002f:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f.b(d.f):int");
    }

    public String toString() {
        if (this.f19528c.length == 0) {
            return "[size=0]";
        }
        String a = mo5099a();
        int a2 = C5869f.m24695a(a, 64);
        StringBuilder stringBuilder;
        if (a2 == -1) {
            if (this.f19528c.length <= 64) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("[hex=");
                stringBuilder.append(mo5108f());
                stringBuilder.append("]");
                a = stringBuilder.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("[size=");
                stringBuilder.append(this.f19528c.length);
                stringBuilder.append(" hex=");
                stringBuilder.append(mo5098a(0, 64).mo5108f());
                stringBuilder.append("…]");
                a = stringBuilder.toString();
            }
            return a;
        }
        String replace = a.substring(0, a2).replace("\\", "\\\\").replace(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, "\\n").replace("\r", "\\r");
        if (a2 < a.length()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("[size=");
            stringBuilder.append(this.f19528c.length);
            stringBuilder.append(" text=");
            stringBuilder.append(replace);
            stringBuilder.append("…]");
            a = stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("[text=");
            stringBuilder.append(replace);
            stringBuilder.append("]");
            a = stringBuilder.toString();
        }
        return a;
    }

    /* renamed from: a */
    static int m24695a(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    private void readObject(java.io.ObjectInputStream r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r3.readInt();
        r3 = p286d.C5869f.m24696a(r3, r0);
        r0 = p286d.C5869f.class;	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r1 = "c";	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r0 = r0.getDeclaredField(r1);	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r1 = 1;	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r0.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r3 = r3.f19528c;	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        r0.set(r2, r3);	 Catch:{ NoSuchFieldException -> 0x0020, IllegalAccessException -> 0x001a }
        return;
    L_0x001a:
        r3 = new java.lang.AssertionError;
        r3.<init>();
        throw r3;
    L_0x0020:
        r3 = new java.lang.AssertionError;
        r3.<init>();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f.readObject(java.io.ObjectInputStream):void");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.f19528c.length);
        objectOutputStream.write(this.f19528c);
    }
}
