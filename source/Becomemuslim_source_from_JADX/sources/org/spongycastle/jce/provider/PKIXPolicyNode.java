package org.spongycastle.jce.provider;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PKIXPolicyNode implements PolicyNode {
    /* renamed from: a */
    protected List f23001a;
    /* renamed from: b */
    protected int f23002b;
    /* renamed from: c */
    protected Set f23003c;
    /* renamed from: d */
    protected PolicyNode f23004d;
    /* renamed from: e */
    protected Set f23005e;
    /* renamed from: f */
    protected String f23006f;
    /* renamed from: g */
    protected boolean f23007g;

    public PKIXPolicyNode(List list, int i, Set set, PolicyNode policyNode, Set set2, String str, boolean z) {
        this.f23001a = list;
        this.f23002b = i;
        this.f23003c = set;
        this.f23004d = policyNode;
        this.f23005e = set2;
        this.f23006f = str;
        this.f23007g = z;
    }

    /* renamed from: a */
    public void m28233a(PKIXPolicyNode pKIXPolicyNode) {
        this.f23001a.add(pKIXPolicyNode);
        pKIXPolicyNode.m28238c(this);
    }

    public Iterator getChildren() {
        return this.f23001a.iterator();
    }

    public int getDepth() {
        return this.f23002b;
    }

    public Set getExpectedPolicies() {
        return this.f23003c;
    }

    public PolicyNode getParent() {
        return this.f23004d;
    }

    public Set getPolicyQualifiers() {
        return this.f23005e;
    }

    public String getValidPolicy() {
        return this.f23006f;
    }

    /* renamed from: a */
    public boolean m28235a() {
        return this.f23001a.isEmpty() ^ 1;
    }

    public boolean isCritical() {
        return this.f23007g;
    }

    /* renamed from: b */
    public void m28237b(PKIXPolicyNode pKIXPolicyNode) {
        this.f23001a.remove(pKIXPolicyNode);
    }

    /* renamed from: a */
    public void m28234a(boolean z) {
        this.f23007g = z;
    }

    /* renamed from: c */
    public void m28238c(PKIXPolicyNode pKIXPolicyNode) {
        this.f23004d = pKIXPolicyNode;
    }

    public String toString() {
        return m28232a("");
    }

    /* renamed from: a */
    public String m28232a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(this.f23006f);
        stringBuffer.append(" {\n");
        for (int i = 0; i < this.f23001a.size(); i++) {
            PKIXPolicyNode pKIXPolicyNode = (PKIXPolicyNode) this.f23001a.get(i);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("    ");
            stringBuffer.append(pKIXPolicyNode.m28232a(stringBuilder.toString()));
        }
        stringBuffer.append(str);
        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }

    public Object clone() {
        return m28236b();
    }

    /* renamed from: b */
    public PKIXPolicyNode m28236b() {
        Set hashSet = new HashSet();
        for (String str : this.f23003c) {
            hashSet.add(new String(str));
        }
        Set hashSet2 = new HashSet();
        for (String str2 : this.f23005e) {
            hashSet2.add(new String(str2));
        }
        PKIXPolicyNode pKIXPolicyNode = new PKIXPolicyNode(new ArrayList(), this.f23002b, hashSet, null, hashSet2, new String(this.f23006f), this.f23007g);
        for (PKIXPolicyNode b : this.f23001a) {
            PKIXPolicyNode b2 = b2.m28236b();
            b2.m28238c(pKIXPolicyNode);
            pKIXPolicyNode.m28233a(b2);
        }
        return pKIXPolicyNode;
    }
}
