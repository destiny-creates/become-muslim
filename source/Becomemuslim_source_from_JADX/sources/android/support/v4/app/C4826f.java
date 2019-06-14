package android.support.v4.app;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

/* compiled from: BaseFragmentActivityApi16 */
/* renamed from: android.support.v4.app.f */
abstract class C4826f extends C4456e {
    boolean mStartedActivityFromFragment;

    C4826f() {
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!(this.mStartedActivityFromFragment || i == -1)) {
            C4456e.checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!(this.mStartedIntentSenderFromFragment || i == -1)) {
            C4456e.checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
