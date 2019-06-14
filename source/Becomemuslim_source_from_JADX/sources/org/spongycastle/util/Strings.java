package org.spongycastle.util;

import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.NativeProtocol;
import java.io.OutputStream;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Vector;

public final class Strings {
    /* renamed from: a */
    private static String f23436a;

    /* renamed from: org.spongycastle.util.Strings$1 */
    static class C67011 implements PrivilegedAction<String> {
        C67011() {
        }

        public /* synthetic */ Object run() {
            return m29417a();
        }

        /* renamed from: a */
        public String m29417a() {
            return System.getProperty("line.separator");
        }
    }

    private static class StringListImpl extends ArrayList<String> implements StringList {
        private StringListImpl() {
        }

        public /* synthetic */ void add(int i, Object obj) {
            m42150b(i, (String) obj);
        }

        public /* synthetic */ boolean add(Object obj) {
            return m42149a((String) obj);
        }

        public /* synthetic */ Object set(int i, Object obj) {
            return m42148a(i, (String) obj);
        }

        /* renamed from: a */
        public boolean m42149a(String str) {
            return super.add(str);
        }

        /* renamed from: a */
        public String m42148a(int i, String str) {
            return (String) super.set(i, str);
        }

        /* renamed from: b */
        public void m42150b(int i, String str) {
            super.add(i, str);
        }
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.spongycastle.util.Strings$1;	 Catch:{ Exception -> 0x000e }
        r0.<init>();	 Catch:{ Exception -> 0x000e }
        r0 = java.security.AccessController.doPrivileged(r0);	 Catch:{ Exception -> 0x000e }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x000e }
        f23436a = r0;	 Catch:{ Exception -> 0x000e }
        goto L_0x001e;
    L_0x000e:
        r0 = "%n";	 Catch:{ Exception -> 0x001a }
        r1 = 0;	 Catch:{ Exception -> 0x001a }
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x001a }
        r0 = java.lang.String.format(r0, r1);	 Catch:{ Exception -> 0x001a }
        f23436a = r0;	 Catch:{ Exception -> 0x001a }
        goto L_0x001e;
    L_0x001a:
        r0 = "\n";
        f23436a = r0;
    L_0x001e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.util.Strings.<clinit>():void");
    }

    /* renamed from: a */
    public static String m29419a(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            i3++;
            if ((bArr[i2] & 240) == 240) {
                i3++;
                i2 += 4;
            } else {
                i2 = (bArr[i2] & 224) == 224 ? i2 + 3 : (bArr[i2] & JfifUtil.MARKER_SOFn) == JfifUtil.MARKER_SOFn ? i2 + 2 : i2 + 1;
            }
        }
        char[] cArr = new char[i3];
        i3 = 0;
        while (i < bArr.length) {
            char c;
            if ((bArr[i] & 240) == 240) {
                int i4 = (((((bArr[i] & 3) << 18) | ((bArr[i + 1] & 63) << 12)) | ((bArr[i + 2] & 63) << 6)) | (bArr[i + 3] & 63)) - NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                c = (char) ((i4 & 1023) | 56320);
                int i5 = i3 + 1;
                cArr[i3] = (char) (55296 | (i4 >> 10));
                i += 4;
                i3 = i5;
            } else if ((bArr[i] & 224) == 224) {
                c = (char) ((((bArr[i] & 15) << 12) | ((bArr[i + 1] & 63) << 6)) | (bArr[i + 2] & 63));
                i += 3;
            } else if ((bArr[i] & JfifUtil.MARKER_RST0) == JfifUtil.MARKER_RST0) {
                c = (char) (((bArr[i] & 31) << 6) | (bArr[i + 1] & 63));
                i += 2;
            } else if ((bArr[i] & JfifUtil.MARKER_SOFn) == JfifUtil.MARKER_SOFn) {
                c = (char) (((bArr[i] & 31) << 6) | (bArr[i + 1] & 63));
                i += 2;
            } else {
                c = (char) (bArr[i] & JfifUtil.MARKER_FIRST_BYTE);
                i++;
            }
            int i6 = i3 + 1;
            cArr[i3] = c;
            i3 = i6;
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static byte[] m29421a(String str) {
        return m29422a(str.toCharArray());
    }

    /* renamed from: a */
    public static byte[] m29422a(char[] r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        m29420a(r1, r0);	 Catch:{ IOException -> 0x000d }
        r1 = r0.toByteArray();
        return r1;
    L_0x000d:
        r1 = new java.lang.IllegalStateException;
        r0 = "cannot encode string to byte array!";
        r1.<init>(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.util.Strings.a(char[]):byte[]");
    }

    /* renamed from: a */
    public static void m29420a(char[] cArr, OutputStream outputStream) {
        int i = 0;
        while (i < cArr.length) {
            char c = cArr[i];
            if (c < '') {
                outputStream.write(c);
            } else if (c < 'ࠀ') {
                outputStream.write((c >> 6) | JfifUtil.MARKER_SOFn);
                outputStream.write((c & 63) | 128);
            } else if (c < '?' || c > '?') {
                outputStream.write((c >> 12) | 224);
                outputStream.write(((c >> 6) & 63) | 128);
                outputStream.write((c & 63) | 128);
            } else {
                i++;
                if (i < cArr.length) {
                    char c2 = cArr[i];
                    if (c <= '?') {
                        int i2 = (((c & 1023) << 10) | (c2 & 1023)) + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                        outputStream.write((i2 >> 18) | 240);
                        outputStream.write(((i2 >> 12) & 63) | 128);
                        outputStream.write(((i2 >> 6) & 63) | 128);
                        outputStream.write((i2 & 63) | 128);
                    } else {
                        throw new IllegalStateException("invalid UTF-16 codepoint");
                    }
                }
                throw new IllegalStateException("invalid UTF-16 codepoint");
            }
            i++;
        }
    }

    /* renamed from: b */
    public static String m29424b(String str) {
        char[] toCharArray = str.toCharArray();
        Object obj = null;
        for (int i = 0; i != toCharArray.length; i++) {
            char c = toCharArray[i];
            if ('a' <= c && 'z' >= c) {
                toCharArray[i] = (char) ((c - 97) + 65);
                obj = 1;
            }
        }
        return obj != null ? new String(toCharArray) : str;
    }

    /* renamed from: c */
    public static String m29427c(String str) {
        char[] toCharArray = str.toCharArray();
        Object obj = null;
        for (int i = 0; i != toCharArray.length; i++) {
            char c = toCharArray[i];
            if ('A' <= c && 'Z' >= c) {
                toCharArray[i] = (char) ((c - 65) + 97);
                obj = 1;
            }
        }
        return obj != null ? new String(toCharArray) : str;
    }

    /* renamed from: b */
    public static byte[] m29426b(char[] cArr) {
        byte[] bArr = new byte[cArr.length];
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = (byte) cArr[i];
        }
        return bArr;
    }

    /* renamed from: d */
    public static byte[] m29429d(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    /* renamed from: b */
    public static String m29425b(byte[] bArr) {
        return new String(m29428c(bArr));
    }

    /* renamed from: c */
    public static char[] m29428c(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i = 0; i != cArr.length; i++) {
            cArr[i] = (char) (bArr[i] & JfifUtil.MARKER_FIRST_BYTE);
        }
        return cArr;
    }

    /* renamed from: a */
    public static String[] m29423a(String str, char c) {
        Vector vector = new Vector();
        Object obj = 1;
        while (true) {
            char c2 = '\u0000';
            if (obj == null) {
                break;
            }
            int indexOf = str.indexOf(c);
            if (indexOf > 0) {
                vector.addElement(str.substring(0, indexOf));
                str = str.substring(indexOf + 1);
            } else {
                vector.addElement(str);
                obj = null;
            }
        }
        str = new String[vector.size()];
        while (c2 != str.length) {
            str[c2] = (String) vector.elementAt(c2);
            c2++;
        }
        return str;
    }

    /* renamed from: a */
    public static String m29418a() {
        return f23436a;
    }
}
