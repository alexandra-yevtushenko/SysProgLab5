/*
 * Decompiled with CFR 0.150.
 */

public class TableNode {
    String lexemaText;
    int lexemacode;
    static int numarator = 0;

    public TableNode(String lexema, int lexemaType) {
        this.lexemaText = lexema;
        this.lexemacode = lexemaType | numarator++;
    }

    public String getLexemaText() {
        return this.lexemaText;
    }

    public int getLexemaCode() {
        return this.lexemacode;
    }

    public boolean equals(TableNode node1) {
        if (node1 == null) {
            return false;
        }
        if (this == node1) {
            return true;
        }
        return this.lexemaText.equals(node1.lexemaText);
    }
}
