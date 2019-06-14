package host.exp.exponent.experience;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import host.exp.p333a.C6279c.C6274c;

public class InfoActivity_ViewBinding implements Unbinder {
    /* renamed from: a */
    private InfoActivity f26136a;
    /* renamed from: b */
    private View f26137b;
    /* renamed from: c */
    private View f26138c;

    public InfoActivity_ViewBinding(InfoActivity infoActivity) {
        this(infoActivity, infoActivity.getWindow().getDecorView());
    }

    public InfoActivity_ViewBinding(final InfoActivity infoActivity, View view) {
        this.f26136a = infoActivity;
        infoActivity.mToolbar = (Toolbar) Utils.findRequiredViewAsType(view, C6274c.toolbar, "field 'mToolbar'", Toolbar.class);
        infoActivity.mImageView = (ImageView) Utils.findRequiredViewAsType(view, C6274c.app_icon_small, "field 'mImageView'", ImageView.class);
        infoActivity.mAppNameView = (TextView) Utils.findRequiredViewAsType(view, C6274c.app_name, "field 'mAppNameView'", TextView.class);
        infoActivity.mExperienceIdView = (TextView) Utils.findRequiredViewAsType(view, C6274c.experience_id, "field 'mExperienceIdView'", TextView.class);
        infoActivity.mSdkVersionView = (TextView) Utils.findRequiredViewAsType(view, C6274c.sdk_version, "field 'mSdkVersionView'", TextView.class);
        infoActivity.mPublishedTimeView = (TextView) Utils.findRequiredViewAsType(view, C6274c.published_time, "field 'mPublishedTimeView'", TextView.class);
        infoActivity.mIsVerifiedView = (TextView) Utils.findRequiredViewAsType(view, C6274c.is_verified, "field 'mIsVerifiedView'", TextView.class);
        infoActivity.mManifestTextView = (TextView) Utils.findRequiredViewAsType(view, C6274c.manifest, "field 'mManifestTextView'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C6274c.toggle_manifest, "field 'mToggleManifestButton' and method 'onClickToggleManifest'");
        infoActivity.mToggleManifestButton = (Button) Utils.castView(findRequiredView, C6274c.toggle_manifest, "field 'mToggleManifestButton'", Button.class);
        this.f26137b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ InfoActivity_ViewBinding f26133b;

            public void doClick(View view) {
                infoActivity.onClickToggleManifest();
            }
        });
        view = Utils.findRequiredView(view, C6274c.clear_data, "method 'onClickClearData'");
        this.f26138c = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ InfoActivity_ViewBinding f26135b;

            public void doClick(View view) {
                infoActivity.onClickClearData();
            }
        });
    }

    public void unbind() {
        InfoActivity infoActivity = this.f26136a;
        if (infoActivity != null) {
            this.f26136a = null;
            infoActivity.mToolbar = null;
            infoActivity.mImageView = null;
            infoActivity.mAppNameView = null;
            infoActivity.mExperienceIdView = null;
            infoActivity.mSdkVersionView = null;
            infoActivity.mPublishedTimeView = null;
            infoActivity.mIsVerifiedView = null;
            infoActivity.mManifestTextView = null;
            infoActivity.mToggleManifestButton = null;
            this.f26137b.setOnClickListener(null);
            this.f26137b = null;
            this.f26138c.setOnClickListener(null);
            this.f26138c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
