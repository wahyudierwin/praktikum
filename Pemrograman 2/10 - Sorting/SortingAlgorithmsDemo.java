import java.util.Random;

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
        helperMergeSort(this.data, 0, this.numData-1);
    }

    private void helperMergeSort(int[] data, int firstIndex, int lastIndex) {
        if (firstIndex == lastIndex) return;

        int halfIndex = (int) (firstIndex + lastIndex) / 2;
        helperMergeSort(data, firstIndex, halfIndex);
        helperMergeSort(data, halfIndex + 1, lastIndex);
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
}

class SortingAlgorithmsDemo {
    public static void main(String[] args) {
        // int[] data = new int[10];
        // data[0] = 10;
        // data[1] = 5;

        // SortingAlgorithms sortingAlgorithms = new SortingAlgorithms(data);
        // sortingAlgorithms.printData();
        // System.out.println("-----------------------------------------");

        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms(100);
        sortingAlgorithms.printData();

        // sortingAlgorithms.bubbleSort();
        // sortingAlgorithms.mergeSort();

        System.out.println("-----------------------------------------");
        sortingAlgorithms.printData();

    }
}