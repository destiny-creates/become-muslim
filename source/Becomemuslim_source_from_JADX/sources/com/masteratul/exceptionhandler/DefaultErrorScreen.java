package com.masteratul.exceptionhandler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.masteratul.exceptionhandler.C5433a.C5431a;
import com.masteratul.exceptionhandler.C5433a.C5432b;

public class DefaultErrorScreen extends Activity {
    /* renamed from: a */
    private static String f18226a = "RN_ERROR_HANDLER";
    /* renamed from: b */
    private Button f18227b;
    /* renamed from: c */
    private Button f18228c;
    /* renamed from: d */
    private Button f18229d;
    /* renamed from: e */
    private TextView f18230e;

    /* renamed from: com.masteratul.exceptionhandler.DefaultErrorScreen$1 */
    class C54271 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ DefaultErrorScreen f18223a;

        C54271(DefaultErrorScreen defaultErrorScreen) {
            this.f18223a = defaultErrorScreen;
        }

        public void onClick(View view) {
            if (this.f18223a.f18230e.getVisibility() == null) {
                this.f18223a.f18230e.setVisibility(8);
                this.f18223a.f18229d.setText("SHOW DETAILS");
                return;
            }
            this.f18223a.f18230e.setVisibility(0);
            this.f18223a.f18229d.setText("HIDE DETAILS");
        }
    }

    /* renamed from: com.masteratul.exceptionhandler.DefaultErrorScreen$2 */
    class C54282 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ DefaultErrorScreen f18224a;

        C54282(DefaultErrorScreen defaultErrorScreen) {
            this.f18224a = defaultErrorScreen;
        }

        public void onClick(View view) {
            DefaultErrorScreen.m23023a(this.f18224a.getApplicationContext());
        }
    }

    /* renamed from: com.masteratul.exceptionhandler.DefaultErrorScreen$3 */
    class C54293 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ DefaultErrorScreen f18225a;

        C54293(DefaultErrorScreen defaultErrorScreen) {
            this.f18225a = defaultErrorScreen;
        }

        public void onClick(View view) {
            System.exit(null);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getIntent().getExtras().getString("stack_trace_string");
        setContentView(C5432b.default_error_screen);
        this.f18227b = (Button) findViewById(C5431a.eh_quit_button);
        this.f18228c = (Button) findViewById(C5431a.eh_restart_button);
        this.f18229d = (Button) findViewById(C5431a.eh_show_details_button);
        this.f18230e = (TextView) findViewById(C5431a.eh_stack_trace_text_view);
        this.f18230e.setText(bundle);
        this.f18229d.setOnClickListener(new C54271(this));
        this.f18228c.setOnClickListener(new C54282(this));
        this.f18227b.setOnClickListener(new C54293(this));
    }

    /* renamed from: a */
    public static void m23023a(android.content.Context r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r6 == 0) goto L_0x0048;
    L_0x0002:
        r0 = r6.getPackageManager();	 Catch:{ Exception -> 0x0050 }
        if (r0 == 0) goto L_0x0040;	 Catch:{ Exception -> 0x0050 }
    L_0x0008:
        r1 = r6.getPackageName();	 Catch:{ Exception -> 0x0050 }
        r0 = r0.getLaunchIntentForPackage(r1);	 Catch:{ Exception -> 0x0050 }
        if (r0 == 0) goto L_0x0038;	 Catch:{ Exception -> 0x0050 }
    L_0x0012:
        r1 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.31561842E-316;	 Catch:{ Exception -> 0x0050 }
        r0.addFlags(r1);	 Catch:{ Exception -> 0x0050 }
        r1 = 654311; // 0x9fbe7 float:9.16885E-40 double:3.232726E-318;	 Catch:{ Exception -> 0x0050 }
        r2 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;	 Catch:{ Exception -> 0x0050 }
        r0 = android.app.PendingIntent.getActivity(r6, r1, r0, r2);	 Catch:{ Exception -> 0x0050 }
        r1 = "alarm";	 Catch:{ Exception -> 0x0050 }
        r6 = r6.getSystemService(r1);	 Catch:{ Exception -> 0x0050 }
        r6 = (android.app.AlarmManager) r6;	 Catch:{ Exception -> 0x0050 }
        r1 = 1;	 Catch:{ Exception -> 0x0050 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0050 }
        r4 = 100;	 Catch:{ Exception -> 0x0050 }
        r2 = r2 + r4;	 Catch:{ Exception -> 0x0050 }
        r6.set(r1, r2, r0);	 Catch:{ Exception -> 0x0050 }
        r6 = 0;	 Catch:{ Exception -> 0x0050 }
        java.lang.System.exit(r6);	 Catch:{ Exception -> 0x0050 }
        goto L_0x0057;	 Catch:{ Exception -> 0x0050 }
    L_0x0038:
        r6 = new java.lang.Exception;	 Catch:{ Exception -> 0x0050 }
        r0 = "Was not able to restart application, mStartActivity null";	 Catch:{ Exception -> 0x0050 }
        r6.<init>(r0);	 Catch:{ Exception -> 0x0050 }
        throw r6;	 Catch:{ Exception -> 0x0050 }
    L_0x0040:
        r6 = new java.lang.Exception;	 Catch:{ Exception -> 0x0050 }
        r0 = "Was not able to restart application, PM null";	 Catch:{ Exception -> 0x0050 }
        r6.<init>(r0);	 Catch:{ Exception -> 0x0050 }
        throw r6;	 Catch:{ Exception -> 0x0050 }
    L_0x0048:
        r6 = new java.lang.Exception;	 Catch:{ Exception -> 0x0050 }
        r0 = "Was not able to restart application, Context null";	 Catch:{ Exception -> 0x0050 }
        r6.<init>(r0);	 Catch:{ Exception -> 0x0050 }
        throw r6;	 Catch:{ Exception -> 0x0050 }
    L_0x0050:
        r6 = f18226a;
        r0 = "Was not able to restart application";
        android.util.Log.e(r6, r0);
    L_0x0057:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.masteratul.exceptionhandler.DefaultErrorScreen.a(android.content.Context):void");
    }
}
