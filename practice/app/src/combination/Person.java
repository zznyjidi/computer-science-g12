package combination;

public class Person {
    public enum Job {
        Head, Employee
    }

    int pay;
    int score;
    Job job;

    public Person(int pay, Job job, int score) {
        this.pay = pay;
        this.job = job;
        this.score = score;
    }

    public double getEffectiveness() {
        return score / pay;
    }
}
