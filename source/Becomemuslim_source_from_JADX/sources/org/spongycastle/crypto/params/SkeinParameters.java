package org.spongycastle.crypto.params;

import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.util.Integers;

public class SkeinParameters implements CipherParameters {
    /* renamed from: a */
    private Hashtable f27147a;

    public static class Builder {
        /* renamed from: a */
        private Hashtable f22428a = new Hashtable();

        public Builder(Hashtable hashtable) {
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                Integer num = (Integer) keys.nextElement();
                this.f22428a.put(num, hashtable.get(num));
            }
        }

        /* renamed from: a */
        public Builder m27502a(int i, byte[] bArr) {
            if (bArr != null) {
                if (i != 0) {
                    if (i <= 4 || i >= 63 || i == 48) {
                        throw new IllegalArgumentException("Parameter types must be in the range 0,5..47,49..62.");
                    }
                }
                if (i != 4) {
                    this.f22428a.put(Integers.m29396a(i), bArr);
                    return this;
                }
                throw new IllegalArgumentException("Parameter type 4 is reserved for internal use.");
            }
            throw new IllegalArgumentException("Parameter value must not be null.");
        }

        /* renamed from: a */
        public Builder m27503a(byte[] bArr) {
            return m27502a(0, bArr);
        }

        /* renamed from: a */
        public SkeinParameters m27504a() {
            return new SkeinParameters(this.f22428a);
        }
    }

    public SkeinParameters() {
        this(new Hashtable());
    }

    private SkeinParameters(Hashtable hashtable) {
        this.f27147a = hashtable;
    }

    /* renamed from: a */
    public Hashtable m35709a() {
        return this.f27147a;
    }

    /* renamed from: b */
    public byte[] m35710b() {
        return (byte[]) this.f27147a.get(Integers.m29396a(0));
    }
}
