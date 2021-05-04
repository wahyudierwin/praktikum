public class Hashing {
    public static int[] ArrayData;
    int arraySize;
    int itemsInArray=0;
    Hashing(int size){
        arraySize=size;
        ArrayData = new int[size]; //set nilai awal array "-1" sbg
        for(int i=0;i<size;i++){   // tanda array masih kosong
            ArrayData[i]=-1;
        }
    }

    public int modMethod(int hashvalue, int sizehash, int[] Arr){
        int index = hashvalue%sizehash;
        return index;
    }

    public boolean apaArrayPenuh(int[] array){
        boolean dec=true;
        for(int i=0;i<arraySize;i++){
            if(array[i]==-1){
                dec=false;
                break;
            }
        }
        return dec;
    }

    public void insert(int key, int[] Array){
        int indexArr = modMethod(key,arraySize,ArrayData);
        if(apaArrayPenuh(Array)==true){
            System.out.println("Array penuh!");
        }else{
            while(ArrayData[indexArr]!=-1){ //menggunakan linear probing
             indexArr+=1;
             if(indexArr==arraySize){
                 indexArr=0;
             }
            }
            ArrayData[indexArr]=key;
        }
    }

    public void insert2(int key, int[] Array){
        int indexArr = modMethod(key,arraySize,ArrayData);
        int i=1;
        if(apaArrayPenuh(Array)==true){
            System.out.println("Array penuh!");
        }else{
            while(ArrayData[indexArr]!=-1){ //menggunakan quadratic probing
             indexArr+=i*i;
             if(indexArr==arraySize){
                 indexArr=0;
             }else if(indexArr>=arraySize){
                 indexArr%=arraySize;
             }
             i++;
            }
            ArrayData[indexArr]=key;
        }
    }

    public void insert3(int key, int[] Array){ //Double hashing
        int index1 = modMethod(key,arraySize,ArrayData); //index fungsi hash 1
        int index2 = (key+(key%10))%arraySize; //index fungsi hash 2
        if(apaArrayPenuh(Array)==true){
            System.out.println("Array penuh!");
        }else{                                 
            int indexNext=index1;
            while(ArrayData[indexNext]!=-1){
                int i=1;
                indexNext=index1+(i*index2);
                if(indexNext==arraySize){
                  indexNext=0;
                }else if(indexNext>=arraySize){
                  indexNext%=arraySize;
                }
                i++;
            }
            ArrayData[indexNext]=key;
        }
    }

    public static void main(String[] args) {
        Hashing theFunc = new Hashing(30);

        theFunc.insert2(10, ArrayData);
        theFunc.insert2(10, ArrayData);
        
        for (int ArrayData1 : ArrayData) {
            System.out.print(ArrayData1+" ");
        }
    }
}