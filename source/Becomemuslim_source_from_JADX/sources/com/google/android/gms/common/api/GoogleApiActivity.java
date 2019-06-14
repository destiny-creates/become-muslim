package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.C4361e;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.C2798d;

@KeepName
public class GoogleApiActivity extends Activity implements OnCancelListener {
    /* renamed from: a */
    private int f7077a = 0;

    /* renamed from: a */
    public static PendingIntent m7899a(Context context, PendingIntent pendingIntent, int i) {
        return PendingIntent.getActivity(context, 0, m7900a(context, pendingIntent, i, true), 134217728);
    }

    /* renamed from: a */
    public static Intent m7900a(Context context, PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f7077a = bundle.getInt("resolution");
        }
        if (this.f7077a != 1) {
            bundle = getIntent().getExtras();
            if (bundle == null) {
                Log.e("GoogleApiActivity", "Activity started without extras");
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.get("pending_intent");
            Integer num = (Integer) bundle.get(NativeProtocol.BRIDGE_ARG_ERROR_CODE);
            if (pendingIntent == null && num == null) {
                Log.e("GoogleApiActivity", "Activity started without resolution");
                finish();
            } else if (pendingIntent != null) {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    this.f7077a = 1;
                } catch (Bundle bundle2) {
                    Log.e("GoogleApiActivity", "Failed to launch pendingIntent", bundle2);
                    finish();
                }
            } else {
                C4361e.m14332a().m14350b(this, num.intValue(), 2, this);
                this.f7077a = 1;
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            i = getIntent().getBooleanExtra("notify_manager", true);
            this.f7077a = 0;
            setResult(i2, intent);
            if (i != 0) {
                i = C2798d.m8041a((Context) this);
                switch (i2) {
                    case -1:
                        i.m8065d();
                        break;
                    case 0:
                        i.m8063b(new C4775b(13, null), getIntent().getIntExtra("failing_client_id", -1));
                        break;
                    default:
                        break;
                }
            }
        } else if (i == 2) {
            this.f7077a = 0;
            setResult(i2, intent);
        }
        finish();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.f7077a);
        super.onSaveInstanceState(bundle);
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f7077a = 0;
        setResult(0);
        finish();
    }
}
