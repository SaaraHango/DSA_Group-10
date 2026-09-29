import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class IntegratedServiceCentre {

    static class Main {
    static class Student{
    int studentNo;
    String name;
    String serviceType;
    int serviceTime;
    Student(int studentNo, String name, String serviceType, int serviceTime) {
    this.studentNo = studentNo;
    this.name = name;
    this.serviceType = serviceType;
    this.serviceTime = serviceTime;
    }
    }
    public static void main(String[] args) {
    Student[] students = {
    new Student(221045678, "Maria", "Registration", 12),
    new Student(222034512, "Tomas", "Student Card", 5),
    new Student(223041876, "Ndapewa", "Fees", 8),
    new Student(221067341, "Simon", "Documents", 4)
    };
    int totalStudentsServed = students.length;
    int totalServiceTime = 0;
    int highest = students[0].serviceTime;
    int lowest = students[0].serviceTime;
    int longerThan10 = 0;
     for (int i = 0; i < students.length; i++) {
    totalServiceTime += students[i].serviceTime;
    if (students[i].serviceTime > highest) {
    highest = students[i].serviceTime; 
    }
    if (students[i].serviceTime < lowest) {
    lowest = students[i].serviceTime;
    }
    if (students[i].serviceTime > 10) {
    longerThan10++;
    }
    }
    double average = (double) totalServiceTime / totalStudentsServed;
    System.out.println("Total students served: " + totalStudentsServed);
    System.out.println("Total service time: " + totalServiceTime + " minutes");
    System.out.println("Average service time: " + average + " minutes");
    System.out.println("Highest service time: " + highest + " minutes");
    System.out.println("Lowest service time: " + lowest + " minutes");
    System.out.println("Services longer than 10 minutes: " + longerThan10);
    }
    }

    static class SelectionSortDemo {
    public static void selectionSort(int[] arr) {
    int n = arr.length;
    int comparisons = 0;
    int swaps = 0;
    for (int i = 0; i < n - 1; i++) {
    int minIndex = i;
    for (int j = i + 1; j < n; j++) {
    comparisons++;
    if (arr[j] < arr[minIndex]) {
    minIndex = j;
    }
    }
    if (minIndex != i) {
    int temp = arr[i];
    arr[i] = arr[minIndex];
    arr[minIndex] = temp;
    swaps++;
    }
    System.out.print("After pass " + (i+1) + ": ");
    printArray(arr);
    }
    System.out.println("comparisons: " + comparisons);
    System.out.println("swaps: " + swaps);
    }
    public static void printArray(int[] arr) {
    for (int num : arr) System.out.print(num + " ");
    System.out.println();
    }
    public static void main(String[] args) {
    int[] arr = {17, 5, 23, 8, 14, 3, 11, 20, 6, 9};
    selectionSort(arr);
    }
    }

    static class Queue {
        static int size = 6;
        static int queue[] = new int[size];
        static int front = -1;
        static int rear = -1;
        //ADDED: true only when every one of the 6 slots is really in use
        static boolean isFull() {
            return front == 0 && rear == size - 1;
        }
        static void enqueue(int num) {
            //FIXED: reuse freed slots at the front (the old code reported "full" after dequeues)
            if (front > 0 && rear == size - 1) {
                int count = rear - front + 1;
                for (int k = 0; k < count; k++) {
                    queue[k] = queue[front + k];
                }
                front = 0;
                rear = count - 1;
            }
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
        dequeue();
        dequeue();
        dequeue();
        peek(); 
        displayQueue();       
           }
    }

    static class MergeSort {
        // Main public method to start merge sort
        public static void sort(int[] arr) {
            if (arr == null || arr.length <= 1) {
                return;
            }
            int[] temp = new int[arr.length];
            mergeSort(arr, temp, 0, arr.length - 1);
        }
        // Recursive divide method
        private static void mergeSort(int[] arr, int[] temp, int left, int right) {
            if (left < right) {
                int mid = left + (right - left) / 2;
                // Sort left half
                mergeSort(arr, temp, left, mid);
                // Sort right half
                mergeSort(arr, temp, mid + 1, right);
                // Merge sorted halves
                merge(arr, temp, left, mid, right);
            }
        }
        // Combine/merge helper method
        private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
            for (int i = left; i <= right; i++) {
                temp[i] = arr[i];
            }
            int i = left;      // Left subarray index
            int j = mid + 1;   // Right subarray index
            int k = left;      // Merged array index
            while (i <= mid && j <= right) {
                if (temp[i] <= temp[j]) {
                    arr[k] = temp[i];
                    i++;
                } else {
                    arr[k] = temp[j];
                    j++;
                }
                k++;
            }
            while (i <= mid) {
                arr[k] = temp[i];
                k++;
                i++;
            }
        }
        // Test execution
        public static void main(String[] args) {
            int[] serviceTimes = {25, 10, 45, 12, 30, 5, 18};
            System.out.println("Original Service Times:");
            printArray(serviceTimes);
            sort(serviceTimes);
            System.out.println("\nSorted Service Times (Ascending):");
            printArray(serviceTimes);
        }
        private static void printArray(int[] arr) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    static class QuickSort {
        // Main public method to initiate quick sort
        public static void sort(int[] arr) {
            if (arr == null || arr.length <= 1) {
                return;
            }
            quickSort(arr, 0, arr.length - 1);
        }
        // Recursive quick sort helper
        private static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                // Partition the array and get the pivot index
                int pivotIndex = partition(arr, low, high);
                // Recursively sort elements before and after partition
                quickSort(arr, low, pivotIndex - 1);
                quickSort(arr, pivotIndex + 1, high);
            }
        }
        // Partition method selecting the last element as pivot
        private static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1; // Index of smaller element
            for (int j = low; j < high; j++) {
                // If current element is smaller than or equal to pivot
                if (arr[j] <= pivot) {
                    i++;
                    // Swap arr[i] and arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            // Swap arr[i+1] and arr[high] (pivot)
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            return i + 1;
        }
        // Demonstration / Testing
        public static void main(String[] args) {
            int[] serviceTimes = {42, 15, 8, 27, 33, 19, 5};
            System.out.println("Original Service Times:");
            printArray(serviceTimes);
            sort(serviceTimes);
            System.out.println("\nSorted Service Times (Ascending):");
            printArray(serviceTimes);
        }
        private static void printArray(int[] arr) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    static class StudentServiceRecords {
        // ---------------- Node ----------------
        static class StudentNode {
            int studentNumber;
            String name;
            String serviceType;
            int estimatedServiceTime; // in minutes
            StudentNode next;
            StudentNode(int studentNumber, String name, String serviceType, int estimatedServiceTime) {
                this.studentNumber = studentNumber;
                this.name = name;
                this.serviceType = serviceType;
                this.estimatedServiceTime = estimatedServiceTime;
                this.next = null;
            }
            @Override
            public String toString() {
                return "[" + studentNumber + " | " + name + " | " + serviceType
                        + " | " + estimatedServiceTime + " min]";
            }
        }
        // ---------------- Singly Linked List ----------------
        static class SinglyLinkedList {
            private StudentNode head;
            private int size;
            public SinglyLinkedList() {
                head = null;
                size = 0;
            }
            // Insert at the beginning
            public void insertAtBeginning(int studentNumber, String name, String serviceType, int estimatedServiceTime) {
                StudentNode newNode = new StudentNode(studentNumber, name, serviceType, estimatedServiceTime);
                newNode.next = head;
                head = newNode;
                size++;
            }
            // Insert at the end
            public void insertAtEnd(int studentNumber, String name, String serviceType, int estimatedServiceTime) {
                StudentNode newNode = new StudentNode(studentNumber, name, serviceType, estimatedServiceTime);
                if (head == null) {
                    head = newNode;
                } else {
                    StudentNode current = head;
                    while (current.next != null) {
                        current = current.next;
                    }
                    current.next = newNode;
                }
                size++;
            }
            // Insert at a specified position (0-based index)
            public void insertAtPosition(int position, int studentNumber, String name,
                                          String serviceType, int estimatedServiceTime) {
                if (position <= 0 || head == null) {
                    insertAtBeginning(studentNumber, name, serviceType, estimatedServiceTime);
                    return;
                }
                if (position >= size) {
                    insertAtEnd(studentNumber, name, serviceType, estimatedServiceTime);
                    return;
                }
                StudentNode newNode = new StudentNode(studentNumber, name, serviceType, estimatedServiceTime);
                StudentNode current = head;
                for (int i = 0; i < position - 1; i++) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
                size++;
            }
            // General entry point used by the menu / integrated system
            public void insertStudent(int studentNumber, String name, String serviceType,
                                       int estimatedServiceTime, String mode, int position) {
                switch (mode.toLowerCase()) {
                    case "beginning":
                        insertAtBeginning(studentNumber, name, serviceType, estimatedServiceTime);
                        break;
                    case "position":
                        insertAtPosition(position, studentNumber, name, serviceType, estimatedServiceTime);
                        break;
                    case "end":
                    default:
                        insertAtEnd(studentNumber, name, serviceType, estimatedServiceTime);
                        break;
                }
            }
            // Delete a student by student number
            public boolean deleteStudent(int studentNumber) {
                if (head == null) {
                    return false;
                }
                if (head.studentNumber == studentNumber) {
                    head = head.next;
                    size--;
                    return true;
                }
                StudentNode current = head;
                while (current.next != null && current.next.studentNumber != studentNumber) {
                    current = current.next;
                }
                if (current.next == null) {
                    return false; // not found
                }
                current.next = current.next.next;
                size--;
                return true;
            }
            // Search for a student by student number
            public StudentNode searchStudent(int studentNumber) {
                StudentNode current = head;
                while (current != null) {
                    if (current.studentNumber == studentNumber) {
                        return current;
                    }
                    current = current.next;
                }
                return null; // not found
            }
            // Traverse and display all students
            public void displayStudents() {
                if (head == null) {
                    System.out.println("(empty list)");
                    return;
                }
                StudentNode current = head;
                StringBuilder sb = new StringBuilder();
                while (current != null) {
                    sb.append(current.toString());
                    if (current.next != null) {
                        sb.append(" -> ");
                    }
                    current = current.next;
                }
                sb.append(" -> null");
                System.out.println(sb);
            }
            public StudentNode getHead() {
                return head;
            }
            public int getSize() {
                return size;
            }
        }
        // ---------------- Demonstration ----------------
        public static void main(String[] args) {
            SinglyLinkedList list = new SinglyLinkedList();
            System.out.println("=== Initial insertions ===");
            list.insertStudent(1001, "Alice Tan", "Enrollment", 15, "end", -1);
            list.insertStudent(1002, "Ben Cruz", "Fee Payment", 10, "end", -1);
            list.insertStudent(1003, "Chloe Reyes", "ID Replacement", 5, "end", -1);
            list.displayStudents();
            // ---- Link-changing operation 1: Insertion ----
            System.out.println("\n=== BEFORE insertion at beginning ===");
            System.out.println("Diagram: head -> [1001|Alice] -> [1002|Ben] -> [1003|Chloe] -> null");
            list.displayStudents();
            list.insertStudent(1000, "Dana Cruz", "Enrollment", 20, "beginning", -1);
            System.out.println("\n=== AFTER insertion at beginning (new node 1000) ===");
            System.out.println("Diagram: head -> [1000|Dana] -> [1001|Alice] -> [1002|Ben] -> [1003|Chloe] -> null");
            list.displayStudents();
            // Insertion at a specified position (index 2)
            list.insertStudent(1004, "Evan Reyes", "Fee Payment", 8, "position", 2);
            System.out.println("\n=== AFTER insertion at position 2 (new node 1004) ===");
            list.displayStudents();
            // ---- Link-changing operation 2: Deletion ----
            System.out.println("\n=== BEFORE deletion of student 1002 ===");
            list.displayStudents();
            boolean deleted = list.deleteStudent(1002);
            System.out.println("\n=== AFTER deletion of student 1002 (deleted=" + deleted + ") ===");
            list.displayStudents();
            // ---- Searching ----
            System.out.println("\n=== Search demonstration ===");
            int searchId = 1003;
            StudentNode found = list.searchStudent(searchId);
            if (found != null) {
                System.out.println("Found student " + searchId + ": " + found);
            } else {
                System.out.println("Student " + searchId + " not found.");
            }
            int missingId = 9999;
            StudentNode notFound = list.searchStudent(missingId);
            System.out.println("Search for " + missingId + ": "
                    + (notFound == null ? "not found" : notFound.toString()));
            // ---- Traversal ----
            System.out.println("\n=== Final traversal ===");
            list.displayStudents();
            System.out.println("Total students in list: " + list.getSize());
            // Simple interactive menu (optional use)
            runMenu(list);
        }
        private static void runMenu(SinglyLinkedList list) {
            Scanner scanner = new Scanner(System.in);
            int choice = -1;
            System.out.println("\n=== Student Service Records Menu ===");
            do {
                System.out.println("\n1. Insert student");
                System.out.println("2. Delete student");
                System.out.println("3. Search student");
                System.out.println("4. Display all students");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Exiting menu.");
                    break;
                }
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Student Number: ");
                        int sn = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Service Type: ");
                        String type = scanner.nextLine();
                        System.out.print("Estimated Service Time (min): ");
                        int time = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Insert mode (beginning/end/position): ");
                        String mode = scanner.nextLine();
                        int pos = -1;
                        if (mode.equalsIgnoreCase("position")) {
                            System.out.print("Position (0-based index): ");
                            pos = scanner.nextInt();
                            scanner.nextLine();
                        }
                        list.insertStudent(sn, name, type, time, mode, pos);
                        list.displayStudents();
                        break;
                    case 2:
                        System.out.print("Student Number to delete: ");
                        int delId = scanner.nextInt();
                        scanner.nextLine();
                        boolean ok = list.deleteStudent(delId);
                        System.out.println(ok ? "Deleted." : "Not found.");
                        list.displayStudents();
                        break;
                    case 3:
                        System.out.print("Student Number to search: ");
                        int searchIdInput = scanner.nextInt();
                        scanner.nextLine();
                        StudentNode result = list.searchStudent(searchIdInput);
                        System.out.println(result != null ? "Found: " + result : "Not found.");
                        break;
                    case 4:
                        list.displayStudents();
                        break;
                    case 0:
                        System.out.println("Exiting.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 0);
            scanner.close();
        }
    }

    static class Sorting_Saara {
    //This is used to count comparisons
       static long comparisons;
       //SELECTION SORT 
       public static void selectionSort(int[] arr){
        for (int i=0; i < arr.length - 1; i++) {
            int  minIndex=i;
            for (int j= i+1; j< arr.length; j++){
    //Comparisons between two data value
    comparisons++;
        if  (arr[j] < arr[minIndex]){
            minIndex=j;
        }
            }
            //Then we swap
            int temp =arr[i];
            arr[i] =arr[minIndex];
            arr[minIndex]=temp;
        }
       }
    //INSERTION SORT
    public static void  insertionSort(int[] arr){
        for(int i=1; i< arr.length; i++){
            int key = arr[i];
            int j= i-1;
            while (j>=0){
    //Comparison between two values
        comparisons++;
        if(arr[j]> key){
            arr[j+1]= arr [j];
            j--;
        } else {
            break;
        }
            }
        arr[j+1] = key;
        }
            }
            //MERGE SORT
            public static void mergeSort(int[]arr) {
                 if (arr.length <=1){
                    return;
                 }
                 int middle = arr.length /2;
                 int[] left = Arrays.copyOfRange( arr, 0, middle);
                 int[] right = Arrays.copyOfRange(arr, middle, arr.length);
                 mergeSort(left); 
                 mergeSort(right);
                 merge(arr, left, right);
            }
            public static void merge(int[] arr, int[] left, int[] right){
                int i=0;
                int j=0;
                int k=0;
                while (i < left.length && j < right.length){
                    //Comparison between two data values
                    comparisons++;
                    if (left [i] <= right[j]){
                        arr[k] = left[i];
                        i++;
                         } else {
                            arr[k] = right[j];
                            j++;
                         }
                         k++;
                    }
                    //Copying remaining left values
                    while ( i< left.length) {
                        arr[k] = left[i];
                        i++;
                        k++;
                    }
                //ADDED: copy remaining right values (missing in the original merge)
                    while (j < right.length) {
                        arr[k] = right[j];
                        j++;
                        k++;
                    }
                }
              
            public static void quickSort(int [] arr, int low, int high){
                if (low >= high){
                    return;
                }
                int i = low;
                int j = high;
                //Choose the middle element as pivot
                int pivot = arr[(low + high) / 2];
                while (i <= j) {
                    //Move i right while value is smaller than pivot
                    while (true) {
                        comparisons++;
                        if (arr[i] < pivot) { i++; } else { break; }
                    }
                    //Move j left while value is larger than pivot
                    while (true) {
                        comparisons++;
                        if (arr[j] > pivot) { j--; } else { break; }
                    }
                    if (i <= j) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        i++;
                        j--;
                    }
                }
                if (low < j) { quickSort(arr, low, j); }
                if (i < high) { quickSort(arr, i, high); }
            }

            //GENERATE RANDOM ARRAY
            public static int[] generateArray (int size){
                Random random = new Random(42);
                int[] arr = new int[size];
                for (int i = 0; i < size; i++){
                    arr[i] = random.nextInt(10000);
                }
            return arr;
        }
        //RUN ONE SORTING TEST
        public static void runTest(
            String algorithm,
            int[] originalArray){
                //Making a copy so every algorithm gets identical data
                int[] testArray = Arrays.copyOf(
                    originalArray,
                    originalArray.length
                );
                //Reset comparison counter 
                comparisons = 0;
                //Start timing immediately before sorting
                long startTime = System.nanoTime();
                if (algorithm.equals("Selection Sort")){
                    selectionSort(testArray);
                }else if (algorithm.equals("Insertion Sort")) {
                    insertionSort(testArray);
                }else if (algorithm.equals("Merge Sort")){
                    mergeSort(testArray);
                }else if (algorithm.equals("Quick Sort")){
                    quickSort(testArray, 0, testArray.length - 1);
                }
                //End timing immidiately after sorting
                long endTime = System.nanoTime();
                long executionTime = endTime - startTime;
                System.out.printf(
                    "%-18s %-10d %-18d %-15d%n",
                    algorithm,
                    originalArray.length,
                    comparisons, 
                    executionTime
                );
            }
                //THE ADDITIONAL ALMOST - SORTED TEST
                public static int[] createAlmostSortedArray(int[] original){
                //First sort the original array
                int[] arr = Arrays.copyOf(original, original.length);
                Arrays.sort(arr);
                //Swap the five pairs of neighbouring values
                for (int i = 0; i<5; i++){
                    int index = i * 2;
                    int temp = arr[index];
                    arr[index] = arr[index + 1];
                    arr[index + 1] = temp;
                }
                return arr;
            }
    //MAIN  METHOD
            public static void main(String[] args){
                int[] inputSizes = {20,50,100,500};
                String[] algorithms ={
                    "Selection Sort",
                    "Insertion Sort",
                    "Merge Sort",
                    "Quick Sort"
                }; 
                System.out.println(
                    "===================================="
                );
                System.out.println(
                    "SORTING ALGORITHM EXPERIMENT"
                );
                System.out.println(
                    "===================================="
                );
                System.out.printf(
                    "%-18s %-10s %-18s %-15s%n",
                    "Algorithm",
                    "Input Size",
                    "Comparisons",
                    "Time (ns)"
                );
                System.out.println();
                //ADDED: run every algorithm on each input size
                for (int size : inputSizes) {
                    int[] original = generateArray(size);
                    for (String algorithm : algorithms) {
                        runTest(algorithm, original);
                    }
                }
            //ALMOST-SORTED TEST
            System.out.println();
            System.out.println(
                "=============================="
            );
             System.out.println(
                "ALMOST - SORTED ARRAY TEST (100 ELEMENTS)"
             );
              System.out.println(
                "=============================="
              );
               System.out.printf(
                "%-18s %-10s %-18s %-15s%n",
                "Algorithm",
                "Input Size", 
                "Comparisons",
                "Time (ns)"
               );
                System.out.println(
                    "---------------------------"
                );
                //Generate original 100-element array
                int[] original100 = generateArray(100);
                //Create almost-sorted version
                int[] almostSorted = createAlmostSortedArray(original100);
                //Test all four algorithms using the same almost-sorted array
                for (String algorithm : algorithms) {
                    runTest(algorithm, almostSorted);
                }
                 System.out.println(
                    "============================"
                 );
            }
    }

    // =====================================================================
    //                    PART D - INTEGRATED MENU SYSTEM
    // =====================================================================
    static final Scanner sc = new Scanner(System.in);

    // The SAME linked list from A2 holds the service records
    static final StudentServiceRecords.SinglyLinkedList records =
            new StudentServiceRecords.SinglyLinkedList();

    // Details of students currently waiting (the array Queue stores student numbers)
    static final Map<Integer, Main.Student> waiting = new HashMap<>();

    // ---------------- input helpers ----------------
    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Input cannot be empty.");
        }
    }

    static boolean queueIsEmpty() {
        return Queue.front == -1 && Queue.rear == -1;
    }

    static void printTimes(String label, int[] arr) {
        StringBuilder sb = new StringBuilder(label);
        for (int v : arr) sb.append(v).append(' ');
        System.out.println(sb.toString().trim());
    }

    // ---------------- menu ----------------
    static void printMenu() {
        System.out.println();
        System.out.println("=========== INTEGRATED CAMPUS SERVICE-CENTRE SYSTEM ===========");
        System.out.println(" 1. Add to waiting queue");
        System.out.println(" 2. Serve next student");
        System.out.println(" 3. Display waiting students");
        System.out.println(" 4. Add record");
        System.out.println(" 5. Display records");
        System.out.println(" 6. Search record");
        System.out.println(" 7. Remove record");
        System.out.println(" 8. Daily statistics");
        System.out.println(" 9. Sort service times");
        System.out.println("10. Run experiment");
        System.out.println("11. Exit");
    }

    // ---------------- 1. Add to waiting queue ----------------
    static void addToWaitingQueue() {
        if (Queue.isFull()) {
            System.out.println("Queue is full");
            return;
        }
        int no = readInt("Student Number: ");
        if (waiting.containsKey(no)) {
            System.out.println("That student is already in the waiting queue.");
            return;
        }
        String name = readText("Name: ");
        String type = readText("Service Type: ");
        int time = readInt("Estimated Service Time (min): ");
        if (time <= 0) {
            System.out.println("Service time must be greater than 0.");
            return;
        }
        waiting.put(no, new Main.Student(no, name, type, time));
        Queue.enqueue(no);
        System.out.println("Student " + no + " added to the waiting queue.");
    }

    // ---------------- 2. Serve next student ----------------
    static void serveNextStudent() {
        if (queueIsEmpty()) {
            System.out.println("Queue is empty - no student to serve.");
            return;
        }
        int no = Queue.queue[Queue.front];
        Queue.dequeue();
        Main.Student s = waiting.remove(no);
        if (s != null) {
            System.out.println("Now serving: " + s.studentNo + " | " + s.name
                    + " | " + s.serviceType + " | " + s.serviceTime + " min");
            records.insertStudent(s.studentNo, s.name, s.serviceType, s.serviceTime, "end", -1);
            System.out.println("Service record added to the linked list.");
        }
    }

    // ---------------- 3. Display waiting students ----------------
    static void displayWaitingStudents() {
        if (queueIsEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Queue.peek();
        System.out.println("Waiting students (front to rear):");
        for (int i = Queue.front; i <= Queue.rear; i++) {
            Main.Student s = waiting.get(Queue.queue[i]);
            if (s != null) {
                System.out.println((i - Queue.front + 1) + ". " + s.studentNo + " | " + s.name
                        + " | " + s.serviceType + " | " + s.serviceTime + " min");
            } else {
                System.out.println((i - Queue.front + 1) + ". " + Queue.queue[i]);
            }
        }
    }

    // ---------------- 4. Add record ----------------
    static void addRecord() {
        int no = readInt("Student Number: ");
        if (records.searchStudent(no) != null) {
            System.out.println("A record for student " + no + " already exists.");
            return;
        }
        String name = readText("Name: ");
        String type = readText("Service Type: ");
        int time = readInt("Estimated Service Time (min): ");
        if (time <= 0) {
            System.out.println("Service time must be greater than 0.");
            return;
        }
        String mode;
        while (true) {
            mode = readText("Insert mode (beginning/end/position): ").toLowerCase();
            if (mode.equals("beginning") || mode.equals("end") || mode.equals("position")) break;
            System.out.println("Please type beginning, end or position.");
        }
        int pos = -1;
        if (mode.equals("position")) {
            pos = readInt("Position (0-based index): ");
        }
        records.insertStudent(no, name, type, time, mode, pos);
        System.out.println("Record added.");
        records.displayStudents();
    }

    // ---------------- 5. Display records ----------------
    static void displayRecords() {
        records.displayStudents();
        System.out.println("Total records: " + records.getSize());
    }

    // ---------------- 6. Search record ----------------
    static void searchRecord() {
        int no = readInt("Student Number to search: ");
        StudentServiceRecords.StudentNode found = records.searchStudent(no);
        System.out.println(found != null ? "Found: " + found : "Student " + no + " not found.");
    }

    // ---------------- 7. Remove record ----------------
    static void removeRecord() {
        int no = readInt("Student Number to remove: ");
        boolean ok = records.deleteStudent(no);
        System.out.println(ok ? "Record removed." : "Student " + no + " not found.");
        records.displayStudents();
    }

    // ---------------- 8. Daily statistics ----------------
    static void dailyStatistics() {
        if (records.getSize() == 0) {
            System.out.println("No service records yet - nothing to calculate.");
            return;
        }
        int totalStudentsServed = records.getSize();
        int totalServiceTime = 0;
        int highest = records.getHead().estimatedServiceTime;
        int lowest = records.getHead().estimatedServiceTime;
        int longerThan10 = 0;

        StudentServiceRecords.StudentNode current = records.getHead();
        while (current != null) {
            int t = current.estimatedServiceTime;
            totalServiceTime += t;
            if (t > highest) highest = t;
            if (t < lowest) lowest = t;
            if (t > 10) longerThan10++;
            current = current.next;
        }
        double average = (double) totalServiceTime / totalStudentsServed;

        System.out.println("Total students served: " + totalStudentsServed);
        System.out.println("Total service time: " + totalServiceTime + " minutes");
        System.out.println("Average service time: " + average + " minutes");
        System.out.println("Highest service time: " + highest + " minutes");
        System.out.println("Lowest service time: " + lowest + " minutes");
        System.out.println("Services longer than 10 minutes: " + longerThan10);
    }

    // ---------------- 9. Sort service times ----------------
    static void sortServiceTimes() {
        int n = records.getSize();
        if (n == 0) {
            System.out.println("No service records yet - nothing to sort.");
            return;
        }
        int[] times = new int[n];
        StudentServiceRecords.StudentNode current = records.getHead();
        for (int i = 0; i < n; i++) {
            times[i] = current.estimatedServiceTime;
            current = current.next;
        }
        printTimes("Original service times: ", times);

        System.out.println("Choose algorithm:");
        System.out.println(" 1. Selection Sort");
        System.out.println(" 2. Insertion Sort");
        System.out.println(" 3. Merge Sort");
        System.out.println(" 4. Quick Sort");
        int choice = readInt("Enter choice: ");

        int[] sorted = Arrays.copyOf(times, n);   // the list itself is left untouched
        switch (choice) {
            case 1:
                SelectionSortDemo.selectionSort(sorted);
                break;
            case 2:
                Sorting_Saara.comparisons = 0;
                Sorting_Saara.insertionSort(sorted);
                System.out.println("comparisons: " + Sorting_Saara.comparisons);
                break;
            case 3:
                MergeSort.sort(sorted);
                break;
            case 4:
                QuickSort.sort(sorted);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        printTimes("Sorted service times (ascending): ", sorted);
    }

    // ---------------- 10. Run experiment ----------------
    static void runExperiment() {
        Sorting_Saara.main(new String[0]);
    }

    // ---------------- main loop ----------------
    static void runSystem() {
        int choice = 0;
        do {
            printMenu();
            choice = readInt("Enter choice (1-11): ");
            System.out.println();
            switch (choice) {
                case 1:  addToWaitingQueue();     break;
                case 2:  serveNextStudent();      break;
                case 3:  displayWaitingStudents(); break;
                case 4:  addRecord();             break;
                case 5:  displayRecords();        break;
                case 6:  searchRecord();          break;
                case 7:  removeRecord();          break;
                case 8:  dailyStatistics();       break;
                case 9:  sortServiceTimes();      break;
                case 10: runExperiment();         break;
                case 11: System.out.println("Exiting Campus Service-Centre System. Have a nice day!"); break;
                default: System.out.println("Invalid choice. Please enter a number from 1 to 11.");
            }
        } while (choice != 11);
    }

    public static void main(String[] args) {
        try {
            runSystem();
        } catch (NoSuchElementException e) {
            System.out.println("\nInput closed. Exiting.");
        }
    }
}

