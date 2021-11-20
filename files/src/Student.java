public class Student {
    String name;
    int number;
    int score;
    public Student(String name, int number, int score) {
        this.name = name;
        this.number = number;
        this.score = score;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", number=" + number + ", score=" + score + "]";
    }

    
    
    
}
