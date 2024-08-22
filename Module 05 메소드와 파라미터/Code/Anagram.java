public class Anagram {
    public static char[] toCharArray(String value) {
        char[] result = new char[value.length()];

        for (int i = 0; i < result.length; i++) {
            result[i] = value.charAt(i);
        }

        return result;
    }

    public static char[] removeWhiteSpace(char[] array) {
        int count = 0;
        for (char c: array) {
            if (c != ' ') {
                count++;
            }
        }

        char[] result = new char[count];
        int index = 0;

        for (char c: array) {
            if (c != ' ') {
                result[index++] = c;
            }
        }

        return result;
    }

    public static char[] toLowerCase(char[] array) {
        char[] result = new char[array.length];
        int index = 0;

        for (char c: array) {
            if (((int)c) < 97) {
                result[index++] = (char)(c + 32);
            }
            else {
                result[index++] = c;
            }
        }

        return result;
    }

    public static void sort(char[] arr) {
        int n = arr.length;
        char temp = '0';

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static boolean isEqual(char[] array1, char[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[1] != array2[1]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagram(String value1, String value2) {
        char[] array1 = toLowerCase(removeWhiteSpace(toCharArray(value1)));
        char[] array2 = toLowerCase(removeWhiteSpace(toCharArray(value2)));

        sort(array1);
        sort(array2);

        return isEqual(array1, array2) ? true : false;
    }

    public static void main(String[] args){
        String s1 = "I am Lord Voldemort";
        String s2 = "Tom Marvolo Riddle";

        System.out.println(isAnagram(s1, s2));
    }
}