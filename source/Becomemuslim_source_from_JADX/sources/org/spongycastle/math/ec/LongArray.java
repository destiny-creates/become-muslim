package org.spongycastle.math.ec;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.common.util.ByteConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.NativeProtocol;
import java.math.BigInteger;
import org.spongycastle.util.Arrays;

class LongArray implements Cloneable {
    /* renamed from: a */
    static final byte[] f23099a = new byte[]{(byte) 0, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3, (byte) 3, (byte) 4, (byte) 4, (byte) 4, (byte) 4, (byte) 4, (byte) 4, (byte) 4, (byte) 4, (byte) 5, (byte) 5, (byte) 5, (byte) 5, (byte) 5, (byte) 5, (byte) 5, (byte) 5, (byte) 5, (byte) 5, (byte) 5, (byte) 5, (byte) 5, (byte) 5, (byte) 5, (byte) 5, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 7, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8, (byte) 8};
    /* renamed from: b */
    private static final short[] f23100b = new short[]{(short) 0, (short) 1, (short) 4, (short) 5, (short) 16, (short) 17, (short) 20, (short) 21, (short) 64, (short) 65, (short) 68, (short) 69, (short) 80, (short) 81, (short) 84, (short) 85, (short) 256, (short) 257, (short) 260, (short) 261, (short) 272, (short) 273, (short) 276, (short) 277, (short) 320, (short) 321, (short) 324, (short) 325, (short) 336, (short) 337, (short) 340, (short) 341, (short) 1024, (short) 1025, (short) 1028, (short) 1029, (short) 1040, (short) 1041, (short) 1044, (short) 1045, (short) 1088, (short) 1089, (short) 1092, (short) 1093, (short) 1104, (short) 1105, (short) 1108, (short) 1109, (short) 1280, (short) 1281, (short) 1284, (short) 1285, (short) 1296, (short) 1297, (short) 1300, (short) 1301, (short) 1344, (short) 1345, (short) 1348, (short) 1349, (short) 1360, (short) 1361, (short) 1364, (short) 1365, (short) 4096, (short) 4097, (short) 4100, (short) 4101, (short) 4112, (short) 4113, (short) 4116, (short) 4117, (short) 4160, (short) 4161, (short) 4164, (short) 4165, (short) 4176, (short) 4177, (short) 4180, (short) 4181, (short) 4352, (short) 4353, (short) 4356, (short) 4357, (short) 4368, (short) 4369, (short) 4372, (short) 4373, (short) 4416, (short) 4417, (short) 4420, (short) 4421, (short) 4432, (short) 4433, (short) 4436, (short) 4437, (short) 5120, (short) 5121, (short) 5124, (short) 5125, (short) 5136, (short) 5137, (short) 5140, (short) 5141, (short) 5184, (short) 5185, (short) 5188, (short) 5189, (short) 5200, (short) 5201, (short) 5204, (short) 5205, (short) 5376, (short) 5377, (short) 5380, (short) 5381, (short) 5392, (short) 5393, (short) 5396, (short) 5397, (short) 5440, (short) 5441, (short) 5444, (short) 5445, (short) 5456, (short) 5457, (short) 5460, (short) 5461, (short) 16384, (short) 16385, (short) 16388, (short) 16389, (short) 16400, (short) 16401, (short) 16404, (short) 16405, (short) 16448, (short) 16449, (short) 16452, (short) 16453, (short) 16464, (short) 16465, (short) 16468, (short) 16469, (short) 16640, (short) 16641, (short) 16644, (short) 16645, (short) 16656, (short) 16657, (short) 16660, (short) 16661, (short) 16704, (short) 16705, (short) 16708, (short) 16709, (short) 16720, (short) 16721, (short) 16724, (short) 16725, (short) 17408, (short) 17409, (short) 17412, (short) 17413, (short) 17424, (short) 17425, (short) 17428, (short) 17429, (short) 17472, (short) 17473, (short) 17476, (short) 17477, (short) 17488, (short) 17489, (short) 17492, (short) 17493, (short) 17664, (short) 17665, (short) 17668, (short) 17669, (short) 17680, (short) 17681, (short) 17684, (short) 17685, (short) 17728, (short) 17729, (short) 17732, (short) 17733, (short) 17744, (short) 17745, (short) 17748, (short) 17749, (short) 20480, (short) 20481, (short) 20484, (short) 20485, (short) 20496, (short) 20497, (short) 20500, (short) 20501, (short) 20544, (short) 20545, (short) 20548, (short) 20549, (short) 20560, (short) 20561, (short) 20564, (short) 20565, (short) 20736, (short) 20737, (short) 20740, (short) 20741, (short) 20752, (short) 20753, (short) 20756, (short) 20757, (short) 20800, (short) 20801, (short) 20804, (short) 20805, (short) 20816, (short) 20817, (short) 20820, (short) 20821, (short) 21504, (short) 21505, (short) 21508, (short) 21509, (short) 21520, (short) 21521, (short) 21524, (short) 21525, (short) 21568, (short) 21569, (short) 21572, (short) 21573, (short) 21584, (short) 21585, (short) 21588, (short) 21589, (short) 21760, (short) 21761, (short) 21764, (short) 21765, (short) 21776, (short) 21777, (short) 21780, (short) 21781, (short) 21824, (short) 21825, (short) 21828, (short) 21829, (short) 21840, (short) 21841, (short) 21844, (short) 21845};
    /* renamed from: c */
    private static final int[] f23101c = new int[]{0, 1, 8, 9, 64, 65, 72, 73, 512, 513, 520, 521, 576, 577, 584, 585, 4096, 4097, 4104, 4105, 4160, 4161, 4168, 4169, 4608, 4609, 4616, 4617, 4672, 4673, 4680, 4681, 32768, 32769, 32776, 32777, 32832, 32833, 32840, 32841, 33280, 33281, 33288, 33289, 33344, 33345, 33352, 33353, 36864, 36865, 36872, 36873, 36928, 36929, 36936, 36937, 37376, 37377, 37384, 37385, 37440, 37441, 37448, 37449, 262144, 262145, 262152, 262153, 262208, 262209, 262216, 262217, 262656, 262657, 262664, 262665, 262720, 262721, 262728, 262729, 266240, 266241, 266248, 266249, 266304, 266305, 266312, 266313, 266752, 266753, 266760, 266761, 266816, 266817, 266824, 266825, 294912, 294913, 294920, 294921, 294976, 294977, 294984, 294985, 295424, 295425, 295432, 295433, 295488, 295489, 295496, 295497, 299008, 299009, 299016, 299017, 299072, 299073, 299080, 299081, 299520, 299521, 299528, 299529, 299584, 299585, 299592, 299593};
    /* renamed from: d */
    private static final int[] f23102d = new int[]{0, 1, 16, 17, 256, 257, 272, 273, 4096, 4097, 4112, 4113, 4352, 4353, 4368, 4369, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY, 65552, 65553, 65792, 65793, 65808, 65809, 69632, 69633, 69648, 69649, 69888, 69889, 69904, 69905, ByteConstants.MB, 1048577, 1048592, 1048593, 1048832, 1048833, 1048848, 1048849, 1052672, 1052673, 1052688, 1052689, 1052928, 1052929, 1052944, 1052945, 1114112, 1114113, 1114128, 1114129, 1114368, 1114369, 1114384, 1114385, 1118208, 1118209, 1118224, 1118225, 1118464, 1118465, 1118480, 1118481, 16777216, 16777217, 16777232, 16777233, 16777472, 16777473, 16777488, 16777489, 16781312, 16781313, 16781328, 16781329, 16781568, 16781569, 16781584, 16781585, 16842752, 16842753, 16842768, 16842769, 16843008, 16843009, 16843024, 16843025, 16846848, 16846849, 16846864, 16846865, 16847104, 16847105, 16847120, 16847121, 17825792, 17825793, 17825808, 17825809, 17826048, 17826049, 17826064, 17826065, 17829888, 17829889, 17829904, 17829905, 17830144, 17830145, 17830160, 17830161, 17891328, 17891329, 17891344, 17891345, 17891584, 17891585, 17891600, 17891601, 17895424, 17895425, 17895440, 17895441, 17895680, 17895681, 17895696, 17895697, 268435456, 268435457, 268435472, 268435473, 268435712, 268435713, 268435728, 268435729, 268439552, 268439553, 268439568, 268439569, 268439808, 268439809, 268439824, 268439825, 268500992, 268500993, 268501008, 268501009, 268501248, 268501249, 268501264, 268501265, 268505088, 268505089, 268505104, 268505105, 268505344, 268505345, 268505360, 268505361, 269484032, 269484033, 269484048, 269484049, 269484288, 269484289, 269484304, 269484305, 269488128, 269488129, 269488144, 269488145, 269488384, 269488385, 269488400, 269488401, 269549568, 269549569, 269549584, 269549585, 269549824, 269549825, 269549840, 269549841, 269553664, 269553665, 269553680, 269553681, 269553920, 269553921, 269553936, 269553937, 285212672, 285212673, 285212688, 285212689, 285212928, 285212929, 285212944, 285212945, 285216768, 285216769, 285216784, 285216785, 285217024, 285217025, 285217040, 285217041, 285278208, 285278209, 285278224, 285278225, 285278464, 285278465, 285278480, 285278481, 285282304, 285282305, 285282320, 285282321, 285282560, 285282561, 285282576, 285282577, 286261248, 286261249, 286261264, 286261265, 286261504, 286261505, 286261520, 286261521, 286265344, 286265345, 286265360, 286265361, 286265600, 286265601, 286265616, 286265617, 286326784, 286326785, 286326800, 286326801, 286327040, 286327041, 286327056, 286327057, 286330880, 286330881, 286330896, 286330897, 286331136, 286331137, 286331152, 286331153};
    /* renamed from: e */
    private static final int[] f23103e = new int[]{0, 1, 32, 33, 1024, 1025, 1056, 1057, 32768, 32769, 32800, 32801, 33792, 33793, 33824, 33825, ByteConstants.MB, 1048577, 1048608, 1048609, 1049600, 1049601, 1049632, 1049633, 1081344, 1081345, 1081376, 1081377, 1082368, 1082369, 1082400, 1082401, 33554432, 33554433, 33554464, 33554465, 33555456, 33555457, 33555488, 33555489, 33587200, 33587201, 33587232, 33587233, 33588224, 33588225, 33588256, 33588257, 34603008, 34603009, 34603040, 34603041, 34604032, 34604033, 34604064, 34604065, 34635776, 34635777, 34635808, 34635809, 34636800, 34636801, 34636832, 34636833, 1073741824, 1073741825, 1073741856, 1073741857, 1073742848, 1073742849, 1073742880, 1073742881, 1073774592, 1073774593, 1073774624, 1073774625, 1073775616, 1073775617, 1073775648, 1073775649, 1074790400, 1074790401, 1074790432, 1074790433, 1074791424, 1074791425, 1074791456, 1074791457, 1074823168, 1074823169, 1074823200, 1074823201, 1074824192, 1074824193, 1074824224, 1074824225, 1107296256, 1107296257, 1107296288, 1107296289, 1107297280, 1107297281, 1107297312, 1107297313, 1107329024, 1107329025, 1107329056, 1107329057, 1107330048, 1107330049, 1107330080, 1107330081, 1108344832, 1108344833, 1108344864, 1108344865, 1108345856, 1108345857, 1108345888, 1108345889, 1108377600, 1108377601, 1108377632, 1108377633, 1108378624, 1108378625, 1108378656, 1108378657};
    /* renamed from: f */
    private static final long[] f23104f = new long[]{0, 1, 128, 129, 16384, 16385, 16512, 16513, 2097152, 2097153, 2097280, 2097281, 2113536, 2113537, 2113664, 2113665, 268435456, 268435457, 268435584, 268435585, 268451840, 268451841, 268451968, 268451969, 270532608, 270532609, 270532736, 270532737, 270548992, 270548993, 270549120, 270549121, 34359738368L, 34359738369L, 34359738496L, 34359738497L, 34359754752L, 34359754753L, 34359754880L, 34359754881L, 34361835520L, 34361835521L, 34361835648L, 34361835649L, 34361851904L, 34361851905L, 34361852032L, 34361852033L, 34628173824L, 34628173825L, 34628173952L, 34628173953L, 34628190208L, 34628190209L, 34628190336L, 34628190337L, 34630270976L, 34630270977L, 34630271104L, 34630271105L, 34630287360L, 34630287361L, 34630287488L, 34630287489L, 4398046511104L, 4398046511105L, 4398046511232L, 4398046511233L, 4398046527488L, 4398046527489L, 4398046527616L, 4398046527617L, 4398048608256L, 4398048608257L, 4398048608384L, 4398048608385L, 4398048624640L, 4398048624641L, 4398048624768L, 4398048624769L, 4398314946560L, 4398314946561L, 4398314946688L, 4398314946689L, 4398314962944L, 4398314962945L, 4398314963072L, 4398314963073L, 4398317043712L, 4398317043713L, 4398317043840L, 4398317043841L, 4398317060096L, 4398317060097L, 4398317060224L, 4398317060225L, 4432406249472L, 4432406249473L, 4432406249600L, 4432406249601L, 4432406265856L, 4432406265857L, 4432406265984L, 4432406265985L, 4432408346624L, 4432408346625L, 4432408346752L, 4432408346753L, 4432408363008L, 4432408363009L, 4432408363136L, 4432408363137L, 4432674684928L, 4432674684929L, 4432674685056L, 4432674685057L, 4432674701312L, 4432674701313L, 4432674701440L, 4432674701441L, 4432676782080L, 4432676782081L, 4432676782208L, 4432676782209L, 4432676798464L, 4432676798465L, 4432676798592L, 4432676798593L, 562949953421312L, 562949953421313L, 562949953421440L, 562949953421441L, 562949953437696L, 562949953437697L, 562949953437824L, 562949953437825L, 562949955518464L, 562949955518465L, 562949955518592L, 562949955518593L, 562949955534848L, 562949955534849L, 562949955534976L, 562949955534977L, 562950221856768L, 562950221856769L, 562950221856896L, 562950221856897L, 562950221873152L, 562950221873153L, 562950221873280L, 562950221873281L, 562950223953920L, 562950223953921L, 562950223954048L, 562950223954049L, 562950223970304L, 562950223970305L, 562950223970432L, 562950223970433L, 562984313159680L, 562984313159681L, 562984313159808L, 562984313159809L, 562984313176064L, 562984313176065L, 562984313176192L, 562984313176193L, 562984315256832L, 562984315256833L, 562984315256960L, 562984315256961L, 562984315273216L, 562984315273217L, 562984315273344L, 562984315273345L, 562984581595136L, 562984581595137L, 562984581595264L, 562984581595265L, 562984581611520L, 562984581611521L, 562984581611648L, 562984581611649L, 562984583692288L, 562984583692289L, 562984583692416L, 562984583692417L, 562984583708672L, 562984583708673L, 562984583708800L, 562984583708801L, 567347999932416L, 567347999932417L, 567347999932544L, 567347999932545L, 567347999948800L, 567347999948801L, 567347999948928L, 567347999948929L, 567348002029568L, 567348002029569L, 567348002029696L, 567348002029697L, 567348002045952L, 567348002045953L, 567348002046080L, 567348002046081L, 567348268367872L, 567348268367873L, 567348268368000L, 567348268368001L, 567348268384256L, 567348268384257L, 567348268384384L, 567348268384385L, 567348270465024L, 567348270465025L, 567348270465152L, 567348270465153L, 567348270481408L, 567348270481409L, 567348270481536L, 567348270481537L, 567382359670784L, 567382359670785L, 567382359670912L, 567382359670913L, 567382359687168L, 567382359687169L, 567382359687296L, 567382359687297L, 567382361767936L, 567382361767937L, 567382361768064L, 567382361768065L, 567382361784320L, 567382361784321L, 567382361784448L, 567382361784449L, 567382628106240L, 567382628106241L, 567382628106368L, 567382628106369L, 567382628122624L, 567382628122625L, 567382628122752L, 567382628122753L, 567382630203392L, 567382630203393L, 567382630203520L, 567382630203521L, 567382630219776L, 567382630219777L, 567382630219904L, 567382630219905L, 72057594037927936L, 72057594037927937L, 72057594037928064L, 72057594037928065L, 72057594037944320L, 72057594037944321L, 72057594037944448L, 72057594037944449L, 72057594040025088L, 72057594040025089L, 72057594040025216L, 72057594040025217L, 72057594040041472L, 72057594040041473L, 72057594040041600L, 72057594040041601L, 72057594306363392L, 72057594306363393L, 72057594306363520L, 72057594306363521L, 72057594306379776L, 72057594306379777L, 72057594306379904L, 72057594306379905L, 72057594308460544L, 72057594308460545L, 72057594308460672L, 72057594308460673L, 72057594308476928L, 72057594308476929L, 72057594308477056L, 72057594308477057L, 72057628397666304L, 72057628397666305L, 72057628397666432L, 72057628397666433L, 72057628397682688L, 72057628397682689L, 72057628397682816L, 72057628397682817L, 72057628399763456L, 72057628399763457L, 72057628399763584L, 72057628399763585L, 72057628399779840L, 72057628399779841L, 72057628399779968L, 72057628399779969L, 72057628666101760L, 72057628666101761L, 72057628666101888L, 72057628666101889L, 72057628666118144L, 72057628666118145L, 72057628666118272L, 72057628666118273L, 72057628668198912L, 72057628668198913L, 72057628668199040L, 72057628668199041L, 72057628668215296L, 72057628668215297L, 72057628668215424L, 72057628668215425L, 72061992084439040L, 72061992084439041L, 72061992084439168L, 72061992084439169L, 72061992084455424L, 72061992084455425L, 72061992084455552L, 72061992084455553L, 72061992086536192L, 72061992086536193L, 72061992086536320L, 72061992086536321L, 72061992086552576L, 72061992086552577L, 72061992086552704L, 72061992086552705L, 72061992352874496L, 72061992352874497L, 72061992352874624L, 72061992352874625L, 72061992352890880L, 72061992352890881L, 72061992352891008L, 72061992352891009L, 72061992354971648L, 72061992354971649L, 72061992354971776L, 72061992354971777L, 72061992354988032L, 72061992354988033L, 72061992354988160L, 72061992354988161L, 72062026444177408L, 72062026444177409L, 72062026444177536L, 72062026444177537L, 72062026444193792L, 72062026444193793L, 72062026444193920L, 72062026444193921L, 72062026446274560L, 72062026446274561L, 72062026446274688L, 72062026446274689L, 72062026446290944L, 72062026446290945L, 72062026446291072L, 72062026446291073L, 72062026712612864L, 72062026712612865L, 72062026712612992L, 72062026712612993L, 72062026712629248L, 72062026712629249L, 72062026712629376L, 72062026712629377L, 72062026714710016L, 72062026714710017L, 72062026714710144L, 72062026714710145L, 72062026714726400L, 72062026714726401L, 72062026714726528L, 72062026714726529L, 72620543991349248L, 72620543991349249L, 72620543991349376L, 72620543991349377L, 72620543991365632L, 72620543991365633L, 72620543991365760L, 72620543991365761L, 72620543993446400L, 72620543993446401L, 72620543993446528L, 72620543993446529L, 72620543993462784L, 72620543993462785L, 72620543993462912L, 72620543993462913L, 72620544259784704L, 72620544259784705L, 72620544259784832L, 72620544259784833L, 72620544259801088L, 72620544259801089L, 72620544259801216L, 72620544259801217L, 72620544261881856L, 72620544261881857L, 72620544261881984L, 72620544261881985L, 72620544261898240L, 72620544261898241L, 72620544261898368L, 72620544261898369L, 72620578351087616L, 72620578351087617L, 72620578351087744L, 72620578351087745L, 72620578351104000L, 72620578351104001L, 72620578351104128L, 72620578351104129L, 72620578353184768L, 72620578353184769L, 72620578353184896L, 72620578353184897L, 72620578353201152L, 72620578353201153L, 72620578353201280L, 72620578353201281L, 72620578619523072L, 72620578619523073L, 72620578619523200L, 72620578619523201L, 72620578619539456L, 72620578619539457L, 72620578619539584L, 72620578619539585L, 72620578621620224L, 72620578621620225L, 72620578621620352L, 72620578621620353L, 72620578621636608L, 72620578621636609L, 72620578621636736L, 72620578621636737L, 72624942037860352L, 72624942037860353L, 72624942037860480L, 72624942037860481L, 72624942037876736L, 72624942037876737L, 72624942037876864L, 72624942037876865L, 72624942039957504L, 72624942039957505L, 72624942039957632L, 72624942039957633L, 72624942039973888L, 72624942039973889L, 72624942039974016L, 72624942039974017L, 72624942306295808L, 72624942306295809L, 72624942306295936L, 72624942306295937L, 72624942306312192L, 72624942306312193L, 72624942306312320L, 72624942306312321L, 72624942308392960L, 72624942308392961L, 72624942308393088L, 72624942308393089L, 72624942308409344L, 72624942308409345L, 72624942308409472L, 72624942308409473L, 72624976397598720L, 72624976397598721L, 72624976397598848L, 72624976397598849L, 72624976397615104L, 72624976397615105L, 72624976397615232L, 72624976397615233L, 72624976399695872L, 72624976399695873L, 72624976399696000L, 72624976399696001L, 72624976399712256L, 72624976399712257L, 72624976399712384L, 72624976399712385L, 72624976666034176L, 72624976666034177L, 72624976666034304L, 72624976666034305L, 72624976666050560L, 72624976666050561L, 72624976666050688L, 72624976666050689L, 72624976668131328L, 72624976668131329L, 72624976668131456L, 72624976668131457L, 72624976668147712L, 72624976668147713L, 72624976668147840L, 72624976668147841L};
    /* renamed from: g */
    private long[] f23105g;

    public LongArray(int i) {
        this.f23105g = new long[i];
    }

    public LongArray(long[] jArr) {
        this.f23105g = jArr;
    }

    public LongArray(long[] jArr, int i, int i2) {
        if (i == 0 && i2 == jArr.length) {
            this.f23105g = jArr;
            return;
        }
        this.f23105g = new long[i2];
        System.arraycopy(jArr, i, this.f23105g, 0, i2);
    }

    public LongArray(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0) {
            throw new IllegalArgumentException("invalid F2m field value");
        } else if (bigInteger.signum() == 0) {
            this.f23105g = new long[]{null};
        } else {
            int i;
            int i2;
            bigInteger = bigInteger.toByteArray();
            int length = bigInteger.length;
            if (bigInteger[0] == (byte) 0) {
                length--;
                i = 1;
            } else {
                i = 0;
            }
            int i3 = (length + 7) / 8;
            this.f23105g = new long[i3];
            i3--;
            length = (length % 8) + i;
            if (i < length) {
                long j = 0;
                while (i < length) {
                    j = (j << 8) | ((long) (bigInteger[i] & JfifUtil.MARKER_FIRST_BYTE));
                    i++;
                }
                i2 = i3 - 1;
                this.f23105g[i3] = j;
            } else {
                i2 = i3;
            }
            while (i2 >= 0) {
                int i4 = i;
                length = 0;
                long j2 = 0;
                while (length < 8) {
                    j2 = (j2 << 8) | ((long) (bigInteger[i4] & JfifUtil.MARKER_FIRST_BYTE));
                    length++;
                    i4++;
                }
                this.f23105g[i2] = j2;
                i2--;
                i = i4;
            }
        }
    }

    /* renamed from: a */
    public boolean m28458a() {
        long[] jArr = this.f23105g;
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public boolean m28461b() {
        long[] jArr = this.f23105g;
        for (long j : jArr) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public int m28462c() {
        return m28453a(this.f23105g.length);
    }

    /* renamed from: a */
    public int m28453a(int i) {
        long[] jArr = this.f23105g;
        i = Math.min(i, jArr.length);
        if (i < 1) {
            return 0;
        }
        if (jArr[0] != 0) {
            while (true) {
                i--;
                if (jArr[i] != 0) {
                    return i + 1;
                }
            }
        } else {
            do {
                i--;
                if (jArr[i] != 0) {
                    return i + 1;
                }
            } while (i > 0);
            return 0;
        }
    }

    /* renamed from: d */
    public int m28464d() {
        int length = this.f23105g.length;
        while (length != 0) {
            length--;
            long j = this.f23105g[length];
            if (j != 0) {
                return (length << 6) + m28429a(j);
            }
        }
        return 0;
    }

    /* renamed from: b */
    private int m28441b(int i) {
        i = (i + 62) >>> 6;
        while (i != 0) {
            i--;
            long j = this.f23105g[i];
            if (j != 0) {
                return (i << 6) + m28429a(j);
            }
        }
        return 0;
    }

    /* renamed from: a */
    private static int m28429a(long j) {
        int i = 32;
        int i2 = (int) (j >>> 32);
        if (i2 == 0) {
            i2 = (int) j;
            i = 0;
        }
        j = i2 >>> 16;
        if (j == null) {
            j = i2 >>> 8;
            j = j == null ? f23099a[i2] : f23099a[j] + 8;
        } else {
            int i3 = j >>> 8;
            j = i3 == 0 ? f23099a[j] + 16 : f23099a[i3] + 24;
        }
        return i + j;
    }

    /* renamed from: c */
    private long[] m28449c(int i) {
        Object obj = new long[i];
        System.arraycopy(this.f23105g, 0, obj, 0, Math.min(this.f23105g.length, i));
        return obj;
    }

    /* renamed from: e */
    public BigInteger m28466e() {
        int c = m28462c();
        if (c == 0) {
            return ECConstants.f23075c;
        }
        int i = c - 1;
        long j = this.f23105g[i];
        byte[] bArr = new byte[8];
        Object obj = null;
        int i2 = 0;
        for (int i3 = 7; i3 >= 0; i3--) {
            byte b = (byte) ((int) (j >>> (i3 * 8)));
            if (obj != null || b != (byte) 0) {
                int i4 = i2 + 1;
                bArr[i2] = b;
                i2 = i4;
                obj = 1;
            }
        }
        byte[] bArr2 = new byte[((i * 8) + i2)];
        for (int i5 = 0; i5 < i2; i5++) {
            bArr2[i5] = bArr[i5];
        }
        for (c -= 2; c >= 0; c--) {
            j = this.f23105g[c];
            i = 7;
            while (i >= 0) {
                int i6 = i2 + 1;
                bArr2[i2] = (byte) ((int) (j >>> (i * 8)));
                i--;
                i2 = i6;
            }
        }
        return new BigInteger(1, bArr2);
    }

    /* renamed from: a */
    private static long m28430a(long[] jArr, int i, long[] jArr2, int i2, int i3, int i4) {
        int i5 = 64 - i4;
        long j = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            long j2 = jArr[i + i6];
            jArr2[i2 + i6] = j | (j2 << i4);
            j = j2 >>> i5;
        }
        return j;
    }

    /* renamed from: f */
    public LongArray m28467f() {
        if (this.f23105g.length == 0) {
            return new LongArray(new long[]{1});
        }
        long[] c = m28449c(Math.max(1, m28462c()));
        c[0] = 1 ^ c[0];
        return new LongArray(c);
    }

    /* renamed from: a */
    private void m28433a(LongArray longArray, int i, int i2) {
        i = (i + 63) >>> 6;
        int i3 = i2 >>> 6;
        int i4 = i2 & 63;
        if (i4 == 0) {
            m28438a(this.f23105g, i3, longArray.f23105g, 0, i);
            return;
        }
        long b = m28443b(this.f23105g, i3, longArray.f23105g, 0, i, i4);
        if (b != 0) {
            longArray = this.f23105g;
            i += i3;
            longArray[i] = b ^ longArray[i];
        }
    }

    /* renamed from: b */
    private static long m28443b(long[] jArr, int i, long[] jArr2, int i2, int i3, int i4) {
        int i5 = 64 - i4;
        long j = 0;
        int i6 = i3;
        for (int i7 = 0; i7 < i6; i7++) {
            long j2 = jArr2[i2 + i7];
            int i8 = i + i7;
            jArr[i8] = (j | (j2 << i4)) ^ jArr[i8];
            j = j2 >>> i5;
        }
        return j;
    }

    /* renamed from: c */
    private static long m28447c(long[] jArr, int i, long[] jArr2, int i2, int i3, int i4) {
        int i5 = 64 - i4;
        long j = 0;
        while (true) {
            i3--;
            if (i3 < 0) {
                return j;
            }
            long j2 = jArr2[i2 + i3];
            int i6 = i + i3;
            jArr[i6] = (j | (j2 >>> i4)) ^ jArr[i6];
            j = j2 << i5;
        }
    }

    /* renamed from: a */
    public void m28457a(LongArray longArray, int i) {
        int c = longArray.m28462c();
        if (c != 0) {
            int i2 = c + i;
            if (i2 > this.f23105g.length) {
                this.f23105g = m28449c(i2);
            }
            m28438a(this.f23105g, i, longArray.f23105g, 0, c);
        }
    }

    /* renamed from: a */
    private static void m28438a(long[] jArr, int i, long[] jArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i + i4;
            jArr[i5] = jArr[i5] ^ jArr2[i2 + i4];
        }
    }

    /* renamed from: a */
    private static void m28439a(long[] jArr, int i, long[] jArr2, int i2, long[] jArr3, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            jArr3[i3 + i5] = jArr[i + i5] ^ jArr2[i2 + i5];
        }
    }

    /* renamed from: b */
    private static void m28446b(long[] jArr, int i, long[] jArr2, int i2, long[] jArr3, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i + i5;
            jArr[i6] = jArr[i6] ^ (jArr2[i2 + i5] ^ jArr3[i3 + i5]);
        }
    }

    /* renamed from: a */
    private static void m28435a(long[] jArr, int i, int i2, long j) {
        i += i2 >>> 6;
        i2 &= 63;
        if (i2 == 0) {
            jArr[i] = jArr[i] ^ j;
            return;
        }
        jArr[i] = jArr[i] ^ (j << i2);
        i2 = j >>> (64 - i2);
        if (i2 != 0) {
            i++;
            jArr[i] = i2 ^ jArr[i];
        }
    }

    /* renamed from: g */
    public boolean m28468g() {
        return this.f23105g.length > 0 && (this.f23105g[0] & 1) != 0;
    }

    /* renamed from: a */
    private static boolean m28440a(long[] jArr, int i, int i2) {
        return (jArr[i + (i2 >>> 6)] & (1 << (i2 & 63))) != 0 ? 1 : null;
    }

    /* renamed from: b */
    private static void m28444b(long[] jArr, int i, int i2) {
        i += i2 >>> 6;
        jArr[i] = jArr[i] ^ (1 << (i2 & 63));
    }

    /* renamed from: a */
    private static void m28432a(long j, long[] jArr, int i, long[] jArr2, int i2) {
        int i3 = i;
        long[] jArr3 = jArr2;
        int i4 = i2;
        if ((j & 1) != 0) {
            m28438a(jArr3, i4, jArr, 0, i3);
        } else {
            long[] jArr4 = jArr;
        }
        int i5 = 1;
        long j2 = j;
        while (true) {
            long j3 = j2 >>> 1;
            if (j3 != 0) {
                if ((j3 & 1) != 0) {
                    j2 = m28443b(jArr2, i2, jArr, 0, i, i5);
                    if (j2 != 0) {
                        int i6 = i4 + i3;
                        jArr3[i6] = j2 ^ jArr3[i6];
                    }
                }
                i5++;
                j2 = j3;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public LongArray m28455a(LongArray longArray, int i, int[] iArr) {
        int i2 = i;
        int[] iArr2 = iArr;
        int d = m28464d();
        if (d == 0) {
            return this;
        }
        int d2 = longArray.m28464d();
        if (d2 == 0) {
            return longArray;
        }
        LongArray longArray2;
        LongArray longArray3;
        if (d > d2) {
            longArray2 = this;
            longArray3 = longArray;
            int i3 = d2;
            d2 = d;
            d = i3;
        } else {
            longArray3 = this;
            longArray2 = longArray;
        }
        int i4 = (d + 63) >>> 6;
        int i5 = (d2 + 63) >>> 6;
        d = ((d + d2) + 62) >>> 6;
        if (i4 == 1) {
            long j = longArray3.f23105g[0];
            if (j == 1) {
                return longArray2;
            }
            long[] jArr = new long[d];
            m28432a(j, longArray2.f23105g, i5, jArr, 0);
            return m28431a(jArr, 0, d, i2, iArr2);
        }
        long[] jArr2;
        d2 = ((d2 + 7) + 63) >>> 6;
        int[] iArr3 = new int[16];
        long[] jArr3 = new long[(d2 << 4)];
        iArr3[1] = d2;
        System.arraycopy(longArray2.f23105g, 0, jArr3, d2, i5);
        int i6 = 2;
        int i7 = d2;
        while (i6 < 16) {
            i7 += d2;
            iArr3[i6] = i7;
            if ((i6 & 1) == 0) {
                jArr2 = jArr3;
                m28430a(jArr3, i7 >>> 1, jArr3, i7, d2, 1);
            } else {
                jArr2 = jArr3;
                m28439a(jArr2, d2, jArr3, i7 - d2, jArr2, i7, d2);
            }
            i6++;
            jArr3 = jArr2;
        }
        jArr2 = jArr3;
        long[] jArr4 = new long[jArr2.length];
        m28430a(jArr2, 0, jArr4, 0, jArr2.length, 4);
        long[] jArr5 = longArray3.f23105g;
        long[] jArr6 = new long[(d << 3)];
        for (int i8 = 0; i8 < i4; i8++) {
            long j2 = jArr5[i8];
            int i9 = i8;
            while (true) {
                j2 >>>= 4;
                int i10 = ((int) j2) & 15;
                long j3 = j2;
                m28446b(jArr6, i9, jArr2, iArr3[((int) j2) & 15], jArr4, iArr3[i10], d2);
                j2 = j3 >>> 4;
                if (j2 == 0) {
                    break;
                }
                i9 += d;
            }
        }
        d2 = jArr6.length;
        while (true) {
            d2 -= d;
            if (d2 == 0) {
                return m28431a(jArr6, 0, d, i2, iArr2);
            }
            m28443b(jArr6, d2 - d, jArr6, d2, d, 8);
        }
    }

    /* renamed from: b */
    public LongArray m28460b(LongArray longArray, int i, int[] iArr) {
        int d = m28464d();
        if (d == 0) {
            return this;
        }
        int d2 = longArray.m28464d();
        if (d2 == 0) {
            return longArray;
        }
        LongArray longArray2;
        LongArray longArray3;
        if (d > d2) {
            longArray2 = this;
            longArray3 = longArray;
            int i2 = d2;
            d2 = d;
            d = i2;
        } else {
            longArray3 = this;
            longArray2 = longArray;
        }
        int i3 = (d + 63) >>> 6;
        int i4 = (d2 + 63) >>> 6;
        d = ((d + d2) + 62) >>> 6;
        if (i3 == 1) {
            long j = longArray3.f23105g[0];
            if (j == 1) {
                return longArray2;
            }
            long[] jArr = new long[d];
            m28432a(j, longArray2.f23105g, i4, jArr, 0);
            return new LongArray(jArr, 0, d);
        }
        long[] jArr2;
        d2 = ((d2 + 7) + 63) >>> 6;
        int[] iArr2 = new int[16];
        long[] jArr3 = new long[(d2 << 4)];
        iArr2[1] = d2;
        System.arraycopy(longArray2.f23105g, 0, jArr3, d2, i4);
        int i5 = 2;
        int i6 = d2;
        while (i5 < 16) {
            i6 += d2;
            iArr2[i5] = i6;
            if ((i5 & 1) == 0) {
                jArr2 = jArr3;
                m28430a(jArr3, i6 >>> 1, jArr3, i6, d2, 1);
            } else {
                jArr2 = jArr3;
                m28439a(jArr2, d2, jArr2, i6 - d2, jArr3, i6, d2);
            }
            i5++;
            jArr3 = jArr2;
        }
        jArr2 = jArr3;
        long[] jArr4 = new long[jArr2.length];
        m28430a(jArr2, 0, jArr4, 0, jArr2.length, 4);
        long[] jArr5 = longArray3.f23105g;
        long[] jArr6 = new long[(d << 3)];
        for (int i7 = 0; i7 < i3; i7++) {
            long j2 = jArr5[i7];
            int i8 = i7;
            while (true) {
                long j3 = j2 >>> 4;
                int i9 = ((int) j3) & 15;
                long j4 = j3;
                m28446b(jArr6, i8, jArr2, iArr2[((int) j2) & 15], jArr4, iArr2[i9], d2);
                j2 = j4 >>> 4;
                if (j2 == 0) {
                    break;
                }
                i8 += d;
            }
        }
        d2 = jArr6.length;
        while (true) {
            d2 -= d;
            if (d2 == 0) {
                return new LongArray(jArr6, 0, d);
            }
            m28443b(jArr6, d2 - d, jArr6, d2, d, 8);
        }
    }

    /* renamed from: a */
    public void m28456a(int i, int[] iArr) {
        Object obj = this.f23105g;
        i = m28442b(obj, 0, obj.length, i, iArr);
        if (i < obj.length) {
            this.f23105g = new long[i];
            System.arraycopy(obj, 0, this.f23105g, 0, i);
        }
    }

    /* renamed from: a */
    private static LongArray m28431a(long[] jArr, int i, int i2, int i3, int[] iArr) {
        return new LongArray(jArr, i, m28442b(jArr, i, i2, i3, iArr));
    }

    /* renamed from: b */
    private static int m28442b(long[] jArr, int i, int i2, int i3, int[] iArr) {
        long[] jArr2 = jArr;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        int[] iArr2 = iArr;
        int i7 = (i6 + 63) >>> 6;
        if (i5 < i7) {
            return i5;
        }
        int i8 = i5 << 6;
        int min = Math.min(i8, (i6 << 1) - 1);
        i8 -= min;
        int i9 = i5;
        while (i8 >= 64) {
            i9--;
            i8 -= 64;
        }
        int length = iArr2.length;
        int i10 = iArr2[length - 1];
        length = length > 1 ? iArr2[length - 2] : 0;
        int max = Math.max(i6, i10 + 64);
        i5 = (i8 + Math.min(min - max, i6 - length)) >> 6;
        if (i5 > 1) {
            int i11 = i9 - i5;
            m28445b(jArr, i, i9, i11, i3, iArr);
            while (i9 > i11) {
                i9--;
                jArr2[i4 + i9] = 0;
            }
            min = i11 << 6;
        }
        if (min > max) {
            m28434a(jArr, i, i9, max, i3, iArr);
        } else {
            max = min;
        }
        if (max > i6) {
            m28448c(jArr, i, max, i6, iArr2);
        }
        return i7;
    }

    /* renamed from: c */
    private static void m28448c(long[] jArr, int i, int i2, int i3, int[] iArr) {
        while (true) {
            i2--;
            if (i2 < i3) {
                return;
            }
            if (m28440a(jArr, i, i2)) {
                m28451d(jArr, i, i2, i3, iArr);
            }
        }
    }

    /* renamed from: d */
    private static void m28451d(long[] jArr, int i, int i2, int i3, int[] iArr) {
        m28444b(jArr, i, i2);
        i2 -= i3;
        i3 = iArr.length;
        while (true) {
            i3--;
            if (i3 >= 0) {
                m28444b(jArr, i, iArr[i3] + i2);
            } else {
                m28444b(jArr, i, i2);
                return;
            }
        }
    }

    /* renamed from: a */
    private static void m28434a(long[] jArr, int i, int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6 = i3 >>> 6;
        int i7 = i2;
        while (true) {
            int i8 = i7 - 1;
            if (i8 <= i6) {
                break;
            }
            i5 = i + i8;
            long j = jArr[i5];
            if (j != 0) {
                jArr[i5] = 0;
                m28436a(jArr, i, i8 << 6, j, i4, iArr);
            }
            i7 = i8;
        }
        i5 = i3 & 63;
        int i9 = i + i6;
        long j2 = jArr[i9] >>> i5;
        if (j2 != 0) {
            jArr[i9] = jArr[i9] ^ (j2 << i5);
            m28436a(jArr, i, i3, j2, i4, iArr);
        }
    }

    /* renamed from: a */
    private static void m28436a(long[] jArr, int i, int i2, long j, int i3, int[] iArr) {
        i2 -= i3;
        i3 = iArr.length;
        while (true) {
            i3--;
            if (i3 >= 0) {
                m28435a(jArr, i, iArr[i3] + i2, j);
            } else {
                m28435a(jArr, i, i2, j);
                return;
            }
        }
    }

    /* renamed from: b */
    private static void m28445b(long[] jArr, int i, int i2, int i3, int i4, int[] iArr) {
        int i5 = (i3 << 6) - i4;
        i4 = iArr.length;
        while (true) {
            i4--;
            if (i4 >= 0) {
                m28452d(jArr, i, jArr, i + i3, i2 - i3, i5 + iArr[i4]);
            } else {
                m28452d(jArr, i, jArr, i + i3, i2 - i3, i5);
                return;
            }
        }
    }

    /* renamed from: d */
    private static void m28452d(long[] jArr, int i, long[] jArr2, int i2, int i3, int i4) {
        i += i4 >>> 6;
        i4 &= 63;
        if (i4 == 0) {
            m28438a(jArr, i, jArr2, i2, i3);
            return;
        }
        jArr[i] = m28447c(jArr, i + 1, jArr2, i2, i3, 64 - i4) ^ jArr[i];
    }

    /* renamed from: b */
    public LongArray m28459b(int i, int[] iArr) {
        int c = m28462c();
        if (c == 0) {
            return this;
        }
        c <<= 1;
        long[] jArr = new long[c];
        int i2 = 0;
        while (i2 < c) {
            long j = this.f23105g[i2 >>> 1];
            int i3 = i2 + 1;
            jArr[i2] = m28450d((int) j);
            i2 = i3 + 1;
            jArr[i3] = m28450d((int) (j >>> 32));
        }
        return new LongArray(jArr, 0, m28442b(jArr, 0, jArr.length, i, iArr));
    }

    /* renamed from: a */
    public LongArray m28454a(int i, int i2, int[] iArr) {
        int c = m28462c();
        if (c == 0) {
            return this;
        }
        long[] jArr = new long[(((i2 + 63) >>> 6) << 1)];
        System.arraycopy(this.f23105g, 0, jArr, 0, c);
        while (true) {
            i--;
            if (i < 0) {
                return new LongArray(jArr, 0, c);
            }
            m28437a(jArr, c, i2, iArr);
            c = m28442b(jArr, 0, jArr.length, i2, iArr);
        }
    }

    /* renamed from: c */
    public LongArray m28463c(int i, int[] iArr) {
        i = m28462c();
        if (i == 0) {
            return this;
        }
        i <<= 1;
        iArr = new long[i];
        int i2 = 0;
        while (i2 < i) {
            long j = this.f23105g[i2 >>> 1];
            int i3 = i2 + 1;
            iArr[i2] = m28450d((int) j);
            i2 = i3 + 1;
            iArr[i3] = m28450d((int) (j >>> 32));
        }
        return new LongArray(iArr, 0, iArr.length);
    }

    /* renamed from: a */
    private static void m28437a(long[] jArr, int i, int i2, int[] iArr) {
        i2 = i << 1;
        while (true) {
            i--;
            if (i >= 0) {
                long j = jArr[i];
                i2--;
                jArr[i2] = m28450d((int) (j >>> 32));
                i2--;
                jArr[i2] = m28450d((int) j);
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    private static long m28450d(int i) {
        int i2 = f23100b[i & JfifUtil.MARKER_FIRST_BYTE] | (f23100b[(i >>> 8) & JfifUtil.MARKER_FIRST_BYTE] << 16);
        return ((((long) ((f23100b[i >>> 24] << 16) | f23100b[(i >>> 16) & JfifUtil.MARKER_FIRST_BYTE])) & 4294967295L) << 32) | (4294967295L & ((long) i2));
    }

    /* renamed from: d */
    public LongArray m28465d(int i, int[] iArr) {
        int d = m28464d();
        if (d == 0) {
            throw new IllegalStateException();
        } else if (d == 1) {
            return this;
        } else {
            LongArray longArray = (LongArray) clone();
            int i2 = (i + 63) >>> 6;
            m28451d(new LongArray(i2).f23105g, 0, i, i, iArr);
            new LongArray(i2).f23105g[0] = 1;
            LongArray longArray2 = new LongArray(i2);
            int[] iArr2 = new int[]{d, i + 1};
            i = new LongArray[]{longArray, r4};
            int[] iArr3 = new int[]{1, 0};
            LongArray[] longArrayArr = new LongArray[]{iArr, longArray2};
            iArr = iArr2[1];
            int i3 = iArr - iArr2[0];
            int i4 = iArr3[1];
            i2 = iArr;
            iArr = 1;
            while (true) {
                if (i3 < 0) {
                    i3 = -i3;
                    iArr2[iArr] = i2;
                    iArr3[iArr] = i4;
                    iArr = 1 - iArr;
                    i2 = iArr2[iArr];
                    i4 = iArr3[iArr];
                }
                int i5 = 1 - iArr;
                i[iArr].m28433a(i[i5], iArr2[i5], i3);
                int b = i[iArr].m28441b(i2);
                if (b == 0) {
                    return longArrayArr[i5];
                }
                int i6 = iArr3[i5];
                longArrayArr[iArr].m28433a(longArrayArr[i5], i6, i3);
                i6 += i3;
                if (i6 > i4) {
                    i4 = i6;
                } else if (i6 == i4) {
                    i4 = longArrayArr[iArr].m28441b(i4);
                }
                i3 += b - i2;
                i2 = b;
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LongArray)) {
            return false;
        }
        LongArray longArray = (LongArray) obj;
        int c = m28462c();
        if (longArray.m28462c() != c) {
            return false;
        }
        for (int i = 0; i < c; i++) {
            if (this.f23105g[i] != longArray.f23105g[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int c = m28462c();
        int i = 1;
        for (int i2 = 0; i2 < c; i2++) {
            long j = this.f23105g[i2];
            i = (((i * 31) ^ ((int) j)) * 31) ^ ((int) (j >>> 32));
        }
        return i;
    }

    public Object clone() {
        return new LongArray(Arrays.m29364a(this.f23105g));
    }

    public String toString() {
        int c = m28462c();
        if (c == 0) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        c--;
        StringBuffer stringBuffer = new StringBuffer(Long.toBinaryString(this.f23105g[c]));
        while (true) {
            c--;
            if (c < 0) {
                return stringBuffer.toString();
            }
            String toBinaryString = Long.toBinaryString(this.f23105g[c]);
            int length = toBinaryString.length();
            if (length < 64) {
                stringBuffer.append("0000000000000000000000000000000000000000000000000000000000000000".substring(length));
            }
            stringBuffer.append(toBinaryString);
        }
    }
}
