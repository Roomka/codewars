package com.roman.procopenco.codewars;

public class LongestCommonSubsequence {
  // Function to find the length of the longest common subsequence of substring
  // `X[0…m-1]` and `Y[0…n-1]`
  public static String lcs(String X, String Y)
  {
    int m = X.length(), n = Y.length();

    // lookup table stores solution to already computed subproblems,
    // i.e., `T[i][j]` stores the length of LCS of substring
    // `X[0…i-1]` and `Y[0…j-1]`
    int[][] T = new int[m + 1][n + 1];

    // fill the lookup table in a bottom-up manner
    for (int i = 1; i <= m; i++)
    {
      for (int j = 1; j <= n; j++)
      {
        // if the current character of `X` and `Y` matches
        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
          T[i][j] = T[i - 1][j - 1] + 1;
        }
        // otherwise, if the current character of `X` and `Y` don't match
        else {
          T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
        }
      }
    }

      // Following code is used to print LCS
      int index = T[m][n];
      int temp = index;

      // Create a character array to store the lcs string
      char[] lcs = new char[index+1];
      lcs[index] = '\u0000'; // Set the terminating character

      // Start from the right-most-bottom-most corner and
      // one by one store characters in lcs[]
      int i = m;
      int j = n;
      while (i > 0 && j > 0)
      {
        // If current character in X[] and Y are same, then
        // current character is part of LCS
        if (X.charAt(i-1) == Y.charAt(j-1))
        {
          // Put current character in result
          lcs[index-1] = X.charAt(i-1);

          // reduce values of i, j and index
          i--;
          j--;
          index--;
        }

        // If not same, then find the larger of two and
        // go in the direction of larger value
        else if (T[i-1][j] > T[i][j-1])
          i--;
        else
          j--;
      }

      // Print the lcs
      System.out.print("LCS of "+X+" and "+Y+" is ");

      StringBuilder result = new StringBuilder();
      for(int k=0;k<=temp;k++){
        if (lcs[k] != '\u0000') {
          result.append(lcs[k]);
        }

      }

      return result.length() == 0 ? "" : result.toString();
    }
}
