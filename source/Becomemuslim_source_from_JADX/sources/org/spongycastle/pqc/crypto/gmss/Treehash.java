package org.spongycastle.pqc.crypto.gmss;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Vector;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.encoders.Hex;

public class Treehash {
    /* renamed from: a */
    private int f23231a;
    /* renamed from: b */
    private Vector f23232b;
    /* renamed from: c */
    private Vector f23233c;
    /* renamed from: d */
    private byte[] f23234d = null;
    /* renamed from: e */
    private byte[] f23235e;
    /* renamed from: f */
    private byte[] f23236f;
    /* renamed from: g */
    private int f23237g;
    /* renamed from: h */
    private int f23238h;
    /* renamed from: i */
    private boolean f23239i = false;
    /* renamed from: j */
    private boolean f23240j = false;
    /* renamed from: k */
    private boolean f23241k = false;
    /* renamed from: l */
    private Digest f23242l;

    public Treehash(Vector vector, int i, Digest digest) {
        this.f23232b = vector;
        this.f23231a = i;
        this.f23242l = digest;
        this.f23236f = new byte[this.f23242l.mo5732b()];
        this.f23235e = new byte[this.f23242l.mo5732b()];
    }

    /* renamed from: a */
    public void m29072a(byte[] bArr) {
        System.arraycopy(bArr, 0, this.f23236f, 0, this.f23242l.mo5732b());
        this.f23241k = 1;
    }

    /* renamed from: a */
    public void m29071a() {
        if (this.f23241k) {
            this.f23233c = new Vector();
            this.f23237g = 0;
            this.f23234d = null;
            this.f23238h = -1;
            this.f23239i = true;
            System.arraycopy(this.f23236f, 0, this.f23235e, 0, this.f23242l.mo5732b());
            return;
        }
        PrintStream printStream = System.err;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Seed ");
        stringBuilder.append(this.f23231a);
        stringBuilder.append(" not initialized");
        printStream.println(stringBuilder.toString());
    }

    /* renamed from: b */
    public void m29073b(byte[] bArr) {
        if (!this.f23239i) {
            m29071a();
        }
        this.f23234d = bArr;
        this.f23238h = this.f23231a;
        this.f23240j = 1;
    }

    /* renamed from: b */
    public byte[][] m29074b() {
        byte[][] bArr = (byte[][]) Array.newInstance(byte.class, new int[]{this.f23237g + 3, this.f23242l.mo5732b()});
        int i = 0;
        bArr[0] = this.f23234d;
        bArr[1] = this.f23235e;
        bArr[2] = this.f23236f;
        while (i < this.f23237g) {
            bArr[i + 3] = (byte[]) this.f23232b.elementAt(i);
            i++;
        }
        return bArr;
    }

    /* renamed from: c */
    public int[] m29075c() {
        int[] iArr = new int[(this.f23237g + 6)];
        int i = 0;
        iArr[0] = this.f23231a;
        iArr[1] = this.f23237g;
        iArr[2] = this.f23238h;
        if (this.f23240j) {
            iArr[3] = 1;
        } else {
            iArr[3] = 0;
        }
        if (this.f23239i) {
            iArr[4] = 1;
        } else {
            iArr[4] = 0;
        }
        if (this.f23241k) {
            iArr[5] = 1;
        } else {
            iArr[5] = 0;
        }
        while (i < this.f23237g) {
            iArr[i + 6] = ((Integer) this.f23233c.elementAt(i)).intValue();
            i++;
        }
        return iArr;
    }

    public String toString() {
        StringBuilder stringBuilder;
        String str = "Treehash    : ";
        for (int i = 0; i < this.f23237g + 6; i++) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(m29075c()[i]);
            stringBuilder2.append(" ");
            str = stringBuilder2.toString();
        }
        for (int i2 = 0; i2 < this.f23237g + 3; i2++) {
            String stringBuilder3;
            if (m29074b()[i2] != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(new String(Hex.m29437a(m29074b()[i2])));
                stringBuilder.append(" ");
                stringBuilder3 = stringBuilder.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("null ");
                stringBuilder3 = stringBuilder.toString();
            }
            str = stringBuilder3;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("  ");
        stringBuilder.append(this.f23242l.mo5732b());
        return stringBuilder.toString();
    }
}
