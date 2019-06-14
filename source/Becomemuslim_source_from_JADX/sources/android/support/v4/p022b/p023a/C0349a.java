package android.support.v4.p022b.p023a;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.p030f.C0388b;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* compiled from: FingerprintManagerCompat */
/* renamed from: android.support.v4.b.a.a */
public final class C0349a {
    /* renamed from: a */
    private final Context f939a;

    /* compiled from: FingerprintManagerCompat */
    /* renamed from: android.support.v4.b.a.a$a */
    public static abstract class C0346a {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(C0347b c0347b) {
        }
    }

    /* compiled from: FingerprintManagerCompat */
    /* renamed from: android.support.v4.b.a.a$b */
    public static final class C0347b {
        /* renamed from: a */
        private final C0348c f935a;

        public C0347b(C0348c c0348c) {
            this.f935a = c0348c;
        }
    }

    /* compiled from: FingerprintManagerCompat */
    /* renamed from: android.support.v4.b.a.a$c */
    public static class C0348c {
        /* renamed from: a */
        private final Signature f936a;
        /* renamed from: b */
        private final Cipher f937b;
        /* renamed from: c */
        private final Mac f938c;

        public C0348c(Signature signature) {
            this.f936a = signature;
            this.f937b = null;
            this.f938c = null;
        }

        public C0348c(Cipher cipher) {
            this.f937b = cipher;
            this.f936a = null;
            this.f938c = null;
        }

        public C0348c(Mac mac) {
            this.f938c = mac;
            this.f937b = null;
            this.f936a = null;
        }

        /* renamed from: a */
        public Signature m1034a() {
            return this.f936a;
        }

        /* renamed from: b */
        public Cipher m1035b() {
            return this.f937b;
        }

        /* renamed from: c */
        public Mac m1036c() {
            return this.f938c;
        }
    }

    /* renamed from: a */
    public static C0349a m1040a(Context context) {
        return new C0349a(context);
    }

    private C0349a(Context context) {
        this.f939a = context;
    }

    /* renamed from: a */
    public boolean m1044a() {
        boolean z = false;
        if (VERSION.SDK_INT < 23) {
            return false;
        }
        FingerprintManager b = C0349a.m1041b(this.f939a);
        if (b != null && b.hasEnrolledFingerprints()) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public boolean m1045b() {
        boolean z = false;
        if (VERSION.SDK_INT < 23) {
            return false;
        }
        FingerprintManager b = C0349a.m1041b(this.f939a);
        if (b != null && b.isHardwareDetected()) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public void m1043a(C0348c c0348c, int i, C0388b c0388b, C0346a c0346a, Handler handler) {
        if (VERSION.SDK_INT >= 23) {
            FingerprintManager b = C0349a.m1041b(this.f939a);
            if (b != null) {
                b.authenticate(C0349a.m1038a(c0348c), c0388b != null ? (CancellationSignal) c0388b.m1168b() : null, i, C0349a.m1037a(c0346a), handler);
            }
        }
    }

    /* renamed from: b */
    private static FingerprintManager m1041b(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.fingerprint") ? (FingerprintManager) context.getSystemService(FingerprintManager.class) : null;
    }

    /* renamed from: a */
    private static CryptoObject m1038a(C0348c c0348c) {
        if (c0348c == null) {
            return null;
        }
        if (c0348c.m1035b() != null) {
            return new CryptoObject(c0348c.m1035b());
        }
        if (c0348c.m1034a() != null) {
            return new CryptoObject(c0348c.m1034a());
        }
        if (c0348c.m1036c() != null) {
            return new CryptoObject(c0348c.m1036c());
        }
        return null;
    }

    /* renamed from: b */
    private static C0348c m1042b(CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new C0348c(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new C0348c(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new C0348c(cryptoObject.getMac());
        }
        return null;
    }

    /* renamed from: a */
    private static AuthenticationCallback m1037a(final C0346a c0346a) {
        return new AuthenticationCallback() {
            public void onAuthenticationError(int i, CharSequence charSequence) {
                c0346a.onAuthenticationError(i, charSequence);
            }

            public void onAuthenticationHelp(int i, CharSequence charSequence) {
                c0346a.onAuthenticationHelp(i, charSequence);
            }

            public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
                c0346a.onAuthenticationSucceeded(new C0347b(C0349a.m1042b(authenticationResult.getCryptoObject())));
            }

            public void onAuthenticationFailed() {
                c0346a.onAuthenticationFailed();
            }
        };
    }
}
