package com.google.android.gms.internal.p210i;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.i.je */
final class je implements Cloneable {
    /* renamed from: a */
    private jc<?, ?> f16787a;
    /* renamed from: b */
    private Object f16788b;
    /* renamed from: c */
    private List<jj> f16789c = new ArrayList();

    je() {
    }

    /* renamed from: a */
    final void m20999a(jj jjVar) {
        if (this.f16789c != null) {
            this.f16789c.add(jjVar);
            return;
        }
        if (this.f16788b instanceof jh) {
            jjVar = jjVar.f16795b;
            iy a = iy.m20932a(jjVar, 0, jjVar.length);
            int d = a.m20948d();
            if (d == jjVar.length - iz.m20955a(d)) {
                jjVar = ((jh) this.f16788b).mo6147a(a);
            } else {
                throw jg.m21005a();
            }
        }
        jj jjVar2;
        if (this.f16788b instanceof jh[]) {
            jh[] jhVarArr = (jh[]) this.f16787a.m20985a(Collections.singletonList(jjVar));
            jh[] jhVarArr2 = (jh[]) this.f16788b;
            jjVar2 = (jh[]) Arrays.copyOf(jhVarArr2, jhVarArr2.length + jhVarArr.length);
            System.arraycopy(jhVarArr, 0, jjVar2, jhVarArr2.length, jhVarArr.length);
        } else if (this.f16788b instanceof gt) {
            jjVar = ((gt) this.f16788b).mo6737t().mo6149a((gt) this.f16787a.m20985a(Collections.singletonList(jjVar))).mo6730e();
        } else if (this.f16788b instanceof gt[]) {
            gt[] gtVarArr = (gt[]) this.f16787a.m20985a(Collections.singletonList(jjVar));
            gt[] gtVarArr2 = (gt[]) this.f16788b;
            gt[] gtVarArr3 = (gt[]) Arrays.copyOf(gtVarArr2, gtVarArr2.length + gtVarArr.length);
            System.arraycopy(gtVarArr, 0, gtVarArr3, gtVarArr2.length, gtVarArr.length);
        } else {
            jjVar = this.f16787a.m20985a(Collections.singletonList(jjVar));
        }
        jjVar = jjVar2;
        this.f16787a = this.f16787a;
        this.f16788b = jjVar;
        this.f16789c = null;
    }

    /* renamed from: a */
    final <T> T m20997a(jc<?, T> jcVar) {
        if (this.f16788b == null) {
            this.f16787a = jcVar;
            this.f16788b = jcVar.m20985a(this.f16789c);
            this.f16789c = null;
        } else if (this.f16787a.equals(jcVar) == null) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.f16788b;
    }

    /* renamed from: a */
    final int m20996a() {
        int i = 0;
        int i2;
        if (this.f16788b != null) {
            jc jcVar = this.f16787a;
            Object obj = this.f16788b;
            if (!jcVar.f16779c) {
                return jcVar.m20984a(obj);
            }
            int length = Array.getLength(obj);
            i2 = 0;
            while (i < length) {
                Object obj2 = Array.get(obj, i);
                if (obj2 != null) {
                    i2 += jcVar.m20984a(obj2);
                }
                i++;
            }
            return i2;
        }
        i2 = 0;
        for (jj jjVar : this.f16789c) {
            i2 += (iz.m20968d(jjVar.f16794a) + 0) + jjVar.f16795b.length;
        }
        return i2;
    }

    /* renamed from: a */
    final void m20998a(iz izVar) {
        if (this.f16788b != null) {
            jc jcVar = this.f16787a;
            Object obj = this.f16788b;
            if (jcVar.f16779c) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        jcVar.m20986a(obj2, izVar);
                    }
                }
                return;
            }
            jcVar.m20986a(obj, izVar);
            return;
        }
        for (jj jjVar : this.f16789c) {
            izVar.m20979c(jjVar.f16794a);
            izVar.m20978b(jjVar.f16795b);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof je)) {
            return false;
        }
        je jeVar = (je) obj;
        if (this.f16788b == null || jeVar.f16788b == null) {
            if (this.f16789c != null && jeVar.f16789c != null) {
                return this.f16789c.equals(jeVar.f16789c);
            }
            try {
                return Arrays.equals(m20994b(), jeVar.m20994b());
            } catch (Object obj2) {
                throw new IllegalStateException(obj2);
            }
        } else if (this.f16787a != jeVar.f16787a) {
            return false;
        } else {
            if (!this.f16787a.f16777a.isArray()) {
                return this.f16788b.equals(jeVar.f16788b);
            }
            if (this.f16788b instanceof byte[]) {
                return Arrays.equals((byte[]) this.f16788b, (byte[]) jeVar.f16788b);
            }
            if (this.f16788b instanceof int[]) {
                return Arrays.equals((int[]) this.f16788b, (int[]) jeVar.f16788b);
            }
            if (this.f16788b instanceof long[]) {
                return Arrays.equals((long[]) this.f16788b, (long[]) jeVar.f16788b);
            }
            if (this.f16788b instanceof float[]) {
                return Arrays.equals((float[]) this.f16788b, (float[]) jeVar.f16788b);
            }
            if (this.f16788b instanceof double[]) {
                return Arrays.equals((double[]) this.f16788b, (double[]) jeVar.f16788b);
            }
            if (this.f16788b instanceof boolean[]) {
                return Arrays.equals((boolean[]) this.f16788b, (boolean[]) jeVar.f16788b);
            }
            return Arrays.deepEquals((Object[]) this.f16788b, (Object[]) jeVar.f16788b);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(m20994b()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: b */
    private final byte[] m20994b() {
        byte[] bArr = new byte[m20996a()];
        m20998a(iz.m20958a(bArr));
        return bArr;
    }

    /* renamed from: c */
    private final je m20995c() {
        je jeVar = new je();
        try {
            jeVar.f16787a = this.f16787a;
            if (this.f16789c == null) {
                jeVar.f16789c = null;
            } else {
                jeVar.f16789c.addAll(this.f16789c);
            }
            if (this.f16788b != null) {
                if (this.f16788b instanceof jh) {
                    jeVar.f16788b = (jh) ((jh) this.f16788b).clone();
                } else if (this.f16788b instanceof byte[]) {
                    jeVar.f16788b = ((byte[]) this.f16788b).clone();
                } else {
                    int i = 0;
                    Object obj;
                    if (this.f16788b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.f16788b;
                        obj = new byte[bArr.length][];
                        jeVar.f16788b = obj;
                        while (i < bArr.length) {
                            obj[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.f16788b instanceof boolean[]) {
                        jeVar.f16788b = ((boolean[]) this.f16788b).clone();
                    } else if (this.f16788b instanceof int[]) {
                        jeVar.f16788b = ((int[]) this.f16788b).clone();
                    } else if (this.f16788b instanceof long[]) {
                        jeVar.f16788b = ((long[]) this.f16788b).clone();
                    } else if (this.f16788b instanceof float[]) {
                        jeVar.f16788b = ((float[]) this.f16788b).clone();
                    } else if (this.f16788b instanceof double[]) {
                        jeVar.f16788b = ((double[]) this.f16788b).clone();
                    } else if (this.f16788b instanceof jh[]) {
                        jh[] jhVarArr = (jh[]) this.f16788b;
                        obj = new jh[jhVarArr.length];
                        jeVar.f16788b = obj;
                        while (i < jhVarArr.length) {
                            obj[i] = (jh) jhVarArr[i].clone();
                            i++;
                        }
                    }
                }
            }
            return jeVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() {
        return m20995c();
    }
}
