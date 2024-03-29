package com.facebook.react.shell;

import com.facebook.react.LazyReactPackage;
import com.facebook.react.animated.NativeAnimatedModule;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.modules.blob.BlobModule;
import com.facebook.react.modules.blob.FileReaderModule;
import com.facebook.react.modules.camera.CameraRollManager;
import com.facebook.react.modules.camera.ImageEditingManager;
import com.facebook.react.modules.camera.ImageStoreManager;
import com.facebook.react.modules.clipboard.ClipboardModule;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.i18nmanager.I18nManagerModule;
import com.facebook.react.modules.image.ImageLoaderModule;
import com.facebook.react.modules.intent.IntentModule;
import com.facebook.react.modules.location.LocationModule;
import com.facebook.react.modules.netinfo.NetInfoModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.permissions.PermissionsModule;
import com.facebook.react.modules.share.ShareModule;
import com.facebook.react.modules.statusbar.StatusBarModule;
import com.facebook.react.modules.storage.AsyncStorageModule;
import com.facebook.react.modules.timepicker.TimePickerDialogModule;
import com.facebook.react.modules.toast.ToastModule;
import com.facebook.react.modules.vibration.VibrationModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.art.ARTRenderableViewManager;
import com.facebook.react.views.art.ARTSurfaceViewManager;
import com.facebook.react.views.checkbox.ReactCheckBoxManager;
import com.facebook.react.views.drawer.ReactDrawerLayoutManager;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.picker.ReactDialogPickerManager;
import com.facebook.react.views.picker.ReactDropdownPickerManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollContainerViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.slider.ReactSliderManager;
import com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager;
import com.facebook.react.views.switchview.ReactSwitchManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.text.ReactVirtualTextViewManager;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageViewManager;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.facebook.react.views.toolbar.ReactToolbarManager;
import com.facebook.react.views.view.ReactViewManager;
import com.facebook.react.views.viewpager.ReactViewPagerManager;
import com.facebook.react.views.webview.ReactWebViewManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Provider;

public class MainReactPackage extends LazyReactPackage {
    private MainPackageConfig mConfig;

    public MainReactPackage(MainPackageConfig mainPackageConfig) {
        this.mConfig = mainPackageConfig;
    }

    public List<ModuleSpec> getNativeModules(final ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ModuleSpec[]{ModuleSpec.nativeModuleSpec(AccessibilityInfoModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new AccessibilityInfoModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(AppStateModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new AppStateModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(BlobModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new BlobModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(FileReaderModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new FileReaderModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(AsyncStorageModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new AsyncStorageModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(CameraRollManager.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new CameraRollManager(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(ClipboardModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new ClipboardModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(DatePickerDialogModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new DatePickerDialogModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(DialogModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new DialogModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(FrescoModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new FrescoModule(reactApplicationContext, true, MainReactPackage.this.mConfig != null ? MainReactPackage.this.mConfig.getFrescoConfig() : null);
            }
        }), ModuleSpec.nativeModuleSpec(I18nManagerModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new I18nManagerModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(ImageEditingManager.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new ImageEditingManager(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(ImageLoaderModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new ImageLoaderModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(ImageStoreManager.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new ImageStoreManager(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(IntentModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new IntentModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(LocationModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new LocationModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(NativeAnimatedModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new NativeAnimatedModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(NetworkingModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new NetworkingModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(NetInfoModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new NetInfoModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(PermissionsModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new PermissionsModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(ShareModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new ShareModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(StatusBarModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new StatusBarModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(TimePickerDialogModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new TimePickerDialogModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(ToastModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new ToastModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(VibrationModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new VibrationModule(reactApplicationContext);
            }
        }), ModuleSpec.nativeModuleSpec(WebSocketModule.class, new Provider<NativeModule>() {
            public NativeModule get() {
                return new WebSocketModule(reactApplicationContext);
            }
        })});
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        reactApplicationContext = new ArrayList();
        reactApplicationContext.add(ARTRenderableViewManager.createARTGroupViewManager());
        reactApplicationContext.add(ARTRenderableViewManager.createARTShapeViewManager());
        reactApplicationContext.add(ARTRenderableViewManager.createARTTextViewManager());
        reactApplicationContext.add(new ReactCheckBoxManager());
        reactApplicationContext.add(new ReactDialogPickerManager());
        reactApplicationContext.add(new ReactDrawerLayoutManager());
        reactApplicationContext.add(new ReactDropdownPickerManager());
        reactApplicationContext.add(new ReactHorizontalScrollViewManager());
        reactApplicationContext.add(new ReactHorizontalScrollContainerViewManager());
        reactApplicationContext.add(new ReactProgressBarViewManager());
        reactApplicationContext.add(new ReactScrollViewManager());
        reactApplicationContext.add(new ReactSliderManager());
        reactApplicationContext.add(new ReactSwitchManager());
        reactApplicationContext.add(new ReactToolbarManager());
        reactApplicationContext.add(new ReactWebViewManager());
        reactApplicationContext.add(new SwipeRefreshLayoutManager());
        reactApplicationContext.add(new ARTSurfaceViewManager());
        reactApplicationContext.add(new FrescoBasedReactTextInlineImageViewManager());
        reactApplicationContext.add(new ReactImageManager());
        reactApplicationContext.add(new ReactModalHostManager());
        reactApplicationContext.add(new ReactRawTextManager());
        reactApplicationContext.add(new ReactTextInputManager());
        reactApplicationContext.add(new ReactTextViewManager());
        reactApplicationContext.add(new ReactViewManager());
        reactApplicationContext.add(new ReactViewPagerManager());
        reactApplicationContext.add(new ReactVirtualTextViewManager());
        return reactApplicationContext;
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return LazyReactPackage.getReactModuleInfoProviderViaReflection(this);
    }
}
