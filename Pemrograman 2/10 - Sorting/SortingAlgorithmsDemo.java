import java.util.Random;

class SortingAlgorithms {
    private int[] data;
    private int numData;

    public SortingAlgorithms(int numData) {
        this.numData = numData;
        this.data = new int[numData];

        Random random = new Random();
        for (int i=0 ; i<this.numData ; i++) {
            this.data[i] = Math.abs(random.nextInt()) % 10000;
        }
    }

    public SortingAlgorithms(int[] data) {
        this.data = data;
        this.numData = data.length;
    }

    public void printData() {
        for (int i=0 ; i<this.data.length ; i++) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }

    public void bubbleSort() {
        for (int i=0 ; i<this.numData ; i++) {
            for (int j=0 ; j<this.numData-1 ; j++) {
                if (this.data[j] > this.data[j+1]) {
                    int temp = this.data[j];
                    this.data[j] = this.data[j+1];
                    this.data[j+1] = temp;
                }
            }
        }
    }

    public void mergeSort() {
        recursiveMergeSort(this.data, 0, this.numData-1);
    }

    private void recursiveMergeSort(int[] data, int firstIndex, int lastIndex) {
        if (firstIndex == lastIndex) return;

        int halfIndex = (int) (firstIndex + lastIndex) / 2;
        recursiveMergeSort(data, firstIndex, halfIndex);
        recursiveMergeSort(data, halfIndex + 1, lastIndex);
        merge(data, firstIndex, halfIndex, lastIndex);
    }

    private void merge(int[] data, int firstIndex, int halfIndex, int lastIndex) {
        int[] arrayTemp = new int[lastIndex - firstIndex + 1];

        int i = firstIndex, j = halfIndex + 1, idx = 0;

        while ((i <= halfIndex) && (j <= lastIndex)) {
            if (data[i] <= data[j]) {
                arrayTemp[idx] = data[i];
                i++;
                idx++;
            }
            else {
                arrayTemp[idx] = data[j];
                j++;
                idx++;
            }
        }

        if (i == halfIndex + 1) { // add all remaining items in second half
            while (j <= lastIndex) {
                arrayTemp[idx] = data[j];
                j++;
                idx++;
            }
        }
        else if (j == lastIndex + 1){ // add all remaining items in first half
            while (i <= halfIndex) {
                arrayTemp[idx] = data[i];
                i++;
                idx++;
            }
        }

        for (int k=0 ; k<arrayTemp.length ; k++) {
            data[k + firstIndex] = arrayTemp[k];
        }
    }

    public void countingSort() {
        // find max data
        int maxData = -1;
        for (int i=0 ; i<this.numData ; i++) {
            if (this.data[i] > maxData) {
                maxData = this.data[i];
            }
        }

        int[] countArray = new int[maxData + 1];

        for (int i=0 ; i<this.numData ; i++){
            countArray[this.data[i]]++;
        }

        int idx = 0;
        for (int i=0 ; i<=maxData ; i++) {
            while (countArray[i] > 0) {
                this.data[idx] = i;
                countArray[i]--;
                idx++;
            }
        }
    }
}

public class SortingAlgorithmsDemo {
    public static void main(String[] args) {
        // int[] data = new int[10];
        // data[0] = 10;
        // data[1] = 5;

        // SortingAlgorithms sortingAlgorithms = new SortingAlgorithms(data);
        // sortingAlgorithms.printData();
        // System.out.println("-----------------------------------------");

        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms(100);
        sortingAlgorithms.printData();
        long startTime = System.currentTimeMillis();
        sortingAlgorithms.bubbleSort();
        // sortingAlgorithms.mergeSort();
        // sortingAlgorithms.countingSort();

        System.out.println("-----------------------------------------");
        long finishTime = System.currentTimeMillis();
        sortingAlgorithms.printData();

        System.out.println("Running time in ms: " + (finishTime - startTime));

    }
}
