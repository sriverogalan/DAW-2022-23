package domini;

public class Pelicula {
    private int id;
    private String titol;
    private String director;
    private int any;
    private String genero;

    public Pelicula() {
    }

    public Pelicula(int id) {
        this.id = id;
    }

    public Pelicula(int id, String titol, String director, int any, String genero) {
        this.id = id;
        this.titol = titol;
        this.director = director;
        this.any = any;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titol='" + titol + '\'' +
                ", director='" + director + '\'' +
                ", any=" + any +
                ", genero='" + genero + '\'' +
                '}';
    }
}
