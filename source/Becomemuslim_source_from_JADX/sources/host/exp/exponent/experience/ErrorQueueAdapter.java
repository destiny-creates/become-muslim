package host.exp.exponent.experience;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.common.util.UriUtil;
import com.facebook.react.devsupport.StackTraceHelper;
import host.exp.exponent.p339f.C6332e;
import host.exp.p333a.C6279c.C6274c;
import host.exp.p333a.C6279c.C6275d;
import host.exp.p333a.C6279c.C6277f;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class ErrorQueueAdapter extends ArrayAdapter<C6332e> {
    /* renamed from: a */
    private Context f20516a;

    static class ViewHolder {
        @BindView(2131493010)
        TextView errorMessageView;
        @BindView(2131493011)
        TextView stacktraceView;
        @BindView(2131493012)
        TextView timestampView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public class ViewHolder_ViewBinding implements Unbinder {
        /* renamed from: a */
        private ViewHolder f26124a;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f26124a = viewHolder;
            viewHolder.errorMessageView = (TextView) Utils.findRequiredViewAsType(view, C6274c.error_console_item_message, "field 'errorMessageView'", TextView.class);
            viewHolder.stacktraceView = (TextView) Utils.findRequiredViewAsType(view, C6274c.error_console_item_stack_preview, "field 'stacktraceView'", TextView.class);
            viewHolder.timestampView = (TextView) Utils.findRequiredViewAsType(view, C6274c.error_console_item_timestamp, "field 'timestampView'", TextView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.f26124a;
            if (viewHolder != null) {
                this.f26124a = null;
                viewHolder.errorMessageView = null;
                viewHolder.stacktraceView = null;
                viewHolder.timestampView = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public ErrorQueueAdapter(Context context, List<C6332e> list) {
        super(context, -1, list);
        this.f20516a = context;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f20516a).inflate(C6275d.error_console_list_item, viewGroup, false);
            viewGroup = new ViewHolder(view);
            view.setTag(viewGroup);
        } else {
            viewGroup = (ViewHolder) view.getTag();
        }
        C6332e c6332e = (C6332e) getItem(i);
        viewGroup.errorMessageView.setText(this.f20516a.getString(C6277f.error_uncaught, new Object[]{c6332e.f20571a.m26055b()}));
        if (c6332e.f20572b.length > 0) {
            StringBuilder stringBuilder;
            Bundle bundle = c6332e.f20572b[0];
            String str = "";
            String string = bundle.getString(UriUtil.LOCAL_FILE_SCHEME);
            if (string != null && string.length() > 0) {
                str = string.substring(string.lastIndexOf(47) + 1);
                stringBuilder = new StringBuilder();
                stringBuilder.append("@");
                stringBuilder.append(str);
                str = stringBuilder.toString();
            }
            string = "";
            Object obj = bundle.get(StackTraceHelper.LINE_NUMBER_KEY);
            if (obj instanceof Double) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(":");
                stringBuilder.append(((Double) obj).intValue());
                string = stringBuilder.toString();
            } else if (obj instanceof Integer) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(":");
                stringBuilder.append(((Integer) obj).intValue());
                string = stringBuilder.toString();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(bundle.getString("methodName"));
            stringBuilder2.append(str);
            stringBuilder2.append(string);
            viewGroup.stacktraceView.setText(stringBuilder2.toString());
        }
        CharSequence format = new SimpleDateFormat("HH:mm:ss", Locale.US).format(c6332e.f20575e);
        if (c6332e.f20574d != 0) {
            i = new StringBuilder();
            i.append(format);
            i.append(" Fatal Error");
            format = i.toString();
        }
        viewGroup.timestampView.setText(format);
        return view;
    }
}
