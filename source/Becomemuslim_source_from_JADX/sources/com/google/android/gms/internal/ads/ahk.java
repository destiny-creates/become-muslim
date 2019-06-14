package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class ahk {
    /* renamed from: b */
    private static Cipher f14525b;
    /* renamed from: c */
    private static final Object f14526c = new Object();
    /* renamed from: d */
    private static final Object f14527d = new Object();
    /* renamed from: a */
    private final SecureRandom f14528a = null;

    public ahk(SecureRandom secureRandom) {
    }

    /* renamed from: a */
    private static Cipher m18436a() {
        Cipher cipher;
        synchronized (f14527d) {
            if (f14525b == null) {
                f14525b = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = f14525b;
        }
        return cipher;
    }

    /* renamed from: a */
    public final String m18437a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 16) {
            try {
                byte[] iv;
                Key secretKeySpec = new SecretKeySpec(bArr, "AES");
                synchronized (f14526c) {
                    m18436a().init(1, secretKeySpec, null);
                    bArr2 = m18436a().doFinal(bArr2);
                    iv = m18436a().getIV();
                }
                int length = bArr2.length + iv.length;
                ByteBuffer allocate = ByteBuffer.allocate(length);
                allocate.put(iv).put(bArr2);
                allocate.flip();
                bArr = new byte[length];
                allocate.get(bArr);
                return agh.m18405a(bArr, false);
            } catch (Throwable e) {
                throw new ahl(this, e);
            } catch (Throwable e2) {
                throw new ahl(this, e2);
            } catch (Throwable e22) {
                throw new ahl(this, e22);
            } catch (Throwable e222) {
                throw new ahl(this, e222);
            } catch (Throwable e2222) {
                throw new ahl(this, e2222);
            }
        }
        throw new ahl(this);
    }

    /* renamed from: a */
    public final byte[] m18438a(String str) {
        int i = 0;
        try {
            byte[] a = agh.m18406a(str, false);
            if (a.length == 32) {
                byte[] bArr = new byte[16];
                ByteBuffer.wrap(a, 4, 16).get(bArr);
                while (i < 16) {
                    bArr[i] = (byte) (bArr[i] ^ 68);
                    i++;
                }
                return bArr;
            }
            throw new ahl(this);
        } catch (Throwable e) {
            throw new ahl(this, e);
        }
    }

    /* renamed from: a */
    public final byte[] m18439a(byte[] bArr, String str) {
        if (bArr.length == 16) {
            try {
                byte[] a = agh.m18406a(str, false);
                if (a.length > 16) {
                    ByteBuffer allocate = ByteBuffer.allocate(a.length);
                    allocate.put(a);
                    allocate.flip();
                    byte[] bArr2 = new byte[16];
                    a = new byte[(a.length - 16)];
                    allocate.get(bArr2);
                    allocate.get(a);
                    Key secretKeySpec = new SecretKeySpec(bArr, "AES");
                    synchronized (f14526c) {
                        m18436a().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                        a = m18436a().doFinal(a);
                    }
                    return a;
                }
                throw new ahl(this);
            } catch (Throwable e) {
                throw new ahl(this, e);
            } catch (Throwable e2) {
                throw new ahl(this, e2);
            } catch (Throwable e22) {
                throw new ahl(this, e22);
            } catch (Throwable e222) {
                throw new ahl(this, e222);
            } catch (Throwable e2222) {
                throw new ahl(this, e2222);
            } catch (Throwable e22222) {
                throw new ahl(this, e22222);
            } catch (Throwable e222222) {
                throw new ahl(this, e222222);
            }
        }
        throw new ahl(this);
    }
}
