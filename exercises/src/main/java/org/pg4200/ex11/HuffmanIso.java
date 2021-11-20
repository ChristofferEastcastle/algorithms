package org.pg4200.ex11;

import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;
import org.pg4200.les11.Huffman;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class HuffmanIso extends Huffman {

    @Override
    public void writeTrie(Node node, BitWriter buffer) {
        if (node.isLeaf()) {
            buffer.write(true);
            byte[] bytes = node.ch.toString().getBytes(StandardCharsets.ISO_8859_1);
            buffer.write(bytes[0]);
            return;
        }
        buffer.write(false);
        writeTrie(node.left, buffer);
        writeTrie(node.right, buffer);
    }

    @Override
    public Node readTrie(BitReader buffer) {
        boolean isLeaf = buffer.readBoolean();

        if (isLeaf) {
            byte iso = buffer.readByte();
            char c = new String(new byte[]{iso}, StandardCharsets.ISO_8859_1).charAt(0);
            return new Node(c, -1, null, null);
        } else {
            return new Node(null, -1, readTrie(buffer), readTrie(buffer));
        }

    }
}
