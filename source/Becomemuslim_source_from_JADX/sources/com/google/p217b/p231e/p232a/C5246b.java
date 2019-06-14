package com.google.p217b.p231e.p232a;

/* compiled from: DataCharacter */
/* renamed from: com.google.b.e.a.b */
public class C5246b {
    /* renamed from: a */
    private final int f17700a;
    /* renamed from: b */
    private final int f17701b;

    public C5246b(int i, int i2) {
        this.f17700a = i;
        this.f17701b = i2;
    }

    /* renamed from: a */
    public final int m22224a() {
        return this.f17700a;
    }

    /* renamed from: b */
    public final int m22225b() {
        return this.f17701b;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f17700a);
        stringBuilder.append("(");
        stringBuilder.append(this.f17701b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C5246b)) {
            return false;
        }
        C5246b c5246b = (C5246b) obj;
        if (this.f17700a == c5246b.f17700a && this.f17701b == c5246b.f17701b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f17700a ^ this.f17701b;
    }
}
