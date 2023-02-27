package project2;
public class LinkedListStack{

    private Node top;

    private static class Node{
        private String data;
        private Node next;

        public Node(String data){
            this.data = data;
            this.next = null;
        }

    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(String data){
        Node newNode = new Node(data);

        newNode.next = top;
        top = newNode;
    }

    public String pop(){
        if(isEmpty()){
            return null;
        }
        String ndata = top.data;
        top = top.next;
        return ndata;
    }

    public String top(){
        if(isEmpty()){
            return null;
        }
        return this.top.data;
    }
}
