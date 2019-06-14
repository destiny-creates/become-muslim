package com.facebook.react.devsupport;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.UriUtil;
import com.facebook.react.C1864R;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.devsupport.RedBoxHandler.ReportCompletedListener;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.StackFrame;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import expolib_v1.p321a.C6240u;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.aa;
import org.json.JSONObject;

class RedBoxDialog extends Dialog implements OnItemClickListener {
    private boolean isReporting = false;
    private Button mCopyToClipboardButton;
    private final DevSupportManager mDevSupportManager;
    private Button mDismissButton;
    private final DoubleTapReloadRecognizer mDoubleTapReloadRecognizer;
    private View mLineSeparator;
    private ProgressBar mLoadingIndicator;
    private final RedBoxHandler mRedBoxHandler;
    private Button mReloadJsButton;
    private Button mReportButton;
    private OnClickListener mReportButtonOnClickListener = new C19202();
    private ReportCompletedListener mReportCompletedListener = new C38421();
    private TextView mReportTextView;
    private ListView mStackView;

    /* renamed from: com.facebook.react.devsupport.RedBoxDialog$2 */
    class C19202 implements OnClickListener {
        C19202() {
        }

        public void onClick(View view) {
            if (RedBoxDialog.this.mRedBoxHandler != null && RedBoxDialog.this.mRedBoxHandler.isReportEnabled()) {
                if (!RedBoxDialog.this.isReporting) {
                    RedBoxDialog.this.isReporting = true;
                    ((TextView) Assertions.assertNotNull(RedBoxDialog.this.mReportTextView)).setText("Reporting...");
                    ((TextView) Assertions.assertNotNull(RedBoxDialog.this.mReportTextView)).setVisibility(0);
                    ((ProgressBar) Assertions.assertNotNull(RedBoxDialog.this.mLoadingIndicator)).setVisibility(0);
                    ((View) Assertions.assertNotNull(RedBoxDialog.this.mLineSeparator)).setVisibility(0);
                    ((Button) Assertions.assertNotNull(RedBoxDialog.this.mReportButton)).setEnabled(false);
                    RedBoxDialog.this.mRedBoxHandler.reportRedbox(view.getContext(), (String) Assertions.assertNotNull(RedBoxDialog.this.mDevSupportManager.getLastErrorTitle()), (StackFrame[]) Assertions.assertNotNull(RedBoxDialog.this.mDevSupportManager.getLastErrorStack()), RedBoxDialog.this.mDevSupportManager.getSourceUrl(), (ReportCompletedListener) Assertions.assertNotNull(RedBoxDialog.this.mReportCompletedListener));
                }
            }
        }
    }

    /* renamed from: com.facebook.react.devsupport.RedBoxDialog$3 */
    class C19213 implements OnClickListener {
        C19213() {
        }

        public void onClick(View view) {
            RedBoxDialog.this.mDevSupportManager.handleReloadJS();
        }
    }

    /* renamed from: com.facebook.react.devsupport.RedBoxDialog$4 */
    class C19224 implements OnClickListener {
        C19224() {
        }

        public void onClick(View view) {
            RedBoxDialog.this.dismiss();
        }
    }

    /* renamed from: com.facebook.react.devsupport.RedBoxDialog$5 */
    class C19235 implements OnClickListener {
        C19235() {
        }

        public void onClick(View view) {
            view = RedBoxDialog.this.mDevSupportManager.getLastErrorTitle();
            Object lastErrorStack = RedBoxDialog.this.mDevSupportManager.getLastErrorStack();
            Assertions.assertNotNull(view);
            Assertions.assertNotNull(lastErrorStack);
            new CopyToHostClipBoardTask(RedBoxDialog.this.mDevSupportManager).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{StackTraceHelper.formatStackTrace(view, lastErrorStack)});
        }
    }

    private static class CopyToHostClipBoardTask extends AsyncTask<String, Void, Void> {
        private final DevSupportManager mDevSupportManager;

        private CopyToHostClipBoardTask(DevSupportManager devSupportManager) {
            this.mDevSupportManager = devSupportManager;
        }

        protected Void doInBackground(String... strArr) {
            try {
                String uri = Uri.parse(this.mDevSupportManager.getSourceUrl()).buildUpon().path("/copy-to-clipboard").query(null).build().toString();
                for (String create : strArr) {
                    new C7490w().a(new C6245a().a(uri).a(aa.create(null, create)).b()).b();
                }
            } catch (Throwable e) {
                FLog.m5675e(ReactConstants.TAG, "Could not copy to the host clipboard", e);
            }
            return null;
        }
    }

    private static class OpenStackFrameTask extends AsyncTask<StackFrame, Void, Void> {
        private static final C6240u JSON = C6240u.a("application/json; charset=utf-8");
        private final DevSupportManager mDevSupportManager;

        private OpenStackFrameTask(DevSupportManager devSupportManager) {
            this.mDevSupportManager = devSupportManager;
        }

        protected Void doInBackground(StackFrame... stackFrameArr) {
            try {
                String uri = Uri.parse(this.mDevSupportManager.getSourceUrl()).buildUpon().path("/open-stack-frame").query(null).build().toString();
                C7490w c7490w = new C7490w();
                for (StackFrame stackFrameToJson : stackFrameArr) {
                    c7490w.a(new C6245a().a(uri).a(aa.create(JSON, stackFrameToJson(stackFrameToJson).toString())).b()).b();
                }
            } catch (Throwable e) {
                FLog.m5675e(ReactConstants.TAG, "Could not open stack frame", e);
            }
            return null;
        }

        private static JSONObject stackFrameToJson(StackFrame stackFrame) {
            return new JSONObject(MapBuilder.of(UriUtil.LOCAL_FILE_SCHEME, stackFrame.getFile(), "methodName", stackFrame.getMethod(), StackTraceHelper.LINE_NUMBER_KEY, Integer.valueOf(stackFrame.getLine()), StackTraceHelper.COLUMN_KEY, Integer.valueOf(stackFrame.getColumn())));
        }
    }

    private static class StackAdapter extends BaseAdapter {
        private static final int VIEW_TYPE_COUNT = 2;
        private static final int VIEW_TYPE_STACKFRAME = 1;
        private static final int VIEW_TYPE_TITLE = 0;
        private final StackFrame[] mStack;
        private final String mTitle;

        private static class FrameViewHolder {
            private final TextView mFileView;
            private final TextView mMethodView;

            private FrameViewHolder(View view) {
                this.mMethodView = (TextView) view.findViewById(C1864R.id.rn_frame_method);
                this.mFileView = (TextView) view.findViewById(C1864R.id.rn_frame_file);
            }
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return i == 0 ? 0 : 1;
        }

        public int getViewTypeCount() {
            return 2;
        }

        public boolean isEnabled(int i) {
            return i > 0;
        }

        public StackAdapter(String str, StackFrame[] stackFrameArr) {
            this.mTitle = str;
            this.mStack = stackFrameArr;
        }

        public int getCount() {
            return this.mStack.length + 1;
        }

        public Object getItem(int i) {
            return i == 0 ? this.mTitle : this.mStack[i - 1];
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (i == 0) {
                if (view != null) {
                    view = (TextView) view;
                } else {
                    view = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(C1864R.layout.redbox_item_title, viewGroup, false);
                }
                view.setText(this.mTitle);
                return view;
            }
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(C1864R.layout.redbox_item_frame, viewGroup, false);
                view.setTag(new FrameViewHolder(view));
            }
            i = this.mStack[i - 1];
            FrameViewHolder frameViewHolder = (FrameViewHolder) view.getTag();
            frameViewHolder.mMethodView.setText(i.getMethod());
            frameViewHolder.mFileView.setText(StackTraceHelper.formatFrameSource(i));
            return view;
        }
    }

    /* renamed from: com.facebook.react.devsupport.RedBoxDialog$1 */
    class C38421 implements ReportCompletedListener {
        C38421() {
        }

        public void onReportSuccess(SpannedString spannedString) {
            RedBoxDialog.this.isReporting = false;
            ((Button) Assertions.assertNotNull(RedBoxDialog.this.mReportButton)).setEnabled(true);
            ((ProgressBar) Assertions.assertNotNull(RedBoxDialog.this.mLoadingIndicator)).setVisibility(8);
            ((TextView) Assertions.assertNotNull(RedBoxDialog.this.mReportTextView)).setText(spannedString);
        }

        public void onReportError(SpannedString spannedString) {
            RedBoxDialog.this.isReporting = false;
            ((Button) Assertions.assertNotNull(RedBoxDialog.this.mReportButton)).setEnabled(true);
            ((ProgressBar) Assertions.assertNotNull(RedBoxDialog.this.mLoadingIndicator)).setVisibility(8);
            ((TextView) Assertions.assertNotNull(RedBoxDialog.this.mReportTextView)).setText(spannedString);
        }
    }

    protected RedBoxDialog(Context context, DevSupportManager devSupportManager, RedBoxHandler redBoxHandler) {
        super(context, C1864R.style.Theme_Catalyst_RedBox);
        requestWindowFeature(1);
        setContentView(C1864R.layout.redbox_view);
        this.mDevSupportManager = devSupportManager;
        this.mDoubleTapReloadRecognizer = new DoubleTapReloadRecognizer();
        this.mRedBoxHandler = redBoxHandler;
        this.mStackView = (ListView) findViewById(C1864R.id.rn_redbox_stack);
        this.mStackView.setOnItemClickListener(this);
        this.mReloadJsButton = (Button) findViewById(C1864R.id.rn_redbox_reload_button);
        this.mReloadJsButton.setOnClickListener(new C19213());
        this.mDismissButton = (Button) findViewById(C1864R.id.rn_redbox_dismiss_button);
        this.mDismissButton.setOnClickListener(new C19224());
        this.mCopyToClipboardButton = (Button) findViewById(C1864R.id.rn_redbox_copy_button);
        this.mCopyToClipboardButton.setOnClickListener(new C19235());
        if (this.mRedBoxHandler != null && this.mRedBoxHandler.isReportEnabled() != null) {
            this.mLoadingIndicator = (ProgressBar) findViewById(C1864R.id.rn_redbox_loading_indicator);
            this.mLineSeparator = findViewById(C1864R.id.rn_redbox_line_separator);
            this.mReportTextView = (TextView) findViewById(C1864R.id.rn_redbox_report_label);
            this.mReportTextView.setMovementMethod(LinkMovementMethod.getInstance());
            this.mReportTextView.setHighlightColor(0);
            this.mReportButton = (Button) findViewById(C1864R.id.rn_redbox_report_button);
            this.mReportButton.setOnClickListener(this.mReportButtonOnClickListener);
        }
    }

    public void setExceptionDetails(String str, StackFrame[] stackFrameArr) {
        this.mStackView.setAdapter(new StackAdapter(str, stackFrameArr));
    }

    public void resetReporting() {
        if (this.mRedBoxHandler != null) {
            if (this.mRedBoxHandler.isReportEnabled()) {
                this.isReporting = false;
                ((TextView) Assertions.assertNotNull(this.mReportTextView)).setVisibility(8);
                ((ProgressBar) Assertions.assertNotNull(this.mLoadingIndicator)).setVisibility(8);
                ((View) Assertions.assertNotNull(this.mLineSeparator)).setVisibility(8);
                ((Button) Assertions.assertNotNull(this.mReportButton)).setVisibility(0);
                ((Button) Assertions.assertNotNull(this.mReportButton)).setEnabled(true);
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        new OpenStackFrameTask(this.mDevSupportManager).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new StackFrame[]{(StackFrame) this.mStackView.getAdapter().getItem(i)});
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 82) {
            this.mDevSupportManager.showDevOptionsDialog();
            return true;
        }
        if (this.mDoubleTapReloadRecognizer.didDoubleTapR(i, getCurrentFocus())) {
            this.mDevSupportManager.handleReloadJS();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
