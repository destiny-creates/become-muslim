package io.p347a.p348a.p349a.p350a.p352b;

import android.content.Context;
import android.text.TextUtils;
import io.p347a.p348a.p349a.C6514c;

/* compiled from: ApiKey */
/* renamed from: io.a.a.a.a.b.g */
public class C6424g {
    /* renamed from: a */
    protected String m26340a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }

    /* renamed from: a */
    public String m26341a(Context context) {
        Object b = m26342b(context);
        if (TextUtils.isEmpty(b)) {
            b = m26343c(context);
        }
        if (TextUtils.isEmpty(b)) {
            m26344d(context);
        }
        return b;
    }

    /* renamed from: b */
    protected String m26342b(Context context) {
        StringBuilder stringBuilder;
        String str = null;
        try {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (context == null) {
                return null;
            }
            String string = context.getString("io.fabric.ApiKey");
            if (string != null) {
                return string;
            }
            try {
                C6514c.m26634h().mo5472a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
                return context.getString("com.crashlytics.ApiKey");
            } catch (Exception e) {
                context = e;
                str = string;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Caught non-fatal exception while retrieving apiKey: ");
                stringBuilder.append(context);
                C6514c.m26634h().mo5472a("Fabric", stringBuilder.toString());
                return str;
            }
        } catch (Exception e2) {
            context = e2;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Caught non-fatal exception while retrieving apiKey: ");
            stringBuilder.append(context);
            C6514c.m26634h().mo5472a("Fabric", stringBuilder.toString());
            return str;
        }
    }

    /* renamed from: c */
    protected String m26343c(Context context) {
        int a = C6428i.m26349a(context, "io.fabric.ApiKey", "string");
        if (a == 0) {
            C6514c.m26634h().mo5472a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            a = C6428i.m26349a(context, "com.crashlytics.ApiKey", "string");
        }
        return a != 0 ? context.getResources().getString(a) : null;
    }

    /* renamed from: d */
    protected void m26344d(Context context) {
        if (C6514c.m26635i() || C6428i.m26385i(context) != null) {
            throw new IllegalArgumentException(m26340a());
        }
        C6514c.m26634h().mo5479e("Fabric", m26340a());
    }
}
