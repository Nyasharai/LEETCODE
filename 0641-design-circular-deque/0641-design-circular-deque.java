class MyCircularDeque {
    Dl head;
    Dl tail;
    int c,len;
    public MyCircularDeque(int k) {
        head=null;
        tail=null;
        c=0;
        len=k;
    }
    
    public boolean insertFront(int value) {
       if(c<len){
            Dl temp=new Dl(value);
            if(head==null){
                head=temp;
                tail=temp;
            }
            
            else{
                temp.next=head;
                head.prev=temp;
                head=temp;
            }
            c++;
            return true; 
       }
       return false;
    }
    
    public boolean insertLast(int value) {
        if(c<len){
            Dl temp=new Dl(value);
            if(tail!=null){
                temp.prev=tail;
                tail.next=temp;
                tail=temp;
            }
            else{
                tail=temp;
                head=temp;
            }
            c++;
            return true;
        }
        return false;
    }
    
    public boolean deleteFront() {
        if(c==0)return false;
        if(head!=tail){
            head=head.next;
        }
        else{
            head=null;
            tail=null;
        }
        c--;
        return true;
    }
    
    public boolean deleteLast() {
        if(c==0)return false;
        if(head!=tail){
            tail=tail.prev;
        }
        else{
            head=null;
            tail=null;
        }
        c--;
        return true;
    }
    
    public int getFront() {
        if(c==0)return -1;
        return head.data;
    }
    
    public int getRear() {
        if(c==0)return -1;
        return tail.data;
    }
    
    public boolean isEmpty() {
        return c==0;
    }
    
    public boolean isFull() {
        return c==len;
    }
}
class Dl{
    int data;
    Dl prev;
    Dl next;
    public Dl(int v){
        this.data=v;
        this.prev=null;
        this.next=null;
    }
}