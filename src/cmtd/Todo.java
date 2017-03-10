package cmtd;

import java.util.Date;

public class Todo implements Comparable <Todo>{

    private String title;
    private String description;
    private Date createDate;
    private Date expireDate;

    public Todo(String title, String description, Date createDate, Date expireDate) {
        this.title = title;
        this.description = description;
        this.createDate = createDate;
        this.expireDate = expireDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%10s%-100s\n", " ", getTitle()));
        sb.append(String.format("%-15s%-35s%-15s%-35s\n", "Created On : ", getCreateDate().toString(), "Expired On : ", getExpireDate().toString()));
        sb.append(String.format("\n%-15s\n%-500s\n", "Description : ", getDescription()));

        return sb.toString();
    }

    @Override
    public int compareTo(Todo td) {

        if (!(td instanceof Todo)) {
            throw new ClassCastException("Need Todo Class");
        }
        if (td.expireDate.compareTo(this.expireDate) == -1) {
            return 1;
        } else if (td.expireDate.compareTo(this.expireDate) == 1) {
            return -1;
        }

        return 0;
    }
}
