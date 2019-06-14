package host.exp.exponent.experience;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.facebook.soloader.SoLoader;
import de.p287a.p288a.C5884c;
import expo.modules.barcodescanner.BarCodeScannerPackage;
import expo.modules.constants.ConstantsPackage;
import expo.modules.filesystem.FileSystemPackage;
import expo.modules.font.FontLoaderPackage;
import expo.modules.permissions.PermissionsPackage;
import expo.p304a.p305a.C6002i;
import host.exp.exponent.p334a.C6288a;
import host.exp.exponent.p339f.C7560j.C6347b;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class HomeActivity extends C8362a {
    /* renamed from: a */
    private void m44611a(boolean z) {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = null;
        this.i = "UNVERSIONED";
        C5884c.m24753a().m24767b(this);
        this.a.m34237a();
        m44471c((JSONObject) null);
        m44611a(true);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        m44611a((boolean) 0);
    }

    protected void onResume() {
        super.onResume();
        SoLoader.init(this, false);
        C6288a.m25942a("HOME_APPEARED");
        m44562i();
    }

    public void onEventMainThread(C6347b c6347b) {
        this.c.m26242b(this.a.m34254d());
        this.l.m26242b(this.a.m34256e());
        this.c.m26237a((Object) this, (Object) this);
        m44465a((View) this.l.m26244c());
        m44479y();
    }

    /* renamed from: a */
    protected void mo6909a(Intent intent) {
        intent.putExtra("isHome", true);
        this.a.m34262h();
    }

    /* renamed from: a */
    public static List<C6002i> m44610a() {
        return Arrays.asList(new C6002i[]{new ConstantsPackage(), new PermissionsPackage(), new FileSystemPackage(), new FontLoaderPackage(), new BarCodeScannerPackage()});
    }
}
