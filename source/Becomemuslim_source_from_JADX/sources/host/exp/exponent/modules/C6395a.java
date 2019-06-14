package host.exp.exponent.modules;

import android.content.Context;
import com.facebook.react.modules.storage.ReactDatabaseSupplier;
import com.facebook.stetho.common.Utf8Charset;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p346j.C6393j;
import java.net.URLEncoder;
import org.apache.p371a.p376c.C6644b;
import versioned.host.exp.exponent.modules.internal.ExponentAsyncStorageModule;

/* compiled from: ClearExperienceData */
/* renamed from: host.exp.exponent.modules.a */
public class C6395a {
    /* renamed from: a */
    private static final String f20698a = "a";

    /* renamed from: a */
    public static void m26251a(Context context, String str) {
        try {
            new ReactDatabaseSupplier(context, ExponentAsyncStorageModule.experienceIdToDatabaseName(str)).clearAndCloseDatabase();
        } catch (Throwable e) {
            C6289b.m25950a(f20698a, e);
        }
        try {
            C6393j c6393j = new C6393j(context, URLEncoder.encode(str, Utf8Charset.NAME));
            C6644b.m27036a(c6393j.getFilesDir());
            C6644b.m27036a(c6393j.getCacheDir());
        } catch (Throwable e2) {
            C6289b.m25950a(f20698a, e2);
        }
    }
}
