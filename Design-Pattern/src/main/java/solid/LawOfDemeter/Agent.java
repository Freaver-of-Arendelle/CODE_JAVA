package solid.LawOfDemeter;

/**
 * @author Freaver
 * @date 4/27/2021 19:24
 */
public class Agent {
    private Star star;
    private Fans fans;
    private Company company;

    public void setStar(Star star) {
        this.star = star;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void meeting() {
        System.out.println(star.getName() + "and fan: " + fans.getName());
    }

    public void business() {
        System.out.println(star.getName() + "and " + company.getName());
    }
}
