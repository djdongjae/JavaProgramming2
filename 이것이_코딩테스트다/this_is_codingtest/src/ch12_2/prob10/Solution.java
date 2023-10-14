package ch12_2.prob10;

public class Solution {
    public static int[][] rotateMatrixBy90Degree(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n - 1 - i] = a[i][j];
            }
        }
        return result;
    }

    public static boolean check(int[][] newLock) {
        int lockLength = newLock.length / 3;
        for (int i = lockLength; i < lockLength * 2; i++) {
            for (int j = lockLength; j < lockLength * 2; j++) {
                if (newLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        int[][] newLock = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[i + n][j + n] = lock[i][j];
            }
        }

        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotateMatrixBy90Degree(key);
            for (int i = 0; i < n * 2; i++) {
                for (int j = 0; j < n * 2; j++) {
                    for (int f = 0; f < m; f++) {
                        for (int k = 0; k < m; k++) {
                            newLock[i + f][j + k] += key[f][k];
                        }
                    }
                    if (check(newLock)) return true;
                    else {
                        for (int f = 0; f < m; f++) {
                            for (int k = 0; k < m; k++) {
                                newLock[i + f][j + k] -= key[f][k];
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
