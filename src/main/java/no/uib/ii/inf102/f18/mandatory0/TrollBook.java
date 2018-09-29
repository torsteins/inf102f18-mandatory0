package no.uib.ii.inf102.f18.mandatory0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Torstein Strømme
 */
public class TrollBook {

    private static class Page implements Comparable<Page> {
        private String word;
        private int page;

        Page(String word, int page) {
            this.word = word;
            this.page = page;
        }

        public int compareTo(Page that) {
            return this.page - that.page;
        }
    }

    public static void main(String[] args) throws IOException {
        // A client which utilize this class for the Kattis task Troll Book
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ISortableList<Page> a = new SortableLinkedList<Page>();
        for (int i = 0; i < n; i++) {
            String[] p = br.readLine().split(" ");
            a.add(new Page(p[0], Integer.parseInt(p[1])));
        }

        a.sort();
        StringBuilder ans = new StringBuilder();
        String prefix = "";
        for (Page p : a) {
            ans.append(prefix);
            prefix = " ";
            ans.append(p.word);
        }

        System.out.println(ans);
    }
}
