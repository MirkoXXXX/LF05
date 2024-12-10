package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;

public class IO {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Gets a String from user input
     * @param message Text to print for prompt
     * @return Result of user input
     */
    public static String getString(String message) {
        while (true) {
            log(message);
            try {
                final String s = br.readLine();
                if (s != null) {
                    return s.trim();
                } else {
                    log("Kein Text erkannt, bitte versuchen sie es erneut.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Gets a bool from comparison with user input
     * @param message Text to print for prompt
     * @param comparison Text to compare to
     * @return Result of comparison
     */
    public static boolean getBool(String message, String comparison) {
        log(message);
        try {
            return br.readLine().trim().equalsIgnoreCase(comparison);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets a double from user input
     * @param message Text to print for prompt
     * @return Result of user input
     */
    public static double getDouble(String message) {
        while (true) {
            log(message);
            try {
                return Double.parseDouble(br.readLine().replace(",", ".").trim());
            } catch (NumberFormatException e) {
                log(e.getMessage() + ", Versuchen sie es erneut.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Gets an Integer from user input
     * @param message Text to print for prompt
     * @return Result of user input
     */
    public static int getInteger(String message) {
        while (true) {
            log(message);
            try {
                return Integer.parseInt(br.readLine().trim());
            } catch (NumberFormatException e) {
                log(e.getMessage() + ", Versuchen sie es erneut.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static long[] getLongArray(String message, Integer length) {
        while (true) {
            log(message);
            try {
                String[] sa = br.readLine().trim().split(",");
                long[] rt;
                if (length > 0)
                {rt = new long[length];
                } else
                { rt = new long[sa.length]; }
                for (int i = 0; i < rt.length; i++) {
                    rt[i] = Long.parseLong(sa[i].trim());
                }
                return rt;
            } catch (NumberFormatException e) {
                log(e.getMessage() + ", Versuchen sie es erneut.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int[] getIntArray(String message, Integer length) {
        while (true) {
            log(message);
            try {
                String[] sa = br.readLine().trim().split(",");
                int[] rt;
                if (length > 0)
                {rt = new int[length];
                } else
                { rt = new int[sa.length]; }
                for (int i = 0; i < rt.length; i++) {
                    rt[i] = Integer.parseInt(sa[i].trim());
                }
                return rt;
            } catch (NumberFormatException e) {
                log(e.getMessage() + ", Versuchen sie es erneut.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static double[] getDoubleArray(String message, Integer length) {
        while (true) {
            log(message);
            try {
                String[] sa = br.readLine().trim().split(",");
                double[] rt;
                if (length > 0)
                {rt = new double[length];
                } else
                { rt = new double[sa.length]; }
                for (int i = 0; i < rt.length; i++) {
                    rt[i] = Double.parseDouble(sa[i].trim());
                }
                return rt;
            } catch (NumberFormatException e) {
                log(e.getMessage() + ", Versuchen sie es erneut.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String[] getStringArray(String message, Integer length) {
        while (true) {
            log(message);
            try {
                String[] sa = br.readLine().trim().split(",");
                String[] rt;
                if (length > 0)
                {rt = new String[length];
                } else
                { rt = new String[sa.length]; }
                for (int i = 0; i < rt.length; i++) {
                    rt[i] = sa[i].trim();
                }
                return rt;
            } catch (NumberFormatException e) {
                log(e.getMessage() + ", Versuchen sie es erneut.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Returns a copy of values from a provided 2D int array
     * @param data Your original 2D int array
     * @return Returns your copied 2D data
     */
    public static int[][] copyInt2D(int[][] data) {
        return Arrays.stream(data)
                .map(int[]::clone)
                .toArray(int[][]::new);
    }

    /**
     * Returns a copy of values from a provided 2D double array
     * @param data Your original 2D double array
     * @return Returns your copied 2D data
     */
    public static double[][] copyDouble2D(double[][] data) {
        return Arrays.stream(data)
                .map(double[]::clone)
                .toArray(double[][]::new);
    }

    /**
     * Converts your Double into a formatted String
     * @param x Your Double
     * @param length The Amount of Digits after the dot
     * @return Returns your formatted Double as String
     */
    public static String df (Double x, Integer length) {
        DecimalFormat f = new DecimalFormat("#,##0."+"0".repeat(length));
        return f.format(x);
    }

    /**
     * Removes [,] and , from an array string for easier reading.
     * @param arrayString The String Form of the Array you want to format, usually acquired with Arrays.toString().
     * @return Returns your formatted Array as a string.
     */
    public static String unformatArr (String arrayString) {
        return arrayString
                .replace("]","")
                .replace(",","")
                .replace("[","")
                .replace("\n","").trim();
    }

    /**
     * Prints text into System console
     * @param message Text to print
     */
    public static void log(String message) {
        System.out.println(message);
    }
}
