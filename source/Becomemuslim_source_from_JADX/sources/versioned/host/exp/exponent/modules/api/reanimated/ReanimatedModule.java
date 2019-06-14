package versioned.host.exp.exponent.modules.api.reanimated;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModuleListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@ReactModule(name = "ReanimatedModule")
public class ReanimatedModule extends ReactContextBaseJavaModule implements LifecycleEventListener, UIManagerModuleListener {
    protected static final String NAME = "ReanimatedModule";
    private NodesManager mNodesManager;
    private ArrayList<UIThreadOperation> mOperations = new ArrayList();

    private interface UIThreadOperation {
        void execute(NodesManager nodesManager);
    }

    public String getName() {
        return NAME;
    }

    public void onHostDestroy() {
    }

    public ReanimatedModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void initialize() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        UIManagerModule uIManagerModule = (UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class);
        reactApplicationContext.addLifecycleEventListener(this);
        uIManagerModule.addUIManagerListener(this);
    }

    public void onHostPause() {
        if (this.mNodesManager != null) {
            this.mNodesManager.onHostPause();
        }
    }

    public void onHostResume() {
        if (this.mNodesManager != null) {
            this.mNodesManager.onHostResume();
        }
    }

    public void willDispatchViewUpdates(UIManagerModule uIManagerModule) {
        if (!this.mOperations.isEmpty()) {
            final ArrayList arrayList = this.mOperations;
            this.mOperations = new ArrayList();
            uIManagerModule.addUIBlock(new UIBlock() {
                public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    nativeViewHierarchyManager = ReanimatedModule.this.getNodesManager();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((UIThreadOperation) it.next()).execute(nativeViewHierarchyManager);
                    }
                }
            });
        }
    }

    private NodesManager getNodesManager() {
        if (this.mNodesManager == null) {
            this.mNodesManager = new NodesManager(getReactApplicationContext());
        }
        return this.mNodesManager;
    }

    @ReactMethod
    public void createNode(final int i, final ReadableMap readableMap) {
        this.mOperations.add(new UIThreadOperation() {
            public void execute(NodesManager nodesManager) {
                nodesManager.createNode(i, readableMap);
            }
        });
    }

    @ReactMethod
    public void dropNode(final int i) {
        this.mOperations.add(new UIThreadOperation() {
            public void execute(NodesManager nodesManager) {
                nodesManager.dropNode(i);
            }
        });
    }

    @ReactMethod
    public void connectNodes(final int i, final int i2) {
        this.mOperations.add(new UIThreadOperation() {
            public void execute(NodesManager nodesManager) {
                nodesManager.connectNodes(i, i2);
            }
        });
    }

    @ReactMethod
    public void disconnectNodes(final int i, final int i2) {
        this.mOperations.add(new UIThreadOperation() {
            public void execute(NodesManager nodesManager) {
                nodesManager.disconnectNodes(i, i2);
            }
        });
    }

    @ReactMethod
    public void connectNodeToView(final int i, final int i2) {
        this.mOperations.add(new UIThreadOperation() {
            public void execute(NodesManager nodesManager) {
                nodesManager.connectNodeToView(i, i2);
            }
        });
    }

    @ReactMethod
    public void disconnectNodeFromView(final int i, final int i2) {
        this.mOperations.add(new UIThreadOperation() {
            public void execute(NodesManager nodesManager) {
                nodesManager.disconnectNodeFromView(i, i2);
            }
        });
    }

    @ReactMethod
    public void attachEvent(final int i, final String str, final int i2) {
        this.mOperations.add(new UIThreadOperation() {
            public void execute(NodesManager nodesManager) {
                nodesManager.attachEvent(i, str, i2);
            }
        });
    }

    @ReactMethod
    public void detachEvent(final int i, final String str, final int i2) {
        this.mOperations.add(new UIThreadOperation() {
            public void execute(NodesManager nodesManager) {
                nodesManager.detachEvent(i, str, i2);
            }
        });
    }

    @ReactMethod
    public void configureProps(ReadableArray readableArray, ReadableArray readableArray2) {
        int size = readableArray.size();
        final Set hashSet = new HashSet(size);
        for (int i = 0; i < size; i++) {
            hashSet.add(readableArray.getString(i));
        }
        readableArray = readableArray2.size();
        final Set hashSet2 = new HashSet(readableArray);
        for (int i2 = 0; i2 < readableArray; i2++) {
            hashSet2.add(readableArray2.getString(i2));
        }
        this.mOperations.add(new UIThreadOperation() {
            public void execute(NodesManager nodesManager) {
                nodesManager.configureProps(hashSet, hashSet2);
            }
        });
    }

    @ReactMethod
    public void getValue(final int i, final Callback callback) {
        this.mOperations.add(new UIThreadOperation() {
            public void execute(NodesManager nodesManager) {
                nodesManager.getValue(i, callback);
            }
        });
    }
}
