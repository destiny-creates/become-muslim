package host.exp.exponent.experience;

import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import host.exp.p333a.C6279c.C6274c;

public class ErrorConsoleFragment_ViewBinding implements Unbinder {
    /* renamed from: a */
    private ErrorConsoleFragment f26111a;
    /* renamed from: b */
    private View f26112b;
    /* renamed from: c */
    private View f26113c;

    public ErrorConsoleFragment_ViewBinding(final ErrorConsoleFragment errorConsoleFragment, View view) {
        this.f26111a = errorConsoleFragment;
        View findRequiredView = Utils.findRequiredView(view, C6274c.console_home_button, "field 'mHomeButton' and method 'onClickHome'");
        errorConsoleFragment.mHomeButton = findRequiredView;
        this.f26112b = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ ErrorConsoleFragment_ViewBinding f26108b;

            public void doClick(View view) {
                errorConsoleFragment.onClickHome();
            }
        });
        errorConsoleFragment.mListView = (ListView) Utils.findRequiredViewAsType(view, C6274c.list_view, "field 'mListView'", ListView.class);
        view = Utils.findRequiredView(view, C6274c.console_reload_button, "method 'onClickReload'");
        this.f26113c = view;
        view.setOnClickListener(new DebouncingOnClickListener(this) {
            /* renamed from: b */
            final /* synthetic */ ErrorConsoleFragment_ViewBinding f26110b;

            public void doClick(View view) {
                errorConsoleFragment.onClickReload();
            }
        });
    }

    public void unbind() {
        ErrorConsoleFragment errorConsoleFragment = this.f26111a;
        if (errorConsoleFragment != null) {
            this.f26111a = null;
            errorConsoleFragment.mHomeButton = null;
            errorConsoleFragment.mListView = null;
            this.f26112b.setOnClickListener(null);
            this.f26112b = null;
            this.f26113c.setOnClickListener(null);
            this.f26113c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
