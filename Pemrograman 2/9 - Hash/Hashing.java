public class Hashing {
    public static int[] arrayData;
    int arraySize;
    
    public Hashing(int size) {
        arraySize = size;
        arrayData = new int[size]; //set nilai awal array "-1" sbg
        for(int i = 0; i < size; i++) {   // tanda array masih kosong
            arrayData[i] = -1;
        }
    }

    public int modMethod(int hashvalue, int sizehash) {
        int index = hashvalue%sizehash;
        return index;
    }

    public boolean apaArrayPenuh(int[] array) {
        for(int i = 0; i < arraySize; i++) {
            if (array[i] == -1) {
            	return false;
            }
        }
        return true;
    }

    public void insert(int key) {
        int indexArr = modMethod(key, arraySize);
        if (apaArrayPenuh(arrayData)) {
            System.out.println("Array penuh!");
        }
        else {
            while(arrayData[indexArr] != -1){ //menggunakan linear probing
                indexArr += 1;
                if(indexArr == arraySize){
                    indexArr = 0;
                }
            }
            arrayData[indexArr] = key;
        }
    }

    public void insert2(int key) {
        int indexArr = modMethod(key, arraySize);
        int i = 1;
        if (apaArrayPenuh(arrayData)) {
            System.out.println("Array penuh!");
        }
        else {
            while(arrayData[indexArr] != -1){ //menggunakan quadratic probing
                indexArr += i*i;
                indexArr = indexArr % arraySize;
                i++;
            }
            arrayData[indexArr] = key;
        }
    }

    public void insert3(int key) { //Double hashing
        int index1 = modMethod(key, arraySize); //index fungsi hash 1
        int index2 = (key+(key%10))%arraySize; //index fungsi hash 2
        System.out.println(key + " " + index1 + " " + index2);
        if(apaArrayPenuh(arrayData)){
            System.out.println("Array penuh!");
        }
        else {                                 
            int indexNext = index1;
            int i = 1;
            while(arrayData[indexNext] != -1){
                indexNext = (index1 + (i * index2)) % arraySize;
                i++;
            }
            arrayData[indexNext]=key;
        }
    }

    public static void main(String[] args) {
        Hashing theFunc = new Hashing(30);

        theFunc.insert3(10);
        theFunc.insert3(40);
        theFunc.insert3(70);

        for (int data : arrayData) {
            System.out.print(data + " ");
        }
    }
}
