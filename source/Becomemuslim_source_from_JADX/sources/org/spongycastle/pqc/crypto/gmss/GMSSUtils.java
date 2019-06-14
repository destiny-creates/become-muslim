package org.spongycastle.pqc.crypto.gmss;

import java.util.Enumeration;
import java.util.Vector;
import org.spongycastle.util.Arrays;

class GMSSUtils {
    GMSSUtils() {
    }

    /* renamed from: a */
    static byte[][] m29070a(byte[][] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[][] bArr2 = new byte[bArr.length][];
        for (int i = 0; i != bArr.length; i++) {
            bArr2[i] = Arrays.m29373b(bArr[i]);
        }
        return bArr2;
    }

    /* renamed from: a */
    static Treehash[] m29069a(Treehash[] treehashArr) {
        if (treehashArr == null) {
            return null;
        }
        Object obj = new Treehash[treehashArr.length];
        System.arraycopy(treehashArr, 0, obj, 0, treehashArr.length);
        return obj;
    }

    /* renamed from: a */
    static Vector[] m29068a(Vector[] vectorArr) {
        if (vectorArr == null) {
            return null;
        }
        Vector[] vectorArr2 = new Vector[vectorArr.length];
        for (int i = 0; i != vectorArr.length; i++) {
            vectorArr2[i] = new Vector();
            Enumeration elements = vectorArr[i].elements();
            while (elements.hasMoreElements()) {
                vectorArr2[i].addElement(elements.nextElement());
            }
        }
        return vectorArr2;
    }
}
