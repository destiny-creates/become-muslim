package versioned.host.exp.exponent.modules.universal;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.content.C0366b;
import expo.modules.permissions.PermissionsService;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p339f.p340a.C6328c;
import javax.inject.C6562a;

class PermissionsServiceBinding extends PermissionsService {
    private C6330b mExperienceId;
    @C6562a
    protected C6328c mKernelServiceRegistry;

    PermissionsServiceBinding(Context context, C6330b c6330b) {
        super(context);
        this.mExperienceId = c6330b;
        C6294a.m25957a().m25961b(PermissionsServiceBinding.class, this);
    }

    public int getPermission(String str) {
        if ((VERSION.SDK_INT >= 23 ? C0366b.b(this.mContext, str) : 0) != 0 || this.mKernelServiceRegistry.m26040i().m34179c(str, this.mExperienceId) == null) {
            return -1;
        }
        return 0;
    }
}
