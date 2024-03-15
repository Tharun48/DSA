class Solution{
	int [] nearestSmallestTower(int [] arr){
		int n = arr.length;
	    int leftSmaller[] = new int[n];
	    int rightSmaller[] = new int[n];
      // Monotonic Stack
	    Stack<Integer> stack = new Stack<>();
	    for(int i=n-1;i>=0;i--) {
	        while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]) {
	            stack.pop();
	        }
	        if(stack.isEmpty()) {
	            rightSmaller[i] = -1;
	        }
	        else {
	            rightSmaller[i] = stack.peek();
	        }
	        stack.push(i);
	    }
	    while(!stack.isEmpty()) {
	        stack.pop();
	    }
	    for(int i=0;i<n;i++) {
	        while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]) {
	            stack.pop();
	        }
	        if(stack.isEmpty()) {
	            leftSmaller[i] = -1;
	        }
	        else {
	            leftSmaller[i] = stack.peek();
	        }
	        stack.push(i);
	    }
	    int ans[] = new int[n];
	    for(int i=0;i<n;i++) {
	        if(leftSmaller[i]==-1 && rightSmaller[i]==-1) {
	            ans[i] = -1;
	        }
	        else if(rightSmaller[i]==-1){
	            ans[i] = leftSmaller[i];
	        }
	        else if(leftSmaller[i]==-1) {
	            ans[i] = rightSmaller[i];
	        }
	        else {
	            if( Math.abs(i-rightSmaller[i]) != Math.abs(i-leftSmaller[i]) ) {
	                if( Math.abs(i-rightSmaller[i]) < Math.abs(i-leftSmaller[i]) ) {
	                    ans[i] = rightSmaller[i];
	                }
	                else if(Math.abs(i-rightSmaller[i])>Math.abs(i-leftSmaller[i])){
	                    ans[i] = leftSmaller[i];
	                }
	            }
	            else {
	                if(arr[leftSmaller[i]]!=arr[rightSmaller[i]]) {
	                    ans[i] = arr[leftSmaller[i]]<arr[rightSmaller[i]] ? leftSmaller[i] : rightSmaller[i];
	                }
	                else {
	                    ans[i] = leftSmaller[i]<rightSmaller[i] ? leftSmaller[i] : rightSmaller[i];
	                }
	            }
	        }
	    }
	    return ans;
	}
}

//Tc -> O(4N)
//Sc -> O(N) + O(N) + O(N)
