package com.google.android.gms.internal.ads;

final class aef {
    /* renamed from: a */
    static String m18172a(aai aai) {
        aeh aeg = new aeg(aai);
        StringBuilder stringBuilder = new StringBuilder(aeg.mo3770a());
        for (int i = 0; i < aeg.mo3770a(); i++) {
            String str;
            int a = aeg.mo3769a(i);
            if (a == 34) {
                str = "\\\"";
            } else if (a == 39) {
                str = "\\'";
            } else if (a != 92) {
                switch (a) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (a < 32 || a > 126) {
                            stringBuilder.append('\\');
                            stringBuilder.append((char) (((a >>> 6) & 3) + 48));
                            stringBuilder.append((char) (((a >>> 3) & 7) + 48));
                            a = (a & 7) + 48;
                        }
                        stringBuilder.append((char) a);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
