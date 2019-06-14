package com.facebook.react.animated;

import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.UIImplementation;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModule.CustomEventNamesResolver;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class NativeAnimatedNodesManager implements EventDispatcherListener {
    private final SparseArray<AnimationDriver> mActiveAnimations = new SparseArray();
    private int mAnimatedGraphBFSColor = 0;
    private final SparseArray<AnimatedNode> mAnimatedNodes = new SparseArray();
    private final CustomEventNamesResolver mCustomEventNamesResolver;
    private final Map<String, List<EventAnimationDriver>> mEventDrivers = new HashMap();
    private final List<AnimatedNode> mRunUpdateNodeList = new LinkedList();
    private final UIImplementation mUIImplementation;
    private final SparseArray<AnimatedNode> mUpdatedNodes = new SparseArray();

    public NativeAnimatedNodesManager(UIManagerModule uIManagerModule) {
        this.mUIImplementation = uIManagerModule.getUIImplementation();
        uIManagerModule.getEventDispatcher().addListener(this);
        this.mCustomEventNamesResolver = uIManagerModule.getDirectEventNamesResolver();
    }

    AnimatedNode getNodeById(int i) {
        return (AnimatedNode) this.mAnimatedNodes.get(i);
    }

    public boolean hasActiveAnimations() {
        if (this.mActiveAnimations.size() <= 0) {
            if (this.mUpdatedNodes.size() <= 0) {
                return false;
            }
        }
        return true;
    }

    public void createAnimatedNode(int i, ReadableMap readableMap) {
        if (this.mAnimatedNodes.get(i) == null) {
            AnimatedNode styleAnimatedNode;
            String string = readableMap.getString("type");
            if (AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE.equals(string)) {
                styleAnimatedNode = new StyleAnimatedNode(readableMap, this);
            } else if ("value".equals(string)) {
                styleAnimatedNode = new ValueAnimatedNode(readableMap);
            } else if ("props".equals(string)) {
                styleAnimatedNode = new PropsAnimatedNode(readableMap, this, this.mUIImplementation);
            } else if ("interpolation".equals(string)) {
                styleAnimatedNode = new InterpolationAnimatedNode(readableMap);
            } else if ("addition".equals(string)) {
                styleAnimatedNode = new AdditionAnimatedNode(readableMap, this);
            } else if ("subtraction".equals(string)) {
                styleAnimatedNode = new SubtractionAnimatedNode(readableMap, this);
            } else if ("division".equals(string)) {
                styleAnimatedNode = new DivisionAnimatedNode(readableMap, this);
            } else if ("multiplication".equals(string)) {
                styleAnimatedNode = new MultiplicationAnimatedNode(readableMap, this);
            } else if ("modulus".equals(string)) {
                styleAnimatedNode = new ModulusAnimatedNode(readableMap, this);
            } else if ("diffclamp".equals(string)) {
                styleAnimatedNode = new DiffClampAnimatedNode(readableMap, this);
            } else if ("transform".equals(string)) {
                styleAnimatedNode = new TransformAnimatedNode(readableMap, this);
            } else if ("tracking".equals(string)) {
                styleAnimatedNode = new TrackingAnimatedNode(readableMap, this);
            } else {
                readableMap = new StringBuilder();
                readableMap.append("Unsupported node type: ");
                readableMap.append(string);
                throw new JSApplicationIllegalArgumentException(readableMap.toString());
            }
            styleAnimatedNode.mTag = i;
            this.mAnimatedNodes.put(i, styleAnimatedNode);
            this.mUpdatedNodes.put(i, styleAnimatedNode);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Animated node with tag ");
        stringBuilder.append(i);
        stringBuilder.append(" already exists");
        throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
    }

    public void dropAnimatedNode(int i) {
        this.mAnimatedNodes.remove(i);
        this.mUpdatedNodes.remove(i);
    }

    public void startListeningToAnimatedNodeValue(int i, AnimatedNodeValueListener animatedNodeValueListener) {
        AnimatedNode animatedNode = (AnimatedNode) this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Animated node with tag ");
            stringBuilder.append(i);
            stringBuilder.append(" does not exists or is not a 'value' node");
            throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        }
        ((ValueAnimatedNode) animatedNode).setValueListener(animatedNodeValueListener);
    }

    public void stopListeningToAnimatedNodeValue(int i) {
        AnimatedNode animatedNode = (AnimatedNode) this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Animated node with tag ");
            stringBuilder.append(i);
            stringBuilder.append(" does not exists or is not a 'value' node");
            throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        }
        ((ValueAnimatedNode) animatedNode).setValueListener(0);
    }

    public void setAnimatedNodeValue(int i, double d) {
        AnimatedNode animatedNode = (AnimatedNode) this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Animated node with tag ");
            stringBuilder.append(i);
            stringBuilder.append(" does not exists or is not a 'value' node");
            throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        }
        stopAnimationsForNode(animatedNode);
        ((ValueAnimatedNode) animatedNode).mValue = d;
        this.mUpdatedNodes.put(i, animatedNode);
    }

    public void setAnimatedNodeOffset(int i, double d) {
        AnimatedNode animatedNode = (AnimatedNode) this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Animated node with tag ");
            stringBuilder.append(i);
            stringBuilder.append(" does not exists or is not a 'value' node");
            throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        }
        ((ValueAnimatedNode) animatedNode).mOffset = d;
        this.mUpdatedNodes.put(i, animatedNode);
    }

    public void flattenAnimatedNodeOffset(int i) {
        AnimatedNode animatedNode = (AnimatedNode) this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Animated node with tag ");
            stringBuilder.append(i);
            stringBuilder.append(" does not exists or is not a 'value' node");
            throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        }
        ((ValueAnimatedNode) animatedNode).flattenOffset();
    }

    public void extractAnimatedNodeOffset(int i) {
        AnimatedNode animatedNode = (AnimatedNode) this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Animated node with tag ");
            stringBuilder.append(i);
            stringBuilder.append(" does not exists or is not a 'value' node");
            throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        }
        ((ValueAnimatedNode) animatedNode).extractOffset();
    }

    public void startAnimatingNode(int i, int i2, ReadableMap readableMap, Callback callback) {
        AnimatedNode animatedNode = (AnimatedNode) this.mAnimatedNodes.get(i2);
        if (animatedNode == null) {
            readableMap = new StringBuilder();
            readableMap.append("Animated node with tag ");
            readableMap.append(i2);
            readableMap.append(" does not exists");
            throw new JSApplicationIllegalArgumentException(readableMap.toString());
        } else if ((animatedNode instanceof ValueAnimatedNode) != 0) {
            AnimationDriver animationDriver = (AnimationDriver) this.mActiveAnimations.get(i);
            if (animationDriver != null) {
                animationDriver.resetConfig(readableMap);
                return;
            }
            i2 = readableMap.getString("type");
            if ("frames".equals(i2)) {
                i2 = new FrameBasedAnimationDriver(readableMap);
            } else if ("spring".equals(i2)) {
                i2 = new SpringAnimation(readableMap);
            } else if ("decay".equals(i2)) {
                i2 = new DecayAnimation(readableMap);
            } else {
                readableMap = new StringBuilder();
                readableMap.append("Unsupported animation type: ");
                readableMap.append(i2);
                throw new JSApplicationIllegalArgumentException(readableMap.toString());
            }
            i2.mId = i;
            i2.mEndCallback = callback;
            i2.mAnimatedValue = (ValueAnimatedNode) animatedNode;
            this.mActiveAnimations.put(i, i2);
        } else {
            i2 = new StringBuilder();
            i2.append("Animated node should be of type ");
            i2.append(ValueAnimatedNode.class.getName());
            throw new JSApplicationIllegalArgumentException(i2.toString());
        }
    }

    private void stopAnimationsForNode(AnimatedNode animatedNode) {
        int i = 0;
        while (i < this.mActiveAnimations.size()) {
            AnimationDriver animationDriver = (AnimationDriver) this.mActiveAnimations.valueAt(i);
            if (animatedNode.equals(animationDriver.mAnimatedValue)) {
                if (animationDriver.mEndCallback != null) {
                    Arguments.createMap().putBoolean("finished", false);
                    animationDriver.mEndCallback.invoke(r3);
                }
                this.mActiveAnimations.removeAt(i);
                i--;
            }
            i++;
        }
    }

    public void stopAnimation(int i) {
        for (int i2 = 0; i2 < this.mActiveAnimations.size(); i2++) {
            AnimationDriver animationDriver = (AnimationDriver) this.mActiveAnimations.valueAt(i2);
            if (animationDriver.mId == i) {
                if (animationDriver.mEndCallback != 0) {
                    Arguments.createMap().putBoolean("finished", false);
                    animationDriver.mEndCallback.invoke(i);
                }
                this.mActiveAnimations.removeAt(i2);
                return;
            }
        }
    }

    public void connectAnimatedNodes(int i, int i2) {
        AnimatedNode animatedNode = (AnimatedNode) this.mAnimatedNodes.get(i);
        if (animatedNode != null) {
            AnimatedNode animatedNode2 = (AnimatedNode) this.mAnimatedNodes.get(i2);
            if (animatedNode2 != null) {
                animatedNode.addChild(animatedNode2);
                this.mUpdatedNodes.put(i2, animatedNode2);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Animated node with tag ");
            stringBuilder.append(i2);
            stringBuilder.append(" does not exists");
            throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Animated node with tag ");
        stringBuilder.append(i);
        stringBuilder.append(" does not exists");
        throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
    }

    public void disconnectAnimatedNodes(int i, int i2) {
        AnimatedNode animatedNode = (AnimatedNode) this.mAnimatedNodes.get(i);
        if (animatedNode != null) {
            AnimatedNode animatedNode2 = (AnimatedNode) this.mAnimatedNodes.get(i2);
            if (animatedNode2 != null) {
                animatedNode.removeChild(animatedNode2);
                this.mUpdatedNodes.put(i2, animatedNode2);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Animated node with tag ");
            stringBuilder.append(i2);
            stringBuilder.append(" does not exists");
            throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Animated node with tag ");
        stringBuilder.append(i);
        stringBuilder.append(" does not exists");
        throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
    }

    public void connectAnimatedNodeToView(int i, int i2) {
        AnimatedNode animatedNode = (AnimatedNode) this.mAnimatedNodes.get(i);
        if (animatedNode == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Animated node with tag ");
            stringBuilder.append(i);
            stringBuilder.append(" does not exists");
            throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        } else if (animatedNode instanceof PropsAnimatedNode) {
            ((PropsAnimatedNode) animatedNode).connectToView(i2);
            this.mUpdatedNodes.put(i, animatedNode);
        } else {
            i2 = new StringBuilder();
            i2.append("Animated node connected to view should beof type ");
            i2.append(PropsAnimatedNode.class.getName());
            throw new JSApplicationIllegalArgumentException(i2.toString());
        }
    }

    public void disconnectAnimatedNodeFromView(int i, int i2) {
        AnimatedNode animatedNode = (AnimatedNode) this.mAnimatedNodes.get(i);
        if (animatedNode == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Animated node with tag ");
            stringBuilder.append(i);
            stringBuilder.append(" does not exists");
            throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        } else if ((animatedNode instanceof PropsAnimatedNode) != 0) {
            ((PropsAnimatedNode) animatedNode).disconnectFromView(i2);
        } else {
            i2 = new StringBuilder();
            i2.append("Animated node connected to view should beof type ");
            i2.append(PropsAnimatedNode.class.getName());
            throw new JSApplicationIllegalArgumentException(i2.toString());
        }
    }

    public void restoreDefaultValues(int i, int i2) {
        AnimatedNode animatedNode = (AnimatedNode) this.mAnimatedNodes.get(i);
        if (animatedNode != null) {
            if ((animatedNode instanceof PropsAnimatedNode) != 0) {
                ((PropsAnimatedNode) animatedNode).restoreDefaultValues();
                return;
            }
            i2 = new StringBuilder();
            i2.append("Animated node connected to view should beof type ");
            i2.append(PropsAnimatedNode.class.getName());
            throw new JSApplicationIllegalArgumentException(i2.toString());
        }
    }

    public void addAnimatedEventToView(int i, String str, ReadableMap readableMap) {
        int i2 = readableMap.getInt("animatedValueTag");
        AnimatedNode animatedNode = (AnimatedNode) this.mAnimatedNodes.get(i2);
        if (animatedNode == null) {
            str = new StringBuilder();
            str.append("Animated node with tag ");
            str.append(i2);
            str.append(" does not exists");
            throw new JSApplicationIllegalArgumentException(str.toString());
        } else if (animatedNode instanceof ValueAnimatedNode) {
            readableMap = readableMap.getArray("nativeEventPath");
            List arrayList = new ArrayList(readableMap.size());
            for (int i3 = 0; i3 < readableMap.size(); i3++) {
                arrayList.add(readableMap.getString(i3));
            }
            readableMap = new EventAnimationDriver(arrayList, (ValueAnimatedNode) animatedNode);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append(str);
            i = stringBuilder.toString();
            if (this.mEventDrivers.containsKey(i) != null) {
                ((List) this.mEventDrivers.get(i)).add(readableMap);
                return;
            }
            str = new ArrayList(1);
            str.add(readableMap);
            this.mEventDrivers.put(i, str);
        } else {
            str = new StringBuilder();
            str.append("Animated node connected to event should beof type ");
            str.append(ValueAnimatedNode.class.getName());
            throw new JSApplicationIllegalArgumentException(str.toString());
        }
    }

    public void removeAnimatedEventFromView(int i, String str, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(str);
        String stringBuilder2 = stringBuilder.toString();
        if (this.mEventDrivers.containsKey(stringBuilder2)) {
            List list = (List) this.mEventDrivers.get(stringBuilder2);
            if (list.size() == 1) {
                i2 = this.mEventDrivers;
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append(str);
                i2.remove(stringBuilder.toString());
                return;
            }
            i = list.listIterator();
            while (i.hasNext() != null) {
                if (((EventAnimationDriver) i.next()).mValueNode.mTag == i2) {
                    i.remove();
                    return;
                }
            }
        }
    }

    public void onEventDispatch(final Event event) {
        if (UiThreadUtil.isOnUiThread()) {
            handleEvent(event);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    NativeAnimatedNodesManager.this.handleEvent(event);
                }
            });
        }
    }

    private void handleEvent(Event event) {
        if (!this.mEventDrivers.isEmpty()) {
            String resolveCustomEventName = this.mCustomEventNamesResolver.resolveCustomEventName(event.getEventName());
            Map map = this.mEventDrivers;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(event.getViewTag());
            stringBuilder.append(resolveCustomEventName);
            List<EventAnimationDriver> list = (List) map.get(stringBuilder.toString());
            if (list != null) {
                for (EventAnimationDriver eventAnimationDriver : list) {
                    stopAnimationsForNode(eventAnimationDriver.mValueNode);
                    event.dispatch(eventAnimationDriver);
                    this.mRunUpdateNodeList.add(eventAnimationDriver.mValueNode);
                }
                updateNodes(this.mRunUpdateNodeList);
                this.mRunUpdateNodeList.clear();
            }
        }
    }

    public void runUpdates(long j) {
        int i;
        UiThreadUtil.assertOnUiThread();
        for (i = 0; i < this.mUpdatedNodes.size(); i++) {
            this.mRunUpdateNodeList.add((AnimatedNode) this.mUpdatedNodes.valueAt(i));
        }
        this.mUpdatedNodes.clear();
        Object obj = null;
        for (i = 0; i < this.mActiveAnimations.size(); i++) {
            AnimationDriver animationDriver = (AnimationDriver) this.mActiveAnimations.valueAt(i);
            animationDriver.runAnimationStep(j);
            this.mRunUpdateNodeList.add(animationDriver.mAnimatedValue);
            if (animationDriver.mHasFinished) {
                obj = 1;
            }
        }
        updateNodes(this.mRunUpdateNodeList);
        this.mRunUpdateNodeList.clear();
        if (obj != null) {
            for (j = this.mActiveAnimations.size() - 1; j >= null; j--) {
                AnimationDriver animationDriver2 = (AnimationDriver) this.mActiveAnimations.valueAt(j);
                if (animationDriver2.mHasFinished) {
                    if (animationDriver2.mEndCallback != null) {
                        Arguments.createMap().putBoolean("finished", true);
                        animationDriver2.mEndCallback.invoke(r1);
                    }
                    this.mActiveAnimations.removeAt(j);
                }
            }
        }
    }

    private void updateNodes(List<AnimatedNode> list) {
        this.mAnimatedGraphBFSColor++;
        if (this.mAnimatedGraphBFSColor == 0) {
            this.mAnimatedGraphBFSColor++;
        }
        Queue arrayDeque = new ArrayDeque();
        int i = 0;
        for (AnimatedNode animatedNode : list) {
            if (animatedNode.mBFSColor != this.mAnimatedGraphBFSColor) {
                animatedNode.mBFSColor = this.mAnimatedGraphBFSColor;
                i++;
                arrayDeque.add(animatedNode);
            }
        }
        while (!arrayDeque.isEmpty()) {
            int i2;
            AnimatedNode animatedNode2;
            AnimatedNode animatedNode3 = (AnimatedNode) arrayDeque.poll();
            if (animatedNode3.mChildren != null) {
                i2 = i;
                for (i = 0; i < animatedNode3.mChildren.size(); i++) {
                    animatedNode2 = (AnimatedNode) animatedNode3.mChildren.get(i);
                    animatedNode2.mActiveIncomingNodes++;
                    if (animatedNode2.mBFSColor != this.mAnimatedGraphBFSColor) {
                        animatedNode2.mBFSColor = this.mAnimatedGraphBFSColor;
                        i2++;
                        arrayDeque.add(animatedNode2);
                    }
                }
                i = i2;
            }
        }
        this.mAnimatedGraphBFSColor++;
        if (this.mAnimatedGraphBFSColor == 0) {
            this.mAnimatedGraphBFSColor++;
        }
        int i3 = 0;
        for (AnimatedNode animatedNode4 : list) {
            if (animatedNode4.mActiveIncomingNodes == 0 && animatedNode4.mBFSColor != this.mAnimatedGraphBFSColor) {
                animatedNode4.mBFSColor = this.mAnimatedGraphBFSColor;
                i3++;
                arrayDeque.add(animatedNode4);
            }
        }
        while (arrayDeque.isEmpty() == null) {
            AnimatedNode animatedNode5 = (AnimatedNode) arrayDeque.poll();
            animatedNode5.update();
            if (animatedNode5 instanceof PropsAnimatedNode) {
                try {
                    ((PropsAnimatedNode) animatedNode5).updateView();
                } catch (Throwable e) {
                    FLog.m5675e(ReactConstants.TAG, "Native animation workaround, frame lost as result of race condition", e);
                }
            }
            if (animatedNode5 instanceof ValueAnimatedNode) {
                ((ValueAnimatedNode) animatedNode5).onValueUpdate();
            }
            if (animatedNode5.mChildren != null) {
                i2 = i3;
                for (i3 = 0; i3 < animatedNode5.mChildren.size(); i3++) {
                    animatedNode2 = (AnimatedNode) animatedNode5.mChildren.get(i3);
                    animatedNode2.mActiveIncomingNodes--;
                    if (animatedNode2.mBFSColor != this.mAnimatedGraphBFSColor && animatedNode2.mActiveIncomingNodes == 0) {
                        animatedNode2.mBFSColor = this.mAnimatedGraphBFSColor;
                        i2++;
                        arrayDeque.add(animatedNode2);
                    }
                }
                i3 = i2;
            }
        }
        if (i != i3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Looks like animated nodes graph has cycles, there are ");
            stringBuilder.append(i);
            stringBuilder.append(" but toposort visited only ");
            stringBuilder.append(i3);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }
}
