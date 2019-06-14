package android.support.v7.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.p035a.C0591a.C0581a;
import android.support.v7.p035a.C0591a.C0582b;
import android.support.v7.p035a.C0591a.C0584d;
import android.support.v7.p035a.C0591a.C0590j;
import android.view.ViewConfiguration;
import com.facebook.stetho.server.http.HttpStatus;

/* compiled from: ActionBarPolicy */
/* renamed from: android.support.v7.view.a */
public class C0638a {
    /* renamed from: a */
    private Context f1622a;

    /* renamed from: a */
    public static C0638a m2121a(Context context) {
        return new C0638a(context);
    }

    private C0638a(Context context) {
        this.f1622a = context;
    }

    /* renamed from: a */
    public int m2122a() {
        Configuration configuration = this.f1622a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp <= 600 && i <= 600 && (i <= 960 || i2 <= 720)) {
            if (i <= 720 || i2 <= 960) {
                if (i < HttpStatus.HTTP_INTERNAL_SERVER_ERROR && (i <= 640 || i2 <= 480)) {
                    if (i <= 480 || i2 <= 640) {
                        return i >= 360 ? 3 : 2;
                    }
                }
                return 4;
            }
        }
        return 5;
    }

    /* renamed from: b */
    public boolean m2123b() {
        if (VERSION.SDK_INT >= 19) {
            return true;
        }
        return ViewConfiguration.get(this.f1622a).hasPermanentMenuKey() ^ true;
    }

    /* renamed from: c */
    public int m2124c() {
        return this.f1622a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    /* renamed from: d */
    public boolean m2125d() {
        return this.f1622a.getResources().getBoolean(C0582b.abc_action_bar_embed_tabs);
    }

    /* renamed from: e */
    public int m2126e() {
        TypedArray obtainStyledAttributes = this.f1622a.obtainStyledAttributes(null, C0590j.ActionBar, C0581a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0590j.ActionBar_height, 0);
        Resources resources = this.f1622a.getResources();
        if (!m2125d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0584d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    /* renamed from: f */
    public boolean m2127f() {
        return this.f1622a.getApplicationInfo().targetSdkVersion < 14;
    }

    /* renamed from: g */
    public int m2128g() {
        return this.f1622a.getResources().getDimensionPixelSize(C0584d.abc_action_bar_stacked_tab_max_width);
    }
}
