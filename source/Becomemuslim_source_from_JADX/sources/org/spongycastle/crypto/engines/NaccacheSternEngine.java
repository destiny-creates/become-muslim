package org.spongycastle.crypto.engines;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Vector;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.NaccacheSternKeyParameters;
import org.spongycastle.crypto.params.NaccacheSternPrivateKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.util.Arrays;

public class NaccacheSternEngine implements AsymmetricBlockCipher {
    /* renamed from: e */
    private static BigInteger f26684e = BigInteger.valueOf(0);
    /* renamed from: f */
    private static BigInteger f26685f = BigInteger.valueOf(1);
    /* renamed from: a */
    private boolean f26686a;
    /* renamed from: b */
    private NaccacheSternKeyParameters f26687b;
    /* renamed from: c */
    private Vector[] f26688c = null;
    /* renamed from: d */
    private boolean f26689d = false;

    /* renamed from: a */
    public void mo5737a(boolean z, CipherParameters cipherParameters) {
        this.f26686a = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).m35698b();
        }
        this.f26687b = (NaccacheSternKeyParameters) cipherParameters;
        if (!this.f26686a) {
            if (this.f26689d) {
                System.out.println("Constructing lookup Array");
            }
            NaccacheSternPrivateKeyParameters naccacheSternPrivateKeyParameters = (NaccacheSternPrivateKeyParameters) this.f26687b;
            cipherParameters = naccacheSternPrivateKeyParameters.m43376f();
            this.f26688c = new Vector[cipherParameters.size()];
            for (int i = 0; i < cipherParameters.size(); i++) {
                BigInteger bigInteger = (BigInteger) cipherParameters.elementAt(i);
                int intValue = bigInteger.intValue();
                this.f26688c[i] = new Vector();
                this.f26688c[i].addElement(f26685f);
                if (this.f26689d) {
                    PrintStream printStream = System.out;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Constructing lookup ArrayList for ");
                    stringBuilder.append(intValue);
                    printStream.println(stringBuilder.toString());
                }
                BigInteger bigInteger2 = f26684e;
                for (int i2 = 1; i2 < intValue; i2++) {
                    bigInteger2 = bigInteger2.add(naccacheSternPrivateKeyParameters.m43375e());
                    this.f26688c[i].addElement(naccacheSternPrivateKeyParameters.m40796b().modPow(bigInteger2.divide(bigInteger), naccacheSternPrivateKeyParameters.m40798d()));
                }
            }
        }
    }

    /* renamed from: a */
    public int mo5736a() {
        if (this.f26686a) {
            return ((this.f26687b.m40797c() + 7) / 8) - 1;
        }
        return this.f26687b.m40798d().toByteArray().length;
    }

    /* renamed from: b */
    public int mo5739b() {
        if (this.f26686a) {
            return this.f26687b.m40798d().toByteArray().length;
        }
        return ((this.f26687b.m40797c() + 7) / 8) - 1;
    }

    /* renamed from: a */
    public byte[] mo5738a(byte[] bArr, int i, int i2) {
        if (this.f26687b == null) {
            throw new IllegalStateException("NaccacheStern engine not initialised");
        } else if (i2 <= mo5736a() + 1) {
            if (!this.f26686a) {
                if (i2 < mo5736a()) {
                    throw new InvalidCipherTextException("BlockLength does not match modulus for Naccache-Stern cipher.\n");
                }
            }
            int i3 = 0;
            if (!(i == 0 && i2 == bArr.length)) {
                Object obj = new byte[i2];
                System.arraycopy(bArr, i, obj, 0, i2);
                bArr = obj;
            }
            i = new BigInteger(1, bArr);
            if (this.f26689d != null) {
                bArr = System.out;
                i2 = new StringBuilder();
                i2.append("input as BigInteger: ");
                i2.append(i);
                bArr.println(i2.toString());
            }
            if (this.f26686a != null) {
                return m35030a(i);
            }
            Vector vector = new Vector();
            NaccacheSternPrivateKeyParameters naccacheSternPrivateKeyParameters = (NaccacheSternPrivateKeyParameters) this.f26687b;
            Vector f = naccacheSternPrivateKeyParameters.m43376f();
            for (int i4 = 0; i4 < f.size(); i4++) {
                BigInteger modPow = i.modPow(naccacheSternPrivateKeyParameters.m43375e().divide((BigInteger) f.elementAt(i4)), naccacheSternPrivateKeyParameters.m40798d());
                Vector vector2 = this.f26688c[i4];
                if (this.f26688c[i4].size() != ((BigInteger) f.elementAt(i4)).intValue()) {
                    if (this.f26689d != null) {
                        bArr = System.out;
                        i = new StringBuilder();
                        i.append("Prime is ");
                        i.append(f.elementAt(i4));
                        i.append(", lookup table has size ");
                        i.append(vector2.size());
                        bArr.println(i.toString());
                    }
                    i = new StringBuilder();
                    i.append("Error in lookup Array for ");
                    i.append(((BigInteger) f.elementAt(i4)).intValue());
                    i.append(": Size mismatch. Expected ArrayList with length ");
                    i.append(((BigInteger) f.elementAt(i4)).intValue());
                    i.append(" but found ArrayList of length ");
                    i.append(this.f26688c[i4].size());
                    throw new InvalidCipherTextException(i.toString());
                }
                int indexOf = vector2.indexOf(modPow);
                if (indexOf == -1) {
                    if (this.f26689d != null) {
                        bArr = System.out;
                        i = new StringBuilder();
                        i.append("Actual prime is ");
                        i.append(f.elementAt(i4));
                        bArr.println(i.toString());
                        bArr = System.out;
                        i = new StringBuilder();
                        i.append("Decrypted value is ");
                        i.append(modPow);
                        bArr.println(i.toString());
                        bArr = System.out;
                        i = new StringBuilder();
                        i.append("LookupList for ");
                        i.append(f.elementAt(i4));
                        i.append(" with size ");
                        i.append(this.f26688c[i4].size());
                        i.append(" is: ");
                        bArr.println(i.toString());
                        while (i3 < this.f26688c[i4].size()) {
                            System.out.println(this.f26688c[i4].elementAt(i3));
                            i3++;
                        }
                    }
                    throw new InvalidCipherTextException("Lookup failed");
                }
                vector.addElement(BigInteger.valueOf((long) indexOf));
            }
            return m35027a(vector, f).toByteArray();
        } else {
            throw new DataLengthException("input too large for Naccache-Stern cipher.\n");
        }
    }

    /* renamed from: a */
    public byte[] m35030a(BigInteger bigInteger) {
        byte[] toByteArray = this.f26687b.m40798d().toByteArray();
        Arrays.m29351a(toByteArray, (byte) 0);
        bigInteger = this.f26687b.m40796b().modPow(bigInteger, this.f26687b.m40798d()).toByteArray();
        System.arraycopy(bigInteger, 0, toByteArray, toByteArray.length - bigInteger.length, bigInteger.length);
        if (this.f26689d != null) {
            bigInteger = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Encrypted value is:  ");
            stringBuilder.append(new BigInteger(toByteArray));
            bigInteger.println(stringBuilder.toString());
        }
        return toByteArray;
    }

    /* renamed from: a */
    private static BigInteger m35027a(Vector vector, Vector vector2) {
        BigInteger bigInteger = f26684e;
        BigInteger bigInteger2 = f26685f;
        for (int i = 0; i < vector2.size(); i++) {
            bigInteger2 = bigInteger2.multiply((BigInteger) vector2.elementAt(i));
        }
        for (int i2 = 0; i2 < vector2.size(); i2++) {
            BigInteger bigInteger3 = (BigInteger) vector2.elementAt(i2);
            BigInteger divide = bigInteger2.divide(bigInteger3);
            bigInteger = bigInteger.add(divide.multiply(divide.modInverse(bigInteger3)).multiply((BigInteger) vector.elementAt(i2)));
        }
        return bigInteger.mod(bigInteger2);
    }
}
