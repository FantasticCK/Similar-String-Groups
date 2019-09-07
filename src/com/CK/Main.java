package com.CK;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//        String[] A = {"tars","rats","arts","star"};
//        String[] A = {"ufixvnxsdxalinayfaappbmmj", "nxpxiaauvyjxasbfmfinmdpla", "ujimiyxsaxpavnanfapmlbxdf", "ufimvyxsaxpainanfapdlbxmj", "nxpyajaumxixalbfvpdnmasfi", "nxpxiaauvyjxpsbfmfinmdala", "ufimvyxspxaainanfapdlbxmj", "nxpyaiaumxjxapbfvlanmdsfi", "ufimvyxspxapinanfaadlbxmj", "nxpyaaauvxjxasbfmfinmdpli", "nxpyajaumxixapbfvlanmdsfi", "nxpyaaaumxjxasbfvfinmdpli", "ufixvnbsdxalinayfamppxamj", "ujimvyxsaxpainanfapdlbxmf", "ufixvyxsdxalinanfaappbmmj", "nxpyaaaumxjxapbfvlinmdsfi", "ufixvyxspxalinanfaadpbmmj", "nxpyaaaumxjxasbfvlinmdpfi", "ufixvyxspxapinanfaadlbmmj", "ufixvnbsdxalinayfaappxmmj", "ufiavnbsdxxlinayfamppxamj", "nxpyajaumxixapbfvldnmasfi", "ufiavnbsdxxlinayfamppxajm", "nxpyiaauvxjxasbfmfinmdpla", "ujimiyxsaxpavnanfapdlbxmf"};
        String[] A = {"qihcochwmglyiggvsqqfgjjxu","gcgqxiysqfqugmjgwclhjhovi","gjhoggxvcqlcsyifmqgqujwhi","wqoijxciuqlyghcvjhgsqfmgg","qshcoghwmglygqgviiqfjcjxu","jgcxqfqhuyimjglgihvcqsgow","qshcoghwmggylqgviiqfjcjxu","wcoijxqiuqlyghcvjhgsqgmgf","qshcoghwmglyiqgvigqfjcjxu","qgsjggjuiyihlqcxfovchqmwg","wcoijxjiuqlyghcvqhgsqgmgf","sijgumvhqwqioclcggxgyhfjq","lhogcgfqqihjuqsyicxgwmvgj","ijhoggxvcqlcsygfmqgqujwhi","qshcojhwmglyiqgvigqfgcjxu","wcoijxqiuqlyghcvjhgsqfmgg","qshcojhwmglyiggviqqfgcjxu","lhogcgqqfihjuqsyicxgwmvgj","xscjjyfiuglqigmgqwqghcvho","lhggcgfqqihjuqsyicxgwmvoj","lhgocgfqqihjuqsyicxgwmvgj","qihcojhwmglyiggvsqqfgcjxu","ojjycmqshgglwicfqguxvihgq","sijvumghqwqioclcggxgyhfjq","gglhhifwvqgqcoyumcgjjisqx"};
        System.out.println(new Solution().numSimilarGroups(A));
    }
}

class Solution {
    public int numSimilarGroups(String[] A) {
        int len = A.length;
        UnionFind uf = new UnionFind(len);
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isSimilar(A[i],A[j])) uf.union(i,j);
            }
        }
        return uf.size();
    }

    public boolean isSimilar(String a, String b) {
        int res = 0, len = a.length();
        for (int i = 0; i < len; i++)
            if (a.charAt(i) != b.charAt(i) && ++res > 2)
                return false;
        return true;
    }
}

class UnionFind {
    int[] p, rank;
    int num;
    public UnionFind(int num){
        p = new int[num];
        for (int i = 0; i < num; i++) p[i] = i;
        rank = new int[num];
        this.num = num;
    }
    public int find(int index){
        if (p[index] == index) return index;
        int res = find(p[index]);
        p[index] = res;
        return res;
    }
    public void union(int i, int j) {
        int ri = find(i), rj = find(j);
        if (ri == rj) return;
        if (rank[ri] > rank[rj]) p[rj] = ri;
        else {
            p[ri] = rj;
            if (rank[ri] == rank[rj]) rank[rj]++;
        }
        num--;
    }
    public int size(){
        return num;
    }
}