/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp.soluction.demo.util;

import java.util.List;
import java.util.Random;

/**
 * 城市距离类，保存城市间的距离，初始化后不再改变
 *
 * @author weangdan
 */
public class DistanceUtil {

    private static double distance[][];
    private static int num;
    Random random = new Random();
    private int min = 2;
    private int max = 100;

    public DistanceUtil(int num, boolean ifDuichen) {
        this.num = num;
        initDistance(num);
    }

    public static double[][] initDistance(int cityNum) {
        num = cityNum;
//        distance = new double[num][num];
//        //distance是一个对称阵，且对角元素设为无穷大；对角线元素不会被用到，如果算法正确
//        for (int i = 0; i < num; i++) {
//            if (ifDuichen) {
//                for (int j = i; j < num; j++) {
//                    if (i == j) {
//                        distance[i][j] = 0;
//                    } else {
//                        distance[i][j] = distance[j][i] = min + ((max - min) * random.nextDouble()); //产生2-100之间的随机浮点数
//                    }
//                }
//            } else {
//                for (int j = 0; j < num; j++) {
//                    if (i == j) {
//                        distance[i][j] = Double.MAX_VALUE;
//                    } else {
//                        distance[i][j] = min + ((max - min) * random.nextDouble()); //产生2-100之间的随机浮点数
//                    }
//                }
//
//            }
//        }
//        distance = new double[][]{{0.0, 62.688755870316974, 99.89436511341816, 41.89630850035449, 55.364490449768276, 76.4666914372237, 81.03885335195375, 80.22198949566219, 84.31650530983178, 85.57835262526116, 27.878880500789187, 36.7050211664927, 86.88914177279167, 96.38409490113175, 81.82668214369178, 27.26744172489623, 73.93440799566099, 71.84647901799423, 69.611799392534, 31.632382130342265, 32.83000938960603, 76.7595542749642, 94.70014186230357, 7.475660593284674, 16.8974237850573, 63.30046958922474, 47.71866896129891, 60.58775215944333, 52.39570403444055, 65.9049353242746},
//                {8.952165660354149, 0.0, 17.181406206913913, 47.705348269261776, 58.626291897813694, 25.589946722510426, 76.66969836632704, 14.209101261738226, 32.858557675807525, 41.0740269921114, 16.991226010949344, 7.331677120001479, 78.58715711598926, 13.636813520581999, 45.873647233055536, 13.217970537158894, 44.17662661905514, 13.91501001515386, 84.30365272870273, 91.60936416101065, 80.11284706224298, 43.38790695374147, 42.91099212760944, 46.620355797143624, 83.08806722674535, 54.311935239431335, 45.976050203539906, 46.32278821490471, 96.3501291605989, 21.809817565529514},
//                {95.33497906680658, 31.31254953128176, 0.0, 96.33308062435216, 75.82133109322805, 15.583344192181388, 63.76368407351687, 24.244520196176524, 76.73416421044918, 36.66863497264903, 95.86744731487632, 94.50570755626649, 43.68708917059777, 50.2140142528372, 92.00888676496848, 73.72374772087522, 70.77402593785285, 45.730114017922226, 26.55113579830219, 58.22075485640594, 5.676409163015426, 8.248599110023294, 74.67769046546712, 75.05321013773069, 23.612589880804073, 25.850728498413716, 5.385474064747886, 14.92536339948988, 72.91682962087167, 28.066079226833825},
//                {37.42663107047457, 79.43373685757254, 71.046784462274, 0.0, 20.181001129259766, 98.76452355340582, 87.67554758526667, 69.36718048398751, 14.12342912514582, 39.93950764621937, 8.411975112024846, 83.66874499274331, 61.780024917023646, 95.63262515801748, 47.69800756678336, 63.055254256932415, 69.35363527993918, 36.67045834760828, 52.17371138789115, 72.56790214611927, 37.68349013987772, 44.73192101544349, 83.05753916388646, 76.71501935565576, 15.327522509034328, 8.097896531472045, 13.290446035239793, 83.93651045160537, 72.6456317304326, 2.9271582924808133},
//                {12.25033610163182, 43.95617323137197, 86.12468103364603, 62.74713068292498, 0.0, 30.989510760308374, 72.96143868518075, 2.750461704683821, 79.1155790570088, 76.04352630840118, 23.598859528366155, 6.358814496192013, 38.73946293142087, 49.51808041260391, 75.8850195840899, 61.58755964585572, 20.72968462117409, 95.38121573885306, 23.306366595896574, 58.30281352342196, 20.125602186951728, 24.671350523394928, 43.61778879972598, 26.187764712062698, 64.34073904571932, 79.67738364697648, 82.14860167442825, 25.55888607365898, 71.76118156187367, 45.055222512932396},
//                {96.78590832183765, 72.41406189080382, 92.37076587579055, 4.315937091749292, 12.229169028727359, 0.0, 59.21902506104165, 68.98220223582541, 59.15379065845958, 26.5960947974028, 48.00297457246452, 42.42089184497535, 28.678219680157483, 86.00885730040417, 88.96116567010877, 32.83822920691146, 99.77196470862172, 26.400876453218398, 69.95179340384301, 32.223831776535974, 98.51830350462717, 60.45835193976708, 12.026310663144013, 34.141120927986506, 59.92350690304109, 57.34695888692023, 85.44694254152161, 59.728338482156396, 57.0063687716655, 29.672986021300986},
//                {75.52195199844519, 28.08713360450756, 58.73483553659039, 77.98955775285606, 78.02878478998181, 44.3234053157557, 0.0, 41.2604993486051, 56.08233288996583, 9.997101379309477, 5.710207708281903, 10.434878938228527, 60.25547057580016, 77.18819668071582, 19.710078039747167, 83.68717170944315, 62.88746197435407, 4.734238337662941, 88.92422856306537, 72.00129476593003, 12.637712861872165, 36.09022154864575, 19.428633724862443, 17.95079690341646, 24.858676547197664, 73.70349066259668, 24.41210141339916, 43.533393249339156, 60.004555723612214, 58.62010902723926},
//                {4.548998674215197, 29.89258353526365, 29.126530674086183, 69.62435942852208, 6.119430642169364, 33.92203328179589, 65.90572374429766, 0.0, 11.447046828161975, 11.532149219742594, 62.21906604752117, 96.09894048010165, 80.08029394116812, 76.61064281812011, 24.886855548855728, 71.75862753645508, 31.300914401405784, 36.77038563562122, 30.28059330960946, 67.13720961009572, 82.13144711005546, 86.04532206425475, 8.951104801342229, 9.797397751378723, 32.15736215126248, 80.8142193660116, 86.76009478825085, 86.12379350435464, 10.370902692689233, 56.03262736478875},
//                {49.4244178727214, 13.167551915352073, 65.52651440733527, 15.79374117686395, 99.59244778009423, 70.55457052423763, 45.8696998080072, 36.12154788892137, 0.0, 26.963843421817742, 25.0491053889546, 79.54065166709739, 42.04223452431682, 79.93472574308649, 22.28848616847739, 75.95596295793347, 35.184853536422594, 37.78341815952161, 79.19093372997266, 97.0361140871092, 74.42990832083359, 87.507694286723, 14.58734790676805, 43.27345638316264, 46.45452379910756, 81.08262176258854, 2.7392072483362555, 93.32482189803237, 49.41548491548939, 27.128802000656037},
//                {88.57859817301372, 85.06486003967112, 13.466485127389932, 49.7640213601994, 60.74270138281623, 54.85065399039564, 32.32352696159283, 68.75703779289243, 22.773868600354223, 0.0, 74.12509989506123, 98.67245814990845, 83.01039932026276, 68.21780295774657, 38.426040187621496, 8.855266003860827, 95.86992893286427, 41.776132087987925, 59.37002179950925, 72.97673690369281, 89.7917007766199, 8.156018139977188, 75.24406467534902, 53.34077922032856, 41.49300693103277, 26.808275496144425, 90.46575112246282, 98.95569193082302, 20.87209535429081, 24.35679558290981},
//                {82.36139448461957, 22.74029102419427, 55.70205122799802, 9.195885464049063, 91.46402083844619, 11.017856637050292, 41.387494645019785, 34.46849029205844, 66.84733706937234, 7.902464214703472, 0.0, 60.91842687242053, 48.43707525833091, 80.88879638013834, 2.262336927193896, 74.56377243006048, 17.120260524437064, 50.294366431307786, 54.08741722364237, 39.81782689088426, 70.99216340063813, 80.21951133882874, 66.2934363698425, 73.6461058689336, 91.52771230386273, 47.88539189613349, 39.262376686116454, 73.17272019571259, 74.42600204547975, 57.21621531461046},
//                {74.74924201727254, 51.609629889329675, 22.455135705616115, 68.7131184862898, 35.17767778700605, 51.448838368730364, 48.03579287286299, 79.03195748845529, 43.802025895110376, 98.72180766359486, 61.91709419109448, 0.0, 30.546778105268253, 30.731004818166245, 86.47600289714057, 63.59717897470536, 90.55771817088402, 69.38826204941843, 54.52680213689883, 65.50222063793862, 94.74157974846325, 77.62763769921658, 28.01359334244831, 34.36144246786508, 31.94518634388492, 23.426057943650477, 93.32213831820324, 19.702021504898056, 89.48616306676826, 80.84453191302381},
//                {42.53100109785752, 36.93660580480845, 53.75271224440247, 9.777841712099667, 76.69799752121078, 45.12748217389383, 46.08336918048253, 48.90605383080463, 22.02334950083703, 57.1852657846008, 24.659745418716486, 55.21609018930349, 0.0, 59.209447139394626, 22.99632382905489, 75.45966199025233, 75.47915725900806, 25.182793559534723, 5.771954584455368, 99.19505881991469, 83.14991950779294, 45.75191282491415, 94.77368228032387, 90.59850000963122, 34.295850198709914, 57.74575088495545, 89.49285608436982, 21.424083250760056, 66.3703604216517, 63.710220750694155},
//                {75.34905690093763, 3.0929561882952, 71.91072961795304, 71.33632962738307, 81.02067691618281, 59.04066075588161, 83.57212189435043, 69.45148834935442, 58.63231541967292, 66.51292882975486, 67.30140913258813, 6.626280913784771, 72.19750270005115, 0.0, 18.808530313236837, 28.909649775027106, 17.23223574783776, 10.95158740386796, 83.7822330408739, 73.81968238001286, 25.131805108328102, 28.50842356638522, 70.79785661924488, 22.345305276228267, 51.089957593107826, 92.13584896771876, 42.26089318217254, 59.50116447363434, 20.467507996002144, 92.86877475953793},
//                {77.36210728581288, 45.04746642649782, 20.789528217921603, 38.665005986369565, 60.727945470461464, 30.241304703278967, 72.37781795755097, 83.35777861175542, 27.30061625945967, 92.5963750203577, 95.39472146099104, 83.77029806453278, 6.96007193294162, 76.84551798047274, 0.0, 3.3661784896332465, 84.03140812819372, 84.15211906652333, 7.255525667654618, 58.5351633287715, 33.867837111569365, 51.10136537227602, 9.461293876441946, 44.242346852652105, 34.447301550766255, 56.06457505979274, 37.06643625842612, 87.9390331305656, 5.208084517842913, 14.519556033808279},
//                {31.400065069131617, 33.40808180342307, 70.03450652268337, 79.18660388949256, 58.02456358819974, 64.30182324245433, 77.12407713349396, 4.3439755392565855, 8.856653888462075, 87.20154900465296, 57.94089417380216, 19.025846262864018, 26.094255301018013, 65.06148116346978, 62.76123159993889, 0.0, 46.38063185731475, 13.534133537888351, 19.12075992545809, 31.491053145394368, 18.719544818524035, 36.320448593649914, 19.150214083088542, 34.67152482257304, 79.59964531999772, 37.681873760970866, 4.246354570972481, 16.88745787456625, 41.6626778147088, 56.79503385408648},
//                {51.293312480520896, 13.154863341373467, 33.89038659810261, 39.55462870557191, 11.684021220410202, 24.287743791801763, 4.438940727427628, 17.735609011076015, 30.925272244717323, 91.73045326086213, 31.279643311097, 31.8004404051709, 60.34689490837952, 19.890885942333803, 62.49990626716249, 78.4344909266571, 0.0, 99.29354043882124, 44.62100759130266, 89.3080970420969, 47.78520175693193, 45.898246082735184, 14.165118795913143, 47.53765571966829, 37.33577313209476, 52.82019559473619, 33.632556662706726, 3.7604454649718786, 41.36166044774248, 67.17472450729225},
//                {33.850360898619314, 19.996214309979912, 10.99825462023476, 91.29187962981015, 38.31272693964244, 14.444469608162255, 94.09071866021019, 48.91054212822084, 63.868020829598706, 4.667090066593431, 24.20202680421095, 73.94827985863833, 67.77025024763604, 40.21437000989253, 54.42278591465897, 30.082856321660564, 69.77094738621733, 0.0, 39.81422332943579, 97.95657767289455, 37.039493525281614, 3.0385548661783988, 95.93366667826731, 11.847055212406204, 61.69867809866539, 39.86635446062876, 28.773682156278504, 94.66817323721524, 46.92256675749016, 99.36624357838456},
//                {20.573007785484336, 93.51646494746068, 54.34363312929535, 10.644533912070834, 83.47338229509074, 74.22436434538949, 35.2675454793276, 66.31723930709875, 2.138152073217813, 55.35619119643141, 38.31285562239509, 63.646167183655166, 15.818192532478598, 77.25341765950132, 91.44331485049031, 58.063461109887896, 77.6234852317015, 46.16348469492698, 0.0, 49.64437724024985, 12.40104969812028, 87.38567268895927, 40.31649039535248, 45.6535786416985, 70.75280459130425, 44.686350562859936, 27.706626285016135, 55.875265529167486, 90.57103367021386, 56.37782478545355},
//                {82.29035126881104, 42.89326752712069, 50.33525080654434, 70.23751841232871, 62.330859681600316, 65.84087769596161, 56.93001578284216, 53.274124365981095, 53.698465060104986, 10.295687544578971, 98.72992955602456, 51.643117759969655, 78.07910089776033, 4.337490782796517, 37.31376003135751, 79.13115043760594, 9.248260032898923, 60.94074224406738, 92.71591806574395, 0.0, 24.733302612581767, 97.83519920888412, 34.968680641781006, 78.17240189735793, 40.97415183783576, 54.33237882599086, 79.69451568015327, 14.429629429073245, 17.31302842955371, 81.49763734462316},
//                {78.99569542847706, 16.85840006119218, 9.225834173147769, 98.75173570525244, 93.1505388164404, 62.851562312801136, 25.37019005060857, 24.691402709226967, 46.51219382523968, 24.28280006846692, 14.617691265864323, 75.41818444443399, 12.243066656293005, 32.165255350723214, 29.67646934058135, 2.025894684439413, 66.76363095155553, 44.072576889905974, 98.52919811011104, 30.29461023041762, 0.0, 6.602647049056457, 15.371240362468694, 92.97619732183381, 63.406669180412024, 28.931600108960676, 2.8619025359359425, 81.20016371858928, 4.330272496404133, 50.22432089864112},
//                {8.038809344731138, 14.45854469187253, 14.408819044539937, 23.203469539785974, 44.8501253795846, 6.761574733876731, 44.6491894437528, 44.51876758076528, 29.5784222296587, 2.708330163480129, 18.21981558885325, 62.447590950563765, 68.25930077765405, 92.5302318367726, 20.749381663920204, 87.31666885144595, 51.91755502427524, 30.830805064496285, 41.15962809979218, 37.31442847138417, 21.824047231087818, 0.0, 14.51248280959587, 23.970810160787988, 88.89666127511494, 29.962785389255174, 69.94568830126371, 10.285910813310581, 98.08390159564344, 91.94659030935786},
//                {31.562391524954815, 94.9897918674514, 18.607149724791615, 58.73097295331818, 89.74577580550135, 28.092098314313827, 15.079231628763646, 33.64976492900593, 7.139616781463522, 8.597708243522474, 32.15229430029525, 20.532295643878598, 13.315429965366587, 13.806208335415441, 13.967670618683412, 58.960798052536035, 56.11235997115983, 65.52185649129717, 48.11251842308861, 70.08799421911759, 33.90429871596036, 27.298158596644186, 0.0, 20.768350455559208, 36.85870884207028, 2.5506430874332198, 43.54619107224885, 32.76980007290963, 95.96561329791784, 59.851507726700476},
//                {8.103419295949754, 57.887608478612904, 55.41810233407987, 52.955279709001445, 50.68983645894435, 22.80810779776432, 45.21456551733764, 18.35570675756364, 38.57081154292343, 49.00209518215686, 31.282201701329896, 17.86780996078416, 89.7011282958842, 17.959257335418314, 82.58481660610371, 29.286240637426687, 10.642266774169652, 59.109968517592385, 94.09789443819244, 25.306740912662416, 67.62504272981357, 96.16451762090003, 70.21152457521173, 0.0, 72.73077555568169, 50.27235087133287, 60.570491335766185, 68.0456587100168, 9.975378750266913, 48.70176597190706},
//                {50.32228071646857, 34.14842424270173, 72.47468689804347, 39.99537605194135, 6.452344498206708, 23.09712110753372, 88.68660659145127, 83.35429963006196, 26.192098883067622, 74.63278664291309, 68.10752106380141, 34.64790498422933, 37.01097439209563, 71.13310547557042, 36.94985850490526, 48.522826857897975, 39.52541428207218, 63.464743807129096, 74.95184260653278, 57.75446654531484, 81.61527058388769, 56.5549656759964, 26.165664779114234, 57.10371806508902, 0.0, 96.9932721136819, 84.38383548172122, 39.5097886275689, 44.58428256279582, 4.943909140042817},
//                {11.52200719240934, 3.3730460139248555, 58.75094869582391, 23.981353633121604, 48.825523731132314, 28.6226322721918, 36.38685051463386, 98.77164347680268, 16.447830595110887, 19.99507194021469, 22.797772042333296, 86.82263518429741, 79.9405487854172, 31.038667765812974, 68.81413990844473, 79.16590236265323, 90.88839520246906, 18.52790415886907, 60.556424711377986, 91.53796661281206, 48.25991661925123, 48.58473563372041, 6.0372670293010575, 65.41394699897259, 78.45462062392248, 0.0, 60.61863213315049, 64.75370698047908, 55.654910975676025, 96.88830765408149},
//                {2.6367041924303987, 86.56544739610995, 83.50095045329037, 3.8823310921353085, 44.47721797487955, 36.36024705853179, 86.17513379851951, 98.60876643523667, 84.0842047816797, 31.27500080637223, 51.45929152928695, 32.89236684096995, 42.06786592992488, 39.57123672581595, 61.26067722623009, 29.781437580492973, 43.484943396507035, 76.65628935680171, 72.40937158619171, 71.97366670662969, 59.025100706674294, 24.19648752667437, 31.709399286094904, 36.41919835987177, 58.603910283637184, 68.78632754192323, 0.0, 3.6122763281415327, 49.72213963722611, 4.739919473496873},
//                {73.2175796565774, 28.78993040298108, 70.32296415552047, 59.03277146330062, 30.034951389540055, 38.354581584118726, 83.86812417702528, 96.56127611337672, 89.76996366919815, 47.50642811579015, 75.65952081223654, 96.08479075650759, 49.01227770346331, 43.985646273579846, 56.625279166119014, 84.55825160937472, 20.30777911349088, 18.863455118914672, 64.86465793701518, 58.660571390007796, 14.765345483492501, 29.927655800706553, 7.493677705969732, 19.788197625218018, 69.20923635341619, 99.20129443499359, 35.25444328520026, 0.0, 98.27992414001119, 34.731694688217324},
//                {27.978778786626254, 33.149946901418616, 21.51616699604406, 90.58035999767924, 61.17200566814427, 94.22742616459917, 14.975204388354873, 48.45772402980389, 43.72971717614228, 74.5572582866659, 51.33097295536645, 13.514908795378382, 25.42655585820399, 9.440610725298692, 94.24139511575859, 15.58962896622014, 76.41396954906429, 93.92797566812483, 40.60314043246334, 45.568285758225436, 92.58330186935376, 70.84198487607196, 29.738278936010737, 23.144727262689308, 33.01213513287723, 90.67177186307043, 56.2301051192368, 11.703245333508535, 0.0, 85.54816878601052},
//                {79.94243912370085, 38.939988608394735, 73.57101636708335, 72.93054256915138, 17.96204662247598, 18.11395795811797, 52.46522526144038, 48.756831185793565, 68.20986472688911, 71.42725941796138, 25.602722510846615, 82.07454042247149, 78.05342435989796, 74.31703160735773, 29.645096068081607, 19.409188460997612, 98.96827495312974, 90.01769841644847, 86.419699653143, 37.63675757946513, 36.98317346684174, 20.340673995476255, 10.18714925606984, 60.266475375752506, 59.68472057627968, 19.429371278589404, 24.118475417818306, 11.420634749020508, 45.789352852274504, 0.0},
//
//        };
        distance = new double[][]{
                {0.0, 18.68, 17.84, 32.91, 12.88, 21.53, 21.65, 24.01, 24.13, 32.77, 19.65, 26.18, 23.76, 10.1, 8.11, 8.53, 27.87, 43.45, 57.09, 27.83, 20.16, 33.51, 43.6, 50.06, 54.13, 38.58, 27.46, 26.24, 39.73, 29.72},
                {18.55, 0.0, 5.85, 48.29, 6.29, 4.22, 5.51, 6.78, 10.86, 40.77, 30.56, 22.39, 19.97, 16.84, 13.71, 10.54, 20.09, 27.42, 48.23, 12.7, 14.76, 21.79, 35.46, 33.53, 40.14, 23.93, 23.89, 13.71, 31.05, 13.18},
                {17.63, 5.81, 0.0, 43.03, 5.38, 8.64, 6.95, 11.11, 9.96, 35.5, 25.3, 17.12, 14.7, 12.26, 12.79, 9.62, 23.72, 31.06, 51.86, 16.33, 17.2, 25.43, 39.09, 37.16, 43.78, 27.57, 26.95, 17.34, 34.68, 15.94},
                {32.73, 48.28, 42.97, 0.0, 42.02, 51.11, 49.42, 53.58, 48.26, 20.56, 18.53, 30.91, 37.06, 32.9, 35.4, 38.72, 59.65, 73.52, 88.87, 58.8, 51.94, 65.29, 75.38, 79.63, 86.25, 70.03, 59.25, 58.02, 71.51, 58.41},
                {12.73, 6.43, 5.59, 42.01, 0.0, 9.28, 9.39, 11.75, 12.21, 34.48, 24.27, 20.51, 18.09, 11.03, 7.89, 4.72, 21.71, 31.69, 52.16, 16.97, 13.99, 26.07, 39.4, 37.8, 44.42, 28.2, 23.74, 17.98, 34.98, 17.46},
                {21.41, 4.24, 8.57, 51.01, 9.16, 0.0, 5.76, 2.3, 10.82, 43.48, 33.28, 25.1, 21.47, 19.71, 16.58, 13.41, 15.83, 23.17, 43.97, 8.45, 10.51, 17.54, 31.21, 29.27, 35.89, 19.68, 19.64, 9.46, 26.79, 10.05},
                {21.65, 5.46, 7.0, 49.44, 9.39, 5.32, 0.0, 6.93, 6.87, 41.17, 31.71, 23.53, 17.82, 18.67, 16.81, 13.64, 19.54, 26.67, 47.68, 12.15, 14.21, 21.25, 34.91, 32.77, 39.6, 23.39, 23.34, 13.16, 30.5, 10.36},
                {23.47, 6.83, 10.62, 53.06, 11.22, 2.21, 7.0, 0.0, 12.07, 45.54, 35.33, 27.16, 23.99, 21.77, 18.63, 15.46, 13.45, 20.78, 41.59, 6.06, 8.12, 15.16, 28.82, 26.89, 33.51, 17.29, 17.25, 7.07, 24.41, 9.74},
                {24.09, 11.26, 9.98, 47.72, 12.09, 10.39, 6.75, 12.0, 0.0, 36.05, 29.99, 18.74, 12.7, 16.95, 17.18, 16.06, 24.51, 29.83, 52.65, 16.56, 19.28, 26.22, 39.88, 35.94, 44.58, 24.68, 28.41, 18.23, 35.47, 12.75},
                {32.64, 40.93, 35.62, 20.49, 34.67, 43.76, 41.05, 46.23, 35.95, 0.0, 12.83, 19.38, 25.63, 28.3, 31.23, 32.13, 54.75, 65.08, 85.21, 51.45, 47.03, 60.55, 72.44, 71.19, 78.9, 59.94, 56.97, 52.46, 68.03, 48.0},
                {19.45, 30.78, 25.47, 18.45, 24.52, 33.61, 31.92, 36.08, 30.76, 12.82, 0.0, 13.41, 19.56, 18.08, 20.57, 21.98, 44.6, 56.03, 75.6, 41.3, 36.88, 50.4, 62.11, 62.13, 68.75, 52.54, 45.98, 42.31, 58.24, 40.91},
                {26.15, 22.47, 17.17, 30.88, 20.63, 25.3, 23.62, 27.78, 18.75, 19.5, 13.37, 0.0, 8.43, 17.07, 20.0, 18.12, 40.39, 47.89, 68.53, 33.0, 32.99, 42.1, 55.76, 53.99, 60.44, 44.23, 42.74, 34.01, 51.35, 30.81},
                {23.61, 20.64, 14.63, 37.13, 18.08, 21.58, 17.76, 23.96, 12.65, 25.77, 19.62, 8.46, 0.0, 14.53, 17.46, 15.57, 36.47, 41.79, 64.61, 28.51, 30.44, 38.18, 51.84, 47.89, 56.54, 36.64, 40.37, 30.19, 47.43, 24.71},
                {9.89, 17.07, 12.14, 32.89, 11.27, 19.93, 18.59, 22.4, 16.88, 28.18, 18.08, 17.04, 14.62, 0.0, 3.6, 6.92, 29.74, 42.34, 58.96, 27.62, 22.03, 35.38, 45.47, 48.45, 55.07, 38.85, 29.34, 28.12, 41.6, 27.57},
                {8.09, 13.85, 13.01, 35.44, 8.05, 16.7, 16.82, 19.18, 17.16, 31.13, 20.63, 19.98, 17.56, 3.53, 0.0, 3.7, 27.01, 39.12, 56.23, 24.4, 19.29, 32.64, 42.73, 45.23, 51.84, 35.63, 26.6, 25.38, 38.86, 24.88},
                {8.52, 10.6, 9.76, 38.72, 4.79, 13.45, 13.57, 15.93, 16.03, 32.58, 22.38, 18.07, 15.65, 6.82, 3.68, 0.0, 24.73, 35.87, 55.19, 21.14, 17.02, 30.24, 42.43, 41.97, 48.59, 32.38, 26.77, 22.16, 38.01, 21.63},
                {28.0, 20.49, 24.09, 59.79, 21.95, 16.14, 19.9, 13.81, 24.83, 54.81, 44.6, 40.62, 36.76, 29.81, 27.08, 25.05, 0.0, 15.67, 30.41, 8.72, 8.75, 5.73, 17.64, 22.62, 26.36, 10.81, 5.47, 6.39, 13.23, 17.7},
                {43.35, 27.45, 31.06, 73.5, 31.65, 23.11, 26.63, 20.78, 29.83, 65.1, 55.77, 47.59, 41.75, 42.2, 39.07, 35.9, 15.65, 0.0, 26.52, 16.06, 24.11, 12.18, 24.37, 8.62, 17.65, 5.91, 20.73, 17.66, 19.07, 22.66},
                {57.19, 48.43, 52.03, 88.97, 52.29, 44.09, 47.84, 41.75, 52.77, 85.14, 74.94, 68.56, 64.7, 59.0, 56.27, 55.38, 30.48, 26.47, 0.0, 36.66, 39.09, 27.69, 21.76, 35.55, 13.13, 31.3, 34.04, 34.33, 21.37, 45.64},
                {27.73, 12.79, 16.39, 58.83, 16.99, 8.45, 12.2, 6.11, 16.6, 51.3, 41.1, 32.92, 28.52, 27.53, 24.4, 21.23, 8.44, 16.16, 36.58, 0.0, 8.16, 10.15, 23.81, 22.26, 28.5, 12.28, 13.99, 2.52, 19.4, 9.85},
                {20.14, 14.97, 17.32, 51.92, 14.09, 10.63, 14.39, 7.84, 19.45, 46.94, 36.74, 32.97, 30.55, 21.95, 19.22, 17.19, 8.55, 24.13, 39.01, 8.64, 0.0, 14.19, 26.24, 31.08, 34.82, 19.27, 10.59, 7.05, 21.83, 14.95},
                {33.43, 21.83, 25.44, 65.21, 26.03, 17.49, 21.25, 15.16, 26.18, 60.35, 50.15, 41.97, 38.1, 35.24, 32.51, 30.28, 5.72, 12.12, 27.54, 10.07, 14.18, 0.0, 16.39, 19.07, 20.88, 7.26, 10.59, 7.74, 11.98, 19.05},
                {43.59, 35.57, 39.17, 75.37, 39.43, 31.23, 34.99, 28.89, 39.92, 72.29, 62.12, 55.71, 51.84, 45.4, 42.67, 42.53, 17.63, 24.23, 21.53, 23.81, 26.23, 16.41, 0.0, 32.43, 21.73, 22.43, 20.17, 21.48, 6.42, 32.79},
                {50.02, 33.57, 37.17, 79.61, 37.77, 29.23, 32.75, 26.89, 35.94, 71.22, 61.88, 53.71, 47.87, 48.32, 45.19, 42.01, 22.61, 8.65, 35.62, 22.18, 31.06, 19.14, 32.45, 0.0, 26.75, 12.87, 27.68, 23.94, 27.16, 28.78},
                {53.87, 40.07, 43.67, 86.11, 44.27, 35.73, 39.49, 33.39, 44.43, 78.59, 68.38, 60.21, 56.35, 54.82, 51.68, 48.51, 26.16, 17.39, 13.18, 28.31, 34.62, 20.69, 21.6, 26.47, 0.0, 22.22, 31.24, 28.16, 21.23, 37.3},
                {38.38, 23.85, 27.45, 69.9, 28.05, 19.51, 23.27, 17.18, 24.66, 62.37, 52.16, 43.99, 36.58, 38.6, 35.47, 32.29, 10.67, 5.94, 31.22, 12.09, 19.13, 7.2, 22.43, 12.89, 22.35, 0.0, 15.75, 12.69, 18.01, 17.5},
                {27.51, 24.06, 27.14, 59.29, 23.91, 19.72, 23.47, 17.38, 28.54, 56.92, 46.04, 42.8, 40.46, 29.32, 26.59, 27.01, 5.48, 20.72, 32.82, 13.51, 10.71, 10.69, 19.32, 27.67, 33.03, 15.86, 0.0, 11.18, 15.45, 22.49},
                {26.17, 13.88, 17.48, 57.96, 18.08, 9.54, 13.29, 7.2, 18.36, 52.4, 42.19, 34.01, 30.28, 27.98, 25.25, 22.32, 6.14, 17.79, 34.28, 2.54, 6.6, 7.85, 21.51, 23.97, 28.46, 12.92, 11.69, 0.0, 17.1, 12.63},
                {39.73, 31.18, 34.78, 71.52, 35.04, 26.84, 30.6, 24.51, 35.53, 67.9, 58.26, 51.32, 47.45, 41.54, 38.81, 38.14, 13.24, 19.03, 21.21, 19.42, 21.84, 12.02, 5.99, 27.22, 21.65, 18.04, 16.31, 17.09, 0.0, 28.4},
                {29.89, 13.44, 15.82, 58.26, 17.64, 9.94, 10.24, 9.64, 12.67, 47.95, 40.53, 30.63, 24.59, 27.49, 25.05, 21.88, 17.42, 22.71, 45.57, 9.79, 14.83, 19.13, 32.8, 28.82, 37.49, 17.57, 22.98, 12.53, 28.39, 0.0}
        };
        printlndistance();
        return distance;
    }

    public static double getDistance(int i, int j) { //注意i,j和城市之间的对应关系
        return distance[i][j];
    }


    /**
     * 获取访问路径的长度
     * TODO 这个看起来太复杂了
     * @param road
     * @return
     */
    public static double getDistance(Integer[] road) {
        double roadLen = 0.0;
        for (int i = 1; i < road.length; i++) {
            roadLen += distance[road[i-1]][road[i]];
        }
        roadLen +=  distance[road[road.length-1]][road[0]];
        return roadLen;
    }

    public static double getDistance(List<Integer> road) {
        double roadLen = 0.0;
        for (int i = 1; i < road.size(); i++) {
            roadLen += distance[road.get(i-1)][road.get(i)];
        }
        roadLen +=  distance[road.get(road.size()-1)][road.get(0)];
        return roadLen;
    }

    private static void printlndistance() {
        System.out.printf("%8s","");
        for (int i = 0; i < num; i++) {
            System.out.printf("%5s",i);
        }
        System.out.println();
        for (int i = 0; i < num; i++) {
            System.out.printf("%5s",i);
            for (int j = 0; j < num; j++) {
                System.out.printf("%5s",(int)distance[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        DistanceUtil.initDistance(11);
        Integer[] road= {0, 6, 22, 23, 24, 1, 7, 14, 17, 18, 11, 29, 21, 12, 25, 26, 8, 28, 20, 16, 15, 10, 13, 27, 5, 3, 4, 2, 19, 9};
        System.out.println(DistanceUtil.getDistance(road));
    }
}
