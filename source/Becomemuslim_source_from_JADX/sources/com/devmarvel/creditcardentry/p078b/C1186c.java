package com.devmarvel.creditcardentry.p078b;

import android.annotation.SuppressLint;
import com.devmarvel.creditcardentry.library.C1190a;
import com.facebook.appevents.AppEventsConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Pattern;

@SuppressLint({"SimpleDateFormat"})
/* compiled from: CreditCardUtil */
/* renamed from: com.devmarvel.creditcardentry.b.c */
public class C1186c {
    /* renamed from: a */
    private static SimpleDateFormat f3310a = new SimpleDateFormat("MM/yyyy");

    static {
        f3310a.setLenient(false);
    }

    /* renamed from: d */
    private static String m4157d(String str) {
        return str.replaceAll("\\s", "");
    }

    /* renamed from: a */
    public static C1190a m4151a(String str) {
        if (str.length() < 4) {
            return C1190a.INVALID;
        }
        for (C1190a c1190a : C1190a.values()) {
            if (c1190a.f3339j != null && Pattern.compile(c1190a.f3339j).matcher(str.substring(0, 4)).matches()) {
                return c1190a;
            }
        }
        return C1190a.INVALID;
    }

    /* renamed from: b */
    public static boolean m4155b(String str) {
        str = C1186c.m4157d(str);
        C1190a a = C1186c.m4151a(str);
        boolean z = false;
        if (a != null) {
            if (a.f3338i != null) {
                if (Pattern.compile(a.f3338i).matcher(str).matches() && C1186c.m4158e(str) != null) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: e */
    private static boolean m4158e(String str) {
        int i = 0;
        int i2 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            int parseInt = Integer.parseInt(str.substring(length, length + 1));
            if (i != 0) {
                parseInt *= 2;
                if (parseInt > 9) {
                    parseInt -= 9;
                }
            }
            i2 += parseInt;
            i ^= 1;
        }
        if (i2 % 10 == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static String m4152a(String str, C1190a c1190a) {
        String d = C1186c.m4157d(str);
        int length = d.length();
        if (length <= 4) {
            return d;
        }
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[]{0, 0, 0};
        switch (c1190a) {
            case VISA:
            case MASTERCARD:
            case JCB:
            case DISCOVER:
                arrayList.add(" ");
                iArr[0] = 4;
                arrayList.add(" ");
                iArr[1] = 4;
                arrayList.add(" ");
                iArr[2] = 4;
                break;
            case AMEX:
                arrayList.add(" ");
                iArr[0] = 6;
                arrayList.add(" ");
                iArr[1] = 5;
                arrayList.add("");
                iArr[2] = 0;
                break;
            case DINERS:
                arrayList.add(" ");
                iArr[0] = 6;
                arrayList.add(" ");
                iArr[1] = 4;
                arrayList.add("");
                iArr[2] = 0;
                break;
            default:
                return str;
        }
        str = d.substring(0, 4);
        c1190a = iArr[0] + 4 > length ? length : iArr[0] + 4;
        String substring = d.substring(4, c1190a);
        int i = iArr[1] + c1190a > length ? length : iArr[1] + c1190a;
        c1190a = d.substring(c1190a, i);
        if (iArr[2] + i <= length) {
            length = iArr[2] + i;
        }
        d = d.substring(i, length);
        return String.format("%s%s%s%s%s%s%s", new Object[]{str, arrayList.get(0), substring, arrayList.get(1), c1190a, arrayList.get(2), d}).trim();
    }

    /* renamed from: a */
    public static int m4150a(C1190a c1190a) {
        switch (c1190a) {
            case VISA:
            case MASTERCARD:
            case JCB:
            case DISCOVER:
                return 19;
            case AMEX:
                return 17;
            case DINERS:
                return 16;
            default:
                return null;
        }
    }

    /* renamed from: c */
    public static String m4156c(String str) {
        try {
            StringBuilder stringBuilder;
            switch (str.length()) {
                case 1:
                    if (Integer.parseInt(str) < 2) {
                        return str;
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    stringBuilder.append(str);
                    stringBuilder.append("/");
                    return stringBuilder.toString();
                case 2:
                    int parseInt = Integer.parseInt(str);
                    if (parseInt <= 12) {
                        if (parseInt >= 1) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(str);
                            stringBuilder.append("/");
                            return stringBuilder.toString();
                        }
                    }
                    return str.substring(0, 1);
                case 3:
                    if (!str.substring(2, 3).equalsIgnoreCase("/")) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str.substring(0, 2));
                        stringBuilder.append("/");
                        stringBuilder.append(str.substring(2, 3));
                        str = stringBuilder.toString();
                        break;
                    }
                    return str;
                case 4:
                    break;
                case 5:
                    Calendar a = C1186c.m4153a();
                    String valueOf = String.valueOf(a.get(1));
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str.substring(0, 3));
                    stringBuilder2.append(valueOf.substring(0, 2));
                    stringBuilder2.append(str.substring(3, 5));
                    if (f3310a.parse(stringBuilder2.toString()).before(a.getTime())) {
                        return str.substring(0, 4);
                    }
                    return str;
                default:
                    return str.length() > 5 ? str.substring(0, 5) : str;
            }
            if (Integer.parseInt(str.substring(3, 4)) < Integer.parseInt(String.valueOf(C1186c.m4153a().get(1)).substring(2, 3))) {
                return str.substring(0, 3);
            }
            return str;
        } catch (String str2) {
            str2.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    private static Calendar m4153a() {
        Calendar instance = Calendar.getInstance();
        instance.set(instance.get(1), instance.get(2), 0, 0, 0);
        return instance;
    }

    /* renamed from: b */
    public static int m4154b(C1190a c1190a) {
        return (c1190a != null && C11851.f3309a[c1190a.ordinal()] == 5) ? 4 : 3;
    }
}
