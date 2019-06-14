package versioned.host.exp.exponent.modules.api.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import versioned.host.exp.exponent.modules.api.reanimated.NodesManager;
import versioned.host.exp.exponent.modules.api.reanimated.UpdateContext;

public abstract class Node {
    public static final Double ONE = Double.valueOf(1.0d);
    public static final Double ZERO = Double.valueOf(0.0d);
    private List<Node> mChildren;
    private long mLastLoopID = -1;
    private Object mMemoizedValue;
    protected final int mNodeID;
    protected final NodesManager mNodesManager;
    private final UpdateContext mUpdateContext;

    protected abstract Object evaluate();

    public Node(int i, ReadableMap readableMap, NodesManager nodesManager) {
        this.mNodeID = i;
        this.mNodesManager = nodesManager;
        this.mUpdateContext = nodesManager.updateContext;
    }

    public final Object value() {
        if (this.mLastLoopID >= this.mUpdateContext.updateLoopID) {
            return this.mMemoizedValue;
        }
        this.mLastLoopID = this.mUpdateContext.updateLoopID;
        Object evaluate = evaluate();
        this.mMemoizedValue = evaluate;
        return evaluate;
    }

    public final Double doubleValue() {
        Object value = value();
        if (value == null) {
            return ZERO;
        }
        if (value instanceof Double) {
            return (Double) value;
        }
        if (value instanceof Number) {
            return Double.valueOf(((Number) value).doubleValue());
        }
        if (value instanceof Boolean) {
            return ((Boolean) value).booleanValue() ? ONE : ZERO;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Value of node ");
        stringBuilder.append(this);
        stringBuilder.append(" cannot be cast to a number");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void addChild(Node node) {
        if (this.mChildren == null) {
            this.mChildren = new ArrayList();
        }
        this.mChildren.add(node);
        dangerouslyRescheduleEvaluate();
    }

    public void removeChild(Node node) {
        if (this.mChildren != null) {
            this.mChildren.remove(node);
        }
    }

    protected void markUpdated() {
        UiThreadUtil.assertOnUiThread();
        this.mUpdateContext.updatedNodes.add(this);
        this.mNodesManager.postRunUpdatesAfterAnimation();
    }

    protected final void dangerouslyRescheduleEvaluate() {
        this.mLastLoopID = -1;
        markUpdated();
    }

    protected final void forceUpdateMemoizedValue(Object obj) {
        this.mMemoizedValue = obj;
        markUpdated();
    }

    private static void findAndUpdateNodes(Node node, Set<Node> set, Stack<FinalNode> stack) {
        if (!set.contains(node)) {
            set.add(node);
            List<Node> list = node.mChildren;
            if (list != null) {
                for (Node findAndUpdateNodes : list) {
                    findAndUpdateNodes(findAndUpdateNodes, set, stack);
                }
            }
            if ((node instanceof FinalNode) != null) {
                stack.push((FinalNode) node);
            }
        }
    }

    public static void runUpdates(UpdateContext updateContext) {
        UiThreadUtil.assertOnUiThread();
        ArrayList arrayList = updateContext.updatedNodes;
        Set hashSet = new HashSet();
        Stack stack = new Stack();
        for (int i = 0; i < arrayList.size(); i++) {
            findAndUpdateNodes((Node) arrayList.get(i), hashSet, stack);
            if (i == arrayList.size() - 1) {
                while (!stack.isEmpty()) {
                    ((FinalNode) stack.pop()).update();
                }
            }
        }
        arrayList.clear();
        updateContext.updateLoopID++;
    }
}
