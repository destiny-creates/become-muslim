package org.spongycastle.math.field;

import java.math.BigInteger;
import org.spongycastle.util.Integers;

class GenericPolynomialExtensionField implements PolynomialExtensionField {
    /* renamed from: a */
    protected final FiniteField f32675a;
    /* renamed from: b */
    protected final Polynomial f32676b;

    GenericPolynomialExtensionField(FiniteField finiteField, Polynomial polynomial) {
        this.f32675a = finiteField;
        this.f32676b = polynomial;
    }

    /* renamed from: a */
    public BigInteger mo5911a() {
        return this.f32675a.mo5911a();
    }

    /* renamed from: b */
    public int mo5912b() {
        return this.f32675a.mo5912b() * this.f32676b.mo5909a();
    }

    /* renamed from: c */
    public Polynomial mo6823c() {
        return this.f32676b;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GenericPolynomialExtensionField)) {
            return false;
        }
        GenericPolynomialExtensionField genericPolynomialExtensionField = (GenericPolynomialExtensionField) obj;
        if (!this.f32675a.equals(genericPolynomialExtensionField.f32675a) || this.f32676b.equals(genericPolynomialExtensionField.f32676b) == null) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.f32675a.hashCode() ^ Integers.m29395a(this.f32676b.hashCode(), 16);
    }
}
