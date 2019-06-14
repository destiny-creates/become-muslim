package host.exp.exponent;

import android.content.Context;
import android.text.TextUtils;
import host.exp.exponent.p334a.C6289b;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/* compiled from: Constants */
/* renamed from: host.exp.exponent.d */
public class C6301d {
    /* renamed from: a */
    public static String f20495a = null;
    /* renamed from: b */
    public static String f20496b = null;
    /* renamed from: c */
    public static String f20497c = null;
    /* renamed from: d */
    public static String f20498d = null;
    /* renamed from: e */
    public static String f20499e = null;
    /* renamed from: f */
    public static List<String> f20500f = null;
    /* renamed from: g */
    public static List<C6297a> f20501g = null;
    /* renamed from: h */
    public static boolean f20502h = false;
    /* renamed from: i */
    public static String f20503i = "default";
    /* renamed from: j */
    public static boolean f20504j = false;
    /* renamed from: k */
    public static boolean f20505k = true;
    /* renamed from: l */
    public static int f20506l = 0;
    /* renamed from: m */
    public static boolean f20507m = false;
    /* renamed from: n */
    public static boolean f20508n = false;
    /* renamed from: o */
    private static final String f20509o = "d";
    /* renamed from: p */
    private static boolean f20510p = false;

    /* compiled from: Constants */
    /* renamed from: host.exp.exponent.d$a */
    public static class C6297a {
        /* renamed from: a */
        public final String f20482a;
        /* renamed from: b */
        public final String f20483b;
        /* renamed from: c */
        public final String f20484c;

        public C6297a(String str, String str2, String str3) {
            this.f20482a = str;
            this.f20483b = str2;
            this.f20484c = str3;
        }
    }

    /* compiled from: Constants */
    /* renamed from: host.exp.exponent.d$b */
    public static class C6298b {
        /* renamed from: a */
        public String f20485a;
        /* renamed from: b */
        public String f20486b;
        /* renamed from: c */
        public String f20487c;
        /* renamed from: d */
        public String f20488d;
        /* renamed from: e */
        public boolean f20489e;
        /* renamed from: f */
        public boolean f20490f;
        /* renamed from: g */
        public List<C6297a> f20491g;
        /* renamed from: h */
        public int f20492h;
        /* renamed from: i */
        public boolean f20493i;
    }

    /* renamed from: a */
    public static void m26000a(List<String> list) {
        f20498d = TextUtils.join(",", list);
        f20499e = f20498d;
        f20500f = list;
    }

    static {
        Collection hashSet = new HashSet();
        hashSet.add("32.0.0");
        C6301d.m26000a(new ArrayList(hashSet));
        List arrayList = new ArrayList();
        arrayList.add(new C6297a("https://exp.host/@exponent/home/bundle", "assets://kernel.android.bundle", "application/javascript"));
        try {
            C6298b c6298b = (C6298b) Class.forName("host.exp.exponent.generated.AppConstants").getMethod("get", new Class[0]).invoke(null, new Object[0]);
            f20495a = c6298b.f20485a;
            f20496b = c6298b.f20486b;
            f20497c = c6298b.f20487c;
            f20503i = c6298b.f20488d;
            f20504j = c6298b.f20489e;
            f20505k = c6298b.f20490f;
            f20506l = c6298b.f20492h;
            f20507m = c6298b.f20493i;
            f20508n = C6301d.m26001a() ^ 1;
            arrayList.addAll(c6298b.f20491g);
            f20501g = arrayList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    /* renamed from: a */
    public static boolean m26001a() {
        return f20496b != null;
    }

    /* renamed from: a */
    public static String m25999a(Context context) {
        if (f20495a != null) {
            return f20495a;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Context context2) {
            C6289b.m25953c(f20509o, context2.toString());
            return "";
        }
    }

    /* renamed from: b */
    public static boolean m26002b() {
        return f20510p;
    }
}
