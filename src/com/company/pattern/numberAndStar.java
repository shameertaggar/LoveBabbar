package com.company.pattern;

public class numberAndStar {
    public static void main(String[] args) {
        int n = 8;
        int num = 0;
        int a = 0, a2 = 0;
        for (int i = 0; i<n ; i++){

                for (int j = 0; j<(2*i)+1 ; j++){
                    if (j%2 == 0){
                        num = num+1;
                        System.out.print(num+ " ");
                        if (i == n-2){
                            a = num;
                        }
                        if (i == n-3){
                            a2 = num;
                        }
                    }else{
                        System.out.print("* ");
                    }




                }
            System.out.println();
        }

        int num2 = 0;
        int num3 = num;

        int d = a2-a;
        for (int q = 0; q<n; q++){
            num2 = a+(q-1+1)*(d) +(((q-1+1)*(q-2+1)/2)*1);
            int k = n - q;
             num3 = num2;
             for (int w = 2*k-1; w > 0; w--){
                  if (w%2 == 1){
                      num3 = num3 + 1;
                      System.out.print(num3 + " ");
                  }else {
                      System.out.print("* ");
                  }
              }



            System.out.println();
        }

    }
}
