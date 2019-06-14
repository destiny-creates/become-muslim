package com.facebook.stetho.inspector.protocol.module;

import android.graphics.Color;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ArrayListAccumulator;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.Document;
import com.facebook.stetho.inspector.elements.Document.AttributeListAccumulator;
import com.facebook.stetho.inspector.elements.Document.UpdateListener;
import com.facebook.stetho.inspector.elements.DocumentView;
import com.facebook.stetho.inspector.elements.NodeDescriptor;
import com.facebook.stetho.inspector.elements.NodeType;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError.ErrorCode;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.inspector.protocol.module.Runtime.ObjectSubType;
import com.facebook.stetho.inspector.protocol.module.Runtime.ObjectType;
import com.facebook.stetho.inspector.protocol.module.Runtime.RemoteObject;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class DOM implements ChromeDevtoolsDomain {
    private ChildNodeInsertedEvent mCachedChildNodeInsertedEvent;
    private ChildNodeRemovedEvent mCachedChildNodeRemovedEvent;
    private final Document mDocument;
    private final DocumentUpdateListener mListener;
    private final ObjectMapper mObjectMapper = new ObjectMapper();
    private final ChromePeerManager mPeerManager;
    private final AtomicInteger mResultCounter;
    private final Map<String, List<Integer>> mSearchResults;

    /* renamed from: com.facebook.stetho.inspector.protocol.module.DOM$3 */
    class C20743 implements Runnable {
        C20743() {
        }

        public void run() {
            DOM.this.mDocument.hideHighlight();
        }
    }

    private static class AttributeModifiedEvent {
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public String value;

        private AttributeModifiedEvent() {
        }
    }

    private static class AttributeRemovedEvent {
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public int nodeId;

        private AttributeRemovedEvent() {
        }
    }

    private static class ChildNodeInsertedEvent {
        @JsonProperty(required = true)
        public Node node;
        @JsonProperty(required = true)
        public int parentNodeId;
        @JsonProperty(required = true)
        public int previousNodeId;

        private ChildNodeInsertedEvent() {
        }
    }

    private static class ChildNodeRemovedEvent {
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public int parentNodeId;

        private ChildNodeRemovedEvent() {
        }
    }

    private static class DiscardSearchResultsRequest {
        @JsonProperty(required = true)
        public String searchId;

        private DiscardSearchResultsRequest() {
        }
    }

    private static class GetSearchResultsRequest {
        @JsonProperty(required = true)
        public int fromIndex;
        @JsonProperty(required = true)
        public String searchId;
        @JsonProperty(required = true)
        public int toIndex;

        private GetSearchResultsRequest() {
        }
    }

    private static class HighlightConfig {
        @JsonProperty
        public RGBAColor contentColor;

        private HighlightConfig() {
        }
    }

    private static class HighlightNodeRequest {
        @JsonProperty(required = true)
        public HighlightConfig highlightConfig;
        @JsonProperty
        public Integer nodeId;
        @JsonProperty
        public String objectId;

        private HighlightNodeRequest() {
        }
    }

    private static class InspectNodeRequestedEvent {
        @JsonProperty
        public int nodeId;

        private InspectNodeRequestedEvent() {
        }
    }

    private static class PerformSearchRequest {
        @JsonProperty
        public Boolean includeUserAgentShadowDOM;
        @JsonProperty(required = true)
        public String query;

        private PerformSearchRequest() {
        }
    }

    private static class RGBAColor {
        @JsonProperty
        /* renamed from: a */
        public Double f4999a;
        @JsonProperty(required = true)
        /* renamed from: b */
        public int f5000b;
        @JsonProperty(required = true)
        /* renamed from: g */
        public int f5001g;
        @JsonProperty(required = true)
        /* renamed from: r */
        public int f5002r;

        private RGBAColor() {
        }

        public int getColor() {
            int i = -1;
            if (this.f4999a != null) {
                long round = Math.round(this.f4999a.doubleValue() * 255.0d);
                if (round < 0) {
                    i = 0;
                } else if (round < 255) {
                    i = (byte) ((int) round);
                }
            }
            return Color.argb(i, this.f5002r, this.f5001g, this.f5000b);
        }
    }

    private static class ResolveNodeRequest {
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty
        public String objectGroup;

        private ResolveNodeRequest() {
        }
    }

    private static class SetAttributesAsTextRequest {
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public String text;

        private SetAttributesAsTextRequest() {
        }
    }

    private static class SetInspectModeEnabledRequest {
        @JsonProperty(required = true)
        public boolean enabled;
        @JsonProperty
        public HighlightConfig highlightConfig;
        @JsonProperty
        public Boolean inspectShadowDOM;

        private SetInspectModeEnabledRequest() {
        }
    }

    /* renamed from: com.facebook.stetho.inspector.protocol.module.DOM$1 */
    class C39641 implements UncheckedCallable<Node> {
        C39641() {
        }

        public Node call() {
            return DOM.this.createNodeForElement(DOM.this.mDocument.getRootElement(), DOM.this.mDocument.getDocumentView(), null);
        }
    }

    private final class DocumentUpdateListener implements UpdateListener {
        private DocumentUpdateListener() {
        }

        public void onAttributeModified(Object obj, String str, String str2) {
            AttributeModifiedEvent attributeModifiedEvent = new AttributeModifiedEvent();
            attributeModifiedEvent.nodeId = DOM.this.mDocument.getNodeIdForElement(obj).intValue();
            attributeModifiedEvent.name = str;
            attributeModifiedEvent.value = str2;
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.onAttributeModified", attributeModifiedEvent);
        }

        public void onAttributeRemoved(Object obj, String str) {
            AttributeRemovedEvent attributeRemovedEvent = new AttributeRemovedEvent();
            attributeRemovedEvent.nodeId = DOM.this.mDocument.getNodeIdForElement(obj).intValue();
            attributeRemovedEvent.name = str;
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.attributeRemoved", attributeRemovedEvent);
        }

        public void onInspectRequested(Object obj) {
            Integer nodeIdForElement = DOM.this.mDocument.getNodeIdForElement(obj);
            if (nodeIdForElement == null) {
                LogUtil.m5739d("DocumentProvider.Listener.onInspectRequested() called for a non-mapped node: element=%s", obj);
                return;
            }
            obj = new InspectNodeRequestedEvent();
            obj.nodeId = nodeIdForElement.intValue();
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.inspectNodeRequested", obj);
        }

        public void onChildNodeRemoved(int i, int i2) {
            ChildNodeRemovedEvent access$1500 = DOM.this.acquireChildNodeRemovedEvent();
            access$1500.parentNodeId = i;
            access$1500.nodeId = i2;
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.childNodeRemoved", access$1500);
            DOM.this.releaseChildNodeRemovedEvent(access$1500);
        }

        public void onChildNodeInserted(DocumentView documentView, Object obj, int i, int i2, Accumulator<Object> accumulator) {
            ChildNodeInsertedEvent access$1700 = DOM.this.acquireChildNodeInsertedEvent();
            access$1700.parentNodeId = i;
            access$1700.previousNodeId = i2;
            access$1700.node = DOM.this.createNodeForElement(obj, documentView, accumulator);
            DOM.this.mPeerManager.sendNotificationToPeers("DOM.childNodeInserted", access$1700);
            DOM.this.releaseChildNodeInsertedEvent(access$1700);
        }
    }

    private static class GetDocumentResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public Node root;

        private GetDocumentResponse() {
        }
    }

    private static class GetSearchResultsResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<Integer> nodeIds;

        private GetSearchResultsResponse() {
        }
    }

    private static class Node implements JsonRpcResult {
        @JsonProperty
        public List<String> attributes;
        @JsonProperty
        public Integer childNodeCount;
        @JsonProperty
        public List<Node> children;
        @JsonProperty(required = true)
        public String localName;
        @JsonProperty(required = true)
        public int nodeId;
        @JsonProperty(required = true)
        public String nodeName;
        @JsonProperty(required = true)
        public NodeType nodeType;
        @JsonProperty(required = true)
        public String nodeValue;

        private Node() {
        }
    }

    private static class PerformSearchResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public int resultCount;
        @JsonProperty(required = true)
        public String searchId;

        private PerformSearchResponse() {
        }
    }

    private static class ResolveNodeResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public RemoteObject object;

        private ResolveNodeResponse() {
        }
    }

    private final class PeerManagerListener extends PeersRegisteredListener {
        private PeerManagerListener() {
        }

        protected synchronized void onFirstPeerRegistered() {
            DOM.this.mDocument.addRef();
            DOM.this.mDocument.addUpdateListener(DOM.this.mListener);
        }

        protected synchronized void onLastPeerUnregistered() {
            DOM.this.mSearchResults.clear();
            DOM.this.mDocument.removeUpdateListener(DOM.this.mListener);
            DOM.this.mDocument.release();
        }
    }

    public DOM(Document document) {
        this.mDocument = (Document) Util.throwIfNull(document);
        this.mSearchResults = Collections.synchronizedMap(new HashMap());
        this.mResultCounter = new AtomicInteger(0);
        this.mPeerManager = new ChromePeerManager();
        this.mPeerManager.setListener(new PeerManagerListener());
        this.mListener = new DocumentUpdateListener();
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mPeerManager.addPeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mPeerManager.removePeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getDocument(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        jsonRpcPeer = new GetDocumentResponse();
        jsonRpcPeer.root = (Node) this.mDocument.postAndWait(new C39641());
        return jsonRpcPeer;
    }

    @ChromeDevtoolsMethod
    public void highlightNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final HighlightNodeRequest highlightNodeRequest = (HighlightNodeRequest) this.mObjectMapper.convertValue(jSONObject, HighlightNodeRequest.class);
        if (highlightNodeRequest.nodeId == null) {
            LogUtil.m5754w("DOM.highlightNode was not given a nodeId; JS objectId is not supported");
            return;
        }
        jSONObject = highlightNodeRequest.highlightConfig.contentColor;
        if (jSONObject == null) {
            LogUtil.m5754w("DOM.highlightNode was not given a color to highlight with");
        } else {
            this.mDocument.postAndWait(new Runnable() {
                public void run() {
                    Object elementForNodeId = DOM.this.mDocument.getElementForNodeId(highlightNodeRequest.nodeId.intValue());
                    if (elementForNodeId != null) {
                        DOM.this.mDocument.highlightElement(elementForNodeId, jSONObject.getColor());
                    }
                }
            });
        }
    }

    @ChromeDevtoolsMethod
    public void hideHighlight(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mDocument.postAndWait((Runnable) new C20743());
    }

    @ChromeDevtoolsMethod
    public ResolveNodeResponse resolveNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final ResolveNodeRequest resolveNodeRequest = (ResolveNodeRequest) this.mObjectMapper.convertValue(jSONObject, ResolveNodeRequest.class);
        Object postAndWait = this.mDocument.postAndWait(new UncheckedCallable<Object>() {
            public Object call() {
                return DOM.this.mDocument.getElementForNodeId(resolveNodeRequest.nodeId);
            }
        });
        if (postAndWait != null) {
            jsonRpcPeer = Runtime.mapObject(jsonRpcPeer, postAndWait);
            jSONObject = new RemoteObject();
            jSONObject.type = ObjectType.OBJECT;
            jSONObject.subtype = ObjectSubType.NODE;
            jSONObject.className = postAndWait.getClass().getName();
            jSONObject.value = null;
            jSONObject.description = null;
            jSONObject.objectId = String.valueOf(jsonRpcPeer);
            jsonRpcPeer = new ResolveNodeResponse();
            jsonRpcPeer.object = jSONObject;
            return jsonRpcPeer;
        }
        ErrorCode errorCode = ErrorCode.INVALID_PARAMS;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No known nodeId=");
        stringBuilder.append(resolveNodeRequest.nodeId);
        throw new JsonRpcException(new JsonRpcError(errorCode, stringBuilder.toString(), null));
    }

    @ChromeDevtoolsMethod
    public void setAttributesAsText(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final SetAttributesAsTextRequest setAttributesAsTextRequest = (SetAttributesAsTextRequest) this.mObjectMapper.convertValue(jSONObject, SetAttributesAsTextRequest.class);
        this.mDocument.postAndWait(new Runnable() {
            public void run() {
                Object elementForNodeId = DOM.this.mDocument.getElementForNodeId(setAttributesAsTextRequest.nodeId);
                if (elementForNodeId != null) {
                    DOM.this.mDocument.setAttributesAsText(elementForNodeId, setAttributesAsTextRequest.text);
                }
            }
        });
    }

    @ChromeDevtoolsMethod
    public void setInspectModeEnabled(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final SetInspectModeEnabledRequest setInspectModeEnabledRequest = (SetInspectModeEnabledRequest) this.mObjectMapper.convertValue(jSONObject, SetInspectModeEnabledRequest.class);
        this.mDocument.postAndWait(new Runnable() {
            public void run() {
                DOM.this.mDocument.setInspectModeEnabled(setInspectModeEnabledRequest.enabled);
            }
        });
    }

    @ChromeDevtoolsMethod
    public PerformSearchResponse performSearch(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final PerformSearchRequest performSearchRequest = (PerformSearchRequest) this.mObjectMapper.convertValue(jSONObject, PerformSearchRequest.class);
        jSONObject = new ArrayListAccumulator();
        this.mDocument.postAndWait(new Runnable() {
            public void run() {
                DOM.this.mDocument.findMatchingElements(performSearchRequest.query, jSONObject);
            }
        });
        jsonRpcPeer = String.valueOf(this.mResultCounter.getAndIncrement());
        this.mSearchResults.put(jsonRpcPeer, jSONObject);
        PerformSearchResponse performSearchResponse = new PerformSearchResponse();
        performSearchResponse.searchId = jsonRpcPeer;
        performSearchResponse.resultCount = jSONObject.size();
        return performSearchResponse;
    }

    @ChromeDevtoolsMethod
    public GetSearchResultsResponse getSearchResults(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        GetSearchResultsRequest getSearchResultsRequest = (GetSearchResultsRequest) this.mObjectMapper.convertValue(jSONObject, GetSearchResultsRequest.class);
        if (getSearchResultsRequest.searchId == null) {
            LogUtil.m5754w("searchId may not be null");
            return null;
        }
        List list = (List) this.mSearchResults.get(getSearchResultsRequest.searchId);
        if (list == null) {
            jSONObject = new StringBuilder();
            jSONObject.append("\"");
            jSONObject.append(getSearchResultsRequest.searchId);
            jSONObject.append("\" is not a valid reference to a search result");
            LogUtil.m5754w(jSONObject.toString());
            return null;
        }
        jsonRpcPeer = list.subList(getSearchResultsRequest.fromIndex, getSearchResultsRequest.toIndex);
        jSONObject = new GetSearchResultsResponse();
        jSONObject.nodeIds = jsonRpcPeer;
        return jSONObject;
    }

    @ChromeDevtoolsMethod
    public void discardSearchResults(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        DiscardSearchResultsRequest discardSearchResultsRequest = (DiscardSearchResultsRequest) this.mObjectMapper.convertValue(jSONObject, DiscardSearchResultsRequest.class);
        if (discardSearchResultsRequest.searchId != null) {
            this.mSearchResults.remove(discardSearchResultsRequest.searchId);
        }
    }

    private Node createNodeForElement(Object obj, DocumentView documentView, Accumulator<Object> accumulator) {
        List emptyList;
        if (accumulator != null) {
            accumulator.store(obj);
        }
        NodeDescriptor nodeDescriptor = this.mDocument.getNodeDescriptor(obj);
        Node node = new Node();
        node.nodeId = this.mDocument.getNodeIdForElement(obj).intValue();
        node.nodeType = nodeDescriptor.getNodeType(obj);
        node.nodeName = nodeDescriptor.getNodeName(obj);
        node.localName = nodeDescriptor.getLocalName(obj);
        node.nodeValue = nodeDescriptor.getNodeValue(obj);
        Object attributeListAccumulator = new AttributeListAccumulator();
        nodeDescriptor.getAttributes(obj, attributeListAccumulator);
        node.attributes = attributeListAccumulator;
        obj = documentView.getElementInfo(obj);
        if (obj.children.size() == 0) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = new ArrayList(obj.children.size());
        }
        int size = obj.children.size();
        for (int i = 0; i < size; i++) {
            emptyList.add(createNodeForElement(obj.children.get(i), documentView, accumulator));
        }
        node.children = emptyList;
        node.childNodeCount = Integer.valueOf(emptyList.size());
        return node;
    }

    private ChildNodeInsertedEvent acquireChildNodeInsertedEvent() {
        ChildNodeInsertedEvent childNodeInsertedEvent = this.mCachedChildNodeInsertedEvent;
        if (childNodeInsertedEvent == null) {
            childNodeInsertedEvent = new ChildNodeInsertedEvent();
        }
        this.mCachedChildNodeInsertedEvent = null;
        return childNodeInsertedEvent;
    }

    private void releaseChildNodeInsertedEvent(ChildNodeInsertedEvent childNodeInsertedEvent) {
        childNodeInsertedEvent.parentNodeId = -1;
        childNodeInsertedEvent.previousNodeId = -1;
        childNodeInsertedEvent.node = null;
        if (this.mCachedChildNodeInsertedEvent == null) {
            this.mCachedChildNodeInsertedEvent = childNodeInsertedEvent;
        }
    }

    private ChildNodeRemovedEvent acquireChildNodeRemovedEvent() {
        ChildNodeRemovedEvent childNodeRemovedEvent = this.mCachedChildNodeRemovedEvent;
        if (childNodeRemovedEvent == null) {
            childNodeRemovedEvent = new ChildNodeRemovedEvent();
        }
        this.mCachedChildNodeRemovedEvent = null;
        return childNodeRemovedEvent;
    }

    private void releaseChildNodeRemovedEvent(ChildNodeRemovedEvent childNodeRemovedEvent) {
        childNodeRemovedEvent.parentNodeId = -1;
        childNodeRemovedEvent.nodeId = -1;
        if (this.mCachedChildNodeRemovedEvent == null) {
            this.mCachedChildNodeRemovedEvent = childNodeRemovedEvent;
        }
    }
}
