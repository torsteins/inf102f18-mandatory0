package no.uib.ii.inf102.f18.mandatory0;

/**
 * Sample solution
 *
 * @author Torstein Strømme
 */
public class FakeboolQuickFind {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in);
        int n = io.getInt();
        int m = io.getInt();

        QuickFind uf = new QuickFind(n);
        for (int i = 0; i < m; i++) {
            uf.union(io.getInt(), io.getInt());
        }

        for (int i = 0; i < n; i++) {
            io.print(uf.find(i) + " ");
        }
        io.close();
    }

    private static class QuickFind {
        private final int[] id;

        /**
         * Initialize the Union-Find object to contain n singleton elements
         *
         * @param n number of elements
         */
        public QuickFind(int n) {
            this.id = new int[n];
            for (int i = 0; i < n; i++) {
                this.id[i] = i;
            }
        }

        /**
         * Union operation in QuickFind takes linear time
         *
         * @param p the element
         * @param q the element
         */
        public void union(int p, int q) {
            p = find(p);
            q = find(q);

            int mi = p < q ? p : q;
            int ma = p < q ? q : p;

            for (int i = 0; i < this.id.length; i++) {
                if (this.id[i] == ma) {
                    this.id[i] = mi;
                }
            }
        }

        /**
         * Find operation in QuickFind always takes O(1) time
         *
         * @param p element
         * @return component in which p resides
         */
        public int find(int p) {
            return this.id[p];
        }
    }
}
