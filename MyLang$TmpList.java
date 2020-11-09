/*
 * Decompiled with CFR 0.150.
 */


class TmpList {
    TmpList treeFather;
    Node treeNode;
    int treePos;

    public TmpList(TmpList tmpFather, Node tmpNode, int tmpPos) {
        this.treeFather = tmpFather;
        this.treeNode = tmpNode;
        this.treePos = tmpPos;
    }

    private boolean roleInTree(Node tmp) {
        TmpList tmpLst = null;
        tmpLst = this;
        while (tmpLst != null) {
            if (tmpLst.treeNode == tmp) {
                return true;
            }
            tmpLst = tmpLst.treeFather;
        }
        return false;
    }

    void searchLeftRecursion(MyLang lang) {
        int[] epsilon = lang.getEpsilonNonterminals();
        TmpList tmpLst = null;
        tmpLst = this;
        while (tmpLst.treeFather != null) {
            tmpLst = this.treeFather;
        }
        Node root = tmpLst.treeNode;
        block1: for (Node tmp : lang.getLanguarge()) {
            if (tmp.getTeg() == 1 || this.roleInTree(tmp)) continue;
            int[] role = tmp.getRoole();
            for (int ii = 1; ii < role.length && role[ii] <= 0 && root.getRoole()[0] != role[ii]; ++ii) {
                int ii1;
                for (ii1 = 0; ii1 < epsilon.length && epsilon[ii1] != role[ii]; ++ii1) {
                }
                if (ii1 == epsilon.length) continue block1;
                TmpList tree1 = new TmpList(this, tmp, ii);
            }
        }
    }
}
