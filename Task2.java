// +На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть две команды
// - команда 1 (к1): увеличить в с раза, а умножается на c
// - команда 2 (к2): увеличить на d, к a прибавляется d
// написать программу, которая выдаёт набор команд, позволяющий число a превратить в число b
// или сообщить, что это невозможно
// Пример 1: а = 1, b = 7, c = 2, d = 1
// Показать набор команд для превращения числа а в число b
// Показать хотя бы один набор
// *Подумать над решением задачи 2 рекурсией

public class Task2 {

  static int solve(int start, int end, int add, int mult) {
    int[] ways = new int[end + 1];
    ways[start] = 1;

    for (int index = start + add; index <= end; index++) {

      if (index % mult == 0) {
        ways[index] = ways[index - add] + ways[index / mult];
      } else {
        ways[index] = ways[index - add];
      }
    }
    System.out.println(print(ways));
    if (ways[end] != 0) {
      System.out.println("Набор одного из вариантов команд:");
      System.out.println(instruction_set(ways, start, end, add, mult));
    }
      
    return ways[end];
  }

  static String instruction_set(int[] ways, int start, int end, int add, int mult) {
    StringBuffer instr_set = new StringBuffer();
    while (end >= start) {
      if (end == start) {
        instr_set=instr_set.replace(instr_set.length()-2,instr_set.length(),".");
        break;
      } else {
        if (end % mult == 0 && ways[end / 2] != 0 && end / mult >= start) {
          instr_set.insert(0, String.format("*%d, ",mult));
          end = end / mult;
        } else {
          if (ways[end - add] != 0 && end - add >= start) {
            instr_set.insert(0, String.format("+%d, ", add));
            end = end - add;
          }
        }
      }
    }
    return instr_set.toString();
  }

  static String print(int[] items) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < items.length; i++) {

      sb.append(String.format("(%d)%d ", i, items[i]));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    int start =3;
    int end = 10;
    int add =1;
    int mult = 2;
    System.out.println(String.format("Количество вариантов превращения числа %d в число %d = %d, "
    , start, end, solve(start, end, add, mult)));  }
}