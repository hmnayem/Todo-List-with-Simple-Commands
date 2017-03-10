package cmtd;

import java.util.*;

public class TodoManage {

    private List<Todo> todoList;

    public TodoManage() {

        todoList = new LinkedList<>();

    }

    private Todo todoObj(String title, String description, Date expDate) {

        Date dt = new Date();
        Todo td = new Todo(title, description, dt, expDate);

        return td;
    }

    public void addTodo(String title, String description, Date expDate) {

        Todo td = todoObj(title, description, expDate);

        todoList.add(td);

        Collections.sort(todoList);

    }

    public boolean removeTodo(String title) {

        int index = getIndex(title);

        if (index >= 0 && index < todoList.size()) {

            todoList.remove(index);
            return true;
        }

        return false;
    }

    public int getIndex(String title) {

        int index = -1;

        for (Todo td : todoList) {

            if (td.getTitle().equals(title)) {
                return index+1;
            }
            else
                index++;
        }

        return -1;
    }

    public Todo getTodo(int from) {

        if (from < 0 && from > todoList.size()) {

            throw new IndexOutOfBoundsException("Invalid Index");

        }

        return todoList.get(from);

    }

    public int getSize() {
        return todoList.size();
    }

}





















