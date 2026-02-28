class NumArray {
    int[] nums;
    int[] tree;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        tree = new int[4*n];
        buildTree(0,0,n-1);
    }

    void buildTree(int idx,int l,int r){
        if(l == r){
            tree[idx] = nums[l];
            return;
        }

        int mid = l + (r-l)/2;
        
        buildTree( 2 * idx + 1 , l , mid);
        buildTree( 2 * idx + 2 , mid + 1 , r);

        tree[idx] = tree[ 2 * idx + 1] + tree[ 2 * idx + 2 ];
    }
    
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
    }

    int query(int idx,int l , int r, int ql, int qr){
        if(ql>r || qr<l) return 0;
        if( ql<= l && r <= qr) return tree[idx];

        int mid = l + (r-l)/2;

        return query(2* idx + 1,l,mid,ql,qr) + query(2 * idx+ 2,mid+1,r,ql,qr);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */