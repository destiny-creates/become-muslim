package expo.modules.permissions;

import android.content.Context;
import android.support.v4.content.C0366b;
import expo.p304a.C6007d;
import expo.p304a.p305a.C5998e;
import expo.p304a.p305a.C6001h;
import expo.p307b.p315h.C6033a;
import expo.p307b.p315h.C6033a.C6031a;
import expo.p307b.p315h.C6033a.C6032b;
import expo.p307b.p315h.C6034b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermissionsService implements C5998e, C6001h, C6033a {
    protected Context mContext;
    private PermissionsRequester mPermissionsRequester;

    public PermissionsService(Context context) {
        this.mContext = context;
    }

    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(C6033a.class);
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mPermissionsRequester = new PermissionsRequester(c6007d);
    }

    public int[] getPermissions(String[] strArr) {
        int[] iArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            iArr[i] = getPermission(strArr[i]);
        }
        return iArr;
    }

    public int getPermission(String str) {
        return C0366b.b(this.mContext, str);
    }

    public void askForPermissions(String[] strArr, final C6032b c6032b) {
        if (!this.mPermissionsRequester.askForPermissions(strArr, new C6034b() {
            public void onPermissionResult(String[] strArr, int[] iArr) {
                c6032b.onPermissionsResult(iArr);
            }
        })) {
            strArr = new int[strArr.length];
            Arrays.fill(strArr, -1);
            c6032b.onPermissionsResult(strArr);
        }
    }

    public void askForPermission(String str, final C6031a c6031a) {
        askForPermissions(new String[]{str}, new C6032b() {
            public void onPermissionsResult(int[] iArr) {
                c6031a.m25168a(iArr[0]);
            }
        });
    }
}
