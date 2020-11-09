// 
// Decompiled by Procyon v0.5.36
// 


import java.util.Iterator;
import java.util.LinkedList;

public class LlkContext
{
    private LinkedList<int[]> llkContext;
    
    public LlkContext() {
        this.llkContext = new LinkedList<int[]>();
    }
    
    public boolean wordInContext(final int[] word) {
        for (final int[] word2 : this.llkContext) {
            if (word.length != word2.length) {
                continue;
            }
            int len;
            for (len = 0; len < word.length && word[len] == word2[len]; ++len) {}
            if (len == word.length) {
                return true;
            }
        }
        return false;
    }
    
    int[] getWord(final int index) {
        if (this.llkContext == null) {
            return null;
        }
        if (index >= this.llkContext.size() || index < 0) {
            return null;
        }
        return this.llkContext.get(index);
    }
    
    int minLengthWord() {
        int minlen = 99;
        for (final int[] word : this.llkContext) {
            if (minlen > word.length) {
                minlen = word.length;
            }
        }
        return minlen;
    }
    
    public int calcWords() {
        return this.llkContext.size();
    }
    
    public boolean addWord(final int[] word) {
        final int len = word.length;
        for (final int[] tmp : this.llkContext) {
            if (tmp.length != len) {
                continue;
            }
            int ii;
            for (ii = 0; ii < tmp.length && tmp[ii] == word[ii]; ++ii) {}
            if (ii == tmp.length) {
                return false;
            }
        }
        this.llkContext.add(word);
        return true;
    }
}
