class RandomizedSet {
    List<Integer> list;
    Random ran = new Random();
    public RandomizedSet() {
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(!list.contains(val)) {
            list.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(list.contains(val)) {
            list.remove(Integer.valueOf(val));
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        return list.get(ran.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
