package com.polidea.p254a.p255a;

import java.util.Date;

/* compiled from: BleScanException */
/* renamed from: com.polidea.a.a.n */
public class C6975n extends C5548g {
    /* renamed from: a */
    private final int f24865a;
    /* renamed from: b */
    private final Date f24866b;

    /* renamed from: a */
    private static String m32753a(int i) {
        if (i == 2147483646) {
            return "Undocumented scan throttle";
        }
        switch (i) {
            case 0:
                return "Bluetooth cannot start";
            case 1:
                return "Bluetooth disabled";
            case 2:
                return "Bluetooth not available";
            case 3:
                return "Location Permission missing";
            case 4:
                return "Location Services disabled";
            case 5:
                return "Scan failed because it has already started";
            case 6:
                return "Scan failed because application registration failed";
            case 7:
                return "Scan failed because of an internal error";
            case 8:
                return "Scan failed because feature unsupported";
            case 9:
                return "Scan failed because out of hardware resources";
            default:
                return "Unknown error";
        }
    }

    public C6975n(int i) {
        super(C6975n.m32754a(i, null));
        this.f24865a = i;
        this.f24866b = null;
    }

    public C6975n(int i, Date date) {
        super(C6975n.m32754a(i, date));
        this.f24865a = i;
        this.f24866b = date;
    }

    public C6975n(int i, Throwable th) {
        super(C6975n.m32754a(i, null), th);
        this.f24865a = i;
        this.f24866b = null;
    }

    /* renamed from: a */
    public int m32756a() {
        return this.f24865a;
    }

    /* renamed from: a */
    private static String m32754a(int i, Date date) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C6975n.m32753a(i));
        stringBuilder.append(" (code ");
        stringBuilder.append(i);
        stringBuilder.append(")");
        stringBuilder.append(C6975n.m32755a(date));
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static String m32755a(Date date) {
        if (date == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(", suggested retry date is ");
        stringBuilder.append(date);
        return stringBuilder.toString();
    }
}
