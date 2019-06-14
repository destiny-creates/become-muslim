package host.exp.exponent.experience;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import host.exp.p333a.C6279c.C6274c;
import host.exp.p333a.C6279c.C6277f;

public class ErrorFragment_ViewBinding implements Unbinder {
    /* renamed from: a */
    private ErrorFragment f26120a;
    /* renamed from: b */
    private View f26121b;
    /* renamed from: c */
    private View f26122c;
    /* renamed from: d */
    private View f26123d;

    public ErrorFragment_ViewBinding(final ErrorFragment errorFragment, View view) {
        this.f26120a = errorFragment;
        errorFragment.mErrorMessageView = (TextView) Utils.findRequiredViewAsType(view, C6274c.error_message, "field 'mErrorMessageView'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C6274c.home_button, "field 'mHomeButton' and method 'onClickHome'");
        errorFragment.mHomeButton = findRequiredView;
        this.f26121b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ ErrorFragment_ViewBinding f26115b;

            public void doClick(View view) {
                errorFragment.onClickHome();
            }
        });
        findRequiredView = Utils.findRequiredView(view, C6274c.reload_button, "method 'onClickReload'");
        this.f26122c = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ ErrorFragment_ViewBinding f26117b;

            public void doClick(View view) {
                errorFragment.onClickReload();
            }
        });
        findRequiredView = Utils.findRequiredView(view, C6274c.view_error_log, "method 'onClickViewErrorLog'");
        this.f26123d = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ ErrorFragment_ViewBinding f26119b;

            public void doClick(View view) {
                errorFragment.onClickViewErrorLog();
            }
        });
        view = view.getContext().getResources();
        errorFragment.mDefaultError = view.getString(C6277f.error_default_client);
        errorFragment.mDefaultErrorShell = view.getString(C6277f.error_default_shell);
    }

    public void unbind() {
        ErrorFragment errorFragment = this.f26120a;
        if (errorFragment != null) {
            this.f26120a = null;
            errorFragment.mErrorMessageView = null;
            errorFragment.mHomeButton = null;
            this.f26121b.setOnClickListener(null);
            this.f26121b = null;
            this.f26122c.setOnClickListener(null);
            this.f26122c = null;
            this.f26123d.setOnClickListener(null);
            this.f26123d = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
