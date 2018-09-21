package witali.tasks.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parts {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String type;
    private String model;
    private int count;
    private boolean need;

    public Parts() {
    }

    public Parts(String type, String model, int count, boolean need) {
        this.type = type;
        this.model = model;
        this.count = count;
        this.need = need;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String name) {
        this.model = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int inStock) {
        this.count = inStock;
    }

    public boolean isNeed() {
        return need;
    }

    public void setNeed(boolean need) {
        this.need = need;
    }
}