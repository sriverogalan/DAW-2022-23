package Domini;

import java.util.Date;
public class Pelicula {
    // crear clase pelicula
    private String titulo;
    private String director;
    private String genero;
    private String sinopsis;
    private Date fechaEstreno;
    private String duracion;
    private String idioma;
    private String subtitulos;
    private String clasificacion;
    private String pais;

    public Pelicula(String titulo, String director, String genero, String sinopsis, Date fechaEstreno, String duracion, String idioma, String subtitulos, String clasificacion, String pais) {
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.fechaEstreno = fechaEstreno;
        this.duracion = duracion;
        this.idioma = idioma;
        this.subtitulos = subtitulos;
        this.clasificacion = clasificacion;
        this.pais = pais;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public Date getFechaEstreno() {
        return fechaEstreno;
    }
    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }
    public String getDuracion() {
        return duracion;
    }
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public String getSubtitulos() {
        return subtitulos;
    }
    public void setSubtitulos(String subtitulos) {
        this.subtitulos = subtitulos;
    }
    public String getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Pelicula [clasificacion=" + clasificacion + ", director=" + director + ", duracion=" + duracion + ", fechaEstreno=" + fechaEstreno + ", genero=" + genero + ", idioma=" + idioma + ", pais=" + pais + ", sinopsis=" + sinopsis + ", subtitulos=" + subtitulos + ", titulo=" + titulo + "]";
    }
}