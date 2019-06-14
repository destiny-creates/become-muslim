package host.exp.exponent;

import android.content.Context;
import host.exp.exponent.experience.ExperienceActivity;
import host.exp.exponent.p334a.C6289b;
import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: ExponentUncaughtExceptionHandler */
/* renamed from: host.exp.exponent.h */
public class C6374h implements UncaughtExceptionHandler {
    /* renamed from: a */
    private static final String f20645a = "h";
    /* renamed from: b */
    private UncaughtExceptionHandler f20646b = Thread.getDefaultUncaughtExceptionHandler();
    /* renamed from: c */
    private Context f20647c;

    public C6374h(Context context) {
        this.f20647c = context;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            ExperienceActivity.m44574a(this.f20647c);
        } catch (Throwable th2) {
            C6289b.m25950a(f20645a, th2);
        }
        if (this.f20646b != null) {
            this.f20646b.uncaughtException(thread, th);
        }
        System.exit(1);
    }
}
