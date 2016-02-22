public class Sort {
    public static void quicksort(String[] content, int left, int right) {
        String x, t;
        int i, j;

        i = left;
        j = right;
        x = content[(i + j) / 2];
        while (i <= j)
        {
            while (i < right && content[i].compareTo(x) < 0)
                i++;
            while (j > left && content[j].compareTo(x) > 0)
                j--;
            if (i <= j)
            {
                t = content[i];
                content[i] = content[j];
                content[j] = t;
                i++;
                j--;
            }
        }
        if (left < j)
            quicksort(content, left, j);
        if (i < right)
            quicksort(content, i, right);
    }
}
