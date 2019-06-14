package org.spongycastle.pqc.crypto.gmss;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.crypto.MessageSigner;
import org.spongycastle.pqc.crypto.gmss.util.GMSSRandom;
import org.spongycastle.pqc.crypto.gmss.util.GMSSUtil;
import org.spongycastle.pqc.crypto.gmss.util.WinternitzOTSVerify;
import org.spongycastle.pqc.crypto.gmss.util.WinternitzOTSignature;
import org.spongycastle.util.Arrays;

public class GMSSSigner implements MessageSigner {
    /* renamed from: a */
    GMSSKeyParameters f27665a;
    /* renamed from: b */
    private GMSSUtil f27666b;
    /* renamed from: c */
    private byte[] f27667c;
    /* renamed from: d */
    private Digest f27668d;
    /* renamed from: e */
    private int f27669e;
    /* renamed from: f */
    private int f27670f;
    /* renamed from: g */
    private Digest f27671g;
    /* renamed from: h */
    private WinternitzOTSignature f27672h;
    /* renamed from: i */
    private GMSSDigestProvider f27673i;
    /* renamed from: j */
    private int[] f27674j;
    /* renamed from: k */
    private byte[][][] f27675k;
    /* renamed from: l */
    private byte[][] f27676l;
    /* renamed from: m */
    private GMSSParameters f27677m;
    /* renamed from: n */
    private GMSSRandom f27678n;
    /* renamed from: o */
    private SecureRandom f27679o;

    /* renamed from: a */
    public void mo5913a(boolean z, CipherParameters cipherParameters) {
        if (!z) {
            this.f27665a = (GMSSPublicKeyParameters) cipherParameters;
            m36334b();
        } else if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f27679o = parametersWithRandom.m35697a();
            this.f27665a = (GMSSPrivateKeyParameters) parametersWithRandom.m35698b();
            m36333a();
        } else {
            this.f27679o = new SecureRandom();
            this.f27665a = (GMSSPrivateKeyParameters) cipherParameters;
            m36333a();
        }
    }

    /* renamed from: a */
    private void m36333a() {
        this.f27668d.mo5733c();
        GMSSPrivateKeyParameters gMSSPrivateKeyParameters = (GMSSPrivateKeyParameters) this.f27665a;
        if (gMSSPrivateKeyParameters.m43437c()) {
            throw new IllegalStateException("Private key already used");
        } else if (gMSSPrivateKeyParameters.m43434a(0) < gMSSPrivateKeyParameters.m43436c(0)) {
            this.f27677m = gMSSPrivateKeyParameters.m42093b();
            this.f27670f = this.f27677m.m29049a();
            byte[] bArr = new byte[this.f27669e];
            Object obj = new byte[this.f27669e];
            System.arraycopy(gMSSPrivateKeyParameters.m43440f()[this.f27670f - 1], 0, obj, 0, this.f27669e);
            this.f27672h = new WinternitzOTSignature(this.f27678n.m29078a(obj), this.f27673i.m29043a(), this.f27677m.m29051c()[this.f27670f - 1]);
            byte[][][] g = gMSSPrivateKeyParameters.m43441g();
            this.f27675k = new byte[this.f27670f][][];
            for (int i = 0; i < this.f27670f; i++) {
                this.f27675k[i] = (byte[][]) Array.newInstance(byte.class, new int[]{g[i].length, this.f27669e});
                for (int i2 = 0; i2 < g[i].length; i2++) {
                    System.arraycopy(g[i][i2], 0, this.f27675k[i][i2], 0, this.f27669e);
                }
            }
            this.f27674j = new int[this.f27670f];
            System.arraycopy(gMSSPrivateKeyParameters.m43439e(), 0, this.f27674j, 0, this.f27670f);
            this.f27676l = new byte[(this.f27670f - 1)][];
            for (int i3 = 0; i3 < this.f27670f - 1; i3++) {
                obj = gMSSPrivateKeyParameters.m43435b(i3);
                this.f27676l[i3] = new byte[obj.length];
                System.arraycopy(obj, 0, this.f27676l[i3], 0, obj.length);
            }
            gMSSPrivateKeyParameters.m43438d();
        } else {
            throw new IllegalStateException("No more signatures can be generated");
        }
    }

    /* renamed from: a */
    public byte[] mo5915a(byte[] bArr) {
        byte[] bArr2 = new byte[this.f27669e];
        bArr = this.f27672h.m29087a(bArr);
        Object a = this.f27666b.m29081a(this.f27675k[this.f27670f - 1]);
        Object a2 = this.f27666b.m29080a(this.f27674j[this.f27670f - 1]);
        Object obj = new byte[((a2.length + bArr.length) + a.length)];
        System.arraycopy(a2, 0, obj, 0, a2.length);
        System.arraycopy(bArr, 0, obj, a2.length, bArr.length);
        System.arraycopy(a, 0, obj, a2.length + bArr.length, a.length);
        bArr = new byte[0];
        for (int i = (this.f27670f - 1) - 1; i >= 0; i--) {
            a2 = this.f27666b.m29081a(this.f27675k[i]);
            Object a3 = this.f27666b.m29080a(this.f27674j[i]);
            Object obj2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, obj2, 0, bArr.length);
            bArr = new byte[(((obj2.length + a3.length) + this.f27676l[i].length) + a2.length)];
            System.arraycopy(obj2, 0, bArr, 0, obj2.length);
            System.arraycopy(a3, 0, bArr, obj2.length, a3.length);
            System.arraycopy(this.f27676l[i], 0, bArr, obj2.length + a3.length, this.f27676l[i].length);
            System.arraycopy(a2, 0, bArr, (obj2.length + a3.length) + this.f27676l[i].length, a2.length);
        }
        a = new byte[(obj.length + bArr.length)];
        System.arraycopy(obj, 0, a, 0, obj.length);
        System.arraycopy(bArr, 0, a, obj.length, bArr.length);
        return a;
    }

    /* renamed from: b */
    private void m36334b() {
        this.f27668d.mo5733c();
        GMSSPublicKeyParameters gMSSPublicKeyParameters = (GMSSPublicKeyParameters) this.f27665a;
        this.f27667c = gMSSPublicKeyParameters.m43442c();
        this.f27677m = gMSSPublicKeyParameters.m42093b();
        this.f27670f = this.f27677m.m29049a();
    }

    /* renamed from: a */
    public boolean mo5914a(byte[] bArr, byte[] bArr2) {
        this.f27671g.mo5733c();
        int i = this.f27670f - 1;
        int i2 = 0;
        while (i >= 0) {
            WinternitzOTSVerify winternitzOTSVerify = new WinternitzOTSVerify(this.f27673i.m29043a(), this.f27677m.m29051c()[i]);
            int a = winternitzOTSVerify.m29082a();
            int a2 = this.f27666b.m29079a(bArr2, i2);
            i2 += 4;
            Object obj = new byte[a];
            System.arraycopy(bArr2, i2, obj, 0, a);
            i2 += a;
            Object a3 = winternitzOTSVerify.m29084a(bArr, obj);
            if (a3 == null) {
                System.err.println("OTS Public Key is null in GMSSSignature.verify");
                return false;
            }
            byte[][] bArr3 = (byte[][]) Array.newInstance(byte.class, new int[]{this.f27677m.m29050b()[i], this.f27669e});
            a = i2;
            for (Object obj2 : bArr3) {
                System.arraycopy(bArr2, a, obj2, 0, this.f27669e);
                a += this.f27669e;
            }
            byte[] bArr4 = new byte[this.f27669e];
            i2 = (1 << bArr3.length) + a2;
            Object obj3 = a3;
            for (bArr = null; bArr < bArr3.length; bArr++) {
                obj2 = new byte[(this.f27669e << 1)];
                if (i2 % 2 == 0) {
                    System.arraycopy(obj3, 0, obj2, 0, this.f27669e);
                    System.arraycopy(bArr3[bArr], 0, obj2, this.f27669e, this.f27669e);
                    i2 /= 2;
                } else {
                    System.arraycopy(bArr3[bArr], 0, obj2, 0, this.f27669e);
                    System.arraycopy(obj3, 0, obj2, this.f27669e, obj3.length);
                    i2 = (i2 - 1) / 2;
                }
                this.f27668d.mo5731a(obj2, 0, obj2.length);
                obj3 = new byte[this.f27668d.mo5732b()];
                this.f27668d.mo5728a(obj3, 0);
            }
            i--;
            i2 = a;
            a3 = obj3;
        }
        return Arrays.m29353a(this.f27667c, bArr);
    }
}
