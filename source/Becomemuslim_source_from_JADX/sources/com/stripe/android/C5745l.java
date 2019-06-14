package com.stripe.android;

import com.facebook.GraphResponse;

/* compiled from: PaymentSessionUtils */
/* renamed from: com.stripe.android.l */
class C5745l {
    /* renamed from: a */
    public static String m24320a(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -1867169789) {
            if (hashCode != -1010022050) {
                if (hashCode != 96784904) {
                    if (hashCode == 2043678173) {
                        if (str.equals("user_cancelled") != null) {
                            str = true;
                            switch (str) {
                                case null:
                                    return GraphResponse.SUCCESS_KEY;
                                case 1:
                                    return "user_cancelled";
                                case 2:
                                    return "error";
                                case 3:
                                    return "incomplete";
                                default:
                                    return "error";
                            }
                        }
                    }
                } else if (str.equals("error") != null) {
                    str = 2;
                    switch (str) {
                        case null:
                            return GraphResponse.SUCCESS_KEY;
                        case 1:
                            return "user_cancelled";
                        case 2:
                            return "error";
                        case 3:
                            return "incomplete";
                        default:
                            return "error";
                    }
                }
            } else if (str.equals("incomplete") != null) {
                str = 3;
                switch (str) {
                    case null:
                        return GraphResponse.SUCCESS_KEY;
                    case 1:
                        return "user_cancelled";
                    case 2:
                        return "error";
                    case 3:
                        return "incomplete";
                    default:
                        return "error";
                }
            }
        } else if (str.equals(GraphResponse.SUCCESS_KEY) != null) {
            str = null;
            switch (str) {
                case null:
                    return GraphResponse.SUCCESS_KEY;
                case 1:
                    return "user_cancelled";
                case 2:
                    return "error";
                case 3:
                    return "incomplete";
                default:
                    return "error";
            }
        }
        str = -1;
        switch (str) {
            case null:
                return GraphResponse.SUCCESS_KEY;
            case 1:
                return "user_cancelled";
            case 2:
                return "error";
            case 3:
                return "incomplete";
            default:
                return "error";
        }
    }
}
