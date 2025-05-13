
public class Nom {
    private String name;
    private String id;
    private final String nomOriginal;
    public Nom(String name, String id) {
        this.name = name;
        this.id = id;
        this.nomOriginal=name;
    }
    public String getNom() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getNomOriginal() {return nomOriginal;}
    public void setNom(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String toString() {
        return "Nom{id=" + id + ", nom='" + nomOriginal + "'}";
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nom nom = (Nom) o;
        return name.equalsIgnoreCase(nom.name);
    }
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }
}
