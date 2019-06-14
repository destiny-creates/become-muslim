package host.exp.exponent.experience;

import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import host.exp.p333a.C6279c.C6274c;

public class ErrorActivity_ViewBinding implements Unbinder {
    /* renamed from: a */
    private ErrorActivity f26106a;

    public ErrorActivity_ViewBinding(ErrorActivity errorActivity) {
        this(errorActivity, errorActivity.getWindow().getDecorView());
    }

    public ErrorActivity_ViewBinding(ErrorActivity errorActivity, View view) {
        this.f26106a = errorActivity;
        errorActivity.mPager = (ViewPager) Utils.findRequiredViewAsType(view, C6274c.error_viewPager, "field 'mPager'", ViewPager.class);
    }

    public void unbind() {
        ErrorActivity errorActivity = this.f26106a;
        if (errorActivity != null) {
            this.f26106a = null;
            errorActivity.mPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
