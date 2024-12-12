package logica;

public class Libro {
//codigo ISBN, título, autor, género, número de páginas.  
    
    String isbn;
    String titulo;
    String autor;
    String genero;
    int paginas;

    public Libro() {
    }

    public Libro(String isbn, String titulo, String autor, String genero, int paginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.paginas = paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Libros{" + "isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero + ", paginas=" + paginas + '}';
    }
    
    
    
    
}
