import java.util.Scanner;

public class NumbertoText {
    public static void main(String[] args) {
        //Generalize ones ,tens ,hundred and thousand
        String[] ones = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        String[] tens = { "", "ten", "twenty", "thirty", "fourty", "fifity", "sixty", "seventy", "eighty", "ninty" };
        String[] hundreds = { "hundred" };
        String[] eleventotwenty = { "", "eleven", "twleve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nintee" };
        String[] thousand = { "thousand" };

        System.out.print("Enter a number");

        //Taking input of the number

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int count = 0;
        //Calling the first function
        func(n, ones, tens, hundreds, thousand, eleventotwenty);

    }

    static void func(int n, String[] ones, String[] tens, String[] hundreds, String[] thousand,
            String[] eleventotwenty) {
                //Function to count no of digits in the number
        int[] arr = new int[4];
        int temp = n;
        int i = 0;
        if (n < 10000) {
            while (n > 0) {

                arr[i] = n % 10;
                i++;
                n = n / 10;

            }
            checking_the_inputs(arr, i, ones, tens, hundreds, thousand, temp, eleventotwenty);
        }
        if (n == 10000) {
            System.out.println("Ten thousand");
        }
        if (n > 10000) {
            NumbersGreaterThanfourdigit(n, i, ones, tens, hundreds, thousand, temp, eleventotwenty);
        }

    }

    static void checking_the_inputs(int[] arr, int i, String[] ones, String[] tens, String[] hundreds,
            String[] thousand, int temp, String[] eleventotwenty) {
        if (i == 0) {
            System.out.println("zero");
        }
        if (i == 1) {
            System.out.println(ones[temp]);

        }
        if (temp == 100) {
            System.out.println("Hundred");
        }

        if (i == 2 && arr[arr.length - 3] == 1) {
            System.out.println(eleventotwenty[arr[arr.length - 4]]);

        }
        if (i == 2 && arr[arr.length - 3] != 1 && temp != 100) {

            System.out.println(tens[arr[arr.length - 3]] + " " + ones[arr[0]]);

        }
        if (i == 3 && (temp != 100) && arr[arr.length - 3] != 1) {
            System.out.println(ones[arr[arr.length - 2]] + " " + hundreds[0] + " " + tens[arr[arr.length - 3]] + " "
                    + ones[arr[arr.length - 4]]);

        }
        if (i == 3 && (temp != 100) && arr[arr.length - 3] == 1) {
            System.out
                    .println(ones[arr[arr.length - 2]] + " " + hundreds[0] + " " + eleventotwenty[arr[arr.length - 4]]);

        }
        if (i == 4 && temp == 1000) {
            System.out.println("Thousand");
        }
        if (i == 4 && (temp != 1000) && (arr[arr.length - 3] != 1)) {
            System.out.println(ones[arr[arr.length - 1]] + " " + thousand[0] + " " + ones[arr[arr.length - 2]] + " "
                    + hundreds[0] + " " + tens[arr[arr.length - 3]] + " " + ones[arr[arr.length - 4]]);

        }
        if (i == 4 && (temp != 1000) && (arr[arr.length - 3] == 1)) {
            System.out.println(ones[arr[arr.length - 1]] + " " + thousand[0] + " " + ones[arr[arr.length - 2]] + " "
                    + hundreds[0] + " " + " " + eleventotwenty[arr[arr.length - 4]]);
        }

    }

    static void NumbersGreaterThanfourdigit(int n, int i, String[] ones, String[] tens, String[] hundreds,
            String[] thousand, int temp, String[] eleventotwenty) {
        int tempforbignum = temp;
        int[] bigarr = new int[6];
        int k = 0;
        while (temp != 0) {
            bigarr[k] = temp % 10;
            k++;
            temp = temp / 10;

        }
        gettingtextfromnumber(bigarr, tempforbignum, k, ones, tens, thousand, eleventotwenty, hundreds);

    }

    static void gettingtextfromnumber(int[] bigarr, int tempforbignum, int k, String[] ones, String[] tens,
            String[] thousand, String[] eleventotwenty, String[] hundrers) {

        if (k == 5 && bigarr[bigarr.length - 5] != 1 && bigarr[bigarr.length - 3] != 0 && bigarr[bigarr.length - 4] != 0
                && bigarr[bigarr.length - 5] != 0 && bigarr[bigarr.length - 6] != 0) {
            System.out.println(tens[bigarr[bigarr.length - 2]] + " " + ones[bigarr[bigarr.length - 3]] + " "
                    + thousand[0] + " " + ones[bigarr[bigarr.length - 4]] + " " + hundrers[0] + " "
                    + tens[bigarr[bigarr.length - 5]] + " " + ones[bigarr[bigarr.length - 6]]);

        }

        if (k == 5 && bigarr[bigarr.length - 5] == 1 && bigarr[bigarr.length - 6] != 0) {
            if (bigarr[bigarr.length - 4] == 0) {
                System.out.println(tens[bigarr[bigarr.length - 2]] + " " + ones[bigarr[bigarr.length - 3]] + " "
                        + thousand[0] + " " + ones[bigarr[bigarr.length - 4]] + " "
                        + eleventotwenty[bigarr[bigarr.length - 6]]);

            } else {
                System.out.println(tens[bigarr[bigarr.length - 2]] + " " + ones[bigarr[bigarr.length - 3]] + " "
                        + thousand[0] + " " + ones[bigarr[bigarr.length - 4]] + " " + hundrers[0] + " "
                        + eleventotwenty[bigarr[bigarr.length - 6]]);
            }

        }
        if (k == 5 && bigarr[bigarr.length - 3] == 0 && bigarr[bigarr.length - 4] == 0 && bigarr[bigarr.length - 5] == 0
                && bigarr[bigarr.length - 6] == 0) {
            System.out.println(tens[bigarr[bigarr.length - 2]] + " " + thousand[0]);
        }
        if (k == 5 && bigarr[bigarr.length - 2] != 0 && bigarr[bigarr.length - 3] != 0 && bigarr[bigarr.length - 4] == 0
                && bigarr[bigarr.length - 5] == 0 && bigarr[bigarr.length - 6] == 0) {
            System.out.println(
                    tens[bigarr[bigarr.length - 2]] + " " + ones[bigarr[bigarr.length - 3]] + " " + thousand[0]);
        }
        if (k == 5 && bigarr[bigarr.length - 3] == 0 && bigarr[bigarr.length - 5] != 1 && bigarr[bigarr.length - 4] != 0
                && bigarr[bigarr.length - 5] != 0
                &&
                bigarr[bigarr.length - 6] != 0) {
            System.out.println(tens[bigarr[bigarr.length - 2]] + " " + thousand[0] + " "
                    + ones[bigarr[bigarr.length - 4]] + " " + hundrers[0] + " " + tens[bigarr[bigarr.length - 5]] + " "
                    + ones[bigarr[bigarr.length - 6]]);
            System.out.println("hi0");
        }
        if (k == 5 && bigarr[bigarr.length - 4] == 0 && bigarr[bigarr.length - 5] != 1 && bigarr[bigarr.length - 6] != 0
                && bigarr[bigarr.length - 5] != 0) {
            System.out.println(tens[bigarr[bigarr.length - 2]] + " " + ones[bigarr[bigarr.length - 3]] + " "
                    + thousand[0] + " " + tens[bigarr[bigarr.length - 5]] + " " + ones[bigarr[bigarr.length - 6]]);
            System.out.println("hi1");
        }
        if (k == 5 && bigarr[bigarr.length - 5] == 0 && bigarr[bigarr.length - 4] != 0
                && bigarr[bigarr.length - 6] != 0) {
            System.out.println(tens[bigarr[bigarr.length - 2]] + " " + ones[bigarr[bigarr.length - 3]] + " "
                    + thousand[0] + " " + ones[bigarr[bigarr.length - 4]] + " " + hundrers[0] + " "
                    + ones[bigarr[bigarr.length - 6]]);
            System.out.println("hi2");

        }
        if (k == 5 && bigarr[bigarr.length - 6] == 0 && bigarr[bigarr.length - 4] != 0
                && bigarr[bigarr.length - 5] != 0) {
            System.out.println(tens[bigarr[bigarr.length - 2]] + " " + ones[bigarr[bigarr.length - 3]] + " "
                    + thousand[0] + " " + ones[bigarr[bigarr.length - 4]] + " " + hundrers[0] + " "
                    + tens[bigarr[bigarr.length - 5]]);
            System.out.println("hi3");

        }

     
        if (k == 5 && bigarr[bigarr.length - 4] == 0 || bigarr[bigarr.length - 5] == 0 || bigarr[bigarr.length - 2] == 0
                || bigarr[bigarr.length - 3] == 0 || bigarr[bigarr.length - 6] == 0) {
            if (bigarr[bigarr.length - 4] == 0 && bigarr[bigarr.length - 6] == 0 && bigarr[bigarr.length - 5] != 0
                    && bigarr[bigarr.length - 3] != 0) {
                System.out.println(tens[bigarr[bigarr.length - 2]] + " " + ones[bigarr[bigarr.length - 3]] + " "
                        + thousand[0] + " " + tens[bigarr[bigarr.length - 5]]);
                System.out.println("test1");

            }
            if (bigarr[bigarr.length - 3] == 0 && bigarr[bigarr.length - 4] == 0 && bigarr[bigarr.length - 6] == 0
                    && bigarr[bigarr.length - 5] != 0) {
                System.out.println(
                        tens[bigarr[bigarr.length - 2]] + " " + thousand[0] + " " + tens[bigarr[bigarr.length - 5]]);
                System.out.println("test2");
            }
            if (bigarr[bigarr.length - 5] == 0 && bigarr[bigarr.length - 6] == 0 && bigarr[bigarr.length - 4] != 0
                    && bigarr[bigarr.length - 3] != 0 && bigarr[bigarr.length - 2] != 0) {
                System.out.println(tens[bigarr[bigarr.length - 2]] + " " + ones[bigarr[bigarr.length - 3]] + " "
                        + thousand[0] + " " + ones[bigarr[bigarr.length - 4]] + " " + hundrers[0]);
                System.out.println("test3");
            }

        }

    }

}
