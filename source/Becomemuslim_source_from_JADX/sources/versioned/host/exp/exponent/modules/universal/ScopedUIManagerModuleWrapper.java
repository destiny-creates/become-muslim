package versioned.host.exp.exponent.modules.universal;

import android.content.Intent;
import com.facebook.react.bridge.ReactContext;
import expo.adapters.react.services.C7380c;
import expo.p304a.p305a.C5994a;
import expo.p307b.p315h.C6034b;
import host.exp.exponent.C6292b;
import host.exp.exponent.p339f.C6330b;
import host.exp.p333a.C6271b;
import host.exp.p333a.C6271b.C6269d;

public class ScopedUIManagerModuleWrapper extends C7380c {
    private final C6330b mExperienceId;
    private final String mExperienceName;

    public ScopedUIManagerModuleWrapper(ReactContext reactContext, C6330b c6330b, String str) {
        super(reactContext);
        this.mExperienceId = c6330b;
        this.mExperienceName = str;
    }

    public boolean requestPermissions(final String[] strArr, int i, final C6034b c6034b) {
        return C6271b.m25897a().m25915a(new C6269d() {
            public void permissionsGranted() {
                c6034b.onPermissionResult(strArr, ScopedUIManagerModuleWrapper.arrayFilled(0, strArr.length));
            }

            public void permissionsDenied() {
                c6034b.onPermissionResult(strArr, ScopedUIManagerModuleWrapper.arrayFilled(-1, strArr.length));
            }
        }, strArr, this.mExperienceId, this.mExperienceName);
    }

    public void registerActivityEventListener(final C5994a c5994a) {
        C6271b.m25897a().m25912a(new C6292b() {
            public void onActivityResult(int i, int i2, Intent intent) {
                c5994a.onActivityResult(C6271b.m25897a().m25920b(), i, i2, intent);
            }
        });
    }

    private static int[] arrayFilled(int i, int i2) {
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = i;
        }
        return iArr;
    }
}
