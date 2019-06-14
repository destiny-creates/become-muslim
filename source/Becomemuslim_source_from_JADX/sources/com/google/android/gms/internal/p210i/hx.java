package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.hx */
final class hx {
    /* renamed from: a */
    static String m20761a(dy dyVar) {
        hz hyVar = new hy(dyVar);
        dyVar = new StringBuilder(hyVar.mo4584a());
        for (int i = 0; i < hyVar.mo4584a(); i++) {
            byte a = hyVar.mo4583a(i);
            if (a == (byte) 34) {
                dyVar.append("\\\"");
            } else if (a == (byte) 39) {
                dyVar.append("\\'");
            } else if (a != (byte) 92) {
                switch (a) {
                    case (byte) 7:
                        dyVar.append("\\a");
                        break;
                    case (byte) 8:
                        dyVar.append("\\b");
                        break;
                    case (byte) 9:
                        dyVar.append("\\t");
                        break;
                    case (byte) 10:
                        dyVar.append("\\n");
                        break;
                    case (byte) 11:
                        dyVar.append("\\v");
                        break;
                    case (byte) 12:
                        dyVar.append("\\f");
                        break;
                    case (byte) 13:
                        dyVar.append("\\r");
                        break;
                    default:
                        if (a >= (byte) 32 && a <= (byte) 126) {
                            dyVar.append((char) a);
                            break;
                        }
                        dyVar.append('\\');
                        dyVar.append((char) (((a >>> 6) & 3) + 48));
                        dyVar.append((char) (((a >>> 3) & 7) + 48));
                        dyVar.append((char) ((a & 7) + 48));
                        break;
                }
            } else {
                dyVar.append("\\\\");
            }
        }
        return dyVar.toString();
    }
}
