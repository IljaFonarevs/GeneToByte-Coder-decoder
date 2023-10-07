
// Ilja Fonarevs 221RDB217 3.grupa
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;

class Main {
  public static void main(String[] args) {
    HashMap<Character, Byte> conversion = createHashMap();
    Scanner sc = new Scanner(System.in);
    String command = "";
    while (!command.equals("exit")) {
      System.out.println("Enter command: ");
      command = sc.nextLine();
      String[] command_spec = command.split(" ");
      if (command_spec[0].equals("decomp")) {
        decomp(command, conversion);
      } else if (command_spec[0].equals("comp")) {
        comp(command, conversion);
      } else if (command_spec[0].equals("about")) {
        about();
      } else {
        System.out.println("wrong command format");
      }
    }
    sc.close();
  }

  static void about() {
    System.out.println("Ilja Fonarevs 3.grupa 221RDB217");
  }

  static void comp(String str, HashMap<Character, Byte> conversion) {
    char[] com = str.toCharArray();
    if (com.length - 5 < 0) {
      System.out.println("wrong command format");
      return;
    }
    char[] genes = new char[com.length - 5];
    

    for (int i = 5; i < com.length; i++) {
      genes[i - 5] = com[i];
      if (!((com[i] == 'A') || (com[i] == 'C') || (com[i] == 'G') || (com[i] == 'T'))) {
        System.out.println("wrong command format");
        return;
      }
    }
    byte[] converted_genes = new byte[3];

    converted_genes[0] = (byte) genes.length;
    converted_genes[1] += conversion.get(genes[0]);
    converted_genes[2] = 0;

    for (int i = 1; i < genes.length; i++) {
      if (i < 4) {
        converted_genes[1] <<= 2;
        converted_genes[1] += conversion.get(genes[i]);

        
      } else if (i < genes.length) {
        converted_genes[2] += conversion.get(genes[i]);

        converted_genes[2] <<= 2;
        System.out.println(converted_genes[2]);
        
      }
    }
    for (int i = 0; i < 7 - genes.length; i++) {
      converted_genes[2] <<= 2;
    }
  
    for (byte b : converted_genes) {
      String st = String.format("%2X", b);
      st = st.strip();
      System.out.print(st + " ");
    }

  }

  static void decomp(String str, HashMap<Character, Byte> conversion) {
    String[] splited = str.split(" ");
    if (splited.length - 2 < 0) {
      System.out.println("wrong command format");
      return;
    }
    int[] decNumb = new int[splited.length - 2];
    for (int i = 0; i < decNumb.length; i++) {
      decNumb[i] = Integer.parseInt(splited[i + 2]);
      byte b = (byte) decNumb[i];
      String st = String.format("%2X", b);
      System.out.print(st + " ");
      if (!(decNumb[i] > -128 && decNumb[i] < 127) || Integer.parseInt(splited[1]) != decNumb.length)
        System.out.println("wrong command format");
    }
    System.out.println();
    byte[] converted_genes = new byte[decNumb.length - 1];
    for (int i = 0; i < converted_genes.length; i++) {
      converted_genes[i] += (byte) decNumb[i + 1];

    }
    byte mask_C = 1, mask_G = 2, mask_T = 3;
    mask_C <<= 6;
    mask_G <<= 6;
    mask_T <<= 6;
    LinkedList<Character> DNA = new LinkedList<>();
    for (int i = 0; i < converted_genes.length; i++) {

      for (int j = 0; j < 4; j++) {

        if ((converted_genes[i] & mask_T) == mask_T) {
          DNA.add('T');
        } else if ((converted_genes[i] & mask_G) == mask_G) {
          DNA.add('G');
        } else if ((converted_genes[i] & mask_C) == mask_C) {
          DNA.add('C');
        } else {
          DNA.add('A');
        }
        converted_genes[i] <<= 2;
      }
    }
    if (Integer.parseInt(splited[2]) < DNA.size()) {
      for (int i = 0; i < DNA.size() - Integer.parseInt(splited[2]); i++)
        DNA.removeLast();
    }
    for (int i = 0; i < DNA.size(); i++)
      System.out.print(DNA.get(i));
    System.out.println();

  }

  static HashMap<Character, Byte> createHashMap() {
    HashMap<Character, Byte> conversion = new HashMap<>();

    int value = 0;
    conversion.put('A', (byte) value);

    value = 1;
    conversion.put('C', (byte) value);

    value = 2;
    conversion.put('G', (byte) value);

    value = 3;
    conversion.put('T', (byte) value);

    return conversion;
  }
}