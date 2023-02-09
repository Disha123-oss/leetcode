class BrowserHistory {
    class Node{
        String url;
        Node prev;
        Node next;
        Node(String url){
            prev=null;
            next=null;
            this.url=url;
        }
    }
    Node curr;
    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }
    
    public void visit(String url) {
        Node nn = new Node(url);
        curr.next = nn;
        nn.prev = curr;
        curr = nn;
    }
    
    public String back(int steps) {
        int i=0;
        while(curr.prev!=null && i!=steps){
            curr = curr.prev;
            i++;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        int i=0;
        while(curr.next!=null && i!=steps){
            curr = curr.next;
            i++;
        }
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */