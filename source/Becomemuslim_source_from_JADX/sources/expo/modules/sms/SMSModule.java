package expo.modules.sms;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5995b;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6000g;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5993b;
import java.util.ArrayList;

public class SMSModule extends C6006c implements C6000g, C6001h {
    private static final String ERROR_TAG = "E_SMS";
    private static final String TAG = "ExpoSMS";
    private C6007d mModuleRegistry;
    private C6009f mPromise;
    private boolean mSMSComposerOpened = null;

    public String getName() {
        return TAG;
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    SMSModule(Context context) {
        super(context);
    }

    public void setModuleRegistry(C6007d c6007d) {
        if (!(this.mModuleRegistry == null || this.mModuleRegistry.m25133a(C5993b.class) == null)) {
            ((C5993b) this.mModuleRegistry.m25133a(C5993b.class)).unregisterLifecycleEventListener(this);
        }
        this.mModuleRegistry = c6007d;
        if (this.mModuleRegistry != null && this.mModuleRegistry.m25133a(C5993b.class) != null) {
            ((C5993b) this.mModuleRegistry.m25133a(C5993b.class)).registerLifecycleEventListener(this);
        }
    }

    @C5996c
    public void sendSMSAsync(ArrayList<String> arrayList, String str, C6009f c6009f) {
        if (!getContext().getPackageManager().hasSystemFeature("android.hardware.telephony") && !getContext().getPackageManager().hasSystemFeature("android.hardware.telephony.cdma")) {
            c6009f.m25152a("E_SMS_UNAVAILABLE", "SMS service not available");
        } else if (this.mPromise != null) {
            c6009f.m25152a("E_SMS_SENDING_IN_PROGRESS", "Different SMS sending in progress. Await the old request and then try again.");
        } else {
            StringBuilder stringBuilder = new StringBuilder((String) arrayList.get(0));
            for (int i = 1; i < arrayList.size(); i++) {
                stringBuilder.append(';');
                stringBuilder.append((String) arrayList.get(i));
            }
            arrayList = new Intent("android.intent.action.SENDTO");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("smsto:");
            stringBuilder3.append(stringBuilder2);
            arrayList.setData(Uri.parse(stringBuilder3.toString()));
            arrayList.putExtra("exit_on_sent", true);
            arrayList.putExtra("compose_mode", true);
            arrayList.putExtra("android.intent.extra.TEXT", str);
            arrayList.putExtra("sms_body", str);
            if (arrayList.resolveActivity(getContext().getPackageManager()) == null) {
                c6009f.m25152a("E_SMS_NO_SMS_APP", "No messaging application available");
                return;
            }
            this.mPromise = c6009f;
            ((C5995b) this.mModuleRegistry.m25133a(C5995b.class)).getCurrentActivity().startActivity(arrayList);
            this.mSMSComposerOpened = true;
        }
    }

    @C5996c
    public void isAvailableAsync(C6009f c6009f) {
        if (getContext().getPackageManager().hasSystemFeature("android.hardware.telephony")) {
            c6009f.mo5137a(Boolean.valueOf(true));
        } else {
            c6009f.mo5137a(Boolean.valueOf(false));
        }
    }

    public void onHostResume() {
        if (this.mSMSComposerOpened && this.mPromise != null) {
            Object bundle = new Bundle();
            bundle.putString("result", "unknown");
            this.mPromise.mo5137a(bundle);
            this.mPromise = null;
        }
        this.mSMSComposerOpened = false;
    }
}
