package org.pg4200.ex11;

import org.junit.jupiter.api.Test;
import org.pg4200.les11.Huffman;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HuffmanIsoTest {

    @Test
    public void testCompareOnShortNorwegianSentence() {
        HuffmanIso huffmanIso = new HuffmanIso();
        String text = "Jeg ønsker å få en god karakter i denne eksamenen";
        byte[] isoCompressed = huffmanIso.compress(text);
        Huffman huffman = new Huffman();
        byte[] huffmanComp = huffman.compress(text);

        System.out.println(isoCompressed.length);
        System.out.println(huffmanComp.length);
        System.out.println(text.getBytes().length);
        assertTrue(isoCompressed.length < huffmanComp.length);

    }
}
