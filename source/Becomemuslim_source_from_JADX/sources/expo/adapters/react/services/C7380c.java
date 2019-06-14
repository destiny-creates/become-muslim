package expo.adapters.react.services;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import expo.p304a.p305a.C5994a;
import expo.p304a.p305a.C5995b;
import expo.p304a.p305a.C5998e;
import expo.p304a.p305a.C5999f;
import expo.p304a.p305a.C6000g;
import expo.p304a.p305a.p306a.C5993b;
import expo.p304a.p305a.p306a.C5993b.C5992a;
import expo.p307b.p314g.C6030a;
import expo.p307b.p314g.C6030a.C6029a;
import expo.p307b.p315h.C6034b;
import expo.p307b.p315h.C6035c;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: UIManagerModuleWrapper */
/* renamed from: expo.adapters.react.services.c */
public class C7380c implements C5993b, C5995b, C5998e, C5999f, C6030a, C6035c {
    private Map<C6000g, LifecycleEventListener> mLifecycleListenersMap = new WeakHashMap();
    private ReactContext mReactContext;

    public C7380c(ReactContext reactContext) {
        this.mReactContext = reactContext;
    }

    protected ReactContext getContext() {
        return this.mReactContext;
    }

    public List<Class> getExportedInterfaces() {
        return Arrays.asList(new Class[]{C5995b.class, C6030a.class, C5999f.class, C6035c.class, C5993b.class});
    }

    public <T> void addUIBlock(final int i, final C5992a<T> c5992a, final Class<T> cls) {
        ((UIManagerModule) getContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock(this) {
            /* renamed from: d */
            final /* synthetic */ C7380c f25781d;

            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                nativeViewHierarchyManager = nativeViewHierarchyManager.resolveView(i);
                if (nativeViewHierarchyManager == null) {
                    c5992a.reject(new IllegalArgumentException("Expected view for this tag not to be null."));
                    return;
                }
                try {
                    if (cls.isInstance(nativeViewHierarchyManager)) {
                        c5992a.resolve(cls.cast(nativeViewHierarchyManager));
                        return;
                    }
                    C5992a c5992a = c5992a;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Expected view to be of ");
                    stringBuilder.append(cls);
                    stringBuilder.append("; found ");
                    stringBuilder.append(nativeViewHierarchyManager.getClass());
                    stringBuilder.append(" instead");
                    c5992a.reject(new IllegalStateException(stringBuilder.toString()));
                } catch (NativeViewHierarchyManager nativeViewHierarchyManager2) {
                    c5992a.reject(nativeViewHierarchyManager2);
                }
            }
        });
    }

    public void runOnUiQueueThread(Runnable runnable) {
        if (getContext().isOnUiQueueThread()) {
            runnable.run();
        } else {
            getContext().runOnUiQueueThread(runnable);
        }
    }

    public void runOnClientCodeQueueThread(Runnable runnable) {
        if (getContext().isOnJSQueueThread()) {
            runnable.run();
        } else {
            getContext().runOnJSQueueThread(runnable);
        }
    }

    public void registerLifecycleEventListener(C6000g c6000g) {
        final WeakReference weakReference = new WeakReference(c6000g);
        this.mLifecycleListenersMap.put(c6000g, new LifecycleEventListener(this) {
            /* renamed from: b */
            final /* synthetic */ C7380c f25783b;

            public void onHostResume() {
                C6000g c6000g = (C6000g) weakReference.get();
                if (c6000g != null) {
                    c6000g.onHostResume();
                }
            }

            public void onHostPause() {
                C6000g c6000g = (C6000g) weakReference.get();
                if (c6000g != null) {
                    c6000g.onHostPause();
                }
            }

            public void onHostDestroy() {
                C6000g c6000g = (C6000g) weakReference.get();
                if (c6000g != null) {
                    c6000g.onHostDestroy();
                }
            }
        });
        this.mReactContext.addLifecycleEventListener((LifecycleEventListener) this.mLifecycleListenersMap.get(c6000g));
    }

    public void unregisterLifecycleEventListener(C6000g c6000g) {
        getContext().removeLifecycleEventListener((LifecycleEventListener) this.mLifecycleListenersMap.get(c6000g));
        this.mLifecycleListenersMap.remove(c6000g);
    }

    public void registerActivityEventListener(final C5994a c5994a) {
        this.mReactContext.addActivityEventListener(new ActivityEventListener(this) {
            /* renamed from: b */
            final /* synthetic */ C7380c f25785b;

            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                c5994a.onActivityResult(activity, i, i2, intent);
            }

            public void onNewIntent(Intent intent) {
                c5994a.onNewIntent(intent);
            }
        });
    }

    public boolean requestPermissions(String[] strArr, final int i, final C6034b c6034b) {
        Activity currentActivity = getContext().getCurrentActivity();
        if (!(currentActivity instanceof PermissionAwareActivity)) {
            return null;
        }
        ((PermissionAwareActivity) currentActivity).requestPermissions(strArr, i, new PermissionListener(this) {
            /* renamed from: c */
            final /* synthetic */ C7380c f25788c;

            public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                if (i != i) {
                    return false;
                }
                c6034b.onPermissionResult(strArr, iArr);
                return true;
            }
        });
        return 1;
    }

    public long getJavaScriptContextRef() {
        return this.mReactContext.getJavaScriptContextHolder().get();
    }

    public void loadImageFromURL(String str, final C6029a c6029a) {
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequest.fromUri(str), this.mReactContext).subscribe(new BaseBitmapDataSubscriber(this) {
            /* renamed from: b */
            final /* synthetic */ C7380c f32452b;

            public void onNewResultImpl(Bitmap bitmap) {
                if (bitmap == null) {
                    c6029a.onFailure(new Exception("Loaded bitmap is null"));
                } else {
                    c6029a.onSuccess(bitmap);
                }
            }

            public void onFailureImpl(DataSource dataSource) {
                c6029a.onFailure(dataSource.getFailureCause());
            }
        }, AsyncTask.THREAD_POOL_EXECUTOR);
    }

    public Activity getCurrentActivity() {
        return getContext().getCurrentActivity();
    }
}
