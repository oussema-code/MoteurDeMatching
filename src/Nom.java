
public class Nom {
    private String name;
    private String id;
    public Nom(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public String getNom() {
        return name;
    }
    public String getId() {
        return id;
    }
    public void setNom(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String toString() {
        return "Nom{id=" + id + ", nom='" + name + "'}";
    }
    
}
