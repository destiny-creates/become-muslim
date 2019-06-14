package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.common.ListUtil;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.Document;
import com.facebook.stetho.inspector.elements.Origin;
import com.facebook.stetho.inspector.elements.StyleAccumulator;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class CSS implements ChromeDevtoolsDomain {
    private final Document mDocument;
    private final ObjectMapper mObjectMapper = new ObjectMapper();
    private final ChromePeerManager mPeerManager = new ChromePeerManager();

    private static class CSSComputedStyleProperty {
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public String value;

        private CSSComputedStyleProperty() {
        }
    }

    private static class CSSProperty {
        @JsonProperty
        public Boolean disabled;
        @JsonProperty
        public Boolean implicit;
        @JsonProperty
        public Boolean important;
        @JsonProperty(required = true)
        public String name;
        @JsonProperty
        public Boolean parsedOk;
        @JsonProperty
        public SourceRange range;
        @JsonProperty
        public String text;
        @JsonProperty(required = true)
        public String value;

        private CSSProperty() {
        }
    }

    private static class CSSRule {
        @JsonProperty
        public Origin origin;
        @JsonProperty(required = true)
        public SelectorList selectorList;
        @JsonProperty
        public CSSStyle style;
        @JsonProperty
        public String styleSheetId;

        private CSSRule() {
        }
    }

    private static class CSSStyle {
        @JsonProperty(required = true)
        public List<CSSProperty> cssProperties;
        @JsonProperty
        public String cssText;
        @JsonProperty
        public SourceRange range;
        @JsonProperty
        public List<ShorthandEntry> shorthandEntries;
        @JsonProperty
        public String styleSheetId;

        private CSSStyle() {
        }
    }

    private static class GetComputedStyleForNodeRequest {
        @JsonProperty(required = true)
        public int nodeId;

        private GetComputedStyleForNodeRequest() {
        }
    }

    private static class InheritedStyleEntry {
        @JsonProperty(required = true)
        public CSSStyle inlineStyle;
        @JsonProperty(required = true)
        public List<RuleMatch> matchedCSSRules;

        private InheritedStyleEntry() {
        }
    }

    private static class PseudoIdMatches {
        @JsonProperty(required = true)
        public List<RuleMatch> matches = new ArrayList();
        @JsonProperty(required = true)
        public int pseudoId;
    }

    private static class RuleMatch {
        @JsonProperty
        public List<Integer> matchingSelectors;
        @JsonProperty
        public CSSRule rule;

        private RuleMatch() {
        }
    }

    private static class Selector {
        @JsonProperty
        public SourceRange range;
        @JsonProperty(required = true)
        public String value;

        private Selector() {
        }
    }

    private static class SelectorList {
        @JsonProperty
        public List<Selector> selectors;
        @JsonProperty
        public String text;

        private SelectorList() {
        }
    }

    private static class ShorthandEntry {
        @JsonProperty
        public Boolean imporant;
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public String value;

        private ShorthandEntry() {
        }
    }

    private static class SourceRange {
        @JsonProperty(required = true)
        public int endColumn;
        @JsonProperty(required = true)
        public int endLine;
        @JsonProperty(required = true)
        public int startColumn;
        @JsonProperty(required = true)
        public int startLine;

        private SourceRange() {
        }
    }

    private static class GetComputedStyleForNodeResult implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<CSSComputedStyleProperty> computedStyle;

        private GetComputedStyleForNodeResult() {
        }
    }

    private static class GetMatchedStylesForNodeRequest implements JsonRpcResult {
        @JsonProperty
        public Boolean excludeInherited;
        @JsonProperty
        public Boolean excludePseudo;
        @JsonProperty(required = true)
        public int nodeId;

        private GetMatchedStylesForNodeRequest() {
        }
    }

    private static class GetMatchedStylesForNodeResult implements JsonRpcResult {
        @JsonProperty
        public List<InheritedStyleEntry> inherited;
        @JsonProperty
        public List<RuleMatch> matchedCSSRules;
        @JsonProperty
        public List<PseudoIdMatches> pseudoElements;

        private GetMatchedStylesForNodeResult() {
        }
    }

    private final class PeerManagerListener extends PeersRegisteredListener {
        private PeerManagerListener() {
        }

        protected synchronized void onFirstPeerRegistered() {
            CSS.this.mDocument.addRef();
        }

        protected synchronized void onLastPeerUnregistered() {
            CSS.this.mDocument.release();
        }
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
    }

    public CSS(Document document) {
        this.mDocument = (Document) Util.throwIfNull(document);
        this.mPeerManager.setListener(new PeerManagerListener());
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getComputedStyleForNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final GetComputedStyleForNodeRequest getComputedStyleForNodeRequest = (GetComputedStyleForNodeRequest) this.mObjectMapper.convertValue(jSONObject, GetComputedStyleForNodeRequest.class);
        jSONObject = new GetComputedStyleForNodeResult();
        jSONObject.computedStyle = new ArrayList();
        this.mDocument.postAndWait(new Runnable() {

            /* renamed from: com.facebook.stetho.inspector.protocol.module.CSS$1$1 */
            class C39621 implements StyleAccumulator {
                C39621() {
                }

                public void store(String str, String str2, boolean z) {
                    if (!z) {
                        z = new CSSComputedStyleProperty();
                        z.name = str;
                        z.value = str2;
                        jSONObject.computedStyle.add(z);
                    }
                }
            }

            public void run() {
                Object elementForNodeId = CSS.this.mDocument.getElementForNodeId(getComputedStyleForNodeRequest.nodeId);
                if (elementForNodeId == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Tried to get the style of an element that does not exist, using nodeid=");
                    stringBuilder.append(getComputedStyleForNodeRequest.nodeId);
                    LogUtil.m5742e(stringBuilder.toString());
                    return;
                }
                CSS.this.mDocument.getElementStyles(elementForNodeId, new C39621());
            }
        });
        return jSONObject;
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getMatchedStylesForNode(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        final GetMatchedStylesForNodeRequest getMatchedStylesForNodeRequest = (GetMatchedStylesForNodeRequest) this.mObjectMapper.convertValue(jSONObject, GetMatchedStylesForNodeRequest.class);
        jSONObject = new GetMatchedStylesForNodeResult();
        final RuleMatch ruleMatch = new RuleMatch();
        jSONObject.matchedCSSRules = ListUtil.newImmutableList(ruleMatch);
        ruleMatch.matchingSelectors = ListUtil.newImmutableList(Integer.valueOf(0));
        Selector selector = new Selector();
        selector.value = "<this_element>";
        CSSRule cSSRule = new CSSRule();
        cSSRule.origin = Origin.REGULAR;
        cSSRule.selectorList = new SelectorList();
        cSSRule.selectorList.selectors = ListUtil.newImmutableList(selector);
        cSSRule.style = new CSSStyle();
        cSSRule.style.cssProperties = new ArrayList();
        ruleMatch.rule = cSSRule;
        cSSRule.style.shorthandEntries = Collections.emptyList();
        this.mDocument.postAndWait(new Runnable() {

            /* renamed from: com.facebook.stetho.inspector.protocol.module.CSS$2$1 */
            class C39631 implements StyleAccumulator {
                C39631() {
                }

                public void store(String str, String str2, boolean z) {
                    if (!z) {
                        z = new CSSProperty();
                        z.name = str;
                        z.value = str2;
                        ruleMatch.rule.style.cssProperties.add(z);
                    }
                }
            }

            public void run() {
                Object elementForNodeId = CSS.this.mDocument.getElementForNodeId(getMatchedStylesForNodeRequest.nodeId);
                if (elementForNodeId == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to get style of an element that does not exist, nodeid=");
                    stringBuilder.append(getMatchedStylesForNodeRequest.nodeId);
                    LogUtil.m5754w(stringBuilder.toString());
                    return;
                }
                CSS.this.mDocument.getElementStyles(elementForNodeId, new C39631());
            }
        });
        jSONObject.inherited = Collections.emptyList();
        jSONObject.pseudoElements = Collections.emptyList();
        return jSONObject;
    }
}
