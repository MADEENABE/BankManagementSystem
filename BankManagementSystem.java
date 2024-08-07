s

import java.util.Scanner;

class BankManagementSystem {

  private int total;
  private String id;

  class Person {

    String name, ID, address;
    int contact, cash;
  }

  private Person[] persons = new Person[100];

  public BankManagementSystem() {
    total = 0;
  }

  public void choice() {
    char ch;

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\n\nPRESS..!!");
      System.out.println("1. Create new account");
      System.out.println("2. View customers list");
      System.out.println("3. Update information of existing account");
      System.out.println("4. Check the details of an existing account");
      System.out.println("5. For transactions");
      System.out.println("6. Remove existing account");
      System.out.println("7. Exit");

      ch = scanner.next().charAt(0);

      switch (ch) {
        case '1':
          perData();
          break;
        case '2':
          if (total == 0) {
            System.out.println("No data is entered");
          } else {
            show();
          }
          break;
        case '3':
          if (total == 0) System.out.println(
            "No data is entered"
          ); else update();
          break;
        case '4':
          if (total == 0) System.out.println(
            "No data is entered"
          ); else search();
          break;
        case '5':
          if (total == 0) System.out.println(
            "No data is entered"
          ); else transactions();
          break;
        case '6':
          if (total == 0) System.out.println("No data is entered"); else del();
          break;
        case '7':
          System.exit(0);
          break;
        default:
          System.out.println("Invalid input");
          break;
      }
    }
  }

  public void perData() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter data of person " + (total + 1));
    persons[total] = new Person();

    System.out.print("Enter name: ");
    persons[total].name = scanner.next();

    System.out.print("ID: ");
    persons[total].ID = scanner.next();

    System.out.print("Address: ");
    persons[total].address = scanner.next();

    System.out.print("Contact: ");
    persons[total].contact = scanner.nextInt();

    System.out.print("Total Cash: ");
    persons[total].cash = scanner.nextInt();

    total++;
  }

  public void show() {
    for (int i = 0; i < total; i++) {
      System.out.println("Data of person " + (i + 1));
      System.out.println("Name: " + persons[i].name);
      System.out.println("ID: " + persons[i].ID);
      System.out.println("Address: " + persons[i].address);
      System.out.println("Contact: " + persons[i].contact);
      System.out.println("Cash: " + persons[i].cash);
    }
  }

  public void update() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter id of person whose data you want to update");
    id = scanner.next();

    for (int i = 0; i < total; i++) {
      if (id.equals(persons[i].ID)) {
        System.out.println("Previous data");
        System.out.println("Data of person " + (i + 1));
        System.out.println("Name: " + persons[i].name);
        System.out.println("ID: " + persons[i].ID);
        System.out.println("Address: " + persons[i].address);
        System.out.println("Contact: " + persons[i].contact);
        System.out.println("Cash: " + persons[i].cash);

        System.out.println("\nEnter new data");
        System.out.print("Enter name: ");
        persons[i].name = scanner.next();

        System.out.print("ID: ");
        persons[i].ID = scanner.next();

        System.out.print("Address: ");
        persons[i].address = scanner.next();

        System.out.print("Contact: ");
        persons[i].contact = scanner.nextInt();

        System.out.print("Total Cash: ");
        persons[i].cash = scanner.nextInt();

        break;
      }

      if (i == total - 1) {
        System.out.println("No such record found");
      }
    }
  }

  public void search() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter id of person whose data you want to search");
    id = scanner.next();

    for (int i = 0; i < total; i++) {
      if (id.equals(persons[i].ID)) {
        System.out.println("Name: " + persons[i].name);
        System.out.println("ID: " + persons[i].ID);
        System.out.println("Address: " + persons[i].address);
        System.out.println("Contact: " + persons[i].contact);
        System.out.println("Cash: " + persons[i].cash);
        break;
      }

      if (i == total - 1) {
        System.out.println("No such record found");
      }
    }
  }

  public void transactions() {
    int cash;
    char ch;

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter id of person whose data you want to transact");
    id = scanner.next();

    for (int i = 0; i < total; i++) {
      if (id.equals(persons[i].ID)) {
        System.out.println("Name: " + persons[i].name);
        System.out.println("Address: " + persons[i].address);
        System.out.println("Contact: " + persons[i].contact);
        System.out.println("\nExisting Cash " + persons[i].cash);
        System.out.println("Press 1 to deposit");
        System.out.println("Press 2 to withdraw");

        ch = scanner.next().charAt(0);

        switch (ch) {
          case '1':
            System.out.println("How much cash you want to deposit?");
            cash = scanner.nextInt();
            persons[i].cash += cash;
            System.out.println("Your new cash is " + persons[i].cash);
            break;
          case '2':
            int withdrawAmount;
            do {
              System.out.println("How much cash you want to withdraw?");
              withdrawAmount = scanner.nextInt();
              if (withdrawAmount > persons[i].cash) {
                System.out.println(
                  "Your existing cash is just " + persons[i].cash
                );
              }
            } while (withdrawAmount > persons[i].cash);
            persons[i].cash -= withdrawAmount;
            System.out.println("Your new cash is " + persons[i].cash);
            break;
          default:
            System.out.println("Invalid input");
            break;
        }
        break;
      }

      if (i == total - 1) {
        System.out.println("No such record found");
      }
    }
  }

  public void del() {
    char ch;

    Scanner scanner = new Scanner(System.in);

    System.out.println("Press 1 to remove specific record");
    System.out.println("Press 2 to remove full record");

    ch = scanner.next().charAt(0);

    switch (ch) {
      case '1':
        System.out.println("Enter id of person whose data you want to remove");
        id = scanner.next();

        for (int i = 0; i < total; i++) {
          if (id.equals(persons[i].ID)) {
            for (int j = i; j < total; j++) {
              persons[j].name = persons[j + 1].name;
              persons[j].ID = persons[j + 1].ID;
              persons[j].address = persons[j + 1].address;
              persons[j].contact = persons[j + 1].contact;
              persons[j].cash = persons[j + 1].cash;
              total--;
              System.out.println("Your required data is deleted");
              break;
            }
          }

          if (i == total - 1) {
            System.out.println("No such record found");
          }
        }
        break;
      case '2':
        total = 0;
        System.out.println("All records are deleted");
        break;
      default:
        System.out.println("Invalid Input");
        break;
    }
  }

  public static void main(String[] args) {
    BankManagementSystem b = new BankManagementSystem();
    b.choice();
  }
}
