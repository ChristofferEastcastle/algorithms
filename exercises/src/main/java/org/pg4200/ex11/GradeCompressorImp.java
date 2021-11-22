package org.pg4200.ex11;

import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

import java.util.HashMap;

public class GradeCompressorImp implements GradeCompressor {

    private static HashMap<Character, Integer> grades;

    public GradeCompressorImp() {
        initGrades();
    }

    @Override
    public byte[] compress(String idsAndGrades) {
        BitWriter writer = new BitWriter();
        int i = 0;
        while (i < idsAndGrades.length()) {
            char c = idsAndGrades.charAt(i);
            StringBuilder digits = new StringBuilder();
            while ((Character.isDigit(c))) {
                digits.append(c);
                c = idsAndGrades.charAt(++i);
            }
            writer.write(grades.get(c), 3);
            i++;

            writer.write(Integer.parseInt(digits.toString()), 9);
        }
        return writer.extract();
    }

    @Override
    public String decompress(byte[] data) {
        BitReader reader = new BitReader(data);
        StringBuilder output = new StringBuilder();
        while (true) {
            try {
                char grade = findChar(reader.readInt(3));
                output.append(reader.readInt(9)).append(grade);
            } catch (IllegalArgumentException | IllegalStateException e) {
                break;
            }
        }
        return output.toString();
    }

    private static void print(BitReader reader, int bits) {
        for (int j = 0; j < bits; j++) {
            boolean read = reader.readBoolean();
            if (read) System.out.print(1);
            else System.out.print(0);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GradeCompressor gradeCompressor = new GradeCompressorImp();
        String string = "1A54C232F511E";
        byte[] compressed = gradeCompressor.compress(string);
        var cloned = compressed.clone();
        print(new BitReader(cloned), 48);
        String decompressed = gradeCompressor.decompress(compressed);
        System.out.println(decompressed.equals(string));
    }


    private static void initGrades() {
        grades = new HashMap<>();
        grades.put('A', 0b000);
        grades.put('B', 0b001);
        grades.put('C', 0b010);
        grades.put('D', 0b011);
        grades.put('E', 0b100);
        grades.put('F', 0b111);
    }

    private char findChar(int value) {
        for (var entry : grades.entrySet()) {
            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return 'N';
    }
}
