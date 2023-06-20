package linkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class DesignLinkedList {
    ListNode dummyNode;
    int size = 0;
    class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }

    }
    public DesignLinkedList() {
        dummyNode = new ListNode(-1);
    }

    public int get(int index) {
        if(index>=size) return -1;
        ListNode cur = dummyNode;
        for(int i =0;i<=index;i++){
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        ListNode afterNode = dummyNode.next;
        dummyNode.next = newNode;
        newNode.next=afterNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode cur = dummyNode;
        ListNode newNode = new ListNode(val);
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index>size) return;
        ListNode cur = dummyNode;
        ListNode newAdd = new ListNode(val);
        for(int i =0;i<index;i++){
            cur = cur.next;
        }
        ListNode next = cur.next;
        cur.next = newAdd;
        newAdd.next = next;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(index>=size) return;
        ListNode cur = dummyNode;
        for(int i =0;i<index;i++){
            cur = cur.next;
        }
        if(cur.next!=null)
            cur.next = cur.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */