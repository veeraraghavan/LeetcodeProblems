package com.practice.scribble;

import java.util.*;

public class BeforeAndAfterPuzzle {
    public static void main(String[] args) {
        BeforeAndAfterPuzzle me = new BeforeAndAfterPuzzle();
        me.beforeAndAfterPuzzles(new String[]{"elnafsbb q k as elsa s nj zohu bvtyqsif sslanu auztaj gijtw znfi igfjclnn ohuk b xwaeyo yn", "fsoggiun znfi wqeh utubv c tauhgi jqxm u qb sar sh dnryb", "tauhgi sh emgokxqq yn sar fy l de", "ohuk", "tauhgi rrdlwwu zvmq ylcpzhhc zvoq znfi yn rlftwz u wrbjzpno", "de znfi wrbjzpno nj fw rrdlwwu l sziskzq jcq sslanu tauhgi w x nuwwd b m", "s rlftwz svr q sar zvoq ylmbku rds b iijrqjgq vgyja nj dccbuy iijrqjgq chicvvn zvoq fw s", "dccbuy dnryb m ss ys b", "elsa ysaln sar hvqnpc do chicvvn", "auztaj ys zvoq utubv", "jrw ylmbku jrw sslanu", "c w ss funhr fw rds tntqzfo nj", "de", "nuwwd", "vkyzh rrdlwwu rlftwz b ylmbku asx b", "yn chicvvn u k s", "brf zohu", "emgokxqq yn as afcztpgf sahqp u utubv k", "sar gijtw u rds ys btmiuwh sar ylcpzhhc hvqnpc dhcf jcq fw yn vuao pooyn s", "qb ylmbku eorljtgx elsa hef asx tntqzfo vgyja nj b zvmq zvoq u u", "x ys vgyja rrdlwwu sslanu do fsoggiun b rrdlwwu nuwwd ul", "fy s u auztaj", "bvtyqsif lnkquudx b weyqrt", "emgokxqq wrbjzpno rds pooyn xwaeyo sh hef pooyn nj", "dhcf sziskzq btmiuwh yn wrbjzpno hvqnpc", "ylmbku vkyzh w jrw", "eorljtgx de c kmcm sahqp ymb h sslanu afcztpgf de", "btmiuwh ylmbku zajtj chicvvn qb vkyzh l asx eorljtgx auztaj rds rds", "vgyja sziskzq wqeh q", "dnryb b weyqrt b fw vkyzh qb rrdlwwu xwaeyo ss hvqnpc h u", "fw hvqnpc b w elsa ys s sh funhr wrbjzpno vkyzh as yn", "de jrw x hef wrbjzpno ztqidl vuao hef brf hkwtvao ys dccbuy", "utubv bvtyqsif fy zajtj ul fsoggiun dhcf ys hvqnpc jwlmw sh k",
                "c fw dnryb m jcq dnryb xwaeyo afcztpgf yn zajtj hef hut auztaj rlftwz xwaeyo ss ss",
                "zajtj jqxm zohu fsoggiun vkyzh l as c funhr sahqp k btmiuwh c",
                "elnafsbb utubv znfi fsoggiun weyqrt auztaj ysaln rlftwz utubv sar auztaj",
                "sar svr dhcf asx fw pooyn ztqidl l eorljtgx h znfi rrdlwwu jqxm",
                "chicvvn fy yn hut ul rrbogif hkwtvao m asx hvqnpc ylmbku",
                "dhcf q asx elnafsbb do l b ztqidl lnkquudx ys rrdlwwu s",
                "btmiuwh l s qb eorljtgx l ymb fy ys jrw elnafsbb afcztpgf znfi",
                "l nj sziskzq vgyja dnryb q utubv hut jwjbj chicvvn ss sh",
                "aqtlwdrg",
                "zajtj hef",
                "as dnryb weyqrt xwaeyo",
                "fw elnafsbb auztaj yjm lnkquudx zohu hef b ylcpzhhc chicvvn jrw yn btmiuwh q ylmbku c de",
                "xwaeyo auztaj zajtj rlftwz pooyn aqtlwdrg afcztpgf kmcm sslanu k dhcf de s fy jwjbj u",
                "l jcq igfjclnn vuao elsa asx znfi q rlftwz fy jrw sslanu sh hef ohuk utubv ul",
                "ymb",
                "iijrqjgq",
                "ul hkwtvao hkwtvao hef aqtlwdrg nj",
                "hvqnpc jrw ss brf kbibako hkwtvao pooyn aqtlwdrg tauhgi ohuk sziskzq jcq",
                "h fy eorljtgx xwaeyo zohu gijtw sh zvmq elsa jwjbj jwjbj ysaln l",
                "tntqzfo ylcpzhhc b jwlmw gijtw ys auztaj q nj fy de ymb fw fw",
                "ohuk",
                "weyqrt tauhgi chicvvn ymb wrbjzpno vgyja btmiuwh",
                "sh zohu funhr qb ys wqeh h yn c",
                "nuoqfc",
                "nj sslanu zvmq h q",
                "jwjbj vuao fw fy aqtlwdrg sahqp pooyn elnafsbb fw svr q ul ztqidl hkwtvao rlftwz",
                "jwjbj ysaln k l wrbjzpno yn utubv dnryb de k pooyn tauhgi yjm",
                "funhr rrdlwwu m",
                "sahqp aqtlwdrg b yn c ymb",
                "rrbogif ylmbku vkyzh ylmbku rlftwz aqtlwdrg hut",
                "vuao zajtj dhcf wrbjzpno jcq tntqzfo ohuk ss emgokxqq bvtyqsif jqxm igfjclnn wqeh l elnafsbb",
                "elsa u elnafsbb igfjclnn dccbuy hkwtvao",
                "dhcf dhcf rrbogif as do jwlmw l nj jwlmw vkyzh svr",
                "m q x vgyja sahqp m xwaeyo do pooyn xwaeyo ohuk",
                "b",
                "l yjm vkyzh rds sslanu gijtw l zajtj sar m",
                "ss aqtlwdrg rlftwz dccbuy zohu do elsa ylcpzhhc hkwtvao tntqzfo k u jwjbj rlftwz l w",
                "s wrbjzpno ul iijrqjgq ss s svr nuwwd xwaeyo tauhgi znfi btmiuwh sh yn jwjbj qb znfi",
                "yn",
                "pooyn pooyn",
                "kbibako x ss jrw de aqtlwdrg zohu ss",
                "b hkwtvao rds ymb sziskzq w ysaln zvmq kmcm nuoqfc fw nj q qb",
                "znfi vgyja tntqzfo ylcpzhhc ul ymb",
                "funhr sh kmcm",
                "rds dhcf btmiuwh l btmiuwh x eorljtgx q as zajtj emgokxqq q ylmbku",
                "jqxm ztqidl igfjclnn lnkquudx auztaj jrw weyqrt hut nuwwd elsa xwaeyo l",
                "jrw elsa igfjclnn vuao qb auztaj ztqidl zohu vkyzh aqtlwdrg bvtyqsif funhr hkwtvao",
                "fsoggiun weyqrt brf jwlmw jwlmw utubv do do l svr",
                "vkyzh tntqzfo ysaln aqtlwdrg ys dccbuy lnkquudx btmiuwh nuoqfc gijtw ul kmcm vuao",
                "nj ysaln hut ylmbku svr igfjclnn vkyzh yn x jwlmw ohuk w",
                "hef c kmcm zvmq fsoggiun gijtw m",
                "xwaeyo jwjbj vgyja vkyzh rrbogif zohu btmiuwh m tntqzfo ohuk nuoqfc asx w jrw m",
                "as tntqzfo tauhgi dnryb jcq rrdlwwu iijrqjgq brf l jcq",
                "yn l jqxm l eorljtgx rrdlwwu yjm u",
                "lnkquudx auztaj zajtj hut b m ysaln jwjbj",
                "b h hvqnpc asx vgyja",
                "jrw zohu rds c zvmq ymb asx zvoq dhcf sar aqtlwdrg vkyzh yjm rds ul ss wqeh"});

    }

    public List<String> beforeAndAfterPuzzles(String[] phrases) {
////         Map<String,List<String>> firstWordMap = new HashMap();
////         Map<String,List<String>> lastWordMap = new HashMap();
////         int indexI = 0 ;
////         for(String phrase:phrases){
////             if(phrase.indexOf(" ")<0){
////                 firstWordMap.putIfAbsent(phrase,new ArrayList());
////                 List temp = firstWordMap.get(phrase);
////                  temp.add(phrase+"_"+indexI);
////                 //temp.add(phrase);
////                 firstWordMap.put(phrase,temp);
////                 lastWordMap.putIfAbsent(phrase,new ArrayList());
////                 temp = lastWordMap.get(phrase);
////                 //temp.add(phrase);
////                 temp.add(phrase+"_"+indexI);
////                 lastWordMap.put(phrase,temp);
//
////             }else{
////                 int index = phrase.lastIndexOf(" ");
////                 String word = phrase.substring(index+1);
////                 int firstIndex = phrase.indexOf(" ");
////                 String firstWord = phrase.substring(0,firstIndex);
////                 firstWordMap.putIfAbsent(firstWord,new ArrayList());
////                 List temp = firstWordMap.get(firstWord);
////                 temp.add(phrase);
////                 firstWordMap.put(phrase,temp);
////                 lastWordMap.putIfAbsent(word,new ArrayList());
////                 temp = lastWordMap.get(word);
////                 temp.add(phrase);
////                 lastWordMap.put(word,temp);
////             }
////             indexI++;
////         }
////         List<String> result = new ArrayList();
////         for(Map.Entry entry:lastWordMap.entrySet()){
////             // int index = Integer.parseInt(entry.substring(entry.indexOf("_")+1));
////             // String key
////             if(firstWordMap.containsKey(entry.getKey())){
////                 List<String> temp = (List<String>)entry.getValue();
////                 for(String sentence : temp){
////                     String sentenceWithOutIndex = sentence.substring(0,sentence.indexOf("_"));
////                     int sentenceIndex = Integer.parseInt(sentence.substring(sentence.indexOf("_")+1));
////                     for(String sentence2: firstWordMap.get(entry.getKey())){
////                     String sentence2WithOutIndex = sentence2.substring(0,sentence2.indexOf("_"));
////                     int sentence2Index = Integer.parseInt(sentence2.substring(sentence2.indexOf("_")+1));
////                         if(sentenceIndex!=sentence2Index){
////                              String temp2 = "";
////                              if(sentence2.indexOf(" ")<0){
////                             }else{
////                             temp2 = sentence2.substring(sentence2.indexOf(" "));
////                         }
////                         result.add(sentence + temp2);
//
////                         }
//
////                     }
////                 }
////             }
//
////         }
//        List<String> result = new ArrayList<>();
//        for (int i = 0; i < phrases.length; i++) {
//            for (int j = 0; j < phrases.length; j++) {
//                if (i == j) continue;
//                String lastWord = "", firstWord = "";
//                if (phrases[j].indexOf(" ") < 0 && phrases[i].indexOf(" ") < 0) {
//                    if (phrases[i].equals(phrases[j])) {
//                        result.add(phrases[i]);
//                    }
//                } else {
//                    lastWord = phrases[i].substring(phrases[i].lastIndexOf(" ") + 1);
//                    firstWord = phrases[j].substring(0, phrases[j].indexOf(" "));
//                    if (firstWord.equals(lastWord)) {
//                        result.add(phrases[i] + phrases[j].substring(phrases[j].indexOf(" ")));
//                    }
//                }
//            }
//        }
//        Collections.sort(result);
//        return result;
//        public List<String> beforeAndAfterPuzzles (String[]phrases){
//        List<String> result = new ArrayList<>();
////            Map<String, Integer> map = new HashMap();
//        for (int i = 0; i < phrases.length; i++) {
//            for (int j = 0; j < phrases.length; j++) {
//                if (i == j) continue;
//                String lastWord = "", firstWord = "";
//                if (phrases[j].indexOf(" ") < 0 && phrases[i].indexOf(" ") < 0) {
//
//                    if (phrases[i].equals(phrases[j]) && !map.containsKey(phrases[i])) {
//                        map.put(phrases[i], 0);
//                        result.add(phrases[i]);
//                    }
//                } else {
//                    lastWord = phrases[i].substring(phrases[i].lastIndexOf(" ") + 1);
//                    if (phrases[j].indexOf(" ") >= 0)
//                        firstWord = phrases[j].substring(0, phrases[j].indexOf(" "));
//                    else
//                        firstWord = phrases[j];
//                    if (firstWord.equals(lastWord)) {
//                        if (phrases[j].indexOf(" ") >= 0)
//                            result.add(phrases[i] + phrases[j].substring(phrases[j].indexOf(" ")));
//                        else
//                            result.add(phrases[i]);
//                    }
//                }
//            }
//        }
//        Collections.sort(result);
//        return result;
//        List<String> result = new ArrayList<>();
//        Map<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < phrases.length; i++) {
//            for (int j = 0; j < phrases.length; j++) {
//                if (i == j) continue;
//                String lastWord = "", firstWord = "";
//                if (phrases[j].indexOf(" ") < 0 && phrases[i].indexOf(" ") < 0) {
//
//                    if (phrases[i].equals(phrases[j]) && !map.containsKey(phrases[i])) {
//                        map.put(phrases[i], 0);
//                        result.add(phrases[i]);
//                    }
//                } else {
//                    lastWord = phrases[i].substring(phrases[i].lastIndexOf(" ") + 1);
//                    if (phrases[j].indexOf(" ") >= 0)
//                        firstWord = phrases[j].substring(0, phrases[j].indexOf(" "));
//                    else
//                        firstWord = phrases[j];
//                    if (firstWord.equals(lastWord)) {
//                        if (phrases[j].indexOf(" ") >= 0)
//                            result.add(phrases[i] + phrases[j].substring(phrases[j].indexOf(" ")));
//                        else
//                            result.add(phrases[i]);
//                    }
//                }
//            }
//        }
//        Collections.sort(result);
//        return result;
        Set<String> result = new HashSet<>();
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < phrases.length; i++) {
            for (int j = 0; j < phrases.length; j++) {
                if (i == j) continue;
                String lastWord = "", firstWord = "";
                if (phrases[j].indexOf(" ") < 0 && phrases[i].indexOf(" ") < 0) {

                    if (phrases[i].equals(phrases[j]) && !map.containsKey(phrases[i])) {
                        map.put(phrases[i], 0);
                        result.add(phrases[i]);
                    }
                } else {
                    lastWord = phrases[i].substring(phrases[i].lastIndexOf(" ") + 1);
                    if (phrases[j].indexOf(" ") >= 0)
                        firstWord = phrases[j].substring(0, phrases[j].indexOf(" "));
                    else
                        firstWord = phrases[j];
                    if (firstWord.equals(lastWord)) {
                        if (phrases[j].indexOf(" ") >= 0)
                            result.add(phrases[i] + phrases[j].substring(phrases[j].indexOf(" ")));
                        else
                            result.add(phrases[i]);
                    }
                }
            }
        }
        ArrayList<String> resultList = new ArrayList(result);
        Collections.sort(resultList);
        return resultList;


    }


}
