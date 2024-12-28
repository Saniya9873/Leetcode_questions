public class Singly_linkedlist {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;
    //ADD_FIRST :
    public void addFirst(int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }

    //ADD_LAST :
    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node current =head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=newNode;
    }
    //ADD_SPECIFIC :
    public void addSpecific(int data,int position){
        Node newNode=new Node(data);
        if (position==0) {
            addFirst(data);
            return;
        }
        Node current=head;
        for(int i=0;i<position-1;i++){
            if(current==null){
                return;
            }
            current=current.next;
        }
        newNode.next=current.next;
        current.next=newNode;
    }

    //DELETE_FIRST :
    public void deleteFirst(){
        if(head!=null){
            head=head.next;
        }
    }

    //DELETE_LAST :
    public void deleteLast(){
        if(head== null){
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        Node current=head;
        while(current.next!=null && current.next.next!=null){
            current=current.next;
        }
        current.next=null;
    }

    //DELETE_SPECIFIC :
    public void deleteSpecific(int data){
        if(head==null){
            return;
        }
        if(head.data==data){
            head=head.next;
            return;
        }
        Node current=head;
        while(current.next !=null){
            if(current.next.data==data){
                current.next=current.next.next;
                return;
            }
            current=current.next;
        }
    }

    //DISPLAY :
    public void display(){
        if(head==null){
            System.out.println("List  is empty");
            return;
        }
        Node current=head;
        while(current!=null){
            System.out.print(current.data+"->");
            current=current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Singly Linked List
        Singly_linkedlist s = new Singly_linkedlist();
        s.addFirst(10);
        s.addLast(20);
        s.addLast(30);
        s.addSpecific(25, 2);
        s.display();
        // s.deleteFirst();
        s.deleteLast();
        // s.deleteSpecific(25);
        s.display();
    }
}