package main.t04.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ekaterina Semenova on 23.03.2018.
 */
public class FilmCollection implements Serializable {
    private List<Film> films = new ArrayList<>();

    public final static File COLLECTION_DIRECTORY = new File("src\\main\\t04\\collection");

    public FilmCollection() {
        super();
    }

    public boolean addFilm(Film film) {
        return films.add(film);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Film film : films) {
            stringBuilder.append("Name: ")
                    .append(film.getName())
                    .append(" (")
                    .append(film.getYear())
                    .append(") ")
                    .append("Main actors: ")
                    .append(film.getActorSet().toString())
                    .append("\n");
        }
        if (stringBuilder.toString().equals("")) {
            return "collection is empty";
        }

        return stringBuilder.toString();
    }

    public void serialize(String name) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(COLLECTION_DIRECTORY + "\\" + name + ".out");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream))

        {

            objectOutputStream.writeObject(this);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deserializeFromFile(File file) {

        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            FilmCollection filmCollection = (FilmCollection) objectInputStream.readObject();
            this.films = filmCollection.getArrayFilms();
            System.out.println("deserialized");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Film> getArrayFilms() {
        return films;
    }

    public Film getByName(String name) {
        for (Film film : films) {
            if (film.getName().compareToIgnoreCase(name) == 0) {
                return film;
            }
        }
        return null;
    }

    public boolean hasFilm(String name) {
        if (this.getByName(name) == null) {
            return false;
        }
        return true;
    }

    public boolean deleteFilm(Film film) {
        return film != null && films.remove(film);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object instanceof FilmCollection) {
            FilmCollection newObject = (FilmCollection) object;
            if (films.size() != newObject.getArrayFilms().size()) {
                return false;
            }
            for (Film film : newObject.getArrayFilms()) {
                if (!films.contains(film)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode(){
        int result = 1;
        for (Film film:films) {
            result += film.hashCode();
        }
        return result;
    }
}
