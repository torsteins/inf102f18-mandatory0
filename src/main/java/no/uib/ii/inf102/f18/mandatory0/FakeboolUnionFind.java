package no.uib.ii.inf102.f18.mandatory0;

/**
 * Sample solution
 *
 * @author Torstein Strømme
 */
public class FakeboolUnionFind {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int q = io.getInt();

        MinUnionFind uf = new MinUnionFind(n);
        for (int i = 0; i < q; i++) {
            String query = io.getWord();
            if (query.equals("LEGAL")) {
                io.print(uf.min(io.getInt()) + "\n");
            } else if (query.equals("DAEMON")) {
                uf.union(io.getInt(), io.getInt());
            }
        }
        io.close();
    }

    private static class MinUnionFind {
        private final int[] id;
        private int[] mini;
        private int[] size;

        /**
         * Initialize MinUnionFind to contain n disconnected elements
         *
         * @param n the number of elements
         */
        public MinUnionFind(int n) {
            this.id = new int[n];
            this.mini = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                this.id[i] = i;
                this.mini[i] = i;
                this.size[i] = 1;
            }
        }

        /**
         * Weighted quick union - always make the root of the largest component the common root.
         *
         * @param p an element
         * @param q an element
         */
        public void union(int p, int q) {
            p = find(p);
            q = find(q);
            if (p == q) return;

            // Let mi be smallest component, and ma be biggest component.
            int mi = this.size[p] < this.size[q] ? p : q;
            int ma = this.size[p] < this.size[q] ? q : p;

            this.id[mi] = ma;
            this.mini[ma] = Math.min(this.mini[mi], this.mini[ma]);
            this.size[ma] += this.size[mi];
        }

        /**
         * find with recursive tail compression. (Note: recursive version might cause stack overflow
         * on adversary inputs unless it is combined with weighted quick union)
         *
         * @param p index for which to find the component id (root)
         * @return the id (root) of the component
         */
        public int find(int p) {
            if (this.id[p] == p) {
                return p;
            }

            int parent = find(this.id[p]);
            this.id[p] = parent;
            return parent;
        }

        /**
         * Return the minimum element of the component where p resides
         *
         * @param p element in component
         * @return minimum element in the same component as p
         */
        public int min(int p) {
            return this.mini[find(p)];
        }
    }
}
