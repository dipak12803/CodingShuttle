package classCoding;

public class LABAP {
    public static void main(String[] args) {
        int[] array1 = {6,14,5,10,1};
        int[] array2 = {4,8,2,7,12};

        int[] mergedArray = mergeAndSort(array1, array2);

        for (int i : mergedArray) {
            System.out.print(i + " ");
        }
    }

    public static int[] mergeAndSort(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];

        System.arraycopy(array1, 0, mergedArray, 0, array1.length);
        System.arraycopy(array2, 0, mergedArray, array1.length, array2.length);

        for (int i = 0; i < mergedArray.length - 1; i++) {
            for (int j = 0; j < mergedArray.length - i - 1; j++) {
                if (mergedArray[j] > mergedArray[j + 1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = mergedArray[j];
                    mergedArray[j] = mergedArray[j + 1];
                    mergedArray[j + 1] = temp;
                }
            }
        }
        System.out.println("Count of elements in merged array are "+mergedArray.length);

        return mergedArray;
    }
}

