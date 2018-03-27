package main.t04.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Ekaterina Semenova on 23.03.2018.
 */
public class Film implements Serializable {
    private String name;
    private int year;
  //  private Map.Entry<String, Integer> filmEntry;
    private Set<Actor> actorSet = new HashSet<>();

    public Film(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public boolean addActor(Actor actor) {
        return actorSet.add(actor);
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public Set<Actor> getActorSet() {
        return actorSet;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if(object instanceof Film){
            Film newObject = (Film)object;
            if(this.name.compareToIgnoreCase(newObject.getName()) !=0){
                return false;
            }
            if (this.year != newObject.getYear()){
                return false;
            }
            for (Actor actor:actorSet) {
                if(newObject.getActorSet().size() != actorSet.size()){
                    return false;
                }
                if(!newObject.getActorSet().contains(actor)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        int prime = 17;
        int result = 1;
        result = prime * (result + name.hashCode());
        result = prime * (result + year);
        result = prime * (result + actorSet.hashCode());
        return result;
    }
}
