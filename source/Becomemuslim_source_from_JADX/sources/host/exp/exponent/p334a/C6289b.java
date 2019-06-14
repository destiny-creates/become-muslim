package host.exp.exponent.p334a;

import android.util.Log;
import host.exp.exponent.C6301d;
import host.exp.p333a.C6271b;
import org.json.JSONObject;

/* compiled from: EXL */
/* renamed from: host.exp.exponent.a.b */
public class C6289b {
    /* renamed from: a */
    private static final String f20456a = "b";

    /* renamed from: a */
    public static void m25951a(Throwable th) {
        if (!C6301d.m26002b()) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m25949a(String str, String str2) {
        Log.d(str, str2);
    }

    /* renamed from: b */
    public static void m25952b(String str, String str2) {
        Log.w(str, str2);
    }

    /* renamed from: a */
    public static void m25950a(String str, Throwable th) {
        Log.e(str, th.toString());
        C6271b.m25902a(th);
    }

    /* renamed from: c */
    public static void m25953c(String str, String str2) {
        Log.e(str, str2);
        try {
            String stackTraceString = Log.getStackTraceString(new Throwable());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("TAG", str);
            jSONObject.put("MESSAGE", str2);
            jSONObject.put("STACK_TRACE", stackTraceString);
            C6288a.m25945a("LOG_ERROR", jSONObject);
        } catch (String str3) {
            Log.e(f20456a, str3.toString());
        }
    }
}
