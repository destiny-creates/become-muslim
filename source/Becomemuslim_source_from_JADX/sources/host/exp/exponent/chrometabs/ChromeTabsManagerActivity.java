package host.exp.exponent.chrometabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import de.p287a.p288a.C5884c;

public class ChromeTabsManagerActivity extends Activity {
    /* renamed from: a */
    private boolean f20481a = false;

    /* renamed from: host.exp.exponent.chrometabs.ChromeTabsManagerActivity$a */
    public static class C6296a {
    }

    /* renamed from: a */
    public static Intent m25992a(Context context, Intent intent) {
        context = m25993b(context);
        context.putExtra("browserIntent", intent);
        return context;
    }

    /* renamed from: a */
    public static Intent m25991a(Context context) {
        context = m25993b(context);
        context.addFlags(67108864);
        return context;
    }

    /* renamed from: b */
    private static Intent m25993b(Context context) {
        return new Intent(context, ChromeTabsManagerActivity.class);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().hasExtra("browserIntent") != null) {
            Intent intent = (Intent) getIntent().getParcelableExtra("browserIntent");
            intent.addFlags(67108864);
            startActivity(intent);
            return;
        }
        finish();
    }

    protected void onResume() {
        super.onResume();
        if (this.f20481a) {
            C5884c.m24753a().m24769d(new C6296a());
            finish();
            return;
        }
        this.f20481a = true;
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }
}
