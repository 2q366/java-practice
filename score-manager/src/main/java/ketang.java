abstract class Animal{
    public abstract void say();
    public abstract String getAnimalName();
}
class Simulator{
    public void playSound(Animal animal){
        System.out.println(animal.getAnimalName());
        animal.say();
    }
}
class Dog extends Animal{
    @Override
    public void say(){
        System.out.println("汪汪叫");
    }
    @Override
    public String getAnimalName(){
        return "小狗";
    }
}
class Cat extends Animal{
    @Override
    public void say(){
        System.out.println("喵喵叫");
    }
    @Override
    public String getAnimalName(){
        return "小猫";
    }
}

public class ketang {
    public static void main(String[] args){
        Simulator si = new Simulator();
        Animal animal;
        animal= new Dog();
        si.playSound(animal);
        animal = new Cat();
        si.playSound(animal);
    }
}
