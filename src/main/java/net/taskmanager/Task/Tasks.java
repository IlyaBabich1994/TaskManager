package net.taskmanager.Task;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name = "tasktable")
public class Tasks {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "start")
    private Date start;

    @Column(name = "end")
    private Date end;

    @Column(name = "status")
    private String status;

    @Column(name = "target")
    private String target;

    @Column(name = "comment")
    private String comment;

    public Tasks() {
        //this.start = LocalDate.now();
        this.target = "Relax";
        this.comment = "";
        this.status = "Undefined";
    }

    public Tasks(String target, String comment, String status) {
        //this.start = start;
        this.target = target;
        this.comment = comment;
        this.status = status;
    }

    public Date getStart() {
        return this.start;
    }

    public void setStart(Date start) {
        if((this.end != null && start.after(this.end)) || this.end == null)
            this.start = start;
        else
            this.start = end;
            }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date start, Integer day) {
        this.end.setDate(day);
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
