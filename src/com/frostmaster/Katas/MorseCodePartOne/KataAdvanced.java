package com.frostmaster.Katas.MorseCodePartOne;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author dk
 */
public class KataAdvanced {

    final static private Pattern binaryPattern = Pattern.compile("(0+|1+)");
    final static private Map<String, String> MorseCode = new HashMap<>();

    public static String decodeBits(String bits) {
        final StringBuilder result = new StringBuilder();
        final Matcher matcher = binaryPattern.matcher(bits);
        bits = bits.substring(bits.indexOf("1"),
                bits.lastIndexOf("1") + 1);

        final int rate = getTransmissionRate(bits);

        final String dot = String.join("",
                Collections.nCopies(rate, "1"))
                .intern();
        final String dash = String.join("",
                Collections.nCopies(rate * 3, "1")).intern();
        final String char_gap = String.join("",
                Collections.nCopies(rate * 3, "0")).intern();
        final String word_gap = String.join("",
                Collections.nCopies(rate * 7, "0")).intern();

        while (matcher.find()) {
            final String chr = matcher.group().intern();
            if (dot == chr) {
                result.append(".");
            } else if (dash == chr) {
                result.append("-");
            } else if (char_gap == chr) {
                result.append(" ");
            } else if (word_gap == chr) {
                result.append("   ");
            }
        }
        return result.toString();
    }

    public static String decodeMorse(String morseCode) {
        return Stream.of(morseCode.split("   "))
                .map(x -> {
                    return Stream.of(x.split(" "))
                            .map(chr -> MorseCode.get(chr))
                            .filter(chr -> chr != null)
                            .collect(Collectors.joining());
                })
                .collect(Collectors.joining(" "));
    }

    private static int getTransmissionRate(String bits) {
        final Set<String> sequences = new HashSet<>();
        final Matcher matcher = binaryPattern.matcher(bits);
        while (matcher.find()) {
            sequences.add(matcher.group());
        }
        final String minSeq = sequences.stream()
                .min((String o1, String o2)
                        -> Integer.compare(o1.length(), o2.length())).orElse("0");
        return minSeq.length();
    }

    static {
        MorseCode.put(".-", "A");
        MorseCode.put("-...", "B");
        MorseCode.put("-.-.", "C");
        MorseCode.put("-..", "D");
        MorseCode.put(".", "E");
        MorseCode.put("..-.", "F");
        MorseCode.put("--.", "G");
        MorseCode.put("....", "H");
        MorseCode.put("..", "I");
        MorseCode.put(".---", "J");
        MorseCode.put("-.-", "K");
        MorseCode.put(".-..", "L");
        MorseCode.put("--", "M");
        MorseCode.put("-.", "N");
        MorseCode.put("---", "O");
        MorseCode.put(".--.", "P");
        MorseCode.put("--.-", "Q");
        MorseCode.put(".-.", "R");
        MorseCode.put("...", "S");
        MorseCode.put("-", "T");
        MorseCode.put("..-", "U");
        MorseCode.put("...-", "V");
        MorseCode.put(".--", "W");
        MorseCode.put("-..-", "X");
        MorseCode.put("-.--", "Y");
        MorseCode.put("--..", "Z");
        //-----------------------
        MorseCode.put(".----", "1");
        MorseCode.put("..---", "2");
        MorseCode.put("...--", "3");
        MorseCode.put("....-", "4");
        MorseCode.put(".....", "5");
        MorseCode.put("-....", "6");
        MorseCode.put("--...", "7");
        MorseCode.put("---..", "8");
        MorseCode.put("----.", "9");
        MorseCode.put("-----", "0");
        //-----------------------
        MorseCode.put(".-.-.-", ".");
        MorseCode.put("--..--", ",");
    }
}
