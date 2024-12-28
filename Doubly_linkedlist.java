public class Doubly_linkedlist {
    class Node{
        int data;
        Node next,prev;
        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    Node head;

    //ADD_FIRST :
    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }else{
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
    }

    //ADD_LAST :
    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node current=head;
        while(current.next!=null ){
            current=current.next;
        }
        current.next=newNode;
        newNode.prev=current;
    }

    //ADD_SPECIFIC :
    public void addSpecific(int data,int position){
        Node newNode=new Node(data);
        if(position==0){
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
        newNode.prev=current;
        if(current.next!=null){
            current.next.prev=newNode;
        }
        current.next=newNode;
    }

    //DELETE_FIRST :
    public void deleteFirst(){
        if(head!=null){
            if(head.next!=null){
                head=head.next;
                head.prev=null;
            }
            else{
                head=null;
            }
        }
    }

    //DELETE_LAST :
    public void deleteLast(){
        if(head==null){
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.prev.next=null;
    }

    //DELETE_SPECIFIC :
    public void deleteSpecific(int data){
        if(head==null){
            return;
        }
        if(head.data==data){
            deleteFirst();
            return;
        }
        Node current=head;
        while(current !=null){
            if(current.data==data){
                if(current.next!=null){
                    current.next.prev=current.prev;
                }
                if(current.prev!=null){
                    current.prev.next=current.next;
                }
                return;
            }
            current=current.next;
        }
    }

    //DISPLAY :
    public void display(){
        if(head==null){
            System.out.println("list is empty");
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
        Doubly_linkedlist d=new Doubly_linkedlist();
        d.addFirst(10);
        d.addLast(30);
        d.addLast(5);
        d.addSpecific(25,2);
        d.display();
        d.deleteFirst();
        d.deleteLast();
        d.deleteSpecific(25);
        d.display();
    }
}


