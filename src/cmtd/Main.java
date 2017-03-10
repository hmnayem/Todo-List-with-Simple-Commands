package cmtd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    Scanner sc;
    TodoManage todoManage;
    private boolean exitLoop = true;

    public Main() {
        sc = new Scanner(System.in);
        todoManage = new TodoManage();
    }

    public static void main(String[] args) throws ParseException {

        Main start = new Main();
        do {
            start.operate();

        } while (start.exitLoop);


    }


    private String[] getCommand() {

        System.out.print("TODO >> ");
        String[] commands = sc.nextLine().split(" ");

        return commands;
    }

    private void operate() {

        String [] commands = getCommand();

        if (commands.length == 0 || !commands[0].equals("todo")){
            System.out.println("Invalid Command");
            return;
        }

        if (commands.length >= 3 && commands[1].equals("add") && !commands[2].equals(null)) {

            String title = arrToString(commands);

            String [] com1 = getCommand();
            String [] com2 = getCommand();

            if (!com1[0].equals("todo") || !com2[0].equals("todo")) {
                System.out.println("Invalid Commands");
                return;
            }

            if (!com1[1].equals("description") || !com2[1].equals("expdate")) {
                System.out.println("Command Not Match");
                return;
            }

            String des = arrToString(com1);
            Date exp = strToDate((com2[2]+ " " + com2[3]));

            todoManage.addTodo(title, des, exp);

            return;
        }

        if (commands.length == 2 && commands[1].equals("show")) {

            for (int i=0; i<todoManage.getSize(); i++) {
                System.out.println(String.format("%-30s%-35s", todoManage.getTodo(i).getTitle(), todoManage.getTodo(i).getExpireDate()));
                System.out.println();
            }
            System.out.println();
            return;
        }

        if (commands.length == 3 && commands[1].equals("remove")) {
            boolean bb = todoManage.removeTodo(commands[2]);

            if (bb) {
                System.out.println("Removed");
            }
            else
                System.out.println("Not Removed");

            return;
        }

        if (commands.length == 2 && commands[1].equals("next")) {

            System.out.println(todoManage.getTodo(0));

            return;
        }

        if (commands.length == 2 && commands[1].equals("exit")) {
            exitLoop = false;
            return;

        }

        else {
            System.out.println("Command not found!");
            return;
        }
    }


    private String arrToString(String[] strings) {

        StringBuilder sb = new StringBuilder();

        for (int i=2; i<strings.length; i++) {
            sb.append(strings[i]);
            sb.append(" ");
        }

        return sb.toString();
    }

    private Date strToDate(String str) {

        SimpleDateFormat sm = new SimpleDateFormat("yyyyy-MM-dd hh:mm:ss");

        Date dt = null;
        try {
            dt = sm.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dt;
    }

}




















