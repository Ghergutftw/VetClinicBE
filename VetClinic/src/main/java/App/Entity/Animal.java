package App.Entity;

import javax.persistence.*;
@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private int id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "animal_type")
    private String animalType;

    @Column(name = "specie")
    private String specie;

    @Column(name = "age")
    private int age;

    @Column(name = "weight")
    private double weight;


    public Animal(int id, String nickname, String animalType, String specie, int age, double weight) {
        this.id = id;
        this.nickname = nickname;
        this.animalType = animalType;
        this.specie = specie;
        this.age = age;
        this.weight = weight;
    }

    public Animal() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", animalType='" + animalType + '\'' +
                ", specie='" + specie + '\'' +
                ", age=" + age +
                ", weight=" + weight + '\'' +
                '}';
    }
}
