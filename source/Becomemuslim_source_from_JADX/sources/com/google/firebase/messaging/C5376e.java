package com.google.firebase.messaging;

import java.util.Locale;

/* renamed from: com.google.firebase.messaging.e */
public final class C5376e extends Exception {
    /* renamed from: a */
    private final int f18142a;

    C5376e(String str) {
        super(str);
        int i = 4;
        if (str != null) {
            str = str.toLowerCase(Locale.US);
            Object obj = -1;
            switch (str.hashCode()) {
                case -1743242157:
                    if (str.equals("service_not_available") != null) {
                        obj = 3;
                        break;
                    }
                    break;
                case -1290953729:
                    if (str.equals("toomanymessages") != null) {
                        obj = 4;
                        break;
                    }
                    break;
                case -920906446:
                    if (str.equals("invalid_parameters") != null) {
                        obj = null;
                        break;
                    }
                    break;
                case -617027085:
                    if (str.equals("messagetoobig") != null) {
                        obj = 2;
                        break;
                    }
                    break;
                case -95047692:
                    if (str.equals("missing_to") != null) {
                        obj = 1;
                        break;
                    }
                    break;
                default:
                    break;
            }
            switch (obj) {
                case null:
                case 1:
                    i = 1;
                    break;
                case 2:
                    i = 2;
                    break;
                case 3:
                    i = 3;
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }
        i = 0;
        this.f18142a = i;
    }
}
