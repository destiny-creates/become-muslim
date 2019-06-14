package org.spongycastle.pqc.math.linearalgebra;

public class GF2mVector extends Vector {
    /* renamed from: b */
    private GF2mField f27866b;
    /* renamed from: c */
    private int[] f27867c;

    public GF2mVector(GF2mField gF2mField, int[] iArr) {
        this.f27866b = gF2mField;
        this.a = iArr.length;
        int length = iArr.length - 1;
        while (length >= 0) {
            if (gF2mField.m29221c(iArr[length])) {
                length--;
            } else {
                throw new ArithmeticException("Element array is not specified over the given finite field.");
            }
        }
        this.f27867c = IntUtils.m29234a(iArr);
    }

    /* renamed from: a */
    public GF2mField m36528a() {
        return this.f27866b;
    }

    /* renamed from: b */
    public int[] m36530b() {
        return IntUtils.m29234a(this.f27867c);
    }

    /* renamed from: a */
    public Vector mo5929a(Vector vector) {
        throw new RuntimeException("not implemented");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GF2mVector)) {
            return false;
        }
        GF2mVector gF2mVector = (GF2mVector) obj;
        if (this.f27866b.equals(gF2mVector.f27866b)) {
            return IntUtils.m29233a(this.f27867c, gF2mVector.f27867c);
        }
        return false;
    }

    public int hashCode() {
        return (this.f27866b.hashCode() * 31) + this.f27867c.hashCode();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : this.f27867c) {
            for (int i2 = 0; i2 < this.f27866b.m29212a(); i2++) {
                if (((1 << (i2 & 31)) & i) != 0) {
                    stringBuffer.append('1');
                } else {
                    stringBuffer.append('0');
                }
            }
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }
}
