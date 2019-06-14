package expo.modules.localauthentication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.p022b.p023a.C0349a;
import android.support.v4.p022b.p023a.C0349a.C0346a;
import android.support.v4.p022b.p023a.C0349a.C0347b;
import android.support.v4.p030f.C0388b;
import com.facebook.GraphResponse;
import com.facebook.share.internal.ShareConstants;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5993b;
import java.util.ArrayList;

public class LocalAuthenticationModule extends C6006c implements C6001h {
    private static final int AUTHENTICATION_TYPE_FINGERPRINT = 1;
    private final C0346a mAuthenticationCallback = new C74161();
    private C0388b mCancellationSignal;
    private final C0349a mFingerprintManager;
    private boolean mIsAuthenticating = false;
    private C6009f mPromise;
    private C5993b mUIManager;

    /* renamed from: expo.modules.localauthentication.LocalAuthenticationModule$3 */
    class C61083 implements Runnable {
        C61083() {
        }

        public void run() {
            LocalAuthenticationModule.this.safeCancel();
        }
    }

    /* renamed from: expo.modules.localauthentication.LocalAuthenticationModule$1 */
    class C74161 extends C0346a {
        C74161() {
        }

        public void onAuthenticationSucceeded(C0347b c0347b) {
            LocalAuthenticationModule.this.mIsAuthenticating = false;
            c0347b = new Bundle();
            c0347b.putBoolean(GraphResponse.SUCCESS_KEY, true);
            LocalAuthenticationModule.this.safeResolve(c0347b);
        }

        public void onAuthenticationFailed() {
            LocalAuthenticationModule.this.mIsAuthenticating = false;
            Bundle bundle = new Bundle();
            bundle.putBoolean(GraphResponse.SUCCESS_KEY, false);
            bundle.putString("error", "authentication_failed");
            LocalAuthenticationModule.this.safeResolve(bundle);
            LocalAuthenticationModule.this.safeCancel();
        }

        public void onAuthenticationError(int i, CharSequence charSequence) {
            LocalAuthenticationModule.this.mIsAuthenticating = false;
            Bundle bundle = new Bundle();
            bundle.putBoolean(GraphResponse.SUCCESS_KEY, false);
            bundle.putString("error", LocalAuthenticationModule.convertErrorCode(i));
            bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, charSequence.toString());
            LocalAuthenticationModule.this.safeResolve(bundle);
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
            LocalAuthenticationModule.this.mIsAuthenticating = false;
            Bundle bundle = new Bundle();
            bundle.putBoolean(GraphResponse.SUCCESS_KEY, false);
            bundle.putString("error", LocalAuthenticationModule.convertHelpCode(i));
            bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, charSequence.toString());
            LocalAuthenticationModule.this.safeResolve(bundle);
            LocalAuthenticationModule.this.safeCancel();
        }
    }

    private static String convertErrorCode(int i) {
        if (i == 7) {
            return "lockout";
        }
        switch (i) {
            case 1:
                return "not_available";
            case 2:
                return "unable_to_process";
            case 3:
                return "timeout";
            case 4:
                return "no_space";
            case 5:
                return "user_cancel";
            default:
                return "unknown";
        }
    }

    private static String convertHelpCode(int i) {
        switch (i) {
            case 1:
                return "partial";
            case 2:
                return "insufficient";
            case 3:
                return "imager_dirty";
            case 4:
                return "too_slow";
            case 5:
                return "too_fast";
            default:
                return "unknown";
        }
    }

    public String getName() {
        return "ExpoLocalAuthentication";
    }

    public LocalAuthenticationModule(Context context) {
        super(context);
        this.mFingerprintManager = C0349a.a(context);
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mUIManager = (C5993b) c6007d.m25133a(C5993b.class);
    }

    @C5996c
    public void supportedAuthenticationTypesAsync(C6009f c6009f) {
        boolean b = this.mFingerprintManager.b();
        Object arrayList = new ArrayList();
        if (b) {
            arrayList.add(Integer.valueOf(1));
        }
        c6009f.mo5137a(arrayList);
    }

    @C5996c
    public void hasHardwareAsync(C6009f c6009f) {
        c6009f.mo5137a(Boolean.valueOf(this.mFingerprintManager.b()));
    }

    @C5996c
    public void isEnrolledAsync(C6009f c6009f) {
        c6009f.mo5137a(Boolean.valueOf(this.mFingerprintManager.a()));
    }

    @C5996c
    public void authenticateAsync(final C6009f c6009f) {
        this.mUIManager.runOnUiQueueThread(new Runnable() {
            public void run() {
                if (LocalAuthenticationModule.this.mIsAuthenticating) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(GraphResponse.SUCCESS_KEY, false);
                    bundle.putString("error", "app_cancel");
                    LocalAuthenticationModule.this.safeResolve(bundle);
                    LocalAuthenticationModule.this.mPromise = c6009f;
                    return;
                }
                LocalAuthenticationModule.this.mIsAuthenticating = true;
                LocalAuthenticationModule.this.mPromise = c6009f;
                LocalAuthenticationModule.this.mCancellationSignal = new C0388b();
                LocalAuthenticationModule.this.mFingerprintManager.a(null, 0, LocalAuthenticationModule.this.mCancellationSignal, LocalAuthenticationModule.this.mAuthenticationCallback, null);
            }
        });
    }

    @C5996c
    public void cancelAuthenticate(C6009f c6009f) {
        this.mUIManager.runOnUiQueueThread(new C61083());
    }

    private void safeCancel() {
        if (this.mCancellationSignal != null) {
            this.mCancellationSignal.a();
            this.mCancellationSignal = null;
        }
    }

    private void safeResolve(Object obj) {
        if (this.mPromise != null) {
            this.mPromise.mo5137a(obj);
            this.mPromise = null;
        }
    }
}
