package expo.modules.print;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Margins;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentAdapter.WriteResultCallback;
import android.print.PrintDocumentInfo.Builder;
import android.print.PrintManager;
import android.util.Base64;
import android.webkit.URLUtil;
import expo.modules.print.PrintPDFRenderTask.Callbacks;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5995b;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import versioned.host.exp.exponent.modules.api.viewshot.ViewShot.Results;

public class PrintModule extends C6006c implements C6001h {
    private static String ORIENTATION_LANDSCAPE = "landscape";
    private static String ORIENTATION_PORTRAIT = "portrait";
    private Context mContext;
    private final String mJobName = "Printing";
    private C6007d mModuleRegistry = null;

    /* renamed from: expo.modules.print.PrintModule$1 */
    class C61241 extends HashMap<String, Object> {

        /* renamed from: expo.modules.print.PrintModule$1$1 */
        class C61231 extends HashMap<String, Object> {
            C61231() {
                put("portrait", PrintModule.ORIENTATION_PORTRAIT);
                put("landscape", PrintModule.ORIENTATION_LANDSCAPE);
            }
        }

        C61241() {
            put("Orientation", Collections.unmodifiableMap(new C61231()));
        }
    }

    public String getName() {
        return "ExponentPrint";
    }

    public PrintModule(Context context) {
        super(context);
        this.mContext = context;
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mModuleRegistry = c6007d;
    }

    public Map<String, Object> getConstants() {
        return Collections.unmodifiableMap(new C61241());
    }

    @C5996c
    public void print(final Map<String, Object> map, final C6009f c6009f) {
        String str = map.containsKey("html") ? (String) map.get("html") : null;
        final String str2 = map.containsKey("uri") ? (String) map.get("uri") : null;
        if (str != null) {
            try {
                new PrintPDFRenderTask(this.mContext, map, this.mModuleRegistry).render(null, new Callbacks() {
                    public void onRenderFinished(PrintDocumentAdapter printDocumentAdapter, File file, int i) {
                        PrintModule.this.printDocumentToPrinter(printDocumentAdapter, map);
                        c6009f.mo5137a((Object) null);
                    }

                    public void onRenderError(String str, String str2, Exception exception) {
                        c6009f.mo5138a(str, str2, exception);
                    }
                });
                return;
            } catch (Map<String, Object> map2) {
                c6009f.mo5138a("E_CANNOT_PRINT", "There was an error while trying to print HTML.", map2);
                return;
            }
        }
        try {
            printDocumentToPrinter(new PrintDocumentAdapter() {
                public void onWrite(PageRange[] pageRangeArr, final ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, final WriteResultCallback writeResultCallback) {
                    if (URLUtil.isValidUrl(str2) != null) {
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    InputStream openInputStream;
                                    if (URLUtil.isContentUrl(str2)) {
                                        openInputStream = PrintModule.this.mContext.getContentResolver().openInputStream(Uri.parse(str2));
                                    } else {
                                        openInputStream = new URL(str2).openStream();
                                    }
                                    PrintModule.this.loadAndClose(parcelFileDescriptor, writeResultCallback, openInputStream);
                                } catch (Throwable e) {
                                    e.printStackTrace();
                                    c6009f.mo5138a("E_CANNOT_LOAD", "An error occurred while trying to load a file at given URI.", e);
                                }
                            }
                        }).start();
                    } else if (str2.startsWith("data:") == null || str2.contains(";base64,") == null) {
                        c6009f.m25152a("E_INVALID_URI", "Given URI is not valid.");
                    } else {
                        try {
                            PrintModule.this.loadAndClose(parcelFileDescriptor, writeResultCallback, PrintModule.this.decodeDataURI(str2));
                        } catch (PageRange[] pageRangeArr2) {
                            c6009f.mo5138a("E_CANNOT_LOAD", "An error occurred while trying to load given data URI.", pageRangeArr2);
                        }
                    }
                }

                public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, LayoutResultCallback layoutResultCallback, Bundle bundle) {
                    if (cancellationSignal.isCanceled() != null) {
                        layoutResultCallback.onLayoutCancelled();
                    } else {
                        layoutResultCallback.onLayoutFinished(new Builder("Printing").setContentType(null).build(), true);
                    }
                }
            }, map2);
            c6009f.mo5137a(null);
        } catch (Map<String, Object> map22) {
            c6009f.mo5138a("E_CANNOT_PRINT", "There was an error while trying to print a file.", map22);
        }
    }

    @C5996c
    public void printToFileAsync(final Map<String, Object> map, final C6009f c6009f) {
        try {
            new PrintPDFRenderTask(this.mContext, map, this.mModuleRegistry).render(generateFilePath(), new Callbacks() {
                public void onRenderFinished(PrintDocumentAdapter printDocumentAdapter, File file, int i) {
                    Object bundle = new Bundle();
                    String uri = FileUtils.uriFromFile(file).toString();
                    if (map.containsKey(Results.BASE_64) && ((Boolean) map.get(Results.BASE_64)).booleanValue()) {
                        try {
                            bundle.putString(Results.BASE_64, PrintModule.this.encodeFromFile(file));
                        } catch (PrintDocumentAdapter printDocumentAdapter2) {
                            c6009f.mo5138a("E_PRINT_BASE64_FAILED", "An error occurred while encoding PDF file to base64 string.", printDocumentAdapter2);
                            return;
                        }
                    }
                    bundle.putString("uri", uri);
                    bundle.putInt("numberOfPages", i);
                    c6009f.mo5137a(bundle);
                }

                public void onRenderError(String str, String str2, Exception exception) {
                    c6009f.mo5138a(str, str2, exception);
                }
            });
        } catch (Map<String, Object> map2) {
            c6009f.mo5138a("E_PRINT_FAILED", "An unknown I/O exception occurred.", map2);
        }
    }

    private void printDocumentToPrinter(PrintDocumentAdapter printDocumentAdapter, Map<String, Object> map) {
        ((PrintManager) ((C5995b) this.mModuleRegistry.m25133a(C5995b.class)).getCurrentActivity().getSystemService("print")).print("Printing", printDocumentAdapter, getAttributesFromOptions(map).build());
    }

    private PrintAttributes.Builder getAttributesFromOptions(Map<String, Object> map) {
        map = map.containsKey("orientation") ? (String) map.get("orientation") : null;
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        if (ORIENTATION_LANDSCAPE.equals(map) != null) {
            builder.setMediaSize(MediaSize.UNKNOWN_LANDSCAPE);
        } else {
            builder.setMediaSize(MediaSize.UNKNOWN_PORTRAIT);
        }
        builder.setMinMargins(Margins.NO_MARGINS);
        return builder;
    }

    private String generateFilePath() {
        return FileUtils.generateOutputPath(this.mContext.getCacheDir(), "Print", ".pdf");
    }

    private String encodeFromFile(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        file = new byte[((int) randomAccessFile.length())];
        randomAccessFile.readFully(file);
        return Base64.encodeToString(file, 0);
    }

    private InputStream decodeDataURI(String str) {
        return new ByteArrayInputStream(Base64.decode(str.substring(str.indexOf(";base64,") + 8), 0));
    }

    private void loadAndClose(ParcelFileDescriptor parcelFileDescriptor, WriteResultCallback writeResultCallback, InputStream inputStream) {
        OutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
        parcelFileDescriptor = new byte[1024];
        while (true) {
            int read = inputStream.read(parcelFileDescriptor);
            if (read > 0) {
                fileOutputStream.write(parcelFileDescriptor, 0, read);
            } else {
                writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                try {
                    inputStream.close();
                    fileOutputStream.close();
                    return;
                } catch (ParcelFileDescriptor parcelFileDescriptor2) {
                    parcelFileDescriptor2.printStackTrace();
                    return;
                }
            }
        }
    }
}
