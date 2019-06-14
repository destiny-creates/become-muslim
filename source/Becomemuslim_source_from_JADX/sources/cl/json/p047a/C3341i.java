package cl.json.p047a;

import android.content.Intent;
import android.net.Uri;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.share.internal.ShareConstants;

/* compiled from: SingleShareIntent */
/* renamed from: cl.json.a.i */
public abstract class C3341i extends C0839h {
    /* renamed from: f */
    protected String f8883f = null;
    /* renamed from: g */
    protected String f8884g = null;

    public C3341i(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* renamed from: a */
    public void mo716a(ReadableMap readableMap) {
        System.out.println(mo715a());
        if (!(mo715a() == null && mo717b() == null && mo718c() == null)) {
            if (m3022a(mo715a(), this.a)) {
                System.out.println("INSTALLED");
                m3029e().setPackage(mo715a());
                super.mo716a(readableMap);
            } else {
                System.out.println("NOT INSTALLED");
                String str = "";
                if (mo717b() != null) {
                    str = mo717b().replace("{url}", C0839h.m3017a(readableMap.getString("url"))).replace("{message}", C0839h.m3017a(readableMap.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)));
                } else if (mo718c() != null) {
                    str = mo718c();
                }
                m3020a(new Intent(new Intent("android.intent.action.VIEW", Uri.parse(str))));
            }
        }
        super.mo716a(readableMap);
    }

    /* renamed from: d */
    protected void mo719d() {
        m3029e().setFlags(268435456);
        this.a.startActivity(m3029e());
    }
}
