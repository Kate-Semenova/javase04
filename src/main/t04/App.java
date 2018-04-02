package main.t04;

import main.t04.model.Actor;
import main.t04.model.Film;
import main.t04.model.FilmCollection;

import java.io.File;
import java.util.*;

/**
 * Created by Ekaterina Semenova on 23.03.2018.
 */
public class App {
    private final static int EXIT = 42;
    private final static File collectionDirectory = new File("src\\main\\t04\\collection");

    public static void main(String[] args) {
        FilmCollection filmCollection2 = new FilmCollection();


        List<String> collections = new ArrayList<>();
        for (File name : filmCollection2.COLLECTION_DIRECTORY.listFiles()) {
            collections.add(name.getName().substring(0, name.getName().length() - 4));
        }
        System.out.println("Choose collection");

        for (int i = 0; i < collections.size(); i++) {
            System.out.println((i + 1) + " - " + collections.get(i));
        }

        System.out.println(collections.size() + 1 + " - create new collection");
        System.out.println("Type number of collection to deserialize it: ");
        int choosingCollection = inputMismatchExceptionCatcher();
        while (choosingCollection > collections.size() + 1) {
            while (choosingCollection == 666) {
                System.out.println("Type a number");
                choosingCollection = inputMismatchExceptionCatcher();
            }
            System.out.println("Type correct number");
            choosingCollection = inputMismatchExceptionCatcher();
        }
        if (choosingCollection != collections.size() + 1) {
            filmCollection2.deserializeFromFile(filmCollection2.COLLECTION_DIRECTORY.listFiles()[choosingCollection - 1]);
            System.out.println("Deserialized successfully");
            System.out.println(filmCollection2);
        }

        System.out.println("-----------------------------");
        int number = EXIT;
        while (number == EXIT) {
            System.out.println("1 - show films");
            System.out.println("2 - add film");
            System.out.println("3 - add actor");
            System.out.println("4 - delete film");
            System.out.print("Type the number to choose the option: ");
            Scanner in = new Scanner(System.in);
            int choosing = inputMismatchExceptionCatcher();
            switch (choosing) {
                case 1: {
                    System.out.println("===FILM COLLECTION===");
                    System.out.println(filmCollection2);
                    break;
                }
                case 2: {
                    System.out.println("===ADDING A MOVIE TO THE COLLECTION===");
                    System.out.println("Type name: ");
                    Scanner in2 = new Scanner(System.in);
                    String name = in2.nextLine();
                    System.out.println("Type year: ");
                    int year = in.nextInt();
                    Film film = new Film(name, year);
                    int j = 0;
                    while (j == 0) {
                        System.out.println("Type actors name ");
                        String actorsName = in.next();
                        System.out.println("Type actors Surname");
                        String actorsSurname = in.next();
                        film.addActor(new Actor(actorsName, actorsSurname));
                        System.out.println("Type 0 to continue adding actors");
                        j = in.nextInt();
                    }
                    filmCollection2.addFilm(film);
                    break;
                }
                case 3: {
                    System.out.println("===ADDING AN ACTOR TO THE MOVIE===");

                    int i = 0;
                    List<Film> films = filmCollection2.getArrayFilms();
                    for (Film film : films) {
                        i++;
                        System.out.println(i + " - " + film.getName());
                    }
                    System.out.println("Type the number you wanna change: ");
                    Film film = null;
                    for (i = in.nextInt(); i > films.size(); i = in.nextInt()) {
                        System.out.println("Type the number you wanna change: ");
                    }
                    film = films.get(i - 1);

                    System.out.println("Type the name of an actor:");
                    String actorsName = in.next();
                    System.out.println("Type actors Surname");
                    String actorsSurname = in.next();
                    film.addActor(new Actor(actorsName, actorsSurname));
                    break;
                }

                case 4: {
                    System.out.println("===DELETING THE MOVIE FROM THE COLLECTION===");
                    int i = 0;
                    List<Film> films = filmCollection2.getArrayFilms();
                    if (films.isEmpty()) {
                        System.out.println("The collection is empty");
                        System.out.println("=======================");
                        continue;
                    }
                    for (Film film : films) {
                        i++;
                        System.out.println(i + " - " + film.getName());
                    }
                    System.out.println("Type the number you wanna delete: ");
                    Film film = null;
                    for (i = in.nextInt(); i > films.size(); i = in.nextInt()) {
                        System.out.println("Type the number you wanna delete: ");
                    }
                    film = films.get(i - 1);
                    if (filmCollection2.deleteFilm(film)) {
                        System.out.println("Film is deleted");
                    } else {
                        System.out.println("Cant delete");
                    }
                    break;
                }
                default: {
                    System.out.println("Please, type a number");
                    continue;
                }

            }
            System.out.printf("Type %d to continue. Type any other to save and exit ", EXIT);
            number = in.nextInt();
        }
        if (choosingCollection == collections.size() + 1) {
            System.out.println("Type the name of new collection");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            filmCollection2.serialize(name);
        } else {
            filmCollection2.serialize(collections.get(choosingCollection - 1));
        }
    }

    public static int inputMismatchExceptionCatcher() {
        Scanner in = new Scanner(System.in);
        int integer;
        try {
            integer = in.nextInt();
        } catch (InputMismatchException exception) {
            return 666;
        }
        return integer;
    }


}
