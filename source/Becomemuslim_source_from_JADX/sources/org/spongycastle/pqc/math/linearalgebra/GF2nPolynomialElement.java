package org.spongycastle.pqc.math.linearalgebra;

import android.support.v7.widget.LinearLayoutManager;
import com.facebook.common.util.ByteConstants;
import com.facebook.imagepipeline.memory.DefaultFlexByteArrayPoolParams;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;

public class GF2nPolynomialElement extends GF2nElement {
    /* renamed from: c */
    private static final int[] f32185c = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, Utility.DEFAULT_STREAM_BUFFER_SIZE, 16384, 32768, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 131072, 262144, 524288, ByteConstants.MB, 2097152, DefaultFlexByteArrayPoolParams.DEFAULT_MAX_BYTE_ARRAY_SIZE, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, LinearLayoutManager.INVALID_OFFSET, 0};
    /* renamed from: d */
    private GF2Polynomial f32186d;

    public GF2nPolynomialElement(GF2nPolynomialElement gF2nPolynomialElement) {
        this.a = gF2nPolynomialElement.a;
        this.b = gF2nPolynomialElement.b;
        this.f32186d = new GF2Polynomial(gF2nPolynomialElement.f32186d);
    }

    public Object clone() {
        return new GF2nPolynomialElement(this);
    }

    /* renamed from: a */
    public boolean mo6590a() {
        return this.f32186d.m29204f();
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof GF2nPolynomialElement) {
                GF2nPolynomialElement gF2nPolynomialElement = (GF2nPolynomialElement) obj;
                if (this.a == gF2nPolynomialElement.a || this.a.m29224b().equals(gF2nPolynomialElement.a.m29224b())) {
                    return this.f32186d.equals(gF2nPolynomialElement.f32186d);
                }
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() + this.f32186d.hashCode();
    }

    public String toString() {
        return this.f32186d.m29188a(16);
    }
}
