package versioned.host.exp.exponent.modules.api.reanimated;

import android.util.SparseArray;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.facebook.react.uimanager.GuardedFrameCallback;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModule.CustomEventNamesResolver;
import com.facebook.react.uimanager.UIManagerReanimatedHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.AlwaysNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.BezierNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.BlockNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.ClockNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.ClockOpNode.ClockStartNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.ClockOpNode.ClockStopNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.ClockOpNode.ClockTestNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.ConcatNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.CondNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.DebugNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.EventNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.JSCallNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.Node;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.NoopNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.OperatorNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.PropsNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.SetNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.StyleNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.TransformNode;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.ValueNode;

public class NodesManager implements EventDispatcherListener {
    private static final Double ZERO = Double.valueOf(0.0d);
    public double currentFrameTimeMs;
    private final SparseArray<Node> mAnimatedNodes = new SparseArray();
    private final AtomicBoolean mCallbackPosted = new AtomicBoolean();
    private final GuardedFrameCallback mChoreographerCallback;
    private final ReactContext mContext;
    private final CustomEventNamesResolver mCustomEventNamesResolver;
    private final RCTDeviceEventEmitter mEventEmitter;
    private final Map<String, EventNode> mEventMapping = new HashMap();
    private ConcurrentLinkedQueue<Event> mEventQueue = new ConcurrentLinkedQueue();
    private List<OnAnimationFrame> mFrameCallbacks = new ArrayList();
    private final NoopNode mNoopNode;
    private Queue<NativeUpdateOperation> mOperationsInBatch = new LinkedList();
    private final ReactChoreographer mReactChoreographer;
    private final UIImplementation mUIImplementation;
    private final UIManagerModule mUIManager;
    private boolean mWantRunUpdates;
    public Set<String> nativeProps = Collections.emptySet();
    public Set<String> uiProps = Collections.emptySet();
    public final UpdateContext updateContext;

    private final class NativeUpdateOperation {
        public WritableMap mNativeProps;
        public int mViewTag;

        public NativeUpdateOperation(int i, WritableMap writableMap) {
            this.mViewTag = i;
            this.mNativeProps = writableMap;
        }
    }

    public interface OnAnimationFrame {
        void onAnimationFrame();
    }

    public NodesManager(ReactContext reactContext) {
        this.mContext = reactContext;
        this.mUIManager = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
        this.updateContext = new UpdateContext();
        this.mUIImplementation = this.mUIManager.getUIImplementation();
        this.mCustomEventNamesResolver = this.mUIManager.getDirectEventNamesResolver();
        this.mUIManager.getEventDispatcher().addListener(this);
        this.mEventEmitter = (RCTDeviceEventEmitter) reactContext.getJSModule(RCTDeviceEventEmitter.class);
        this.mReactChoreographer = ReactChoreographer.getInstance();
        this.mChoreographerCallback = new GuardedFrameCallback(reactContext) {
            protected void doFrameGuarded(long j) {
                NodesManager.this.onAnimationFrame(j);
            }
        };
        this.mNoopNode = new NoopNode(this);
    }

    public void onHostPause() {
        if (this.mCallbackPosted.get()) {
            stopUpdatingOnAnimationFrame();
            this.mCallbackPosted.set(true);
        }
    }

    public void onHostResume() {
        if (this.mCallbackPosted.getAndSet(false)) {
            startUpdatingOnAnimationFrame();
        }
    }

    private void startUpdatingOnAnimationFrame() {
        if (!this.mCallbackPosted.getAndSet(true)) {
            this.mReactChoreographer.postFrameCallback(CallbackType.NATIVE_ANIMATED_MODULE, this.mChoreographerCallback);
        }
    }

    private void stopUpdatingOnAnimationFrame() {
        if (this.mCallbackPosted.getAndSet(false)) {
            this.mReactChoreographer.removeFrameCallback(CallbackType.NATIVE_ANIMATED_MODULE, this.mChoreographerCallback);
        }
    }

    private void onAnimationFrame(long j) {
        this.currentFrameTimeMs = ((double) j) / 4696837146684686336L;
        while (this.mEventQueue.isEmpty() == null) {
            handleEvent((Event) this.mEventQueue.poll());
        }
        if (this.mFrameCallbacks.isEmpty() == null) {
            j = this.mFrameCallbacks;
            this.mFrameCallbacks = new ArrayList(j.size());
            int size = j.size();
            for (int i = 0; i < size; i++) {
                ((OnAnimationFrame) j.get(i)).onAnimationFrame();
            }
        }
        if (this.mWantRunUpdates != null) {
            Node.runUpdates(this.updateContext);
        }
        if (this.mOperationsInBatch.isEmpty() == null) {
            j = this.mOperationsInBatch;
            this.mOperationsInBatch = new LinkedList();
            this.mContext.runOnNativeModulesQueueThread(new GuardedRunnable(this.mContext) {
                public void runGuarded() {
                    boolean isOperationQueueEmpty = UIManagerReanimatedHelper.isOperationQueueEmpty(NodesManager.this.mUIImplementation);
                    while (!j.isEmpty()) {
                        NativeUpdateOperation nativeUpdateOperation = (NativeUpdateOperation) j.remove();
                        ReactShadowNode resolveShadowNode = NodesManager.this.mUIImplementation.resolveShadowNode(nativeUpdateOperation.mViewTag);
                        if (resolveShadowNode != null) {
                            NodesManager.this.mUIManager.updateView(nativeUpdateOperation.mViewTag, resolveShadowNode.getViewClass(), nativeUpdateOperation.mNativeProps);
                        }
                    }
                    if (isOperationQueueEmpty) {
                        NodesManager.this.mUIImplementation.dispatchViewUpdates(-1);
                    }
                }
            });
        }
        this.mCallbackPosted.set(false);
        this.mWantRunUpdates = false;
        if (this.mFrameCallbacks.isEmpty() == null || this.mEventQueue.isEmpty() == null) {
            startUpdatingOnAnimationFrame();
        }
    }

    public Object getNodeValue(int i) {
        Node node = (Node) this.mAnimatedNodes.get(i);
        if (node != null) {
            return node.value();
        }
        return ZERO;
    }

    public <T extends Node> T findNodeById(int i, Class<T> cls) {
        Node node = (Node) this.mAnimatedNodes.get(i);
        if (node == null) {
            if (cls != Node.class) {
                if (cls != ValueNode.class) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Requested node with id ");
                    stringBuilder.append(i);
                    stringBuilder.append(" of type ");
                    stringBuilder.append(cls);
                    stringBuilder.append(" cannot be found");
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            return this.mNoopNode;
        } else if (cls.isInstance(node)) {
            return node;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Node with id ");
            stringBuilder2.append(i);
            stringBuilder2.append(" is of incompatible type ");
            stringBuilder2.append(node.getClass());
            stringBuilder2.append(", requested type was ");
            stringBuilder2.append(cls);
            throw new IllegalArgumentException(stringBuilder2.toString());
        }
    }

    public void createNode(int i, ReadableMap readableMap) {
        if (this.mAnimatedNodes.get(i) == null) {
            Object propsNode;
            String string = readableMap.getString("type");
            if ("props".equals(string)) {
                propsNode = new PropsNode(i, readableMap, this, this.mUIImplementation);
            } else if (AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE.equals(string)) {
                propsNode = new StyleNode(i, readableMap, this);
            } else if ("transform".equals(string)) {
                propsNode = new TransformNode(i, readableMap, this);
            } else if ("value".equals(string)) {
                propsNode = new ValueNode(i, readableMap, this);
            } else if ("block".equals(string)) {
                propsNode = new BlockNode(i, readableMap, this);
            } else if ("cond".equals(string)) {
                propsNode = new CondNode(i, readableMap, this);
            } else if ("op".equals(string)) {
                propsNode = new OperatorNode(i, readableMap, this);
            } else if ("set".equals(string)) {
                propsNode = new SetNode(i, readableMap, this);
            } else if ("debug".equals(string)) {
                propsNode = new DebugNode(i, readableMap, this);
            } else if ("clock".equals(string)) {
                propsNode = new ClockNode(i, readableMap, this);
            } else if ("clockStart".equals(string)) {
                propsNode = new ClockStartNode(i, readableMap, this);
            } else if ("clockStop".equals(string)) {
                propsNode = new ClockStopNode(i, readableMap, this);
            } else if ("clockTest".equals(string)) {
                propsNode = new ClockTestNode(i, readableMap, this);
            } else if ("call".equals(string)) {
                propsNode = new JSCallNode(i, readableMap, this);
            } else if ("bezier".equals(string)) {
                propsNode = new BezierNode(i, readableMap, this);
            } else if ("event".equals(string)) {
                propsNode = new EventNode(i, readableMap, this);
            } else if (ReactScrollViewHelper.OVER_SCROLL_ALWAYS.equals(string)) {
                propsNode = new AlwaysNode(i, readableMap, this);
            } else if ("concat".equals(string)) {
                propsNode = new ConcatNode(i, readableMap, this);
            } else {
                readableMap = new StringBuilder();
                readableMap.append("Unsupported node type: ");
                readableMap.append(string);
                throw new JSApplicationIllegalArgumentException(readableMap.toString());
            }
            this.mAnimatedNodes.put(i, propsNode);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Animated node with ID ");
        stringBuilder.append(i);
        stringBuilder.append(" already exists");
        throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
    }

    public void dropNode(int i) {
        this.mAnimatedNodes.remove(i);
    }

    public void connectNodes(int i, int i2) {
        Node node = (Node) this.mAnimatedNodes.get(i);
        if (node != null) {
            Node node2 = (Node) this.mAnimatedNodes.get(i2);
            if (node2 != null) {
                node.addChild(node2);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Animated node with ID ");
            stringBuilder.append(i2);
            stringBuilder.append(" does not exists");
            throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Animated node with ID ");
        stringBuilder.append(i);
        stringBuilder.append(" does not exists");
        throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
    }

    public void disconnectNodes(int i, int i2) {
        Node node = (Node) this.mAnimatedNodes.get(i);
        if (node != null) {
            Node node2 = (Node) this.mAnimatedNodes.get(i2);
            if (node2 != null) {
                node.removeChild(node2);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Animated node with ID ");
            stringBuilder.append(i2);
            stringBuilder.append(" does not exists");
            throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Animated node with ID ");
        stringBuilder.append(i);
        stringBuilder.append(" does not exists");
        throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
    }

    public void connectNodeToView(int i, int i2) {
        Node node = (Node) this.mAnimatedNodes.get(i);
        if (node == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Animated node with ID ");
            stringBuilder.append(i);
            stringBuilder.append(" does not exists");
            throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        } else if ((node instanceof PropsNode) != 0) {
            ((PropsNode) node).connectToView(i2);
        } else {
            i2 = new StringBuilder();
            i2.append("Animated node connected to view should beof type ");
            i2.append(PropsNode.class.getName());
            throw new JSApplicationIllegalArgumentException(i2.toString());
        }
    }

    public void disconnectNodeFromView(int i, int i2) {
        Node node = (Node) this.mAnimatedNodes.get(i);
        if (node == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Animated node with ID ");
            stringBuilder.append(i);
            stringBuilder.append(" does not exists");
            throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        } else if ((node instanceof PropsNode) != 0) {
            ((PropsNode) node).disconnectFromView(i2);
        } else {
            i2 = new StringBuilder();
            i2.append("Animated node connected to view should beof type ");
            i2.append(PropsNode.class.getName());
            throw new JSApplicationIllegalArgumentException(i2.toString());
        }
    }

    public void enqueueUpdateViewOnNativeThread(int i, WritableMap writableMap) {
        this.mOperationsInBatch.add(new NativeUpdateOperation(i, writableMap));
    }

    public void attachEvent(int i, String str, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(str);
        i = stringBuilder.toString();
        EventNode eventNode = (EventNode) this.mAnimatedNodes.get(i2);
        if (eventNode == null) {
            str = new StringBuilder();
            str.append("Event node ");
            str.append(i2);
            str.append(" does not exists");
            throw new JSApplicationIllegalArgumentException(str.toString());
        } else if (this.mEventMapping.containsKey(i) == 0) {
            this.mEventMapping.put(i, eventNode);
        } else {
            throw new JSApplicationIllegalArgumentException("Event handler already set for the given view and event type");
        }
    }

    public void detachEvent(int i, String str, int i2) {
        i2 = new StringBuilder();
        i2.append(i);
        i2.append(str);
        this.mEventMapping.remove(i2.toString());
    }

    public void configureProps(Set<String> set, Set<String> set2) {
        this.nativeProps = set;
        this.uiProps = set2;
    }

    public void getValue(int i, Callback callback) {
        callback.invoke(new Object[]{((Node) this.mAnimatedNodes.get(i)).value()});
    }

    public void postRunUpdatesAfterAnimation() {
        this.mWantRunUpdates = true;
        startUpdatingOnAnimationFrame();
    }

    public void postOnAnimation(OnAnimationFrame onAnimationFrame) {
        this.mFrameCallbacks.add(onAnimationFrame);
        startUpdatingOnAnimationFrame();
    }

    public void onEventDispatch(Event event) {
        if (UiThreadUtil.isOnUiThread()) {
            handleEvent(event);
            return;
        }
        this.mEventQueue.offer(event);
        startUpdatingOnAnimationFrame();
    }

    private void handleEvent(Event event) {
        if (!this.mEventMapping.isEmpty()) {
            String resolveCustomEventName = this.mCustomEventNamesResolver.resolveCustomEventName(event.getEventName());
            int viewTag = event.getViewTag();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(viewTag);
            stringBuilder.append(resolveCustomEventName);
            EventNode eventNode = (EventNode) this.mEventMapping.get(stringBuilder.toString());
            if (eventNode != null) {
                event.dispatch(eventNode);
            }
        }
    }

    public void sendEvent(String str, WritableMap writableMap) {
        this.mEventEmitter.emit(str, writableMap);
    }
}
