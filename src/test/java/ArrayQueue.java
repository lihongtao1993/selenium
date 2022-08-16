public class ArrayQueue {
    private int maxsize;
    private int front;
    private int rear;
    private int[] arr;
    public ArrayQueue(int maxsize){
        this.maxsize = maxsize;
        front=0;
        rear=0;
        arr = new int[maxsize];
    }

    public boolean isFull(){
        return (rear-front)%maxsize==0;
    }

    public boolean isEmpty(){
        return rear==front;
    }

    public void addQueue(int value){
        if (isFull()){
            System.out.println("full……");
        }
        arr[rear%maxsize] = value;
        rear++;
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("empty");
        }
        int result = arr[front%maxsize];
        front++;
        return result;
    }

    public void show(){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    public void showFrontAndRear(){
        System.out.println("front="+front+",rear="+rear);
    }
}

class ArrayQueueDemo{
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        queue.addQueue(10);
        queue.addQueue(20);
        queue.addQueue(30);
        queue.show();
        queue.showFrontAndRear();
        System.out.println("取出"+queue.getQueue());
        queue.show();
        queue.showFrontAndRear();
        queue.addQueue(40);
        queue.show();
        queue.showFrontAndRear();
        System.out.println("取出第一个"+queue.getQueue());
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
    }
}

