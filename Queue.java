   public class Queue {

    static int size = 6;
    static int queue[] = new int[size];

    static int front = -1;
    static int rear = -1;

    static void enqueue(int num) {

        if (rear == size - 1) {
            System.out.println("Queue is full");
        }

        else if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
            queue[rear] = num;
        }

        else {
            rear++;
            queue[rear] = num;
        }
    }                                                                                  
   //Dequeue
static void dequeue() {

    if (rear == -1 && front == -1) {
        System.out.println("Queue is empty");
    }

    else if (rear == front) {
        System.out.println("Deleted element: " + queue[front]);
        front = -1;
        rear = -1;
    }

    else {
        System.out.println("Deleted element: " + queue[front]);
        front++;
    }
}
//Peek the element at the front of the queue
static void peek() {

    if (front == -1 && rear == -1) {
        System.out.println("Queue is empty");
    }

    else {
        System.out.println("Element at the front is " + queue[front]);
    }
}

static void isEmpty() {

    if (front == -1 && rear == -1) {
        System.out.println("Queue is empty!");
    }

    else {
        System.out.println("Queue is not empty!");
    }
} 
static void displayQueue() {

    if (rear == -1 && front == -1) {
        System.out.println("Queue is empty");
    }

    else {
        for (int i = front; i < rear + 1; i++) {
            System.out.println(queue[i]);
        }
    }
}    

//Enter a student into the queue
       public static void main(String[] args) {
    enqueue(221045678);
    enqueue(222034512);
    enqueue(223041876);
    enqueue(221067341);
    enqueue(226089963);
    enqueue(224089863);
          
    isEmpty();      
          
    dequeue();
    dequeue();
    dequeue();
           
    peek(); 

    displayQueue();       
           
       }
   } 
