package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class afl implements Cloneable {
    /* renamed from: a */
    private afj<?, ?> f14425a;
    /* renamed from: b */
    private Object f14426b;
    /* renamed from: c */
    private List<afq> f14427c = new ArrayList();

    afl() {
    }

    /* renamed from: b */
    private final byte[] m18377b() {
        byte[] bArr = new byte[m18379a()];
        m18380a(afg.m18346a(bArr));
        return bArr;
    }

    /* renamed from: c */
    private final afl m18378c() {
        afl afl = new afl();
        try {
            afl.f14425a = this.f14425a;
            if (this.f14427c == null) {
                afl.f14427c = null;
            } else {
                afl.f14427c.addAll(this.f14427c);
            }
            if (this.f14426b != null) {
                Object obj;
                if (this.f14426b instanceof afo) {
                    obj = (afo) ((afo) this.f14426b).clone();
                } else if (this.f14426b instanceof byte[]) {
                    obj = ((byte[]) this.f14426b).clone();
                } else {
                    int i = 0;
                    Object obj2;
                    if (this.f14426b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.f14426b;
                        obj2 = new byte[bArr.length][];
                        afl.f14426b = obj2;
                        while (i < bArr.length) {
                            obj2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.f14426b instanceof boolean[]) {
                        obj = ((boolean[]) this.f14426b).clone();
                    } else if (this.f14426b instanceof int[]) {
                        obj = ((int[]) this.f14426b).clone();
                    } else if (this.f14426b instanceof long[]) {
                        obj = ((long[]) this.f14426b).clone();
                    } else if (this.f14426b instanceof float[]) {
                        obj = ((float[]) this.f14426b).clone();
                    } else if (this.f14426b instanceof double[]) {
                        obj = ((double[]) this.f14426b).clone();
                    } else if (this.f14426b instanceof afo[]) {
                        afo[] afoArr = (afo[]) this.f14426b;
                        obj2 = new afo[afoArr.length];
                        afl.f14426b = obj2;
                        while (i < afoArr.length) {
                            obj2[i] = (afo) afoArr[i].clone();
                            i++;
                        }
                    }
                }
                afl.f14426b = obj;
            }
            return afl;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    final int m18379a() {
        if (this.f14426b == null) {
            int i = 0;
            for (afq afq : this.f14427c) {
                i += (afg.m18357d(afq.f14432a) + 0) + afq.f14433b.length;
            }
            return i;
        }
        throw new NoSuchMethodError();
    }

    /* renamed from: a */
    final void m18380a(afg afg) {
        if (this.f14426b == null) {
            for (afq afq : this.f14427c) {
                afg.m18368c(afq.f14432a);
                afg.m18370c(afq.f14433b);
            }
            return;
        }
        throw new NoSuchMethodError();
    }

    /* renamed from: a */
    final void m18381a(afq afq) {
        if (this.f14427c != null) {
            this.f14427c.add(afq);
        } else if (this.f14426b instanceof afo) {
            byte[] bArr = afq.f14433b;
            afe a = afe.m18320a(bArr, 0, bArr.length);
            int g = a.m18338g();
            if (g == bArr.length - afg.m18342a(g)) {
                afo a2 = ((afo) this.f14426b).mo6026a(a);
                this.f14425a = this.f14425a;
                this.f14426b = a2;
                this.f14427c = null;
                return;
            }
            throw afn.m18383a();
        } else if (this.f14426b instanceof afo[]) {
            Collections.singletonList(afq);
            throw new NoSuchMethodError();
        } else {
            Collections.singletonList(afq);
            throw new NoSuchMethodError();
        }
    }

    public final /* synthetic */ Object clone() {
        return m18378c();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof afl)) {
            return false;
        }
        afl afl = (afl) obj;
        if (this.f14426b != null && afl.f14426b != null) {
            return this.f14425a != afl.f14425a ? false : !this.f14425a.f14419a.isArray() ? this.f14426b.equals(afl.f14426b) : this.f14426b instanceof byte[] ? Arrays.equals((byte[]) this.f14426b, (byte[]) afl.f14426b) : this.f14426b instanceof int[] ? Arrays.equals((int[]) this.f14426b, (int[]) afl.f14426b) : this.f14426b instanceof long[] ? Arrays.equals((long[]) this.f14426b, (long[]) afl.f14426b) : this.f14426b instanceof float[] ? Arrays.equals((float[]) this.f14426b, (float[]) afl.f14426b) : this.f14426b instanceof double[] ? Arrays.equals((double[]) this.f14426b, (double[]) afl.f14426b) : this.f14426b instanceof boolean[] ? Arrays.equals((boolean[]) this.f14426b, (boolean[]) afl.f14426b) : Arrays.deepEquals((Object[]) this.f14426b, (Object[]) afl.f14426b);
        } else {
            if (this.f14427c != null && afl.f14427c != null) {
                return this.f14427c.equals(afl.f14427c);
            }
            try {
                return Arrays.equals(m18377b(), afl.m18377b());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(m18377b()) + 527;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
