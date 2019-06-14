package org.spongycastle.util.io.pem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PemObject implements PemObjectGenerator {
    /* renamed from: a */
    private static final List f27891a = Collections.unmodifiableList(new ArrayList());
    /* renamed from: b */
    private String f27892b;
    /* renamed from: c */
    private List f27893c;
    /* renamed from: d */
    private byte[] f27894d;

    /* renamed from: d */
    public PemObject mo5939d() {
        return this;
    }

    public PemObject(String str, byte[] bArr) {
        this(str, f27891a, bArr);
    }

    public PemObject(String str, List list, byte[] bArr) {
        this.f27892b = str;
        this.f27893c = Collections.unmodifiableList(list);
        this.f27894d = bArr;
    }

    /* renamed from: a */
    public String m36598a() {
        return this.f27892b;
    }

    /* renamed from: b */
    public List m36599b() {
        return this.f27893c;
    }

    /* renamed from: c */
    public byte[] m36600c() {
        return this.f27894d;
    }
}
