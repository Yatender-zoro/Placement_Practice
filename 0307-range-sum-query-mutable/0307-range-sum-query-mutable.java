class NumArray {

    private int[] nums;
    private int[] tree;
    private int n;

    int build(int idx,int l,int r){
        
        if(l==r){
            return tree[idx] = nums[l];
        }
        int mid = l + (r-l)/2;

        int lsum = build(2*idx+1,l,mid);
        int rsum = build(2*idx+2,mid+1,r);

        return tree[idx] = lsum + rsum;
    }

    int querySum(int idx,int l,int r,int ql,int qr){
        
        if(ql>r || qr<l) return 0;

        if(ql<=l && r<=qr){
            return tree[idx];
        }

        int mid = l + (r-l)/2;

        int lsum = querySum(2*idx+1,l,mid,ql,qr);
        int rsum = querySum(2*idx+2,mid+1,r,ql,qr);

        return lsum + rsum;
    }

    void queryUpdate(int idx,int l,int r,int qidx,int val){
        
        if(l==r ){
            tree[idx] = val;
            return;
        }

        int mid = l + (r-l)/2;

        if(qidx<=mid){
            queryUpdate(2*idx+1,l,mid,qidx,val);
        }

        else{
            queryUpdate(2*idx+2,mid+1,r,qidx,val);
        }
        tree[idx] = tree[2*idx+1] + tree[2*idx+2];
    }

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        if(n == 0) return;

        tree = new int[4*n];
        build(0,0,n-1);
    }
    
    public void update(int index, int val) {
        if(n == 0) return;
        queryUpdate(0,0,n-1,index,val);
    }
    
    public int sumRange(int left, int right) {
        if(n == 0) return 0;
        return querySum(0,0,n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */