package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.util.C2892b;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.AppMeasurement.C6848e;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.firebase.analytics.connector.internal.b */
public final class C5329b {
    /* renamed from: a */
    private static final List<String> f17964a = Arrays.asList(new String[]{"_e", "_f", "_iap", "_s", "_au", "_ui", "_cd", "app_open"});
    /* renamed from: b */
    private static final List<String> f17965b = Arrays.asList(new String[]{"auto", "app", "am"});
    /* renamed from: c */
    private static final List<String> f17966c = Arrays.asList(new String[]{"_r", "_dbg"});
    /* renamed from: d */
    private static final List<String> f17967d = Arrays.asList((String[]) C2892b.a(new String[][]{C6848e.f24656a, C6848e.f24657b}));
    /* renamed from: e */
    private static final List<String> f17968e = Arrays.asList(new String[]{"^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$"});

    /* renamed from: a */
    public static boolean m22591a(String str) {
        return !f17965b.contains(str);
    }

    /* renamed from: a */
    public static boolean m22592a(String str, Bundle bundle) {
        if (f17964a.contains(str)) {
            return false;
        }
        if (bundle != null) {
            for (String containsKey : f17966c) {
                if (bundle.containsKey(containsKey)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m22593a(String str, String str2) {
        if (!"_ce1".equals(str2)) {
            if (!"_ce2".equals(str2)) {
                if ("_ln".equals(str2)) {
                    return str.equals(AppMeasurement.FCM_ORIGIN);
                }
                if (f17967d.contains(str2)) {
                    return false;
                }
                for (String matches : f17968e) {
                    if (str2.matches(matches)) {
                        return false;
                    }
                }
                return true;
            }
        }
        if (!str.equals(AppMeasurement.FCM_ORIGIN)) {
            if (!str.equals("frc")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m22594a(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!C5329b.m22591a(str) || bundle == null) {
            return false;
        }
        Object obj;
        for (String containsKey : f17966c) {
            if (bundle.containsKey(containsKey)) {
                return false;
            }
        }
        int hashCode = str.hashCode();
        if (hashCode != 101200) {
            if (hashCode != 101230) {
                if (hashCode == 3142703) {
                    if (str.equals(AppMeasurement.FIAM_ORIGIN)) {
                        obj = 2;
                        switch (obj) {
                            case null:
                                str = "_cis";
                                str2 = "fcm_integration";
                                break;
                            case 1:
                                str = "_cis";
                                str2 = "fdl_integration";
                                break;
                            case 2:
                                str = "_cis";
                                str2 = "fiam_integration";
                                break;
                            default:
                                return false;
                        }
                        bundle.putString(str, str2);
                        return true;
                    }
                }
            } else if (str.equals("fdl")) {
                obj = 1;
                switch (obj) {
                    case null:
                        str = "_cis";
                        str2 = "fcm_integration";
                        break;
                    case 1:
                        str = "_cis";
                        str2 = "fdl_integration";
                        break;
                    case 2:
                        str = "_cis";
                        str2 = "fiam_integration";
                        break;
                    default:
                        return false;
                }
                bundle.putString(str, str2);
                return true;
            }
        } else if (str.equals(AppMeasurement.FCM_ORIGIN)) {
            obj = null;
            switch (obj) {
                case null:
                    str = "_cis";
                    str2 = "fcm_integration";
                    break;
                case 1:
                    str = "_cis";
                    str2 = "fdl_integration";
                    break;
                case 2:
                    str = "_cis";
                    str2 = "fiam_integration";
                    break;
                default:
                    return false;
            }
            bundle.putString(str, str2);
            return true;
        }
        obj = -1;
        switch (obj) {
            case null:
                str = "_cis";
                str2 = "fcm_integration";
                break;
            case 1:
                str = "_cis";
                str2 = "fdl_integration";
                break;
            case 2:
                str = "_cis";
                str2 = "fiam_integration";
                break;
            default:
                return false;
        }
        bundle.putString(str, str2);
        return true;
    }
}
