package expo.modules.print;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.print.C0089a;
import android.print.C0090b;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Builder;
import android.print.PrintAttributes.Margins;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintAttributes.Resolution;
import android.print.PrintDocumentAdapter;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.stetho.common.Utf8Charset;
import expo.p304a.C6007d;
import expo.p304a.p305a.p306a.C5993b;
import java.io.File;
import java.util.Map;

public class PrintPDFRenderTask {
    private static final int DEFAULT_MEDIA_HEIGHT = 792;
    private static final int DEFAULT_MEDIA_WIDTH = 612;
    private static final double MILS_PER_INCH = 1000.0d;
    private static final int PIXELS_PER_INCH = 72;
    private static final double PIXELS_PER_MIL = 0.072d;
    private Callbacks mCallbacks;
    private Context mContext;
    private PrintDocumentAdapter mDocument;
    private ParcelFileDescriptor mFileDescriptor;
    private C6007d mModuleRegistry;
    private int mNumberOfPages;
    private Map<String, Object> mOptions;
    private File mOutputFile;
    private PrintAttributes mPrintAttributes;
    private C0090b mPrintDocumentWriteCallback = new C74333();
    private WebView mWebView;
    private WebViewClient mWebViewClient = new C61282();

    /* renamed from: expo.modules.print.PrintPDFRenderTask$1 */
    class C61271 implements Runnable {
        C61271() {
        }

        public void run() {
            String str = PrintPDFRenderTask.this.mOptions.containsKey("html") ? (String) PrintPDFRenderTask.this.mOptions.get("html") : "";
            PrintPDFRenderTask.this.mPrintAttributes = PrintPDFRenderTask.this.getPrintAttributes();
            PrintPDFRenderTask.this.mWebView = new WebView(PrintPDFRenderTask.this.mContext);
            PrintPDFRenderTask.this.mWebView.getSettings().setDefaultTextEncodingName(Utf8Charset.NAME);
            PrintPDFRenderTask.this.mWebView.setWebViewClient(PrintPDFRenderTask.this.mWebViewClient);
            PrintPDFRenderTask.this.mWebView.loadDataWithBaseURL(null, str, "text/html; charset=utf-8", Utf8Charset.NAME, null);
        }
    }

    /* renamed from: expo.modules.print.PrintPDFRenderTask$2 */
    class C61282 extends WebViewClient {

        /* renamed from: expo.modules.print.PrintPDFRenderTask$2$1 */
        class C74321 extends C0089a {
            C74321() {
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return false;
        }

        C61282() {
        }

        public void onPageFinished(WebView webView, String str) {
            PrintPDFRenderTask.this.mDocument = PrintPDFRenderTask.this.mWebView.createPrintDocumentAdapter("Document");
            PrintPDFRenderTask.this.mDocument.onLayout(null, PrintPDFRenderTask.this.mPrintAttributes, null, new C74321(), null);
            PrintPDFRenderTask.this.mNumberOfPages = ((int) (((double) PrintPDFRenderTask.this.mWebView.getContentHeight()) / (((double) PrintPDFRenderTask.this.mPrintAttributes.getMediaSize().getHeightMils()) * PrintPDFRenderTask.PIXELS_PER_MIL))) + 1;
            if (PrintPDFRenderTask.this.mFileDescriptor != null) {
                PrintPDFRenderTask.this.mDocument.onWrite(new PageRange[]{PageRange.ALL_PAGES}, PrintPDFRenderTask.this.mFileDescriptor, null, PrintPDFRenderTask.this.mPrintDocumentWriteCallback);
                return;
            }
            PrintPDFRenderTask.this.mCallbacks.onRenderFinished(PrintPDFRenderTask.this.mDocument, null, PrintPDFRenderTask.this.mNumberOfPages);
        }
    }

    public static abstract class Callbacks {
        public void onRenderError(String str, String str2, Exception exception) {
        }

        public void onRenderFinished(PrintDocumentAdapter printDocumentAdapter, File file, int i) {
        }
    }

    /* renamed from: expo.modules.print.PrintPDFRenderTask$3 */
    class C74333 extends C0090b {
        C74333() {
        }

        public void onWriteFinished(PageRange[] pageRangeArr) {
            PrintPDFRenderTask.this.mCallbacks.onRenderFinished(PrintPDFRenderTask.this.mDocument, PrintPDFRenderTask.this.mOutputFile, PrintPDFRenderTask.this.mNumberOfPages);
        }

        public void onWriteFailed(CharSequence charSequence) {
            PrintPDFRenderTask.this.mCallbacks.onRenderError("E_PRINT_FAILED", "An error occurred while writing PDF data.", null);
        }
    }

    public PrintPDFRenderTask(Context context, Map<String, Object> map, C6007d c6007d) {
        this.mContext = context;
        this.mOptions = map;
        this.mModuleRegistry = c6007d;
    }

    public void render(String str, Callbacks callbacks) {
        this.mCallbacks = callbacks;
        if (str != null) {
            try {
                this.mOutputFile = new File(str);
                this.mOutputFile.createNewFile();
                this.mFileDescriptor = ParcelFileDescriptor.open(this.mOutputFile, 603979776);
            } catch (String str2) {
                this.mCallbacks.onRenderError("E_FILE_NOT_FOUND", "Cannot create or open a file.", str2);
                return;
            }
        }
        ((C5993b) this.mModuleRegistry.m25133a(C5993b.class)).runOnUiQueueThread(new C61271());
    }

    private PrintAttributes getPrintAttributes() {
        Builder builder = new Builder();
        if (this.mOptions.containsKey("html")) {
            int i = DEFAULT_MEDIA_WIDTH;
            int i2 = DEFAULT_MEDIA_HEIGHT;
            if (this.mOptions.containsKey("width")) {
                i = ((Integer) this.mOptions.get("width")).intValue();
            }
            if (this.mOptions.containsKey("height")) {
                i2 = ((Integer) this.mOptions.get("height")).intValue();
            }
            MediaSize mediaSize = new MediaSize("id", "label", (int) Math.round(((double) i) / PIXELS_PER_MIL), (int) Math.round(((double) i2) / PIXELS_PER_MIL));
            if (this.mOptions.containsKey("orientation") && "landscape".equals(this.mOptions.get("orientation"))) {
                mediaSize = mediaSize.asLandscape();
            }
            builder.setMediaSize(mediaSize).setMinMargins(Margins.NO_MARGINS).setResolution(new Resolution("id", "label", 72, 72));
        }
        return builder.build();
    }
}
