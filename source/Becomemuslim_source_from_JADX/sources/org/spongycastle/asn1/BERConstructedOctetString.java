package org.spongycastle.asn1;

import java.util.Enumeration;
import java.util.Vector;

public class BERConstructedOctetString extends BEROctetString {
    /* renamed from: b */
    private Vector f32923b;

    /* renamed from: c */
    public byte[] mo6859c() {
        return this.a;
    }

    /* renamed from: j */
    public Enumeration mo6872j() {
        if (this.f32923b == null) {
            return m44480k().elements();
        }
        return this.f32923b.elements();
    }

    /* renamed from: k */
    private Vector m44480k() {
        Vector vector = new Vector();
        int i = 0;
        while (i < this.a.length) {
            int i2 = i + 1000;
            Object obj = new byte[((i2 > this.a.length ? this.a.length : i2) - i)];
            System.arraycopy(this.a, i, obj, 0, obj.length);
            vector.addElement(new DEROctetString(obj));
            i = i2;
        }
        return vector;
    }
}
