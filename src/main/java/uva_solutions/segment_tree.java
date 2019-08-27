package uva_solutions;

public class segment_tree{
    private static class SegmentTree{
        private int[] a, st;
        private int n;
        private int left (int p) { return (p << 1);}
        private int right (int p) { return (p << 1) + 1;}

        public SegmentTree(int[] arr){
            a = arr;
            n = arr.length;
            st = new int[4*n];
            build(1, 0, n-1);
        }

        private void build(int p, int L, int R){
            if(L == R){
                st[p] = L;
                return;
            }else{
                build(left(p), L, (L+R)/2);
                build(right(p), (L+R)/2 + 1, R);
                int p1 = st[left(p)];
                int p2 = st[right(p)];

                st[p] = (a[p1] <= a[p2]) ? p1 : p2;
            }
        }

        private int rmq(int p, int L, int R, int i, int j){
            if(j < L || i > R){
                return -1;
            }
            if(L >= i && R <= j) return st[p];

            int p1 = rmq(left(p), L, (L+R)/2, i, j);
            int p2 = rmq(right(p), (L+R)/2 + 1, R, i, j);

            if(p1 == -1) return p2;
            if(p2 == -1) return p1;

            return (a[p1] <= a[p2]) ? p1:p2;

        }

        public int rmq(int i, int j){
            return rmq(1, 0, n - 1, i, j);
        }
    }
    public static void main(String[] args) {
        int arr[] = { 18, 17, 13, 19, 15, 11, 20 }; // the original array
        SegmentTree st = new SegmentTree(arr);
        System.out.println("RMQ(1, 3) = " + st.rmq(1, 3)); // answer = index 2
        System.out.println("RMQ(4, 6) = " + st.rmq(4, 6));
    }
}