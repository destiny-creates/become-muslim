package org.spongycastle.pqc.math.linearalgebra;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;

public class GF2mMatrix extends Matrix {
    /* renamed from: a */
    protected GF2mField f27864a;
    /* renamed from: b */
    protected int[][] f27865b;

    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof GF2mMatrix) {
                GF2mMatrix gF2mMatrix = (GF2mMatrix) obj;
                if (this.f27864a.equals(gF2mMatrix.f27864a) && gF2mMatrix.c == this.d) {
                    if (gF2mMatrix.d == this.d) {
                        for (int i = 0; i < this.c; i++) {
                            for (int i2 = 0; i2 < this.d; i2++) {
                                if (this.f27865b[i][i2] != gF2mMatrix.f27865b[i][i2]) {
                                    return false;
                                }
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((this.f27864a.hashCode() * 31) + this.c) * 31) + this.d;
        int i = 0;
        while (i < this.c) {
            int i2 = hashCode;
            for (hashCode = 0; hashCode < this.d; hashCode++) {
                i2 = (i2 * 31) + this.f27865b[i][hashCode];
            }
            i++;
            hashCode = i2;
        }
        return hashCode;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append(" x ");
        stringBuilder.append(this.d);
        stringBuilder.append(" Matrix over ");
        stringBuilder.append(this.f27864a.toString());
        stringBuilder.append(": \n");
        String stringBuilder2 = stringBuilder.toString();
        for (int i = 0; i < this.c; i++) {
            String str = stringBuilder2;
            for (int i2 = 0; i2 < this.d; i2++) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str);
                stringBuilder3.append(this.f27864a.m29222d(this.f27865b[i][i2]));
                stringBuilder3.append(" : ");
                str = stringBuilder3.toString();
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(str);
            stringBuilder4.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            stringBuilder2 = stringBuilder4.toString();
        }
        return stringBuilder2;
    }
}
