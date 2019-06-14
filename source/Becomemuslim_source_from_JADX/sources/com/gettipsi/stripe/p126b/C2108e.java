package com.gettipsi.stripe.p126b;

import com.stripe.android.p285b.C7157c;

/* compiled from: Utils */
/* renamed from: com.gettipsi.stripe.b.e */
public class C2108e {
    /* renamed from: a */
    public static String m5808a(C7157c c7157c) {
        if (!c7157c.c()) {
            return "The card number that you entered is invalid";
        }
        if (c7157c.d()) {
            return c7157c.e() == null ? "The CVC code that you entered is invalid" : null;
        } else {
            return "The expiration date that you entered is invalid";
        }
    }
}
