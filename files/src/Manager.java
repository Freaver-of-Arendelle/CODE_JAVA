public class Manager extends Employee{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Employee secretary;
    
    public Manager(String name, double salary) {
        super(name, salary);
        //TODO Auto-generated constructor stub
    }

    public Employee getSecretary() {
        return secretary;
    }

    public void setSecretary(Employee secretary) {
        this.secretary = secretary;
    }

    
}
