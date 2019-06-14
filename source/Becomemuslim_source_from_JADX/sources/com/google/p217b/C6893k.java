package com.google.p217b;

import com.google.p217b.p218a.C6855c;
import com.google.p217b.p222b.C5202b;
import com.google.p217b.p225c.C6859b;
import com.google.p217b.p231e.C6875u;
import com.google.p217b.p231e.C7902b;
import com.google.p217b.p231e.C7904d;
import com.google.p217b.p231e.C7906f;
import com.google.p217b.p231e.C7908h;
import com.google.p217b.p231e.C7910o;
import com.google.p217b.p231e.C8235j;
import com.google.p217b.p231e.C8237l;
import com.google.p217b.p231e.ab;
import com.google.p217b.p235f.C6878d;
import com.google.p217b.p240g.C6890b;
import java.util.Map;

/* compiled from: MultiFormatWriter */
/* renamed from: com.google.b.k */
public final class C6893k implements C5318u {
    /* renamed from: a */
    public C5202b mo4860a(String str, C5193a c5193a, int i, int i2, Map<C5309g, ?> map) {
        C6855c c8237l;
        switch (c5193a) {
            case EAN_8:
                c8237l = new C8237l();
                break;
            case UPC_E:
                c8237l = new ab();
                break;
            case EAN_13:
                c8237l = new C8235j();
                break;
            case UPC_A:
                c8237l = new C6875u();
                break;
            case QR_CODE:
                c8237l = new C6890b();
                break;
            case CODE_39:
                c8237l = new C7906f();
                break;
            case CODE_93:
                c8237l = new C7908h();
                break;
            case CODE_128:
                c8237l = new C7904d();
                break;
            case ITF:
                c8237l = new C7910o();
                break;
            case PDF_417:
                c8237l = new C6878d();
                break;
            case CODABAR:
                c8237l = new C7902b();
                break;
            case DATA_MATRIX:
                c8237l = new C6859b();
                break;
            case AZTEC:
                c8237l = new C6855c();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(c5193a)));
        }
        return c8237l.mo4860a(str, c5193a, i, i2, map);
    }
}
