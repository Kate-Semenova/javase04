package main.t04.model;

import java.io.Serializable;

/**
 * Created by Ekaterina Semenova on 23.03.2018.
 */
public class Actor implements Serializable {
    private String name;
    private String surname;

    public Actor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object instanceof Actor) {
            Actor newObject = (Actor) object;
            if (!this.surname.equals(newObject.name)) {
                return false;
            }
            if (this.surname.equals(newObject.surname)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        int prime = 17;
        int result = 1;
        result = prime * (result + name.hashCode());
        return prime * (result + surname.hashCode());

    }
}
