import java.util.Random;
import java.util.ArrayList;

class SortingAlgorithms {
    private int[] data;
    private int numData;

    public SortingAlgorithms(int numData) {
        this.numData = numData;
        this.data = new int[numData];

        Random random = new Random();
        for (int i=0 ; i<this.numData ; i++) {
            this.data[i] = Math.abs(random.nextInt()) % 100;
        }
    }

    public SortingAlgorithms(int[] data) {
        this.data = data;
        this.numData = data.length;
    }

    public void printData() {
        for (int i=0 ; i<this.data.length ; i++) {
            System.out.println(this.data[i]);
        }
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
        helperMergeSort(this.data, 0, this.numData-1);
    }

    private void helperMergeSort(int[] data, int firstIndex, int lastIndex) {
        if (firstIndex == lastIndex) return;

        int halfIndex = (int) (firstIndex + lastIndex) / 2;
        helperMergeSort(data, 0, halfIndex);
        helperMergeSort(data, halfIndex + 1, lastIndex);
        merge(data, 0, halfIndex, lastIndex);
    }

    private void merge(int[] data, int firstIndex, int halfIndex, int lastIndex) {
        ArrayList<Integer> arrayTemp = new ArrayList<Integer>();

        int i = firstIndex, j = halfIndex + 1;

        while ((i <= halfIndex) && (j <= lastIndex)) {
            if (data[i] <= data[j]) {
                arrayTemp.add(data[i]);
                i++;
            }
            else {
                arrayTemp.add(data[j]);
                j++;
            }
        }

        if (i == halfIndex + 1) { // add all remaining items in second half
            while (j <= lastIndex) {
                arrayTemp.add(data[j]);
                j++;
            }
        }
        else if (j == lastIndex + 1){ // add all remaining items in first half
            while (i <= halfIndex) {
                arrayTemp.add(data[i]);
                i++;
            }
        }

        for (int k=0 ; k<arrayTemp.size() ; k++) {
            data[k + firstIndex] = (int) arrayTemp.get(k);
        }
    }
}

class SortingAlgorithmsDemo {
    public static void main(String[] args) {
        // int[] data = new int[10];

        // data[0] = 10;
        // data[1] = 5;

        // SortingAlgorithms sortingAlgorithms = new SortingAlgorithms(data);
        // sortingAlgorithms.printData();

        // System.out.println("-----------------------------------------");

        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms(10);
        sortingAlgorithms.printData();

        // sortingAlgorithms.bubbleSort();
        sortingAlgorithms.mergeSort();

        System.out.println("-----------------------------------------");

        sortingAlgorithms.printData();

    }
}