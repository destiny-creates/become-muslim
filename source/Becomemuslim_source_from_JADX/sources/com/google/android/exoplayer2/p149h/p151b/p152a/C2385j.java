package com.google.android.exoplayer2.p149h.p151b.p152a;

import java.util.Locale;

/* compiled from: UrlTemplate */
/* renamed from: com.google.android.exoplayer2.h.b.a.j */
public final class C2385j {
    /* renamed from: a */
    private final String[] f5875a;
    /* renamed from: b */
    private final int[] f5876b;
    /* renamed from: c */
    private final String[] f5877c;
    /* renamed from: d */
    private final int f5878d;

    /* renamed from: a */
    public static C2385j m6585a(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new C2385j(strArr, iArr, strArr2, C2385j.m6584a(str, strArr, iArr, strArr2));
    }

    private C2385j(String[] strArr, int[] iArr, String[] strArr2, int i) {
        this.f5875a = strArr;
        this.f5876b = iArr;
        this.f5877c = strArr2;
        this.f5878d = i;
    }

    /* renamed from: a */
    public String m6586a(String str, int i, int i2, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i3 = 0; i3 < this.f5878d; i3++) {
            stringBuilder.append(this.f5875a[i3]);
            if (this.f5876b[i3] == 1) {
                stringBuilder.append(str);
            } else if (this.f5876b[i3] == 2) {
                stringBuilder.append(String.format(Locale.US, this.f5877c[i3], new Object[]{Integer.valueOf(i)}));
            } else if (this.f5876b[i3] == 3) {
                stringBuilder.append(String.format(Locale.US, this.f5877c[i3], new Object[]{Integer.valueOf(i2)}));
            } else if (this.f5876b[i3] == 4) {
                stringBuilder.append(String.format(Locale.US, this.f5877c[i3], new Object[]{Long.valueOf(j)}));
            }
        }
        stringBuilder.append(this.f5875a[this.f5878d]);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static int m6584a(String str, String[] strArr, int[] iArr, String[] strArr2) {
        strArr[0] = "";
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int indexOf = str.indexOf("$", i);
            Object obj = -1;
            StringBuilder stringBuilder;
            if (indexOf == -1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(strArr[i2]);
                stringBuilder.append(str.substring(i));
                strArr[i2] = stringBuilder.toString();
                i = str.length();
            } else {
                if (indexOf != i) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(strArr[i2]);
                    stringBuilder2.append(str.substring(i, indexOf));
                    strArr[i2] = stringBuilder2.toString();
                } else if (str.startsWith("$$", i)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(strArr[i2]);
                    stringBuilder.append("$");
                    strArr[i2] = stringBuilder.toString();
                    i += 2;
                } else {
                    i++;
                    indexOf = str.indexOf("$", i);
                    String substring = str.substring(i, indexOf);
                    if (substring.equals("RepresentationID")) {
                        iArr[i2] = 1;
                    } else {
                        int indexOf2 = substring.indexOf("%0");
                        String str2 = "%01d";
                        if (indexOf2 != -1) {
                            str2 = substring.substring(indexOf2);
                            if (!str2.endsWith("d")) {
                                StringBuilder stringBuilder3 = new StringBuilder();
                                stringBuilder3.append(str2);
                                stringBuilder3.append("d");
                                str2 = stringBuilder3.toString();
                            }
                            substring = substring.substring(0, indexOf2);
                        }
                        indexOf2 = substring.hashCode();
                        if (indexOf2 != -1950496919) {
                            if (indexOf2 != 2606829) {
                                if (indexOf2 == 38199441) {
                                    if (substring.equals("Bandwidth")) {
                                        obj = 1;
                                    }
                                }
                            } else if (substring.equals("Time")) {
                                obj = 2;
                            }
                        } else if (substring.equals("Number")) {
                            obj = null;
                        }
                        switch (obj) {
                            case null:
                                iArr[i2] = 2;
                                break;
                            case 1:
                                iArr[i2] = 3;
                                break;
                            case 2:
                                iArr[i2] = 4;
                                break;
                            default:
                                iArr = new StringBuilder();
                                iArr.append("Invalid template: ");
                                iArr.append(str);
                                throw new IllegalArgumentException(iArr.toString());
                        }
                        strArr2[i2] = str2;
                    }
                    i2++;
                    strArr[i2] = "";
                    indexOf++;
                }
                i = indexOf;
            }
        }
        return i2;
    }
}
