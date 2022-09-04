public class Task2Recurs {
    static int solve(int start, int end, int add, int mult) {

        if (end <= start)
            return 1;
        else {
            if (end % mult == 0) {
                return solve(start, end - add, add, mult) + solve(start, end / mult, add, mult);
            } else {
                return solve(start, end - add, add, mult);
            }
        }
    } 
    public static void main(String[] args) {
        int start =3;
        int end = 10;
        int add =1;
        int mult = 2;
        System.out.println(String.format("Количество вариантов превращения числа %d в число %d = %d, "
        , start, end, solve(start, end, add, mult)));
    }
}
